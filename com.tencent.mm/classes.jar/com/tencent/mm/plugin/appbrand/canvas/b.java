package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.appbrand.canvas.widget.a
{
  protected volatile int mCount;
  public volatile boolean mPause;
  private volatile String mSessionId;
  volatile boolean nSY;
  JSONArray nSZ;
  volatile DrawCanvasArg nTa;
  private d nTb;
  private c nTc;
  public com.tencent.mm.plugin.appbrand.canvas.widget.a nTd;
  public Runnable nTe;
  private Runnable nTf;
  public volatile long nTg;
  private volatile long nTh;
  protected volatile int nTi;
  protected volatile long nTj;
  protected volatile long nTk;
  protected volatile long nTl;
  protected volatile long nTm;
  private com.tencent.mm.plugin.appbrand.canvas.c.a nTn;
  boolean nTo;
  private String nTp;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144832);
    this.nTe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144823);
        b.this.nTm = 0L;
        b.this.mPause = true;
        AppMethodBeat.o(144823);
      }
    };
    this.nTf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144824);
        boolean bool = b.this.mPause;
        b.this.mPause = false;
        Log.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.this.nSY) });
        if ((bool) && (b.this.nSY)) {
          b.this.nTd.bKv();
        }
        AppMethodBeat.o(144824);
      }
    };
    this.nTi = 0;
    this.nTo = true;
    this.nTd = parama;
    this.nTb = new d(new a(parama));
    this.nTc = new c();
    AppMethodBeat.o(144832);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144835);
    this.nSY = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144835);
      return false;
    }
    long l1 = this.nTg;
    long l2 = System.nanoTime();
    this.nTb.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.nTc.a(this.nTb, paramCanvas, localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.DrawActionDelegateImpl", "drawAction error with method[%s], exception : %s", new Object[] { localJSONObject.optString("method"), localException });
          }
        }
      }
    }
    i(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.mPause) {
      this.nTm = l1;
    }
    AppMethodBeat.o(144835);
    return true;
  }
  
  private void i(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.nTl = (paramLong3 - paramLong2 + this.nTl);
      this.nTk += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean r(Canvas paramCanvas)
  {
    AppMethodBeat.i(144834);
    this.nTb.nTE = true;
    if (this.nTa == null)
    {
      this.nSY = false;
      AppMethodBeat.o(144834);
      return false;
    }
    if ((this.nTa.nUJ) && (!this.nTa.nUN))
    {
      boolean bool = a(paramCanvas, this.nTa.nUK);
      AppMethodBeat.o(144834);
      return bool;
    }
    this.nSY = false;
    if (this.nTa == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.nTa.nUh)
    {
      AppMethodBeat.o(144834);
      return false;
    }
    long l1 = this.nTg;
    long l2 = System.nanoTime();
    this.nTb.reset();
    localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      try
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (DrawActionWrapper)((Iterator)localObject1).next();
          if (localObject4 == null) {
            continue;
          }
          try
          {
            switch (((DrawActionWrapper)localObject4).type)
            {
            case 1: 
              Log.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", new Object[] { Integer.valueOf(((DrawActionWrapper)localObject4).type) });
            }
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
          continue;
        }
        this.nTc.a(this.nTb, paramCanvas, ((DrawActionWrapper)localObject4).nTH);
      }
      catch (Exception paramCanvas)
      {
        Log.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        i(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.nTm = l1;
        }
        AppMethodBeat.o(144834);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).nTH.toString());
      AppMethodBeat.o(144834);
      throw ((Throwable)localObject2);
      Object localObject3 = this.nTc;
      localObject2 = this.nTb;
      Object localObject4 = ((DrawActionWrapper)localObject4).nTG;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).nTv.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(144842);
    if (equals(this.nTd))
    {
      AppMethodBeat.o(144842);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(144842);
  }
  
  public final void a(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144838);
    this.nTd.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144827);
        DrawCanvasArg localDrawCanvasArg = b.this.nTa;
        b.this.nTa = paramDrawCanvasArg;
        b.this.nSY = true;
        b.this.nTo = false;
        if (parama != null) {
          parama.a(localDrawCanvasArg);
        }
        b.a(b.this);
        AppMethodBeat.o(144827);
      }
    });
    AppMethodBeat.o(144838);
  }
  
  public final void a(final JSONArray paramJSONArray, final a.a parama)
  {
    AppMethodBeat.i(144836);
    this.nTd.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144825);
        DrawCanvasArg localDrawCanvasArg = b.this.nTa;
        b.this.nTa = null;
        b.this.nSZ = paramJSONArray;
        b.this.nTo = true;
        b.this.nSY = true;
        if (parama != null) {
          parama.a(localDrawCanvasArg);
        }
        b.a(b.this);
        AppMethodBeat.o(144825);
      }
    });
    AppMethodBeat.o(144836);
  }
  
  public final void b(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144839);
    if (paramDrawCanvasArg == null)
    {
      AppMethodBeat.o(144839);
      return;
    }
    this.nTd.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144828);
        if (b.this.nTa == null)
        {
          AppMethodBeat.o(144828);
          return;
        }
        b.this.nTa.nUh.addAll(paramDrawCanvasArg.nUh);
        b.this.nSY = true;
        b.this.nTo = false;
        if (parama != null) {
          parama.a(null);
        }
        AppMethodBeat.o(144828);
      }
    });
    AppMethodBeat.o(144839);
  }
  
  public final void b(final JSONArray paramJSONArray, final a.a parama)
  {
    AppMethodBeat.i(144837);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144837);
      return;
    }
    this.nTd.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144826);
        b.this.nTo = true;
        if (b.this.nSZ == null) {
          b.this.nSZ = paramJSONArray;
        }
        for (;;)
        {
          b.this.nSY = true;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(144826);
          return;
          int i = 0;
          while (i < paramJSONArray.length())
          {
            b.this.nSZ.put(paramJSONArray.opt(i));
            i += 1;
          }
        }
      }
    });
    AppMethodBeat.o(144837);
  }
  
  public final void bKv() {}
  
  public final void bKw()
  {
    AppMethodBeat.i(144840);
    this.nTd.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144829);
        Log.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
        b.this.nTa = null;
        b.this.nSZ = null;
        b.this.nSY = true;
        AppMethodBeat.o(144829);
      }
    });
    AppMethodBeat.o(144840);
  }
  
  public final void bKx()
  {
    AppMethodBeat.i(144843);
    int i = this.mCount;
    long l1 = this.nTl;
    long l2 = this.nTk;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(144843);
      return;
    }
    float f1 = (float)this.nTj * 1.0F / this.nTi / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    Log.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.nTi), Integer.valueOf(i) });
    if (this.nTn != null)
    {
      this.nTn.Hm(l1 / i);
      this.nTn.Hn(l2 / i);
      this.nTn.e(l1, l2, i);
      this.nTn.aH(f1);
      this.nTn.aI(f2);
    }
    AppMethodBeat.o(144843);
  }
  
  public final d getDrawContext()
  {
    return this.nTb;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.nTp;
  }
  
  public final boolean isPaused()
  {
    return this.mPause;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(144841);
    this.nTd.V(this.nTf);
    AppMethodBeat.o(144841);
  }
  
  public final boolean q(Canvas paramCanvas)
  {
    AppMethodBeat.i(144833);
    if (this.nTo)
    {
      this.nTb.nTE = false;
      bool = a(paramCanvas, this.nSZ);
      AppMethodBeat.o(144833);
      return bool;
    }
    boolean bool = r(paramCanvas);
    AppMethodBeat.o(144833);
    return bool;
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.nTn = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.nTg = paramLong;
    this.nTh = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.nTp = paramString;
  }
  
  static final class a
    implements a
  {
    private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> nTu;
    
    a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
    {
      AppMethodBeat.i(144830);
      this.nTu = new WeakReference(parama);
      AppMethodBeat.o(144830);
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(144831);
      com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.nTu.get();
      if (locala == null)
      {
        AppMethodBeat.o(144831);
        return;
      }
      locala.bKv();
      AppMethodBeat.o(144831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */