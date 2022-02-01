package com.tencent.matrix.trace.f;

import com.tencent.matrix.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class e$a
  implements Runnable
{
  long[] cCW;
  long cDJ;
  boolean cDM;
  long cDV;
  long cDW;
  int scene;
  
  e$a(e parame, long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
  {
    this.cCW = paramArrayOfLong;
    this.scene = paramInt;
    this.cDV = paramLong1;
    this.cDJ = paramLong2;
    this.cDW = paramLong3;
    this.cDM = paramBoolean;
  }
  
  public final void run()
  {
    Object localObject2 = new LinkedList();
    if (this.cCW.length > 0)
    {
      com.tencent.matrix.trace.g.a.a(this.cCW, (LinkedList)localObject2, false, -1L);
      com.tencent.matrix.trace.g.a.a((List)localObject2, new com.tencent.matrix.trace.g.a.a()
      {
        public final boolean c(long paramAnonymousLong, int paramAnonymousInt)
        {
          return paramAnonymousLong < paramAnonymousInt * 5;
        }
        
        public final void d(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
        {
          com.tencent.matrix.g.c.w("Matrix.StartupTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
          paramAnonymousList = paramAnonymousList.listIterator(Math.min(paramAnonymousInt, 30));
          while (paramAnonymousList.hasNext())
          {
            paramAnonymousList.next();
            paramAnonymousList.remove();
          }
        }
      });
    }
    Object localObject1 = new StringBuilder();
    Object localObject3 = new StringBuilder();
    long l1 = Math.max(this.cDW, com.tencent.matrix.trace.g.a.a((LinkedList)localObject2, (StringBuilder)localObject1, (StringBuilder)localObject3));
    localObject2 = com.tencent.matrix.trace.g.a.b((List)localObject2, l1);
    if (((this.cDW > e.a(this.cDX)) && (!this.cDM)) || ((this.cDW > e.b(this.cDX)) && (this.cDM))) {
      com.tencent.matrix.g.c.w("Matrix.StartupTracer", "stackKey:%s \n%s", new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
    }
    long l2 = this.cDV;
    long l3 = this.cDJ;
    boolean bool = this.cDM;
    int i = this.scene;
    localObject3 = (com.tencent.matrix.trace.a)b.GF().V(com.tencent.matrix.trace.a.class);
    if (localObject3 == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), b.GF().application);
        localJSONObject.put("application_create", l2);
        localJSONObject.put("application_create_scene", i);
        localJSONObject.put("first_activity_create", l3);
        localJSONObject.put("startup_duration", l1);
        localJSONObject.put("is_warm_start_up", bool);
        com.tencent.matrix.report.c localc = new com.tencent.matrix.report.c();
        localc.tag = "Trace_StartUp";
        localc.cwV = localJSONObject;
        ((com.tencent.matrix.trace.a)localObject3).onDetectIssue(localc);
        if (((l1 <= e.a(this.cDX)) || (bool)) && ((l1 <= e.b(this.cDX)) || (!bool))) {
          continue;
        }
        try
        {
          localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), b.GF().application);
          localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.cBK);
          localJSONObject.put("cost", l1);
          localJSONObject.put("stack", ((StringBuilder)localObject1).toString());
          localJSONObject.put("stackKey", localObject2);
          if (bool)
          {
            i = 2;
            localJSONObject.put("subType", i);
            localObject1 = new com.tencent.matrix.report.c();
            ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.c)localObject1).cwV = localJSONObject;
            ((com.tencent.matrix.trace.a)localObject3).onDetectIssue((com.tencent.matrix.report.c)localObject1);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          com.tencent.matrix.g.c.e("Matrix.StartupTracer", "[JSONException error: %s", new Object[] { localJSONException1 });
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          com.tencent.matrix.g.c.e("Matrix.StartupTracer", "[JSONException for StartUpReportTask error: %s", new Object[] { localJSONException2 });
          continue;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.f.e.a
 * JD-Core Version:    0.7.0.1
 */