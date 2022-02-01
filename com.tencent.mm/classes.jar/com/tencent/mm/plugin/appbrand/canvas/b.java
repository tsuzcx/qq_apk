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
  volatile boolean qSK;
  JSONArray qSL;
  volatile DrawCanvasArg qSM;
  private d qSN;
  private c qSO;
  public com.tencent.mm.plugin.appbrand.canvas.widget.a qSP;
  public Runnable qSQ;
  private Runnable qSR;
  public volatile long qSS;
  private volatile long qST;
  protected volatile int qSU;
  protected volatile long qSV;
  protected volatile long qSW;
  protected volatile long qSX;
  protected volatile long qSY;
  private com.tencent.mm.plugin.appbrand.canvas.c.a qSZ;
  boolean qTa;
  private String qTb;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144832);
    this.qSQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144823);
        b.this.qSY = 0L;
        b.this.mPause = true;
        AppMethodBeat.o(144823);
      }
    };
    this.qSR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144824);
        boolean bool = b.this.mPause;
        b.this.mPause = false;
        Log.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.this.qSK) });
        if ((bool) && (b.this.qSK)) {
          b.this.qSP.cjV();
        }
        AppMethodBeat.o(144824);
      }
    };
    this.qSU = 0;
    this.qTa = true;
    this.qSP = parama;
    this.qSN = new d(new a(parama));
    this.qSO = new c();
    AppMethodBeat.o(144832);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144835);
    this.qSK = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144835);
      return false;
    }
    long l1 = this.qSS;
    long l2 = System.nanoTime();
    this.qSN.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.qSO.a(this.qSN, paramCanvas, localJSONObject);
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
      this.qSY = l1;
    }
    AppMethodBeat.o(144835);
    return true;
  }
  
  private void i(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.qSX = (paramLong3 - paramLong2 + this.qSX);
      this.qSW += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean m(Canvas paramCanvas)
  {
    AppMethodBeat.i(144834);
    this.qSN.qTq = true;
    if (this.qSM == null)
    {
      this.qSK = false;
      AppMethodBeat.o(144834);
      return false;
    }
    if ((this.qSM.qUt) && (!this.qSM.qUx))
    {
      boolean bool = a(paramCanvas, this.qSM.qUu);
      AppMethodBeat.o(144834);
      return bool;
    }
    this.qSK = false;
    if (this.qSM == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.qSM.qTR)
    {
      AppMethodBeat.o(144834);
      return false;
    }
    long l1 = this.qSS;
    long l2 = System.nanoTime();
    this.qSN.reset();
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
        this.qSO.a(this.qSN, paramCanvas, ((DrawActionWrapper)localObject4).qTt);
      }
      catch (Exception paramCanvas)
      {
        Log.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        i(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.qSY = l1;
        }
        AppMethodBeat.o(144834);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).qTt.toString());
      AppMethodBeat.o(144834);
      throw ((Throwable)localObject2);
      Object localObject3 = this.qSO;
      localObject2 = this.qSN;
      Object localObject4 = ((DrawActionWrapper)localObject4).qTs;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).qTh.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void a(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144838);
    this.qSP.ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144827);
        DrawCanvasArg localDrawCanvasArg = b.this.qSM;
        b.this.qSM = paramDrawCanvasArg;
        b.this.qSK = true;
        b.this.qTa = false;
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
    this.qSP.ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144825);
        DrawCanvasArg localDrawCanvasArg = b.this.qSM;
        b.this.qSM = null;
        b.this.qSL = paramJSONArray;
        b.this.qTa = true;
        b.this.qSK = true;
        if (parama != null) {
          parama.a(localDrawCanvasArg);
        }
        b.a(b.this);
        AppMethodBeat.o(144825);
      }
    });
    AppMethodBeat.o(144836);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    AppMethodBeat.i(144842);
    if (equals(this.qSP))
    {
      AppMethodBeat.o(144842);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(144842);
  }
  
  public final void b(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144839);
    if (paramDrawCanvasArg == null)
    {
      AppMethodBeat.o(144839);
      return;
    }
    this.qSP.ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144828);
        if (b.this.qSM == null)
        {
          AppMethodBeat.o(144828);
          return;
        }
        b.this.qSM.qTR.addAll(paramDrawCanvasArg.qTR);
        b.this.qSK = true;
        b.this.qTa = false;
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
    this.qSP.ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144826);
        b.this.qTa = true;
        if (b.this.qSL == null) {
          b.this.qSL = paramJSONArray;
        }
        for (;;)
        {
          b.this.qSK = true;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(144826);
          return;
          int i = 0;
          while (i < paramJSONArray.length())
          {
            b.this.qSL.put(paramJSONArray.opt(i));
            i += 1;
          }
        }
      }
    });
    AppMethodBeat.o(144837);
  }
  
  public final void cjV() {}
  
  public final void cjW()
  {
    AppMethodBeat.i(144840);
    this.qSP.ab(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144829);
        Log.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
        b.this.qSM = null;
        b.this.qSL = null;
        b.this.qSK = true;
        AppMethodBeat.o(144829);
      }
    });
    AppMethodBeat.o(144840);
  }
  
  public final void cjX()
  {
    AppMethodBeat.i(144843);
    int i = this.mCount;
    long l1 = this.qSX;
    long l2 = this.qSW;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(144843);
      return;
    }
    float f1 = (float)this.qSV * 1.0F / this.qSU / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    Log.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.qSU), Integer.valueOf(i) });
    if (this.qSZ != null)
    {
      this.qSZ.jC(l1 / i);
      this.qSZ.jD(l2 / i);
      this.qSZ.g(l1, l2, i);
      this.qSZ.bF(f1);
      this.qSZ.bG(f2);
    }
    AppMethodBeat.o(144843);
  }
  
  public final d getDrawContext()
  {
    return this.qSN;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.qTb;
  }
  
  public final boolean isPaused()
  {
    return this.mPause;
  }
  
  public final boolean l(Canvas paramCanvas)
  {
    AppMethodBeat.i(144833);
    if (this.qTa)
    {
      this.qSN.qTq = false;
      bool = a(paramCanvas, this.qSL);
      AppMethodBeat.o(144833);
      return bool;
    }
    boolean bool = m(paramCanvas);
    AppMethodBeat.o(144833);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(144841);
    this.qSP.ab(this.qSR);
    AppMethodBeat.o(144841);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.qSZ = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.qSS = paramLong;
    this.qST = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.qTb = paramString;
  }
  
  static final class a
    implements a
  {
    private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> qTg;
    
    a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
    {
      AppMethodBeat.i(144830);
      this.qTg = new WeakReference(parama);
      AppMethodBeat.o(144830);
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(144831);
      com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.qTg.get();
      if (locala == null)
      {
        AppMethodBeat.o(144831);
        return;
      }
      locala.cjV();
      AppMethodBeat.o(144831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */