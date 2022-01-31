package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.g.c;
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
  private AppMethodBeat.a bRV;
  private long[] bRW = new long[3];
  private long bRX;
  private boolean bRY;
  final com.tencent.matrix.trace.a.a bRa;
  
  public b(com.tencent.matrix.trace.a.a parama)
  {
    this.bRa = parama;
    if (parama.bNO == null) {}
    for (;;)
    {
      this.bRX = i;
      this.bRY = parama.bQU;
      return;
      i = parama.bNO.get(com.tencent.mrs.b.a.a.Bap.name(), 700);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.bRa.bQX) {}
    for (l = System.currentTimeMillis();; l = 0L) {
      try
      {
        if (paramLong3 - paramLong1 >= this.bRX)
        {
          long[] arrayOfLong1 = AppMethodBeat.getInstance().copyData(this.bRV);
          long[] arrayOfLong2 = new long[3];
          System.arraycopy(this.bRW, 0, arrayOfLong2, 0, 3);
          String str = AppMethodBeat.getVisibleScene();
          com.tencent.matrix.g.b.zJ().post(new a(com.tencent.matrix.a.bLP.bLR, str, arrayOfLong1, arrayOfLong2, paramLong4 - paramLong2, paramLong3 - paramLong1, paramLong3));
        }
        return;
      }
      finally
      {
        this.bRV.release();
        if (!this.bRa.bQX) {
          break;
        }
        c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong3 - paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.r(paramLong4 - paramLong2, paramLong3 - paramLong1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.bRW[0] = paramLong2;
    this.bRW[1] = paramLong3;
    this.bRW[2] = paramLong4;
  }
  
  public final void c(long paramLong1, long paramLong2, long paramLong3)
  {
    super.c(paramLong1, paramLong2, paramLong3);
    this.bRV = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
  }
  
  public final void zy()
  {
    super.zy();
    if (this.bRY) {
      com.tencent.matrix.trace.core.b.zt().a(this);
    }
  }
  
  public final void zz()
  {
    super.zz();
    if (this.bRY) {
      com.tencent.matrix.trace.core.b.zt().b(this);
    }
  }
  
  final class a
    implements Runnable
  {
    long[] bRA;
    long[] bRZ;
    long bSa;
    long bSb;
    long bSc;
    String bSd;
    boolean bSe;
    
    a(boolean paramBoolean, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2, long paramLong3)
    {
      this.bSe = paramBoolean;
      this.bSd = paramString;
      this.bSb = paramLong2;
      this.bSa = paramLong1;
      this.bRZ = paramArrayOfLong1;
      this.bRA = paramArrayOfLong2;
      this.bSc = paramLong3;
    }
    
    public final void run()
    {
      Object localObject2 = com.tencent.matrix.trace.g.b.fS(Process.myPid());
      Object localObject1 = com.tencent.matrix.trace.g.b.r(this.bSa, this.bSb);
      Object localObject4 = new LinkedList();
      if (this.bRZ.length > 0)
      {
        com.tencent.matrix.trace.g.a.a(this.bRZ, (LinkedList)localObject4, true, this.bSc);
        com.tencent.matrix.trace.g.a.a((List)localObject4, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean c(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void e(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
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
      long l1 = Math.max(this.bSb, com.tencent.matrix.trace.g.a.a((LinkedList)localObject4, localStringBuilder, (StringBuilder)localObject3));
      String str = com.tencent.matrix.trace.g.a.a((List)localObject4, l1);
      boolean bool = this.bSe;
      long l2 = ((LinkedList)localObject4).size();
      long l3 = this.bRA[0];
      long l4 = this.bRA[1];
      long l5 = this.bRA[2];
      long l6 = this.bSb;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(String.format("-\n>>>>>>>>>>>>>>>>>>>>> maybe happens Jankiness!(%sms) <<<<<<<<<<<<<<<<<<<<<\n", new Object[] { Long.valueOf(l6) }));
      ((StringBuilder)localObject4).append("|* [ProcessStat]\n");
      ((StringBuilder)localObject4).append("|*\t\tPriority: ").append(localObject2[0]).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tNice: ").append(localObject2[1]).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tForeground: ").append(bool).append("\n");
      ((StringBuilder)localObject4).append("|* [CPU]\n");
      ((StringBuilder)localObject4).append("|*\t\tusage: ").append((String)localObject1).append("\n");
      ((StringBuilder)localObject4).append("|* [Memory]\n");
      ((StringBuilder)localObject4).append("|* [doFrame]\n");
      ((StringBuilder)localObject4).append("|*\t\tinputCost: ").append(l3).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tanimationCost: ").append(l4).append("\n");
      ((StringBuilder)localObject4).append("|*\t\ttraversalCost: ").append(l5).append("\n");
      ((StringBuilder)localObject4).append("|* [Trace]\n");
      ((StringBuilder)localObject4).append("|*\t\tStackSize: ").append(l2).append("\n");
      ((StringBuilder)localObject4).append("|*\t\tStackKey: ").append(str).append("\n");
      if (b.this.bRa.isDebug) {
        ((StringBuilder)localObject4).append(((StringBuilder)localObject3).toString());
      }
      ((StringBuilder)localObject4).append("=========================================================================");
      c.w("Matrix.EvilMethodTracer", "%s", new Object[] { ((StringBuilder)localObject4).toString() });
      if ((l1 >= 5500L) || (localObject2[0] > 10)) {
        c.w("Matrix.EvilMethodTracer", "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
      }
      for (;;)
      {
        return;
        try
        {
          localObject2 = (com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
          if (localObject2 != null)
          {
            localObject3 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.yD().application);
            ((JSONObject)localObject3).put("detail", com.tencent.matrix.trace.b.a.a.bRb);
            ((JSONObject)localObject3).put("cost", l1);
            ((JSONObject)localObject3).put("usage", localObject1);
            ((JSONObject)localObject3).put("scene", this.bSd);
            ((JSONObject)localObject3).put("stack", localStringBuilder.toString());
            ((JSONObject)localObject3).put("stackKey", str);
            localObject1 = new com.tencent.matrix.e.b();
            ((com.tencent.matrix.e.b)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.e.b)localObject1).bOx = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.b)localObject2).onDetectIssue((com.tencent.matrix.e.b)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.f.b
 * JD-Core Version:    0.7.0.1
 */