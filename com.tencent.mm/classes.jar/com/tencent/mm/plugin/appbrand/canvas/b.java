package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.appbrand.canvas.widget.a
{
  volatile boolean fKP;
  JSONArray fKQ;
  volatile DrawCanvasArg fKR;
  private d fKS;
  private c fKT;
  com.tencent.mm.plugin.appbrand.canvas.widget.a fKU;
  private volatile String fKV;
  public volatile boolean fKW;
  private Runnable fKX = new Runnable()
  {
    public final void run()
    {
      b.this.fLf = 0L;
      b.this.fKW = true;
    }
  };
  private Runnable fKY = new b.2(this);
  private volatile long fKZ;
  private volatile long fLa;
  protected volatile int fLb = 0;
  protected volatile long fLc;
  protected volatile long fLd;
  protected volatile long fLe;
  protected volatile long fLf;
  private com.tencent.mm.plugin.appbrand.canvas.c.a fLg;
  boolean fLh = true;
  private String fLi;
  protected volatile int mCount;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    this.fKU = parama;
    this.fKS = new d(new b.a(parama));
    this.fKT = new c();
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    this.fKP = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return false;
    }
    long l1 = this.fKZ;
    long l2 = System.nanoTime();
    this.fKS.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.fKT.a(this.fKS, paramCanvas, localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
        }
      }
    }
    c(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.fKW) {
      this.fLf = l1;
    }
    return true;
  }
  
  private void c(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.fLe = (paramLong3 - paramLong2 + this.fLe);
      this.fLd += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean g(Canvas paramCanvas)
  {
    this.fKS.fLy = true;
    if (this.fKR == null)
    {
      this.fKP = false;
      return false;
    }
    if ((this.fKR.fMI) && (!this.fKR.fMM)) {
      return a(paramCanvas, this.fKR.fMJ);
    }
    this.fKP = false;
    if (this.fKR == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.fKR.fMg) {
      return false;
    }
    long l1 = this.fKZ;
    long l2 = System.nanoTime();
    this.fKS.reset();
    localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      try
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (DrawActionWrapper)((Iterator)localObject1).next();
          if (localObject3 == null) {
            continue;
          }
          try
          {
            switch (((DrawActionWrapper)localObject3).type)
            {
            case 1: 
              y.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", new Object[] { Integer.valueOf(((DrawActionWrapper)localObject3).type) });
            }
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
          continue;
        }
        this.fKT.a(this.fKS, paramCanvas, ((DrawActionWrapper)localObject3).fLB);
      }
      catch (Exception paramCanvas)
      {
        y.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        c(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.fKW) {
          this.fLf = l1;
        }
        return true;
      }
      throw new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject3).fLB.toString());
      Object localObject2 = this.fKT;
      d locald = this.fKS;
      Object localObject3 = ((DrawActionWrapper)localObject3).fLA;
      localObject2 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject2).fLo.get(((BaseDrawActionArg)localObject3).method);
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject2).a(locald, paramCanvas, (DrawActionArg)localObject3);
      }
    }
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    this.fKU.t(new b.5(this, paramDrawCanvasArg, parama));
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    this.fKU.t(new b.3(this, paramJSONArray, parama));
  }
  
  public final void adB() {}
  
  public final void adC()
  {
    this.fKU.t(new b.7(this));
  }
  
  public final void adD()
  {
    int i = this.mCount;
    long l1 = this.fLe;
    long l2 = this.fLd;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L)) {}
    float f1;
    float f2;
    do
    {
      return;
      f1 = (float)this.fLc * 1.0F / this.fLb / 1000000.0F;
      f2 = (float)l1 * 1.0F / i / 1000000.0F;
      y.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.fLb), Integer.valueOf(i) });
    } while (this.fLg == null);
    this.fLg.cv(l1 / i);
    this.fLg.cw(l2 / i);
    this.fLg.b(l1, l2, i);
    this.fLg.ae(f1);
    this.fLg.af(f2);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    if (paramDrawCanvasArg == null) {
      return;
    }
    this.fKU.t(new b.6(this, paramDrawCanvasArg, parama));
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return;
    }
    this.fKU.t(new b.4(this, paramJSONArray, parama));
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    if (this.fLh)
    {
      this.fKS.fLy = false;
      return a(paramCanvas, this.fKQ);
    }
    return g(paramCanvas);
  }
  
  public final d getDrawContext()
  {
    return this.fKS;
  }
  
  public final String getSessionId()
  {
    return this.fKV;
  }
  
  public final String getTraceId()
  {
    return this.fLi;
  }
  
  public final boolean isPaused()
  {
    return this.fKW;
  }
  
  public final void onPause()
  {
    this.fKZ = 0L;
    this.fKU.t(this.fKX);
  }
  
  public final void onResume()
  {
    this.fKU.t(this.fKY);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.fLg = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.fKV = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.fKZ = paramLong;
    this.fLa = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.fLi = paramString;
  }
  
  public final void t(Runnable paramRunnable)
  {
    if (equals(this.fKU)) {
      return;
    }
    this.fKU.t(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */