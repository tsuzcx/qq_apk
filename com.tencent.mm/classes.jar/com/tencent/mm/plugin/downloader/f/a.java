package com.tencent.mm.plugin.downloader.f;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final HashMap<Long, Integer> ptV;
  
  static
  {
    AppMethodBeat.i(89084);
    ptV = new HashMap();
    AppMethodBeat.o(89084);
  }
  
  public static void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(89076);
    if (ptV.containsKey(Long.valueOf(paramb.dkO))) {
      paramInt = ((Integer)ptV.remove(Long.valueOf(paramb.dkO))).intValue();
    }
    ae.i("MicroMsg.FileDownloadReportUtil", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s, reservedInWifi = %d, startScene = %d, uiarea = %d, noticeId = %d, ssid = %d, downloadType = %d", new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.ptY), Long.valueOf(paramb.ptA), Long.valueOf(paramb.nyl), paramb.downloadUrl, Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.dvO), paramb.channelId, Long.valueOf(paramb.mxN), Integer.valueOf(paramb.ptZ), Long.valueOf(paramb.dkO), paramb.extInfo, Integer.valueOf(paramb.pua), Integer.valueOf(paramb.pub), Integer.valueOf(paramb.puc), Integer.valueOf(paramb.pud), Integer.valueOf(paramb.pue), Integer.valueOf(paramb.dQh) });
    Object localObject = paramb.appId;
    int i = paramb.scene;
    long l1 = paramb.ptA;
    long l2 = paramb.nyl;
    String str1 = wT(paramb.downloadUrl);
    int j = getNetworkType(ak.getContext());
    int k = paramb.errCode;
    int m = paramb.dvO;
    String str2 = paramb.channelId;
    long l3 = paramb.mxN;
    int n = paramb.ptZ;
    long l4 = paramb.dkO;
    String str3 = paramb.extInfo;
    String str4 = getDeviceInfo();
    long l5 = paramb.ptY;
    int i1 = paramb.pua;
    int i2 = paramb.pub;
    int i3 = paramb.puc;
    int i4 = paramb.pud;
    int i5 = paramb.pue;
    int i6 = paramb.dQh;
    ak.getContext();
    localObject = com.tencent.mm.game.report.api.b.c(14567, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2), str1, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str2, Long.valueOf(l3), Integer.valueOf(n), Long.valueOf(l4), str3, str4, Long.valueOf(l5), Integer.valueOf(i1), "", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(com.tencent.matrix.g.a.Jw() / 1024L), Long.valueOf(cdN()), Long.valueOf(cdO()) });
    com.tencent.mm.game.report.api.a.guC.a((com.tencent.mm.game.report.api.b)localObject);
    com.tencent.mm.plugin.report.service.g.yxI.f(15015, new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.ptA), Long.valueOf(paramb.nyl), wT(paramb.downloadUrl), Integer.valueOf(getNetworkType(ak.getContext())), Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.dvO), paramb.channelId, Long.valueOf(paramb.mxN), Integer.valueOf(paramb.ptZ), Long.valueOf(paramb.dkO), paramb.extInfo });
    AppMethodBeat.o(89076);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(89075);
    long l = System.currentTimeMillis();
    paramString1 = com.tencent.mm.game.report.api.b.c(10737, new Object[] { Long.valueOf(l), Long.valueOf(l), Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", paramString3, Integer.valueOf(getNetworkType(ak.getContext())), Integer.valueOf(0), Integer.valueOf(1), paramString4, paramString5 });
    com.tencent.mm.game.report.api.a.guC.a(paramString1);
    AppMethodBeat.o(89075);
  }
  
  public static void ab(String paramString, final long paramLong)
  {
    AppMethodBeat.i(89077);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(89077);
      return;
    }
    if ("appid_is_empty".equals(paramString))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(860L, paramLong, 1L, false);
      AppMethodBeat.o(89077);
      return;
    }
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89073);
        com.tencent.mm.pluginsdk.model.app.g localg = h.cC(this.val$appId, false);
        if ((localg != null) && (localg.Ee())) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(860L, paramLong, this.ptX, false);
        }
        AppMethodBeat.o(89073);
      }
    });
    AppMethodBeat.o(89077);
  }
  
  private static String cdM()
  {
    AppMethodBeat.i(89079);
    try
    {
      String str = bu.nullAsNil(BluetoothAdapter.getDefaultAdapter().getAddress());
      AppMethodBeat.o(89079);
      return str;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.FileDownloadReportUtil", "getBlueToothAddress failed: %s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(89079);
    }
    return "";
  }
  
  private static long cdN()
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
      ae.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(89082);
    }
    return 0L;
  }
  
  private static long cdO()
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
      ae.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(89083);
    }
    return 0L;
  }
  
  private static String getDeviceInfo()
  {
    AppMethodBeat.i(89078);
    String str1 = q.aaA();
    String str2 = cdM();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("IMEI", str1);
      ((JSONObject)localObject).put("BLUETOOTH_ADDRESS", str2);
      localObject = wT(((JSONObject)localObject).toString());
      AppMethodBeat.o(89078);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.FileDownloadReportUtil", "getDeviceInfo: " + localJSONException.getMessage());
      }
    }
  }
  
  private static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(89081);
    if (az.is3G(paramContext))
    {
      AppMethodBeat.o(89081);
      return 4;
    }
    if (az.is4G(paramContext))
    {
      AppMethodBeat.o(89081);
      return 5;
    }
    switch (az.getNetType(paramContext))
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
    ptV.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(89074);
  }
  
  private static String wT(String paramString)
  {
    AppMethodBeat.i(89080);
    if (bu.isNullOrNil(paramString))
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
        ae.e("MicroMsg.FileDownloadReportUtil", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.a
 * JD-Core Version:    0.7.0.1
 */