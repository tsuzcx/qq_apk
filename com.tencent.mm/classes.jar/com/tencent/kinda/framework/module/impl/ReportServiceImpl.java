package com.tencent.kinda.framework.module.impl;

import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.kinda.gen.KReportService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ReportServiceImpl
  implements KReportService
{
  private static final String ACF_REPORT_KEY = "acfReport_";
  private static final String LAST_REPORT_SESSION_KEY = "lastReportSession";
  private static final String TAG = "MicroMsg.ReportServiceImpl";
  
  public String getLastSessionInfo()
  {
    AppMethodBeat.i(226661);
    String str = com.tencent.mm.wallet_core.ui.i.jPw().getString("lastReportSession", "");
    AppMethodBeat.o(226661);
    return str;
  }
  
  public void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(18677);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    AppMethodBeat.o(18677);
  }
  
  public void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(18678);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(paramInt, paramString);
    AppMethodBeat.o(18678);
  }
  
  public void setLastSessionInfo(final String paramString)
  {
    AppMethodBeat.i(226660);
    com.tencent.mm.wallet_core.ui.i.jPw().edit().putString("lastReportSession", paramString).apply();
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226658);
        Object localObject1 = new StringBuilder("acfReport_");
        com.tencent.mm.kernel.h.baC();
        String str2 = b.aZs();
        String str1;
        Object localObject4;
        if (!Util.isNullOrNil(paramString))
        {
          localObject1 = com.tencent.mm.wallet_core.ui.i.jPw().getString(str2, "");
          if (Util.isNullOrNil((String)localObject1)) {
            localObject1 = "{}";
          }
          Object localObject6;
          String str3;
          try
          {
            String str4;
            for (;;)
            {
              localObject6 = new JSONObject(paramString);
              str1 = ((JSONObject)localObject6).optString("sessionId");
              localObject4 = ((JSONObject)localObject6).optString("lastReportUrl");
              localObject5 = ((JSONObject)localObject6).optString("logType");
              str4 = ((JSONObject)localObject6).optString("logAction");
              if ((!((String)localObject4).equals("NetworkChange")) && (!((String)localObject4).equals("MemoryWarning"))) {
                break;
              }
              Log.d("MicroMsg.ReportServiceImpl", "ignore unused action: %s", new Object[] { localObject4 });
              AppMethodBeat.o(226658);
              return;
              localObject1 = new String(Base64.decode((String)localObject1, 2));
            }
            localObject1 = new JSONObject((String)localObject1);
            localObject6 = ((JSONObject)localObject1).optString("sessionId");
            str3 = ((JSONObject)localObject1).optString("acf");
            localObject4 = String.format("%s(%s:%s)", new Object[] { localObject4, localObject5, str4 });
            Object localObject5 = str3.split("-");
            int i = localObject5.length;
            if ((i >= 2) && (localObject5[(i - 1)].equals(localObject4)) && (localObject5[(i - 2)].equals(localObject4)))
            {
              Log.w("MicroMsg.ReportServiceImpl", "skip duplicate action node: %s", new Object[] { localObject4 });
              AppMethodBeat.o(226658);
              return;
            }
            if (Util.isNullOrNil((String)localObject6))
            {
              ((JSONObject)localObject1).put("sessionId", str1);
              ((JSONObject)localObject1).put("acf", localObject4);
              Log.d("MicroMsg.ReportServiceImpl", "new acf: %s", new Object[] { ((JSONObject)localObject1).toString() });
              localObject1 = Base64.encodeToString(((JSONObject)localObject1).toString().getBytes(), 2);
              com.tencent.mm.wallet_core.ui.i.jPw().putString(str2, (String)localObject1);
              AppMethodBeat.o(226658);
              return;
            }
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.ReportServiceImpl", localException1, "", new Object[0]);
            AppMethodBeat.o(226658);
            return;
          }
          if (((String)localObject6).equals(str1))
          {
            localException1.put("acf", str3 + "-" + (String)localObject4);
            Log.d("MicroMsg.ReportServiceImpl", "append acf: %s", new Object[] { localException1.toString() });
            localObject2 = Base64.encodeToString(localException1.toString().getBytes(), 2);
            com.tencent.mm.wallet_core.ui.i.jPw().putString(str2, (String)localObject2);
            AppMethodBeat.o(226658);
            return;
          }
          Log.e("MicroMsg.ReportServiceImpl", "bad case: %s", new Object[] { str1 });
          com.tencent.mm.plugin.report.service.h.OAn.b(24087, new Object[] { str3, localObject6 });
          ((JSONObject)localObject2).put("sessionId", str1);
          ((JSONObject)localObject2).put("acf", localObject4);
          Log.d("MicroMsg.ReportServiceImpl", "new acf: %s", new Object[] { ((JSONObject)localObject2).toString() });
          localObject2 = Base64.encodeToString(((JSONObject)localObject2).toString().getBytes(), 2);
          com.tencent.mm.wallet_core.ui.i.jPw().putString(str2, (String)localObject2);
          AppMethodBeat.o(226658);
          return;
        }
        Object localObject2 = com.tencent.mm.wallet_core.ui.i.jPw().getString(str2, "");
        if (!Util.isNullOrNil((String)localObject2)) {
          try
          {
            localObject4 = new JSONObject(new String(Base64.decode((String)localObject2, 2)));
            str1 = ((JSONObject)localObject4).optString("acf");
            localObject2 = str1;
            if (str1.length() > 7000)
            {
              Log.w("MicroMsg.ReportServiceImpl", "over length: %s", new Object[] { Integer.valueOf(str1.length()) });
              localObject2 = str1.substring(0, 7000);
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(24087, new Object[] { localObject2, ((JSONObject)localObject4).optString("sessionId") });
            return;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.ReportServiceImpl", localException2, "", new Object[0]);
            return;
          }
          finally
          {
            com.tencent.mm.wallet_core.ui.i.jPw().remove(str2);
            AppMethodBeat.o(226658);
          }
        }
        AppMethodBeat.o(226658);
      }
    }, "wcpay_acf_report");
    AppMethodBeat.o(226660);
  }
  
  public long svrTimeMs()
  {
    AppMethodBeat.i(18679);
    long l = cn.bDu();
    AppMethodBeat.o(18679);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */