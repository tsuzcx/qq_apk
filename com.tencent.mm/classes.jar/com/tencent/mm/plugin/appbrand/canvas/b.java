package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.appbrand.canvas.widget.a
{
  volatile boolean jyD;
  JSONArray jyE;
  volatile DrawCanvasArg jyF;
  private d jyG;
  private c jyH;
  public com.tencent.mm.plugin.appbrand.canvas.widget.a jyI;
  public Runnable jyJ;
  private Runnable jyK;
  public volatile long jyL;
  private volatile long jyM;
  protected volatile int jyN;
  protected volatile long jyO;
  protected volatile long jyP;
  protected volatile long jyQ;
  protected volatile long jyR;
  private com.tencent.mm.plugin.appbrand.canvas.c.a jyS;
  boolean jyT;
  private String jyU;
  protected volatile int mCount;
  public volatile boolean mPause;
  private volatile String mSessionId;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144832);
    this.jyJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144823);
        b.this.jyR = 0L;
        b.this.mPause = true;
        AppMethodBeat.o(144823);
      }
    };
    this.jyK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144824);
        boolean bool = b.this.mPause;
        b.this.mPause = false;
        ac.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.this.jyD) });
        if ((bool) && (b.this.jyD)) {
          b.this.jyI.aZL();
        }
        AppMethodBeat.o(144824);
      }
    };
    this.jyN = 0;
    this.jyT = true;
    this.jyI = parama;
    this.jyG = new d(new a(parama));
    this.jyH = new c();
    AppMethodBeat.o(144832);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144835);
    this.jyD = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144835);
      return false;
    }
    long l1 = this.jyL;
    long l2 = System.nanoTime();
    this.jyG.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.jyH.a(this.jyG, paramCanvas, localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.DrawActionDelegateImpl", "drawAction error with method[%s], exception : %s", new Object[] { localJSONObject.optString("method"), localException });
          }
        }
      }
    }
    h(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.mPause) {
      this.jyR = l1;
    }
    AppMethodBeat.o(144835);
    return true;
  }
  
  private void h(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.jyQ = (paramLong3 - paramLong2 + this.jyQ);
      this.jyP += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean i(Canvas paramCanvas)
  {
    AppMethodBeat.i(144834);
    this.jyG.jzj = true;
    if (this.jyF == null)
    {
      this.jyD = false;
      AppMethodBeat.o(144834);
      return false;
    }
    if ((this.jyF.jAq) && (!this.jyF.jAu))
    {
      boolean bool = a(paramCanvas, this.jyF.jAr);
      AppMethodBeat.o(144834);
      return bool;
    }
    this.jyD = false;
    if (this.jyF == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.jyF.jzO)
    {
      AppMethodBeat.o(144834);
      return false;
    }
    long l1 = this.jyL;
    long l2 = System.nanoTime();
    this.jyG.reset();
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
              ac.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", new Object[] { Integer.valueOf(((DrawActionWrapper)localObject4).type) });
            }
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
          continue;
        }
        this.jyH.a(this.jyG, paramCanvas, ((DrawActionWrapper)localObject4).jzm);
      }
      catch (Exception paramCanvas)
      {
        ac.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        h(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.jyR = l1;
        }
        AppMethodBeat.o(144834);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).jzm.toString());
      AppMethodBeat.o(144834);
      throw ((Throwable)localObject2);
      Object localObject3 = this.jyH;
      localObject2 = this.jyG;
      Object localObject4 = ((DrawActionWrapper)localObject4).jzl;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).jza.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void S(Runnable paramRunnable)
  {
    AppMethodBeat.i(144842);
    if (equals(this.jyI))
    {
      AppMethodBeat.o(144842);
      return;
    }
    ap.f(paramRunnable);
    AppMethodBeat.o(144842);
  }
  
  public final void a(final DrawCanvasArg paramDrawCanvasArg, final a.a parama)
  {
    AppMethodBeat.i(144838);
    this.jyI.S(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144827);
        DrawCanvasArg localDrawCanvasArg = b.this.jyF;
        b.this.jyF = paramDrawCanvasArg;
        b.this.jyD = true;
        b.this.jyT = false;
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
    this.jyI.S(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144825);
        DrawCanvasArg localDrawCanvasArg = b.this.jyF;
        b.this.jyF = null;
        b.this.jyE = paramJSONArray;
        b.this.jyT = true;
        b.this.jyD = true;
        if (parama != null) {
          parama.a(localDrawCanvasArg);
        }
        b.a(b.this);
        AppMethodBeat.o(144825);
      }
    });
    AppMethodBeat.o(144836);
  }
  
  public final void aZL() {}
  
  public final void aZM()
  {
    AppMethodBeat.i(144840);
    this.jyI.S(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144829);
        ac.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
        b.this.jyF = null;
        b.this.jyE = null;
        b.this.jyD = true;
        AppMethodBeat.o(144829);
      }
    });
    AppMethodBeat.o(144840);
  }
  
  public final void aZN()
  {
    AppMethodBeat.i(144843);
    int i = this.mCount;
    long l1 = this.jyQ;
    long l2 = this.jyP;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(144843);
      return;
    }
    float f1 = (float)this.jyO * 1.0F / this.jyN / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    ac.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.jyN), Integer.valueOf(i) });
    if (this.jyS != null)
    {
      this.jyS.qJ(l1 / i);
      this.jyS.qK(l2 / i);
      this.jyS.d(l1, l2, i);
      this.jyS.au(f1);
      this.jyS.av(f2);
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
    this.jyI.S(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144828);
        if (b.this.jyF == null)
        {
          AppMethodBeat.o(144828);
          return;
        }
        b.this.jyF.jzO.addAll(paramDrawCanvasArg.jzO);
        b.this.jyD = true;
        b.this.jyT = false;
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
    this.jyI.S(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144826);
        b.this.jyT = true;
        if (b.this.jyE == null) {
          b.this.jyE = paramJSONArray;
        }
        for (;;)
        {
          b.this.jyD = true;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(144826);
          return;
          int i = 0;
          while (i < paramJSONArray.length())
          {
            b.this.jyE.put(paramJSONArray.opt(i));
            i += 1;
          }
        }
      }
    });
    AppMethodBeat.o(144837);
  }
  
  public final d getDrawContext()
  {
    return this.jyG;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.jyU;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(144833);
    if (this.jyT)
    {
      this.jyG.jzj = false;
      bool = a(paramCanvas, this.jyE);
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
    this.jyI.S(this.jyK);
    AppMethodBeat.o(144841);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.jyS = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.jyL = paramLong;
    this.jyM = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.jyU = paramString;
  }
  
  static final class a
    implements a
  {
    private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> jyZ;
    
    a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
    {
      AppMethodBeat.i(144830);
      this.jyZ = new WeakReference(parama);
      AppMethodBeat.o(144830);
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(144831);
      com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.jyZ.get();
      if (locala == null)
      {
        AppMethodBeat.o(144831);
        return;
      }
      locala.aZL();
      AppMethodBeat.o(144831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */