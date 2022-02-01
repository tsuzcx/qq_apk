package com.tencent.matrix.trace.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class b$a
  implements Runnable
{
  long[] cCW;
  long cCX;
  long cCY;
  long[] cCl;
  long cin;
  boolean ctF;
  String scene;
  
  b$a(b paramb, boolean paramBoolean, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2, long paramLong3)
  {
    this.ctF = paramBoolean;
    this.scene = paramString;
    this.cin = paramLong2;
    this.cCX = paramLong1;
    this.cCW = paramArrayOfLong1;
    this.cCl = paramArrayOfLong2;
    this.cCY = paramLong3;
  }
  
  public final void run()
  {
    Object localObject2 = com.tencent.matrix.trace.g.b.ho(Process.myPid());
    Object localObject1 = com.tencent.matrix.trace.g.b.t(this.cCX, this.cin);
    Object localObject4 = new LinkedList();
    if (this.cCW.length > 0)
    {
      com.tencent.matrix.trace.g.a.a(this.cCW, (LinkedList)localObject4, true, this.cCY);
      com.tencent.matrix.trace.g.a.a((List)localObject4, new com.tencent.matrix.trace.g.a.a()
      {
        public final boolean c(long paramAnonymousLong, int paramAnonymousInt)
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
    long l1 = Math.max(this.cin, com.tencent.matrix.trace.g.a.a((LinkedList)localObject4, localStringBuilder, (StringBuilder)localObject3));
    String str1 = com.tencent.matrix.trace.g.a.b((List)localObject4, l1);
    String str2 = this.scene;
    boolean bool = this.ctF;
    long l2 = ((LinkedList)localObject4).size();
    long l3 = this.cCl[0];
    long l4 = this.cCl[1];
    long l5 = this.cCl[2];
    long l6 = this.cin;
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
        localObject2 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class);
        if (localObject2 == null)
        {
          return;
          ((StringBuilder)localObject4).append(String.format("AppMethodBeat is close[%s].", new Object[] { Boolean.valueOf(AppMethodBeat.getInstance().isAlive()) })).append("\n");
        }
        else
        {
          localObject3 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.GF().application);
          ((JSONObject)localObject3).put("detail", com.tencent.matrix.trace.b.a.a.cBI);
          ((JSONObject)localObject3).put("cost", l1);
          ((JSONObject)localObject3).put("usage", localObject1);
          ((JSONObject)localObject3).put("scene", this.scene);
          ((JSONObject)localObject3).put("stack", localStringBuilder.toString());
          ((JSONObject)localObject3).put("stackKey", str1);
          localObject1 = new com.tencent.matrix.report.c();
          ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
          ((com.tencent.matrix.report.c)localObject1).cwV = ((JSONObject)localObject3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.f.b.a
 * JD-Core Version:    0.7.0.1
 */