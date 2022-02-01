package com.tencent.mm.plugin.downloader.f;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.pluginsdk.model.app.h;
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
  private static final HashMap<Long, Integer> pno;
  
  static
  {
    AppMethodBeat.i(89084);
    pno = new HashMap();
    AppMethodBeat.o(89084);
  }
  
  public static void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(89076);
    if (pno.containsKey(Long.valueOf(paramb.djM))) {
      paramInt = ((Integer)pno.remove(Long.valueOf(paramb.djM))).intValue();
    }
    ad.i("MicroMsg.FileDownloadReportUtil", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s, reservedInWifi = %d, startScene = %d, uiarea = %d, noticeId = %d, ssid = %d, downloadType = %d", new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.pnr), Long.valueOf(paramb.pmT), Long.valueOf(paramb.nsQ), paramb.downloadUrl, Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.duJ), paramb.channelId, Long.valueOf(paramb.msQ), Integer.valueOf(paramb.pns), Long.valueOf(paramb.djM), paramb.extInfo, Integer.valueOf(paramb.pnt), Integer.valueOf(paramb.pnu), Integer.valueOf(paramb.pnv), Integer.valueOf(paramb.pnw), Integer.valueOf(paramb.pnx), Integer.valueOf(paramb.dOR) });
    Object localObject = paramb.appId;
    int i = paramb.scene;
    long l1 = paramb.pmT;
    long l2 = paramb.nsQ;
    String str1 = wk(paramb.downloadUrl);
    int j = getNetworkType(aj.getContext());
    int k = paramb.errCode;
    int m = paramb.duJ;
    String str2 = paramb.channelId;
    long l3 = paramb.msQ;
    int n = paramb.pns;
    long l4 = paramb.djM;
    String str3 = paramb.extInfo;
    String str4 = getDeviceInfo();
    long l5 = paramb.pnr;
    int i1 = paramb.pnt;
    int i2 = paramb.pnu;
    int i3 = paramb.pnv;
    int i4 = paramb.pnw;
    int i5 = paramb.pnx;
    int i6 = paramb.dOR;
    aj.getContext();
    localObject = com.tencent.mm.game.report.api.b.c(14567, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2), str1, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str2, Long.valueOf(l3), Integer.valueOf(n), Long.valueOf(l4), str3, str4, Long.valueOf(l5), Integer.valueOf(i1), "", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(com.tencent.matrix.g.a.Jo() / 1024L), Long.valueOf(ccy()), Long.valueOf(ccz()) });
    com.tencent.mm.game.report.api.a.gsb.a((com.tencent.mm.game.report.api.b)localObject);
    com.tencent.mm.plugin.report.service.g.yhR.f(15015, new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.pmT), Long.valueOf(paramb.nsQ), wk(paramb.downloadUrl), Integer.valueOf(getNetworkType(aj.getContext())), Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.duJ), paramb.channelId, Long.valueOf(paramb.msQ), Integer.valueOf(paramb.pns), Long.valueOf(paramb.djM), paramb.extInfo });
    AppMethodBeat.o(89076);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(89075);
    long l = System.currentTimeMillis();
    paramString1 = com.tencent.mm.game.report.api.b.c(10737, new Object[] { Long.valueOf(l), Long.valueOf(l), Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", paramString3, Integer.valueOf(getNetworkType(aj.getContext())), Integer.valueOf(0), Integer.valueOf(1), paramString4, paramString5 });
    com.tencent.mm.game.report.api.a.gsb.a(paramString1);
    AppMethodBeat.o(89075);
  }
  
  public static void ab(String paramString, final long paramLong)
  {
    AppMethodBeat.i(89077);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89077);
      return;
    }
    if ("appid_is_empty".equals(paramString))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(860L, paramLong, 1L, false);
      AppMethodBeat.o(89077);
      return;
    }
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89073);
        com.tencent.mm.pluginsdk.model.app.g localg = h.cy(this.val$appId, false);
        if ((localg != null) && (localg.Eb())) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(860L, paramLong, this.pnq, false);
        }
        AppMethodBeat.o(89073);
      }
    });
    AppMethodBeat.o(89077);
  }
  
  private static String ccx()
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
      ad.e("MicroMsg.FileDownloadReportUtil", "getBlueToothAddress failed: %s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(89079);
    }
    return "";
  }
  
  private static long ccy()
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
  
  private static long ccz()
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
    String str1 = q.aar();
    String str2 = ccx();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("IMEI", str1);
      ((JSONObject)localObject).put("BLUETOOTH_ADDRESS", str2);
      localObject = wk(((JSONObject)localObject).toString());
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
  
  public static void s(long paramLong, int paramInt)
  {
    AppMethodBeat.i(89074);
    pno.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(89074);
  }
  
  private static String wk(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.a
 * JD-Core Version:    0.7.0.1
 */