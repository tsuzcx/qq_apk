package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bvf;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "", "downloadUrl", "", "path", "mediaId", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getDownloadUrl", "()Ljava/lang/String;", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalFinderMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaId", "getPath", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "toString", "plugin-finder_release"})
public final class p
{
  final String downloadUrl;
  public final String mediaId;
  public final String path;
  public final FinderItem rJP;
  public final m rQu;
  final bvf sQp;
  
  public p(String paramString1, String paramString2, String paramString3, bvf parambvf, m paramm, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204882);
    this.downloadUrl = paramString1;
    this.path = paramString2;
    this.mediaId = paramString3;
    this.sQp = parambvf;
    this.rQu = paramm;
    this.rJP = paramFinderItem;
    AppMethodBeat.o(204882);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204881);
    Object localObject = new StringBuilder("downloadUrl='").append(this.downloadUrl).append("', path='").append(this.path).append("', mediaId='").append(this.mediaId).append("' localFinderMedia is null? ");
    if (this.sQp == null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = bool + ' ';
      AppMethodBeat.o(204881);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.p
 * JD-Core Version:    0.7.0.1
 */