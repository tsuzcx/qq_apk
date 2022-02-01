package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.cwr;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"toLongVideoServer", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Ljava/util/LinkedList;", "toMegaMediaSpec", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMediaSpec;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "toServer", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "plugin-finder-base_release"})
public final class n
{
  public static final LinkedList<cwq> aT(LinkedList<csg> paramLinkedList)
  {
    AppMethodBeat.i(263299);
    p.k(paramLinkedList, "$this$toLongVideoServer");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(c((csg)paramLinkedList.next()));
    }
    AppMethodBeat.o(263299);
    return localLinkedList;
  }
  
  private static LinkedList<cwr> aU(LinkedList<beb> paramLinkedList)
  {
    AppMethodBeat.i(263303);
    p.k(paramLinkedList, "$this$toMegaMediaSpec");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(b((beb)paramLinkedList.next()));
    }
    AppMethodBeat.o(263303);
    return localLinkedList;
  }
  
  private static cwr b(beb parambeb)
  {
    AppMethodBeat.i(263302);
    p.k(parambeb, "$this$toMegaMediaSpec");
    cwr localcwr = new cwr();
    localcwr.fPD = parambeb.fPD;
    localcwr.SIw = parambeb.SIw;
    localcwr.SKL = parambeb.SKL;
    localcwr.zKY = parambeb.zKY;
    AppMethodBeat.o(263302);
    return localcwr;
  }
  
  public static final cwq c(csg paramcsg)
  {
    AppMethodBeat.i(263301);
    p.k(paramcsg, "$this$toLongVideoServer");
    cwq localcwq = new cwq();
    localcwq.url = paramcsg.url;
    localcwq.mediaType = paramcsg.mediaType;
    localcwq.thumbUrl = paramcsg.thumbUrl;
    localcwq.TFq = paramcsg.videoDuration;
    if (paramcsg.TzW == 0L) {}
    for (localcwq.TFr = (paramcsg.videoDuration * 1000L);; localcwq.TFr = paramcsg.TzW)
    {
      localcwq.width = paramcsg.width;
      localcwq.height = paramcsg.height;
      localcwq.md5sum = paramcsg.md5sum;
      localcwq.fileSize = paramcsg.fileSize;
      localcwq.bitrate = paramcsg.bitrate;
      localcwq.decodeKey = paramcsg.decodeKey;
      localcwq.coverUrl = paramcsg.coverUrl;
      LinkedList localLinkedList = localcwq.spec;
      localLinkedList.clear();
      paramcsg = paramcsg.spec;
      p.j(paramcsg, "spec");
      localLinkedList.addAll((Collection)aU(paramcsg));
      AppMethodBeat.o(263301);
      return localcwq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.n
 * JD-Core Version:    0.7.0.1
 */