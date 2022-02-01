package com.tencent.mm.plugin.flutter.d;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.aa;
import d.g.b.k;
import d.l;
import d.v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnService;", "Lcom/tencent/mars/cdn/CdnLogic$VideoStreamingCallback;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mars/cdn/CdnLogic$AppCallback;", "()V", "RSAPUBKEY_E", "", "RSAPUBKEY_N", "RSA_VERSION", "TAG", "USERKEY", "mTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "addDownloadTask", "", "task", "cancelDownloadTask", "mediaId", "clearAll", "", "onBadNetworkProbed", "onC2CDownloadCompleted", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDataAvailable", "offset", "", "length", "onDownloadProgressChanged", "total", "tryshow", "", "onDownloadToEnd", "onMoovReadyWithFlag", "svrflag", "onPreloadCompletedWithResult", "reportFlow", "wifi_recv", "wifi_send", "mobile_recv", "mobile_send", "requestGetCDN", "reason", "requestVideoData", "duration_ms", "resolveHost", "", "host", "is_dcip", "dnstype", "", "(Ljava/lang/String;Z[I)[Ljava/lang/String;", "plugin-flutter_release"})
public final class c
  implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.VideoStreamingCallback
{
  private final String TAG;
  private final String smn;
  private final String smo;
  private final String smp;
  private final String smq;
  private final HashMap<String, h> smr;
  
  public c()
  {
    AppMethodBeat.i(209726);
    this.TAG = "MicroMsg.FlutterCdnService";
    this.smn = "1";
    this.smo = "010001";
    this.smp = "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1";
    this.smq = "cdnwx2013usrname";
    this.smr = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    Context localContext = ai.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    CdnLogic.Initialize(localContext.getFilesDir().toString() + "/NativeCDNInfo", (CdnLogic.AppCallback)this, this.smn, this.smp, this.smo, this.smq);
    AppMethodBeat.o(209726);
  }
  
  public final int aeY(String paramString)
  {
    AppMethodBeat.i(209717);
    ac.d(this.TAG, "FlutterCdnService cancelDownloadTask mediaId:".concat(String.valueOf(paramString)));
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, new CdnLogic.C2CDownloadResult());
    if (i == 0)
    {
      Map localMap = (Map)this.smr;
      if (localMap == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(209717);
        throw paramString;
      }
      aa.eS(localMap).remove(paramString);
    }
    AppMethodBeat.o(209717);
    return i;
  }
  
  public final int c(h paramh)
  {
    AppMethodBeat.i(209716);
    k.h(paramh, "task");
    ac.d(this.TAG, "FlutterCdnService addDownloadTask mediaId:" + paramh.field_mediaId);
    Object localObject = new CdnLogic.C2CDownloadRequest();
    ((CdnLogic.C2CDownloadRequest)localObject).fileKey = paramh.field_mediaId;
    ((CdnLogic.C2CDownloadRequest)localObject).url = paramh.url;
    ((CdnLogic.C2CDownloadRequest)localObject).referer = paramh.referer;
    ((CdnLogic.C2CDownloadRequest)localObject).setSavePath(paramh.field_fullpath);
    ((CdnLogic.C2CDownloadRequest)localObject).fileSize = 0;
    ((CdnLogic.C2CDownloadRequest)localObject).fileType = 20210;
    ((CdnLogic.C2CDownloadRequest)localObject).concurrentCount = 10;
    ((CdnLogic.C2CDownloadRequest)localObject).ocIpList = paramh.fqT;
    ((CdnLogic.C2CDownloadRequest)localObject).preloadRatio = paramh.field_preloadRatio;
    ((CdnLogic.C2CDownloadRequest)localObject).preloadMinSize = paramh.preloadMinSize;
    int i = CdnLogic.startHttpVideoStreamingDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.VideoStreamingCallback)this, (CdnLogic.DownloadCallback)this, paramh.frw);
    ac.d(this.TAG, "FlutterCdnService startHttpVideoStreamingDownload result:".concat(String.valueOf(i)));
    if (i == 0)
    {
      localObject = (Map)this.smr;
      String str = paramh.field_mediaId;
      k.g(str, "task.field_mediaId");
      ((Map)localObject).put(str, paramh);
    }
    AppMethodBeat.o(209716);
    return i;
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(209718);
    HashMap localHashMap = this.smr;
    if (localHashMap != null)
    {
      localHashMap.clear();
      AppMethodBeat.o(209718);
      return;
    }
    AppMethodBeat.o(209718);
  }
  
  public final void onBadNetworkProbed() {}
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(209725);
    ac.d(this.TAG, "FlutterCdnService onC2CDownloadCompleted mediaId:" + paramString + " result:" + paramC2CDownloadResult);
    Object localObject = (h)((Map)this.smr).get(paramString);
    d locald = new d();
    if (paramC2CDownloadResult != null)
    {
      locald.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
      locald.field_fileLength = paramC2CDownloadResult.fileSize;
      if (localObject != null)
      {
        localObject = ((h)localObject).frE;
        if (localObject != null)
        {
          ((h.a)localObject).a(paramString, paramC2CDownloadResult.errorCode, locald);
          AppMethodBeat.o(209725);
          return;
        }
      }
      AppMethodBeat.o(209725);
      return;
    }
    if (localObject != null)
    {
      paramC2CDownloadResult = ((h)localObject).frE;
      if (paramC2CDownloadResult != null)
      {
        paramC2CDownloadResult.a(paramString, -1, null);
        AppMethodBeat.o(209725);
        return;
      }
    }
    AppMethodBeat.o(209725);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209721);
    ac.d(this.TAG, "FlutterCdnService onDataAvailable mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.smr).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).frE;
      if (localObject != null)
      {
        ((h.a)localObject).onDataAvailable(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(209721);
        return;
      }
    }
    AppMethodBeat.o(209721);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(209724);
    ac.d(this.TAG, "FlutterCdnService onDownloadProgressChanged mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    Object localObject = (h)((Map)this.smr).get(paramString);
    if (localObject != null)
    {
      localObject = ((h)localObject).frE;
      if (localObject != null)
      {
        ((h.a)localObject).i(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(209724);
        return;
      }
    }
    AppMethodBeat.o(209724);
  }
  
  public final void onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209722);
    ac.d(this.TAG, "FlutterCdnService onDownloadToEnd mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    AppMethodBeat.o(209722);
  }
  
  public final void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(209720);
    ac.d(this.TAG, "FlutterCdnService onMoovReadyWithFlag mediaId:" + paramString1 + " offset:" + paramLong1 + " length:" + paramLong2);
    Object localObject = (h)((Map)this.smr).get(paramString1);
    if (localObject != null)
    {
      localObject = ((h)localObject).frE;
      if (localObject != null)
      {
        ((h.a)localObject).a(paramString1, paramLong1, paramLong2, paramString2);
        AppMethodBeat.o(209720);
        return;
      }
    }
    AppMethodBeat.o(209720);
  }
  
  public final void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(209723);
    ac.d(this.TAG, "FlutterCdnService onPreloadCompletedWithResult mediaId:" + paramString + " offset:" + paramLong1 + " total:" + paramLong2);
    paramC2CDownloadResult = (h)((Map)this.smr).get(paramString);
    if (paramC2CDownloadResult != null)
    {
      paramC2CDownloadResult = paramC2CDownloadResult.frE;
      if (paramC2CDownloadResult != null)
      {
        paramC2CDownloadResult.i(paramString, paramLong1, paramLong2);
        AppMethodBeat.o(209723);
        return;
      }
    }
    AppMethodBeat.o(209723);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void requestGetCDN(int paramInt) {}
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return new String[0];
  }
  
  public final int x(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209719);
    k.h(paramString, "mediaId");
    ac.d(this.TAG, "FlutterCdnService requestVideoData mediaId:" + paramString + " offset:" + paramLong1 + " length:" + paramLong2);
    int i = CdnLogic.requestVideoData(paramString, paramLong1, paramLong2, 0);
    AppMethodBeat.o(209719);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.c
 * JD-Core Version:    0.7.0.1
 */