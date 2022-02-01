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
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.appbrand.canvas.widget.a
{
  protected volatile long iYA;
  protected volatile long iYB;
  private com.tencent.mm.plugin.appbrand.canvas.c.a iYC;
  boolean iYD;
  private String iYE;
  volatile boolean iYm;
  JSONArray iYn;
  volatile DrawCanvasArg iYo;
  private d iYp;
  private c iYq;
  public com.tencent.mm.plugin.appbrand.canvas.widget.a iYr;
  public Runnable iYt;
  private Runnable iYu;
  public volatile long iYv;
  private volatile long iYw;
  protected volatile int iYx;
  protected volatile long iYy;
  protected volatile long iYz;
  protected volatile int mCount;
  public volatile boolean mPause;
  private volatile String mSessionId;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144832);
    this.iYt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144823);
        b.this.iYB = 0L;
        b.this.mPause = true;
        AppMethodBeat.o(144823);
      }
    };
    this.iYu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144824);
        boolean bool = b.this.mPause;
        b.this.mPause = false;
        ad.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.this.iYm) });
        if ((bool) && (b.this.iYm)) {
          b.this.iYr.aSM();
        }
        AppMethodBeat.o(144824);
      }
    };
    this.iYx = 0;
    this.iYD = true;
    this.iYr = parama;
    this.iYp = new d(new a(parama));
    this.iYq = new c();
    AppMethodBeat.o(144832);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144835);
    this.iYm = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144835);
      return false;
    }
    long l1 = this.iYv;
    long l2 = System.nanoTime();
    this.iYp.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.iYq.a(this.iYp, paramCanvas, localJSONObject);
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
    g(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.mPause) {
      this.iYB = l1;
    }
    AppMethodBeat.o(144835);
    return true;
  }
  
  private void g(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.iYA = (paramLong3 - paramLong2 + this.iYA);
      this.iYz += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean i(Canvas paramCanvas)
  {
    AppMethodBeat.i(144834);
    this.iYp.iYT = true;
    if (this.iYo == null)
    {
      this.iYm = false;
      AppMethodBeat.o(144834);
      return false;
    }
    if ((this.iYo.jad) && (!this.iYo.jah))
    {
      boolean bool = a(paramCanvas, this.iYo.jae);
      AppMethodBeat.o(144834);
      return bool;
    }
    this.iYm = false;
    if (this.iYo == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.iYo.iZB)
    {
      AppMethodBeat.o(144834);
      return false;
    }
    long l1 = this.iYv;
    long l2 = System.nanoTime();
    this.iYp.reset();
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
        this.iYq.a(this.iYp, paramCanvas, ((DrawActionWrapper)localObject4).iYW);
      }
      catch (Exception paramCanvas)
      {
        ad.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        g(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.iYB = l1;
        }
        AppMethodBeat.o(144834);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).iYW.toString());
      AppMethodBeat.o(144834);
      throw ((Throwable)localObject2);
      Object localObject3 = this.iYq;
      localObject2 = this.iYp;
      Object localObject4 = ((DrawActionWrapper)localObject4).iYV;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).iYK.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void Q(Runnable paramRunnable)
  {
    AppMethodBeat.i(144842);
    if (equals(this.iYr))
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
    this.iYr.Q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144827);
        DrawCanvasArg localDrawCanvasArg = b.this.iYo;
        b.this.iYo = paramDrawCanvasArg;
        b.this.iYm = true;
        b.this.iYD = false;
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
    this.iYr.Q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144825);
        DrawCanvasArg localDrawCanvasArg = b.this.iYo;
        b.this.iYo = null;
        b.this.iYn = paramJSONArray;
        b.this.iYD = true;
        b.this.iYm = true;
        if (parama != null) {
          parama.a(localDrawCanvasArg);
        }
        b.a(b.this);
        AppMethodBeat.o(144825);
      }
    });
    AppMethodBeat.o(144836);
  }
  
  public final void aSM() {}
  
  public final void aSN()
  {
    AppMethodBeat.i(144840);
    this.iYr.Q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144829);
        ad.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
        b.this.iYo = null;
        b.this.iYn = null;
        b.this.iYm = true;
        AppMethodBeat.o(144829);
      }
    });
    AppMethodBeat.o(144840);
  }
  
  public final void aSO()
  {
    AppMethodBeat.i(144843);
    int i = this.mCount;
    long l1 = this.iYA;
    long l2 = this.iYz;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(144843);
      return;
    }
    float f1 = (float)this.iYy * 1.0F / this.iYx / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    ad.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.iYx), Integer.valueOf(i) });
    if (this.iYC != null)
    {
      this.iYC.mV(l1 / i);
      this.iYC.mW(l2 / i);
      this.iYC.d(l1, l2, i);
      this.iYC.aq(f1);
      this.iYC.ar(f2);
    }
    AppMethodBeat.o(144843);
  }
  
  public final void b(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144839);
    if (paramDrawCanvasArg == null)
    {
      AppMethodBeat.o(144839);
      return;
    }
    this.iYr.Q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144828);
        if (b.this.iYo == null)
        {
          AppMethodBeat.o(144828);
          return;
        }
        b.this.iYo.iZB.addAll(paramDrawCanvasArg.iZB);
        b.this.iYm = true;
        b.this.iYD = false;
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
    this.iYr.Q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144826);
        b.this.iYD = true;
        if (b.this.iYn == null) {
          b.this.iYn = paramJSONArray;
        }
        for (;;)
        {
          b.this.iYm = true;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(144826);
          return;
          int i = 0;
          while (i < paramJSONArray.length())
          {
            b.this.iYn.put(paramJSONArray.opt(i));
            i += 1;
          }
        }
      }
    });
    AppMethodBeat.o(144837);
  }
  
  public final d getDrawContext()
  {
    return this.iYp;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.iYE;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(144833);
    if (this.iYD)
    {
      this.iYp.iYT = false;
      bool = a(paramCanvas, this.iYn);
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
    this.iYr.Q(this.iYu);
    AppMethodBeat.o(144841);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.iYC = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.iYv = paramLong;
    this.iYw = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.iYE = paramString;
  }
  
  static final class a
    implements a
  {
    private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> iYJ;
    
    a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
    {
      AppMethodBeat.i(144830);
      this.iYJ = new WeakReference(parama);
      AppMethodBeat.o(144830);
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(144831);
      com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.iYJ.get();
      if (locala == null)
      {
        AppMethodBeat.o(144831);
        return;
      }
      locala.aSM();
      AppMethodBeat.o(144831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */