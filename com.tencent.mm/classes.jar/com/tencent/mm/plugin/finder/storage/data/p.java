package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.protocal.protobuf.aqq;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/MegaVideoOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "id", "", "list", "Ljava/util/LinkedList;", "targetDataType", "plugin-finder_release"})
public final class p
{
  public static final p vGB;
  
  static
  {
    AppMethodBeat.i(252033);
    vGB = new p();
    AppMethodBeat.o(252033);
  }
  
  public static boolean a(long paramLong, LinkedList<aqq> paramLinkedList)
  {
    AppMethodBeat.i(252032);
    kotlin.g.b.p.h(paramLinkedList, "list");
    z.a locala = new z.a();
    locala.SYB = false;
    d.a(paramLinkedList, (b)new a(paramLong, locala));
    boolean bool = locala.SYB;
    AppMethodBeat.o(252032);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class a
    extends q
    implements b<aqq, Boolean>
  {
    a(long paramLong, z.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.p
 * JD-Core Version:    0.7.0.1
 */