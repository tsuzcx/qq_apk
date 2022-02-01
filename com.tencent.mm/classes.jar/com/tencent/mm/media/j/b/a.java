package com.tencent.mm.media.j.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getGlTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "needProfile", "getNeedProfile", "setNeedProfile", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBByteBufferAvailableListener", "Ljava/nio/ByteBuffer;", "buffer", "getOnRGBByteBufferAvailableListener", "setOnRGBByteBufferAvailableListener", "onRGBByteBufferAvailableWithSizeListener", "Lkotlin/Function3;", "width", "height", "getOnRGBByteBufferAvailableWithSizeListener", "()Lkotlin/jvm/functions/Function3;", "setOnRGBByteBufferAvailableWithSizeListener", "(Lkotlin/jvm/functions/Function3;)V", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderCost", "", "getRenderCost", "()J", "setRenderCost", "(J)V", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "snapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "snapshotBufferQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "snapshotCost", "getSnapshotCost", "setSnapshotCost", "snapshotDirectBuffer", "getSnapshotDirectBuffer", "setSnapshotDirectBuffer", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "getValidLeftTopPoint", "()Landroid/graphics/Point;", "setValidLeftTopPoint", "(Landroid/graphics/Point;)V", "validRightBottomPoint", "getValidRightBottomPoint", "setValidRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "fitCenter", "aspectPlane", "", "aspectTexture", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getOutputTextureObj", "getRotate", "getSnapshotOutputByteBuffer", "getTextureCropRect", "getValidTextureArea", "Landroid/graphics/RectF;", "initDrawCoordBuffer", "initMatrix", "initWithoutMatrix", "array", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateRenderTypeStatus", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a nDE = new a.a((byte)0);
  private FloatBuffer mVU;
  private FloatBuffer mVV;
  private int mVd;
  private int mVe;
  private int mWn;
  private int mWo;
  public Rect nDB;
  public d nDF;
  private com.tencent.mm.media.g.a nDG;
  public ByteBuffer nDH;
  private float[] nDI;
  private boolean nDJ;
  private kotlin.g.a.b<? super d, ah> nDK;
  public kotlin.g.a.b<? super IntBuffer, ah> nDL;
  public kotlin.g.a.b<? super ByteBuffer, ah> nDM;
  public q<? super ByteBuffer, ? super Integer, ? super Integer, ah> nDN;
  public boolean nDO;
  public volatile boolean nDP;
  private boolean nDQ;
  public int nDR;
  public int nDS;
  private LinkedBlockingQueue<ByteBuffer> nDT;
  public ByteBuffer nDU;
  public Point nDV;
  public Point nDW;
  private boolean nDX;
  private int nDk;
  private int nDl;
  public int nDr;
  private boolean nvG;
  private long renderCost;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mVd = paramInt1;
    this.mVe = paramInt2;
    this.mWn = paramInt3;
    this.mWo = paramInt4;
    this.nDk = paramInt5;
    this.nDl = paramInt6;
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.mVU = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.mVV = ((FloatBuffer)localObject);
    this.nDI = new float[16];
    this.nDO = true;
    this.nDR = -1;
    this.nDS = -1;
    this.nDT = new LinkedBlockingQueue();
    this.nDV = new Point(0, this.mVe);
    this.nDW = new Point(this.mVd, 0);
    if (this.nDk == 2)
    {
      this.nDF = com.tencent.mm.media.g.c.d(true, 3L);
      localObject = com.tencent.mm.media.g.c.nAB;
      this.nDG = com.tencent.mm.media.g.c.hX(3L);
    }
    while (this.nDk != 3) {
      return;
    }
    bqa();
  }
  
  private void bqa()
  {
    if ((this.mWn > 0) && (this.mWo > 0) && (this.nDH == null)) {
      this.nDH = ByteBuffer.allocateDirect(this.mWn * this.mWo * 4).order(ByteOrder.nativeOrder());
    }
  }
  
  protected final void a(com.tencent.mm.media.g.a parama)
  {
    this.nDG = parama;
  }
  
  public void a(d paramd)
  {
    s.u(paramd, "texture");
  }
  
  public final void am(float paramFloat1, float paramFloat2)
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
      Matrix.orthoM(this.nDI, 0, paramFloat1, paramFloat2, f1, f2, 1.0F, -1.0F);
      return;
      paramFloat1 = -paramFloat1 / paramFloat2;
      paramFloat2 = -paramFloat1;
      f1 = -1.0F;
      f2 = 1.0F;
    }
  }
  
  public void ap(byte[] paramArrayOfByte)
  {
    s.u(paramArrayOfByte, "frame");
  }
  
  protected void bgB()
  {
    Matrix.setIdentityM(this.nDI, 0);
    Matrix.setRotateM(this.nDI, 0, this.nDr, 0.0F, 0.0F, -1.0F);
    if ((this.nDJ) || (this.nDk == 3)) {
      if ((this.nDr == 90) || (this.nDr == 270)) {
        Matrix.scaleM(this.nDI, 0, -1.0F, 1.0F, 1.0F);
      }
    }
    for (;;)
    {
      if (this.nvG) {
        Matrix.scaleM(this.nDI, 0, 1.0F, -1.0F, 1.0F);
      }
      if (this.nDl == 5) {
        am(this.mWn / this.mWo, this.mVd / this.mVe);
      }
      bqd();
      bqe();
      return;
      Matrix.scaleM(this.nDI, 0, 1.0F, -1.0F, 1.0F);
      continue;
      Matrix.scaleM(this.nDI, 0, 1.0F, 1.0F, 1.0F);
    }
  }
  
  public final void bgE()
  {
    bgB();
    if (this.nDX) {
      GLES20.glFinish();
    }
    long l = Util.currentTicks();
    bqg();
    if (this.nDX)
    {
      GLES20.glFinish();
      this.renderCost = Util.ticksToNow(l);
    }
    bqf();
  }
  
  protected final int bpT()
  {
    return this.mVd;
  }
  
  protected final int bpU()
  {
    return this.mVe;
  }
  
  protected final FloatBuffer bpV()
  {
    return this.mVU;
  }
  
  protected final FloatBuffer bpW()
  {
    return this.mVV;
  }
  
  protected final com.tencent.mm.media.g.a bpX()
  {
    return this.nDG;
  }
  
  public final float[] bpY()
  {
    return this.nDI;
  }
  
  protected final boolean bpZ()
  {
    return this.nvG;
  }
  
  public final boolean bqb()
  {
    return this.nvG;
  }
  
  protected final RectF bqc()
  {
    return new RectF(this.nDV.x / this.mVd, (this.nDV.y - 1.0F) / this.mVe, (this.nDW.x - 1.0F) / this.mVd, this.nDW.y / this.mVe);
  }
  
  protected void bqd()
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
    if (this.nDl == 2)
    {
      if ((this.nDr != 90) && (this.nDr != 270)) {
        break label450;
      }
      j = 1;
      k = this.nDW.x - this.nDV.x;
      m = this.nDV.y - this.nDW.y;
      if (j == 0) {
        break label456;
      }
      i = m;
      if (j == 0) {
        break label463;
      }
      f4 = this.mWn / i;
      f5 = this.mWo / k;
      f3 = 0.0F;
      f2 = 0.0F;
      if (f4 >= f5) {
        break label470;
      }
      f1 = i - this.mWn / f5;
    }
    Object localObject;
    Point localPoint;
    int n;
    int i1;
    Rect localRect;
    float f6;
    for (;;)
    {
      this.nDR = (i - (int)f1);
      this.nDS = (k - (int)f2);
      this.mVU.position(0);
      FloatBuffer localFloatBuffer = this.mVU;
      localObject = com.tencent.mm.media.j.c.b.nFq;
      k = this.nDl;
      i = this.mVd;
      j = this.mVe;
      localObject = this.nDV;
      localPoint = this.nDW;
      m = this.nDr;
      n = this.mWn;
      i1 = this.mWo;
      localRect = this.nDB;
      s.u(localObject, "textureValidLTPoint");
      s.u(localPoint, "textureValidRBPoint");
      float[] arrayOfFloat = Arrays.copyOf(com.tencent.mm.media.util.c.nFu, com.tencent.mm.media.util.c.nFu.length);
      s.s(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
      RectF localRectF = com.tencent.mm.media.j.c.b.a((Point)localObject, localPoint, i, j);
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
        this.mVU.position(0);
        this.mVV.position(0);
        localFloatBuffer = this.mVV;
        localObject = com.tencent.mm.media.j.c.b.nFq;
        localFloatBuffer.put(com.tencent.mm.media.j.c.b.a(this.nDl, this.nDV, this.nDW, this.nDr, this.mWn, this.mWo));
        this.mVV.position(0);
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
          f2 = k - this.mWo / f4;
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
      k = localPoint.x - ((Point)localObject).x;
      m = ((Point)localObject).y - localPoint.y;
      if (i == 0) {
        break label647;
      }
      j = m;
      if (i == 0) {
        break label654;
      }
      f1 = n / j;
      f7 = i1 / k;
      f2 = 0.0F;
      if (f1 >= f7) {
        break label661;
      }
      f1 = j - n / f7;
    }
    for (;;)
    {
      label593:
      if (i != 0)
      {
        f2 = f2 / 2.0F / k;
        f1 = f1 / 2.0F / j;
      }
      for (;;)
      {
        f6 += f2;
        f3 += f1;
        f4 -= f2;
        f1 = f5 - f1;
        f2 = f6;
        break;
        i = 0;
        break label516;
        label647:
        j = k;
        break label551;
        label654:
        k = m;
        break label556;
        label661:
        if (f1 <= f7) {
          break label956;
        }
        f2 = k - i1 / f1;
        f1 = 0.0F;
        break label593;
        f7 = f1 / 2.0F / j;
        f1 = f2 / 2.0F / k;
        f2 = f7;
      }
      if (localRect == null) {
        break;
      }
      k = localRect.width();
      m = localRect.height();
      if (localRect.left == 0)
      {
        f1 = (i - k) / i;
        f4 = 1.0F - f1;
      }
      for (;;)
      {
        if (localRect.top != 0) {
          break label805;
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
      label805:
      f3 = (j - m) / j;
      f5 = 1.0F - f3;
      f2 = f1;
      f1 = f5;
      break label326;
      if (localRect == null) {
        break;
      }
      f2 = com.tencent.mm.media.j.c.b.bp(localRect.left / i);
      float f9 = com.tencent.mm.media.j.c.b.bp(localRect.right / i);
      f7 = com.tencent.mm.media.j.c.b.bp(localRect.bottom / j);
      f1 = com.tencent.mm.media.j.c.b.bp(localRect.top / j);
      f4 = Math.abs(f4 - f6);
      float f8 = Math.abs(f3 - f5);
      f2 = f6 + f2 * f4;
      f4 = f4 * f9 + f2;
      f3 = Math.min(f5, f3) + f8 * f7;
      f1 = Math.min(f5, f3) + f8 * f1;
      break label326;
      label956:
      f1 = 0.0F;
    }
  }
  
  protected final void bqe()
  {
    Object localObject;
    if (this.nDk == 2)
    {
      if (this.nDF == null)
      {
        this.nDF = com.tencent.mm.media.g.c.d(true, 3L);
        localObject = com.tencent.mm.media.g.c.nAB;
        this.nDG = com.tencent.mm.media.g.c.hX(3L);
      }
      localObject = com.tencent.mm.media.util.c.nFs;
      c.a.a(this.nDG, this.nDF, this.mWn, this.mWo);
    }
    GLES20.glViewport(0, 0, this.mWn, this.mWo);
    if (this.nDP)
    {
      if (this.nDF == null)
      {
        this.nDF = com.tencent.mm.media.g.c.d(true, 3L);
        localObject = com.tencent.mm.media.g.c.nAB;
        this.nDG = com.tencent.mm.media.g.c.hX(3L);
      }
      localObject = com.tencent.mm.media.util.c.nFs;
      c.a.a(this.nDG, this.nDF, this.nDR, this.nDS);
      GLES20.glViewport(0, 0, this.nDR, this.nDS);
      if ((this.nDr != 90) && (this.nDr != 270)) {
        break label189;
      }
      Matrix.scaleM(this.nDI, 0, -1.0F, 1.0F, 1.0F);
    }
    for (;;)
    {
      this.nDQ = true;
      return;
      label189:
      Matrix.scaleM(this.nDI, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  protected void bqf()
  {
    label152:
    Object localObject1;
    Object localObject2;
    if ((this.nDP) && (this.nDQ))
    {
      Util.currentTicks();
      this.nDQ = false;
      int k;
      int i;
      int j;
      if ((this.nDT.size() < 2) && (this.nDR > 0) && (this.nDS > 0) && (this.nDT.size() < 2))
      {
        if (!this.nDO) {
          break label152;
        }
        k = 2 - this.nDT.size();
        if (k > 0)
        {
          i = 0;
          do
          {
            j = i + 1;
            this.nDT.add(ByteBuffer.allocateDirect(this.nDR * this.nDS * 4).order(ByteOrder.nativeOrder()));
            i = j;
          } while (j < k);
        }
      }
      while ((this.nDT.size() < 2) || (this.nDR < 0) || (this.nDS < 0))
      {
        this.nDP = false;
        return;
        k = 2 - this.nDT.size();
        if (k > 0)
        {
          i = 0;
          do
          {
            j = i + 1;
            this.nDT.add(ByteBuffer.allocate(this.nDR * this.nDS * 4).order(ByteOrder.nativeOrder()));
            i = j;
          } while (j < k);
        }
      }
      localObject1 = this.nDG;
      if (localObject1 != null) {
        GLES20.glBindFramebuffer(36160, ((com.tencent.mm.media.g.a)localObject1).nAy);
      }
      kotlin.g.a.b localb;
      if (this.nDT.size() > 0)
      {
        localObject1 = (ByteBuffer)this.nDT.take();
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).position(0);
        }
        GLES20.glReadPixels(0, 0, this.nDR, this.nDS, 6408, 5121, (Buffer)localObject1);
        GLES20.glFinish();
        localObject2 = this.nDM;
        if (localObject2 != null)
        {
          s.checkNotNull(localObject1);
          ((kotlin.g.a.b)localObject2).invoke(localObject1);
        }
        localObject2 = this.nDN;
        if (localObject2 != null)
        {
          s.checkNotNull(localObject1);
          ((q)localObject2).invoke(localObject1, Integer.valueOf(this.nDR), Integer.valueOf(this.nDS));
        }
        localb = this.nDL;
        if (localb != null) {
          if (localObject1 != null) {
            break label458;
          }
        }
      }
      label458:
      for (localObject2 = null;; localObject2 = ((ByteBuffer)localObject1).asIntBuffer())
      {
        s.checkNotNull(localObject2);
        localb.invoke(localObject2);
        GLES30.glBindFramebuffer(36160, 0);
        this.nDP = false;
        if (this.nDT.size() < 2) {
          this.nDT.add(localObject1);
        }
        this.nDU = ((ByteBuffer)localObject1);
        return;
        localObject1 = ByteBuffer.allocate(this.nDR * this.nDS * 4).order(ByteOrder.nativeOrder());
        break;
      }
    }
    if (this.nDk == 3)
    {
      if (this.nDH == null) {
        bqa();
      }
      if (this.nDH != null)
      {
        localObject1 = this.nDH;
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).clear();
        }
        GLES20.glReadPixels(0, 0, this.mWn, this.mWo, 6408, 5121, (Buffer)this.nDH);
        GLES20.glFinish();
        localObject2 = this.nDL;
        if (localObject2 != null)
        {
          localObject1 = this.nDH;
          if (localObject1 != null) {
            break label592;
          }
          localObject1 = null;
          s.checkNotNull(localObject1);
          ((kotlin.g.a.b)localObject2).invoke(localObject1);
        }
      }
    }
    for (;;)
    {
      GLES20.glUseProgram(0);
      GLES30.glBindFramebuffer(36160, 0);
      return;
      label592:
      localObject1 = ((ByteBuffer)localObject1).asIntBuffer();
      break;
      if (this.nDk == 2)
      {
        GLES20.glBindFramebuffer(36160, 0);
        localObject1 = this.nDK;
        if (localObject1 != null) {
          ((kotlin.g.a.b)localObject1).invoke(this.nDF);
        }
      }
    }
  }
  
  protected abstract void bqg();
  
  public void ek(int paramInt1, int paramInt2)
  {
    this.mWo = paramInt2;
    this.mWn = paramInt1;
    es(paramInt1, paramInt2);
    if (this.nDk == 3) {
      bqa();
    }
  }
  
  public void el(int paramInt1, int paramInt2)
  {
    this.mVd = paramInt1;
    this.mVe = paramInt2;
    this.nDV.x = 0;
    this.nDV.y = paramInt2;
    this.nDW.x = paramInt1;
    this.nDW.y = 0;
  }
  
  public final void es(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.nDR) || (paramInt2 != this.nDS)) {
      this.nDT.clear();
    }
    this.nDR = paramInt1;
    this.nDS = paramInt2;
  }
  
  protected final int getDrawHeight()
  {
    return this.mWo;
  }
  
  protected final int getDrawWidth()
  {
    return this.mWn;
  }
  
  protected final int getScaleType()
  {
    return this.nDl;
  }
  
  public void gq(boolean paramBoolean)
  {
    this.nDJ = paramBoolean;
  }
  
  public void gr(boolean paramBoolean)
  {
    this.nvG = paramBoolean;
  }
  
  public void release()
  {
    Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.nDF + ", renderOutputTextureFbo:" + this.nDG + ", drawWidth:" + this.mWn + ", drawHeight:" + this.mWo);
    Object localObject = this.nDF;
    if (localObject != null) {
      ((d)localObject).close();
    }
    localObject = this.nDG;
    if (localObject != null) {
      ((com.tencent.mm.media.g.a)localObject).close();
    }
  }
  
  protected final void setScaleType(int paramInt)
  {
    this.nDl = paramInt;
  }
  
  protected final void tZ(int paramInt)
  {
    this.mWn = paramInt;
  }
  
  public void th(int paramInt)
  {
    this.nDr = paramInt;
  }
  
  protected final void ua(int paramInt)
  {
    this.mWo = paramInt;
  }
  
  protected final void ub(int paramInt)
  {
    this.nDk = paramInt;
  }
  
  public void uc(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b.a
 * JD-Core Version:    0.7.0.1
 */