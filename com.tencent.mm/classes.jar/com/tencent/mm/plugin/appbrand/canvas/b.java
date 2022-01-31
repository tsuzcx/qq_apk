package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.appbrand.canvas.widget.a
{
  volatile boolean hed;
  JSONArray hee;
  volatile DrawCanvasArg hef;
  private d heg;
  private c heh;
  com.tencent.mm.plugin.appbrand.canvas.widget.a hei;
  private Runnable hej;
  private Runnable hek;
  private volatile long hel;
  private volatile long hem;
  protected volatile int hen;
  protected volatile long heo;
  protected volatile long hep;
  protected volatile long heq;
  protected volatile long her;
  private com.tencent.mm.plugin.appbrand.canvas.c.a hes;
  boolean het;
  private String heu;
  protected volatile int mCount;
  public volatile boolean mPause;
  private volatile String mSessionId;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(103149);
    this.hej = new Runnable()
    {
      public final void run()
      {
        b.this.her = 0L;
        b.this.mPause = true;
      }
    };
    this.hek = new b.2(this);
    this.hen = 0;
    this.het = true;
    this.hei = parama;
    this.heg = new d(new b.a(parama));
    this.heh = new c();
    AppMethodBeat.o(103149);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103152);
    this.hed = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(103152);
      return false;
    }
    long l1 = this.hel;
    long l2 = System.nanoTime();
    this.heg.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.heh.a(this.heg, paramCanvas, localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
        }
      }
    }
    e(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.mPause) {
      this.her = l1;
    }
    AppMethodBeat.o(103152);
    return true;
  }
  
  private void e(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.heq = (paramLong3 - paramLong2 + this.heq);
      this.hep += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean g(Canvas paramCanvas)
  {
    AppMethodBeat.i(103151);
    this.heg.heJ = true;
    if (this.hef == null)
    {
      this.hed = false;
      AppMethodBeat.o(103151);
      return false;
    }
    if ((this.hef.hfS) && (!this.hef.hfW))
    {
      boolean bool = a(paramCanvas, this.hef.hfT);
      AppMethodBeat.o(103151);
      return bool;
    }
    this.hed = false;
    if (this.hef == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.hef.hfq)
    {
      AppMethodBeat.o(103151);
      return false;
    }
    long l1 = this.hel;
    long l2 = System.nanoTime();
    this.heg.reset();
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
              ab.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", new Object[] { Integer.valueOf(((DrawActionWrapper)localObject4).type) });
            }
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[] { localException });
          }
          continue;
        }
        this.heh.a(this.heg, paramCanvas, ((DrawActionWrapper)localObject4).heM);
      }
      catch (Exception paramCanvas)
      {
        ab.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        e(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.her = l1;
        }
        AppMethodBeat.o(103151);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).heM.toString());
      AppMethodBeat.o(103151);
      throw ((Throwable)localObject2);
      Object localObject3 = this.heh;
      localObject2 = this.heg;
      Object localObject4 = ((DrawActionWrapper)localObject4).heL;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).heA.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(103159);
    if (equals(this.hei))
    {
      AppMethodBeat.o(103159);
      return;
    }
    al.d(paramRunnable);
    AppMethodBeat.o(103159);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103155);
    this.hei.B(new b.5(this, paramDrawCanvasArg, parama));
    AppMethodBeat.o(103155);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103153);
    this.hei.B(new b.3(this, paramJSONArray, parama));
    AppMethodBeat.o(103153);
  }
  
  public final void axT() {}
  
  public final void axU()
  {
    AppMethodBeat.i(103157);
    this.hei.B(new b.7(this));
    AppMethodBeat.o(103157);
  }
  
  public final void axV()
  {
    AppMethodBeat.i(103160);
    int i = this.mCount;
    long l1 = this.heq;
    long l2 = this.hep;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(103160);
      return;
    }
    float f1 = (float)this.heo * 1.0F / this.hen / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    ab.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.hen), Integer.valueOf(i) });
    if (this.hes != null)
    {
      this.hes.hu(l1 / i);
      this.hes.hv(l2 / i);
      this.hes.b(l1, l2, i);
      this.hes.ap(f1);
      this.hes.aq(f2);
    }
    AppMethodBeat.o(103160);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103156);
    if (paramDrawCanvasArg == null)
    {
      AppMethodBeat.o(103156);
      return;
    }
    this.hei.B(new b.6(this, paramDrawCanvasArg, parama));
    AppMethodBeat.o(103156);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103154);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(103154);
      return;
    }
    this.hei.B(new b.4(this, paramJSONArray, parama));
    AppMethodBeat.o(103154);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    AppMethodBeat.i(103150);
    if (this.het)
    {
      this.heg.heJ = false;
      bool = a(paramCanvas, this.hee);
      AppMethodBeat.o(103150);
      return bool;
    }
    boolean bool = g(paramCanvas);
    AppMethodBeat.o(103150);
    return bool;
  }
  
  public final d getDrawContext()
  {
    return this.heg;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.heu;
  }
  
  public final boolean isPaused()
  {
    return this.mPause;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103158);
    this.hei.B(this.hek);
    AppMethodBeat.o(103158);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.hes = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.hel = paramLong;
    this.hem = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.heu = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */