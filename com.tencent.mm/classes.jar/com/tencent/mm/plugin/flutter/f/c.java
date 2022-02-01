package com.tencent.mm.plugin.flutter.f;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "Lcom/tencent/mars/cdn/CdnLogic$VideoStreamingCallback;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mars/cdn/CdnLogic$AppCallback;", "()V", "RSAPUBKEY_E", "", "RSAPUBKEY_N", "RSA_VERSION", "TAG", "USERKEY", "mTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "addDownloadTask", "", "task", "cancelDownloadTask", "mediaId", "clearAll", "", "onBadNetworkProbed", "onC2CDownloadCompleted", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDataAvailable", "offset", "", "length", "onDownloadProgressChanged", "total", "tryshow", "", "onDownloadToEnd", "onM3U8Ready", "m3u8", "onMoovReadyWithFlag", "svrflag", "onPreloadCompletedWithResult", "reportFlow", "wifi_recv", "wifi_send", "mobile_recv", "mobile_send", "requestGetCDN", "reason", "requestVideoData", "duration_ms", "resolveHost", "", "host", "is_dcip", "dnstype", "", "(Ljava/lang/String;Z[I)[Ljava/lang/String;", "plugin-flutter_release"})
public final class c
  implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.VideoStreamingCallback
{
  private final String TAG;
  private final String wKX;
  private final String wKY;
  private final String wKZ;
  private final String wLa;
  final HashMap<String, h> wLb;
  
  public c()
  {
    AppMethodBeat.i(241143);
    this.TAG = "MicroMsg.FlutterCdnService";
    this.wKX = "1";
    this.wKY = "010001";
    this.wKZ = "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1";
    this.wLa = "cdnwx2013usrname";
    this.wLb = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    CdnLogic.Initialize(localContext.getFilesDir().toString() + "/NativeCDNInfo", (CdnLogic.AppCallback)this, this.wKX, this.wKZ, this.wKY, this.wLa);
    AppMethodBeat.o(241143);
  }
  
  public final int axz(String paramString)
  {
    AppMethodBeat.i(241134);
    Log.d(this.TAG, "FlutterCdnService cancelDownloadTask mediaId:".concat(String.valueOf(paramString)));
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, new CdnLogic.C2CDownloadResult());
    if (i == 0)
    {
      Map localMap = (Map)this.wLb;
      if (localMap == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(241134);
        throw paramString;
      }
      af.fd(localMap).remove(paramString);
    }
    AppMethodBeat.o(241134);
    return i;
  }
  
  public final int g(h paramh)
  {
    AppMethodBeat.i(241133);
    p.h(paramh, "task");
    Log.d(this.TAG, "FlutterCdnService addDownloadTask mediaId:" + paramh.field_mediaId);
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
    int i = CdnLogic.startHttpVideoStreamingDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.VideoStreamingCallback)this, (CdnLogic.DownloadCallback)this, paramh.gqU);
    Log.d(this.TAG, "FlutterCdnService startHttpVideoStreamingDownload result:".concat(String.valueOf(i)));
    if (i == 0)
    {
      localObject = (Map)this.wLb;
      String str = paramh.field_mediaId;
      p.g(str, "task.field_mediaId");
      ((Map)localObject).put(str, paramh);
    }
    AppMethodBeat.o(241133);
    return i;
  }
  
  public final void onBadNetworkProbed() {}
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(241142);
    Log.d(this.TAG, "FlutterCdnService onC2CDownloadCompleted mediaId:" + paramString + " result:" + paramC2CDownloadResult);
    Object localObject = (h)((Map)this.wLb).get(paramString);
    d locald = new d();
    if (paramC2CDownloadResult != null)
    {
      locald.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
      locald.field_fileLength = paramC2CDownloadResult.fileSize;
      if (localObject != null)
      {
        localObject = ((h)localObject).gre;
        if (localObject != null)
        {
          ((h.a)localObject).a(paramString, paramC2CDownloadResult.errorCode, locald);
          AppMethodBeat.o(241142);
          return;
        }
      }
      AppMethodBeat.o(241142);
      return;
    }
    if (localObject != null)
    {
      paramC2CDownloadResult = ((h)localObject).gre;
      if (paramC2CDownloadResult != null)
      {
        paramC2CDownloadResult.a(paramString, -1, null);
        AppMethodBeat.o(241142);
        return;
      }
    }
    AppMethodBeat.o(241142);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241138);
    Log.d(this.TAG, "FlutterCdnService onDataAvailable mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.wLb).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).gre;
      if (localObject != null)
      {
        ((h.a)localObject).onDataAvailable(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(241138);
        return;
      }
    }
    AppMethodBeat.o(241138);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(241141);
    Log.d(this.TAG, "FlutterCdnService onDownloadProgressChanged mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    Object localObject = (h)((Map)this.wLb).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).gre;
      if (localObject != null)
      {
        ((h.a)localObject).i(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(241141);
        return;
      }
    }
    AppMethodBeat.o(241141);
  }
  
  public final void onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241139);
    Log.d(this.TAG, "FlutterCdnService onDownloadToEnd mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    AppMethodBeat.o(241139);
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241136);
    Log.d(this.TAG, "FlutterCdnService onM3U8Ready mediaId:".concat(String.valueOf(paramString1)));
    paramString2 = (h)((Map)this.wLb).get(paramString1);
    if (paramString2 != null)
    {
      paramString2 = paramString2.gre;
      if (paramString2 != null)
      {
        paramString2.Ds(paramString1);
        AppMethodBeat.o(241136);
        return;
      }
    }
    AppMethodBeat.o(241136);
  }
  
  public final void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(241137);
    Log.d(this.TAG, "FlutterCdnService onMoovReadyWithFlag mediaId:" + paramString1 + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.wLb).get(paramString1);
    if (localObject != null)
    {
      localObject = ((h)localObject).gre;
      if (localObject != null)
      {
        ((h.a)localObject).a(paramString1, paramLong1, paramLong2, paramString2);
        AppMethodBeat.o(241137);
        return;
      }
    }
    AppMethodBeat.o(241137);
  }
  
  public final void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(241140);
    Log.d(this.TAG, "FlutterCdnService onPreloadCompletedWithResult mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    paramC2CDownloadResult = (h)((Map)this.wLb).get(paramString);
    if (paramC2CDownloadResult != null)
    {
      paramC2CDownloadResult = paramC2CDownloadResult.gre;
      if (paramC2CDownloadResult != null)
      {
        paramC2CDownloadResult.i(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(241140);
        return;
      }
    }
    AppMethodBeat.o(241140);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void requestGetCDN(int paramInt) {}
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return new String[0];
  }
  
  public final int z(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241135);
    p.h(paramString, "mediaId");
    Log.d(this.TAG, "FlutterCdnService requestVideoData mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    int i = CdnLogic.requestVideoData(paramString, paramLong1, paramLong2, 0);
    AppMethodBeat.o(241135);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.f.c
 * JD-Core Version:    0.7.0.1
 */