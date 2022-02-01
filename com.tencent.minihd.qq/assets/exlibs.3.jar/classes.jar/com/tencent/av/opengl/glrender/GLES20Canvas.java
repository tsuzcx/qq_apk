package com.tencent.av.opengl.glrender;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.opengl.program.DrawProgram;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.qav.log.AVLog;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class GLES20Canvas
  implements GLCanvas
{
  private static final float[] BOX_COORDINATES = { -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private static final int COORDS_PER_VERTEX = 2;
  private static final int COUNT_FILL_VERTEX = 4;
  private static final int COUNT_LINE_VERTEX = 2;
  private static final int COUNT_RECT_VERTEX = 4;
  private static final int FLOAT_SIZE = 4;
  private static final int INDEX_MATRIX = 1;
  private static final int INDEX_POSITION = 0;
  private static final int INITIAL_RESTORE_STATE_SIZE = 8;
  private static final int MATRIX_SIZE = 16;
  private static final int OFFSET_DRAW_LINE = 4;
  private static final int OFFSET_DRAW_RECT = 6;
  private static final int OFFSET_FILL_RECT = 0;
  public static final float OPAQUE_ALPHA = 0.95F;
  private static final String TAG = "GLES20Canvas";
  private static final int VERTEX_STRIDE = 8;
  private static final GLId mGLId = new GLES20Id();
  private float[] currMatrix;
  private float exDepth = 0.0F;
  private float exEyeZ = 3.0F;
  private float exPx = 180.0F;
  private float eyeZ = 0.0F;
  private ByteBuffer llbb = ByteBuffer.allocateDirect(12);
  private float[] mAlphas = new float[8];
  private int mBoxCoordinates;
  private int mCountDrawLine = 0;
  private int mCountDrawMesh = 0;
  private int mCountFillRect = 0;
  private int mCountTextureRect = 0;
  private int mCurrentAlphaIndex = 0;
  private int mCurrentMatrixIndex = 0;
  private final IntArray mDeleteBuffers = new IntArray();
  private DrawProgram mDrawProgram;
  private int mHeight;
  float[] mMVPMatrix = new float[16];
  private float[] mProjMatrix = new float[16];
  private IntArray mSaveFlags = new IntArray();
  private float[][] mStack = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 16 });
  private final float[] mTempColor = new float[4];
  private final int[] mTempIntArray = new int[1];
  private final float[] mTempMatrix = new float[32];
  private final RectF mTempSourceRect = new RectF();
  private final RectF mTempTargetRect = new RectF();
  private final float[] mTempTextureMatrix = new float[16];
  private final IntArray mUnboundTextures = new IntArray();
  private float[] mVMatrix = new float[16];
  private int mWidth;
  private int stackTop = -1;
  
  public GLES20Canvas()
  {
    Matrix.setIdentityM(this.mTempTextureMatrix, 0);
    this.mAlphas[this.mCurrentAlphaIndex] = 1.0F;
    this.mBoxCoordinates = uploadBuffer(createBuffer(BOX_COORDINATES));
    this.mDrawProgram = new DrawProgram();
    GLES20.glBlendFunc(1, 771);
    Utils.checkError();
  }
  
  private static void convertCoordinate(RectF paramRectF, BasicTexture paramBasicTexture)
  {
    int i = paramBasicTexture.getTextureWidth();
    int j = paramBasicTexture.getTextureHeight();
    paramRectF.left /= i;
    paramRectF.right /= i;
    paramRectF.top /= j;
    paramRectF.bottom /= j;
  }
  
  private static FloatBuffer createBuffer(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat, 0, paramArrayOfFloat.length).position(0);
    return localFloatBuffer;
  }
  
  private void draw(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, float paramFloat5)
  {
    prepareDraw(paramInt2, paramInt4, paramFloat5);
    draw(this.mDrawProgram.getParameters(), paramInt1, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  private void draw(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    draw(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint.getColor(), paramGLPaint.getLineWidth());
  }
  
  private void draw(ShaderParameter[] paramArrayOfShaderParameter, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setMatrix(paramArrayOfShaderParameter, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int i = paramArrayOfShaderParameter[0].handle;
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glEnableVertexAttribArray(i);
    Utils.checkError();
    GLES20.glDrawArrays(paramInt1, 0, paramInt2);
    Utils.checkError();
    GLES20.glDisableVertexAttribArray(i);
    Utils.checkError();
  }
  
  private void drawTextureRect(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    setTextureMatrix(paramRectF1);
    drawTextureRect(paramBasicTexture, this.mTempTextureMatrix, paramRectF2);
  }
  
  private void drawTextureRect(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, RectF paramRectF)
  {
    ShaderParameter[] arrayOfShaderParameter = paramBasicTexture.prepareTexture(this);
    setPosition(arrayOfShaderParameter, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].handle, 1, false, paramArrayOfFloat, 0);
    Utils.checkError();
    if (paramBasicTexture.isFlippedVertically())
    {
      save(2);
      translate(0.0F, paramRectF.centerY());
      scale(1.0F, -1.0F, 1.0F);
      translate(0.0F, -paramRectF.centerY());
    }
    draw(arrayOfShaderParameter, 5, 4, paramRectF.left, paramRectF.top, paramRectF.width(), paramRectF.height());
    if (paramBasicTexture.isFlippedVertically()) {
      restore();
    }
    this.mCountTextureRect += 1;
  }
  
  public static void enableBlending(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      Utils.checkError();
      return;
    }
    GLES20.glDisable(3042);
    Utils.checkError();
  }
  
  private float[] getColor(int paramInt)
  {
    float f1 = (paramInt >>> 24 & 0xFF) / 255.0F * getAlpha();
    float f2 = (paramInt >>> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt >>> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt & 0xFF) / 255.0F;
    this.mTempColor[0] = (f2 * f1);
    this.mTempColor[1] = (f3 * f1);
    this.mTempColor[2] = (f4 * f1);
    this.mTempColor[3] = f1;
    return this.mTempColor;
  }
  
  private float[] getFinalMatrix()
  {
    Matrix.multiplyMM(this.mMVPMatrix, 0, this.mVMatrix, 0, this.currMatrix, 0);
    Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjMatrix, 0, this.mMVPMatrix, 0);
    return this.mMVPMatrix;
  }
  
  private void prepareDraw(int paramInt1, int paramInt2, float paramFloat)
  {
    GLES20.glUseProgram(this.mDrawProgram.getId());
    Utils.checkError();
    if (paramFloat > 0.0F)
    {
      GLES20.glLineWidth(paramFloat);
      Utils.checkError();
    }
    float[] arrayOfFloat = getColor(paramInt2);
    if (arrayOfFloat[3] < 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      enableBlending(bool);
      if (bool)
      {
        GLES20.glBlendColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
        Utils.checkError();
      }
      GLES20.glUniform4fv(this.mDrawProgram.getParameters()[2].handle, 1, arrayOfFloat, 0);
      setPosition(this.mDrawProgram.getParameters(), paramInt1);
      Utils.checkError();
      return;
    }
  }
  
  private static void printMatrix(String paramString, float[] paramArrayOfFloat, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < 16)
    {
      paramString.append(' ');
      if (i % 4 == 0) {
        paramString.append('\n');
      }
      paramString.append(paramArrayOfFloat[(paramInt + i)]);
      i += 1;
    }
    AVLog.d("GLES20Canvas", String.format("printMatrix content=%s", new Object[] { paramString }));
  }
  
  private void setMatrix(ShaderParameter[] paramArrayOfShaderParameter, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    pushMatrix();
    translate(paramFloat1, paramFloat2, 0.0F);
    scale(paramFloat3, paramFloat4, 1.0F);
    GLES20.glUniformMatrix4fv(paramArrayOfShaderParameter[1].handle, 1, false, getFinalMatrix(), 0);
    popMatrix();
    Utils.checkError();
  }
  
  private void setPosition(ShaderParameter[] paramArrayOfShaderParameter, int paramInt)
  {
    GLES20.glBindBuffer(34962, this.mBoxCoordinates);
    Utils.checkError();
    GLES20.glVertexAttribPointer(paramArrayOfShaderParameter[0].handle, 2, 5126, false, 8, paramInt * 8);
    Utils.checkError();
    GLES20.glBindBuffer(34962, 0);
    Utils.checkError();
  }
  
  private void setProjectFrustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.frustumM(this.mProjMatrix, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  private void setTextureMatrix(RectF paramRectF)
  {
    this.mTempTextureMatrix[0] = paramRectF.width();
    this.mTempTextureMatrix[5] = paramRectF.height();
    this.mTempTextureMatrix[12] = paramRectF.left;
    this.mTempTextureMatrix[13] = paramRectF.top;
  }
  
  private int uploadBuffer(Buffer paramBuffer, int paramInt)
  {
    mGLId.glGenBuffers(1, this.mTempIntArray, 0);
    Utils.checkError();
    int i = this.mTempIntArray[0];
    GLES20.glBindBuffer(34962, i);
    Utils.checkError();
    GLES20.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    Utils.checkError();
    return i;
  }
  
  public Bitmap GenerateBmp(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    IntBuffer localIntBuffer = IntBuffer.allocate(paramInt1 * paramInt2);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(localIntBuffer.array()));
    return paramBitmap;
  }
  
  public Bitmap GenerateBmpByTexture(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    IntBuffer localIntBuffer = IntBuffer.allocate(paramInt1 * paramInt2);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(localIntBuffer.array()));
    return paramBitmap;
  }
  
  public void clearBuffer()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Utils.checkError();
    GLES20.glClear(16384);
    Utils.checkError();
  }
  
  public void clearBuffer(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    Utils.checkError();
    GLES20.glClear(16384);
    Utils.checkError();
  }
  
  public void deleteBuffer(int paramInt)
  {
    synchronized (this.mUnboundTextures)
    {
      this.mDeleteBuffers.add(paramInt);
      return;
    }
  }
  
  public void deleteRecycledResources()
  {
    synchronized (this.mUnboundTextures)
    {
      IntArray localIntArray2 = this.mUnboundTextures;
      if (this.mUnboundTextures.size() > 0)
      {
        mGLId.glDeleteTextures(null, localIntArray2.size(), localIntArray2.getInternalArray(), 0);
        localIntArray2.clear();
      }
      localIntArray2 = this.mDeleteBuffers;
      if (localIntArray2.size() > 0)
      {
        mGLId.glDeleteBuffers(null, localIntArray2.size(), localIntArray2.getInternalArray(), 0);
        localIntArray2.clear();
      }
      return;
    }
  }
  
  public void drawLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    draw(3, 4, 2, paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, paramGLPaint);
    this.mCountDrawLine += 1;
  }
  
  public void drawMixed(BasicTexture paramBasicTexture, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Rect localRect = paramBasicTexture.getSourceBounds();
    this.mTempSourceRect.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.mTempTargetRect.set(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5);
    drawMixed(paramBasicTexture, paramInt1, paramFloat, this.mTempSourceRect, this.mTempTargetRect);
  }
  
  public void drawMixed(BasicTexture paramBasicTexture, int paramInt, float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    save(1);
    float f = getAlpha();
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    setAlpha((1.0F - paramFloat) * f);
    drawTexture(paramBasicTexture, paramRectF1, paramRectF2);
    setAlpha(paramFloat * f);
    fillRect(paramRectF2.left, paramRectF2.top, paramRectF2.width(), paramRectF2.height(), paramInt);
    restore();
  }
  
  public void drawRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    draw(2, 6, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint);
    this.mCountDrawLine += 1;
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    Rect localRect = paramBasicTexture.getSourceBounds();
    this.mTempSourceRect.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.mTempTargetRect.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    convertCoordinate(this.mTempSourceRect, paramBasicTexture);
    drawTextureRect(paramBasicTexture, this.mTempSourceRect, this.mTempTargetRect);
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF2.width() <= 0.0F) || (paramRectF2.height() <= 0.0F)) {
      return;
    }
    this.mTempSourceRect.set(paramRectF1);
    this.mTempTargetRect.set(paramRectF2);
    convertCoordinate(this.mTempSourceRect, paramBasicTexture);
    drawTextureRect(paramBasicTexture, this.mTempSourceRect, this.mTempTargetRect);
  }
  
  public void drawTexture(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    this.mTempTargetRect.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    drawTextureRect(paramBasicTexture, paramArrayOfFloat, this.mTempTargetRect);
  }
  
  public void dumpStatisticsAndClear()
  {
    String str = String.format("MESH:%d, TEX_RECT:%d, FILL_RECT:%d, LINE:%d", new Object[] { Integer.valueOf(this.mCountDrawMesh), Integer.valueOf(this.mCountTextureRect), Integer.valueOf(this.mCountFillRect), Integer.valueOf(this.mCountDrawLine) });
    this.mCountDrawMesh = 0;
    this.mCountTextureRect = 0;
    this.mCountFillRect = 0;
    this.mCountDrawLine = 0;
    AVLog.d("GLES20Canvas", str);
  }
  
  public void fillRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    draw(5, 0, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 0.0F);
    this.mCountFillRect += 1;
  }
  
  public float getAlpha()
  {
    return this.mAlphas[this.mCurrentAlphaIndex];
  }
  
  public void getBounds(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramRect.left = Math.round(this.mTempMatrix[16]);
    paramRect.right = Math.round(this.mTempMatrix[20]);
    paramRect.top = Math.round(this.mTempMatrix[17]);
    paramRect.bottom = Math.round(this.mTempMatrix[21]);
    paramRect.sort();
  }
  
  public GLId getGLId()
  {
    return mGLId;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int getmHeight()
  {
    return this.mHeight;
  }
  
  public int getmWidth()
  {
    return this.mWidth;
  }
  
  public void initializeTexture(BasicTexture paramBasicTexture, Bitmap paramBitmap)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    Utils.checkError();
    GLUtils.texImage2D(j, 0, paramBitmap, 0);
  }
  
  public void initializeTextureSize(BasicTexture paramBasicTexture, int paramInt1, int paramInt2)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    Utils.checkError();
    GLES20.glTexImage2D(j, 0, paramInt1, paramBasicTexture.getTextureWidth(), paramBasicTexture.getTextureHeight(), 0, paramInt1, paramInt2, null);
  }
  
  public void multiplyAlpha(float paramFloat)
  {
    setAlpha(getAlpha() * paramFloat);
  }
  
  public void multiplyMatrix(float[] paramArrayOfFloat, int paramInt) {}
  
  public void popMatrix()
  {
    int i = 0;
    while (i < 16)
    {
      this.currMatrix[i] = this.mStack[this.stackTop][i];
      i += 1;
    }
    this.stackTop -= 1;
  }
  
  public void pushMatrix()
  {
    this.stackTop += 1;
    int i = 0;
    while (i < 16)
    {
      this.mStack[this.stackTop][i] = this.currMatrix[i];
      i += 1;
    }
  }
  
  public void recoverFromLightCycle()
  {
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
    GLES20.glDisable(2929);
    GLES20.glBlendFunc(1, 771);
    Utils.checkError();
  }
  
  public void restore()
  {
    int j = 1;
    int k = this.mSaveFlags.removeLast();
    if ((k & 0x1) == 1)
    {
      i = 1;
      if (i != 0) {
        this.mCurrentAlphaIndex -= 1;
      }
      if ((k & 0x2) != 2) {
        break label67;
      }
    }
    label67:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        this.mCurrentMatrixIndex -= 16;
        popMatrix();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.rotateM(this.currMatrix, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void save()
  {
    save(-1);
  }
  
  public void save(int paramInt)
  {
    int j = 1;
    if ((paramInt & 0x1) == 1)
    {
      i = 1;
      if (i != 0)
      {
        float f = getAlpha();
        this.mCurrentAlphaIndex += 1;
        if (this.mAlphas.length <= this.mCurrentAlphaIndex)
        {
          if (Build.VERSION.SDK_INT < 9) {
            break label111;
          }
          this.mAlphas = Arrays.copyOf(this.mAlphas, this.mAlphas.length * 2);
        }
        label69:
        this.mAlphas[this.mCurrentAlphaIndex] = f;
      }
      if ((paramInt & 0x2) != 2) {
        break label159;
      }
    }
    label159:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        pushMatrix();
      }
      this.mSaveFlags.add(paramInt);
      return;
      i = 0;
      break;
      label111:
      float[] arrayOfFloat = new float[this.mAlphas.length * 2];
      i = 0;
      while (i < this.mAlphas.length)
      {
        arrayOfFloat[i] = this.mAlphas[i];
        i += 1;
      }
      this.mAlphas = arrayOfFloat;
      break label69;
    }
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.currMatrix, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlphas[this.mCurrentAlphaIndex] = paramFloat;
  }
  
  public void setCamera(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.eyeZ = paramFloat3;
    Matrix.setLookAtM(this.mVMatrix, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public void setInitStack()
  {
    this.currMatrix = new float[16];
    Matrix.setRotateM(this.currMatrix, 0, 0.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    setInitStack();
    setProjectFrustum(-paramInt1 / 4, paramInt1 / 4, -paramInt2 / 4, paramInt2 / 4, paramInt2, 1000000.0F);
    setCamera(0.0F, 0.0F, paramInt2 * 2, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    translate(0.0F, paramInt2 / 2, 0.0F);
    scale(1.0F, -1.0F, 1.0F);
    translate(-paramInt1 / 2, 0.0F, 0.0F);
    Utils.checkError();
  }
  
  public void setTextureParameters(BasicTexture paramBasicTexture)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    Utils.checkError();
    GLES20.glTexParameteri(j, 10242, 33071);
    GLES20.glTexParameteri(j, 10243, 33071);
    GLES20.glTexParameterf(j, 10241, 9729.0F);
    GLES20.glTexParameterf(j, 10240, 9729.0F);
  }
  
  public void texSubImage2D(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int j = paramBasicTexture.getTarget();
    int[] arrayOfInt = paramBasicTexture.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramBasicTexture.getId()[i]);
      i += 1;
    }
    Utils.checkError();
    GLUtils.texSubImage2D(j, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void translate(float paramFloat1, float paramFloat2)
  {
    translate(paramFloat1, paramFloat2, 0.0F);
  }
  
  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.currMatrix, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public boolean unloadTexture(BasicTexture paramBasicTexture)
  {
    boolean bool = paramBasicTexture.isLoaded();
    if (bool) {}
    for (;;)
    {
      synchronized (this.mUnboundTextures)
      {
        paramBasicTexture = paramBasicTexture.getId();
        if (paramBasicTexture != null) {
          break label68;
        }
        return bool;
        if (i < paramBasicTexture.length)
        {
          this.mUnboundTextures.add(paramBasicTexture[i]);
          i += 1;
          continue;
        }
        return bool;
      }
      return bool;
      label68:
      int i = 0;
    }
  }
  
  public int uploadBuffer(ByteBuffer paramByteBuffer)
  {
    return uploadBuffer(paramByteBuffer, 1);
  }
  
  public int uploadBuffer(FloatBuffer paramFloatBuffer)
  {
    return uploadBuffer(paramFloatBuffer, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.glrender.GLES20Canvas
 * JD-Core Version:    0.7.0.1
 */