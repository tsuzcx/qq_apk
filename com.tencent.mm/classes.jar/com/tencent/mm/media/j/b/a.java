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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getGlTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "needProfile", "getNeedProfile", "setNeedProfile", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBByteBufferAvailableListener", "Ljava/nio/ByteBuffer;", "buffer", "getOnRGBByteBufferAvailableListener", "setOnRGBByteBufferAvailableListener", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderCost", "", "getRenderCost", "()J", "setRenderCost", "(J)V", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "snapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "snapshotBufferQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "snapshotCost", "getSnapshotCost", "setSnapshotCost", "snapshotDirectBuffer", "getSnapshotDirectBuffer", "setSnapshotDirectBuffer", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "getValidLeftTopPoint", "()Landroid/graphics/Point;", "setValidLeftTopPoint", "(Landroid/graphics/Point;)V", "validRightBottomPoint", "getValidRightBottomPoint", "setValidRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "fitCenter", "aspectPlane", "", "aspectTexture", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getOutputTextureObj", "getRotate", "getSnapshotOutputByteBuffer", "getTextureCropRect", "getValidTextureArea", "Landroid/graphics/RectF;", "initDrawCoordBuffer", "initMatrix", "initWithoutMatrix", "array", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "width", "height", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateRenderTypeStatus", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a ijW = new a.a((byte)0);
  protected FloatBuffer hDT;
  protected FloatBuffer hDU;
  protected int hDn;
  protected int hDo;
  protected int hEp;
  protected int hEq;
  public Rect ijA;
  public d ijD;
  protected com.tencent.mm.media.g.a ijE;
  public ByteBuffer ijF;
  protected float[] ijG;
  public boolean ijH;
  private b<? super d, x> ijI;
  public b<? super IntBuffer, x> ijJ;
  public b<? super ByteBuffer, x> ijK;
  public boolean ijL;
  public volatile boolean ijM;
  private boolean ijN;
  public int ijO;
  public int ijP;
  private LinkedBlockingQueue<ByteBuffer> ijQ;
  public ByteBuffer ijR;
  public Point ijS;
  public Point ijT;
  private long ijU;
  private boolean ijV;
  protected int ijt;
  public boolean iju;
  protected int ijy;
  protected int scaleType;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.hDn = paramInt1;
    this.hDo = paramInt2;
    this.hEp = paramInt3;
    this.hEq = paramInt4;
    this.ijy = paramInt5;
    this.scaleType = paramInt6;
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hDT = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.ilm.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hDU = ((FloatBuffer)localObject);
    this.ijG = new float[16];
    this.ijL = true;
    this.ijO = -1;
    this.ijP = -1;
    this.ijQ = new LinkedBlockingQueue();
    this.ijS = new Point(0, this.hDo);
    this.ijT = new Point(this.hDn, 0);
    if (this.ijy == 2)
    {
      this.ijD = com.tencent.mm.media.g.c.a(true, 3L);
      localObject = com.tencent.mm.media.g.c.igu;
      this.ijE = com.tencent.mm.media.g.c.zI(3L);
    }
    while (this.ijy != 3) {
      return;
    }
    aMQ();
  }
  
  private void aMQ()
  {
    if ((this.hEp > 0) && (this.hEq > 0) && (this.ijF == null)) {
      this.ijF = ByteBuffer.allocateDirect(this.hEp * this.hEq * 4).order(ByteOrder.nativeOrder());
    }
  }
  
  public final void E(float paramFloat1, float paramFloat2)
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
      Matrix.orthoM(this.ijG, 0, paramFloat1, paramFloat2, f1, f2, 1.0F, -1.0F);
      return;
      paramFloat1 = -paramFloat1 / paramFloat2;
      paramFloat2 = -paramFloat1;
      f1 = -1.0F;
      f2 = 1.0F;
    }
  }
  
  protected void aEB()
  {
    Matrix.setIdentityM(this.ijG, 0);
    Matrix.setRotateM(this.ijG, 0, this.ijt, 0.0F, 0.0F, -1.0F);
    if ((this.ijH) || (this.ijy == 3)) {
      if ((this.ijt == 90) || (this.ijt == 270)) {
        Matrix.scaleM(this.ijG, 0, -1.0F, 1.0F, 1.0F);
      }
    }
    for (;;)
    {
      if (this.iju) {
        Matrix.scaleM(this.ijG, 0, 1.0F, -1.0F, 1.0F);
      }
      if (this.scaleType == 5) {
        E(this.hEp / this.hEq, this.hDn / this.hDo);
      }
      aMS();
      aMT();
      return;
      Matrix.scaleM(this.ijG, 0, 1.0F, -1.0F, 1.0F);
      continue;
      Matrix.scaleM(this.ijG, 0, 1.0F, 1.0F, 1.0F);
    }
  }
  
  public final void aED()
  {
    aEB();
    if (this.ijV) {
      GLES20.glFinish();
    }
    long l = Util.currentTicks();
    aMV();
    if (this.ijV)
    {
      GLES20.glFinish();
      this.ijU = Util.ticksToNow(l);
    }
    aMU();
  }
  
  protected final RectF aMR()
  {
    return new RectF(this.ijS.x / this.hDn, (this.ijS.y - 1.0F) / this.hDo, (this.ijT.x - 1.0F) / this.hDn, this.ijT.y / this.hDo);
  }
  
  protected void aMS()
  {
    Object localObject1 = aMR();
    float f6 = ((RectF)localObject1).left;
    float f4 = ((RectF)localObject1).top;
    float f7 = ((RectF)localObject1).right;
    float f5 = ((RectF)localObject1).bottom;
    if ((this.scaleType == 1) || (this.scaleType == 5))
    {
      this.hDT.position(0);
      this.hDT.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
      this.hDT.position(0);
    }
    for (;;)
    {
      this.hDU.position(0);
      this.hDU.put(com.tencent.mm.media.k.c.ilm);
      this.hDU.position(0);
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
        localObject1 = com.tencent.mm.media.k.c.iln;
        localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
        int k;
        int m;
        if ((this.ijt == 90) || (this.ijt == 270))
        {
          i = 1;
          j = this.ijT.x - this.ijS.x;
          k = this.ijS.y - this.ijT.y;
          if (i == 0) {
            break label453;
          }
          m = k;
          if (i == 0) {
            break label460;
          }
          f8 = this.hEp / m;
          f9 = this.hEq / j;
          f3 = 0.0F;
          f2 = 0.0F;
          if (f8 >= f9) {
            break label467;
          }
          f1 = m - this.hEp / f9;
          label292:
          this.ijO = (m - (int)f1);
          this.ijP = (j - (int)f2);
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
          this.hDT.put(com.tencent.mm.media.k.c.iln);
          this.hDT.position(0);
          this.hDT.put((float[])localObject1);
          this.hDT.position(0);
          this.hDU.position(0);
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
          f2 = j - this.hEq / f8;
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
        if (this.ijA != null)
        {
          localObject1 = com.tencent.mm.media.k.c.iln;
          localObject2 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject1 = this.ijA;
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((Rect)localObject1).width());
            label569:
            if (localObject1 == null) {
              p.hyc();
            }
            i = ((Integer)localObject1).intValue();
            localObject1 = this.ijA;
            if (localObject1 == null) {
              break label798;
            }
            localObject1 = Integer.valueOf(((Rect)localObject1).height());
            label605:
            if (localObject1 == null) {
              p.hyc();
            }
            j = ((Integer)localObject1).intValue();
            localObject1 = this.ijA;
            if ((localObject1 == null) || (((Rect)localObject1).left != 0)) {
              break label804;
            }
            f2 = (this.hDn - i) / this.hDn;
            f1 = 1.0F - f2;
            label658:
            localObject1 = this.ijA;
            if ((localObject1 == null) || (((Rect)localObject1).top != 0)) {
              break label826;
            }
            f3 = (this.hDo - j) / this.hDo;
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
            this.hDT.put(com.tencent.mm.media.k.c.iln);
            this.hDT.position(0);
            this.hDT.put((float[])localObject2);
            this.hDT.position(0);
            this.hDU.position(0);
            break;
            localObject1 = null;
            break label569;
            label798:
            localObject1 = null;
            break label605;
            label804:
            f1 = (this.hDn - i) / this.hDn;
            f2 = 1.0F - f1;
            break label658;
            label826:
            f4 = (this.hDo - j) / this.hDo;
            f3 = 1.0F - f4;
          }
        }
        this.hDT.position(0);
        this.hDT.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
        this.hDT.position(0);
      }
      else if (this.scaleType == 4)
      {
        if (this.ijA != null)
        {
          localObject1 = com.tencent.mm.media.k.c.iln;
          localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject2 = a.b.ijX;
          i = this.hDn;
          j = this.hDo;
          localObject2 = this.ijA;
          if (localObject2 == null) {
            p.hyc();
          }
          f9 = a.b.au(((Rect)localObject2).left / i);
          localObject2 = this.ijA;
          if (localObject2 == null) {
            p.hyc();
          }
          f8 = a.b.au(((Rect)localObject2).right / i);
          localObject2 = this.ijA;
          if (localObject2 == null) {
            p.hyc();
          }
          f2 = a.b.au(((Rect)localObject2).bottom / j);
          localObject2 = this.ijA;
          if (localObject2 == null) {
            p.hyc();
          }
          f1 = a.b.au(((Rect)localObject2).top / j);
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
          this.hDT.put(com.tencent.mm.media.k.c.iln);
          this.hDT.position(0);
          this.hDT.put((float[])localObject1);
          this.hDT.position(0);
          this.hDU.position(0);
        }
        else
        {
          this.hDT.position(0);
          this.hDT.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
          this.hDT.position(0);
        }
      }
    }
  }
  
  protected final void aMT()
  {
    Object localObject;
    if (this.ijy == 2)
    {
      if (this.ijD == null)
      {
        this.ijD = com.tencent.mm.media.g.c.a(true, 3L);
        localObject = com.tencent.mm.media.g.c.igu;
        this.ijE = com.tencent.mm.media.g.c.zI(3L);
      }
      localObject = com.tencent.mm.media.k.c.ilt;
      c.a.a(this.ijE, this.ijD, this.hEp, this.hEq);
    }
    GLES20.glViewport(0, 0, this.hEp, this.hEq);
    if (this.ijM)
    {
      if (this.ijD == null)
      {
        this.ijD = com.tencent.mm.media.g.c.a(true, 3L);
        localObject = com.tencent.mm.media.g.c.igu;
        this.ijE = com.tencent.mm.media.g.c.zI(3L);
      }
      localObject = com.tencent.mm.media.k.c.ilt;
      c.a.a(this.ijE, this.ijD, this.ijO, this.ijP);
      GLES20.glViewport(0, 0, this.ijO, this.ijP);
      if ((this.ijt != 90) && (this.ijt != 270)) {
        break label254;
      }
      Matrix.scaleM(this.ijG, 0, -1.0F, 1.0F, 1.0F);
    }
    for (;;)
    {
      Log.i("MicroMsg.GLTextureRenderProc", "rotateDegree " + this.ijt + "  transformMatrix:" + this.ijG + " snapShotWidth:" + this.ijO + " snapShotHeight:" + this.ijP);
      this.ijN = true;
      return;
      label254:
      Matrix.scaleM(this.ijG, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  protected void aMU()
  {
    Object localObject1;
    Object localObject2;
    if ((this.ijM) && (this.ijN))
    {
      long l = Util.currentTicks();
      this.ijN = false;
      if ((this.ijQ.size() < 2) && (this.ijO > 0) && (this.ijP > 0) && (this.ijQ.size() < 2))
      {
        if (this.ijL)
        {
          j = this.ijQ.size();
          i = 0;
          while (i < 2 - j)
          {
            this.ijQ.add(ByteBuffer.allocateDirect(this.ijO * this.ijP * 4).order(ByteOrder.nativeOrder()));
            i += 1;
          }
        }
        int j = this.ijQ.size();
        int i = 0;
        while (i < 2 - j)
        {
          this.ijQ.add(ByteBuffer.allocate(this.ijO * this.ijP * 4).order(ByteOrder.nativeOrder()));
          i += 1;
        }
      }
      if ((this.ijQ.size() < 2) || (this.ijO < 0) || (this.ijP < 0))
      {
        this.ijM = false;
        return;
      }
      Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " after render takeSnapshot, renderOutputTextureFbo:" + this.ijE + ", renderOutputTexture:" + this.ijD);
      localObject1 = this.ijE;
      if (localObject1 != null) {
        GLES20.glBindFramebuffer(36160, ((com.tencent.mm.media.g.a)localObject1).igo);
      }
      b localb;
      if (this.ijQ.size() > 0)
      {
        localObject1 = (ByteBuffer)this.ijQ.remove();
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).position(0);
        }
        GLES20.glReadPixels(0, 0, this.ijO, this.ijP, 6408, 5121, (Buffer)localObject1);
        GLES20.glFinish();
        localObject2 = this.ijK;
        if (localObject2 != null)
        {
          if (localObject1 == null) {
            p.hyc();
          }
          ((b)localObject2).invoke(localObject1);
        }
        localb = this.ijJ;
        if (localb != null) {
          if (localObject1 == null) {
            break label558;
          }
        }
      }
      label558:
      for (localObject2 = ((ByteBuffer)localObject1).asIntBuffer();; localObject2 = null)
      {
        if (localObject2 == null) {
          p.hyc();
        }
        localb.invoke(localObject2);
        GLES30.glBindFramebuffer(36160, 0);
        this.ijM = false;
        if (this.ijQ.size() < 2) {
          this.ijQ.add(localObject1);
        }
        this.ijR = ((ByteBuffer)localObject1);
        Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " takeSnapShot cost " + Util.ticksToNow(l) + ", size:" + this.ijO + 'x' + this.ijP + "  rotate: " + this.ijt + " snapshotBufferQueue.size:" + this.ijQ.size());
        return;
        localObject1 = ByteBuffer.allocate(this.ijO * this.ijP * 4).order(ByteOrder.nativeOrder());
        break;
      }
    }
    if (this.ijy == 3)
    {
      if (this.ijF == null) {
        aMQ();
      }
      if (this.ijF != null)
      {
        localObject1 = this.ijF;
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).clear();
        }
        GLES20.glReadPixels(0, 0, this.hEp, this.hEq, 6408, 5121, (Buffer)this.ijF);
        GLES20.glFinish();
        localObject2 = this.ijJ;
        if (localObject2 != null)
        {
          localObject1 = this.ijF;
          if (localObject1 == null) {
            break label695;
          }
          localObject1 = ((ByteBuffer)localObject1).asIntBuffer();
          if (localObject1 == null) {
            p.hyc();
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
      label695:
      localObject1 = null;
      break;
      if (this.ijy == 2)
      {
        GLES20.glBindFramebuffer(36160, 0);
        localObject1 = this.ijI;
        if (localObject1 != null) {
          ((b)localObject1).invoke(this.ijD);
        }
      }
    }
  }
  
  protected abstract void aMV();
  
  public void ag(byte[] paramArrayOfByte)
  {
    p.h(paramArrayOfByte, "frame");
  }
  
  public void cY(int paramInt1, int paramInt2)
  {
    this.hEq = paramInt2;
    this.hEp = paramInt1;
    dc(paramInt1, paramInt2);
    if (this.ijy == 3) {
      aMQ();
    }
  }
  
  public void cZ(int paramInt1, int paramInt2)
  {
    this.hDn = paramInt1;
    this.hDo = paramInt2;
    this.ijS.x = 0;
    this.ijS.y = paramInt2;
    this.ijT.x = paramInt1;
    this.ijT.y = 0;
  }
  
  public final void dc(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.GLTextureRenderProc", "setSnapshotSize:" + paramInt1 + " x " + paramInt2);
    if ((paramInt1 != this.ijO) || (paramInt2 != this.ijP))
    {
      Log.i("MicroMsg.GLTextureRenderProc", "SnapshotSize Changed: res: " + paramInt1 + " x " + paramInt2 + " ori: " + this.ijO + " x " + this.ijP + " buffQuesize: " + this.ijQ.size());
      this.ijQ.clear();
    }
    this.ijO = paramInt1;
    this.ijP = paramInt2;
  }
  
  public final float[] k(float[] paramArrayOfFloat)
  {
    p.h(paramArrayOfFloat, "array");
    c.a locala = com.tencent.mm.media.k.c.ilt;
    c.a.e(this.ijt, paramArrayOfFloat);
    if (this.iju)
    {
      locala = com.tencent.mm.media.k.c.ilt;
      p.h(paramArrayOfFloat, "textureCoords");
      paramArrayOfFloat[1] = (1.0F - paramArrayOfFloat[1]);
      paramArrayOfFloat[3] = (1.0F - paramArrayOfFloat[3]);
      paramArrayOfFloat[5] = (1.0F - paramArrayOfFloat[5]);
      paramArrayOfFloat[7] = (1.0F - paramArrayOfFloat[7]);
    }
    return paramArrayOfFloat;
  }
  
  public void qx(int paramInt)
  {
    this.ijt = paramInt;
  }
  
  public void release()
  {
    Log.i("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.ijD + ", renderOutputTextureFbo:" + this.ijE + ", drawWidth:" + this.hEp + ", drawHeight:" + this.hEq);
    Object localObject = this.ijD;
    if (localObject != null) {
      ((d)localObject).close();
    }
    localObject = this.ijE;
    if (localObject != null) {
      ((com.tencent.mm.media.g.a)localObject).close();
    }
  }
  
  public void rl(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.b.a
 * JD-Core Version:    0.7.0.1
 */