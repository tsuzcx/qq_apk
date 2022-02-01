package com.tencent.mm.plugin.finder.preload;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.az;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Companion;", "", "()V", "SOURCE_DATA_INSERTED", "", "SOURCE_IDLE", "SOURCE_LOAD_MORE", "SOURCE_REFRESH", "SOURCE_TAB_CHANGE", "TAG", "", "isShowPreloadView", "", "()Z", "setShowPreloadView", "(Z)V", "checkMoovReady", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "cache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a
{
  public static f.b a(az paramaz)
  {
    AppMethodBeat.i(346233);
    s.u(paramaz, "cache");
    String str3 = paramaz.getFilePath();
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    long[] arrayOfLong = new long[2];
    localC2CDownloadRequest.fileKey = paramaz.field_mediaId;
    localC2CDownloadRequest.fileType = 8;
    String str2 = paramaz.field_url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localC2CDownloadRequest.url = s.X(str1, paramaz.field_urlToken);
    localC2CDownloadRequest.snsCipherKey = paramaz.field_decodeKey;
    localC2CDownloadRequest.setSavePath(str3);
    localC2CDownloadRequest.videoflagPolicy = 0;
    localC2CDownloadRequest.requestVideoFlag = paramaz.field_fileFormat;
    localC2CDownloadRequest.requestVideoFormat = paramaz.field_reqFormat;
    paramaz = new f.b(CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong), arrayOfLong[0], arrayOfLong[1]);
    AppMethodBeat.o(346233);
    return paramaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.f.a
 * JD-Core Version:    0.7.0.1
 */