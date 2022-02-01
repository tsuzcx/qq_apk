package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.appbrand.canvas.widget.a
{
  volatile boolean jSA;
  JSONArray jSB;
  volatile DrawCanvasArg jSC;
  private d jSD;
  private c jSE;
  public com.tencent.mm.plugin.appbrand.canvas.widget.a jSF;
  public Runnable jSG;
  private Runnable jSH;
  public volatile long jSI;
  private volatile long jSJ;
  protected volatile int jSK;
  protected volatile long jSL;
  protected volatile long jSM;
  protected volatile long jSN;
  protected volatile long jSO;
  private com.tencent.mm.plugin.appbrand.canvas.c.a jSP;
  boolean jSQ;
  private String jSR;
  protected volatile int mCount;
  public volatile boolean mPause;
  private volatile String mSessionId;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144832);
    this.jSG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144823);
        b.this.jSO = 0L;
        b.this.mPause = true;
        AppMethodBeat.o(144823);
      }
    };
    this.jSH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144824);
        boolean bool = b.this.mPause;
        b.this.mPause = false;
        ad.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.this.jSA) });
        if ((bool) && (b.this.jSA)) {
          b.this.jSF.bdk();
        }
        AppMethodBeat.o(144824);
      }
    };
    this.jSK = 0;
    this.jSQ = true;
    this.jSF = parama;
    this.jSD = new d(new b.a(parama));
    this.jSE = new c();
    AppMethodBeat.o(144832);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144835);
    this.jSA = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144835);
      return false;
    }
    long l1 = this.jSI;
    long l2 = System.nanoTime();
    this.jSD.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.jSE.a(this.jSD, paramCanvas, localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.DrawActionDelegateImpl", "drawAction error with method[%s], exception : %s", new Object[] { localJSONObject.optString("method"), localException });
          }
        }
      }
    }
    h(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.mPause) {
      this.jSO = l1;
    }
    AppMethodBeat.o(144835);
    return true;
  }
  
  private void h(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.jSN = (paramLong3 - paramLong2 + this.jSN);
      this.jSM += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean i(Canvas paramCanvas)
  {
    AppMethodBeat.i(144834);
    this.jSD.jTg = true;
    if (this.jSC == null)
    {
      this.jSA = false;
      AppMethodBeat.o(144834);
      return false;
    }
    if ((this.jSC.jUl) && (!this.jSC.jUp))
    {
      boolean bool = a(paramCanvas, this.jSC.jUm);
      AppMethodBeat.o(144834);
      return bool;
    }
    this.jSA = false;
    if (this.jSC == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.jSC.jTJ)
    {
      AppMethodBeat.o(144834);
      return false;
    }
    long l1 = this.jSI;
    long l2 = System.nanoTime();
    this.jSD.reset();
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
              ad.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", new Object[] { Integer.valueOf(((DrawActionWrapper)localObject4).type) });
            }
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
          continue;
        }
        this.jSE.a(this.jSD, paramCanvas, ((DrawActionWrapper)localObject4).jTj);
      }
      catch (Exception paramCanvas)
      {
        ad.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        h(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.jSO = l1;
        }
        AppMethodBeat.o(144834);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).jTj.toString());
      AppMethodBeat.o(144834);
      throw ((Throwable)localObject2);
      Object localObject3 = this.jSE;
      localObject2 = this.jSD;
      Object localObject4 = ((DrawActionWrapper)localObject4).jTi;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).jSX.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void R(Runnable paramRunnable)
  {
    AppMethodBeat.i(144842);
    if (equals(this.jSF))
    {
      AppMethodBeat.o(144842);
      return;
    }
    aq.f(paramRunnable);
    AppMethodBeat.o(144842);
  }
  
  public final void a(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144838);
    this.jSF.R(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144827);
        DrawCanvasArg localDrawCanvasArg = b.this.jSC;
        b.this.jSC = paramDrawCanvasArg;
        b.this.jSA = true;
        b.this.jSQ = false;
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
    this.jSF.R(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144825);
        DrawCanvasArg localDrawCanvasArg = b.this.jSC;
        b.this.jSC = null;
        b.this.jSB = paramJSONArray;
        b.this.jSQ = true;
        b.this.jSA = true;
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
    this.jSF.R(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144828);
        if (b.this.jSC == null)
        {
          AppMethodBeat.o(144828);
          return;
        }
        b.this.jSC.jTJ.addAll(paramDrawCanvasArg.jTJ);
        b.this.jSA = true;
        b.this.jSQ = false;
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
    this.jSF.R(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144826);
        b.this.jSQ = true;
        if (b.this.jSB == null) {
          b.this.jSB = paramJSONArray;
        }
        for (;;)
        {
          b.this.jSA = true;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(144826);
          return;
          int i = 0;
          while (i < paramJSONArray.length())
          {
            b.this.jSB.put(paramJSONArray.opt(i));
            i += 1;
          }
        }
      }
    });
    AppMethodBeat.o(144837);
  }
  
  public final void bdk() {}
  
  public final void bdl()
  {
    AppMethodBeat.i(144840);
    this.jSF.R(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144829);
        ad.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
        b.this.jSC = null;
        b.this.jSB = null;
        b.this.jSA = true;
        AppMethodBeat.o(144829);
      }
    });
    AppMethodBeat.o(144840);
  }
  
  public final void bdm()
  {
    AppMethodBeat.i(144843);
    int i = this.mCount;
    long l1 = this.jSN;
    long l2 = this.jSM;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(144843);
      return;
    }
    float f1 = (float)this.jSL * 1.0F / this.jSK / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    ad.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.jSK), Integer.valueOf(i) });
    if (this.jSP != null)
    {
      this.jSP.sH(l1 / i);
      this.jSP.sI(l2 / i);
      this.jSP.d(l1, l2, i);
      this.jSP.ax(f1);
      this.jSP.ay(f2);
    }
    AppMethodBeat.o(144843);
  }
  
  public final d getDrawContext()
  {
    return this.jSD;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.jSR;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(144833);
    if (this.jSQ)
    {
      this.jSD.jTg = false;
      bool = a(paramCanvas, this.jSB);
      AppMethodBeat.o(144833);
      return bool;
    }
    boolean bool = i(paramCanvas);
    AppMethodBeat.o(144833);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.mPause;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(144841);
    this.jSF.R(this.jSH);
    AppMethodBeat.o(144841);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.jSP = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.jSI = paramLong;
    this.jSJ = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.jSR = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */