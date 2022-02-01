package com.tencent.matrix.c;

import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.h;
import com.tencent.matrix.a.a.a.m.a.a;
import com.tencent.matrix.a.b.l;
import com.tencent.matrix.a.b.l.d;
import com.tencent.matrix.a.b.o.a;
import com.tencent.matrix.a.b.o.c;
import com.tencent.matrix.a.b.o.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.k;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends com.tencent.matrix.a.a.a.b
{
  private com.tencent.matrix.report.d eWp;
  private a eWy;
  
  public final void P(String paramString, int paramInt)
  {
    super.P(paramString, paramInt);
  }
  
  public final void Q(String paramString, int paramInt)
  {
    super.Q(paramString, paramInt);
  }
  
  public final void a(int paramInt, String paramString, long paramLong)
  {
    if (a.aym()) {
      Log.i("Matrix.battery.ThreadPoolJiffies", "#onStatTask, tid = " + paramInt + ", stamp = " + paramLong + ", key = " + paramString);
    }
    super.a(paramInt, paramString, paramLong);
  }
  
  public final void awI()
  {
    super.awI();
    com.tencent.threadpool.c.b.ahBl = new i.a.1(this.eWy);
  }
  
  public final void awJ()
  {
    super.awJ();
    com.tencent.threadpool.c.b.ahBl = this.eWy.eWD;
  }
  
  public final int awQ()
  {
    return 0;
  }
  
  public final boolean b(m.a.a<b.a> parama)
  {
    if (a.aym()) {
      return true;
    }
    return super.b(parama);
  }
  
  public final void be(List<m.a.a<b.a>> paramList)
  {
    if (this.eWp != null) {
      this.eWp.be(paramList);
    }
  }
  
  public final void c(final m.a.a<b.a> parama)
  {
    super.c(parama);
    if ((a.ayo()) && (parama.isValid()) && (parama.eSi > a.ayd()))
    {
      Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug for updateDeltas, task name = " + ((b.a)parama.eSh).name);
      new Runnable()
      {
        public final void run()
        {
          if (i.a(i.this) != null) {
            try
            {
              i.b(i.this);
              int i = com.tencent.matrix.a.b.b.bW(com.tencent.matrix.a.a.d.getContext());
              long l1 = parama.eSi;
              long l2 = ((b.a)parama.eSg).time;
              Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug devStat, currStat = " + i + ", window= " + l1 + ", currMillis = " + l2);
              Object localObject = i.c(i.this).axf();
              JSONArray localJSONArray = new JSONArray();
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                o.a locala = (o.a)((Iterator)localObject).next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("key", locala.key);
                localJSONObject.put("upTime", locala.eRP);
                localJSONObject.put("statMillis", DateFormat.format("HH:mm:ss", locala.eUs));
                localJSONArray.put(localJSONObject);
                continue;
                return;
              }
            }
            catch (JSONException localJSONException)
            {
              Log.printErrStackTrace("Matrix.battery.ThreadPoolJiffies", localJSONException, "dump devStat stamps error", new Object[0]);
            }
          }
          Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug, stampList = \n\t".concat(String.valueOf(localJSONException.toString(2))));
          Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug result, stat = " + ((b.a)parama.eSh).eQe + ", chargeRatio = " + ((b.a)parama.eSh).eQg);
        }
      };
      a.ayr();
    }
  }
  
  public final void g(com.tencent.matrix.a.a.d paramd)
  {
    super.g(paramd);
    this.ePX = a.ayh();
    this.eWy = new a(com.tencent.threadpool.c.b.ahBl, (byte)0);
    paramd = paramd.ePD.ePb;
    if ((paramd instanceof com.tencent.matrix.report.d)) {
      this.eWp = ((com.tencent.matrix.report.d)paramd);
    }
  }
  
  public final o.c h(final int paramInt, final long paramLong1, long paramLong2)
  {
    o.c localc = super.h(paramInt, paramLong1, paramLong2);
    if ((a.ayo()) && (localc.eSe) && (localc.eUw.size() > 0) && (!"thread_pool@idle".equals(localc.axE().key)) && (localc.axE().ratio > 10))
    {
      Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug for getTaskPortions, tid = ".concat(String.valueOf(paramInt)));
      new Runnable()
      {
        public final void run()
        {
          Long localLong;
          for (;;)
          {
            try
            {
              long l1 = paramLong1;
              long l2 = paramInt;
              Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug taskStat, currStat = " + "thread_pool@idle" + ", window= " + l1 + ", currMillis = " + l2);
              Object localObject1;
              Object localObject2;
              if (!a.ayf())
              {
                localObject1 = l.dm(Process.myPid(), this.eWA);
                localObject2 = new StringBuilder("#dumpForDebug currJiffies, expected = ").append(paramInt).append(", actual = ");
                if (localObject1 == null)
                {
                  localObject1 = "null";
                  Log.i("Matrix.battery.ThreadPoolJiffies", localObject1);
                }
              }
              else
              {
                localObject2 = i.this.mT(this.eWA);
                localObject1 = new JSONArray();
                localObject2 = ((List)localObject2).iterator();
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                o.a locala = (o.a)((Iterator)localObject2).next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("key", locala.key);
                localJSONObject.put("upTime", locala.eRP);
                localJSONObject.put("statMillis", DateFormat.format("HH:mm:ss", locala.eUs));
                ((JSONArray)localObject1).put(localJSONObject);
                continue;
              }
              localLong = Long.valueOf(localJSONException.axC());
            }
            catch (JSONException localJSONException)
            {
              Log.printErrStackTrace("Matrix.battery.ThreadPoolJiffies", localJSONException, "dump task stamps error", new Object[0]);
              return;
            }
          }
          Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug, stampList = \n\t".concat(String.valueOf(localLong.toString(2))));
          Log.i("Matrix.battery.ThreadPoolJiffies", "#dumpForDebug result, valid = " + this.eWB.eSe + ", result = " + this.eWB.eUw);
        }
      };
      a.ayr();
    }
    return localc;
  }
  
  public final void mU(int paramInt) {}
  
  final class a
  {
    final com.tencent.threadpool.b.c eWD;
    
    private a(com.tencent.threadpool.b.c paramc)
    {
      this.eWD = paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.i
 * JD-Core Version:    0.7.0.1
 */