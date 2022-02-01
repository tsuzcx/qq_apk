package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h;
import com.tencent.mm.g.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "Lcom/tencent/mars/cdn/CdnLogic$VideoStreamingCallback;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mars/cdn/CdnLogic$AppCallback;", "()V", "RSAPUBKEY_E", "", "RSAPUBKEY_N", "RSA_VERSION", "TAG", "USERKEY", "mTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "addDownloadTask", "", "task", "cancelDownloadTask", "mediaId", "clearAll", "", "onBadNetworkProbed", "onC2CDownloadCompleted", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDataAvailable", "offset", "", "length", "onDownloadProgressChanged", "total", "tryshow", "", "onDownloadToEnd", "onM3U8Ready", "m3u8", "onMoovReadyWithFlag", "svrflag", "onPreloadCompletedWithResult", "reportFlow", "wifi_recv", "wifi_send", "mobile_recv", "mobile_send", "requestGetCDN", "reason", "requestVideoData", "duration_ms", "resolveHost", "", "host", "is_dcip", "dnstype", "", "(Ljava/lang/String;Z[I)[Ljava/lang/String;", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.VideoStreamingCallback
{
  private final String HlC;
  private final String HlD;
  private final String HlE;
  private final String HlF;
  final HashMap<String, h> HlG;
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(263071);
    this.TAG = "MicroMsg.FlutterCdnService";
    this.HlC = "1";
    this.HlD = "010001";
    this.HlE = "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1";
    this.HlF = "cdnwx2013usrname";
    this.HlG = new HashMap();
    CdnLogic.Initialize(s.X(MMApplicationContext.getContext().getFilesDir().toString(), "/NativeCDNInfo"), (CdnLogic.AppCallback)this, this.HlC, this.HlE, this.HlD, this.HlF);
    AppMethodBeat.o(263071);
  }
  
  public final int D(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263095);
    s.u(paramString, "mediaId");
    Log.d(this.TAG, "FlutterCdnService requestVideoData mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    int i = CdnLogic.requestVideoData(paramString, paramLong1, paramLong2, 0);
    AppMethodBeat.o(263095);
    return i;
  }
  
  public final int agO(String paramString)
  {
    AppMethodBeat.i(263087);
    Log.d(this.TAG, s.X("FlutterCdnService cancelDownloadTask mediaId:", paramString));
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, new CdnLogic.C2CDownloadResult());
    if (i == 0)
    {
      Map localMap = (Map)this.HlG;
      if (localMap == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(263087);
        throw paramString;
      }
      an.hJ(localMap).remove(paramString);
    }
    AppMethodBeat.o(263087);
    return i;
  }
  
  public final int g(h paramh)
  {
    AppMethodBeat.i(263079);
    s.u(paramh, "task");
    Log.d(this.TAG, s.X("FlutterCdnService addDownloadTask mediaId:", paramh.field_mediaId));
    Object localObject = new CdnLogic.C2CDownloadRequest();
    ((CdnLogic.C2CDownloadRequest)localObject).fileKey = paramh.field_mediaId;
    ((CdnLogic.C2CDownloadRequest)localObject).url = paramh.url;
    ((CdnLogic.C2CDownloadRequest)localObject).referer = paramh.referer;
    ((CdnLogic.C2CDownloadRequest)localObject).setSavePath(paramh.field_fullpath);
    ((CdnLogic.C2CDownloadRequest)localObject).fileSize = 0;
    ((CdnLogic.C2CDownloadRequest)localObject).fileType = 20210;
    ((CdnLogic.C2CDownloadRequest)localObject).concurrentCount = 10;
    ((CdnLogic.C2CDownloadRequest)localObject).preloadRatio = paramh.field_preloadRatio;
    ((CdnLogic.C2CDownloadRequest)localObject).preloadMinSize = paramh.preloadMinSize;
    int i = CdnLogic.startHttpVideoStreamingDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.VideoStreamingCallback)this, (CdnLogic.DownloadCallback)this, paramh.lxi);
    Log.d(this.TAG, s.X("FlutterCdnService startHttpVideoStreamingDownload result:", Integer.valueOf(i)));
    if (i == 0)
    {
      localObject = (Map)this.HlG;
      String str = paramh.field_mediaId;
      s.s(str, "task.field_mediaId");
      ((Map)localObject).put(str, paramh);
    }
    AppMethodBeat.o(263079);
    return i;
  }
  
  public final void onBadNetworkProbed() {}
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(263152);
    Log.d(this.TAG, "FlutterCdnService onC2CDownloadCompleted mediaId:" + paramString + " result:" + paramC2CDownloadResult);
    Object localObject = (h)((Map)this.HlG).get(paramString);
    d locald = new d();
    if (paramC2CDownloadResult != null)
    {
      locald.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
      locald.field_fileLength = paramC2CDownloadResult.fileSize;
      if (localObject != null)
      {
        localObject = ((h)localObject).lxs;
        if (localObject != null)
        {
          ((h.a)localObject).a(paramString, paramC2CDownloadResult.errorCode, locald);
          AppMethodBeat.o(263152);
        }
      }
    }
    else if (localObject != null)
    {
      paramC2CDownloadResult = ((h)localObject).lxs;
      if (paramC2CDownloadResult != null) {
        paramC2CDownloadResult.a(paramString, -1, null);
      }
    }
    AppMethodBeat.o(263152);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263121);
    Log.d(this.TAG, "FlutterCdnService onDataAvailable mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.HlG).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).onDataAvailable(paramString, paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(263121);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(263143);
    Log.d(this.TAG, "FlutterCdnService onDownloadProgressChanged mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    Object localObject = (h)((Map)this.HlG).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).h(paramString, paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(263143);
  }
  
  public final void onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263126);
    Log.d(this.TAG, "FlutterCdnService onDownloadToEnd mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    AppMethodBeat.o(263126);
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263104);
    Log.d(this.TAG, s.X("FlutterCdnService onM3U8Ready mediaId:", paramString1));
    Object localObject = (h)((Map)this.HlG).get(paramString1);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).onM3U8Ready(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(263104);
  }
  
  public final void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(263113);
    Log.d(this.TAG, "FlutterCdnService onMoovReadyWithFlag mediaId:" + paramString1 + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.HlG).get(paramString1);
    if (localObject != null)
    {
      localObject = ((h)localObject).lxs;
      if (localObject != null) {
        ((h.a)localObject).a(paramString1, paramLong1, paramLong2, paramString2);
      }
    }
    AppMethodBeat.o(263113);
  }
  
  public final void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(263135);
    Log.d(this.TAG, "FlutterCdnService onPreloadCompletedWithResult mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    paramC2CDownloadResult = (h)((Map)this.HlG).get(paramString);
    if (paramC2CDownloadResult != null)
    {
      paramC2CDownloadResult = paramC2CDownloadResult.lxs;
      if (paramC2CDownloadResult != null) {
        paramC2CDownloadResult.h(paramString, paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(263135);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void requestGetCDN(int paramInt) {}
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return (String[])new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.c
 * JD-Core Version:    0.7.0.1
 */