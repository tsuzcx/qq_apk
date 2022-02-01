package com.tencent.mm.plugin.downloader.f;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final HashMap<Long, Integer> ogh;
  
  static
  {
    AppMethodBeat.i(89084);
    ogh = new HashMap();
    AppMethodBeat.o(89084);
  }
  
  public static void T(String paramString, final long paramLong)
  {
    AppMethodBeat.i(89077);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89077);
      return;
    }
    if ("appid_is_empty".equals(paramString))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(860L, paramLong, 1L, false);
      AppMethodBeat.o(89077);
      return;
    }
    com.tencent.mm.cj.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89073);
        g localg = com.tencent.mm.pluginsdk.model.app.h.cn(this.val$appId, false);
        if ((localg != null) && (localg.CZ())) {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(860L, paramLong, this.ogj, false);
        }
        AppMethodBeat.o(89073);
      }
    });
    AppMethodBeat.o(89077);
  }
  
  public static void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(89076);
    if (ogh.containsKey(Long.valueOf(paramb.daY))) {
      paramInt = ((Integer)ogh.remove(Long.valueOf(paramb.daY))).intValue();
    }
    ad.i("MicroMsg.FileDownloadReportUtil", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s, reservedInWifi = %d, startScene = %d, uiarea = %d, noticeId = %d, ssid = %d, downloadType = %d", new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.ogk), Long.valueOf(paramb.ofL), Long.valueOf(paramb.mqq), paramb.downloadUrl, Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.dlp), paramb.channelId, Long.valueOf(paramb.lrf), Integer.valueOf(paramb.ogl), Long.valueOf(paramb.daY), paramb.extInfo, Integer.valueOf(paramb.ogm), Integer.valueOf(paramb.ogn), Integer.valueOf(paramb.ogo), Integer.valueOf(paramb.ogp), Integer.valueOf(paramb.ogq), Integer.valueOf(paramb.dES) });
    Object localObject = paramb.appId;
    int i = paramb.scene;
    long l1 = paramb.ofL;
    long l2 = paramb.mqq;
    String str1 = qh(paramb.downloadUrl);
    int j = getNetworkType(aj.getContext());
    int k = paramb.errCode;
    int m = paramb.dlp;
    String str2 = paramb.channelId;
    long l3 = paramb.lrf;
    int n = paramb.ogl;
    long l4 = paramb.daY;
    String str3 = paramb.extInfo;
    String str4 = getDeviceInfo();
    long l5 = paramb.ogk;
    int i1 = paramb.ogm;
    int i2 = paramb.ogn;
    int i3 = paramb.ogo;
    int i4 = paramb.ogp;
    int i5 = paramb.ogq;
    int i6 = paramb.dES;
    aj.getContext();
    localObject = com.tencent.mm.game.report.api.b.c(14567, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2), str1, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str2, Long.valueOf(l3), Integer.valueOf(n), Long.valueOf(l4), str3, str4, Long.valueOf(l5), Integer.valueOf(i1), "", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(com.tencent.matrix.g.a.Ik() / 1024L), Long.valueOf(bQE()), Long.valueOf(bQF()) });
    com.tencent.mm.game.report.api.a.fUK.a((com.tencent.mm.game.report.api.b)localObject);
    com.tencent.mm.plugin.report.service.h.vKh.f(15015, new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.ofL), Long.valueOf(paramb.mqq), qh(paramb.downloadUrl), Integer.valueOf(getNetworkType(aj.getContext())), Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.dlp), paramb.channelId, Long.valueOf(paramb.lrf), Integer.valueOf(paramb.ogl), Long.valueOf(paramb.daY), paramb.extInfo });
    AppMethodBeat.o(89076);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(89075);
    long l = System.currentTimeMillis();
    paramString1 = com.tencent.mm.game.report.api.b.c(10737, new Object[] { Long.valueOf(l), Long.valueOf(l), Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", paramString3, Integer.valueOf(getNetworkType(aj.getContext())), Integer.valueOf(0), Integer.valueOf(1), paramString4, paramString5 });
    com.tencent.mm.game.report.api.a.fUK.a(paramString1);
    AppMethodBeat.o(89075);
  }
  
  private static String bQD()
  {
    AppMethodBeat.i(89079);
    try
    {
      String str = bt.nullAsNil(BluetoothAdapter.getDefaultAdapter().getAddress());
      AppMethodBeat.o(89079);
      return str;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FileDownloadReportUtil", "getBlueToothAddress failed: %s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(89079);
    }
    return "";
  }
  
  private static long bQE()
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
      ad.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(89082);
    }
    return 0L;
  }
  
  private static long bQF()
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
      ad.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(89083);
    }
    return 0L;
  }
  
  private static String getDeviceInfo()
  {
    AppMethodBeat.i(89078);
    String str1 = q.WT();
    String str2 = bQD();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("IMEI", str1);
      ((JSONObject)localObject).put("BLUETOOTH_ADDRESS", str2);
      localObject = qh(((JSONObject)localObject).toString());
      AppMethodBeat.o(89078);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.FileDownloadReportUtil", "getDeviceInfo: " + localJSONException.getMessage());
      }
    }
  }
  
  private static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(89081);
    if (ay.is3G(paramContext))
    {
      AppMethodBeat.o(89081);
      return 4;
    }
    if (ay.is4G(paramContext))
    {
      AppMethodBeat.o(89081);
      return 5;
    }
    switch (ay.getNetType(paramContext))
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
  
  private static String qh(String paramString)
  {
    AppMethodBeat.i(89080);
    if (bt.isNullOrNil(paramString))
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
        ad.e("MicroMsg.FileDownloadReportUtil", localException.getMessage());
      }
    }
  }
  
  public static void r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(89074);
    ogh.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(89074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.a
 * JD-Core Version:    0.7.0.1
 */