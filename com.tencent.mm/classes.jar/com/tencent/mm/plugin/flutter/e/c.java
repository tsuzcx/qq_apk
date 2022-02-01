package com.tencent.mm.plugin.flutter.e;

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
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "Lcom/tencent/mars/cdn/CdnLogic$VideoStreamingCallback;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mars/cdn/CdnLogic$AppCallback;", "()V", "RSAPUBKEY_E", "", "RSAPUBKEY_N", "RSA_VERSION", "TAG", "USERKEY", "mTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "addDownloadTask", "", "task", "cancelDownloadTask", "mediaId", "clearAll", "", "onBadNetworkProbed", "onC2CDownloadCompleted", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDataAvailable", "offset", "", "length", "onDownloadProgressChanged", "total", "tryshow", "", "onDownloadToEnd", "onMoovReadyWithFlag", "svrflag", "onPreloadCompletedWithResult", "reportFlow", "wifi_recv", "wifi_send", "mobile_recv", "mobile_send", "requestGetCDN", "reason", "requestVideoData", "duration_ms", "resolveHost", "", "host", "is_dcip", "dnstype", "", "(Ljava/lang/String;Z[I)[Ljava/lang/String;", "plugin-flutter_release"})
public final class c
  implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.VideoStreamingCallback
{
  private final String TAG;
  private final String ttJ;
  private final String ttK;
  private final String ttL;
  private final String ttM;
  private final HashMap<String, h> ttN;
  
  public c()
  {
    AppMethodBeat.i(213485);
    this.TAG = "MicroMsg.FlutterCdnService";
    this.ttJ = "1";
    this.ttK = "010001";
    this.ttL = "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1";
    this.ttM = "cdnwx2013usrname";
    this.ttN = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    CdnLogic.Initialize(localContext.getFilesDir().toString() + "/NativeCDNInfo", (CdnLogic.AppCallback)this, this.ttJ, this.ttL, this.ttK, this.ttM);
    AppMethodBeat.o(213485);
  }
  
  public final int aku(String paramString)
  {
    AppMethodBeat.i(213476);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService cancelDownloadTask mediaId:".concat(String.valueOf(paramString)));
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, new CdnLogic.C2CDownloadResult());
    if (i == 0)
    {
      Map localMap = (Map)this.ttN;
      if (localMap == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(213476);
        throw paramString;
      }
      d.g.b.ae.eY(localMap).remove(paramString);
    }
    AppMethodBeat.o(213476);
    return i;
  }
  
  public final int c(h paramh)
  {
    AppMethodBeat.i(213475);
    p.h(paramh, "task");
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService addDownloadTask mediaId:" + paramh.field_mediaId);
    Object localObject = new CdnLogic.C2CDownloadRequest();
    ((CdnLogic.C2CDownloadRequest)localObject).fileKey = paramh.field_mediaId;
    ((CdnLogic.C2CDownloadRequest)localObject).url = paramh.url;
    ((CdnLogic.C2CDownloadRequest)localObject).referer = paramh.referer;
    ((CdnLogic.C2CDownloadRequest)localObject).setSavePath(paramh.field_fullpath);
    ((CdnLogic.C2CDownloadRequest)localObject).fileSize = 0;
    ((CdnLogic.C2CDownloadRequest)localObject).fileType = 20210;
    ((CdnLogic.C2CDownloadRequest)localObject).concurrentCount = 10;
    ((CdnLogic.C2CDownloadRequest)localObject).ocIpList = paramh.fLe;
    ((CdnLogic.C2CDownloadRequest)localObject).preloadRatio = paramh.field_preloadRatio;
    ((CdnLogic.C2CDownloadRequest)localObject).preloadMinSize = paramh.preloadMinSize;
    int i = CdnLogic.startHttpVideoStreamingDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.VideoStreamingCallback)this, (CdnLogic.DownloadCallback)this, paramh.fLI);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService startHttpVideoStreamingDownload result:".concat(String.valueOf(i)));
    if (i == 0)
    {
      localObject = (Map)this.ttN;
      String str = paramh.field_mediaId;
      p.g(str, "task.field_mediaId");
      ((Map)localObject).put(str, paramh);
    }
    AppMethodBeat.o(213475);
    return i;
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(213477);
    HashMap localHashMap = this.ttN;
    if (localHashMap != null)
    {
      localHashMap.clear();
      AppMethodBeat.o(213477);
      return;
    }
    AppMethodBeat.o(213477);
  }
  
  public final void onBadNetworkProbed() {}
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(213484);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService onC2CDownloadCompleted mediaId:" + paramString + " result:" + paramC2CDownloadResult);
    Object localObject = (h)((Map)this.ttN).get(paramString);
    d locald = new d();
    if (paramC2CDownloadResult != null)
    {
      locald.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
      locald.field_fileLength = paramC2CDownloadResult.fileSize;
      if (localObject != null)
      {
        localObject = ((h)localObject).fLQ;
        if (localObject != null)
        {
          ((h.a)localObject).a(paramString, paramC2CDownloadResult.errorCode, locald);
          AppMethodBeat.o(213484);
          return;
        }
      }
      AppMethodBeat.o(213484);
      return;
    }
    if (localObject != null)
    {
      paramC2CDownloadResult = ((h)localObject).fLQ;
      if (paramC2CDownloadResult != null)
      {
        paramC2CDownloadResult.a(paramString, -1, null);
        AppMethodBeat.o(213484);
        return;
      }
    }
    AppMethodBeat.o(213484);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(213480);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService onDataAvailable mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.ttN).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).fLQ;
      if (localObject != null)
      {
        ((h.a)localObject).onDataAvailable(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(213480);
        return;
      }
    }
    AppMethodBeat.o(213480);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(213483);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService onDownloadProgressChanged mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    Object localObject = (h)((Map)this.ttN).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).fLQ;
      if (localObject != null)
      {
        ((h.a)localObject).i(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(213483);
        return;
      }
    }
    AppMethodBeat.o(213483);
  }
  
  public final void onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(213481);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService onDownloadToEnd mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    AppMethodBeat.o(213481);
  }
  
  public final void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(213479);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService onMoovReadyWithFlag mediaId:" + paramString1 + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.ttN).get(paramString1);
    if (localObject != null)
    {
      localObject = ((h)localObject).fLQ;
      if (localObject != null)
      {
        ((h.a)localObject).a(paramString1, paramLong1, paramLong2, paramString2);
        AppMethodBeat.o(213479);
        return;
      }
    }
    AppMethodBeat.o(213479);
  }
  
  public final void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(213482);
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService onPreloadCompletedWithResult mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    paramC2CDownloadResult = (h)((Map)this.ttN).get(paramString);
    if (paramC2CDownloadResult != null)
    {
      paramC2CDownloadResult = paramC2CDownloadResult.fLQ;
      if (paramC2CDownloadResult != null)
      {
        paramC2CDownloadResult.i(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(213482);
        return;
      }
    }
    AppMethodBeat.o(213482);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void requestGetCDN(int paramInt) {}
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return new String[0];
  }
  
  public final int y(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(213478);
    p.h(paramString, "mediaId");
    com.tencent.mm.sdk.platformtools.ae.d(this.TAG, "FlutterCdnService requestVideoData mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    int i = CdnLogic.requestVideoData(paramString, paramLong1, paramLong2, 0);
    AppMethodBeat.o(213478);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.c
 * JD-Core Version:    0.7.0.1
 */