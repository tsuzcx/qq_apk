package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dnw;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"toLongVideoServer", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Ljava/util/LinkedList;", "toMegaMediaSpec", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMediaSpec;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "toServer", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "plugin-finder-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final LinkedList<dnv> ba(LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(339313);
    s.u(paramLinkedList, "<this>");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(c((dji)paramLinkedList.next()));
    }
    AppMethodBeat.o(339313);
    return localLinkedList;
  }
  
  private static LinkedList<dnw> bb(LinkedList<boz> paramLinkedList)
  {
    AppMethodBeat.i(339334);
    s.u(paramLinkedList, "<this>");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(c((boz)paramLinkedList.next()));
    }
    AppMethodBeat.o(339334);
    return localLinkedList;
  }
  
  public static final dnv c(dji paramdji)
  {
    AppMethodBeat.i(339324);
    s.u(paramdji, "<this>");
    dnv localdnv = new dnv();
    localdnv.url = paramdji.url;
    localdnv.mediaType = paramdji.mediaType;
    localdnv.thumbUrl = paramdji.thumbUrl;
    localdnv.aaUX = paramdji.videoDuration;
    if (paramdji.aaPh == 0L) {}
    for (localdnv.aaUY = (paramdji.videoDuration * 1000L);; localdnv.aaUY = paramdji.aaPh)
    {
      localdnv.width = paramdji.width;
      localdnv.height = paramdji.height;
      localdnv.md5sum = paramdji.md5sum;
      localdnv.fileSize = paramdji.fileSize;
      localdnv.bitrate = paramdji.bitrate;
      localdnv.decodeKey = paramdji.decodeKey;
      localdnv.coverUrl = paramdji.coverUrl;
      Object localObject = localdnv.spec;
      ((LinkedList)localObject).clear();
      LinkedList localLinkedList = paramdji.spec;
      s.s(localLinkedList, "spec");
      ((LinkedList)localObject).addAll((Collection)bb(localLinkedList));
      localObject = new bbq();
      ((bbq)localObject).ZMj.addAll((Collection)paramdji.aaPr);
      paramdji = ah.aiuX;
      localdnv.aaVa = ((bbq)localObject);
      paramdji = new bbo();
      paramdji.ZMf.addAll((Collection)paramdji.ZMf);
      localObject = ah.aiuX;
      localdnv.hdr_spec = paramdji;
      AppMethodBeat.o(339324);
      return localdnv;
    }
  }
  
  private static dnw c(boz paramboz)
  {
    AppMethodBeat.i(339329);
    s.u(paramboz, "<this>");
    dnw localdnw = new dnw();
    localdnw.hVy = paramboz.hVy;
    localdnw.ZMg = paramboz.ZMg;
    localdnw.ZPI = paramboz.ZPI;
    localdnw.EVK = paramboz.EVK;
    AppMethodBeat.o(339329);
    return localdnw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.n
 * JD-Core Version:    0.7.0.1
 */