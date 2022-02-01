package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.cjl;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "", "downloadUrl", "", "path", "mediaId", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getDownloadUrl", "()Ljava/lang/String;", "getFeedData", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getLocalFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaId", "getPath", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "toString", "plugin-finder_release"})
public class s
{
  final String downloadUrl;
  public final String mediaId;
  public final String path;
  public final com.tencent.mm.plugin.finder.loader.s tHN;
  final cjl wgl;
  public final FeedData wgm;
  
  public s(String paramString1, String paramString2, String paramString3, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params, FeedData paramFeedData)
  {
    AppMethodBeat.i(254405);
    this.downloadUrl = paramString1;
    this.path = paramString2;
    this.mediaId = paramString3;
    this.wgl = paramcjl;
    this.tHN = params;
    this.wgm = paramFeedData;
    AppMethodBeat.o(254405);
  }
  
  public String toString()
  {
    AppMethodBeat.i(254404);
    Object localObject = new StringBuilder(" downloadUrl='").append(this.downloadUrl).append("', path='").append(this.path).append("', mediaId='").append(this.mediaId).append("' localFinderMedia is null? ");
    if (this.wgl == null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ' ';
      AppMethodBeat.o(254404);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.s
 * JD-Core Version:    0.7.0.1
 */