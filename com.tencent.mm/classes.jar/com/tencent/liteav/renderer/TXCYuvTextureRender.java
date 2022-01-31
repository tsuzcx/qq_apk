package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class TXCYuvTextureRender
{
  private static final int BYTES_PER_FLOAT = 4;
  private static final int INVALID_TEXTURE_ID = -12345;
  private static final int POSITION_COMPONENT_COUNT = 2;
  private static final String TAG;
  private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
  private static final String mFragmentShaderCode = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D yTexture;\nuniform sampler2D uTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(yTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform   \n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor; \n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}\n";
  private static final String mVertexShaderCode = "uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {vec4 pos  = vec4(position, 0.0, 1.0);gl_Position = uMatrix * pos;textureCoordinate = (uTextureMatrix*vec4(inputTextureCoordinate, 0.0, 0.0)).xy;}";
  float[] bt601_fullrage_ffmpeg_matrix;
  float[] bt601_fullrange_ffmpeg_offset;
  float[] bt601_videorage_ffmpeg_matrix;
  float[] bt601_videorange_ffmpeg_offset;
  private final int def_InputType_YUVJ420;
  private int mConvertMatrixUniform;
  private int mConvertOffsetUniform;
  private int mFrameBufferID;
  private int mFrameBufferTextureID;
  private int mHeight;
  private short[] mIndices;
  private ShortBuffer mIndicesBuffer;
  private float[] mMVPMatrix;
  private boolean mNeedReLoadFrameBuffer;
  private int mPositionHandle;
  private int mProgram;
  private int mRawDataFrameType;
  private FloatBuffer mTextureBuffer;
  private float[] mTextureCoordinates;
  private int mTextureCoordinatesHandle;
  private int[] mTextureIds;
  private float[] mTextureMatrix;
  private int mTextureMatrixHandle;
  private int mTextureUnitHandle0;
  private int mTextureUnitHandle1;
  private FloatBuffer mVertexBuffer;
  private int mVertexMatrixHandle;
  private float[] mVerticesCoordinates;
  private int mVideoHeight;
  private int mVideoWidth;
  private int mWidth;
  private float[] mbt601_fullRange_matrix3;
  private float[] mbt601_offset_matrix;
  private float[] mbt601_videoRange_matrix3;
  private float[] mbt709_videoRange_matrix3;
  
  static
  {
    AppMethodBeat.i(67350);
    TAG = TXCYuvTextureRender.class.getSimpleName();
    b.f();
    AppMethodBeat.o(67350);
  }
  
  public TXCYuvTextureRender()
  {
    AppMethodBeat.i(67340);
    this.mMVPMatrix = new float[16];
    this.mTextureMatrix = new float[16];
    this.mConvertMatrixUniform = -1;
    this.mConvertOffsetUniform = -1;
    this.mNeedReLoadFrameBuffer = false;
    this.mFrameBufferTextureID = -12345;
    this.mFrameBufferID = -12345;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.def_InputType_YUVJ420 = 4;
    this.mRawDataFrameType = -1;
    this.mbt601_fullRange_matrix3 = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, -0.343F, 1.765F, 1.4F, -0.711F, 0.0F };
    this.mbt601_videoRange_matrix3 = new float[] { 1.164F, 1.164F, 1.164F, 0.0F, -0.392F, 2.017F, 1.596F, -0.813F, 0.0F };
    this.mbt601_offset_matrix = new float[] { 0.0F, -0.5F, -0.5F };
    this.mbt709_videoRange_matrix3 = new float[] { 1.164F, 1.164F, 1.164F, 0.0F, -0.213F, 2.112F, 1.793F, -0.533F, 0.0F };
    this.bt601_videorange_ffmpeg_offset = new float[] { -0.0627451F, -0.5019608F, -0.5019608F };
    this.bt601_videorage_ffmpeg_matrix = new float[] { 1.1644F, 1.1644F, 1.1644F, 0.0F, -0.3918F, 2.0172F, 1.596F, -0.813F, 0.0F };
    this.bt601_fullrange_ffmpeg_offset = new float[] { 0.0F, -0.5019608F, -0.5019608F };
    this.bt601_fullrage_ffmpeg_matrix = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, -0.3441F, 1.772F, 1.402F, -0.7141F, 0.0F };
    this.mTextureCoordinates = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.mIndices = new short[] { 0, 1, 2, 1, 3, 2 };
    this.mVerticesCoordinates = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.mTextureBuffer = ByteBuffer.allocateDirect(this.mTextureCoordinates.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTextureBuffer.put(this.mTextureCoordinates);
    this.mTextureBuffer.position(0);
    this.mVertexBuffer = ByteBuffer.allocateDirect(this.mVerticesCoordinates.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.put(this.mVerticesCoordinates);
    this.mVertexBuffer.position(0);
    this.mIndicesBuffer = ByteBuffer.allocateDirect(this.mIndices.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    this.mIndicesBuffer.put(this.mIndices);
    this.mIndicesBuffer.position(0);
    AppMethodBeat.o(67340);
  }
  
  private void destroyFrameBuffer()
  {
    AppMethodBeat.i(67345);
    if (this.mFrameBufferID != -12345)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.mFrameBufferID }, 0);
      this.mFrameBufferID = -12345;
    }
    if (this.mFrameBufferTextureID != -12345)
    {
      GLES20.glDeleteTextures(1, new int[] { this.mFrameBufferTextureID }, 0);
      this.mFrameBufferTextureID = -12345;
    }
    AppMethodBeat.o(67345);
  }
  
  private native void nativeLoadTexture(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  private void reloadFrameBuffer()
  {
    AppMethodBeat.i(67344);
    if (!this.mNeedReLoadFrameBuffer)
    {
      AppMethodBeat.o(67344);
      return;
    }
    TXCLog.d(TAG, "reloadFrameBuffer. size = " + this.mWidth + "*" + this.mHeight);
    destroyFrameBuffer();
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    GLES20.glGenTextures(1, arrayOfInt1, 0);
    GLES20.glGenFramebuffers(1, arrayOfInt2, 0);
    this.mFrameBufferTextureID = arrayOfInt1[0];
    this.mFrameBufferID = arrayOfInt2[0];
    TXCLog.d(TAG, "frameBuffer id = " + this.mFrameBufferID + ", texture id = " + this.mFrameBufferTextureID);
    GLES20.glBindTexture(3553, this.mFrameBufferTextureID);
    GLES20.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindFramebuffer(36160, this.mFrameBufferID);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextureID, 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    this.mNeedReLoadFrameBuffer = false;
    AppMethodBeat.o(67344);
  }
  
  public int checkError()
  {
    AppMethodBeat.i(67348);
    int i = GLES20.glGetError();
    if (i != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("gl error=".concat(String.valueOf(i)));
      AppMethodBeat.o(67348);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(67348);
    return i;
  }
  
  public void createTexture()
  {
    AppMethodBeat.i(67341);
    int i = GLES20.glCreateShader(35633);
    checkError();
    GLES20.glShaderSource(i, "uniform mat4 uMatrix;uniform mat4 uTextureMatrix;attribute vec2 position;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {vec4 pos  = vec4(position, 0.0, 1.0);gl_Position = uMatrix * pos;textureCoordinate = (uTextureMatrix*vec4(inputTextureCoordinate, 0.0, 0.0)).xy;}");
    checkError();
    GLES20.glCompileShader(i);
    checkError();
    int j = GLES20.glCreateShader(35632);
    checkError();
    GLES20.glShaderSource(j, "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D yTexture;\nuniform sampler2D uTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(yTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uTexture, vec2(textureCoordinate.x * 0.5, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform   \n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor; \n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}\n");
    checkError();
    GLES20.glCompileShader(j);
    this.mProgram = GLES20.glCreateProgram();
    checkError();
    GLES20.glAttachShader(this.mProgram, i);
    checkError();
    GLES20.glAttachShader(this.mProgram, j);
    checkError();
    GLES20.glLinkProgram(this.mProgram);
    checkError();
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    this.mVertexMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMatrix");
    checkError();
    this.mTextureMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uTextureMatrix");
    checkError();
    this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "position");
    checkError();
    this.mTextureCoordinatesHandle = GLES20.glGetAttribLocation(this.mProgram, "inputTextureCoordinate");
    checkError();
    this.mTextureUnitHandle0 = GLES20.glGetUniformLocation(this.mProgram, "yTexture");
    checkError();
    this.mTextureUnitHandle1 = GLES20.glGetUniformLocation(this.mProgram, "uTexture");
    checkError();
    this.mConvertOffsetUniform = GLES20.glGetUniformLocation(this.mProgram, "offset");
    GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset));
    this.mConvertMatrixUniform = GLES20.glGetUniformLocation(this.mProgram, "convertMatrix");
    GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_fullrage_ffmpeg_matrix, 0);
    this.mTextureIds = new int[2];
    GLES20.glGenTextures(2, this.mTextureIds, 0);
    AppMethodBeat.o(67341);
  }
  
  public void drawFrame(TXSVideoFrame paramTXSVideoFrame)
  {
    AppMethodBeat.i(146764);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    Matrix.setIdentityM(this.mTextureMatrix, 0);
    GLES20.glUseProgram(this.mProgram);
    checkError();
    GLES20.glEnableVertexAttribArray(this.mPositionHandle);
    checkError();
    this.mVertexBuffer.position(0);
    GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, this.mVertexBuffer);
    checkError();
    GLES20.glEnableVertexAttribArray(this.mTextureCoordinatesHandle);
    checkError();
    this.mTextureBuffer.position(0);
    GLES20.glVertexAttribPointer(this.mTextureCoordinatesHandle, 2, 5126, false, 8, this.mTextureBuffer);
    checkError();
    GLES20.glUniformMatrix4fv(this.mVertexMatrixHandle, 1, false, this.mMVPMatrix, 0);
    checkError();
    GLES20.glUniformMatrix4fv(this.mTextureMatrixHandle, 1, false, this.mTextureMatrix, 0);
    checkError();
    int i = paramTXSVideoFrame.frameType;
    if (4 == i)
    {
      GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_fullrange_ffmpeg_offset));
      GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_fullrage_ffmpeg_matrix, 0);
      if (i != this.mRawDataFrameType)
      {
        this.mRawDataFrameType = i;
        TXCLog.i(TAG, " frame type " + i + " matrix_test fullRange");
      }
    }
    for (;;)
    {
      GLES20.glUniform1i(this.mTextureUnitHandle0, 0);
      checkError();
      GLES20.glUniform1i(this.mTextureUnitHandle1, 1);
      checkError();
      if ((paramTXSVideoFrame.buffer != null) && (this.mTextureIds != null)) {
        nativeLoadTexture(paramTXSVideoFrame.buffer, paramTXSVideoFrame.width, paramTXSVideoFrame.height, this.mTextureIds);
      }
      paramTXSVideoFrame.release();
      GLES20.glDrawElements(4, this.mIndices.length, 5123, this.mIndicesBuffer);
      GLES20.glDisableVertexAttribArray(this.mPositionHandle);
      GLES20.glDisableVertexAttribArray(this.mTextureCoordinatesHandle);
      AppMethodBeat.o(146764);
      return;
      GLES20.glUniform3fv(this.mConvertOffsetUniform, 1, FloatBuffer.wrap(this.bt601_videorange_ffmpeg_offset));
      GLES20.glUniformMatrix3fv(this.mConvertMatrixUniform, 1, false, this.bt601_videorage_ffmpeg_matrix, 0);
      if (i != this.mRawDataFrameType)
      {
        this.mRawDataFrameType = i;
        TXCLog.i(TAG, " frame type " + i + " matrix_test videoRange");
      }
    }
  }
  
  public int drawToTexture(TXSVideoFrame paramTXSVideoFrame)
  {
    AppMethodBeat.i(146763);
    reloadFrameBuffer();
    if (this.mFrameBufferID == -12345)
    {
      TXCLog.d(TAG, "invalid frame buffer id");
      AppMethodBeat.o(146763);
      return -12345;
    }
    GLES20.glBindFramebuffer(36160, this.mFrameBufferID);
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    drawFrame(paramTXSVideoFrame);
    GLES20.glBindFramebuffer(36160, 0);
    int i = this.mFrameBufferTextureID;
    AppMethodBeat.o(146763);
    return i;
  }
  
  public void onSurfaceDestroy()
  {
    AppMethodBeat.i(67343);
    if (this.mTextureIds != null)
    {
      GLES20.glDeleteTextures(2, this.mTextureIds, 0);
      this.mTextureIds = null;
    }
    destroyFrameBuffer();
    GLES20.glDeleteProgram(this.mProgram);
    AppMethodBeat.o(67343);
  }
  
  public void setHasFrameBuffer(int paramInt1, int paramInt2)
  {
    if ((this.mWidth == paramInt1) && (this.mHeight == paramInt2)) {
      return;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mNeedReLoadFrameBuffer = true;
  }
  
  public void setVideoSize(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCYuvTextureRender
 * JD-Core Version:    0.7.0.1
 */