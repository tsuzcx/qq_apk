package com.tencent.mobileqq.magicface.model;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ShaderUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class MagicFaceGLDisplayer
{
  private static final int jdField_a_of_type_Int = 700;
  public static final String a;
  private static final short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 2, 3, 0 };
  private static final int jdField_b_of_type_Int = 900;
  private static final String jdField_b_of_type_JavaLangString = "attribute vec4 position;\nattribute mediump vec2 textureCoordinate;\nvarying mediump vec2 coordinate;\nuniform mat4 transformMatrix;\nvoid main()\n{\n   gl_Position = position * transformMatrix; \n   coordinate = textureCoordinate; \n}\n";
  private static final String jdField_c_of_type_JavaLangString = "precision highp float;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform sampler2D SamplerY_Alpha;\nuniform sampler2D SamplerU_Alpha;\nuniform sampler2D SamplerV_Alpha;\nvarying highp vec2 coordinate;\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;    \n    yuv.x = texture2D(SamplerY, coordinate).r;    \n    yuv.y = texture2D(SamplerU, coordinate).r-0.5;    \n    yuv.z = texture2D(SamplerV, coordinate).r-0.5 ;    \n    rgb = mat3(      1,       1,      1,\n               \t\t0, \t\t-.34414, 1.772,\n               \t\t1.402, \t-.71414, 0) * yuv;    \n    highp vec3 yuv_Alpha;\n    highp vec3 rgb_Alpha;    \n    yuv_Alpha.x = texture2D(SamplerY_Alpha, coordinate).r;    \n    yuv_Alpha.y = texture2D(SamplerU_Alpha, coordinate).r-0.5;    \n    yuv_Alpha.z = texture2D(SamplerV_Alpha, coordinate).r-0.5 ;    \n    rgb_Alpha = mat3(      1,       1,      1,\n               \t\t0, \t\t-.34414, 1.772,\n               \t\t1.402, \t-.71414, 0) * yuv_Alpha;    \n         if(rgb_Alpha[0]  <= 0.196 ){   \n               rgb_Alpha[0] = 0.0;}   \n         else if(rgb_Alpha[0]  >= 0.922){     \n               rgb_Alpha[0] = 1.0;}  \n    gl_FragColor = vec4(rgb.r * rgb_Alpha.r ,rgb.g * rgb_Alpha.r ,rgb.b * rgb_Alpha.r, rgb_Alpha.r) ;\n}\n";
  private float jdField_a_of_type_Float = -1.0F;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = null;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer = null;
  private boolean jdField_a_of_type_Boolean = false;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m;
  private int n;
  private int o;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = MagicFaceGLDisplayer.class.getSimpleName();
  }
  
  public MagicFaceGLDisplayer()
  {
    this.b = null;
    b();
    a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = IntBuffer.allocate(1);
    GLES20.glGenTextures(1, (IntBuffer)localObject);
    int i1 = ((IntBuffer)localObject).get();
    GLES20.glBindTexture(3553, i1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    try
    {
      localObject = ByteBuffer.allocateDirect(paramArrayOfByte.length);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      ((ByteBuffer)localObject).position(0);
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, (Buffer)localObject);
      return i1;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -2015;
  }
  
  private void a(float paramFloat)
  {
    float f1 = 3.14159F * paramFloat / 180.0F;
    paramFloat = (float)Math.sin(f1);
    f1 = (float)Math.cos(f1);
    float[] arrayOfFloat = new float[16];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = paramFloat;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (-paramFloat);
    arrayOfFloat[5] = f1;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    Object localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(arrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    GLES20.glUniformMatrix4fv(this.i, 1, false, (FloatBuffer)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = this.w / this.u * this.v / this.x)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func updateRenderParam, [yCord]=" + f1);
      }
      float f2 = (this.s - this.u) / this.s / 2.0F;
      float f3 = (this.t - this.v) / this.t / 2.0F;
      Object localObject = new float[12];
      localObject[0] = 1.0F;
      localObject[1] = (-f1);
      localObject[2] = 0.0F;
      localObject[3] = 1.0F;
      localObject[4] = f1;
      localObject[5] = 0.0F;
      localObject[6] = -1.0F;
      localObject[7] = f1;
      localObject[8] = 0.0F;
      localObject[9] = -1.0F;
      localObject[10] = (-f1);
      localObject[11] = 0.0F;
      float[] arrayOfFloat = new float[8];
      arrayOfFloat[0] = (1.0F - f2);
      arrayOfFloat[1] = (1.0F - f3);
      arrayOfFloat[2] = (1.0F - f2);
      arrayOfFloat[3] = f3;
      arrayOfFloat[4] = f2;
      arrayOfFloat[5] = f3;
      arrayOfFloat[6] = f2;
      arrayOfFloat[7] = (1.0F - f3);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
      this.jdField_a_of_type_JavaNioFloatBuffer.put((float[])localObject);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.b = ((ByteBuffer)localObject).asFloatBuffer();
      this.b.put(arrayOfFloat);
      this.b.position(0);
      return;
    }
  }
  
  private void b()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
  }
  
  public void a()
  {
    this.c = ShaderUtil.a("attribute vec4 position;\nattribute mediump vec2 textureCoordinate;\nvarying mediump vec2 coordinate;\nuniform mat4 transformMatrix;\nvoid main()\n{\n   gl_Position = position * transformMatrix; \n   coordinate = textureCoordinate; \n}\n", "precision highp float;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform sampler2D SamplerY_Alpha;\nuniform sampler2D SamplerU_Alpha;\nuniform sampler2D SamplerV_Alpha;\nvarying highp vec2 coordinate;\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;    \n    yuv.x = texture2D(SamplerY, coordinate).r;    \n    yuv.y = texture2D(SamplerU, coordinate).r-0.5;    \n    yuv.z = texture2D(SamplerV, coordinate).r-0.5 ;    \n    rgb = mat3(      1,       1,      1,\n               \t\t0, \t\t-.34414, 1.772,\n               \t\t1.402, \t-.71414, 0) * yuv;    \n    highp vec3 yuv_Alpha;\n    highp vec3 rgb_Alpha;    \n    yuv_Alpha.x = texture2D(SamplerY_Alpha, coordinate).r;    \n    yuv_Alpha.y = texture2D(SamplerU_Alpha, coordinate).r-0.5;    \n    yuv_Alpha.z = texture2D(SamplerV_Alpha, coordinate).r-0.5 ;    \n    rgb_Alpha = mat3(      1,       1,      1,\n               \t\t0, \t\t-.34414, 1.772,\n               \t\t1.402, \t-.71414, 0) * yuv_Alpha;    \n         if(rgb_Alpha[0]  <= 0.196 ){   \n               rgb_Alpha[0] = 0.0;}   \n         else if(rgb_Alpha[0]  >= 0.922){     \n               rgb_Alpha[0] = 1.0;}  \n    gl_FragColor = vec4(rgb.r * rgb_Alpha.r ,rgb.g * rgb_Alpha.r ,rgb.b * rgb_Alpha.r, rgb_Alpha.r) ;\n}\n");
    GLES20.glUseProgram(this.c);
    this.d = GLES20.glGetAttribLocation(this.c, "position");
    this.e = GLES20.glGetAttribLocation(this.c, "textureCoordinate");
    this.f = GLES20.glGetUniformLocation(this.c, "SamplerY");
    this.g = GLES20.glGetUniformLocation(this.c, "SamplerU");
    this.h = GLES20.glGetUniformLocation(this.c, "SamplerV");
    this.m = GLES20.glGetUniformLocation(this.c, "SamplerY_Alpha");
    this.n = GLES20.glGetUniformLocation(this.c, "SamplerU_Alpha");
    this.o = GLES20.glGetUniformLocation(this.c, "SamplerV_Alpha");
    this.i = GLES20.glGetUniformLocation(this.c, "transformMatrix");
    GLES20.glEnableVertexAttribArray(this.d);
    GLES20.glEnableVertexAttribArray(this.e);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func draw begins, _srcwidth:" + paramInt1 + ",_srcheight:" + paramInt2 + ",_dstWidth:" + paramInt3 + ",_dstHeight:" + paramInt4 + ",isFull:" + paramBoolean);
    }
    if ((paramInt1 > 700) || (paramInt2 > 900)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func draw ends, video size is too big. something must be wrong");
      }
    }
    do
    {
      do
      {
        return;
        GLES20.glClear(16640);
        this.w = paramInt3;
        this.x = paramInt4;
        this.s = paramInt1;
        this.t = paramInt2;
        this.u = paramInt1;
        this.v = paramInt2;
        if (this.jdField_a_of_type_Float == -1.0F)
        {
          this.jdField_a_of_type_Float = paramFloat;
          this.jdField_a_of_type_Boolean = paramBoolean;
          a(this.jdField_a_of_type_Boolean);
          a(this.jdField_a_of_type_Float);
        }
        if (this.jdField_a_of_type_Float != paramFloat)
        {
          this.jdField_a_of_type_Float = paramFloat;
          a(this.jdField_a_of_type_Float);
        }
        if (this.jdField_a_of_type_Boolean != paramBoolean)
        {
          this.jdField_a_of_type_Boolean = paramBoolean;
          a(this.jdField_a_of_type_Boolean);
        }
        if ((this.s != this.u) || (this.t != this.v)) {
          a(this.jdField_a_of_type_Boolean);
        }
        byte[] arrayOfByte1 = new byte[this.s * this.t];
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, 0, this.s * this.t);
        byte[] arrayOfByte2 = new byte[this.s * this.t / 4];
        System.arraycopy(paramArrayOfByte1, this.s * this.t, arrayOfByte2, 0, this.s * this.t / 4);
        byte[] arrayOfByte3 = new byte[this.s * this.t / 4];
        System.arraycopy(paramArrayOfByte1, this.s * this.t * 5 / 4, arrayOfByte3, 0, this.s * this.t / 4);
        paramArrayOfByte1 = new byte[this.s * this.t];
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, this.s * this.t);
        byte[] arrayOfByte4 = new byte[this.s * this.t / 4];
        System.arraycopy(paramArrayOfByte2, this.s * this.t, arrayOfByte4, 0, this.s * this.t / 4);
        byte[] arrayOfByte5 = new byte[this.s * this.t / 4];
        System.arraycopy(paramArrayOfByte2, this.s * this.t * 5 / 4, arrayOfByte5, 0, this.s * this.t / 4);
        if (this.j != -1) {
          GLES20.glDeleteTextures(1, new int[] { this.j }, 0);
        }
        if (this.k != -1) {
          GLES20.glDeleteTextures(1, new int[] { this.k }, 0);
        }
        if (this.l != -1) {
          GLES20.glDeleteTextures(1, new int[] { this.l }, 0);
        }
        if (this.p != -1) {
          GLES20.glDeleteTextures(1, new int[] { this.p }, 0);
        }
        if (this.q != -1) {
          GLES20.glDeleteTextures(1, new int[] { this.q }, 0);
        }
        if (this.r != -1) {
          GLES20.glDeleteTextures(1, new int[] { this.r }, 0);
        }
        this.j = a(arrayOfByte1, this.s, this.t);
        this.k = a(arrayOfByte2, this.s / 2, this.t / 2);
        this.l = a(arrayOfByte3, this.s / 2, this.t / 2);
        this.p = a(paramArrayOfByte1, this.s, this.t);
        this.q = a(arrayOfByte4, this.s / 2, this.t / 2);
        this.r = a(arrayOfByte5, this.s / 2, this.t / 2);
      } while ((this.j == -2015) || (this.k == -2015) || (this.l == -2015) || (this.p == -2015) || (this.q == -2015) || (this.r == -2015));
      GLES20.glVertexAttribPointer(this.d, 3, 5126, false, 12, this.jdField_a_of_type_JavaNioFloatBuffer);
      GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 8, this.b);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.p);
      GLES20.glUniform1i(this.m, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.q);
      GLES20.glUniform1i(this.n, 1);
      GLES20.glActiveTexture(33986);
      GLES20.glBindTexture(3553, this.r);
      GLES20.glUniform1i(this.o, 2);
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, this.j);
      GLES20.glUniform1i(this.f, 3);
      GLES20.glActiveTexture(33988);
      GLES20.glBindTexture(3553, this.k);
      GLES20.glUniform1i(this.g, 4);
      GLES20.glActiveTexture(33989);
      GLES20.glBindTexture(3553, this.l);
      GLES20.glUniform1i(this.h, 5);
      GLES20.glDrawElements(4, jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func draw ends");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceGLDisplayer
 * JD-Core Version:    0.7.0.1
 */