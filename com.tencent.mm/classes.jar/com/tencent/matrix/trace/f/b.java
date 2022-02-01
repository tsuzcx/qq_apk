package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends f
{
  private AppMethodBeat.a cAb;
  private long[] cAc = new long[3];
  public long cAd;
  private boolean cAe;
  private final com.tencent.matrix.trace.a.b cyQ;
  
  public b(com.tencent.matrix.trace.a.b paramb)
  {
    this.cyQ = paramb;
    if (paramb.ctq == null) {}
    for (;;)
    {
      this.cAd = i;
      this.cAe = paramb.cyJ;
      return;
      i = paramb.ctq.get(com.tencent.c.a.a.a.JII.name(), 700);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.cyQ.cyM) {}
    for (l = System.currentTimeMillis();; l = 0L)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      try
      {
        if (paramLong1 >= this.cAd)
        {
          long[] arrayOfLong1 = AppMethodBeat.getInstance().copyData(this.cAb);
          long[] arrayOfLong2 = new long[3];
          System.arraycopy(this.cAc, 0, arrayOfLong2, 0, 3);
          String str = AppMethodBeat.getVisibleScene();
          com.tencent.matrix.g.b.HZ().post(new a(com.tencent.matrix.a.cqa.cqc, str, arrayOfLong1, arrayOfLong2, paramLong4 - paramLong2, paramLong1, paramLong3 / 1000000L));
        }
        return;
      }
      finally
      {
        this.cAb.release();
        if (!this.cyQ.cyM) {
          break;
        }
        com.tencent.matrix.g.c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.p(paramLong4 - paramLong2, paramLong1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.cAc[0] = paramLong4;
    this.cAc[1] = paramLong5;
    this.cAc[2] = paramLong6;
  }
  
  public final void d(long paramLong1, long paramLong2, long paramLong3)
  {
    super.d(paramLong1, paramLong2, paramLong3);
    this.cAb = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.cAe) {
      com.tencent.matrix.trace.core.b.HF().a(this);
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.cAe) {
      com.tencent.matrix.trace.core.b.HF().b(this);
    }
  }
  
  final class a
    implements Runnable
  {
    long[] cAf;
    long cAg;
    long cAh;
    long cfj;
    boolean cqM;
    long[] czu;
    String scene;
    
    a(boolean paramBoolean, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2, long paramLong3)
    {
      this.cqM = paramBoolean;
      this.scene = paramString;
      this.cfj = paramLong2;
      this.cAg = paramLong1;
      this.cAf = paramArrayOfLong1;
      this.czu = paramArrayOfLong2;
      this.cAh = paramLong3;
    }
    
    public final void run()
    {
      Object localObject2 = com.tencent.matrix.trace.g.b.gX(Process.myPid());
      Object localObject1 = com.tencent.matrix.trace.g.b.p(this.cAg, this.cfj);
      Object localObject4 = new LinkedList();
      if (this.cAf.length > 0)
      {
        com.tencent.matrix.trace.g.a.a(this.cAf, (LinkedList)localObject4, true, this.cAh);
        com.tencent.matrix.trace.g.a.a((List)localObject4, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean b(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void d(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            com.tencent.matrix.g.c.w("Matrix.EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
            paramAnonymousList = paramAnonymousList.listIterator(Math.min(paramAnonymousInt, 30));
            while (paramAnonymousList.hasNext())
            {
              paramAnonymousList.next();
              paramAnonymousList.remove();
            }
          }
        });
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject3 = new StringBuilder();
      long l1 = Math.max(this.cfj, com.tencent.matrix.trace.g.a.a((LinkedList)localObject4, localStringBuilder, (StringBuilder)localObject3));
      String str1 = com.tencent.matrix.trace.g.a.a((List)localObject4, l1);
      String str2 = this.scene;
      boolean bool = this.cqM;
      long l2 = ((LinkedList)localObject4).size();
      long l3 = this.czu[0];
      long l4 = this.czu[1];
      long l5 = this.czu[2];
      long l6 = this.cfj;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(String.format("-\n>>>>>>>>>>>>>>>>>>>>> maybe happens Jankiness!(%sms) <<<<<<<<<<<<<<<<<<<<<\n", new Object[] { Long.valueOf(l6) }));
      ((StringBuilder)localObject4).append("|* [Status]\n");
      ((StringBuilder)localObject4).append("|*\t\tScene: ").append(str2).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tForeground: ").append(bool).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tPriority: ").append(localObject2[0]).append("\tNice: ").append(localObject2[1]).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.g.a.is64BitRuntime()).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tCPU: ").append((String)localObject1).append("\n");
      ((StringBuilder)localObject4).append("|* [doFrame]\n");
      ((StringBuilder)localObject4).append("|*\t\tinputCost:animationCost:traversalCost\n");
      ((StringBuilder)localObject4).append("|*\t\t").append(l3).append(":").append(l4).append(":").append(l5).append("\n");
      if (l2 > 0L)
      {
        ((StringBuilder)localObject4).append("|*\t\tStackKey: ").append(str1).append("\n");
        ((StringBuilder)localObject4).append(((StringBuilder)localObject3).toString());
      }
      for (;;)
      {
        ((StringBuilder)localObject4).append("=========================================================================");
        com.tencent.matrix.g.c.w("Matrix.EvilMethodTracer", "%s", new Object[] { ((StringBuilder)localObject4).toString() });
        try
        {
          localObject2 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class);
          if (localObject2 == null)
          {
            return;
            ((StringBuilder)localObject4).append(String.format("AppMethodBeat is close[%s].", new Object[] { Boolean.valueOf(AppMethodBeat.getInstance().isAlive()) })).append("\n");
          }
          else
          {
            localObject3 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.Gq().application);
            ((JSONObject)localObject3).put("detail", com.tencent.matrix.trace.b.a.a.cyR);
            ((JSONObject)localObject3).put("cost", l1);
            ((JSONObject)localObject3).put("usage", localObject1);
            ((JSONObject)localObject3).put("scene", this.scene);
            ((JSONObject)localObject3).put("stack", localStringBuilder.toString());
            ((JSONObject)localObject3).put("stackKey", str1);
            localObject1 = new com.tencent.matrix.report.c();
            ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.c)localObject1).cue = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.a)localObject2).onDetectIssue((com.tencent.matrix.report.c)localObject1);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          com.tencent.matrix.g.c.e("Matrix.EvilMethodTracer", "[JSONException error: %s", new Object[] { localJSONException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.b
 * JD-Core Version:    0.7.0.1
 */