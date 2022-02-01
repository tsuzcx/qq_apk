package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.csg;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "", "downloadUrl", "", "path", "mediaId", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getDownloadUrl", "()Ljava/lang/String;", "getFeedData", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getLocalFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaId", "getPath", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "toString", "plugin-finder-base_release"})
public class t
{
  public final csg APg;
  public final String downloadUrl;
  public final String mediaId;
  public final String path;
  public final ac xqx;
  public final FeedData xzp;
  
  public t(String paramString1, String paramString2, String paramString3, csg paramcsg, ac paramac, FeedData paramFeedData)
  {
    AppMethodBeat.i(259212);
    this.downloadUrl = paramString1;
    this.path = paramString2;
    this.mediaId = paramString3;
    this.APg = paramcsg;
    this.xqx = paramac;
    this.xzp = paramFeedData;
    AppMethodBeat.o(259212);
  }
  
  public String toString()
  {
    AppMethodBeat.i(259211);
    Object localObject = new StringBuilder(" downloadUrl='").append(this.downloadUrl).append("', path='").append(this.path).append("', mediaId='").append(this.mediaId).append("' localFinderMedia is null? ");
    if (this.APg == null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ' ';
      AppMethodBeat.o(259211);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.t
 * JD-Core Version:    0.7.0.1
 */