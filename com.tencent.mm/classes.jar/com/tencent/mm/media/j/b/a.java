package com.tencent.mm.media.j.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getGlTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "needProfile", "getNeedProfile", "setNeedProfile", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBByteBufferAvailableListener", "Ljava/nio/ByteBuffer;", "buffer", "getOnRGBByteBufferAvailableListener", "setOnRGBByteBufferAvailableListener", "onRGBByteBufferAvailableWithSizeListener", "Lkotlin/Function3;", "width", "height", "getOnRGBByteBufferAvailableWithSizeListener", "()Lkotlin/jvm/functions/Function3;", "setOnRGBByteBufferAvailableWithSizeListener", "(Lkotlin/jvm/functions/Function3;)V", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderCost", "", "getRenderCost", "()J", "setRenderCost", "(J)V", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "snapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "snapshotBufferQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "snapshotCost", "getSnapshotCost", "setSnapshotCost", "snapshotDirectBuffer", "getSnapshotDirectBuffer", "setSnapshotDirectBuffer", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "getValidLeftTopPoint", "()Landroid/graphics/Point;", "setValidLeftTopPoint", "(Landroid/graphics/Point;)V", "validRightBottomPoint", "getValidRightBottomPoint", "setValidRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "fitCenter", "aspectPlane", "", "aspectTexture", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getOutputTextureObj", "getRotate", "getSnapshotOutputByteBuffer", "getTextureCropRect", "getValidTextureArea", "Landroid/graphics/RectF;", "initDrawCoordBuffer", "initMatrix", "initWithoutMatrix", "array", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateRenderTypeStatus", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a kYR = new a((byte)0);
  private float[] kYA;
  public boolean kYB;
  private b<? super d, x> kYC;
  public b<? super IntBuffer, x> kYD;
  public b<? super ByteBuffer, x> kYE;
  public q<? super ByteBuffer, ? super Integer, ? super Integer, x> kYF;
  public boolean kYG;
  public volatile boolean kYH;
  private boolean kYI;
  public int kYJ;
  public int kYK;
  private LinkedBlockingQueue<ByteBuffer> kYL;
  public ByteBuffer kYM;
  public Point kYN;
  public Point kYO;
  private long kYP;
  private boolean kYQ;
  private int kYg;
  public boolean kYh;
  private int kYm;
  private int kYn;
  public Rect kYu;
  public d kYx;
  private com.tencent.mm.media.g.a kYy;
  public ByteBuffer kYz;
  private int krg;
  private int krh;
  private FloatBuffer ksa;
  private FloatBuffer ksb;
  private int ksu;
  private int ksv;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.krg = paramInt1;
    this.krh = paramInt2;
    this.ksu = paramInt3;
    this.ksv = paramInt4;
    this.kYm = paramInt5;
    this.kYn = paramInt6;
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.ksa = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.laj.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.ksb = ((FloatBuffer)localObject);
    this.kYA = new float[16];
    this.kYG = true;
    this.kYJ = -1;
    this.kYK = -1;
    this.kYL = new LinkedBlockingQueue();
    this.kYN = new Point(0, this.krh);
    this.kYO = new Point(this.krg, 0);
    if (this.kYm == 2)
    {
      this.kYx = com.tencent.mm.media.g.c.a(true, 3L);
      localObject = com.tencent.mm.media.g.c.kVi;
      this.kYy = com.tencent.mm.media.g.c.FP(3L);
    }
    while (this.kYm != 3) {
      return;
    }
    aVq();
  }
  
  private void aVq()
  {
    if ((this.ksu > 0) && (this.ksv > 0) && (this.kYz == null)) {
      this.kYz = ByteBuffer.allocateDirect(this.ksu * this.ksv * 4).order(ByteOrder.nativeOrder());
    }
  }
  
  public final void G(float paramFloat1, float paramFloat2)
  {
    float f2;
    float f1;
    if (paramFloat2 > paramFloat1)
    {
      f2 = paramFloat2 / paramFloat1;
      f1 = -f2;
      paramFloat2 = 1.0F;
      paramFloat1 = -1.0F;
    }
    for (;;)
    {
      Matrix.orthoM(this.kYA, 0, paramFloat1, paramFloat2, f1, f2, 1.0F, -1.0F);
      return;
      paramFloat1 = -paramFloat1 / paramFloat2;
      paramFloat2 = -paramFloat1;
      f1 = -1.0F;
      f2 = 1.0F;
    }
  }
  
  protected final void a(com.tencent.mm.media.g.a parama)
  {
    this.kYy = parama;
  }
  
  protected void aMR()
  {
    Matrix.setIdentityM(this.kYA, 0);
    Matrix.setRotateM(this.kYA, 0, this.kYg, 0.0F, 0.0F, -1.0F);
    if ((this.kYB) || (this.kYm == 3)) {
      if ((this.kYg == 90) || (this.kYg == 270)) {
        Matrix.scaleM(this.kYA, 0, -1.0F, 1.0F, 1.0F);
      }
    }
    for (;;)
    {
      if (this.kYh) {
        Matrix.scaleM(this.kYA, 0, 1.0F, -1.0F, 1.0F);
      }
      if (this.kYn == 5) {
        G(this.ksu / this.ksv, this.krg / this.krh);
      }
      aVt();
      aVu();
      return;
      Matrix.scaleM(this.kYA, 0, 1.0F, -1.0F, 1.0F);
      continue;
      Matrix.scaleM(this.kYA, 0, 1.0F, 1.0F, 1.0F);
    }
  }
  
  public final void aMU()
  {
    aMR();
    if (this.kYQ) {
      GLES20.glFinish();
    }
    long l = Util.currentTicks();
    aVw();
    if (this.kYQ)
    {
      GLES20.glFinish();
      this.kYP = Util.ticksToNow(l);
    }
    aVv();
  }
  
  protected final FloatBuffer aVl()
  {
    return this.ksa;
  }
  
  protected final FloatBuffer aVm()
  {
    return this.ksb;
  }
  
  protected final com.tencent.mm.media.g.a aVn()
  {
    return this.kYy;
  }
  
  public final float[] aVo()
  {
    return this.kYA;
  }
  
  protected final int aVp()
  {
    return this.kYg;
  }
  
  public final int aVr()
  {
    return this.kYg;
  }
  
  protected final RectF aVs()
  {
    return new RectF(this.kYN.x / this.krg, (this.kYN.y - 1.0F) / this.krh, (this.kYO.x - 1.0F) / this.krg, this.kYO.y / this.krh);
  }
  
  protected void aVt()
  {
    int j;
    label30:
    int k;
    int m;
    int i;
    label73:
    label78:
    float f4;
    float f5;
    float f3;
    float f2;
    float f1;
    if (this.kYn == 2)
    {
      if ((this.kYg != 90) && (this.kYg != 270)) {
        break label450;
      }
      j = 1;
      k = this.kYO.x - this.kYN.x;
      m = this.kYN.y - this.kYO.y;
      if (j == 0) {
        break label456;
      }
      i = m;
      if (j == 0) {
        break label463;
      }
      f4 = this.ksu / i;
      f5 = this.ksv / k;
      f3 = 0.0F;
      f2 = 0.0F;
      if (f4 >= f5) {
        break label470;
      }
      f1 = i - this.ksu / f5;
    }
    Object localObject1;
    Object localObject2;
    Point localPoint;
    int n;
    int i1;
    float f6;
    for (;;)
    {
      this.kYJ = (i - (int)f1);
      this.kYK = (k - (int)f2);
      this.ksa.position(0);
      FloatBuffer localFloatBuffer = this.ksa;
      localObject1 = com.tencent.mm.media.j.c.a.lag;
      k = this.kYn;
      i = this.krg;
      j = this.krh;
      localObject2 = this.kYN;
      localPoint = this.kYO;
      m = this.kYg;
      n = this.ksu;
      i1 = this.ksv;
      localObject1 = this.kYu;
      p.k(localObject2, "textureValidLTPoint");
      p.k(localPoint, "textureValidRBPoint");
      float[] arrayOfFloat = Arrays.copyOf(com.tencent.mm.media.k.c.lak, com.tencent.mm.media.k.c.lak.length);
      p.j(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
      RectF localRectF = com.tencent.mm.media.j.c.a.a((Point)localObject2, localPoint, i, j);
      f6 = localRectF.left;
      f5 = localRectF.top;
      f4 = localRectF.right;
      f3 = localRectF.bottom;
      switch (k)
      {
      default: 
        f2 = f6;
        f1 = f5;
        label326:
        arrayOfFloat[0] = f2;
        arrayOfFloat[1] = f1;
        arrayOfFloat[2] = f4;
        arrayOfFloat[3] = f1;
        arrayOfFloat[4] = f2;
        arrayOfFloat[5] = f3;
        arrayOfFloat[6] = f4;
        arrayOfFloat[7] = f3;
        localFloatBuffer.put(arrayOfFloat);
        this.ksa.position(0);
        this.ksb.position(0);
        localFloatBuffer = this.ksb;
        localObject1 = com.tencent.mm.media.j.c.a.lag;
        localFloatBuffer.put(com.tencent.mm.media.j.c.a.a(this.kYn, this.kYN, this.kYO, this.kYg, this.ksu, this.ksv));
        this.ksb.position(0);
        return;
        label450:
        j = 0;
        break label30;
        label456:
        i = k;
        break label73;
        label463:
        k = m;
        break label78;
        label470:
        f1 = f3;
        if (f4 > f5)
        {
          f2 = k - this.ksv / f4;
          f1 = f3;
        }
        break;
      }
    }
    label516:
    label551:
    label556:
    float f7;
    if ((m == 90) || (m == 270))
    {
      i = 1;
      k = localPoint.x - ((Point)localObject2).x;
      m = ((Point)localObject2).y - localPoint.y;
      if (i == 0) {
        break label655;
      }
      j = m;
      if (i == 0) {
        break label662;
      }
      f1 = n / j;
      f7 = i1 / k;
      f2 = 0.0F;
      if (f1 >= f7) {
        break label669;
      }
      f2 = j - n / f7;
      f1 = 0.0F;
    }
    for (;;)
    {
      label595:
      if (i != 0)
      {
        f1 = f1 / 2.0F / k;
        f7 = f2 / 2.0F / j;
        f2 = f1;
      }
      for (f1 = f7;; f1 = f1 / 2.0F / k)
      {
        f6 += f2;
        f3 += f1;
        f4 -= f2;
        f1 = f5 - f1;
        f2 = f6;
        break;
        i = 0;
        break label516;
        label655:
        j = k;
        break label551;
        label662:
        k = m;
        break label556;
        label669:
        if (f1 <= f7) {
          break label963;
        }
        f1 = k - i1 / f1;
        break label595;
        f2 = f2 / 2.0F / j;
      }
      if (localObject1 == null) {
        break;
      }
      k = ((Rect)localObject1).width();
      m = ((Rect)localObject1).height();
      if (((Rect)localObject1).left == 0)
      {
        f1 = (i - k) / i;
        f4 = 1.0F - f1;
      }
      for (;;)
      {
        if (((Rect)localObject1).top != 0) {
          break label807;
        }
        f2 = (j - m) / j;
        f5 = 1.0F - f2;
        f3 = f1;
        f1 = f2;
        f2 = f3;
        f3 = f5;
        break;
        f4 = (i - k) / i;
        f1 = 1.0F - f4;
      }
      label807:
      f3 = (j - m) / j;
      f5 = 1.0F - f3;
      f2 = f1;
      f1 = f5;
      break label326;
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.media.j.c.a.a.lah;
      f2 = com.tencent.mm.media.j.c.a.a.au(((Rect)localObject1).left / i);
      float f9 = com.tencent.mm.media.j.c.a.a.au(((Rect)localObject1).right / i);
      f7 = com.tencent.mm.media.j.c.a.a.au(((Rect)localObject1).bottom / j);
      f1 = com.tencent.mm.media.j.c.a.a.au(((Rect)localObject1).top / j);
      f4 = Math.abs(f4 - f6);
      float f8 = Math.abs(f3 - f5);
      f2 = f6 + f2 * f4;
      f4 = f4 * f9 + f2;
      f3 = Math.min(f5, f3) + f8 * f7;
      f1 = Math.min(f5, f3) + f8 * f1;
      break label326;
      label963:
      f1 = 0.0F;
    }
  }
  
  protected final void aVu()
  {
    Object localObject;
    if (this.kYm == 2)
    {
      if (this.kYx == null)
      {
        this.kYx = com.tencent.mm.media.g.c.a(true, 3L);
        localObject = com.tencent.mm.media.g.c.kVi;
        this.kYy = com.tencent.mm.media.g.c.FP(3L);
      }
      localObject = com.tencent.mm.media.k.c.lar;
      c.a.a(this.kYy, this.kYx, this.ksu, this.ksv);
    }
    GLES20.glViewport(0, 0, this.ksu, this.ksv);
    if (this.kYH)
    {
      if (this.kYx == null)
      {
        this.kYx = com.tencent.mm.media.g.c.a(true, 3L);
        localObject = com.tencent.mm.media.g.c.kVi;
        this.kYy = com.tencent.mm.media.g.c.FP(3L);
      }
      localObject = com.tencent.mm.media.k.c.lar;
      c.a.a(this.kYy, this.kYx, this.kYJ, this.kYK);
      GLES20.glViewport(0, 0, this.kYJ, this.kYK);
      if ((this.kYg != 90) && (this.kYg != 270)) {
        break label189;
      }
      Matrix.scaleM(this.kYA, 0, -1.0F, 1.0F, 1.0F);
    }
    for (;;)
    {
      this.kYI = true;
      return;
      label189:
      Matrix.scaleM(this.kYA, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  protected void aVv()
  {
    Object localObject1;
    Object localObject2;
    if ((this.kYH) && (this.kYI))
    {
      Util.currentTicks();
      this.kYI = false;
      if ((this.kYL.size() < 2) && (this.kYJ > 0) && (this.kYK > 0) && (this.kYL.size() < 2))
      {
        if (this.kYG)
        {
          j = this.kYL.size();
          i = 0;
          while (i < 2 - j)
          {
            this.kYL.add(ByteBuffer.allocateDirect(this.kYJ * this.kYK * 4).order(ByteOrder.nativeOrder()));
            i += 1;
          }
        }
        int j = this.kYL.size();
        int i = 0;
        while (i < 2 - j)
        {
          this.kYL.add(ByteBuffer.allocate(this.kYJ * this.kYK * 4).order(ByteOrder.nativeOrder()));
          i += 1;
        }
      }
      if ((this.kYL.size() < 2) || (this.kYJ < 0) || (this.kYK < 0))
      {
        this.kYH = false;
        return;
      }
      localObject1 = this.kYy;
      if (localObject1 != null) {
        GLES20.glBindFramebuffer(36160, ((com.tencent.mm.media.g.a)localObject1).kVc);
      }
      b localb;
      if (this.kYL.size() > 0)
      {
        localObject1 = (ByteBuffer)this.kYL.remove();
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).position(0);
        }
        GLES20.glReadPixels(0, 0, this.kYJ, this.kYK, 6408, 5121, (Buffer)localObject1);
        GLES20.glFinish();
        localObject2 = this.kYE;
        if (localObject2 != null)
        {
          if (localObject1 == null) {
            p.iCn();
          }
          ((b)localObject2).invoke(localObject1);
        }
        localObject2 = this.kYF;
        if (localObject2 != null)
        {
          if (localObject1 == null) {
            p.iCn();
          }
          ((q)localObject2).c(localObject1, Integer.valueOf(this.kYJ), Integer.valueOf(this.kYK));
        }
        localb = this.kYD;
        if (localb != null) {
          if (localObject1 == null) {
            break label446;
          }
        }
      }
      label446:
      for (localObject2 = ((ByteBuffer)localObject1).asIntBuffer();; localObject2 = null)
      {
        if (localObject2 == null) {
          p.iCn();
        }
        localb.invoke(localObject2);
        GLES30.glBindFramebuffer(36160, 0);
        this.kYH = false;
        if (this.kYL.size() < 2) {
          this.kYL.add(localObject1);
        }
        this.kYM = ((ByteBuffer)localObject1);
        return;
        localObject1 = ByteBuffer.allocate(this.kYJ * this.kYK * 4).order(ByteOrder.nativeOrder());
        break;
      }
    }
    if (this.kYm == 3)
    {
      if (this.kYz == null) {
        aVq();
      }
      if (this.kYz != null)
      {
        localObject1 = this.kYz;
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).clear();
        }
        GLES20.glReadPixels(0, 0, this.ksu, this.ksv, 6408, 5121, (Buffer)this.kYz);
        GLES20.glFinish();
        localObject2 = this.kYD;
        if (localObject2 != null)
        {
          localObject1 = this.kYz;
          if (localObject1 == null) {
            break label574;
          }
          localObject1 = ((ByteBuffer)localObject1).asIntBuffer();
          if (localObject1 == null) {
            p.iCn();
          }
          ((b)localObject2).invoke(localObject1);
        }
      }
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES30.glBindFramebuffer(36160, 0);
      return;
      label574:
      localObject1 = null;
      break;
      if (this.kYm == 2)
      {
        GLES20.glBindFramebuffer(36160, 0);
        localObject1 = this.kYC;
        if (localObject1 != null) {
          ((b)localObject1).invoke(this.kYx);
        }
      }
    }
  }
  
  protected abstract void aVw();
  
  protected final int aVx()
  {
    return this.krg;
  }
  
  protected final int aVy()
  {
    return this.krh;
  }
  
  public void ap(byte[] paramArrayOfByte)
  {
    p.k(paramArrayOfByte, "frame");
  }
  
  public void du(int paramInt1, int paramInt2)
  {
    this.ksv = paramInt2;
    this.ksu = paramInt1;
    dy(paramInt1, paramInt2);
    if (this.kYm == 3) {
      aVq();
    }
  }
  
  public void dv(int paramInt1, int paramInt2)
  {
    this.krg = paramInt1;
    this.krh = paramInt2;
    this.kYN.x = 0;
    this.kYN.y = paramInt2;
    this.kYO.x = paramInt1;
    this.kYO.y = 0;
  }
  
  public final void dy(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.kYJ) || (paramInt2 != this.kYK))
    {
      Log.i("MicroMsg.GLTextureRenderProc", "SnapshotSize Changed: res: " + paramInt1 + " x " + paramInt2 + " ori: " + this.kYJ + " x " + this.kYK + " buffQuesize: " + this.kYL.size());
      this.kYL.clear();
    }
    this.kYJ = paramInt1;
    this.kYK = paramInt2;
  }
  
  protected final int getDrawHeight()
  {
    return this.ksv;
  }
  
  protected final int getDrawWidth()
  {
    return this.ksu;
  }
  
  protected final int getScaleType()
  {
    return this.kYn;
  }
  
  public final float[] k(float[] paramArrayOfFloat)
  {
    p.k(paramArrayOfFloat, "array");
    c.a locala = com.tencent.mm.media.k.c.lar;
    c.a.e(this.kYg, paramArrayOfFloat);
    if (this.kYh)
    {
      locala = com.tencent.mm.media.k.c.lar;
      p.k(paramArrayOfFloat, "textureCoords");
      paramArrayOfFloat[1] = (1.0F - paramArrayOfFloat[1]);
      paramArrayOfFloat[3] = (1.0F - paramArrayOfFloat[3]);
      paramArrayOfFloat[5] = (1.0F - paramArrayOfFloat[5]);
      paramArrayOfFloat[7] = (1.0F - paramArrayOfFloat[7]);
    }
    return paramArrayOfFloat;
  }
  
  public void release()
  {
    Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.kYx + ", renderOutputTextureFbo:" + this.kYy + ", drawWidth:" + this.ksu + ", drawHeight:" + this.ksv);
    Object localObject = this.kYx;
    if (localObject != null) {
      ((d)localObject).close();
    }
    localObject = this.kYy;
    if (localObject != null) {
      ((com.tencent.mm.media.g.a)localObject).close();
    }
  }
  
  protected final void setScaleType(int paramInt)
  {
    this.kYn = paramInt;
  }
  
  public void tm(int paramInt)
  {
    this.kYg = paramInt;
  }
  
  public void ua(int paramInt) {}
  
  protected final void ub(int paramInt)
  {
    this.ksu = paramInt;
  }
  
  protected final void uc(int paramInt)
  {
    this.ksv = paramInt;
  }
  
  protected final void ud(int paramInt)
  {
    this.kYm = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc$Companion;", "", "()V", "RENDER_OUTPUT_RGB_BUFFER", "", "RENDER_OUTPUT_SCREEN", "RENDER_OUTPUT_TEXTURE", "SCALE_TYPE_CENTER_CROP", "SCALE_TYPE_CENTER_INSIDE", "SCALE_TYPE_CROP_RECT", "SCALE_TYPE_CROP_RECT_ALIGN_ONE_SIDE", "SCALE_TYPE_FIT_MODE", "SCALE_TYPE_NOT_SCALE", "SnapshotBufferQueueSize", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.b.a
 * JD-Core Version:    0.7.0.1
 */