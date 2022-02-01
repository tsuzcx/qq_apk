package com.tencent.mm.plugin.downloader.e;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final HashMap<Long, Integer> xoI;
  
  static
  {
    AppMethodBeat.i(89084);
    xoI = new HashMap();
    AppMethodBeat.o(89084);
  }
  
  public static void A(long paramLong, int paramInt)
  {
    AppMethodBeat.i(89074);
    xoI.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(89074);
  }
  
  private static String EM(String paramString)
  {
    AppMethodBeat.i(89080);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89080);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(89080);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "";
        Log.e("MicroMsg.FileDownloadReportUtil", localException.getMessage());
      }
    }
  }
  
  public static void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(89076);
    if (xoI.containsKey(Long.valueOf(paramb.hyV))) {
      paramInt = ((Integer)xoI.remove(Long.valueOf(paramb.hyV))).intValue();
    }
    Log.i("MicroMsg.FileDownloadReportUtil", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s, reservedInWifi = %d, startScene = %d, uiarea = %d, noticeId = %d, ssid = %d, downloadType = %d", new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.xoL), Long.valueOf(paramb.xom), Long.valueOf(paramb.uWn), paramb.downloadUrl, Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.hMd), paramb.channelId, Long.valueOf(paramb.costTime), Integer.valueOf(paramb.xoM), Long.valueOf(paramb.hyV), paramb.extInfo, Integer.valueOf(paramb.xoN), Integer.valueOf(paramb.xoO), Integer.valueOf(paramb.xoP), Integer.valueOf(paramb.xoQ), Integer.valueOf(paramb.xoR), Integer.valueOf(paramb.iiN) });
    Object localObject = paramb.appId;
    int i = paramb.scene;
    long l1 = paramb.xom;
    long l2 = paramb.uWn;
    String str1 = EM(paramb.downloadUrl);
    int j = dt(MMApplicationContext.getContext());
    int k = paramb.errCode;
    int m = paramb.hMd;
    String str2 = paramb.channelId;
    long l3 = paramb.costTime;
    int n = paramb.xoM;
    long l4 = paramb.hyV;
    String str3 = paramb.extInfo;
    String str4 = getDeviceInfo();
    long l5 = paramb.xoL;
    int i1 = paramb.xoN;
    int i2 = paramb.xoO;
    int i3 = paramb.xoP;
    int i4 = paramb.xoQ;
    int i5 = paramb.xoR;
    int i6 = paramb.iiN;
    MMApplicationContext.getContext();
    localObject = com.tencent.mm.game.report.api.b.e(14567, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2), str1, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str2, Long.valueOf(l3), Integer.valueOf(n), Long.valueOf(l4), str3, str4, Long.valueOf(l5), Integer.valueOf(i1), "", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(com.tencent.matrix.e.a.aAj() / 1024L), Long.valueOf(duG()), Long.valueOf(duH()) });
    com.tencent.mm.game.report.api.a.mtH.a((com.tencent.mm.game.report.api.b)localObject);
    com.tencent.mm.plugin.report.service.h.OAn.b(15015, new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.xom), Long.valueOf(paramb.uWn), EM(paramb.downloadUrl), Integer.valueOf(dt(MMApplicationContext.getContext())), Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.hMd), paramb.channelId, Long.valueOf(paramb.costTime), Integer.valueOf(paramb.xoM), Long.valueOf(paramb.hyV), paramb.extInfo });
    AppMethodBeat.o(89076);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(89075);
    long l = System.currentTimeMillis();
    paramString1 = com.tencent.mm.game.report.api.b.e(10737, new Object[] { Long.valueOf(l), Long.valueOf(l), Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", paramString3, Integer.valueOf(dt(MMApplicationContext.getContext())), Integer.valueOf(0), Integer.valueOf(1), paramString4, paramString5 });
    com.tencent.mm.game.report.api.a.mtH.a(paramString1);
    AppMethodBeat.o(89075);
  }
  
  public static void af(String paramString, final long paramLong)
  {
    AppMethodBeat.i(89077);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89077);
      return;
    }
    if ("appid_is_empty".equals(paramString))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(860L, paramLong, 1L, false);
      AppMethodBeat.o(89077);
      return;
    }
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89073);
        g localg = com.tencent.mm.pluginsdk.model.app.h.dV(a.this, false);
        if ((localg != null) && (localg.aqJ())) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(860L, paramLong, this.xoK, false);
        }
        AppMethodBeat.o(89073);
      }
    });
    AppMethodBeat.o(89077);
  }
  
  private static int dt(Context paramContext)
  {
    AppMethodBeat.i(89081);
    if (NetStatusUtil.is3G(paramContext))
    {
      AppMethodBeat.o(89081);
      return 4;
    }
    if (NetStatusUtil.is4G(paramContext))
    {
      AppMethodBeat.o(89081);
      return 5;
    }
    switch (NetStatusUtil.getNetType(paramContext))
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      AppMethodBeat.o(89081);
      return 6;
    case -1: 
      AppMethodBeat.o(89081);
      return 255;
    case 0: 
      AppMethodBeat.o(89081);
      return 1;
    case 5: 
      AppMethodBeat.o(89081);
      return 2;
    }
    AppMethodBeat.o(89081);
    return 3;
  }
  
  private static long duG()
  {
    AppMethodBeat.i(89082);
    try
    {
      long l = Environment.getExternalStorageDirectory().getFreeSpace() / 1048576L;
      AppMethodBeat.o(89082);
      return l;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(89082);
    }
    return 0L;
  }
  
  private static long duH()
  {
    AppMethodBeat.i(89083);
    try
    {
      long l = Environment.getDataDirectory().getFreeSpace() / 1048576L;
      AppMethodBeat.o(89083);
      return l;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(89083);
    }
    return 0L;
  }
  
  private static String getDeviceInfo()
  {
    AppMethodBeat.i(89078);
    String str = q.aOY();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("IMEI", str);
      localObject = EM(((JSONObject)localObject).toString());
      AppMethodBeat.o(89078);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FileDownloadReportUtil", "getDeviceInfo: " + localJSONException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.a
 * JD-Core Version:    0.7.0.1
 */