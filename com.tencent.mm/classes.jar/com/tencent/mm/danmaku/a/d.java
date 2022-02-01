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
  private static final DecimalFormat jyq;
  private static final DecimalFormat jyr;
  com.tencent.mm.danmaku.c.a jxO;
  final b jxP;
  private final com.tencent.mm.danmaku.d.f jxQ;
  final com.tencent.mm.danmaku.d.c jxR;
  volatile boolean jxW;
  private volatile boolean jxX;
  private volatile boolean jxY;
  private final com.tencent.mm.danmaku.render.d jxZ;
  private int jyA;
  private a jyB;
  final e jya;
  final f jyb;
  final h jyc;
  private long jyd;
  long jye;
  boolean jyf;
  private volatile boolean jyg;
  private long jyh;
  private long jyi;
  private long jyj;
  int jyk;
  int jyl;
  int jym;
  private String jyn;
  private long jyo;
  private long jyp;
  final Queue<com.tencent.mm.danmaku.d.h> jys;
  private final List<com.tencent.mm.danmaku.b.a> jyt;
  final a jyu;
  g.b jyv;
  private d.b jyw;
  i jyx;
  private Object jyy;
  private boolean jyz;
  
  static
  {
    AppMethodBeat.i(247698);
    jyq = new DecimalFormat("00.00");
    jyr = new DecimalFormat("00");
    AppMethodBeat.o(247698);
  }
  
  protected d(View paramView, com.tencent.mm.danmaku.c.a parama)
  {
    AppMethodBeat.i(247633);
    this.jyg = true;
    this.jys = new LinkedBlockingDeque();
    this.jyt = new LinkedList();
    this.jyy = new Object();
    this.jyz = true;
    this.jyA = 0;
    this.jxO = parama;
    if ((paramView instanceof SurfaceView))
    {
      paramView = new com.tencent.mm.danmaku.render.f((SurfaceView)paramView);
      this.jxZ = paramView;
      if (this.jxZ == null) {
        break label343;
      }
      this.jxZ.a(this);
      this.jxZ.setOnTouchListener(this);
      this.jxQ = new com.tencent.mm.danmaku.d.f();
      this.jxR = new com.tencent.mm.danmaku.d.c();
      this.jxP = new b();
      this.jyc = new h(parama);
      paramView = new g.a();
      this.jya = new e(this.jxQ, paramView);
      this.jyu = a.a(parama, this.jxP, paramView, this.jxQ, this.jxR);
      this.jyb = new f(parama);
      this.jyx = new i(this);
      if ((this.jxZ instanceof NativeDanmakuView)) {
        this.jyx.jyW = 1;
      }
      if ((Build.VERSION.SDK_INT < 16) || (!(this.jxZ instanceof NativeDanmakuView))) {
        break label360;
      }
    }
    label343:
    label360:
    for (this.jyA = 0;; this.jyA = 1)
    {
      if (this.jyA == 0) {
        this.jyB = new a((byte)0);
      }
      AppMethodBeat.o(247633);
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
      AppMethodBeat.o(247633);
      throw paramView;
    }
  }
  
  private void Fb(long paramLong)
  {
    AppMethodBeat.i(247661);
    if (ayJ())
    {
      AppMethodBeat.o(247661);
      return;
    }
    ayQ();
    if (ayN())
    {
      i locali = this.jyx;
      if (locali.azf())
      {
        locali.jyT.removeMessages(4);
        locali.jyT.sendEmptyMessageDelayed(4, paramLong);
      }
    }
    AppMethodBeat.o(247661);
  }
  
  private boolean ayI()
  {
    AppMethodBeat.i(247659);
    Object localObject1 = this.jxQ;
    long l1;
    if (this.jxO.isLive()) {
      l1 = SystemClock.uptimeMillis() - this.jyd;
    }
    Object localObject2;
    int i;
    label566:
    boolean bool1;
    for (;;)
    {
      ((com.tencent.mm.danmaku.d.f)localObject1).jAT = l1;
      localObject1 = this.jxR;
      ((com.tencent.mm.danmaku.d.c)localObject1).jAP = (SystemClock.uptimeMillis() - ((com.tencent.mm.danmaku.d.c)localObject1).jyd);
      ((com.tencent.mm.danmaku.d.c)localObject1).jAO += ((com.tencent.mm.danmaku.d.c)localObject1).jAP;
      ((com.tencent.mm.danmaku.d.c)localObject1).jyd = SystemClock.uptimeMillis();
      if (com.tencent.mm.danmaku.e.e.jBo >= 5) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.jxR.jAO), ",lastInterval:", Long.valueOf(this.jxR.jAP) });
      }
      if (this.jyf)
      {
        this.jyu.ayB();
        this.jyf = false;
      }
      try
      {
        if (com.tencent.mm.danmaku.e.e.jBo >= 4) {
          this.jyh = SystemClock.uptimeMillis();
        }
        localObject2 = this.jya;
        ((e)localObject2).ayZ();
        com.tencent.mm.danmaku.d.g localg = ((e)localObject2).jyG;
        l1 = ((e)localObject2).jxQ.jAT;
        Object localObject3 = ((e)localObject2).jyF;
        localObject1 = localg.jAU.jAW;
        i = 0;
        for (;;)
        {
          if ((i < 3) && (localObject1 != localg.jAU) && (localg.jAV.j(((com.tencent.mm.danmaku.d.g.a)localObject1).mData, l1) <= 0))
          {
            int j = i;
            if (localObject3 != null)
            {
              ((List)localObject3).add(((com.tencent.mm.danmaku.d.g.a)localObject1).mData);
              j = i + 1;
            }
            localg.mSize -= 1;
            localObject1 = ((com.tencent.mm.danmaku.d.g.a)localObject1).jAW;
            i = j;
            continue;
            l1 = SystemClock.uptimeMillis();
            if (l1 - this.jyo >= 200L)
            {
              this.jyo = l1;
              l1 = this.jxO.azE();
              this.jyp = l1;
              break;
            }
            l1 = l1 + this.jyp - this.jyo;
            break;
          }
        }
        if ((c.jxV) && (com.tencent.mm.danmaku.f.d.isEmpty((Collection)localObject3)))
        {
          if (localg.jAU.jAW != localg.jAU) {
            break label707;
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
        localg.jAU.jAW = ((com.tencent.mm.danmaku.d.g.a)localObject1);
        ((com.tencent.mm.danmaku.d.g.a)localObject1).jAX = localg.jAU;
        ((e)localObject2).X(((e)localObject2).jyF);
        ((e)localObject2).aza();
        localObject1 = ((e)localObject2).jyF;
        if (com.tencent.mm.danmaku.e.e.jBo >= 4)
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
            if (((com.tencent.mm.danmaku.b.a)localObject2).Fc(this.jxQ.jAT))
            {
              if (com.tencent.mm.danmaku.e.e.jBo >= 4) {
                com.tencent.mm.danmaku.e.e.d("DanmakuManager", new Object[] { "before measure ", localObject2, " is out side" });
              }
              this.jyt.add(localObject2);
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
        AppMethodBeat.o(247659);
        return bool2;
        label707:
        i = 0;
        break;
        if ((com.tencent.mm.danmaku.e.e.jBo >= 4) && (((com.tencent.mm.danmaku.b.a)localObject2).azA())) {
          com.tencent.mm.danmaku.e.e.d("MustShowDMComment", "不可淘汰弹幕从数据源的绘制列表中取出加入到Window中:".concat(String.valueOf(localObject2)));
        }
        ((com.tencent.mm.danmaku.b.a)localObject2).Fi(this.jxR.jAO);
        this.jyu.a((com.tencent.mm.danmaku.b.a)localObject2);
        break label566;
        if (com.tencent.mm.danmaku.e.e.jBo >= 4) {
          this.jyi = SystemClock.uptimeMillis();
        }
        this.jyu.fP();
        if (com.tencent.mm.danmaku.e.e.jBo >= 4) {
          this.jyj = SystemClock.uptimeMillis();
        }
        bool1 = ayK();
        bool2 = bool1;
        if (bool1) {
          try
          {
            ayM();
            bool2 = bool1;
          }
          catch (Throwable localThrowable2) {}
        }
      }
    }
  }
  
  private boolean ayJ()
  {
    return (this.jyA == 0) && (this.jyB != null);
  }
  
  private boolean ayK()
  {
    AppMethodBeat.i(247662);
    try
    {
      Canvas localCanvas = this.jxZ.azQ();
      if (localCanvas != null)
      {
        draw(localCanvas);
        AppMethodBeat.o(247662);
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
      ayL();
      AppMethodBeat.o(247662);
    }
    return false;
  }
  
  private void ayL()
  {
    AppMethodBeat.i(247668);
    ayQ();
    if (this.jyw == null) {
      this.jyw = new d.b()
      {
        public final void m(Canvas arg1)
        {
          AppMethodBeat.i(289992);
          d.a(d.this, ???);
          synchronized (d.b(d.this))
          {
            d.c(d.this);
            d.b(d.this).notifyAll();
            d.a(d.this).sendMessage(12);
            AppMethodBeat.o(289992);
            return;
          }
        }
      };
    }
    this.jxZ.a(this.jyw);
    synchronized (this.jyy)
    {
      for (;;)
      {
        if (this.jyz) {
          break label106;
        }
        boolean bool = ayN();
        if (!bool) {
          break label106;
        }
        try
        {
          this.jyy.wait(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          if (!ayN()) {
            break label106;
          }
        }
      }
      Thread.currentThread().interrupt();
    }
    label106:
    this.jyz = false;
    AppMethodBeat.o(247668);
  }
  
  private void ayM()
  {
    AppMethodBeat.i(247669);
    this.jyt.addAll(this.jyu.ayD());
    this.jyu.ayE();
    Object localObject1 = this.jyt.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.danmaku.b.a)((Iterator)localObject1).next();
      localObject3 = ((com.tencent.mm.danmaku.b.a)localObject2).azx();
      if (localObject3 != null)
      {
        ((com.tencent.mm.danmaku.b.a)localObject2).r(null);
        ((com.tencent.mm.danmaku.b.a)localObject2).azz();
        this.jxP.jxS.s((Bitmap)localObject3);
      }
    }
    Object localObject3 = this.jyt.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)((Iterator)localObject3).next();
      this.jxO.d(locala).g(locala);
      f localf = this.jyb;
      int i = locala.getType();
      localObject2 = (BlockingQueue)localf.jyK.get(i);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedBlockingQueue();
        localf.jyK.put(i, localObject1);
      }
      if (300 > ((BlockingQueue)localObject1).size()) {
        ((BlockingQueue)localObject1).add(locala);
      }
    }
    this.jyt.clear();
    AppMethodBeat.o(247669);
  }
  
  private void ayP()
  {
    AppMethodBeat.i(247677);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "resumeUpdateMessage()");
    if (isPlaying()) {
      this.jyx.aze();
    }
    AppMethodBeat.o(247677);
  }
  
  private void ayQ()
  {
    AppMethodBeat.i(247678);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "removeUpdateMessage()");
    this.jyx.azd();
    AppMethodBeat.o(247678);
  }
  
  private void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(247665);
    if (paramCanvas != null) {}
    try
    {
      com.tencent.mm.danmaku.e.d.p(paramCanvas);
      this.jyu.i(paramCanvas);
      l(paramCanvas);
      try
      {
        k(paramCanvas);
        AppMethodBeat.o(247665);
        return;
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.danmaku.e.e.e("surface_lock", "unlockCanvas exception " + paramCanvas.hashCode(), localThrowable1);
        AppMethodBeat.o(247665);
        return;
      }
      try
      {
        StringBuilder localStringBuilder;
        Object localObject1;
        int i;
        k(paramCanvas);
        AppMethodBeat.o(247665);
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
          k(paramCanvas);
          AppMethodBeat.o(247665);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.danmaku.e.e.e("surface_lock", "unlockCanvas exception " + paramCanvas.hashCode(), localThrowable2);
          AppMethodBeat.o(247665);
          return;
        }
        i = paramCanvas.hashCode();
      }
    }
    finally {}
  }
  
  private void k(Canvas paramCanvas)
  {
    AppMethodBeat.i(247666);
    if (paramCanvas != null)
    {
      if (this.jxY)
      {
        this.jxZ.o(paramCanvas);
        AppMethodBeat.o(247666);
        return;
      }
      this.jxZ.unlock();
    }
    AppMethodBeat.o(247666);
  }
  
  private void l(Canvas paramCanvas)
  {
    AppMethodBeat.i(247671);
    StringBuilder localStringBuilder;
    long l1;
    if (com.tencent.mm.danmaku.e.e.jBo >= 4)
    {
      long l2 = SystemClock.uptimeMillis();
      long l3 = l2 - this.jyh;
      this.jyk += 1;
      this.jym = ((int)(this.jym + l3));
      if (l3 > m.jAl + 1)
      {
        this.jyl += 1;
        if (com.tencent.mm.danmaku.e.e.jBo >= 5) {
          com.tencent.mm.danmaku.e.e.w("DanmakuManager", "a draw block:".concat(String.valueOf(l3)));
        }
      }
      localObject = this.jya.ayY();
      if (this.jyk % 60 == 1)
      {
        localStringBuilder = new StringBuilder().append(com.tencent.mm.danmaku.e.e.jBo).append(",t:").append(com.tencent.mm.danmaku.e.c.Fk(SystemClock.uptimeMillis())).append(",f:");
        if (this.jxR.jAP != 0L) {
          break label488;
        }
        l1 = 1L;
        localStringBuilder = localStringBuilder.append(1000L / l1).append(",ds:").append(this.jyu.ayC()).append(",ts:").append(this.jya.jyG.mSize).append(",mt:").append(jyr.format(this.jyi - this.jyh)).append(",lt:").append(jyr.format(this.jyj - this.jyi)).append(",dt:").append(jyr.format(l2 - this.jyj)).append(",tt:").append(jyr.format(l3)).append(",jp:").append(jyq.format(this.jyl * 100.0F / this.jyk)).append("%,at:").append(jyq.format(this.jym / this.jyk)).append(",fd:");
        if (localObject != null) {
          break label499;
        }
      }
    }
    label488:
    label499:
    for (Object localObject = "null";; localObject = com.tencent.mm.danmaku.e.c.Fk(((com.tencent.mm.danmaku.b.a)localObject).getTime()))
    {
      this.jyn = ((String)localObject + ",cs:" + jyq.format(this.jxP.jxS.jAI / 1024.0F / 1024.0F) + ",uc:" + jyq.format(this.jxP.jxS.jAK * 100.0F / this.jxP.jxS.jAJ));
      if (this.jyn != null) {
        com.tencent.mm.danmaku.e.d.a(paramCanvas, this.jyn);
      }
      AppMethodBeat.o(247671);
      return;
      l1 = this.jxR.jAP;
      break;
    }
  }
  
  protected final void ayG()
  {
    AppMethodBeat.i(247642);
    com.tencent.mm.danmaku.e.e.i("DanmakuManager", "clearDrawingCache()");
    this.jyx.sendMessage(11);
    AppMethodBeat.o(247642);
  }
  
  protected final void ayH()
  {
    AppMethodBeat.i(247656);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "notifyConfigChanged()");
    this.jyx.rq(this.jxO.jzW);
    this.jyx.sendMessage(7);
    AppMethodBeat.o(247656);
  }
  
  protected final boolean ayN()
  {
    AppMethodBeat.i(247672);
    if ((this.jxY) && (!this.jxW) && (this.jxX)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.danmaku.e.e.v("DanmakuManager", "isPrepared() = " + bool + ", mIsSurfaceCreated = " + this.jxY + ", mIsQuited = " + this.jxW + ", mIsPlaying = " + this.jxX);
      AppMethodBeat.o(247672);
      return bool;
    }
  }
  
  protected final void ayO()
  {
    AppMethodBeat.i(247675);
    com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleResume()");
    if (!this.jxX)
    {
      long l = SystemClock.uptimeMillis();
      this.jyd = (l - this.jye);
      if (com.tencent.mm.danmaku.e.e.jBo >= 5) {
        com.tencent.mm.danmaku.e.e.d("DanmakuManager", "handleResume, mBaseTime = " + this.jyd + ", currentTime = " + l + ", mPauseTime = " + this.jye);
      }
      this.jxR.jyd = SystemClock.uptimeMillis();
    }
    this.jxX = true;
    this.jyn = null;
    ayP();
    if (com.tencent.mm.danmaku.e.e.jBo >= 5) {
      com.tencent.mm.danmaku.e.e.d("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.jye), ",mBaseTime:", Long.valueOf(this.jyd) });
    }
    AppMethodBeat.o(247675);
  }
  
  @SuppressLint({"NewApi"})
  protected final void ayR()
  {
    AppMethodBeat.i(247680);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "handleUpdate()");
    ayQ();
    if (ayN())
    {
      if (ayJ()) {
        Choreographer.getInstance().postFrameCallback(this.jyB);
      }
      long l = SystemClock.uptimeMillis();
      if (ayI()) {
        Fb(l + m.jAl - SystemClock.uptimeMillis());
      }
    }
    AppMethodBeat.o(247680);
  }
  
  protected final void ayS()
  {
    AppMethodBeat.i(247682);
    com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handlePause()");
    ayQ();
    this.jxX = false;
    if (this.jxO.isLive()) {}
    for (long l = this.jxQ.jAT;; l = this.jxR.jAO)
    {
      this.jye = l;
      if (com.tencent.mm.danmaku.e.e.jBo >= 5) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.jye) });
      }
      AppMethodBeat.o(247682);
      return;
    }
  }
  
  public final void ayT()
  {
    AppMethodBeat.i(247686);
    com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceCreated");
    AppMethodBeat.o(247686);
  }
  
  public final void ayU()
  {
    AppMethodBeat.i(247687);
    com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceChanged");
    this.jxY = true;
    ayP();
    AppMethodBeat.o(247687);
  }
  
  public final void ayV()
  {
    AppMethodBeat.i(247688);
    this.jxY = false;
    ayQ();
    com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceDestroyed");
    AppMethodBeat.o(247688);
  }
  
  protected final void ayW()
  {
    AppMethodBeat.i(247691);
    ayM();
    Fb(4L);
    AppMethodBeat.o(247691);
  }
  
  protected final void ayX()
  {
    AppMethodBeat.i(247693);
    com.tencent.mm.danmaku.e.e.i("surface_lock", "handleClearDrawingCache");
    ayQ();
    if (this.jxY)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      try
      {
        Canvas localCanvas = this.jxZ.azQ();
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
            com.tencent.mm.danmaku.e.d.p(localCanvas);
          }
          if (localCanvas != null) {}
          try
          {
            this.jxZ.o(localCanvas);
            com.tencent.mm.danmaku.e.e.i("surface_lock", "clearDrawing unlockCanvas " + localCanvas.hashCode());
            AppMethodBeat.o(247693);
            return;
          }
          catch (Throwable localThrowable1)
          {
            int i;
            com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localCanvas.hashCode(), localThrowable1);
            AppMethodBeat.o(247693);
            return;
          }
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          i = localCanvas.hashCode();
        }
        try
        {
          this.jxZ.o(localThrowable2);
          com.tencent.mm.danmaku.e.e.i("surface_lock", "clearDrawing unlockCanvas " + localThrowable2.hashCode());
          AppMethodBeat.o(247693);
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
          this.jxZ.o(localThrowable1);
          com.tencent.mm.danmaku.e.e.i("surface_lock", "clearDrawing unlockCanvas " + localThrowable1.hashCode());
          AppMethodBeat.o(247693);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable1.hashCode(), localThrowable2);
          AppMethodBeat.o(247693);
          return;
        }
      }
      finally
      {
        if (localThrowable2 == null) {}
      }
    }
    AppMethodBeat.o(247693);
  }
  
  protected final void c(Point paramPoint)
  {
    AppMethodBeat.i(247635);
    paramPoint.y = ((int)(paramPoint.y - this.jxZ.azR()));
    paramPoint = new com.tencent.mm.danmaku.d.h(this.jxR.jAO, paramPoint, 0);
    if (com.tencent.mm.danmaku.e.e.jBo >= 4) {
      com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "addClickPoint:", paramPoint });
    }
    this.jys.add(paramPoint);
    this.jyx.sendMessage(10);
    AppMethodBeat.o(247635);
  }
  
  protected final void clear()
  {
    AppMethodBeat.i(247644);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "clear");
    this.jyx.sendMessage(9);
    if (this.jya != null) {
      this.jya.clear();
    }
    AppMethodBeat.o(247644);
  }
  
  protected final void i(Message paramMessage)
  {
    AppMethodBeat.i(247684);
    StringBuilder localStringBuilder = new StringBuilder("handleSeek() msg.obj is null = ");
    if (paramMessage.obj == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.danmaku.e.e.i("DanmakuManager", bool);
      if (paramMessage.obj != null)
      {
        this.jye = ((Long)paramMessage.obj).longValue();
        this.jyf = true;
        ayO();
      }
      if (com.tencent.mm.danmaku.e.e.jBo >= 5) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.jye) });
      }
      AppMethodBeat.o(247684);
      return;
    }
  }
  
  protected final boolean isPlaying()
  {
    AppMethodBeat.i(247673);
    if ((!this.jxW) && (this.jxX)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.danmaku.e.e.d("DanmakuManager", "isPlaying() = " + bool + " : mIsQuited = " + this.jxW + ", mIsPlaying = " + this.jxX);
      AppMethodBeat.o(247673);
      return bool;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247689);
    if (this.jyg)
    {
      if (com.tencent.mm.danmaku.e.e.jBo >= 4) {
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", new Object[] { "onClick:", paramMotionEvent });
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0) {
        c(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
      }
    }
    AppMethodBeat.o(247689);
    return false;
  }
  
  protected final void pause()
  {
    AppMethodBeat.i(247641);
    com.tencent.mm.danmaku.e.e.i("DanmakuManager", "pause()");
    this.jyx.sendMessage(3);
    AppMethodBeat.o(247641);
  }
  
  @SuppressLint({"NewApi"})
  protected final void quit()
  {
    AppMethodBeat.i(247652);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "quit(); mIsQuited = true");
    this.jxW = true;
    this.jyx.sendMessage(6);
    if (ayJ()) {
      Choreographer.getInstance().removeFrameCallback(this.jyB);
    }
    ayQ();
    AppMethodBeat.o(247652);
  }
  
  protected final void release()
  {
    AppMethodBeat.i(247654);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "release() mIsQuited = " + this.jxW);
    if (!this.jxW) {
      quit();
    }
    this.jyx.sendMessage(8);
    this.jyv = null;
    AppMethodBeat.o(247654);
  }
  
  protected final void resume()
  {
    AppMethodBeat.i(247639);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "resume()");
    this.jyx.sendMessage(2);
    AppMethodBeat.o(247639);
  }
  
  protected final void seek(long paramLong)
  {
    AppMethodBeat.i(247643);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "seek(): postime = ".concat(String.valueOf(paramLong)));
    this.jyx.sendMessage(5, Long.valueOf(paramLong));
    AppMethodBeat.o(247643);
  }
  
  protected final void start(long paramLong)
  {
    AppMethodBeat.i(247637);
    com.tencent.mm.danmaku.e.e.v("DanmakuManager", "start() time = ".concat("0"));
    this.jyx.rq(this.jxO.jzW);
    this.jyx.sendMessage(1, Long.valueOf(0L));
    AppMethodBeat.o(247637);
  }
  
  @SuppressLint({"NewApi"})
  final class a
    implements Choreographer.FrameCallback
  {
    private a() {}
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(263647);
      if (d.this.ayN()) {
        d.a(d.this).aze();
      }
      AppMethodBeat.o(263647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.d
 * JD-Core Version:    0.7.0.1
 */