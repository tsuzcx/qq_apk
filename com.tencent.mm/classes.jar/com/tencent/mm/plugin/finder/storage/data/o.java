package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.protocal.protobuf.asm;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/MegaVideoOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "id", "", "list", "Ljava/util/LinkedList;", "targetDataType", "plugin-finder_release"})
public final class o
{
  public static final o Anz;
  
  static
  {
    AppMethodBeat.i(288170);
    Anz = new o();
    AppMethodBeat.o(288170);
  }
  
  public static boolean a(long paramLong, LinkedList<asm> paramLinkedList)
  {
    AppMethodBeat.i(288169);
    p.k(paramLinkedList, "list");
    aa.a locala = new aa.a();
    locala.aaBx = false;
    d.a(paramLinkedList, (b)new a(paramLong, locala));
    boolean bool = locala.aaBx;
    AppMethodBeat.o(288169);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class a
    extends q
    implements b<asm, Boolean>
  {
    a(long paramLong, aa.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.o
 * JD-Core Version:    0.7.0.1
 */