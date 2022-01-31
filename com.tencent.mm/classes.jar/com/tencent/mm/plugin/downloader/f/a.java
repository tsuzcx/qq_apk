package com.tencent.mm.plugin.downloader.f;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final HashMap<Long, Integer> kZr;
  
  static
  {
    AppMethodBeat.i(141101);
    kZr = new HashMap();
    AppMethodBeat.o(141101);
  }
  
  public static void I(String paramString, long paramLong)
  {
    AppMethodBeat.i(141094);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(141094);
      return;
    }
    if ("appid_is_empty".equals(paramString))
    {
      h.qsU.idkeyStat(860L, paramLong, 1L, false);
      AppMethodBeat.o(141094);
      return;
    }
    com.tencent.mm.ch.a.post(new a.1(paramString, paramLong));
    AppMethodBeat.o(141094);
  }
  
  public static void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(141093);
    if (kZr.containsKey(Long.valueOf(paramb.cmm))) {
      paramInt = ((Integer)kZr.remove(Long.valueOf(paramb.cmm))).intValue();
    }
    ab.i("MicroMsg.FileDownloadReportUtil", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s, reservedInWifi = %d, startScene = %d, uiarea = %d, noticeId = %d, ssid = %d, downloadType = %d", new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.kZu), Long.valueOf(paramb.kYX), Long.valueOf(paramb.jyU), paramb.downloadUrl, Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.cvQ), paramb.channelId, Long.valueOf(paramb.iHc), Integer.valueOf(paramb.kZv), Long.valueOf(paramb.cmm), paramb.extInfo, Integer.valueOf(paramb.kZw), Integer.valueOf(paramb.kZx), Integer.valueOf(paramb.kZy), Integer.valueOf(paramb.kZz), Integer.valueOf(paramb.kZA), Integer.valueOf(paramb.kZB) });
    Object localObject = paramb.appId;
    int i = paramb.scene;
    long l1 = paramb.kYX;
    long l2 = paramb.jyU;
    String str1 = lR(paramb.downloadUrl);
    int j = getNetworkType(ah.getContext());
    int k = paramb.errCode;
    int m = paramb.cvQ;
    String str2 = paramb.channelId;
    long l3 = paramb.iHc;
    int n = paramb.kZv;
    long l4 = paramb.cmm;
    String str3 = paramb.extInfo;
    String str4 = getDeviceInfo();
    long l5 = paramb.kZu;
    int i1 = paramb.kZw;
    int i2 = paramb.kZx;
    int i3 = paramb.kZy;
    int i4 = paramb.kZz;
    int i5 = paramb.kZA;
    int i6 = paramb.kZB;
    ah.getContext();
    localObject = com.tencent.mm.game.report.api.b.b(14567, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2), str1, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str2, Long.valueOf(l3), Integer.valueOf(n), Long.valueOf(l4), str3, str4, Long.valueOf(l5), Integer.valueOf(i1), "", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(com.tencent.matrix.g.a.zD() / 1024L), Long.valueOf(bjx()), Long.valueOf(bjy()) });
    com.tencent.mm.game.report.api.a.ezM.a((com.tencent.mm.game.report.api.b)localObject);
    h.qsU.e(15015, new Object[] { paramb.appId, Integer.valueOf(paramb.scene), Integer.valueOf(paramInt), Long.valueOf(paramb.kYX), Long.valueOf(paramb.jyU), lR(paramb.downloadUrl), Integer.valueOf(getNetworkType(ah.getContext())), Integer.valueOf(paramb.errCode), Integer.valueOf(paramb.cvQ), paramb.channelId, Long.valueOf(paramb.iHc), Integer.valueOf(paramb.kZv), Long.valueOf(paramb.cmm), paramb.extInfo });
    AppMethodBeat.o(141093);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(141092);
    long l = System.currentTimeMillis();
    paramString1 = com.tencent.mm.game.report.api.b.b(10737, new Object[] { Long.valueOf(l), Long.valueOf(l), Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0), paramString2, "", paramString3, Integer.valueOf(getNetworkType(ah.getContext())), Integer.valueOf(0), Integer.valueOf(1), paramString4, paramString5 });
    com.tencent.mm.game.report.api.a.ezM.a(paramString1);
    AppMethodBeat.o(141092);
  }
  
  private static String bjw()
  {
    AppMethodBeat.i(141096);
    try
    {
      String str = bo.nullAsNil(BluetoothAdapter.getDefaultAdapter().getAddress());
      AppMethodBeat.o(141096);
      return str;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FileDownloadReportUtil", "getBlueToothAddress failed: %s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(141096);
    }
    return "";
  }
  
  private static long bjx()
  {
    AppMethodBeat.i(141099);
    try
    {
      long l = Environment.getExternalStorageDirectory().getFreeSpace() / 1048576L;
      AppMethodBeat.o(141099);
      return l;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(141099);
    }
    return 0L;
  }
  
  private static long bjy()
  {
    AppMethodBeat.i(141100);
    try
    {
      long l = Environment.getDataDirectory().getFreeSpace() / 1048576L;
      AppMethodBeat.o(141100);
      return l;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FileDownloadReportUtil", localException, "", new Object[0]);
      AppMethodBeat.o(141100);
    }
    return 0L;
  }
  
  private static String getDeviceInfo()
  {
    AppMethodBeat.i(141095);
    String str1 = q.LD();
    String str2 = bjw();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("IMEI", str1);
      ((JSONObject)localObject).put("BLUETOOTH_ADDRESS", str2);
      localObject = lR(((JSONObject)localObject).toString());
      AppMethodBeat.o(141095);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FileDownloadReportUtil", "getDeviceInfo: " + localJSONException.getMessage());
      }
    }
  }
  
  private static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(141098);
    if (at.is3G(paramContext))
    {
      AppMethodBeat.o(141098);
      return 4;
    }
    if (at.is4G(paramContext))
    {
      AppMethodBeat.o(141098);
      return 5;
    }
    switch (at.getNetType(paramContext))
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      AppMethodBeat.o(141098);
      return 6;
    case -1: 
      AppMethodBeat.o(141098);
      return 255;
    case 0: 
      AppMethodBeat.o(141098);
      return 1;
    case 5: 
      AppMethodBeat.o(141098);
      return 2;
    }
    AppMethodBeat.o(141098);
    return 3;
  }
  
  private static String lR(String paramString)
  {
    AppMethodBeat.i(141097);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(141097);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(141097);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "";
        ab.e("MicroMsg.FileDownloadReportUtil", localException.getMessage());
      }
    }
  }
  
  public static void o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(141091);
    kZr.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(141091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.f.a
 * JD-Core Version:    0.7.0.1
 */