package com.tencent.matrix.trace.tracer;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import com.tencent.matrix.trace.f.b.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends g
{
  private final com.tencent.matrix.trace.a.b fdU;
  private AppMethodBeat.a ffp;
  private long[] ffq = new long[3];
  public long ffr;
  private boolean ffs;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.fdU = paramb;
    if (paramb.fbi == null) {}
    for (;;)
    {
      this.ffr = i;
      this.ffs = paramb.fdC;
      return;
      i = paramb.fbi.L(com.tencent.b.a.a.a.ahaa.name(), 700);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.fdU.fdK) {}
    for (l = System.currentTimeMillis();; l = 0L)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      try
      {
        if (paramLong1 >= this.ffr)
        {
          long[] arrayOfLong1 = AppMethodBeat.getInstance().copyData(this.ffp);
          long[] arrayOfLong2 = new long[3];
          System.arraycopy(this.ffq, 0, arrayOfLong2, 0, 3);
          String str = com.tencent.matrix.a.eLw.eLy;
          com.tencent.matrix.e.b.aAp().post(new a(com.tencent.matrix.a.eLw.eLx, str, arrayOfLong1, arrayOfLong2, paramLong4 - paramLong2, paramLong1, paramLong3 / 1000000L));
        }
        return;
      }
      finally
      {
        this.ffp.release();
        if (!this.fdU.fdK) {
          break;
        }
        com.tencent.matrix.e.c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.f.c.N(paramLong4 - paramLong2, paramLong1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.ffq[0] = paramLong4;
    this.ffq[1] = paramLong5;
    this.ffq[2] = paramLong6;
  }
  
  public final void e(long paramLong1, long paramLong2, long paramLong3)
  {
    super.e(paramLong1, paramLong2, paramLong3);
    this.ffp = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.ffs) {
      com.tencent.matrix.trace.core.b.azL().a(this);
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.ffs) {
      com.tencent.matrix.trace.core.b.azL().b(this);
    }
  }
  
  final class a
    implements Runnable
  {
    long cost;
    long endMs;
    long[] feO;
    long[] fft;
    long ffu;
    boolean ffv;
    String scene;
    
    a(boolean paramBoolean, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2, long paramLong3)
    {
      this.ffv = paramBoolean;
      this.scene = paramString;
      this.cost = paramLong2;
      this.ffu = paramLong1;
      this.fft = paramArrayOfLong1;
      this.feO = paramArrayOfLong2;
      this.endMs = paramLong3;
    }
    
    public final void run()
    {
      Object localObject2 = com.tencent.matrix.trace.f.c.ny(Process.myPid());
      Object localObject1 = com.tencent.matrix.trace.f.c.N(this.ffu, this.cost);
      Object localObject4 = new LinkedList();
      if (this.fft.length > 0)
      {
        com.tencent.matrix.trace.f.b.a(this.fft, (LinkedList)localObject4, true, this.endMs);
        com.tencent.matrix.trace.f.b.a((List)localObject4, new b.a()
        {
          public final int azV()
          {
            return 60;
          }
          
          public final boolean k(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void l(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            com.tencent.matrix.e.c.w("Matrix.EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
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
      long l1 = Math.max(this.cost, com.tencent.matrix.trace.f.b.a((LinkedList)localObject4, localStringBuilder, (StringBuilder)localObject3));
      String str1 = com.tencent.matrix.trace.f.b.b((List)localObject4, l1);
      String str2 = this.scene;
      boolean bool = this.ffv;
      long l2 = ((LinkedList)localObject4).size();
      long l3 = this.feO[0];
      long l4 = this.feO[1];
      long l5 = this.feO[2];
      long l6 = this.cost;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(String.format("-\n>>>>>>>>>>>>>>>>>>>>> maybe happens Jankiness!(%sms) <<<<<<<<<<<<<<<<<<<<<\n", new Object[] { Long.valueOf(l6) }));
      ((StringBuilder)localObject4).append("|* [Status]\n");
      ((StringBuilder)localObject4).append("|*\t\tScene: ").append(str2).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tForeground: ").append(bool).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tPriority: ").append(localObject2[0]).append("\tNice: ").append(localObject2[1]).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.e.a.awm()).append("\n");
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
        com.tencent.matrix.e.c.w("Matrix.EvilMethodTracer", "%s", new Object[] { ((StringBuilder)localObject4).toString() });
        try
        {
          localObject2 = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
          if (localObject2 == null)
          {
            return;
            ((StringBuilder)localObject4).append(String.format("AppMethodBeat is close[%s].", new Object[] { Boolean.valueOf(AppMethodBeat.getInstance().isAlive()) })).append("\n");
          }
          else
          {
            localObject3 = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
            ((JSONObject)localObject3).put("detail", com.tencent.matrix.trace.b.a.a.fdV);
            ((JSONObject)localObject3).put("cost", l1);
            ((JSONObject)localObject3).put("usage", localObject1);
            ((JSONObject)localObject3).put("scene", this.scene);
            ((JSONObject)localObject3).put("stack", localStringBuilder.toString());
            ((JSONObject)localObject3).put("stackKey", str1);
            localObject1 = new com.tencent.matrix.report.g();
            ((com.tencent.matrix.report.g)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.g)localObject1).eYz = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.b)localObject2).onDetectIssue((com.tencent.matrix.report.g)localObject1);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          com.tencent.matrix.e.c.e("Matrix.EvilMethodTracer", "[JSONException error: %s", new Object[] { localJSONException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.a
 * JD-Core Version:    0.7.0.1
 */