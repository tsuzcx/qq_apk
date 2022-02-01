package com.tencent.av.opengl.texture;

import android.opengl.GLES20;
import com.tencent.av.opengl.glrender.GLCanvas;
import com.tencent.av.opengl.glrender.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class FrameBufferCenterTexture
{
  private static int NOINITID = -1;
  public static final String TAG = "FrameBufferCenterTexture";
  private static FrameBufferCenterTexture frameBuffer = null;
  public static final float[] matrix = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public static float[] matrixV = { 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private int frameBufferId = NOINITID;
  private int frameBuffer_2_id = NOINITID;
  private int frameTextureId = NOINITID;
  private int frameTexture_2_id = NOINITID;
  private int height = 0;
  boolean isDrawEdge = true;
  private FloatBuffer mVertexBuffer = null;
  private int width = 0;
  
  public static FrameBufferCenterTexture getInstance()
  {
    if (frameBuffer == null) {
      frameBuffer = new FrameBufferCenterTexture();
    }
    return frameBuffer;
  }
  
  private void initFboTexture()
  {
    if (this.frameTextureId == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.frameTextureId = arrayOfInt[0];
    }
    this.frameBufferId = initFrameBuffer(this.width, this.height, this.frameTextureId);
  }
  
  private void initFboTexture_2()
  {
    if (this.frameTexture_2_id == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.frameTexture_2_id = arrayOfInt[0];
    }
    this.frameBuffer_2_id = initFrameBuffer_2(this.width, this.height, this.frameTexture_2_id);
  }
  
  private int initFrameBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.frameBufferId;
    if (this.frameBufferId == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    GLES20.glBindFramebuffer(36160, i);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
    GLES20.glBindFramebuffer(36160, 0);
    return i;
  }
  
  private int initFrameBuffer_2(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.frameBuffer_2_id;
    if (this.frameBuffer_2_id == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    GLES20.glBindFramebuffer(36160, i);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
    GLES20.glBindFramebuffer(36160, 0);
    return i;
  }
  
  private void intVBuffer()
  {
    if (this.mVertexBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(arrayOfFloat);
    this.mVertexBuffer.position(0);
  }
  
  public void drawFbo(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat, int paramInt8, int paramInt9)
  {
    if ((this.width != paramInt1 * 2) || (this.frameBufferId == NOINITID))
    {
      this.width = (paramInt1 * 2);
      this.height = (paramInt2 * 2);
      initFboTexture();
      initFboTexture_2();
      intVBuffer();
    }
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    GLES20.glViewport(0, 0, this.width, this.height);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    TextureProgram localTextureProgram = TextureProgramFactory.make(2);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.getParameters();
    GLES20.glUseProgram(localTextureProgram.getId());
    GLES20.glUniform1f(localTextureProgram.getParameters()[7].handle, paramInt1);
    GLES20.glUniform1f(localTextureProgram.getParameters()[8].handle, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.getParameters()[9].handle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.getParameters()[10].handle, paramInt8);
    GLES20.glUniform1i(localTextureProgram.getParameters()[11].handle, paramInt9);
    GLES20Canvas.enableBlending(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt5);
    GLES20.glUniform1i(arrayOfShaderParameter[4].handle, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt6);
    GLES20.glUniform1i(arrayOfShaderParameter[5].handle, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt7);
    GLES20.glUniform1i(arrayOfShaderParameter[6].handle, 2);
    GLES20.glUniform1f(arrayOfShaderParameter[2].handle, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].handle, 1, false, matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].handle, 1, false, matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].handle, 2, 5126, false, 8, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].handle);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfShaderParameter[0].handle);
    GLES20.glBindFramebuffer(36160, this.frameBuffer_2_id);
    GLES20.glViewport(0, 0, this.width, this.height);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    localTextureProgram = TextureProgramFactory.make(3);
    arrayOfShaderParameter = localTextureProgram.getParameters();
    GLES20.glUseProgram(localTextureProgram.getId());
    GLES20.glUniform1f(localTextureProgram.getParameters()[7].handle, paramInt1);
    GLES20.glUniform1f(localTextureProgram.getParameters()[8].handle, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.getParameters()[9].handle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.getParameters()[10].handle, paramInt8);
    GLES20.glUniform1i(localTextureProgram.getParameters()[11].handle, paramInt9);
    GLES20Canvas.enableBlending(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.frameTextureId);
    GLES20.glUniform1i(arrayOfShaderParameter[4].handle, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].handle, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].handle, 1, false, matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].handle, 1, false, matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].handle, 2, 5126, false, 8, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].handle);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfShaderParameter[0].handle);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    drawFboToScreen(paramGLCanvas, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
  
  public void drawFboToScreen(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.isDrawEdge)
    {
      paramGLCanvas = TextureProgramFactory.make(0);
      GLES20.glUseProgram(paramGLCanvas.getId());
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.frameTexture_2_id);
      GLES20.glUniform1i(paramGLCanvas.getParameters()[4].handle, 0);
      GLES20.glUniform1f(paramGLCanvas.getParameters()[2].handle, 1.0F);
    }
  }
  
  public void release()
  {
    if (this.frameBufferId != NOINITID)
    {
      GLES20.glDeleteFramebuffers(2, new int[] { this.frameBufferId, this.frameBuffer_2_id }, 0);
      GLES20.glDeleteTextures(2, new int[] { this.frameTextureId, this.frameTexture_2_id }, 0);
    }
    this.frameBufferId = NOINITID;
    this.frameTextureId = NOINITID;
    this.frameBuffer_2_id = NOINITID;
    this.frameTexture_2_id = NOINITID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.texture.FrameBufferCenterTexture
 * JD-Core Version:    0.7.0.1
 */