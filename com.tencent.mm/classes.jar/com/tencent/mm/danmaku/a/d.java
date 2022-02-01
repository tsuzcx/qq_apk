package com.tencent.mm.danmaku.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.render.NativeDanmakuView;
import com.tencent.mm.danmaku.render.d.b;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
  implements View.OnTouchListener, com.tencent.mm.danmaku.render.d.a
{
  private static final DecimalFormat gNV;
  private static final DecimalFormat gNW;
  volatile boolean gNB;
  private volatile boolean gNC;
  private volatile boolean gND;
  private final com.tencent.mm.danmaku.render.d gNE;
  final e gNF;
  final f gNG;
  final h gNH;
  private long gNI;
  long gNJ;
  boolean gNK;
  private volatile boolean gNL;
  private long gNM;
  private long gNN;
  private long gNO;
  int gNP;
  int gNQ;
  int gNR;
  private String gNS;
  private long gNT;
  private long gNU;
  final Queue<com.tencent.mm.danmaku.d.h> gNX;
  private final List<com.tencent.mm.danmaku.b.a> gNY;
  final a gNZ;
  com.tencent.mm.danmaku.c.a gNt;
  final b gNu;
  final com.tencent.mm.danmaku.d.f gNv;
  final com.tencent.mm.danmaku.d.c gNw;
  g.b gOa;
  private d.b gOb;
  i gOc;
  private Object gOd;
  private boolean gOe;
  private int gOf;
  private a gOg;
  
  static
  {
    AppMethodBeat.i(241635);
    gNV = new DecimalFormat("00.00");
    gNW = new DecimalFormat("00");
    AppMethodBeat.o(241635);
  }
  
  protected d(View paramView, com.tencent.mm.danmaku.c.a parama)
  {
    AppMethodBeat.i(241606);
    this.gNL = true;
    this.gNX = new LinkedBlockingDeque();
    this.gNY = new LinkedList();
    this.gOd = new Object();
    this.gOe = true;
    this.gOf = 0;
    this.gNt = parama;
    if ((paramView instanceof SurfaceView))
    {
      paramView = new com.tencent.mm.danmaku.render.f((SurfaceView)paramView);
      this.gNE = paramView;
      if (this.gNE == null) {
        break label343;
      }
      this.gNE.a(this);
      this.gNE.setOnTouchListener(this);
      this.gNv = new com.tencent.mm.danmaku.d.f();
      this.gNw = new com.tencent.mm.danmaku.d.c();
      this.gNu = new b();
      this.gNH = new h(parama);
      paramView = new g.a();
      this.gNF = new e(this.gNv, paramView);
      this.gNZ = a.a(parama, this.gNu, paramView, this.gNv, this.gNw);
      this.gNG = new f(parama);
      this.gOc = new i(this);
      if ((this.gNE instanceof NativeDanmakuView)) {
        this.gOc.gOC = 1;
      }
      if ((Build.VERSION.SDK_INT < 16) || (!(this.gNE instanceof NativeDanmakuView))) {
        break label360;
      }
    }
    label343:
    label360:
    for (this.gOf = 0;; this.gOf = 1)
    {
      if (this.gOf == 0) {
        this.gOg = new a((byte)0);
      }
      AppMethodBeat.o(241606);
      return;
      if ((paramView instanceof TextureView))
      {
        paramView = new com.tencent.mm.danmaku.render.g((TextureView)paramView);
        break;
      }
      if ((paramView instanceof NativeDanmakuView))
      {
        paramView = new com.tencent.mm.danmaku.render.e((NativeDanmakuView)paramView);
        break;
      }
      paramView = null;
      break;
      paramView = new RuntimeException("root view not a IDanmakuView");
      AppMethodBeat.o(241606);
      throw paramView;
    }
  }
  
  private boolean arV()
  {
    AppMethodBeat.i(241612);
    Object localObject1 = this.gNv;
    long l1;
    if (this.gNt.isLive()) {
      l1 = SystemClock.uptimeMillis() - this.gNI;
    }
    Object localObject2;
    int i;
    label565:
    boolean bool1;
    for (;;)
    {
      ((com.tencent.mm.danmaku.d.f)localObject1).gQA = l1;
      localObject1 = this.gNw;
      ((com.tencent.mm.danmaku.d.c)localObject1).gQw = (SystemClock.uptimeMillis() - ((com.tencent.mm.danmaku.d.c)localObject1).gNI);
      ((com.tencent.mm.danmaku.d.c)localObject1).gQv += ((com.tencent.mm.danmaku.d.c)localObject1).gQw;
      ((com.tencent.mm.danmaku.d.c)localObject1).gNI = SystemClock.uptimeMillis();
      if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.gNw.gQv), ",lastInterval:", Long.valueOf(this.gNw.gQw) });
      }
      if (this.gNK)
      {
        this.gNZ.arQ();
        this.gNK = false;
      }
      try
      {
        if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
          this.gNM = SystemClock.uptimeMillis();
        }
        localObject2 = this.gNF;
        ((e)localObject2).asm();
        com.tencent.mm.danmaku.d.g localg = ((e)localObject2).gOl;
        l1 = ((e)localObject2).gNv.gQA;
        Object localObject3 = ((e)localObject2).gOk;
        localObject1 = localg.gQB.gQD;
        i = 0;
        for (;;)
        {
          if ((i < 3) && (localObject1 != localg.gQB) && (localg.gQC.m(((com.tencent.mm.danmaku.d.g.a)localObject1).mData, l1) <= 0))
          {
            int j = i;
            if (localObject3 != null)
            {
              ((List)localObject3).add(((com.tencent.mm.danmaku.d.g.a)localObject1).mData);
              j = i + 1;
            }
            localg.mSize -= 1;
            localObject1 = ((com.tencent.mm.danmaku.d.g.a)localObject1).gQD;
            i = j;
            continue;
            l1 = SystemClock.uptimeMillis();
            if (l1 - this.gNT >= 200L)
            {
              this.gNT = l1;
              l1 = this.gNt.asQ();
              this.gNU = l1;
              break;
            }
            l1 = l1 + this.gNU - this.gNT;
            break;
          }
        }
        if ((c.gNA) && (com.tencent.mm.danmaku.f.d.isEmpty((Collection)localObject3)))
        {
          if (localg.gQB.gQD != localg.gQB) {
            break label705;
          }
          i = 1;
          if ((i == 0) && ((((com.tencent.mm.danmaku.d.g.a)localObject1).mData instanceof com.tencent.mm.danmaku.b.a)))
          {
            localObject3 = (com.tencent.mm.danmaku.b.a)((com.tencent.mm.danmaku.d.g.a)localObject1).mData;
            long l2 = Math.abs(((com.tencent.mm.danmaku.b.a)localObject3).getTime() - l1);
            if (l2 > 60000L) {
              com.tencent.mm.danmaku.e.e.w("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l2 + " , curTime = " + l1 + ", curDanmaku = " + localObject3);
            }
          }
        }
        localg.gQB.gQD = ((com.tencent.mm.danmaku.d.g.a)localObject1);
        ((com.tencent.mm.danmaku.d.g.a)localObject1).gQE = localg.gQB;
        ((e)localObject2).aa(((e)localObject2).gOk);
        ((e)localObject2).asn();
        localObject1 = ((e)localObject2).gOk;
        if (com.tencent.mm.danmaku.e.e.gQV >= 4)
        {
          i = ((List)localObject1).size();
          if (i > 0) {
            com.tencent.mm.danmaku.e.e.d("DanmakuManager", new Object[] { "new danmaku to draw:", Integer.valueOf(i) });
          }
        }
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.danmaku.b.a)((Iterator)localObject1).next();
            ((Iterator)localObject1).remove();
            com.tencent.mm.danmaku.e.e.i("DanmakuManager", "upload, danmaku = ".concat(String.valueOf(localObject2)));
            if (((com.tencent.mm.danmaku.b.a)localObject2).yY(this.gNv.gQA))
            {
              if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
                com.tencent.mm.danmaku.e.e.d("DanmakuManager", new Object[] { "before measure ", localObject2, " is out side" });
              }
              this.gNY.add(localObject2);
              continue;
              com.tencent.mm.danmaku.e.e.e("DanmakuManager", localThrowable1.toString(), localThrowable1);
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      for (;;)
      {
        AppMethodBeat.o(241612);
        return bool2;
        label705:
        i = 0;
        break;
        if ((com.tencent.mm.danmaku.e.e.gQV >= 4) && (((com.tencent.mm.danmaku.b.a)localObject2).asM())) {
          com.tencent.mm.danmaku.e.e.d("MustShowDMComment", "不可淘汰弹幕从数据源的绘制列表中取出加入到Window中:".concat(String.valueOf(localObject2)));
        }
        ((com.tencent.mm.danmaku.b.a)localObject2).ze(this.gNw.gQv);
        this.gNZ.a((com.tencent.mm.danmaku.b.a)localObject2);
        break label565;
        if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
          this.gNN = SystemClock.uptimeMillis();
        }
        this.gNZ.layout();
        if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
          this.gNO = SystemClock.uptimeMillis();
        }
        bool1 = arX();
        bool2 = bool1;
        if (bool1) {
          try
          {
            arZ();
            bool2 = bool1;
          }
          catch (Throwable localThrowable2) {}
        }
      }
    }
  }
  
  private boolean arW()
  {
    return (this.gOf == 0) && (this.gOg != null);
  }
  
  private boolean arX()
  {
    AppMethodBeat.i(241614);
    try
    {
      Canvas localCanvas = this.gNE.lockCanvas();
      if (localCanvas != null)
      {
        draw(localCanvas);
        AppMethodBeat.o(241614);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.danmaku.e.e.e("surface_lock", "draw exception " + "null", localThrowable);
        Object localObject = null;
      }
      arY();
      AppMethodBeat.o(241614);
    }
    return false;
  }
  
  private void arY()
  {
    AppMethodBeat.i(241617);
    asd();
    if (this.gOb == null) {
      this.gOb = new d.b()
      {
        public final void l(Canvas arg1)
        {
          AppMethodBeat.i(241601);
          d.a(d.this, ???);
          synchronized (d.b(d.this))
          {
            d.c(d.this);
            d.b(d.this).notifyAll();
            d.a(d.this).sendMessage(12);
            AppMethodBeat.o(241601);
            return;
          }
        }
      };
    }
    this.gNE.a(this.gOb);
    synchronized (this.gOd)
    {
      for (;;)
      {
        if (this.gOe) {
          break label106;
        }
        boolean bool = asa();
        if (!bool) {
          break label106;
        }
        try
        {
          this.gOd.wait(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          if (!asa()) {
            break label106;
          }
        }
      }
      Thread.currentThread().interrupt();
    }
    label106:
    this.gOe = false;
    AppMethodBeat.o(241617);
  }
  
  private void arZ()
  {
    AppMethodBeat.i(241618);
    this.gNY.addAll(this.gNZ.arS());
    this.gNZ.arT();
    Object localObject1 = this.gNY.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.danmaku.b.a)((Iterator)localObject1).next();
      localObject3 = ((com.tencent.mm.danmaku.b.a)localObject2).asJ();
      if (localObject3 != null)
      {
        ((com.tencent.mm.danmaku.b.a)localObject2).w(null);
        ((com.tencent.mm.danmaku.b.a)localObject2).asL();
        this.gNu.gNx.x((Bitmap)localObject3);
      }
    }
    Object localObject3 = this.gNY.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)((Iterator)localObject3).next();
      this.gNt.e(locala).h(locala);
      f localf = this.gNG;
      int i = locala.getType();
      localObject2 = (BlockingQueue)localf.gOp.get(i);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedBlockingQueue();
        localf.gOp.put(i, localObject1);
      }
      if (300 > ((BlockingQueue)localObject1).size()) {
        ((BlockingQueue)localObject1).add(locala);
      }
    }
    this.gNY.clear();
    AppMethodBeat.o(241618);
  }
  
  private void asc()
  {
    AppMethodBeat.i(241623);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "resumeUpdateMessage()");
    if (isPlaying()) {
      this.gOc.asq();
    }
    AppMethodBeat.o(241623);
  }
  
  private void asd()
  {
    AppMethodBeat.i(241624);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "removeUpdateMessage()");
    this.gOc.asp();
    AppMethodBeat.o(241624);
  }
  
  private void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241615);
    if (paramCanvas != null) {}
    try
    {
      com.tencent.mm.danmaku.e.d.n(paramCanvas);
      this.gNZ.h(paramCanvas);
      k(paramCanvas);
      try
      {
        j(paramCanvas);
        AppMethodBeat.o(241615);
        return;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.danmaku.e.e.e("surface_lock", "unlockCanvas exception " + paramCanvas.hashCode(), localThrowable1);
        AppMethodBeat.o(241615);
        return;
      }
      try
      {
        StringBuilder localStringBuilder;
        Object localObject1;
        int i;
        j(paramCanvas);
        AppMethodBeat.o(241615);
        throw localObject2;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          com.tencent.mm.danmaku.e.e.e("surface_lock", "unlockCanvas exception " + paramCanvas.hashCode(), localThrowable4);
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      localThrowable3 = localThrowable3;
      localStringBuilder = new StringBuilder("draw exception ");
      if (paramCanvas == null) {}
      for (localObject1 = "null";; localObject1 = Integer.valueOf(i))
      {
        com.tencent.mm.danmaku.e.e.e("surface_lock", localObject1, localThrowable3);
        try
        {
          j(paramCanvas);
          AppMethodBeat.o(241615);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.danmaku.e.e.e("surface_lock", "unlockCanvas exception " + paramCanvas.hashCode(), localThrowable2);
          AppMethodBeat.o(241615);
          return;
        }
        i = paramCanvas.hashCode();
      }
    }
    finally {}
  }
  
  private void j(Canvas paramCanvas)
  {
    AppMethodBeat.i(241616);
    if (paramCanvas != null)
    {
      if (this.gND)
      {
        this.gNE.unlockCanvasAndPost(paramCanvas);
        AppMethodBeat.o(241616);
        return;
      }
      this.gNE.unlock();
    }
    AppMethodBeat.o(241616);
  }
  
  private void k(Canvas paramCanvas)
  {
    AppMethodBeat.i(241619);
    StringBuilder localStringBuilder;
    long l1;
    if (com.tencent.mm.danmaku.e.e.gQV >= 4)
    {
      long l2 = SystemClock.uptimeMillis();
      long l3 = l2 - this.gNM;
      this.gNP += 1;
      this.gNR = ((int)(this.gNR + l3));
      if (l3 > m.gPS + 1)
      {
        this.gNQ += 1;
        if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
          com.tencent.mm.danmaku.e.e.w("DanmakuManager", "a draw block:".concat(String.valueOf(l3)));
        }
      }
      localObject = this.gNF.asl();
      if (this.gNP % 60 == 1)
      {
        localStringBuilder = new StringBuilder().append(com.tencent.mm.danmaku.e.e.gQV).append(",t:").append(com.tencent.mm.danmaku.e.c.zg(SystemClock.uptimeMillis())).append(",f:");
        if (this.gNw.gQw != 0L) {
          break label488;
        }
        l1 = 1L;
        localStringBuilder = localStringBuilder.append(1000L / l1).append(",ds:").append(this.gNZ.arR()).append(",ts:").append(this.gNF.gOl.mSize).append(",mt:").append(gNW.format(this.gNN - this.gNM)).append(",lt:").append(gNW.format(this.gNO - this.gNN)).append(",dt:").append(gNW.format(l2 - this.gNO)).append(",tt:").append(gNW.format(l3)).append(",jp:").append(gNV.format(this.gNQ * 100.0F / this.gNP)).append("%,at:").append(gNV.format(this.gNR / this.gNP)).append(",fd:");
        if (localObject != null) {
          break label499;
        }
      }
    }
    label488:
    label499:
    for (Object localObject = "null";; localObject = com.tencent.mm.danmaku.e.c.zg(((com.tencent.mm.danmaku.b.a)localObject).getTime()))
    {
      this.gNS = ((String)localObject + ",cs:" + gNV.format(this.gNu.gNx.gQp / 1024.0F / 1024.0F) + ",uc:" + gNV.format(this.gNu.gNx.gQr * 100.0F / this.gNu.gNx.gQq));
      if (this.gNS != null) {
        com.tencent.mm.danmaku.e.d.a(paramCanvas, this.gNS);
      }
      AppMethodBeat.o(241619);
      return;
      l1 = this.gNw.gQw;
      break;
    }
  }
  
  private void yX(long paramLong)
  {
    AppMethodBeat.i(241613);
    if (arW())
    {
      AppMethodBeat.o(241613);
      return;
    }
    asd();
    if (asa())
    {
      i locali = this.gOc;
      if (locali.asr())
      {
        locali.gOz.removeMessages(4);
        locali.gOz.sendEmptyMessageDelayed(4, paramLong);
      }
    }
    AppMethodBeat.o(241613);
  }
  
  protected final boolean asa()
  {
    AppMethodBeat.i(241620);
    if ((this.gND) && (!this.gNB) && (this.gNC)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.danmaku.e.e.v("DanmakuManager", "isPrepared() = " + bool + ", mIsSurfaceCreated = " + this.gND + ", mIsQuited = " + this.gNB + ", mIsPlaying = " + this.gNC);
      AppMethodBeat.o(241620);
      return bool;
    }
  }
  
  protected final void asb()
  {
    AppMethodBeat.i(241622);
    com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleResume()");
    if (!this.gNC)
    {
      long l = SystemClock.uptimeMillis();
      this.gNI = (l - this.gNJ);
      if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
        com.tencent.mm.danmaku.e.e.d("DanmakuManager", "handleResume, mBaseTime = " + this.gNI + ", currentTime = " + l + ", mPauseTime = " + this.gNJ);
      }
      this.gNw.gNI = SystemClock.uptimeMillis();
    }
    this.gNC = true;
    this.gNS = null;
    asc();
    if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
      com.tencent.mm.danmaku.e.e.d("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.gNJ), ",mBaseTime:", Long.valueOf(this.gNI) });
    }
    AppMethodBeat.o(241622);
  }
  
  @SuppressLint({"NewApi"})
  protected final void ase()
  {
    AppMethodBeat.i(241625);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "handleUpdate()");
    asd();
    if (asa())
    {
      if (arW()) {
        Choreographer.getInstance().postFrameCallback(this.gOg);
      }
      long l = SystemClock.uptimeMillis();
      if (arV()) {
        yX(l + m.gPS - SystemClock.uptimeMillis());
      }
    }
    AppMethodBeat.o(241625);
  }
  
  protected final void asf()
  {
    AppMethodBeat.i(241626);
    com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handlePause()");
    asd();
    this.gNC = false;
    if (this.gNt.isLive()) {}
    for (long l = this.gNv.gQA;; l = this.gNw.gQv)
    {
      this.gNJ = l;
      if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.gNJ) });
      }
      AppMethodBeat.o(241626);
      return;
    }
  }
  
  public final void asg()
  {
    AppMethodBeat.i(241628);
    com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceCreated");
    AppMethodBeat.o(241628);
  }
  
  public final void ash()
  {
    AppMethodBeat.i(241629);
    com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceChanged");
    this.gND = true;
    asc();
    AppMethodBeat.o(241629);
  }
  
  public final void asi()
  {
    AppMethodBeat.i(241630);
    this.gND = false;
    asd();
    com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceDestroyed");
    AppMethodBeat.o(241630);
  }
  
  protected final void asj()
  {
    AppMethodBeat.i(241632);
    arZ();
    yX(4L);
    AppMethodBeat.o(241632);
  }
  
  protected final void ask()
  {
    AppMethodBeat.i(241633);
    com.tencent.mm.danmaku.e.e.i("surface_lock", "handleClearDrawingCache");
    asd();
    if (this.gND)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      try
      {
        Canvas localCanvas = this.gNE.lockCanvas();
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        StringBuilder localStringBuilder = new StringBuilder("clearDrawing lockCanvas ");
        if (localCanvas == null) {}
        for (Object localObject4 = "null";; localObject4 = Integer.valueOf(i))
        {
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          com.tencent.mm.danmaku.e.e.i("surface_lock", localObject4);
          if (localCanvas != null)
          {
            localObject1 = localCanvas;
            localObject3 = localCanvas;
            com.tencent.mm.danmaku.e.d.n(localCanvas);
          }
          if (localCanvas != null) {}
          try
          {
            this.gNE.unlockCanvasAndPost(localCanvas);
            com.tencent.mm.danmaku.e.e.i("surface_lock", "clearDrawing unlockCanvas " + localCanvas.hashCode());
            AppMethodBeat.o(241633);
            return;
          }
          catch (Throwable localThrowable1)
          {
            int i;
            com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localCanvas.hashCode(), localThrowable1);
            AppMethodBeat.o(241633);
            return;
          }
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          i = localCanvas.hashCode();
        }
        try
        {
          this.gNE.unlockCanvasAndPost(localThrowable2);
          com.tencent.mm.danmaku.e.e.i("surface_lock", "clearDrawing unlockCanvas " + localThrowable2.hashCode());
          AppMethodBeat.o(241633);
          throw localObject2;
        }
        catch (Throwable localThrowable4)
        {
          for (;;)
          {
            com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable2.hashCode(), localThrowable4);
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject3 = localThrowable1;
        com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing lockCanvas exception: " + localThrowable1.hashCode(), localThrowable3);
        if (localThrowable1 != null) {}
        try
        {
          this.gNE.unlockCanvasAndPost(localThrowable1);
          com.tencent.mm.danmaku.e.e.i("surface_lock", "clearDrawing unlockCanvas " + localThrowable1.hashCode());
          AppMethodBeat.o(241633);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable1.hashCode(), localThrowable2);
          AppMethodBeat.o(241633);
          return;
        }
      }
      finally
      {
        if (localThrowable2 == null) {}
      }
    }
    AppMethodBeat.o(241633);
  }
  
  protected final void c(Point paramPoint)
  {
    AppMethodBeat.i(241607);
    paramPoint.y = ((int)(paramPoint.y - this.gNE.atd()));
    paramPoint = new com.tencent.mm.danmaku.d.h(this.gNw.gQv, paramPoint, 0);
    if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
      com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "addClickPoint:", paramPoint });
    }
    this.gNX.add(paramPoint);
    this.gOc.sendMessage(10);
    AppMethodBeat.o(241607);
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(241610);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "clear");
    this.gOc.sendMessage(9);
    if (this.gNF != null) {
      this.gNF.clear();
    }
    AppMethodBeat.o(241610);
  }
  
  protected final void i(Message paramMessage)
  {
    AppMethodBeat.i(241627);
    StringBuilder localStringBuilder = new StringBuilder("handleSeek() msg.obj is null = ");
    if (paramMessage.obj == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.danmaku.e.e.i("DanmakuManager", bool);
      if (paramMessage.obj != null)
      {
        this.gNJ = ((Long)paramMessage.obj).longValue();
        this.gNK = true;
        asb();
      }
      if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.gNJ) });
      }
      AppMethodBeat.o(241627);
      return;
    }
  }
  
  protected final boolean isPlaying()
  {
    AppMethodBeat.i(241621);
    if ((!this.gNB) && (this.gNC)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.danmaku.e.e.d("DanmakuManager", "isPlaying() = " + bool + " : mIsQuited = " + this.gNB + ", mIsPlaying = " + this.gNC);
      AppMethodBeat.o(241621);
      return bool;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(241631);
    if (this.gNL)
    {
      if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "onClick:", paramMotionEvent });
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0) {
        c(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
      }
    }
    AppMethodBeat.o(241631);
    return false;
  }
  
  protected final void pause()
  {
    AppMethodBeat.i(241609);
    com.tencent.mm.danmaku.e.e.i("DanmakuManager", "pause()");
    this.gOc.sendMessage(3);
    AppMethodBeat.o(241609);
  }
  
  protected final void release()
  {
    AppMethodBeat.i(241611);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "release() mIsQuited = " + this.gNB);
    if (!this.gNB)
    {
      com.tencent.mm.danmaku.e.e.v("DanmakuManager", "quit(); mIsQuited = true");
      this.gNB = true;
      this.gOc.sendMessage(6);
      if (arW()) {
        Choreographer.getInstance().removeFrameCallback(this.gOg);
      }
      asd();
    }
    this.gOc.sendMessage(8);
    this.gOa = null;
    AppMethodBeat.o(241611);
  }
  
  protected final void resume()
  {
    AppMethodBeat.i(241608);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "resume()");
    this.gOc.sendMessage(2);
    AppMethodBeat.o(241608);
  }
  
  @SuppressLint({"NewApi"})
  final class a
    implements Choreographer.FrameCallback
  {
    private a() {}
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(241605);
      if (d.this.asa()) {
        d.a(d.this).asq();
      }
      AppMethodBeat.o(241605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.d
 * JD-Core Version:    0.7.0.1
 */