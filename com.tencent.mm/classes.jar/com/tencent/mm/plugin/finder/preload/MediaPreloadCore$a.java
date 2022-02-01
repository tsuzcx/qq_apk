package com.tencent.mm.plugin.finder.preload;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.z;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Companion;", "", "()V", "SOURCE_DATA_INSERTED", "", "SOURCE_IDLE", "SOURCE_LOAD_MORE", "SOURCE_REFRESH", "SOURCE_TAB_CHANGE", "TAG", "", "isShowPreloadView", "", "()Z", "setShowPreloadView", "(Z)V", "checkMoovReady", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "cache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "plugin-finder_release"})
public final class MediaPreloadCore$a
{
  public static MediaPreloadCore.b a(z paramz)
  {
    AppMethodBeat.i(203494);
    p.h(paramz, "cache");
    String str3 = paramz.getFilePath();
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    long[] arrayOfLong = new long[2];
    localC2CDownloadRequest.fileKey = paramz.field_mediaId;
    localC2CDownloadRequest.fileType = 8;
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = paramz.field_url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localC2CDownloadRequest.url = (str1 + paramz.field_urlToken);
    localC2CDownloadRequest.snsCipherKey = paramz.field_decodeKey;
    localC2CDownloadRequest.setSavePath(str3);
    localC2CDownloadRequest.videoflagPolicy = 0;
    localC2CDownloadRequest.requestVideoFlag = paramz.field_fileFormat;
    localC2CDownloadRequest.requestVideoFormat = paramz.field_reqFormat;
    paramz = new MediaPreloadCore.b(CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong), arrayOfLong[0], arrayOfLong[1]);
    AppMethodBeat.o(203494);
    return paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a
 * JD-Core Version:    0.7.0.1
 */