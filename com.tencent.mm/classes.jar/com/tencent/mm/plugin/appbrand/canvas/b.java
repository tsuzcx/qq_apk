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
  volatile boolean kYN;
  JSONArray kYO;
  volatile DrawCanvasArg kYP;
  private d kYQ;
  private c kYR;
  public com.tencent.mm.plugin.appbrand.canvas.widget.a kYS;
  public Runnable kYT;
  private Runnable kYU;
  public volatile long kYV;
  private volatile long kYW;
  protected volatile int kYX;
  protected volatile long kYY;
  protected volatile long kYZ;
  protected volatile long kZa;
  protected volatile long kZb;
  private com.tencent.mm.plugin.appbrand.canvas.c.a kZc;
  boolean kZd;
  private String kZe;
  protected volatile int mCount;
  public volatile boolean mPause;
  private volatile String mSessionId;
  
  public b(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144832);
    this.kYT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144823);
        b.this.kZb = 0L;
        b.this.mPause = true;
        AppMethodBeat.o(144823);
      }
    };
    this.kYU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144824);
        boolean bool = b.this.mPause;
        b.this.mPause = false;
        Log.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(b.this.kYN) });
        if ((bool) && (b.this.kYN)) {
          b.this.kYS.bzg();
        }
        AppMethodBeat.o(144824);
      }
    };
    this.kYX = 0;
    this.kZd = true;
    this.kYS = parama;
    this.kYQ = new d(new a(parama));
    this.kYR = new c();
    AppMethodBeat.o(144832);
  }
  
  private boolean a(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144835);
    this.kYN = false;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(144835);
      return false;
    }
    long l1 = this.kYV;
    long l2 = System.nanoTime();
    this.kYQ.reset();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {}
        try
        {
          this.kYR.a(this.kYQ, paramCanvas, localJSONObject);
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
    h(l1, l2, System.nanoTime());
    l1 = System.currentTimeMillis();
    if (!this.mPause) {
      this.kZb = l1;
    }
    AppMethodBeat.o(144835);
    return true;
  }
  
  private void h(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != 0L)
    {
      this.kZa = (paramLong3 - paramLong2 + this.kZa);
      this.kYZ += paramLong3 - paramLong1;
      this.mCount += 1;
    }
  }
  
  private boolean p(Canvas paramCanvas)
  {
    AppMethodBeat.i(144834);
    this.kYQ.kZt = true;
    if (this.kYP == null)
    {
      this.kYN = false;
      AppMethodBeat.o(144834);
      return false;
    }
    if ((this.kYP.laA) && (!this.kYP.laE))
    {
      boolean bool = a(paramCanvas, this.kYP.laB);
      AppMethodBeat.o(144834);
      return bool;
    }
    this.kYN = false;
    if (this.kYP == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (((List)localObject1).size() == 0); localObject1 = this.kYP.kZW)
    {
      AppMethodBeat.o(144834);
      return false;
    }
    long l1 = this.kYV;
    long l2 = System.nanoTime();
    this.kYQ.reset();
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
        this.kYR.a(this.kYQ, paramCanvas, ((DrawActionWrapper)localObject4).kZw);
      }
      catch (Exception paramCanvas)
      {
        Log.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", paramCanvas, "", new Object[0]);
        h(l1, l2, System.nanoTime());
        l1 = System.currentTimeMillis();
        if (!this.mPause) {
          this.kZb = l1;
        }
        AppMethodBeat.o(144834);
        return true;
      }
      Object localObject2 = new IllegalStateException("please use draw obj " + ((DrawActionWrapper)localObject4).kZw.toString());
      AppMethodBeat.o(144834);
      throw ((Throwable)localObject2);
      Object localObject3 = this.kYR;
      localObject2 = this.kYQ;
      Object localObject4 = ((DrawActionWrapper)localObject4).kZv;
      localObject3 = (com.tencent.mm.plugin.appbrand.canvas.action.d)((c)localObject3).kZk.get(((BaseDrawActionArg)localObject4).method);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.appbrand.canvas.action.d)localObject3).a((d)localObject2, paramCanvas, (DrawActionArg)localObject4);
      }
    }
  }
  
  public final void U(Runnable paramRunnable)
  {
    AppMethodBeat.i(144842);
    if (equals(this.kYS))
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
    this.kYS.U(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144827);
        DrawCanvasArg localDrawCanvasArg = b.this.kYP;
        b.this.kYP = paramDrawCanvasArg;
        b.this.kYN = true;
        b.this.kZd = false;
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
    this.kYS.U(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144825);
        DrawCanvasArg localDrawCanvasArg = b.this.kYP;
        b.this.kYP = null;
        b.this.kYO = paramJSONArray;
        b.this.kZd = true;
        b.this.kYN = true;
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
    this.kYS.U(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144828);
        if (b.this.kYP == null)
        {
          AppMethodBeat.o(144828);
          return;
        }
        b.this.kYP.kZW.addAll(paramDrawCanvasArg.kZW);
        b.this.kYN = true;
        b.this.kZd = false;
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
    this.kYS.U(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144826);
        b.this.kZd = true;
        if (b.this.kYO == null) {
          b.this.kYO = paramJSONArray;
        }
        for (;;)
        {
          b.this.kYN = true;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(144826);
          return;
          int i = 0;
          while (i < paramJSONArray.length())
          {
            b.this.kYO.put(paramJSONArray.opt(i));
            i += 1;
          }
        }
      }
    });
    AppMethodBeat.o(144837);
  }
  
  public final void bzg() {}
  
  public final void bzh()
  {
    AppMethodBeat.i(144840);
    this.kYS.U(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144829);
        Log.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
        b.this.kYP = null;
        b.this.kYO = null;
        b.this.kYN = true;
        AppMethodBeat.o(144829);
      }
    });
    AppMethodBeat.o(144840);
  }
  
  public final void bzi()
  {
    AppMethodBeat.i(144843);
    int i = this.mCount;
    long l1 = this.kZa;
    long l2 = this.kYZ;
    if ((i <= 0) || (l1 <= 0L) || (l2 <= 0L))
    {
      AppMethodBeat.o(144843);
      return;
    }
    float f1 = (float)this.kYY * 1.0F / this.kYX / 1000000.0F;
    float f2 = (float)l1 * 1.0F / i / 1000000.0F;
    Log.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.kYX), Integer.valueOf(i) });
    if (this.kZc != null)
    {
      this.kZc.Ba(l1 / i);
      this.kZc.Bb(l2 / i);
      this.kZc.d(l1, l2, i);
      this.kZc.aH(f1);
      this.kZc.aI(f2);
    }
    AppMethodBeat.o(144843);
  }
  
  public final d getDrawContext()
  {
    return this.kYQ;
  }
  
  public final String getSessionId()
  {
    return this.mSessionId;
  }
  
  public final String getTraceId()
  {
    return this.kZe;
  }
  
  public final boolean isPaused()
  {
    return this.mPause;
  }
  
  public final boolean o(Canvas paramCanvas)
  {
    AppMethodBeat.i(144833);
    if (this.kZd)
    {
      this.kYQ.kZt = false;
      bool = a(paramCanvas, this.kYO);
      AppMethodBeat.o(144833);
      return bool;
    }
    boolean bool = p(paramCanvas);
    AppMethodBeat.o(144833);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(144841);
    this.kYS.U(this.kYU);
    AppMethodBeat.o(144841);
  }
  
  public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.kZc = parama;
  }
  
  public final void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.kYV = paramLong;
    this.kYW = paramLong;
  }
  
  public final void setTraceId(String paramString)
  {
    this.kZe = paramString;
  }
  
  static final class a
    implements a
  {
    private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> kZj;
    
    a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
    {
      AppMethodBeat.i(144830);
      this.kZj = new WeakReference(parama);
      AppMethodBeat.o(144830);
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(144831);
      com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.kZj.get();
      if (locala == null)
      {
        AppMethodBeat.o(144831);
        return;
      }
      locala.bzg();
      AppMethodBeat.o(144831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b
 * JD-Core Version:    0.7.0.1
 */