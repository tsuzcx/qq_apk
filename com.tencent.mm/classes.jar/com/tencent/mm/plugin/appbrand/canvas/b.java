package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.appbrand.canvas.widget.a
{
  volatile boolean jVR;
  JSONArray jVS;
  volatile DrawCanvasArg jVT;
  private d jVU;
  private c jVV;
  public com.tencent.mm.plugin.appbrand.canvas.widget.a jVW;
  public Runnable jVX;
  private Runnable jVY;
  public volatile long jVZ;
  private volatile long jWa;
  protected volatile int jWb;
  protected volatile long jWc;
  protected volatile long jWd;
  protected volatile long jWe;
  protected volatile long jWf;
  private com.tencent.mm.plugin.appbrand.canvas.c.a jWg;
  boolean jWh;
  private String jWi;
  protected volatile int mCount;
  public volatile boolean mPause;
  private volatile String mSessionId;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144832);
    this.jVX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144823);
        b.this.jWf = 0L;
        b.this.mPause = true;
        AppMethodBeat.o(144823);
      }
    };
    this.jVY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144824);
        boolean bool = b.this.mPause;
        b.this.mPause = false;
        ae.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.this.jVR) });
        if ((bool) && (b.this.jVR)) {
          b.this.jVW.bdP();
        }
        AppMethodBeat.o(144824);
      }
    };
    this.jWb = 0;
    this.jWh = true;
    this.jVW = parama;
    this.jVU = new d(new a(parama));
    this.jVV = new c();
    AppMethodBeat.o(144832);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144835);
    this.jVR = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144835);
      return false;
    }
    long l1 = this.jVZ;
    long l2 = System.nanoTime();
    this.jVU.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.jVV.a(this.jVU, paramCanvas, localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.DrawActionDelegateImpl", "drawAction error with method[%s], exception : %s", new Object[] { localJSONObject.optString("method"), localException });
          }
        }
      }
    }
    h(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.mPause) {
      this.jWf = l1;
    }
    AppMethodBeat.o(144835);
    return true;
  }
  
  private void h(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.jWe = (paramLong3 - paramLong2 + this.jWe);
      this.jWd += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean i(Canvas paramCanvas)
  {
    AppMethodBeat.i(144834);
    this.jVU.jWx = true;
    if (this.jVT == null)
    {
      this.jVR = false;
      AppMethodBeat.o(144834);
      return false;
    }
    if ((this.jVT.jXC) && (!this.jVT.jXG))
    {
      boolean bool = a(paramCanvas, this.jVT.jXD);
      AppMethodBeat.o(144834);
      return bool;
    }
    this.jVR = false;
    if (this.jVT == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.jVT.jXa)
    {
      AppMethodBeat.o(144834);
      return false;
    }
    long l1 = this.jVZ;
    long l2 = System.nanoTime();
    this.jVU.reset();
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
              ae.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", new Object[] { Integer.valueOf(((DrawActionWrapper)localObject4).type) });
            }
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
          continue;
        }
        this.jVV.a(this.jVU, paramCanvas, ((DrawActionWrapper)localObject4).jWA);
      }
      catch (Exception paramCanvas)
      {
        ae.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        h(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.jWf = l1;
        }
        AppMethodBeat.o(144834);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).jWA.toString());
      AppMethodBeat.o(144834);
      throw ((Throwable)localObject2);
      Object localObject3 = this.jVV;
      localObject2 = this.jVU;
      Object localObject4 = ((DrawActionWrapper)localObject4).jWz;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).jWo.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(144842);
    if (equals(this.jVW))
    {
      AppMethodBeat.o(144842);
      return;
    }
    ar.f(paramRunnable);
    AppMethodBeat.o(144842);
  }
  
  public final void a(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144838);
    this.jVW.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144827);
        DrawCanvasArg localDrawCanvasArg = b.this.jVT;
        b.this.jVT = paramDrawCanvasArg;
        b.this.jVR = true;
        b.this.jWh = false;
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
    this.jVW.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144825);
        DrawCanvasArg localDrawCanvasArg = b.this.jVT;
        b.this.jVT = null;
        b.this.jVS = paramJSONArray;
        b.this.jWh = true;
        b.this.jVR = true;
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
    this.jVW.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144828);
        if (b.this.jVT == null)
        {
          AppMethodBeat.o(144828);
          return;
        }
        b.this.jVT.jXa.addAll(paramDrawCanvasArg.jXa);
        b.this.jVR = true;
        b.this.jWh = false;
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
    this.jVW.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144826);
        b.this.jWh = true;
        if (b.this.jVS == null) {
          b.this.jVS = paramJSONArray;
        }
        for (;;)
        {
          b.this.jVR = true;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(144826);
          return;
          int i = 0;
          while (i < paramJSONArray.length())
          {
            b.this.jVS.put(paramJSONArray.opt(i));
            i += 1;
          }
        }
      }
    });
    AppMethodBeat.o(144837);
  }
  
  public final void bdP() {}
  
  public final void bdQ()
  {
    AppMethodBeat.i(144840);
    this.jVW.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144829);
        ae.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
        b.this.jVT = null;
        b.this.jVS = null;
        b.this.jVR = true;
        AppMethodBeat.o(144829);
      }
    });
    AppMethodBeat.o(144840);
  }
  
  public final void bdR()
  {
    AppMethodBeat.i(144843);
    int i = this.mCount;
    long l1 = this.jWe;
    long l2 = this.jWd;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(144843);
      return;
    }
    float f1 = (float)this.jWc * 1.0F / this.jWb / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    ae.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.jWb), Integer.valueOf(i) });
    if (this.jWg != null)
    {
      this.jWg.sU(l1 / i);
      this.jWg.sV(l2 / i);
      this.jWg.d(l1, l2, i);
      this.jWg.ax(f1);
      this.jWg.ay(f2);
    }
    AppMethodBeat.o(144843);
  }
  
  public final d getDrawContext()
  {
    return this.jVU;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.jWi;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(144833);
    if (this.jWh)
    {
      this.jVU.jWx = false;
      bool = a(paramCanvas, this.jVS);
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
    this.jVW.P(this.jVY);
    AppMethodBeat.o(144841);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.jWg = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.jVZ = paramLong;
    this.jWa = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.jWi = paramString;
  }
  
  static final class a
    implements a
  {
    private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> jWn;
    
    a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
    {
      AppMethodBeat.i(144830);
      this.jWn = new WeakReference(parama);
      AppMethodBeat.o(144830);
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(144831);
      com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.jWn.get();
      if (locala == null)
      {
        AppMethodBeat.o(144831);
        return;
      }
      locala.bdP();
      AppMethodBeat.o(144831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */