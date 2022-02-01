package com.tencent.mm.plugin.appbrand.ag.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h;
import com.tencent.mm.g.h.a;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/AppBrandCdnService;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mars/cdn/CdnLogic$VideoStreamingCallback;", "Lcom/tencent/mars/cdn/CdnLogic$AppCallback;", "()V", "RSAPUBKEY_E", "", "RSAPUBKEY_N", "RSA_VERSION", "TAG", "USERKEY", "tasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "addDownloadTask", "", "task", "cancelDownloadTask", "mediaId", "onBadNetworkProbed", "", "onC2CDownloadCompleted", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDataAvailable", "offset", "", "length", "onDownloadProgressChanged", "total", "tryShow", "", "onDownloadToEnd", "onM3U8Ready", "m3u8", "onMoovReadyWithFlag", "svrflag", "onPreloadCompletedWithResult", "reportFlow", "wifiRecv", "wifiSend", "mobileRecv", "mobileSend", "requestGetCDN", "reason", "requestVideoData", "durationMs", "resolveHost", "", "host", "isDcip", "dnsType", "", "(Ljava/lang/String;Z[I)[Ljava/lang/String;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.VideoStreamingCallback
{
  public static final a utk;
  static final ConcurrentHashMap<String, h> utl;
  
  static
  {
    AppMethodBeat.i(317907);
    utk = new a();
    utl = new ConcurrentHashMap();
    String str = y.n(com.tencent.mm.vfs.ah.v(new u(b.bmz(), "ThumbVideoCache/CdnDownload/History").jKT()), true);
    Log.i("MicroMsg.AppBrandCdnService", s.X("<init>, historyPath: ", str));
    CdnLogic.Initialize(str, (CdnLogic.AppCallback)utk, "1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001", "cdnwx2013usrname");
    AppMethodBeat.o(317907);
  }
  
  public static int agO(String paramString)
  {
    AppMethodBeat.i(317892);
    s.u(paramString, "mediaId");
    Log.i("MicroMsg.AppBrandCdnService", s.X("cancelDownloadTask mediaId: ", paramString));
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, new CdnLogic.C2CDownloadResult());
    Log.i("MicroMsg.AppBrandCdnService", s.X("cancelDownloadTask, cancelDownloadTaskWithResult, result: ", Integer.valueOf(i)));
    if (i == 0) {
      utl.remove(paramString);
    }
    AppMethodBeat.o(317892);
    return i;
  }
  
  public final void onBadNetworkProbed()
  {
    AppMethodBeat.i(317993);
    Log.d("MicroMsg.AppBrandCdnService", "onBadNetworkProbed");
    AppMethodBeat.o(317993);
  }
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(317929);
    Log.d("MicroMsg.AppBrandCdnService", "onC2CDownloadCompleted, mediaId: " + paramString + ", result: " + paramC2CDownloadResult);
    if (paramC2CDownloadResult != null)
    {
      Object localObject = (h)((Map)utl).get(paramString);
      if (localObject != null)
      {
        localObject = ((h)localObject).lxs;
        if (localObject != null)
        {
          int i = paramC2CDownloadResult.errorCode;
          d locald = new d();
          locald.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
          locald.field_fileLength = paramC2CDownloadResult.fileSize;
          paramC2CDownloadResult = kotlin.ah.aiuX;
          ((h.a)localObject).a(paramString, i, locald);
          AppMethodBeat.o(317929);
        }
      }
    }
    else
    {
      paramC2CDownloadResult = (h)((Map)utl).get(paramString);
      if (paramC2CDownloadResult != null)
      {
        paramC2CDownloadResult = paramC2CDownloadResult.lxs;
        if (paramC2CDownloadResult != null) {
          paramC2CDownloadResult.a(paramString, -1, null);
        }
      }
    }
    AppMethodBeat.o(317929);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(317952);
    Log.d("MicroMsg.AppBrandCdnService", "onDataAvailable, mediaId: " + paramString + ", offset: " + paramLong1 + ", length: " + paramLong2);
    Object localObject = (h)((Map)utl).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).onDataAvailable(paramString, paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(317952);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(317916);
    Log.d("MicroMsg.AppBrandCdnService", "onDownloadProgressChanged, mediaId: " + paramString + ", offset: " + paramLong1 + ", total: " + paramLong2 + ", tryShow: " + paramBoolean);
    Object localObject = (h)((Map)utl).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).h(paramString, paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(317916);
  }
  
  public final void onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(317959);
    Log.d("MicroMsg.AppBrandCdnService", "onDownloadToEnd, mediaId: " + paramString + ", offset: " + paramLong1 + ", length: " + paramLong2);
    AppMethodBeat.o(317959);
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317935);
    Log.d("MicroMsg.AppBrandCdnService", "onM3U8Ready, mediaId: " + paramString1 + ", m3u8: " + paramString2);
    Object localObject = (h)((Map)utl).get(paramString1);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).onM3U8Ready(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(317935);
  }
  
  public final void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(317944);
    Log.d("MicroMsg.AppBrandCdnService", "onMoovReadyWithFlag, mediaId: " + paramString1 + ", offset: " + paramLong1 + ", length: " + paramLong2 + ", svrflag: " + paramString2);
    Object localObject = (h)((Map)utl).get(paramString1);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).a(paramString1, paramLong1, paramLong2, paramString2);
      }
    }
    AppMethodBeat.o(317944);
  }
  
  public final void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(317966);
    Log.d("MicroMsg.AppBrandCdnService", "onPreloadCompletedWithResult, mediaId: " + paramString + ", offset: " + paramLong1 + ", total: " + paramLong2 + ", result: " + paramC2CDownloadResult);
    paramC2CDownloadResult = (h)((Map)utl).get(paramString);
    if (paramC2CDownloadResult != null)
    {
      paramC2CDownloadResult = paramC2CDownloadResult.lxs;
      if (paramC2CDownloadResult != null) {
        paramC2CDownloadResult.h(paramString, paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(317966);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(317981);
    Log.d("MicroMsg.AppBrandCdnService", "reportFlow, wifiRecv: " + paramInt1 + ", wifiSend: " + paramInt2 + ", mobileRecv: " + paramInt3 + ", mobileSend: " + paramInt4);
    AppMethodBeat.o(317981);
  }
  
  public final void requestGetCDN(int paramInt)
  {
    AppMethodBeat.i(317971);
    Log.d("MicroMsg.AppBrandCdnService", s.X("requestGetCDN, reason: ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(317971);
  }
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(317988);
    StringBuilder localStringBuilder = new StringBuilder("reportFlow, host: ").append(paramString).append(", isDcip: ").append(paramBoolean).append(", dnsType: ");
    if (paramArrayOfInt == null) {
      paramString = null;
    }
    for (;;)
    {
      Log.d("MicroMsg.AppBrandCdnService", paramString);
      paramString = (String[])new String[0];
      AppMethodBeat.o(317988);
      return paramString;
      paramString = Arrays.toString(paramArrayOfInt);
      s.s(paramString, "java.util.Arrays.toString(this)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.a
 * JD-Core Version:    0.7.0.1
 */