package androidx.compose.runtime;

import androidx.compose.runtime.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchorIndex", "anchor", "asString", "", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "dataIndexes", "", "groupSizes", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "slotsOf", "group", "slotsOf$runtime_release", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "index", "level", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  implements androidx.compose.runtime.g.a, Iterable<b>, kotlin.g.b.a.a
{
  int[] apB;
  int apC;
  Object[] apD;
  int apE;
  private int apJ;
  boolean apK;
  ArrayList<c> apL;
  int version;
  
  public be()
  {
    AppMethodBeat.i(201997);
    this.apB = new int[0];
    this.apD = new Object[0];
    this.apL = new ArrayList();
    AppMethodBeat.o(201997);
  }
  
  public final void a(bd parambd)
  {
    AppMethodBeat.i(202021);
    s.u(parambd, "reader");
    if ((parambd.anZ == this) && (this.apJ > 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      parambd = (Throwable)new IllegalArgumentException("Unexpected reader close()".toString());
      AppMethodBeat.o(202021);
      throw parambd;
    }
    this.apJ -= 1;
    AppMethodBeat.o(202021);
  }
  
  public final void a(bg parambg, int[] paramArrayOfInt, int paramInt1, Object[] paramArrayOfObject, int paramInt2, ArrayList<c> paramArrayList)
  {
    AppMethodBeat.i(202027);
    s.u(parambg, "writer");
    s.u(paramArrayOfInt, "groups");
    s.u(paramArrayOfObject, "slots");
    s.u(paramArrayList, "anchors");
    if ((parambg.anZ == this) && (this.apK)) {}
    for (int i = 1; i == 0; i = 0)
    {
      parambg = (Throwable)new IllegalArgumentException("Unexpected writer close()".toString());
      AppMethodBeat.o(202027);
      throw parambg;
    }
    this.apK = false;
    a(paramArrayOfInt, paramInt1, paramArrayOfObject, paramInt2, paramArrayList);
    AppMethodBeat.o(202027);
  }
  
  public final void a(int[] paramArrayOfInt, int paramInt1, Object[] paramArrayOfObject, int paramInt2, ArrayList<c> paramArrayList)
  {
    AppMethodBeat.i(202031);
    s.u(paramArrayOfInt, "groups");
    s.u(paramArrayOfObject, "slots");
    s.u(paramArrayList, "anchors");
    this.apB = paramArrayOfInt;
    this.apC = paramInt1;
    this.apD = paramArrayOfObject;
    this.apE = paramInt2;
    this.apL = paramArrayList;
    AppMethodBeat.o(202031);
  }
  
  public final boolean isEmpty()
  {
    return this.apC == 0;
  }
  
  public final Iterator<b> iterator()
  {
    AppMethodBeat.i(202039);
    Iterator localIterator = (Iterator)new ac(this, 0, this.apC);
    AppMethodBeat.o(202039);
    return localIterator;
  }
  
  public final bd pW()
  {
    AppMethodBeat.i(202008);
    if (this.apK)
    {
      localObject = (Throwable)new IllegalStateException("Cannot read while a writer is pending".toString());
      AppMethodBeat.o(202008);
      throw ((Throwable)localObject);
    }
    this.apJ += 1;
    Object localObject = new bd(this);
    AppMethodBeat.o(202008);
    return localObject;
  }
  
  public final bg pX()
  {
    int j = 0;
    AppMethodBeat.i(202015);
    if (!this.apK) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("Cannot start a writer when another writer is pending".toString());
      localObject = new f();
      AppMethodBeat.o(202015);
      throw ((Throwable)localObject);
    }
    i = j;
    if (this.apJ <= 0) {
      i = 1;
    }
    if (i == 0)
    {
      j.ah("Cannot start a writer when a reader is pending".toString());
      localObject = new f();
      AppMethodBeat.o(202015);
      throw ((Throwable)localObject);
    }
    this.apK = true;
    this.version += 1;
    Object localObject = new bg(this);
    AppMethodBeat.o(202015);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.be
 * JD-Core Version:    0.7.0.1
 */