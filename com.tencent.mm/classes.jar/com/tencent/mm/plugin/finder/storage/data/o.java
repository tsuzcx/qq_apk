package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dnw;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"toFinderMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Ljava/util/LinkedList;", "toFinderMediaSpec", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMediaSpec;", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final FinderMedia b(dnv paramdnv)
  {
    AppMethodBeat.i(339323);
    s.u(paramdnv, "<this>");
    FinderMedia localFinderMedia = new FinderMedia();
    localFinderMedia.url = paramdnv.url;
    localFinderMedia.thumbUrl = paramdnv.thumbUrl;
    localFinderMedia.mediaType = 4;
    localFinderMedia.videoDuration = paramdnv.aaUX;
    localFinderMedia.width = paramdnv.width;
    localFinderMedia.height = paramdnv.height;
    localFinderMedia.md5sum = paramdnv.md5sum;
    localFinderMedia.fileSize = paramdnv.fileSize;
    localFinderMedia.bitrate = paramdnv.bitrate;
    LinkedList localLinkedList1 = localFinderMedia.spec;
    localLinkedList1.clear();
    Object localObject = paramdnv.spec;
    s.s(localObject, "spec");
    s.u(localObject, "<this>");
    LinkedList localLinkedList2 = new LinkedList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dnw localdnw = (dnw)((Iterator)localObject).next();
      s.u(localdnw, "<this>");
      boz localboz = new boz();
      localboz.hVy = localdnw.hVy;
      localboz.ZMg = localdnw.ZMg;
      localboz.ZPI = localdnw.ZPI;
      localboz.EVK = localdnw.EVK;
      localLinkedList2.add(localboz);
    }
    localLinkedList1.addAll((Collection)localLinkedList2);
    localFinderMedia.coverUrl = paramdnv.coverUrl;
    localFinderMedia.decodeKey = paramdnv.decodeKey;
    localFinderMedia.url_token = paramdnv.msf;
    localFinderMedia.thumb_url_token = paramdnv.msh;
    localFinderMedia.cover_url_token = paramdnv.aaUZ;
    localFinderMedia.hls_spec = paramdnv.aaVa;
    localFinderMedia.hot_flag = paramdnv.hot_flag;
    localFinderMedia.half_rect = paramdnv.half_rect;
    localFinderMedia.full_thumb_url = paramdnv.full_thumb_url;
    localFinderMedia.full_thumb_url_token = paramdnv.full_thumb_url_token;
    AppMethodBeat.o(339323);
    return localFinderMedia;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.o
 * JD-Core Version:    0.7.0.1
 */