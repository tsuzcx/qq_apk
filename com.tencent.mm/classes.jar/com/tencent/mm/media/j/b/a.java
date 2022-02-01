package com.tencent.mm.media.j.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "enableSnapshot", "", "flip", "glFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glTextureObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getGlTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mirror", "getMirror", "()Z", "setMirror", "(Z)V", "needProfile", "getNeedProfile", "setNeedProfile", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBByteBufferAvailableListener", "Ljava/nio/ByteBuffer;", "buffer", "getOnRGBByteBufferAvailableListener", "setOnRGBByteBufferAvailableListener", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderCost", "", "getRenderCost", "()J", "setRenderCost", "(J)V", "renderOutputBuffer", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "getRenderOutputType", "setRenderOutputType", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "snapShotBuffer", "snapShotHeight", "getSnapShotHeight", "setSnapShotHeight", "snapShotWidth", "getSnapShotWidth", "setSnapShotWidth", "snapshotBufferQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "snapshotCost", "getSnapshotCost", "setSnapshotCost", "snapshotDirectBuffer", "getSnapshotDirectBuffer", "setSnapshotDirectBuffer", "takeSnapshot", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "validLeftTopPoint", "Landroid/graphics/Point;", "getValidLeftTopPoint", "()Landroid/graphics/Point;", "setValidLeftTopPoint", "(Landroid/graphics/Point;)V", "validRightBottomPoint", "getValidRightBottomPoint", "setValidRightBottomPoint", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "checkInitSnapShotBuffer", "checkInitSnapShotMatrix", "fitCenter", "aspectPlane", "", "aspectTexture", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputByteBuffer", "getOutputTexture", "getOutputTextureObj", "getRotate", "getSnapshotOutputByteBuffer", "getTextureCropRect", "getValidTextureArea", "Landroid/graphics/RectF;", "initDrawCoordBuffer", "initMatrix", "initWithoutMatrix", "array", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setSnapshotSize", "width", "height", "setTextureCropRect", "rect", "takeSnapShot", "updateDrawViewSize", "updateRenderTypeStatus", "updateTextureSize", "updateTextureValidPoint", "leftTop", "rightBottom", "Companion", "plugin-mediaeditor_release"})
public abstract class a
{
  public static final a.a hqA = new a.a((byte)0);
  protected FloatBuffer gNU;
  protected FloatBuffer gNV;
  protected int gNs;
  protected int gNt;
  protected int gOm;
  protected int gOn;
  public int hpY;
  public boolean hpZ;
  protected int hqd;
  public Rect hqf;
  public d hqi;
  protected com.tencent.mm.media.g.a hqj;
  private ByteBuffer hqk;
  protected float[] hql;
  public boolean hqm;
  private b<? super d, z> hqn;
  public b<? super IntBuffer, z> hqo;
  public b<? super ByteBuffer, z> hqp;
  public boolean hqq;
  public volatile boolean hqr;
  private boolean hqs;
  public int hqt;
  public int hqu;
  public ByteBuffer hqv;
  public Point hqw;
  public Point hqx;
  private long hqy;
  private boolean hqz;
  private LinkedBlockingQueue<ByteBuffer> jCG;
  protected final int scaleType;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.gNs = paramInt1;
    this.gNt = paramInt2;
    this.gOm = paramInt3;
    this.gOn = paramInt4;
    this.hqd = paramInt5;
    this.scaleType = paramInt6;
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gNU = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hrw.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gNV = ((FloatBuffer)localObject);
    this.hql = new float[16];
    this.hqq = true;
    this.hqt = -1;
    this.hqu = -1;
    this.jCG = new LinkedBlockingQueue();
    this.hqw = new Point(0, this.gNt);
    this.hqx = new Point(this.gNs, 0);
    if (this.hqd == 2)
    {
      this.hqi = com.tencent.mm.media.g.c.a(true, 3L);
      localObject = com.tencent.mm.media.g.c.hnb;
      this.hqj = com.tencent.mm.media.g.c.rD(3L);
    }
    while (this.hqd != 3) {
      return;
    }
    aup();
  }
  
  private void aup()
  {
    if ((this.gOm > 0) && (this.gOn > 0) && (this.hqk == null)) {
      this.hqk = ByteBuffer.allocateDirect(this.gOm * this.gOn * 4).order(ByteOrder.nativeOrder());
    }
  }
  
  public void S(byte[] paramArrayOfByte)
  {
    p.h(paramArrayOfByte, "frame");
  }
  
  protected void amF()
  {
    Matrix.setIdentityM(this.hql, 0);
    Matrix.setRotateM(this.hql, 0, this.hpY, 0.0F, 0.0F, -1.0F);
    float f3;
    float f4;
    float f1;
    float f2;
    if ((this.hqm) || (this.hqd == 3)) {
      if ((this.hpY == 90) || (this.hpY == 270))
      {
        Matrix.scaleM(this.hql, 0, -1.0F, 1.0F, 1.0F);
        if (this.hpZ) {
          Matrix.scaleM(this.hql, 0, 1.0F, -1.0F, 1.0F);
        }
        if (this.scaleType == 5)
        {
          f3 = this.gOm / this.gOn;
          f4 = this.gNs / this.gNt;
          if (f4 <= f3) {
            break label458;
          }
          f1 = -1.0F;
          f2 = 1.0F;
          f4 /= f3;
          f3 = -f4;
          label149:
          Matrix.orthoM(this.hql, 0, f1, f2, f3, f4, 1.0F, -1.0F);
        }
        aur();
        Object localObject;
        if (this.hqd == 2)
        {
          if (this.hqi == null)
          {
            this.hqi = com.tencent.mm.media.g.c.a(true, 3L);
            localObject = com.tencent.mm.media.g.c.hnb;
            this.hqj = com.tencent.mm.media.g.c.rD(3L);
          }
          localObject = com.tencent.mm.media.k.c.hrD;
          c.a.a(this.hqj, this.hqi, this.gOm, this.gOn);
        }
        GLES20.glViewport(0, 0, this.gOm, this.gOn);
        if (this.hqr)
        {
          if (this.hqi == null)
          {
            this.hqi = com.tencent.mm.media.g.c.a(true, 3L);
            localObject = com.tencent.mm.media.g.c.hnb;
            this.hqj = com.tencent.mm.media.g.c.rD(3L);
          }
          localObject = com.tencent.mm.media.k.c.hrD;
          c.a.a(this.hqj, this.hqi, this.hqt, this.hqu);
          GLES20.glViewport(0, 0, this.hqt, this.hqu);
          if ((this.hpY != 90) && (this.hpY != 270)) {
            break label477;
          }
          Matrix.scaleM(this.hql, 0, -1.0F, 1.0F, 1.0F);
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.GLTextureRenderProc", "rotateDegree " + this.hpY + "  transformMatrix:" + this.hql + " snapShotWidth:" + this.hqt + " snapShotHeight:" + this.hqu);
      this.hqs = true;
      return;
      Matrix.scaleM(this.hql, 0, 1.0F, -1.0F, 1.0F);
      break;
      Matrix.scaleM(this.hql, 0, 1.0F, 1.0F, 1.0F);
      break;
      label458:
      f1 = -f3 / f4;
      f2 = -f1;
      f4 = 1.0F;
      f3 = -1.0F;
      break label149;
      label477:
      Matrix.scaleM(this.hql, 0, 1.0F, -1.0F, 1.0F);
    }
  }
  
  public final void amH()
  {
    amF();
    if (this.hqz) {
      GLES20.glFinish();
    }
    long l = bu.HQ();
    aut();
    if (this.hqz)
    {
      GLES20.glFinish();
      this.hqy = bu.aO(l);
    }
    aus();
  }
  
  public final IntBuffer auj()
  {
    ByteBuffer localByteBuffer = this.hqk;
    if (localByteBuffer != null) {
      return localByteBuffer.asIntBuffer();
    }
    return null;
  }
  
  protected final RectF auq()
  {
    return new RectF(this.hqw.x / this.gNs, (this.hqw.y - 1.0F) / this.gNt, (this.hqx.x - 1.0F) / this.gNs, this.hqx.y / this.gNt);
  }
  
  protected void aur()
  {
    Object localObject1 = auq();
    float f6 = ((RectF)localObject1).left;
    float f4 = ((RectF)localObject1).top;
    float f7 = ((RectF)localObject1).right;
    float f5 = ((RectF)localObject1).bottom;
    if ((this.scaleType == 1) || (this.scaleType == 5))
    {
      this.gNU.position(0);
      this.gNU.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
      this.gNU.position(0);
    }
    for (;;)
    {
      this.gNV.position(0);
      this.gNV.put(com.tencent.mm.media.k.c.hrw);
      this.gNV.position(0);
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
        localObject1 = com.tencent.mm.media.k.c.hrx;
        localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
        int k;
        int m;
        if ((this.hpY == 90) || (this.hpY == 270))
        {
          i = 1;
          j = this.hqx.x - this.hqw.x;
          k = this.hqw.y - this.hqx.y;
          if (i == 0) {
            break label453;
          }
          m = k;
          if (i == 0) {
            break label460;
          }
          f8 = this.gOm / m;
          f9 = this.gOn / j;
          f3 = 0.0F;
          f2 = 0.0F;
          if (f8 >= f9) {
            break label467;
          }
          f1 = m - this.gOm / f9;
          label292:
          this.hqt = (m - (int)f1);
          this.hqu = (j - (int)f2);
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
          this.gNU.put(com.tencent.mm.media.k.c.hrx);
          this.gNU.position(0);
          this.gNU.put((float[])localObject1);
          this.gNU.position(0);
          this.gNV.position(0);
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
          f2 = j - this.gOn / f8;
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
        if (this.hqf != null)
        {
          localObject1 = com.tencent.mm.media.k.c.hrx;
          localObject2 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject1 = this.hqf;
          if (localObject1 != null)
          {
            localObject1 = Integer.valueOf(((Rect)localObject1).width());
            label569:
            if (localObject1 == null) {
              p.gkB();
            }
            i = ((Integer)localObject1).intValue();
            localObject1 = this.hqf;
            if (localObject1 == null) {
              break label798;
            }
            localObject1 = Integer.valueOf(((Rect)localObject1).height());
            label605:
            if (localObject1 == null) {
              p.gkB();
            }
            j = ((Integer)localObject1).intValue();
            localObject1 = this.hqf;
            if ((localObject1 == null) || (((Rect)localObject1).left != 0)) {
              break label804;
            }
            f2 = (this.gNs - i) / this.gNs;
            f1 = 1.0F - f2;
            label658:
            localObject1 = this.hqf;
            if ((localObject1 == null) || (((Rect)localObject1).top != 0)) {
              break label826;
            }
            f3 = (this.gNt - j) / this.gNt;
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
            this.gNU.put(com.tencent.mm.media.k.c.hrx);
            this.gNU.position(0);
            this.gNU.put((float[])localObject2);
            this.gNU.position(0);
            this.gNV.position(0);
            break;
            localObject1 = null;
            break label569;
            label798:
            localObject1 = null;
            break label605;
            label804:
            f1 = (this.gNs - i) / this.gNs;
            f2 = 1.0F - f1;
            break label658;
            label826:
            f4 = (this.gNt - j) / this.gNt;
            f3 = 1.0F - f4;
          }
        }
        this.gNU.position(0);
        this.gNU.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
        this.gNU.position(0);
      }
      else if (this.scaleType == 4)
      {
        if (this.hqf != null)
        {
          localObject1 = com.tencent.mm.media.k.c.hrx;
          localObject1 = Arrays.copyOf((float[])localObject1, localObject1.length);
          localObject2 = a.b.hqB;
          i = this.gNs;
          j = this.gNt;
          localObject2 = this.hqf;
          if (localObject2 == null) {
            p.gkB();
          }
          f9 = a.b.al(((Rect)localObject2).left / i);
          localObject2 = this.hqf;
          if (localObject2 == null) {
            p.gkB();
          }
          f8 = a.b.al(((Rect)localObject2).right / i);
          localObject2 = this.hqf;
          if (localObject2 == null) {
            p.gkB();
          }
          f2 = a.b.al(((Rect)localObject2).bottom / j);
          localObject2 = this.hqf;
          if (localObject2 == null) {
            p.gkB();
          }
          f1 = a.b.al(((Rect)localObject2).top / j);
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
          this.gNU.put(com.tencent.mm.media.k.c.hrx);
          this.gNU.position(0);
          this.gNU.put((float[])localObject1);
          this.gNU.position(0);
          this.gNV.position(0);
        }
        else
        {
          this.gNU.position(0);
          this.gNU.put(new float[] { f6, f4, f7, f4, f6, f5, f7, f5 });
          this.gNU.position(0);
        }
      }
    }
  }
  
  protected void aus()
  {
    Object localObject1;
    Object localObject2;
    if ((this.hqr) && (this.hqs))
    {
      long l = bu.HQ();
      this.hqs = false;
      if ((this.jCG.size() < 2) && (this.hqt > 0) && (this.hqu > 0) && (this.jCG.size() < 2))
      {
        if (this.hqq)
        {
          j = this.jCG.size();
          i = 0;
          while (i < 2 - j)
          {
            this.jCG.add(ByteBuffer.allocateDirect(this.hqt * this.hqu * 4).order(ByteOrder.nativeOrder()));
            i += 1;
          }
        }
        int j = this.jCG.size();
        int i = 0;
        while (i < 2 - j)
        {
          this.jCG.add(ByteBuffer.allocate(this.hqt * this.hqu * 4).order(ByteOrder.nativeOrder()));
          i += 1;
        }
      }
      if ((this.jCG.size() < 2) || (this.hqt < 0) || (this.hqu < 0))
      {
        this.hqr = false;
        return;
      }
      ae.i("MicroMsg.GLTextureRenderProc", hashCode() + " after render takeSnapshot, renderOutputTextureFbo:" + this.hqj + ", renderOutputTexture:" + this.hqi);
      localObject1 = this.hqj;
      if (localObject1 != null) {
        GLES20.glBindFramebuffer(36160, ((com.tencent.mm.media.g.a)localObject1).hmV);
      }
      b localb;
      if (this.jCG.size() > 0)
      {
        localObject1 = (ByteBuffer)this.jCG.remove();
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).position(0);
        }
        GLES20.glReadPixels(0, 0, this.hqt, this.hqu, 6408, 5121, (Buffer)localObject1);
        GLES20.glFinish();
        localObject2 = this.hqp;
        if (localObject2 != null)
        {
          if (localObject1 == null) {
            p.gkB();
          }
          ((b)localObject2).invoke(localObject1);
        }
        localb = this.hqo;
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
          p.gkB();
        }
        localb.invoke(localObject2);
        GLES30.glBindFramebuffer(36160, 0);
        this.hqr = false;
        if (this.jCG.size() < 2) {
          this.jCG.add(localObject1);
        }
        this.hqv = ((ByteBuffer)localObject1);
        ae.i("MicroMsg.GLTextureRenderProc", hashCode() + " takeSnapShot cost " + bu.aO(l) + ", size:" + this.hqt + 'x' + this.hqu + "  rotate: " + this.hpY + " snapshotBufferQueue.size:" + this.jCG.size());
        return;
        localObject1 = ByteBuffer.allocate(this.hqt * this.hqu * 4).order(ByteOrder.nativeOrder());
        break;
      }
    }
    if (this.hqd == 3)
    {
      if (this.hqk == null) {
        aup();
      }
      if (this.hqk != null)
      {
        localObject1 = this.hqk;
        if (localObject1 != null) {
          ((ByteBuffer)localObject1).clear();
        }
        GLES20.glReadPixels(0, 0, this.gOm, this.gOn, 6408, 5121, (Buffer)this.hqk);
        GLES20.glFinish();
        localObject2 = this.hqo;
        if (localObject2 != null)
        {
          localObject1 = this.hqk;
          if (localObject1 == null) {
            break label695;
          }
          localObject1 = ((ByteBuffer)localObject1).asIntBuffer();
          if (localObject1 == null) {
            p.gkB();
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
      if (this.hqd == 2)
      {
        GLES20.glBindFramebuffer(36160, 0);
        localObject1 = this.hqn;
        if (localObject1 != null) {
          ((b)localObject1).invoke(this.hqi);
        }
      }
    }
  }
  
  protected abstract void aut();
  
  public void cT(int paramInt1, int paramInt2)
  {
    this.gOn = paramInt2;
    this.gOm = paramInt1;
    cW(paramInt1, paramInt2);
    if (this.hqd == 3) {
      aup();
    }
  }
  
  public void cU(int paramInt1, int paramInt2)
  {
    this.gNs = paramInt1;
    this.gNt = paramInt2;
    this.hqw.x = 0;
    this.hqw.y = paramInt2;
    this.hqx.x = paramInt1;
    this.hqx.y = 0;
  }
  
  public final void cW(int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.GLTextureRenderProc", "setSnapshotSize:" + paramInt1 + " x " + paramInt2);
    this.hqt = paramInt1;
    this.hqu = paramInt2;
  }
  
  public final float[] k(float[] paramArrayOfFloat)
  {
    p.h(paramArrayOfFloat, "array");
    c.a locala = com.tencent.mm.media.k.c.hrD;
    int i = this.hpY;
    p.h(paramArrayOfFloat, "textureCoords");
    switch (i)
    {
    }
    for (;;)
    {
      if (this.hpZ)
      {
        locala = com.tencent.mm.media.k.c.hrD;
        p.h(paramArrayOfFloat, "textureCoords");
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
  
  public void nQ(int paramInt) {}
  
  public void ng(int paramInt)
  {
    this.hpY = paramInt;
  }
  
  public void release()
  {
    ae.i("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.hqi + ", renderOutputTextureFbo:" + this.hqj + ", drawWidth:" + this.gOm + ", drawHeight:" + this.gOn);
    Object localObject = this.hqi;
    if (localObject != null) {
      ((d)localObject).close();
    }
    localObject = this.hqj;
    if (localObject != null) {
      ((com.tencent.mm.media.g.a)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.b.a
 * JD-Core Version:    0.7.0.1
 */