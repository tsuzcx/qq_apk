package com.tencent.mm.media.i.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getGlTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBByteBufferAvailableListener", "Ljava/nio/ByteBuffer;", "buffer", "getOnRGBByteBufferAvailableListener", "setOnRGBByteBufferAvailableListener", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "snapShotBuffer", "getSnapShotBuffer", "setSnapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "getValidLeftTopPoint", "()Landroid/graphics/Point;", "setValidLeftTopPoint", "(Landroid/graphics/Point;)V", "validRightBottomPoint", "getValidRightBottomPoint", "setValidRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "fitCenter", "aspectPlane", "", "aspectTexture", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getOutputTextureObj", "getRotate", "getSnapshotOutputByteBuffer", "getTextureCropRect", "getValidTextureArea", "Landroid/graphics/RectF;", "initDrawCoordBuffer", "initMatrix", "initWithoutMatrix", "array", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "width", "height", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateRenderTypeStatus", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a gVG = new a.a((byte)0);
  private boolean gVA;
  public int gVB;
  public int gVC;
  public ByteBuffer gVD;
  public Point gVE;
  public Point gVF;
  public int gVh;
  public boolean gVi;
  protected int gVm;
  public Rect gVo;
  public d gVr;
  protected com.tencent.mm.media.f.a gVs;
  private ByteBuffer gVt;
  protected float[] gVu;
  public boolean gVv;
  private b<? super d, y> gVw;
  public b<? super IntBuffer, y> gVx;
  public b<? super ByteBuffer, y> gVy;
  public volatile boolean gVz;
  protected int gqZ;
  protected FloatBuffer grD;
  protected FloatBuffer grE;
  protected int grV;
  protected int grW;
  protected int gra;
  protected final int scaleType;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.gqZ = paramInt1;
    this.gra = paramInt2;
    this.grV = paramInt3;
    this.grW = paramInt4;
    this.gVm = paramInt5;
    this.scaleType = paramInt6;
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.grD = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gWC.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.grE = ((FloatBuffer)localObject);
    this.gVu = new float[16];
    this.gVB = -1;
    this.gVC = -1;
    this.gVE = new Point(0, this.gra);
    this.gVF = new Point(this.gqZ, 0);
    if (this.gVm == 2)
    {
      this.gVr = com.tencent.mm.media.f.c.a(true, 3L);
      localObject = com.tencent.mm.media.f.c.gRV;
      this.gVs = com.tencent.mm.media.f.c.pq(3L);
    }
    while (this.gVm != 3) {
      return;
    }
    arn();
  }
  
  private void arn()
  {
    if ((this.grV > 0) && (this.grW > 0) && (this.gVt == null)) {
      this.gVt = ByteBuffer.allocateDirect(this.grV * this.grW * 4).order(ByteOrder.nativeOrder());
    }
  }
  
  public void T(byte[] paramArrayOfByte)
  {
    k.h(paramArrayOfByte, "frame");
  }
  
  protected void ajE()
  {
    Matrix.setIdentityM(this.gVu, 0);
    Matrix.setRotateM(this.gVu, 0, this.gVh, 0.0F, 0.0F, -1.0F);
    float f3;
    float f4;
    float f1;
    float f2;
    if ((this.gVv) || (this.gVm == 3)) {
      if ((this.gVh == 90) || (this.gVh == 270))
      {
        Matrix.scaleM(this.gVu, 0, -1.0F, 1.0F, 1.0F);
        if (this.gVi) {
          Matrix.scaleM(this.gVu, 0, 1.0F, -1.0F, 1.0F);
        }
        if (this.scaleType == 5)
        {
          f3 = this.grV / this.grW;
          f4 = this.gqZ / this.gra;
          if (f4 <= f3) {
            break label458;
          }
          f1 = -1.0F;
          f2 = 1.0F;
          f4 /= f3;
          f3 = -f4;
          label149:
          Matrix.orthoM(this.gVu, 0, f1, f2, f3, f4, 1.0F, -1.0F);
        }
        arp();
        Object localObject;
        if (this.gVm == 2)
        {
          if (this.gVr == null)
          {
            this.gVr = com.tencent.mm.media.f.c.a(true, 3L);
            localObject = com.tencent.mm.media.f.c.gRV;
            this.gVs = com.tencent.mm.media.f.c.pq(3L);
          }
          localObject = com.tencent.mm.media.j.c.gWJ;
          c.a.a(this.gVs, this.gVr, this.grV, this.grW);
        }
        GLES20.glViewport(0, 0, this.grV, this.grW);
        if (this.gVz)
        {
          if (this.gVr == null)
          {
            this.gVr = com.tencent.mm.media.f.c.a(true, 3L);
            localObject = com.tencent.mm.media.f.c.gRV;
            this.gVs = com.tencent.mm.media.f.c.pq(3L);
          }
          localObject = com.tencent.mm.media.j.c.gWJ;
          c.a.a(this.gVs, this.gVr, this.gVB, this.gVC);
          GLES20.glViewport(0, 0, this.gVB, this.gVC);
          if ((this.gVh != 90) && (this.gVh != 270)) {
            break label477;
          }
          Matrix.scaleM(this.gVu, 0, -1.0F, 1.0F, 1.0F);
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.GLTextureRenderProc", "rotateDegree " + this.gVh + "  transformMatrix:" + this.gVu + " snapShotWidth:" + this.gVB + " snapShotHeight:" + this.gVC);
      this.gVA = true;
      return;
      Matrix.scaleM(this.gVu, 0, 1.0F, -1.0F, 1.0F);
      break;
      Matrix.scaleM(this.gVu, 0, 1.0F, 1.0F, 1.0F);
      break;
      label458:
      f1 = -f3 / f4;
      f2 = -f1;
      f4 = 1.0F;
      f3 = -1.0F;
      break label149;
      label477:
      Matrix.scaleM(this.gVu, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  public final void ajG()
  {
    ajE();
    arr();
    arq();
  }
  
  public final IntBuffer arh()
  {
    ByteBuffer localByteBuffer = this.gVt;
    if (localByteBuffer != null) {
      return localByteBuffer.asIntBuffer();
    }
    return null;
  }
  
  protected final RectF aro()
  {
    return new RectF(this.gVE.x / this.gqZ, (this.gVE.y - 1.0F) / this.gra, (this.gVF.x - 1.0F) / this.gqZ, this.gVF.y / this.gra);
  }
  
  protected void arp()
  {
    Object localObject1 = aro();
    float f6 = ((RectF)localObject1).left;
    float f4 = ((RectF)localObject1).top;
    float f7 = ((RectF)localObject1).right;
    float f5 = ((RectF)localObject1).bottom;
    if ((this.scaleType == 1) || (this.scaleType == 5))
    {
      this.grD.position(0);
      this.grD.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
      this.grD.position(0);
    }
    for (;;)
    {
      this.grE.position(0);
      this.grE.put(com.tencent.mm.media.j.c.gWC);
      this.grE.position(0);
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
        localObject1 = com.tencent.mm.media.j.c.gWD;
        localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
        int k;
        int m;
        if ((this.gVh == 90) || (this.gVh == 270))
        {
          i = 1;
          j = this.gVF.x - this.gVE.x;
          k = this.gVE.y - this.gVF.y;
          if (i == 0) {
            break label453;
          }
          m = k;
          if (i == 0) {
            break label460;
          }
          f8 = this.grV / m;
          f9 = this.grW / j;
          f3 = 0.0F;
          f2 = 0.0F;
          if (f8 >= f9) {
            break label467;
          }
          f1 = m - this.grV / f9;
          label292:
          this.gVB = (m - (int)f1);
          this.gVC = (j - (int)f2);
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
          this.grD.put(com.tencent.mm.media.j.c.gWD);
          this.grD.position(0);
          this.grD.put((float[])localObject1);
          this.grD.position(0);
          this.grE.position(0);
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
          f2 = j - this.grW / f8;
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
        if (this.gVo != null)
        {
          localObject1 = com.tencent.mm.media.j.c.gWD;
          localObject2 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject1 = this.gVo;
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((Rect)localObject1).width());
            label569:
            if (localObject1 == null) {
              k.fOy();
            }
            i = ((Integer)localObject1).intValue();
            localObject1 = this.gVo;
            if (localObject1 == null) {
              break label798;
            }
            localObject1 = Integer.valueOf(((Rect)localObject1).height());
            label605:
            if (localObject1 == null) {
              k.fOy();
            }
            j = ((Integer)localObject1).intValue();
            localObject1 = this.gVo;
            if ((localObject1 == null) || (((Rect)localObject1).left != 0)) {
              break label804;
            }
            f2 = (this.gqZ - i) / this.gqZ;
            f1 = 1.0F - f2;
            label658:
            localObject1 = this.gVo;
            if ((localObject1 == null) || (((Rect)localObject1).top != 0)) {
              break label826;
            }
            f3 = (this.gra - j) / this.gra;
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
            this.grD.put(com.tencent.mm.media.j.c.gWD);
            this.grD.position(0);
            this.grD.put((float[])localObject2);
            this.grD.position(0);
            this.grE.position(0);
            break;
            localObject1 = null;
            break label569;
            label798:
            localObject1 = null;
            break label605;
            label804:
            f1 = (this.gqZ - i) / this.gqZ;
            f2 = 1.0F - f1;
            break label658;
            label826:
            f4 = (this.gra - j) / this.gra;
            f3 = 1.0F - f4;
          }
        }
        this.grD.position(0);
        this.grD.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
        this.grD.position(0);
      }
      else if (this.scaleType == 4)
      {
        if (this.gVo != null)
        {
          localObject1 = com.tencent.mm.media.j.c.gWD;
          localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject2 = a.b.gVH;
          i = this.gqZ;
          j = this.gra;
          localObject2 = this.gVo;
          if (localObject2 == null) {
            k.fOy();
          }
          f9 = a.b.ai(((Rect)localObject2).left / i);
          localObject2 = this.gVo;
          if (localObject2 == null) {
            k.fOy();
          }
          f8 = a.b.ai(((Rect)localObject2).right / i);
          localObject2 = this.gVo;
          if (localObject2 == null) {
            k.fOy();
          }
          f2 = a.b.ai(((Rect)localObject2).bottom / j);
          localObject2 = this.gVo;
          if (localObject2 == null) {
            k.fOy();
          }
          f1 = a.b.ai(((Rect)localObject2).top / j);
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
          this.grD.put(com.tencent.mm.media.j.c.gWD);
          this.grD.position(0);
          this.grD.put((float[])localObject1);
          this.grD.position(0);
          this.grE.position(0);
        }
        else
        {
          this.grD.position(0);
          this.grD.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
          this.grD.position(0);
        }
      }
    }
  }
  
  protected void arq()
  {
    Object localObject1 = null;
    Object localObject2;
    if ((this.gVz) && (this.gVA))
    {
      long l = bs.Gn();
      this.gVA = false;
      if ((this.gVD == null) && (this.gVB > 0) && (this.gVC > 0) && (this.gVD == null)) {
        this.gVD = ByteBuffer.allocateDirect(this.gVB * this.gVC * 4).order(ByteOrder.nativeOrder());
      }
      if (this.gVD == null)
      {
        this.gVz = false;
        return;
      }
      ac.i("MicroMsg.GLTextureRenderProc", hashCode() + " after render takeSnapshot, renderOutputTextureFbo:" + this.gVs + ", renderOutputTexture:" + this.gVr);
      localObject2 = this.gVs;
      if (localObject2 != null) {
        GLES20.glBindFramebuffer(36160, ((com.tencent.mm.media.f.a)localObject2).gRP);
      }
      localObject2 = this.gVD;
      if (localObject2 != null) {
        ((ByteBuffer)localObject2).position(0);
      }
      GLES20.glReadPixels(0, 0, this.gVB, this.gVC, 6408, 5121, (Buffer)this.gVD);
      GLES20.glFinish();
      localObject2 = this.gVy;
      ByteBuffer localByteBuffer;
      if (localObject2 != null)
      {
        localByteBuffer = this.gVD;
        if (localByteBuffer == null) {
          k.fOy();
        }
        ((b)localObject2).ay(localByteBuffer);
      }
      localObject2 = this.gVx;
      if (localObject2 != null)
      {
        localByteBuffer = this.gVD;
        if (localByteBuffer != null) {
          localObject1 = localByteBuffer.asIntBuffer();
        }
        if (localObject1 == null) {
          k.fOy();
        }
        ((b)localObject2).ay(localObject1);
      }
      localObject1 = com.tencent.mm.media.j.c.gWJ;
      c.a.art();
      ac.i("MicroMsg.GLTextureRenderProc", hashCode() + " takeSnapShot cost " + bs.aO(l) + ", size:" + this.gVB + 'x' + this.gVC + "  rotate: " + this.gVh);
      this.gVz = false;
      return;
    }
    if (this.gVm == 3)
    {
      if (this.gVt == null) {
        arn();
      }
      if (this.gVt != null)
      {
        localObject1 = this.gVt;
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).clear();
        }
        GLES20.glReadPixels(0, 0, this.grV, this.grW, 6408, 5121, (Buffer)this.gVt);
        GLES20.glFinish();
        localObject2 = this.gVx;
        if (localObject2 != null)
        {
          localObject1 = this.gVt;
          if (localObject1 == null) {
            break label496;
          }
          localObject1 = ((ByteBuffer)localObject1).asIntBuffer();
          if (localObject1 == null) {
            k.fOy();
          }
          ((b)localObject2).ay(localObject1);
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
      if (this.gVm == 2)
      {
        GLES20.glBindFramebuffer(36160, 0);
        localObject1 = this.gVw;
        if (localObject1 != null) {
          ((b)localObject1).ay(this.gVr);
        }
      }
    }
  }
  
  protected abstract void arr();
  
  public void cR(int paramInt1, int paramInt2)
  {
    this.grW = paramInt2;
    this.grV = paramInt1;
    cU(paramInt1, paramInt2);
    if (this.gVm == 3) {
      arn();
    }
  }
  
  public void cS(int paramInt1, int paramInt2)
  {
    this.gqZ = paramInt1;
    this.gra = paramInt2;
    this.gVE.x = 0;
    this.gVE.y = paramInt2;
    this.gVF.x = paramInt1;
    this.gVF.y = 0;
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.GLTextureRenderProc", "setSnapshotSize:" + paramInt1 + " x " + paramInt2);
    this.gVB = paramInt1;
    this.gVC = paramInt2;
  }
  
  public final float[] m(float[] paramArrayOfFloat)
  {
    k.h(paramArrayOfFloat, "array");
    c.a locala = com.tencent.mm.media.j.c.gWJ;
    int i = this.gVh;
    k.h(paramArrayOfFloat, "textureCoords");
    switch (i)
    {
    }
    for (;;)
    {
      if (this.gVi)
      {
        locala = com.tencent.mm.media.j.c.gWJ;
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
  
  public void mE(int paramInt)
  {
    this.gVh = paramInt;
  }
  
  public void no(int paramInt) {}
  
  public void release()
  {
    ac.i("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.gVr + ", renderOutputTextureFbo:" + this.gVs + ", drawWidth:" + this.grV + ", drawHeight:" + this.grW);
    Object localObject = this.gVr;
    if (localObject != null) {
      ((d)localObject).close();
    }
    localObject = this.gVs;
    if (localObject != null) {
      ((com.tencent.mm.media.f.a)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.b.a
 * JD-Core Version:    0.7.0.1
 */