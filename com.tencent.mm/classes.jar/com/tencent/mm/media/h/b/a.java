package com.tencent.mm.media.h.b;

import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "mirror", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "buffer", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/IntBuffer;", "setRenderOutputBuffer", "(Ljava/nio/IntBuffer;)V", "renderOutputTexture", "getRenderOutputTexture", "setRenderOutputTexture", "renderOutputTextureFbo", "getRenderOutputTextureFbo", "setRenderOutputTextureFbo", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "snapShotBuffer", "getSnapShotBuffer", "setSnapShotBuffer", "snapShotHeight", "snapShotWidth", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputTexture", "getRotate", "initMatrix", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "width", "height", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateTextureSize", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a eYI = new a.a((byte)0);
  private boolean eYA;
  private a.f.a.b<? super Integer, y> eYB;
  public a.f.a.b<? super IntBuffer, y> eYC;
  public boolean eYD;
  private boolean eYE;
  private int eYF;
  private int eYG;
  private IntBuffer eYH;
  public int eYe;
  public boolean eYf;
  public int eYj;
  public int eYk;
  protected int eYl;
  protected int eYm;
  private int eYn;
  public Rect eYq;
  FloatBuffer eYu;
  FloatBuffer eYv;
  private int eYw;
  private int eYx;
  public IntBuffer eYy;
  float[] eYz;
  private final int scaleType;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.eYj = paramInt1;
    this.eYk = paramInt2;
    this.eYl = paramInt3;
    this.eYm = paramInt4;
    this.eYn = paramInt5;
    this.scaleType = paramInt6;
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.i.b.eZr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.eYu = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.i.b.eZq.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    j.p(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.eYv = ((FloatBuffer)localObject);
    this.eYz = new float[16];
    this.eYF = -1;
    this.eYG = -1;
    if (this.eYn == 2)
    {
      localObject = com.tencent.mm.media.i.b.eZw;
      this.eYw = b.a.Vm();
      localObject = com.tencent.mm.media.i.b.eZw;
      this.eYx = b.a.Vn();
    }
    while (this.eYn != 3) {
      return;
    }
    Vi();
  }
  
  private void Vi()
  {
    if ((this.eYl > 0) && (this.eYm > 0) && (this.eYy == null)) {
      this.eYy = ByteBuffer.allocateDirect(this.eYl * this.eYm * 4).asIntBuffer();
    }
  }
  
  public void L(byte[] paramArrayOfByte)
  {
    j.q(paramArrayOfByte, "frame");
  }
  
  public final void Vf()
  {
    Matrix.setIdentityM(this.eYz, 0);
    Matrix.setRotateM(this.eYz, 0, this.eYe, 0.0F, 0.0F, -1.0F);
    if ((this.eYA) || (this.eYn == 3)) {
      if ((this.eYe == 90) || (this.eYe == 270)) {
        Matrix.scaleM(this.eYz, 0, -1.0F, 1.0F, 1.0F);
      }
    }
    Object localObject1;
    int i;
    label307:
    int j;
    label320:
    long l;
    for (;;)
    {
      if (this.eYf) {
        Matrix.scaleM(this.eYz, 0, 1.0F, -1.0F, 1.0F);
      }
      if (this.scaleType != 1) {
        break;
      }
      this.eYu.position(0);
      this.eYu.put(com.tencent.mm.media.i.b.eZr);
      this.eYu.position(0);
      this.eYv.position(0);
      this.eYv.put(com.tencent.mm.media.i.b.eZq);
      this.eYv.position(0);
      localObject1 = com.tencent.mm.media.i.b.eZw;
      b.a.Vo();
      GLES20.glViewport(0, 0, this.eYl, this.eYm);
      if (this.eYn == 2)
      {
        if (this.eYw == 0)
        {
          localObject1 = com.tencent.mm.media.i.b.eZw;
          this.eYw = b.a.Vm();
          localObject1 = com.tencent.mm.media.i.b.eZw;
          this.eYx = b.a.Vn();
        }
        localObject1 = com.tencent.mm.media.i.b.eZw;
        b.a.r(this.eYx, this.eYw, this.eYj, this.eYk);
        GLES20.glViewport(0, 0, this.eYj, this.eYk);
      }
      if (this.eYD)
      {
        if (this.eYw == 0)
        {
          localObject1 = com.tencent.mm.media.i.b.eZw;
          this.eYw = b.a.Vm();
          localObject1 = com.tencent.mm.media.i.b.eZw;
          this.eYx = b.a.Vn();
        }
        if (this.eYF > 0) {
          break label1218;
        }
        i = this.eYl;
        if (this.eYG > 0) {
          break label1227;
        }
        j = this.eYm;
        this.eYF = i;
        this.eYG = j;
        localObject1 = com.tencent.mm.media.i.b.eZw;
        b.a.r(this.eYx, this.eYw, i, j);
        GLES20.glViewport(0, 0, this.eYF, this.eYG);
        if ((this.eYe != 90) && (this.eYe != 270)) {
          break label1236;
        }
        Matrix.scaleM(this.eYz, 0, -1.0F, 1.0F, 1.0F);
        label397:
        ab.i("MicroMsg.GLTextureRenderProc", "rotateDegree " + this.eYe + "  transformMatrix:" + this.eYz);
        this.eYE = true;
      }
      Vj();
      if ((!this.eYD) || (!this.eYE)) {
        break label1419;
      }
      l = bo.yB();
      this.eYE = false;
      if ((this.eYH == null) && (this.eYF > 0) && (this.eYG > 0) && (this.eYH == null)) {
        this.eYH = ByteBuffer.allocateDirect(this.eYF * this.eYG * 4).asIntBuffer();
      }
      if (this.eYH != null) {
        break label1252;
      }
      this.eYD = false;
      label530:
      return;
      Matrix.scaleM(this.eYz, 0, 1.0F, -1.0F, 1.0F);
      continue;
      Matrix.scaleM(this.eYz, 0, 1.0F, 1.0F, 1.0F);
    }
    int k;
    label606:
    int m;
    label617:
    int n;
    label628:
    float f1;
    float f2;
    if (this.scaleType == 2)
    {
      localObject1 = com.tencent.mm.media.i.b.eZr;
      localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
      if ((this.eYe == 90) || (this.eYe == 270))
      {
        k = 1;
        if (k == 0) {
          break label810;
        }
        m = this.eYk;
        if (k == 0) {
          break label819;
        }
        n = this.eYj;
        f1 = this.eYl / m;
        f2 = this.eYm / n;
        if (f1 >= f2) {
          break label828;
        }
        j = (int)(this.eYl / f2);
        i = 0;
        j = m - j;
      }
    }
    for (;;)
    {
      label674:
      float f4;
      float f3;
      if (k != 0)
      {
        f4 = i / 2.0F / n;
        f1 = 1.0F - f4;
        f3 = j / 2.0F / m;
        f2 = 1.0F - f3;
      }
      for (;;)
      {
        localObject1[0] = f4;
        localObject1[1] = f2;
        localObject1[2] = f1;
        localObject1[3] = f2;
        localObject1[4] = f4;
        localObject1[5] = f3;
        localObject1[6] = f1;
        localObject1[7] = f3;
        this.eYu.put(com.tencent.mm.media.i.b.eZr);
        this.eYu.position(0);
        this.eYu.put((float[])localObject1);
        this.eYu.position(0);
        this.eYv.position(0);
        break;
        k = 0;
        break label606;
        label810:
        m = this.eYj;
        break label617;
        label819:
        n = this.eYk;
        break label628;
        label828:
        if (f1 <= f2) {
          break label1555;
        }
        i = n - (int)(this.eYm / f1);
        j = 0;
        break label674;
        f4 = j / 2.0F / m;
        f3 = i / 2.0F / n;
        f2 = 1.0F - f3;
        f1 = 1.0F - f4;
      }
      if ((this.scaleType != 3) || (this.eYq == null)) {
        break;
      }
      localObject1 = com.tencent.mm.media.i.b.eZr;
      Object localObject2 = Arrays.copyOf((float[])localObject1, localObject1.length);
      localObject1 = this.eYq;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((Rect)localObject1).width());
        label937:
        if (localObject1 == null) {
          j.ebi();
        }
        i = ((Integer)localObject1).intValue();
        localObject1 = this.eYq;
        if (localObject1 == null) {
          break label1166;
        }
        localObject1 = Integer.valueOf(((Rect)localObject1).height());
        label973:
        if (localObject1 == null) {
          j.ebi();
        }
        j = ((Integer)localObject1).intValue();
        localObject1 = this.eYq;
        if ((localObject1 == null) || (((Rect)localObject1).left != 0)) {
          break label1172;
        }
        f2 = (this.eYj - i) / this.eYj;
        f1 = 1.0F - f2;
        label1026:
        localObject1 = this.eYq;
        if ((localObject1 == null) || (((Rect)localObject1).top != 0)) {
          break label1194;
        }
        f3 = (this.eYk - j) / this.eYk;
        f4 = 1.0F - f3;
      }
      for (;;)
      {
        localObject2[0] = f2;
        localObject2[1] = f3;
        localObject2[2] = f1;
        localObject2[3] = f3;
        localObject2[4] = f2;
        localObject2[5] = f4;
        localObject2[6] = f1;
        localObject2[7] = f4;
        this.eYu.put(com.tencent.mm.media.i.b.eZr);
        this.eYu.position(0);
        this.eYu.put((float[])localObject2);
        this.eYu.position(0);
        this.eYv.position(0);
        break;
        localObject1 = null;
        break label937;
        label1166:
        localObject1 = null;
        break label973;
        label1172:
        f1 = (this.eYj - i) / this.eYj;
        f2 = 1.0F - f1;
        break label1026;
        label1194:
        f4 = (this.eYk - j) / this.eYk;
        f3 = 1.0F - f4;
      }
      label1218:
      i = this.eYF;
      break label307;
      label1227:
      j = this.eYG;
      break label320;
      label1236:
      Matrix.scaleM(this.eYz, 0, 1.0F, -1.0F, 1.0F);
      break label397;
      label1252:
      GLES20.glBindFramebuffer(36160, this.eYx);
      localObject1 = this.eYH;
      if (localObject1 != null) {
        ((IntBuffer)localObject1).clear();
      }
      GLES20.glReadPixels(0, 0, this.eYF, this.eYG, 6408, 5121, (Buffer)this.eYH);
      localObject1 = this.eYC;
      if (localObject1 != null)
      {
        localObject2 = this.eYH;
        if (localObject2 == null) {
          j.ebi();
        }
        ((a.f.a.b)localObject1).S(localObject2);
      }
      localObject1 = com.tencent.mm.media.i.b.eZw;
      b.a.Vo();
      ab.i("MicroMsg.GLTextureRenderProc", "takeSnapShot cost " + bo.av(l) + ", size:" + this.eYF + 'x' + this.eYG + "  rotate: " + this.eYe);
      this.eYD = false;
      return;
      label1419:
      if (this.eYn == 3)
      {
        if (this.eYy == null) {
          Vi();
        }
        localObject1 = this.eYy;
        if (localObject1 != null) {
          ((IntBuffer)localObject1).clear();
        }
        GLES20.glReadPixels(0, 0, this.eYl, this.eYm, 6408, 5121, (Buffer)this.eYy);
        GLES20.glFinish();
        localObject1 = this.eYC;
        if (localObject1 == null) {
          break label530;
        }
        localObject2 = this.eYy;
        if (localObject2 == null) {
          j.ebi();
        }
        ((a.f.a.b)localObject1).S(localObject2);
        return;
      }
      if (this.eYn != 2) {
        break label530;
      }
      localObject1 = this.eYB;
      if (localObject1 == null) {
        break label530;
      }
      ((a.f.a.b)localObject1).S(Integer.valueOf(this.eYw));
      return;
      label1555:
      i = 0;
      j = 0;
    }
  }
  
  protected abstract void Vj();
  
  public final void cn(int paramInt1, int paramInt2)
  {
    this.eYm = paramInt2;
    this.eYl = paramInt1;
    ab.i("MicroMsg.GLTextureRenderProc", "setSnapshotSize:" + paramInt1 + " x " + paramInt2);
    this.eYF = paramInt1;
    this.eYG = paramInt2;
    if (this.eYn == 3) {
      Vi();
    }
  }
  
  public void jY(int paramInt) {}
  
  public void release()
  {
    if (this.eYw != 0) {
      GLES20.glDeleteTextures(1, new int[] { this.eYw }, 0);
    }
    if (this.eYx != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { this.eYx }, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.h.b.a
 * JD-Core Version:    0.7.0.1
 */