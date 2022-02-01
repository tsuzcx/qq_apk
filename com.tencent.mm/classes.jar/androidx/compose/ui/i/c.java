package androidx.compose.ui.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/DepthSortedSet;", "", "extraAssertions", "", "(Z)V", "DepthComparator", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "mapOfOriginalDepth", "", "", "getMapOfOriginalDepth", "()Ljava/util/Map;", "mapOfOriginalDepth$delegate", "Lkotlin/Lazy;", "set", "Landroidx/compose/ui/node/TreeSet;", "add", "", "node", "contains", "isEmpty", "isNotEmpty", "pop", "popEach", "block", "Lkotlin/Function1;", "remove", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final boolean aNS;
  private final j aNT;
  private final Comparator<f> aNU;
  public final af<f> aNV;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(204449);
    this.aNS = paramBoolean;
    this.aNT = k.a(o.aiuH, (a)c.b.aNW);
    this.aNU = ((Comparator)new a());
    this.aNV = new af(this.aNU);
    AppMethodBeat.o(204449);
  }
  
  private final Map<f, Integer> xo()
  {
    AppMethodBeat.i(204457);
    Map localMap = (Map)this.aNT.getValue();
    AppMethodBeat.o(204457);
    return localMap;
  }
  
  public final boolean c(f paramf)
  {
    AppMethodBeat.i(204463);
    s.u(paramf, "node");
    boolean bool = this.aNV.contains(paramf);
    if (this.aNS)
    {
      if (bool == xo().containsKey(paramf)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramf = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(204463);
        throw paramf;
      }
    }
    AppMethodBeat.o(204463);
    return bool;
  }
  
  public final void d(f paramf)
  {
    AppMethodBeat.i(204469);
    s.u(paramf, "node");
    if (!paramf.isAttached())
    {
      paramf = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(204469);
      throw paramf;
    }
    Integer localInteger;
    if (this.aNS)
    {
      localInteger = (Integer)xo().get(paramf);
      if (localInteger != null) {
        break label99;
      }
      xo().put(paramf, Integer.valueOf(paramf.aOm));
    }
    for (;;)
    {
      this.aNV.add(paramf);
      AppMethodBeat.o(204469);
      return;
      label99:
      int i = paramf.aOm;
      if (localInteger.intValue() == i) {}
      for (i = 1; i == 0; i = 0)
      {
        paramf = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(204469);
        throw paramf;
      }
    }
  }
  
  public final void e(f paramf)
  {
    int i = 1;
    AppMethodBeat.i(204473);
    s.u(paramf, "node");
    if (!paramf.isAttached())
    {
      paramf = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(204473);
      throw paramf;
    }
    boolean bool = this.aNV.remove(paramf);
    if (this.aNS)
    {
      Integer localInteger = (Integer)xo().remove(paramf);
      if (bool)
      {
        int j = paramf.aOm;
        if (localInteger == null) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            break label170;
          }
          paramf = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(204473);
          throw paramf;
          if (localInteger.intValue() != j) {
            break;
          }
        }
      }
      if (localInteger == null) {}
      for (i = 1; i == 0; i = 0)
      {
        paramf = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(204473);
        throw paramf;
      }
    }
    label170:
    AppMethodBeat.o(204473);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204479);
    String str = this.aNV.toString();
    s.s(str, "set.toString()");
    AppMethodBeat.o(204479);
    return str;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/node/DepthSortedSet$DepthComparator$1", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "compare", "", "l1", "l2", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Comparator<f>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.c
 * JD-Core Version:    0.7.0.1
 */