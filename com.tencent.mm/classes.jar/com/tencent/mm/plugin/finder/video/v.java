package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.dji;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "", "downloadUrl", "", "path", "mediaId", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getDownloadUrl", "()Ljava/lang/String;", "getFeedData", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getLocalFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaId", "getPath", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class v
{
  public final x ANK;
  public final FeedData AWA;
  public final dji Grz;
  final String downloadUrl;
  public final String mediaId;
  public final String path;
  
  public v(String paramString1, String paramString2, String paramString3, dji paramdji, x paramx, FeedData paramFeedData)
  {
    AppMethodBeat.i(334837);
    this.downloadUrl = paramString1;
    this.path = paramString2;
    this.mediaId = paramString3;
    this.Grz = paramdji;
    this.ANK = paramx;
    this.AWA = paramFeedData;
    AppMethodBeat.o(334837);
  }
  
  public String toString()
  {
    AppMethodBeat.i(334840);
    Object localObject = new StringBuilder(" downloadUrl='").append(this.downloadUrl).append("', path='").append(this.path).append("', mediaId='").append(this.mediaId).append("' localFinderMedia is null? ");
    if (this.Grz == null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ' ';
      AppMethodBeat.o(334840);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.v
 * JD-Core Version:    0.7.0.1
 */