package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.coe;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"toLongVideoServer", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Ljava/util/LinkedList;", "toMegaMediaSpec", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMediaSpec;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "toServer", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "plugin-finder_release"})
public final class o
{
  public static final LinkedList<cod> aC(LinkedList<cjl> paramLinkedList)
  {
    AppMethodBeat.i(252027);
    p.h(paramLinkedList, "$this$toLongVideoServer");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(d((cjl)paramLinkedList.next()));
    }
    AppMethodBeat.o(252027);
    return localLinkedList;
  }
  
  private static LinkedList<coe> aD(LinkedList<ayh> paramLinkedList)
  {
    AppMethodBeat.i(252030);
    p.h(paramLinkedList, "$this$toMegaMediaSpec");
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      localLinkedList.add(b((ayh)paramLinkedList.next()));
    }
    AppMethodBeat.o(252030);
    return localLinkedList;
  }
  
  private static coe b(ayh paramayh)
  {
    AppMethodBeat.i(252029);
    p.h(paramayh, "$this$toMegaMediaSpec");
    coe localcoe = new coe();
    localcoe.dVY = paramayh.dVY;
    localcoe.LEL = paramayh.LEL;
    localcoe.LGa = paramayh.LGa;
    localcoe.uUI = paramayh.uUI;
    AppMethodBeat.o(252029);
    return localcoe;
  }
  
  public static final cod d(cjl paramcjl)
  {
    AppMethodBeat.i(252028);
    p.h(paramcjl, "$this$toLongVideoServer");
    cod localcod = new cod();
    localcod.url = paramcjl.url;
    localcod.mediaType = paramcjl.mediaType;
    localcod.thumbUrl = paramcjl.thumbUrl;
    localcod.Mur = paramcjl.videoDuration;
    if (paramcjl.MoQ == 0L) {}
    for (localcod.Mus = (paramcjl.videoDuration * 1000L);; localcod.Mus = paramcjl.MoQ)
    {
      localcod.width = paramcjl.width;
      localcod.height = paramcjl.height;
      localcod.md5sum = paramcjl.md5sum;
      localcod.fileSize = paramcjl.fileSize;
      localcod.bitrate = paramcjl.bitrate;
      localcod.decodeKey = paramcjl.decodeKey;
      localcod.coverUrl = paramcjl.coverUrl;
      LinkedList localLinkedList = localcod.spec;
      localLinkedList.clear();
      paramcjl = paramcjl.spec;
      p.g(paramcjl, "spec");
      localLinkedList.addAll((Collection)aD(paramcjl));
      AppMethodBeat.o(252028);
      return localcod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.o
 * JD-Core Version:    0.7.0.1
 */