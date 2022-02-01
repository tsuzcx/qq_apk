package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.c.a.a.a;
import com.tencent.matrix.trace.e.b.1;
import com.tencent.matrix.trace.e.b.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends f
{
  private final com.tencent.matrix.trace.a.b cBH;
  private final long cDc;
  long cDd;
  private boolean cDe;
  long cDf;
  long cDg;
  long cDh;
  long cDi;
  public int cDj = 0;
  private long cDk = 0L;
  private final HashSet<com.tencent.matrix.trace.e.b> listeners = new HashSet();
  
  public c(com.tencent.matrix.trace.a.b paramb)
  {
    this.cBH = paramb;
    this.cDc = com.tencent.matrix.trace.core.b.HU().csA;
    if (paramb.cwi == null)
    {
      i = 10000;
      this.cDd = i;
      this.cDe = paramb.cBz;
      if (paramb.cwi != null) {
        break label202;
      }
      i = 42;
      label75:
      this.cDf = i;
      if (paramb.cwi != null) {
        break label223;
      }
      i = 24;
      label91:
      this.cDg = i;
      if (paramb.cwi != null) {
        break label244;
      }
      i = 3;
      label106:
      this.cDi = i;
      if (paramb.cwi != null) {
        break label264;
      }
    }
    label264:
    for (int i = 9;; i = paramb.cwi.get(a.a.Ihc.name(), 9))
    {
      this.cDh = i;
      com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", new Object[] { Long.valueOf(this.cDc), Boolean.valueOf(this.cDe) });
      if (this.cDe) {
        a(new b((byte)0));
      }
      return;
      i = paramb.cwi.get(a.a.IgZ.name(), 10000);
      break;
      label202:
      i = paramb.cwi.get(a.a.Ihe.name(), 42);
      break label75;
      label223:
      i = paramb.cwi.get(a.a.Ihd.name(), 24);
      break label91;
      label244:
      i = paramb.cwi.get(a.a.Ihb.name(), 3);
      break label106;
    }
  }
  
  public final void a(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.add(paramb);
      return;
    }
  }
  
  public final void a(final String paramString, final long paramLong1, long paramLong2, boolean paramBoolean, final long paramLong3, final long paramLong4, final long paramLong5, long paramLong6)
  {
    if (com.tencent.matrix.a.csS.csU)
    {
      long l1 = System.currentTimeMillis();
      long l2 = paramLong2 - paramLong3;
      for (;;)
      {
        final int i;
        final com.tencent.matrix.trace.e.b localb;
        try
        {
          i = (int)(l2 / this.cDc);
          this.cDj += i;
          long l3 = this.cDk;
          this.cDk = (Math.max(l2, this.cDc) + l3);
          synchronized (this.listeners)
          {
            Iterator localIterator = this.listeners.iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localb = (com.tencent.matrix.trace.e.b)localIterator.next();
            if (this.cBH.cBD) {
              localb.time = SystemClock.uptimeMillis();
            }
            if (localb.getExecutor() == null) {
              break label449;
            }
            if (localb.Ib() > 0)
            {
              Object localObject = b.a.Id();
              ((b.a)localObject).cCD = paramString;
              ((b.a)localObject).cCE = paramLong1;
              ((b.a)localObject).cCF = paramLong2;
              ((b.a)localObject).cCG = i;
              ((b.a)localObject).cCb = paramBoolean;
              ((b.a)localObject).cCH = paramLong3;
              ((b.a)localObject).cCI = paramLong4;
              ((b.a)localObject).cCJ = paramLong5;
              ((b.a)localObject).cCK = paramLong6;
              localb.list.add(localObject);
              if ((localb.list.size() >= localb.cCz) && (localb.getExecutor() != null))
              {
                localObject = new LinkedList(localb.list);
                localb.list.clear();
                localb.getExecutor().execute(new b.1(localb, (List)localObject));
              }
              if (!this.cBH.cBD) {
                continue;
              }
              localb.time = (SystemClock.uptimeMillis() - localb.time);
              com.tencent.matrix.g.c.d("Matrix.FrameTracer", "[notifyListener] cost:%sms listener:%s", new Object[] { Long.valueOf(localb.time), localb });
            }
          }
          localb.getExecutor().execute(new Runnable()
          {
            public final void run()
            {
              localb.a(paramString, paramLong1, i, paramLong3, paramLong4, paramLong5, this.cDs, this.cDt, this.cDu);
            }
          });
        }
        finally
        {
          paramLong1 = System.currentTimeMillis() - l1;
          if ((this.cBH.cxf) && (paramLong1 > this.cDc)) {
            com.tencent.matrix.g.c.w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync! size:%s cost:%sms", new Object[] { Integer.valueOf(this.listeners.size()), Long.valueOf(paramLong1) });
          }
        }
        continue;
        label449:
        l2 = (paramLong2 - paramLong3) / 1000000L;
        localb.a(paramString, l2, l2, i, paramBoolean);
      }
      paramLong1 = System.currentTimeMillis() - l1;
      if ((this.cBH.cxf) && (paramLong1 > this.cDc)) {
        com.tencent.matrix.g.c.w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync! size:%s cost:%sms", new Object[] { Integer.valueOf(this.listeners.size()), Long.valueOf(paramLong1) });
      }
    }
  }
  
  public final void b(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.remove(paramb);
      return;
    }
  }
  
  public final void onAlive()
  {
    super.onAlive();
    com.tencent.matrix.trace.core.b.HU().a(this);
  }
  
  public final void onDead()
  {
    super.onDead();
    com.tencent.matrix.trace.core.b.HU().b(this);
  }
  
  public static enum a
  {
    public int index;
    
    private a(int paramInt)
    {
      this.index = paramInt;
    }
  }
  
  final class b
    extends com.tencent.matrix.trace.e.b
  {
    private Handler cDC = new Handler(com.tencent.matrix.g.b.Ip().getLooper());
    private HashMap<String, c.c> cvB = new HashMap();
    Executor executor = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        c.b.a(c.b.this).post(paramAnonymousRunnable);
      }
    };
    
    private b() {}
    
    public final int Ib()
    {
      return 300;
    }
    
    public final void O(List<b.a> paramList)
    {
      super.O(paramList);
      Iterator localIterator = paramList.iterator();
      Object localObject2;
      int i;
      while (localIterator.hasNext())
      {
        paramList = (b.a)localIterator.next();
        localObject2 = paramList.cCD;
        i = paramList.cCG;
        boolean bool = paramList.cCb;
        if ((!com.tencent.matrix.trace.g.b.dq((String)localObject2)) && (bool))
        {
          paramList = (c.c)this.cvB.get(localObject2);
          if (paramList != null) {
            break label1025;
          }
          paramList = new c.c(c.this, (String)localObject2);
          this.cvB.put(localObject2, paramList);
        }
      }
      label1025:
      for (;;)
      {
        for (;;)
        {
          float f1 = 1.0F * (float)com.tencent.matrix.trace.core.b.HU().csA / 1000000.0F;
          float f2 = (float)paramList.cDE;
          paramList.cDE = ((f1 * (i + 1) + f2));
          paramList.cDG += i;
          paramList.cDF += 1;
          Object localObject3;
          int j;
          if (i >= paramList.cDv.cDf)
          {
            localObject3 = paramList.cDH;
            j = c.a.cDw.index;
            localObject3[j] += 1;
            localObject3 = paramList.cDI;
            j = c.a.cDw.index;
            localObject3[j] = (i + localObject3[j]);
            label228:
            if (paramList.cDE < c.this.cDd) {
              break;
            }
            this.cvB.remove(localObject2);
            f1 = Math.min(60.0F, 1000.0F * paramList.cDF / (float)paramList.cDE);
            com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[report] FPS:%s %s", new Object[] { Float.valueOf(f1), paramList.toString() });
          }
          try
          {
            localObject2 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class);
            if (localObject2 == null)
            {
              paramList.cDF = 0;
              paramList.cDG = 0;
              paramList.cDE = 0L;
              break;
              if (i >= paramList.cDv.cDg)
              {
                localObject3 = paramList.cDH;
                j = c.a.cDx.index;
                localObject3[j] += 1;
                localObject3 = paramList.cDI;
                j = c.a.cDx.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              if (i >= paramList.cDv.cDh)
              {
                localObject3 = paramList.cDH;
                j = c.a.cDy.index;
                localObject3[j] += 1;
                localObject3 = paramList.cDI;
                j = c.a.cDy.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              if (i >= paramList.cDv.cDi)
              {
                localObject3 = paramList.cDH;
                j = c.a.cDz.index;
                localObject3[j] += 1;
                localObject3 = paramList.cDI;
                j = c.a.cDz.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              localObject3 = paramList.cDH;
              j = c.a.cDA.index;
              localObject3[j] += 1;
              localObject3 = paramList.cDI;
              j = c.a.cDA.index;
              int k = localObject3[j];
              localObject3[j] = (Math.max(i, 0) + k);
              break label228;
            }
            Object localObject4 = new JSONObject();
            ((JSONObject)localObject4).put(c.a.cDw.name(), paramList.cDH[c.a.cDw.index]);
            ((JSONObject)localObject4).put(c.a.cDx.name(), paramList.cDH[c.a.cDx.index]);
            ((JSONObject)localObject4).put(c.a.cDy.name(), paramList.cDH[c.a.cDy.index]);
            ((JSONObject)localObject4).put(c.a.cDz.name(), paramList.cDH[c.a.cDz.index]);
            ((JSONObject)localObject4).put(c.a.cDA.name(), paramList.cDH[c.a.cDA.index]);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put(c.a.cDw.name(), paramList.cDI[c.a.cDw.index]);
            localJSONObject.put(c.a.cDx.name(), paramList.cDI[c.a.cDx.index]);
            localJSONObject.put(c.a.cDy.name(), paramList.cDI[c.a.cDy.index]);
            localJSONObject.put(c.a.cDz.name(), paramList.cDI[c.a.cDz.index]);
            localJSONObject.put(c.a.cDA.name(), paramList.cDI[c.a.cDA.index]);
            localObject3 = com.tencent.matrix.g.a.a(new JSONObject(), ((com.tencent.matrix.trace.a)localObject2).getApplication());
            ((JSONObject)localObject3).put("scene", paramList.csV);
            ((JSONObject)localObject3).put("dropLevel", localObject4);
            ((JSONObject)localObject3).put("dropSum", localJSONObject);
            ((JSONObject)localObject3).put("fps", f1);
            localObject4 = new com.tencent.matrix.report.c();
            ((com.tencent.matrix.report.c)localObject4).tag = "Trace_FPS";
            ((com.tencent.matrix.report.c)localObject4).cwV = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.a)localObject2).onDetectIssue((com.tencent.matrix.report.c)localObject4);
            paramList.cDF = 0;
            paramList.cDG = 0;
            paramList.cDE = 0L;
            break;
          }
          catch (JSONException localJSONException)
          {
            com.tencent.matrix.g.c.e("Matrix.FrameTracer", "json error", new Object[] { localJSONException });
            paramList.cDF = 0;
            paramList.cDG = 0;
            paramList.cDE = 0L;
            break;
          }
          finally
          {
            paramList.cDF = 0;
            paramList.cDG = 0;
            paramList.cDE = 0L;
          }
        }
        return;
      }
    }
    
    public final Executor getExecutor()
    {
      return this.executor;
    }
  }
  
  final class c
  {
    long cDE;
    int cDF = 0;
    int cDG;
    int[] cDH = new int[c.a.values().length];
    int[] cDI = new int[c.a.values().length];
    String csV;
    
    c(String paramString)
    {
      this.csV = paramString;
    }
    
    public final String toString()
    {
      return "visibleScene=" + this.csV + ", sumFrame=" + this.cDF + ", sumDroppedFrames=" + this.cDG + ", sumFrameCost=" + this.cDE + ", dropLevel=" + Arrays.toString(this.cDH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.f.c
 * JD-Core Version:    0.7.0.1
 */