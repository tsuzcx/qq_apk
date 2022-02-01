package com.tencent.mm.media.i.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getGlTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBByteBufferAvailableListener", "Ljava/nio/ByteBuffer;", "buffer", "getOnRGBByteBufferAvailableListener", "setOnRGBByteBufferAvailableListener", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "snapShotBuffer", "getSnapShotBuffer", "setSnapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "getValidLeftTopPoint", "()Landroid/graphics/Point;", "setValidLeftTopPoint", "(Landroid/graphics/Point;)V", "validRightBottomPoint", "getValidRightBottomPoint", "setValidRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "fitCenter", "aspectPlane", "", "aspectTexture", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getOutputTextureObj", "getRotate", "getSnapshotOutputByteBuffer", "getTextureCropRect", "getValidTextureArea", "Landroid/graphics/RectF;", "initDrawCoordBuffer", "initMatrix", "initWithoutMatrix", "array", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "width", "height", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateRenderTypeStatus", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a gvj = new a.a((byte)0);
  public int guD;
  public boolean guE;
  protected int guI;
  protected int guJ;
  protected int guK;
  protected int guL;
  protected int guM;
  public Rect guP;
  protected FloatBuffer guS;
  protected FloatBuffer guT;
  public d guU;
  protected com.tencent.mm.media.f.a guV;
  private ByteBuffer guW;
  protected float[] guX;
  public boolean guY;
  public b<? super d, y> guZ;
  public b<? super IntBuffer, y> gva;
  public b<? super ByteBuffer, y> gvb;
  public volatile boolean gvc;
  private boolean gvd;
  public int gve;
  public int gvf;
  public ByteBuffer gvg;
  public Point gvh;
  public Point gvi;
  protected final int scaleType;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.guI = paramInt1;
    this.guJ = paramInt2;
    this.guK = paramInt3;
    this.guL = paramInt4;
    this.guM = paramInt5;
    this.scaleType = paramInt6;
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.guS = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gwe.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.guT = ((FloatBuffer)localObject);
    this.guX = new float[16];
    this.gve = -1;
    this.gvf = -1;
    this.gvh = new Point(0, this.guJ);
    this.gvi = new Point(this.guI, 0);
    if (this.guM == 2)
    {
      this.guU = com.tencent.mm.media.f.c.a(true, 3L);
      localObject = com.tencent.mm.media.f.c.grn;
      this.guV = com.tencent.mm.media.f.c.lC(3L);
    }
    while (this.guM != 3) {
      return;
    }
    aks();
  }
  
  private void aks()
  {
    if ((this.guK > 0) && (this.guL > 0) && (this.guW == null)) {
      this.guW = ByteBuffer.allocateDirect(this.guK * this.guL * 4).order(ByteOrder.nativeOrder());
    }
  }
  
  public void U(byte[] paramArrayOfByte)
  {
    k.h(paramArrayOfByte, "frame");
  }
  
  public final void akk()
  {
    akt();
    akv();
    aku();
  }
  
  public final IntBuffer akl()
  {
    ByteBuffer localByteBuffer = this.guW;
    if (localByteBuffer != null) {
      return localByteBuffer.asIntBuffer();
    }
    return null;
  }
  
  protected void akt()
  {
    Matrix.setIdentityM(this.guX, 0);
    Matrix.setRotateM(this.guX, 0, this.guD, 0.0F, 0.0F, -1.0F);
    float f3;
    float f4;
    float f1;
    float f2;
    if ((this.guY) || (this.guM == 3)) {
      if ((this.guD == 90) || (this.guD == 270))
      {
        Matrix.scaleM(this.guX, 0, -1.0F, 1.0F, 1.0F);
        if (this.guE) {
          Matrix.scaleM(this.guX, 0, 1.0F, -1.0F, 1.0F);
        }
        if (this.scaleType == 5)
        {
          f3 = this.guK / this.guL;
          f4 = this.guI / this.guJ;
          if (f4 <= f3) {
            break label458;
          }
          f1 = -1.0F;
          f2 = 1.0F;
          f4 /= f3;
          f3 = -f4;
          label149:
          Matrix.orthoM(this.guX, 0, f1, f2, f3, f4, 1.0F, -1.0F);
        }
        fQF();
        Object localObject;
        if (this.guM == 2)
        {
          if (this.guU == null)
          {
            this.guU = com.tencent.mm.media.f.c.a(true, 3L);
            localObject = com.tencent.mm.media.f.c.grn;
            this.guV = com.tencent.mm.media.f.c.lC(3L);
          }
          localObject = com.tencent.mm.media.j.c.gwl;
          c.a.a(this.guV, this.guU, this.guK, this.guL);
        }
        GLES20.glViewport(0, 0, this.guK, this.guL);
        if (this.gvc)
        {
          if (this.guU == null)
          {
            this.guU = com.tencent.mm.media.f.c.a(true, 3L);
            localObject = com.tencent.mm.media.f.c.grn;
            this.guV = com.tencent.mm.media.f.c.lC(3L);
          }
          localObject = com.tencent.mm.media.j.c.gwl;
          c.a.a(this.guV, this.guU, this.gve, this.gvf);
          GLES20.glViewport(0, 0, this.gve, this.gvf);
          if ((this.guD != 90) && (this.guD != 270)) {
            break label477;
          }
          Matrix.scaleM(this.guX, 0, -1.0F, 1.0F, 1.0F);
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.GLTextureRenderProc", "rotateDegree " + this.guD + "  transformMatrix:" + this.guX + " snapShotWidth:" + this.gve + " snapShotHeight:" + this.gvf);
      this.gvd = true;
      return;
      Matrix.scaleM(this.guX, 0, 1.0F, -1.0F, 1.0F);
      break;
      Matrix.scaleM(this.guX, 0, 1.0F, 1.0F, 1.0F);
      break;
      label458:
      f1 = -f3 / f4;
      f2 = -f1;
      f4 = 1.0F;
      f3 = -1.0F;
      break label149;
      label477:
      Matrix.scaleM(this.guX, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  protected void aku()
  {
    Object localObject1 = null;
    Object localObject2;
    if ((this.gvc) && (this.gvd))
    {
      long l = bt.GC();
      this.gvd = false;
      if ((this.gvg == null) && (this.gve > 0) && (this.gvf > 0) && (this.gvg == null)) {
        this.gvg = ByteBuffer.allocateDirect(this.gve * this.gvf * 4).order(ByteOrder.nativeOrder());
      }
      if (this.gvg == null)
      {
        this.gvc = false;
        return;
      }
      ad.i("MicroMsg.GLTextureRenderProc", hashCode() + " after render takeSnapshot, renderOutputTextureFbo:" + this.guV + ", renderOutputTexture:" + this.guU);
      localObject2 = this.guV;
      if (localObject2 != null) {
        GLES20.glBindFramebuffer(36160, ((com.tencent.mm.media.f.a)localObject2).grh);
      }
      localObject2 = this.gvg;
      if (localObject2 != null) {
        ((ByteBuffer)localObject2).position(0);
      }
      GLES20.glReadPixels(0, 0, this.gve, this.gvf, 6408, 5121, (Buffer)this.gvg);
      GLES20.glFinish();
      localObject2 = this.gvb;
      ByteBuffer localByteBuffer;
      if (localObject2 != null)
      {
        localByteBuffer = this.gvg;
        if (localByteBuffer == null) {
          k.fvU();
        }
        ((b)localObject2).aA(localByteBuffer);
      }
      localObject2 = this.gva;
      if (localObject2 != null)
      {
        localByteBuffer = this.gvg;
        if (localByteBuffer != null) {
          localObject1 = localByteBuffer.asIntBuffer();
        }
        if (localObject1 == null) {
          k.fvU();
        }
        ((b)localObject2).aA(localObject1);
      }
      localObject1 = com.tencent.mm.media.j.c.gwl;
      c.a.akz();
      ad.i("MicroMsg.GLTextureRenderProc", hashCode() + " takeSnapShot cost " + bt.aS(l) + ", size:" + this.gve + 'x' + this.gvf + "  rotate: " + this.guD);
      this.gvc = false;
      return;
    }
    if (this.guM == 3)
    {
      if (this.guW == null) {
        aks();
      }
      if (this.guW != null)
      {
        localObject1 = this.guW;
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).clear();
        }
        GLES20.glReadPixels(0, 0, this.guK, this.guL, 6408, 5121, (Buffer)this.guW);
        GLES20.glFinish();
        localObject2 = this.gva;
        if (localObject2 != null)
        {
          localObject1 = this.guW;
          if (localObject1 == null) {
            break label496;
          }
          localObject1 = ((ByteBuffer)localObject1).asIntBuffer();
          if (localObject1 == null) {
            k.fvU();
          }
          ((b)localObject2).aA(localObject1);
        }
      }
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES30.glBindFramebuffer(36160, 0);
      return;
      label496:
      localObject1 = null;
      break;
      if (this.guM == 2)
      {
        GLES20.glBindFramebuffer(36160, 0);
        localObject1 = this.guZ;
        if (localObject1 != null) {
          ((b)localObject1).aA(this.guU);
        }
      }
    }
  }
  
  protected abstract void akv();
  
  public void cS(int paramInt1, int paramInt2)
  {
    this.guI = paramInt1;
    this.guJ = paramInt2;
    this.gvh.x = 0;
    this.gvh.y = paramInt2;
    this.gvi.x = paramInt1;
    this.gvi.y = 0;
  }
  
  public void cT(int paramInt1, int paramInt2)
  {
    this.guL = paramInt2;
    this.guK = paramInt1;
    cU(paramInt1, paramInt2);
    if (this.guM == 3) {
      aks();
    }
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.GLTextureRenderProc", "setSnapshotSize:" + paramInt1 + " x " + paramInt2);
    this.gve = paramInt1;
    this.gvf = paramInt2;
  }
  
  protected final RectF fQE()
  {
    return new RectF(this.gvh.x / this.guI, (this.gvh.y - 1.0F) / this.guJ, (this.gvi.x - 1.0F) / this.guI, this.gvi.y / this.guJ);
  }
  
  protected void fQF()
  {
    Object localObject1 = fQE();
    float f6 = ((RectF)localObject1).left;
    float f4 = ((RectF)localObject1).top;
    float f7 = ((RectF)localObject1).right;
    float f5 = ((RectF)localObject1).bottom;
    if ((this.scaleType == 1) || (this.scaleType == 5))
    {
      this.guS.position(0);
      this.guS.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
      this.guS.position(0);
    }
    for (;;)
    {
      this.guT.position(0);
      this.guT.put(com.tencent.mm.media.j.c.gwe);
      this.guT.position(0);
      return;
      int i;
      label197:
      int j;
      label240:
      label245:
      float f8;
      float f9;
      float f3;
      float f2;
      float f1;
      if (this.scaleType == 2)
      {
        localObject1 = com.tencent.mm.media.j.c.gwf;
        localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
        int k;
        int m;
        if ((this.guD == 90) || (this.guD == 270))
        {
          i = 1;
          j = this.gvi.x - this.gvh.x;
          k = this.gvh.y - this.gvi.y;
          if (i == 0) {
            break label453;
          }
          m = k;
          if (i == 0) {
            break label460;
          }
          f8 = this.guK / m;
          f9 = this.guL / j;
          f3 = 0.0F;
          f2 = 0.0F;
          if (f8 >= f9) {
            break label467;
          }
          f1 = m - this.guK / f9;
          label292:
          this.gve = (m - (int)f1);
          this.gvf = (j - (int)f2);
          if (i == 0) {
            break label495;
          }
          f2 = f2 / 2.0F / j;
        }
        for (f1 = f1 / 2.0F / m;; f1 = f3)
        {
          f3 = f6 + f2;
          f2 = f7 - f2;
          f5 += f1;
          f1 = f4 - f1;
          localObject1[0] = f3;
          localObject1[1] = f1;
          localObject1[2] = f2;
          localObject1[3] = f1;
          localObject1[4] = f3;
          localObject1[5] = f5;
          localObject1[6] = f2;
          localObject1[7] = f5;
          this.guS.put(com.tencent.mm.media.j.c.gwf);
          this.guS.position(0);
          this.guS.put((float[])localObject1);
          this.guS.position(0);
          this.guT.position(0);
          break;
          i = 0;
          break label197;
          label453:
          m = j;
          break label240;
          label460:
          j = k;
          break label245;
          label467:
          f1 = f3;
          if (f8 <= f9) {
            break label292;
          }
          f2 = j - this.guL / f8;
          f1 = f3;
          break label292;
          label495:
          f1 = f1 / 2.0F / m;
          f3 = f2 / 2.0F / j;
          f2 = f1;
        }
      }
      Object localObject2;
      if (this.scaleType == 3)
      {
        if (this.guP != null)
        {
          localObject1 = com.tencent.mm.media.j.c.gwf;
          localObject2 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject1 = this.guP;
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((Rect)localObject1).width());
            label569:
            if (localObject1 == null) {
              k.fvU();
            }
            i = ((Integer)localObject1).intValue();
            localObject1 = this.guP;
            if (localObject1 == null) {
              break label798;
            }
            localObject1 = Integer.valueOf(((Rect)localObject1).height());
            label605:
            if (localObject1 == null) {
              k.fvU();
            }
            j = ((Integer)localObject1).intValue();
            localObject1 = this.guP;
            if ((localObject1 == null) || (((Rect)localObject1).left != 0)) {
              break label804;
            }
            f2 = (this.guI - i) / this.guI;
            f1 = 1.0F - f2;
            label658:
            localObject1 = this.guP;
            if ((localObject1 == null) || (((Rect)localObject1).top != 0)) {
              break label826;
            }
            f3 = (this.guJ - j) / this.guJ;
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
            this.guS.put(com.tencent.mm.media.j.c.gwf);
            this.guS.position(0);
            this.guS.put((float[])localObject2);
            this.guS.position(0);
            this.guT.position(0);
            break;
            localObject1 = null;
            break label569;
            label798:
            localObject1 = null;
            break label605;
            label804:
            f1 = (this.guI - i) / this.guI;
            f2 = 1.0F - f1;
            break label658;
            label826:
            f4 = (this.guJ - j) / this.guJ;
            f3 = 1.0F - f4;
          }
        }
        this.guS.position(0);
        this.guS.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
        this.guS.position(0);
      }
      else if (this.scaleType == 4)
      {
        if (this.guP != null)
        {
          localObject1 = com.tencent.mm.media.j.c.gwf;
          localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject2 = a.b.KBF;
          i = this.guI;
          j = this.guJ;
          localObject2 = this.guP;
          if (localObject2 == null) {
            k.fvU();
          }
          f9 = a.b.ae(((Rect)localObject2).left / i);
          localObject2 = this.guP;
          if (localObject2 == null) {
            k.fvU();
          }
          f8 = a.b.ae(((Rect)localObject2).right / i);
          localObject2 = this.guP;
          if (localObject2 == null) {
            k.fvU();
          }
          f2 = a.b.ae(((Rect)localObject2).bottom / j);
          localObject2 = this.guP;
          if (localObject2 == null) {
            k.fvU();
          }
          f1 = a.b.ae(((Rect)localObject2).top / j);
          float f10 = Math.abs(f7 - f6);
          f3 = Math.abs(f5 - f4);
          f7 = f9 * f10 + f6;
          f6 = f8 * f10 + f6;
          f2 = f2 * f3 + Math.min(f4, f5);
          f1 = f1 * f3 + Math.min(f4, f5);
          localObject1[0] = f7;
          localObject1[1] = f1;
          localObject1[2] = f6;
          localObject1[3] = f1;
          localObject1[4] = f7;
          localObject1[5] = f2;
          localObject1[6] = f6;
          localObject1[7] = f2;
          this.guS.put(com.tencent.mm.media.j.c.gwf);
          this.guS.position(0);
          this.guS.put((float[])localObject1);
          this.guS.position(0);
          this.guT.position(0);
        }
        else
        {
          this.guS.position(0);
          this.guS.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
          this.guS.position(0);
        }
      }
    }
  }
  
  public final float[] m(float[] paramArrayOfFloat)
  {
    k.h(paramArrayOfFloat, "array");
    c.a locala = com.tencent.mm.media.j.c.gwl;
    int i = this.guD;
    k.h(paramArrayOfFloat, "textureCoords");
    switch (i)
    {
    }
    for (;;)
    {
      if (this.guE)
      {
        locala = com.tencent.mm.media.j.c.gwl;
        k.h(paramArrayOfFloat, "textureCoords");
        paramArrayOfFloat[1] = (1.0F - paramArrayOfFloat[1]);
        paramArrayOfFloat[3] = (1.0F - paramArrayOfFloat[3]);
        paramArrayOfFloat[5] = (1.0F - paramArrayOfFloat[5]);
        paramArrayOfFloat[7] = (1.0F - paramArrayOfFloat[7]);
      }
      return paramArrayOfFloat;
      float f1 = paramArrayOfFloat[0];
      float f2 = paramArrayOfFloat[1];
      paramArrayOfFloat[0] = paramArrayOfFloat[4];
      paramArrayOfFloat[1] = paramArrayOfFloat[5];
      paramArrayOfFloat[4] = paramArrayOfFloat[6];
      paramArrayOfFloat[5] = paramArrayOfFloat[7];
      paramArrayOfFloat[6] = paramArrayOfFloat[2];
      paramArrayOfFloat[7] = paramArrayOfFloat[3];
      paramArrayOfFloat[2] = f1;
      paramArrayOfFloat[3] = f2;
      continue;
      c.a.swap(paramArrayOfFloat, 0, 6);
      c.a.swap(paramArrayOfFloat, 1, 7);
      c.a.swap(paramArrayOfFloat, 2, 4);
      c.a.swap(paramArrayOfFloat, 3, 5);
      continue;
      f1 = paramArrayOfFloat[0];
      f2 = paramArrayOfFloat[1];
      paramArrayOfFloat[0] = paramArrayOfFloat[2];
      paramArrayOfFloat[1] = paramArrayOfFloat[3];
      paramArrayOfFloat[2] = paramArrayOfFloat[6];
      paramArrayOfFloat[3] = paramArrayOfFloat[7];
      paramArrayOfFloat[6] = paramArrayOfFloat[4];
      paramArrayOfFloat[7] = paramArrayOfFloat[5];
      paramArrayOfFloat[4] = f1;
      paramArrayOfFloat[5] = f2;
    }
  }
  
  public void mA(int paramInt) {}
  
  public void mz(int paramInt)
  {
    this.guD = paramInt;
  }
  
  public void release()
  {
    ad.i("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.guU + ", renderOutputTextureFbo:" + this.guV + ", drawWidth:" + this.guK + ", drawHeight:" + this.guL);
    Object localObject = this.guU;
    if (localObject != null) {
      ((d)localObject).close();
    }
    localObject = this.guV;
    if (localObject != null) {
      ((com.tencent.mm.media.f.a)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.a
 * JD-Core Version:    0.7.0.1
 */