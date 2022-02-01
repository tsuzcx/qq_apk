package com.tencent.matrix.report;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.f.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements k.d
{
  private static long cZH;
  
  static
  {
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        b.bq(Process.myTid());
      }
    });
  }
  
  public final void a(k.b paramb)
  {
    Object localObject2 = paramb.tag;
    Object localObject1 = paramb.key;
    final JSONObject localJSONObject1 = paramb.cZZ;
    long l5 = SystemClock.uptimeMillis();
    if (((String)localObject2).equals("Trace")) {}
    long l1;
    long l6;
    long l2;
    int j;
    int i;
    label390:
    int m;
    long l3;
    long l4;
    int k;
    try
    {
      if ((!paramb.tag.equalsIgnoreCase("Trace_EvilMethod")) || (!localJSONObject1.getString("detail").equalsIgnoreCase(a.a.deX.toString()))) {
        break label616;
      }
      paramb = localJSONObject1.getString("cost");
      l1 = Util.safeParseLong((String)localObject1);
      l6 = Util.safeParseLong(paramb);
      if (!com.tencent.mm.kernel.h.aHB()) {
        break label616;
      }
      paramb = com.tencent.mm.kernel.h.aHG().kcF;
      if ((paramb == null) || (paramb.hBY() == null)) {
        break label735;
      }
      paramb.hBY();
      localObject2 = com.tencent.mm.storagebase.f.hBR();
      long l7 = ((f.a)localObject2).time;
      Log.i("MicroMsg.AnrReportListener", "[happen] threadStatus:%s sql:%s time:%s db:%s", new Object[] { Integer.valueOf(((f.a)localObject2).status), ((f.a)localObject2).sql, Long.valueOf(l7), ((f.a)localObject2).GSi });
      if (((f.a)localObject2).GSi == null) {
        break label697;
      }
      l2 = SystemClock.uptimeMillis();
      l8 = System.currentTimeMillis() - l6 - (l2 - (l1 + l6));
      j = 0;
      l2 = 0L;
      l1 = 0L;
      localObject1 = new JSONObject();
      paramb = ((f.a)localObject2).GSi.dumpJSON(false);
      Log.i("MicroMsg.AnrReportListener", "[happen] db raw json:%s", new Object[] { paramb });
      JSONArray localJSONArray1 = paramb.getJSONArray("availableNonPrimary");
      i = 0;
      if (i >= localJSONArray1.length()) {
        break label779;
      }
      localJSONObject2 = localJSONArray1.getJSONObject(i);
      localJSONArray2 = localJSONObject2.getJSONArray("operations");
      localJSONArray3 = new JSONArray();
      localJSONObject2.put("operations", localJSONArray3);
      if ((i != 0) || (((f.a)localObject2).status != 3)) {
        break label746;
      }
      localJSONObject2 = new JSONObject();
      localJSONArray2.put(localJSONObject2);
      localJSONObject2.put("start", l7);
      localJSONObject2.put("duration", Math.min(l6, l8 + l6 - l7));
      localJSONObject2.put("tid", cZH);
      Log.i("MicroMsg.AnrReportListener", "[happen] add executing:%s", new Object[] { localJSONObject2 });
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        long l8;
        JSONObject localJSONObject2;
        JSONArray localJSONArray2;
        JSONArray localJSONArray3;
        long l11;
        long l9;
        long l10;
        label524:
        label578:
        label597:
        label616:
        Log.printErrStackTrace("MicroMsg.AnrReportListener", paramb, "", new Object[0]);
        return;
        label697:
        Log.i("MicroMsg.AnrReportListener", "has't any db operation in time!");
      }
    }
    finally
    {
      Log.i("MicroMsg.AnrReportListener", "[report] cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l5) });
    }
    if (m < localJSONArray2.length())
    {
      localJSONObject2 = localJSONArray2.getJSONObject(m);
      l11 = localJSONObject2.getLong("start");
      l9 = localJSONObject2.getLong("duration");
      l10 = localJSONObject2.getLong("tid");
      l3 = l1;
      l4 = l2;
      k = j;
      if (l8 <= l11)
      {
        j += 1;
        l1 += l9;
        if ((float)l9 >= (float)l6 * 0.1F) {
          localJSONArray3.put(localJSONObject2);
        }
        l3 = l1;
        l4 = l2;
        k = j;
        if (cZH == l10)
        {
          l4 = l2 + l9;
          l3 = l1;
          k = j;
        }
      }
    }
    for (;;)
    {
      ((JSONObject)localObject1).put("isDbBusy", bool);
      localJSONObject1.put("isDbBusy", bool);
      ((JSONObject)localObject1).put("execSqlCount", j);
      ((JSONObject)localObject1).put("mainThreadAllSqlCost", l2);
      ((JSONObject)localObject1).put("allSqlCost", l1);
      if (bool)
      {
        ((JSONObject)localObject1).put("detail", paramb);
        localJSONObject1.put("dbInfo", localObject1);
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            Log.i("MicroMsg.AnrReportListener", "[happen] %s", new Object[] { localJSONObject1.toString() });
          }
        });
        Log.i("MicroMsg.AnrReportListener", "[report] cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l5) });
        return;
      }
      label735:
      label746:
      do
      {
        bool = false;
        break label524;
        paramb = new JSONObject();
        break label578;
        Log.w("MicroMsg.AnrReportListener", "sqliteDB is null!");
        break label597;
        m = 0;
        break label390;
        m += 1;
        l1 = l3;
        l2 = l4;
        j = k;
        break label390;
        i += 1;
        break;
      } while ((float)l2 < (float)l6 * 0.5F);
      label779:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.b
 * JD-Core Version:    0.7.0.1
 */