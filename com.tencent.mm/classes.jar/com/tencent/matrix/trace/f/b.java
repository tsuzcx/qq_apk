package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.e.c;
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
  private final com.tencent.matrix.trace.a.b deV;
  private AppMethodBeat.a dgi;
  private long[] dgj = new long[3];
  public long dgk;
  private boolean dgl;
  
  public b(com.tencent.matrix.trace.a.b paramb)
  {
    this.deV = paramb;
    if (paramb.dcH == null) {}
    for (;;)
    {
      this.dgk = i;
      this.dgl = paramb.deN;
      return;
      i = paramb.dcH.D(com.tencent.b.a.a.a.Zbt.name(), 700);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.deV.deR) {}
    for (l = System.currentTimeMillis();; l = 0L)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      try
      {
        if (paramLong1 >= this.dgk)
        {
          long[] arrayOfLong1 = AppMethodBeat.getInstance().copyData(this.dgi);
          long[] arrayOfLong2 = new long[3];
          System.arraycopy(this.dgj, 0, arrayOfLong2, 0, 3);
          String str = AppMethodBeat.getVisibleScene();
          com.tencent.matrix.e.b.Yu().post(new a(com.tencent.matrix.a.cQs.cQt, str, arrayOfLong1, arrayOfLong2, paramLong4 - paramLong2, paramLong1, paramLong3 / 1000000L));
        }
        return;
      }
      finally
      {
        this.dgi.release();
        if (!this.deV.deR) {
          break;
        }
        c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.q(paramLong4 - paramLong2, paramLong1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.dgj[0] = paramLong4;
    this.dgj[1] = paramLong5;
    this.dgj[2] = paramLong6;
  }
  
  public final void d(long paramLong1, long paramLong2, long paramLong3)
  {
    super.d(paramLong1, paramLong2, paramLong3);
    this.dgi = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.dgl) {
      com.tencent.matrix.trace.core.b.Ya().a(this);
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.dgl) {
      com.tencent.matrix.trace.core.b.Ya().b(this);
    }
  }
  
  final class a
    implements Runnable
  {
    long cCY;
    long[] data;
    long[] dfz;
    long dgm;
    long dgn;
    boolean dgo;
    String scene;
    
    a(boolean paramBoolean, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2, long paramLong3)
    {
      this.dgo = paramBoolean;
      this.scene = paramString;
      this.cCY = paramLong2;
      this.dgm = paramLong1;
      this.data = paramArrayOfLong1;
      this.dfz = paramArrayOfLong2;
      this.dgn = paramLong3;
    }
    
    public final void run()
    {
      Object localObject2 = com.tencent.matrix.trace.g.b.jJ(Process.myPid());
      Object localObject1 = com.tencent.matrix.trace.g.b.q(this.dgm, this.cCY);
      Object localObject4 = new LinkedList();
      if (this.data.length > 0)
      {
        com.tencent.matrix.trace.g.a.a(this.data, (LinkedList)localObject4, true, this.dgn);
        com.tencent.matrix.trace.g.a.a((List)localObject4, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean c(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void d(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            c.w("Matrix.EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
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
      long l1 = Math.max(this.cCY, com.tencent.matrix.trace.g.a.a((LinkedList)localObject4, localStringBuilder, (StringBuilder)localObject3));
      String str1 = com.tencent.matrix.trace.g.a.a((List)localObject4, l1);
      String str2 = this.scene;
      boolean bool = this.dgo;
      long l2 = ((LinkedList)localObject4).size();
      long l3 = this.dfz[0];
      long l4 = this.dfz[1];
      long l5 = this.dfz[2];
      long l6 = this.cCY;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(String.format("-\n>>>>>>>>>>>>>>>>>>>>> maybe happens Jankiness!(%sms) <<<<<<<<<<<<<<<<<<<<<\n", new Object[] { Long.valueOf(l6) }));
      ((StringBuilder)localObject4).append("|* [Status]\n");
      ((StringBuilder)localObject4).append("|*\t\tScene: ").append(str2).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tForeground: ").append(bool).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tPriority: ").append(localObject2[0]).append("\tNice: ").append(localObject2[1]).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.e.a.is64BitRuntime()).append("\n");
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
        c.w("Matrix.EvilMethodTracer", "%s", new Object[] { ((StringBuilder)localObject4).toString() });
        try
        {
          localObject2 = (com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class);
          if (localObject2 == null)
          {
            return;
            ((StringBuilder)localObject4).append(String.format("AppMethodBeat is close[%s].", new Object[] { Boolean.valueOf(AppMethodBeat.getInstance().isAlive()) })).append("\n");
          }
          else
          {
            localObject3 = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.b.Vu().application);
            ((JSONObject)localObject3).put("detail", com.tencent.matrix.trace.b.a.a.deW);
            ((JSONObject)localObject3).put("cost", l1);
            ((JSONObject)localObject3).put("usage", localObject1);
            ((JSONObject)localObject3).put("scene", this.scene);
            ((JSONObject)localObject3).put("stack", localStringBuilder.toString());
            ((JSONObject)localObject3).put("stackKey", str1);
            localObject1 = new com.tencent.matrix.report.f();
            ((com.tencent.matrix.report.f)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.f)localObject1).cZZ = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.b)localObject2).onDetectIssue((com.tencent.matrix.report.f)localObject1);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          c.e("Matrix.EvilMethodTracer", "[JSONException error: %s", new Object[] { localJSONException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.b
 * JD-Core Version:    0.7.0.1
 */