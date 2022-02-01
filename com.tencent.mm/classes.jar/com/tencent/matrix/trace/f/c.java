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
  private final long cAk;
  long cAl;
  private boolean cAm;
  long cAn;
  long cAo;
  long cAp;
  long cAq;
  public int cAr = 0;
  private long cAs = 0L;
  private final com.tencent.matrix.trace.a.b cyQ;
  private final HashSet<com.tencent.matrix.trace.e.b> listeners = new HashSet();
  
  public c(com.tencent.matrix.trace.a.b paramb)
  {
    this.cyQ = paramb;
    this.cAk = com.tencent.matrix.trace.core.b.HF().cpI;
    if (paramb.ctq == null)
    {
      i = 10000;
      this.cAl = i;
      this.cAm = paramb.cyI;
      if (paramb.ctq != null) {
        break label202;
      }
      i = 42;
      label75:
      this.cAn = i;
      if (paramb.ctq != null) {
        break label223;
      }
      i = 24;
      label91:
      this.cAo = i;
      if (paramb.ctq != null) {
        break label244;
      }
      i = 3;
      label106:
      this.cAq = i;
      if (paramb.ctq != null) {
        break label264;
      }
    }
    label264:
    for (int i = 9;; i = paramb.ctq.get(a.a.JIK.name(), 9))
    {
      this.cAp = i;
      com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", new Object[] { Long.valueOf(this.cAk), Boolean.valueOf(this.cAm) });
      if (this.cAm) {
        a(new b((byte)0));
      }
      return;
      i = paramb.ctq.get(a.a.JIH.name(), 10000);
      break;
      label202:
      i = paramb.ctq.get(a.a.JIM.name(), 42);
      break label75;
      label223:
      i = paramb.ctq.get(a.a.JIL.name(), 24);
      break label91;
      label244:
      i = paramb.ctq.get(a.a.JIJ.name(), 3);
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
  
  public final void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    if (com.tencent.matrix.a.cqa.cqc)
    {
      long l1 = System.currentTimeMillis();
      long l2 = paramLong2 - paramLong3;
      for (;;)
      {
        int i;
        com.tencent.matrix.trace.e.b localb;
        try
        {
          i = (int)(l2 / this.cAk);
          this.cAr += i;
          long l3 = this.cAs;
          this.cAs = (Math.max(l2, this.cAk) + l3);
          synchronized (this.listeners)
          {
            Iterator localIterator = this.listeners.iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localb = (com.tencent.matrix.trace.e.b)localIterator.next();
            if (this.cyQ.cyM) {
              localb.time = SystemClock.uptimeMillis();
            }
            if (localb.getExecutor() == null) {
              break label449;
            }
            if (localb.HM() > 0)
            {
              Object localObject = b.a.HO();
              ((b.a)localObject).czM = paramString;
              ((b.a)localObject).czN = paramLong1;
              ((b.a)localObject).czO = paramLong2;
              ((b.a)localObject).czP = i;
              ((b.a)localObject).czk = paramBoolean;
              ((b.a)localObject).czQ = paramLong3;
              ((b.a)localObject).czR = paramLong4;
              ((b.a)localObject).czS = paramLong5;
              ((b.a)localObject).czT = paramLong6;
              localb.list.add(localObject);
              if ((localb.list.size() >= localb.czI) && (localb.getExecutor() != null))
              {
                localObject = new LinkedList(localb.list);
                localb.list.clear();
                localb.getExecutor().execute(new b.1(localb, (List)localObject));
              }
              if (!this.cyQ.cyM) {
                continue;
              }
              localb.time = (SystemClock.uptimeMillis() - localb.time);
              com.tencent.matrix.g.c.d("Matrix.FrameTracer", "[notifyListener] cost:%sms listener:%s", new Object[] { Long.valueOf(localb.time), localb });
            }
          }
          localb.getExecutor().execute(new c.1(this, localb, paramString, paramLong1, paramLong2, i, paramBoolean, paramLong3, paramLong4, paramLong5, paramLong6));
        }
        finally
        {
          paramLong1 = System.currentTimeMillis() - l1;
          if ((this.cyQ.cuo) && (paramLong1 > this.cAk)) {
            com.tencent.matrix.g.c.w("Matrix.FrameTracer", "[notifyListener] warm! maybe do heavy work in doFrameSync! size:%s cost:%sms", new Object[] { Integer.valueOf(this.listeners.size()), Long.valueOf(paramLong1) });
          }
        }
        continue;
        label449:
        l2 = (paramLong2 - paramLong3) / 1000000L;
        localb.a(paramString, l2, l2, i, paramBoolean);
      }
      paramLong1 = System.currentTimeMillis() - l1;
      if ((this.cyQ.cuo) && (paramLong1 > this.cAk)) {
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
    com.tencent.matrix.trace.core.b.HF().a(this);
  }
  
  public final void onDead()
  {
    super.onDead();
    com.tencent.matrix.trace.core.b.HF().b(this);
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
    private Handler cAK = new Handler(com.tencent.matrix.g.b.HY().getLooper());
    private HashMap<String, c.c> csJ = new HashMap();
    Executor executor = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        c.b.a(c.b.this).post(paramAnonymousRunnable);
      }
    };
    
    private b() {}
    
    public final void F(List<b.a> paramList)
    {
      super.F(paramList);
      Iterator localIterator = paramList.iterator();
      Object localObject2;
      int i;
      while (localIterator.hasNext())
      {
        paramList = (b.a)localIterator.next();
        localObject2 = paramList.czM;
        i = paramList.czP;
        boolean bool = paramList.czk;
        if ((!com.tencent.matrix.trace.g.b.cX((String)localObject2)) && (bool))
        {
          paramList = (c.c)this.csJ.get(localObject2);
          if (paramList != null) {
            break label1025;
          }
          paramList = new c.c(c.this, (String)localObject2);
          this.csJ.put(localObject2, paramList);
        }
      }
      label1025:
      for (;;)
      {
        for (;;)
        {
          float f1 = 1.0F * (float)com.tencent.matrix.trace.core.b.HF().cpI / 1000000.0F;
          float f2 = (float)paramList.cAM;
          paramList.cAM = ((f1 * (i + 1) + f2));
          paramList.cAO += i;
          paramList.cAN += 1;
          Object localObject3;
          int j;
          if (i >= paramList.cAD.cAn)
          {
            localObject3 = paramList.cAP;
            j = c.a.cAE.index;
            localObject3[j] += 1;
            localObject3 = paramList.cAQ;
            j = c.a.cAE.index;
            localObject3[j] = (i + localObject3[j]);
            label228:
            if (paramList.cAM < c.this.cAl) {
              break;
            }
            this.csJ.remove(localObject2);
            f1 = Math.min(60.0F, 1000.0F * paramList.cAN / (float)paramList.cAM);
            com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[report] FPS:%s %s", new Object[] { Float.valueOf(f1), paramList.toString() });
          }
          try
          {
            localObject2 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class);
            if (localObject2 == null)
            {
              paramList.cAN = 0;
              paramList.cAO = 0;
              paramList.cAM = 0L;
              break;
              if (i >= paramList.cAD.cAo)
              {
                localObject3 = paramList.cAP;
                j = c.a.cAF.index;
                localObject3[j] += 1;
                localObject3 = paramList.cAQ;
                j = c.a.cAF.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              if (i >= paramList.cAD.cAp)
              {
                localObject3 = paramList.cAP;
                j = c.a.cAG.index;
                localObject3[j] += 1;
                localObject3 = paramList.cAQ;
                j = c.a.cAG.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              if (i >= paramList.cAD.cAq)
              {
                localObject3 = paramList.cAP;
                j = c.a.cAH.index;
                localObject3[j] += 1;
                localObject3 = paramList.cAQ;
                j = c.a.cAH.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              localObject3 = paramList.cAP;
              j = c.a.cAI.index;
              localObject3[j] += 1;
              localObject3 = paramList.cAQ;
              j = c.a.cAI.index;
              int k = localObject3[j];
              localObject3[j] = (Math.max(i, 0) + k);
              break label228;
            }
            Object localObject4 = new JSONObject();
            ((JSONObject)localObject4).put(c.a.cAE.name(), paramList.cAP[c.a.cAE.index]);
            ((JSONObject)localObject4).put(c.a.cAF.name(), paramList.cAP[c.a.cAF.index]);
            ((JSONObject)localObject4).put(c.a.cAG.name(), paramList.cAP[c.a.cAG.index]);
            ((JSONObject)localObject4).put(c.a.cAH.name(), paramList.cAP[c.a.cAH.index]);
            ((JSONObject)localObject4).put(c.a.cAI.name(), paramList.cAP[c.a.cAI.index]);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put(c.a.cAE.name(), paramList.cAQ[c.a.cAE.index]);
            localJSONObject.put(c.a.cAF.name(), paramList.cAQ[c.a.cAF.index]);
            localJSONObject.put(c.a.cAG.name(), paramList.cAQ[c.a.cAG.index]);
            localJSONObject.put(c.a.cAH.name(), paramList.cAQ[c.a.cAH.index]);
            localJSONObject.put(c.a.cAI.name(), paramList.cAQ[c.a.cAI.index]);
            localObject3 = com.tencent.matrix.g.a.a(new JSONObject(), ((com.tencent.matrix.trace.a)localObject2).getApplication());
            ((JSONObject)localObject3).put("scene", paramList.cqd);
            ((JSONObject)localObject3).put("dropLevel", localObject4);
            ((JSONObject)localObject3).put("dropSum", localJSONObject);
            ((JSONObject)localObject3).put("fps", f1);
            localObject4 = new com.tencent.matrix.report.c();
            ((com.tencent.matrix.report.c)localObject4).tag = "Trace_FPS";
            ((com.tencent.matrix.report.c)localObject4).cue = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.a)localObject2).onDetectIssue((com.tencent.matrix.report.c)localObject4);
            paramList.cAN = 0;
            paramList.cAO = 0;
            paramList.cAM = 0L;
            break;
          }
          catch (JSONException localJSONException)
          {
            com.tencent.matrix.g.c.e("Matrix.FrameTracer", "json error", new Object[] { localJSONException });
            paramList.cAN = 0;
            paramList.cAO = 0;
            paramList.cAM = 0L;
            break;
          }
          finally
          {
            paramList.cAN = 0;
            paramList.cAO = 0;
            paramList.cAM = 0L;
          }
        }
        return;
      }
    }
    
    public final int HM()
    {
      return 300;
    }
    
    public final Executor getExecutor()
    {
      return this.executor;
    }
  }
  
  final class c
  {
    long cAM;
    int cAN = 0;
    int cAO;
    int[] cAP = new int[c.a.values().length];
    int[] cAQ = new int[c.a.values().length];
    String cqd;
    
    c(String paramString)
    {
      this.cqd = paramString;
    }
    
    public final String toString()
    {
      return "visibleScene=" + this.cqd + ", sumFrame=" + this.cAN + ", sumDroppedFrames=" + this.cAO + ", sumFrameCost=" + this.cAM + ", dropLevel=" + Arrays.toString(this.cAP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.c
 * JD-Core Version:    0.7.0.1
 */