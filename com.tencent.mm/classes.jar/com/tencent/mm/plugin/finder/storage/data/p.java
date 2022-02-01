package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.protocal.protobuf.axb;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/MegaVideoOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "id", "", "list", "Ljava/util/LinkedList;", "targetDataType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p FNp;
  
  static
  {
    AppMethodBeat.i(339325);
    FNp = new p();
    AppMethodBeat.o(339325);
  }
  
  public static boolean a(long paramLong, LinkedList<axb> paramLinkedList)
  {
    AppMethodBeat.i(339319);
    s.u(paramLinkedList, "list");
    ah.a locala = new ah.a();
    d.a(paramLinkedList, (b)new a(paramLong, locala));
    boolean bool = locala.aiwY;
    AppMethodBeat.o(339319);
    return bool;
  }
  
  public static int fac()
  {
    return 2;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<axb, Boolean>
  {
    a(long paramLong, ah.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.p
 * JD-Core Version:    0.7.0.1
 */