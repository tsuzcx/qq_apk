package androidx.compose.ui.k;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.e.a;
import androidx.compose.ui.i.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNodeWrapper", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "mergingEnabled", "", "(Landroidx/compose/ui/semantics/SemanticsWrapper;Z)V", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "getBoundsInWindow", "children", "", "getChildren", "()Ljava/util/List;", "config", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "id", "", "getId", "()I", "isFake", "isFake$ui_release", "()Z", "setFake$ui_release", "(Z)V", "isMergingSemanticsOfDescendants", "isRoot", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getMergingEnabled", "getOuterSemanticsNodeWrapper$ui_release", "()Landroidx/compose/ui/semantics/SemanticsWrapper;", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "()J", "positionInWindow", "getPositionInWindow-F1C5BW0", "replacedChildren", "getReplacedChildren$ui_release", "replacedChildrenSortedByBounds", "getReplacedChildrenSortedByBounds$ui_release", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "unmergedConfig", "getUnmergedConfig$ui_release", "emitFakeNodes", "", "unmergedChildren", "", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "findOneLayerOfMergingSemanticsNodes", "list", "sortByBounds", "findWrapperToGetBounds", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "includeReplacedSemantics", "mergeConfig", "mergedConfig", "unmergedChildren$ui_release", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final int Ue = 8;
  public final f aOb;
  public final j aSy;
  public final w aXn;
  private final boolean aXo;
  private o aXp;
  public final int id;
  public boolean isFake;
  
  public o(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(205488);
    this.aXn = paramw;
    this.aXo = paramBoolean;
    this.aSy = this.aXn.AE();
    this.id = ((l)this.aXn.wb()).getId();
    this.aOb = this.aXn.aOb;
    AppMethodBeat.o(205488);
  }
  
  private final boolean Ab()
  {
    return (this.aXo) && (this.aSy.aXd);
  }
  
  private final o a(g paramg, b<? super u, ah> paramb)
  {
    AppMethodBeat.i(205516);
    androidx.compose.ui.i.j localj = new f(true).aOC;
    if (paramg != null) {}
    for (int i = this.id + 1000000000;; i = this.id + 2000000000)
    {
      paramg = new o(new w(localj, (l)new m(i, false, paramb)), false);
      paramg.isFake = true;
      paramg.aXp = this;
      AppMethodBeat.o(205516);
      return paramg;
    }
  }
  
  private List<o> az(boolean paramBoolean)
  {
    AppMethodBeat.i(205504);
    Object localObject;
    if (this.isFake)
    {
      localObject = (List)ab.aivy;
      AppMethodBeat.o(205504);
      return localObject;
    }
    List localList = (List)new ArrayList();
    int k;
    if (paramBoolean)
    {
      localObject = v.c(this.aOb, (List)new ArrayList());
      k = ((List)localObject).size() - 1;
      if (k < 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localList.add(new o((w)((List)localObject).get(i), this.aXo));
      if (j > k)
      {
        localObject = this.aSy;
        r localr = r.aXu;
        localObject = (g)k.a((j)localObject, r.At());
        if ((localObject != null) && (this.aSy.aXd))
        {
          if (((Collection)localList).isEmpty()) {
            break label348;
          }
          i = 1;
          label175:
          if (i != 0) {
            localList.add(a((g)localObject, (b)new o.a((g)localObject)));
          }
        }
        localObject = this.aSy;
        localr = r.aXu;
        if (((j)localObject).b(r.Af()))
        {
          if (((Collection)localList).isEmpty()) {
            break label353;
          }
          i = 1;
          label242:
          if ((i != 0) && (this.aSy.aXd))
          {
            localObject = this.aSy;
            localr = r.aXu;
            localObject = (List)k.a((j)localObject, r.Af());
            if (localObject != null) {
              break label358;
            }
          }
        }
        label348:
        label353:
        label358:
        for (localObject = null;; localObject = (String)kotlin.a.p.oL((List)localObject))
        {
          if (localObject != null) {
            localList.add(0, a(null, (b)new o.b((String)localObject)));
          }
          AppMethodBeat.o(205504);
          return localList;
          localObject = p.b(this.aOb, (List)new ArrayList());
          break;
          i = 0;
          break label175;
          i = 0;
          break label242;
        }
      }
    }
  }
  
  private final List<o> b(List<o> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(205508);
    List localList = az(paramBoolean);
    int k = localList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      o localo = (o)localList.get(i);
      if (localo.Ab()) {
        paramList.add(localo);
      }
      while (j > k)
      {
        AppMethodBeat.o(205508);
        return paramList;
        if (!localo.aSy.aXe) {
          a(localo, paramList, false, 2);
        }
      }
    }
  }
  
  private final void b(j paramj)
  {
    int i = 0;
    AppMethodBeat.i(205494);
    List localList;
    int k;
    if (!this.aSy.aXe)
    {
      localList = az(false);
      k = localList.size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      o localo = (o)localList.get(i);
      if ((!localo.isFake) && (!localo.Ab()))
      {
        paramj.a(localo.aSy);
        localo.b(paramj);
      }
      if (j > k)
      {
        AppMethodBeat.o(205494);
        return;
      }
      i = j;
    }
  }
  
  public final j Aa()
  {
    AppMethodBeat.i(205537);
    if (Ab())
    {
      localj = this.aSy.zU();
      b(localj);
      AppMethodBeat.o(205537);
      return localj;
    }
    j localj = this.aSy;
    AppMethodBeat.o(205537);
    return localj;
  }
  
  public final o Ac()
  {
    AppMethodBeat.i(205547);
    if (this.aXp != null)
    {
      localObject1 = this.aXp;
      AppMethodBeat.o(205547);
      return localObject1;
    }
    if (this.aXo) {}
    for (Object localObject1 = p.a(this.aOb, (b)c.aXr);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = p.a(this.aOb, (b)d.aXs);
      }
      if (localObject2 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = p.G((f)localObject2))
      {
        AppMethodBeat.o(205547);
        return null;
      }
      localObject1 = new o((w)localObject1, this.aXo);
      AppMethodBeat.o(205547);
      return localObject1;
    }
  }
  
  public final androidx.compose.ui.i.j Ad()
  {
    AppMethodBeat.i(205556);
    if (this.aSy.aXd)
    {
      w localw = p.H(this.aOb);
      localObject = localw;
      if (localw == null) {
        localObject = this.aXn;
      }
      localObject = (androidx.compose.ui.i.j)localObject;
      AppMethodBeat.o(205556);
      return localObject;
    }
    Object localObject = (androidx.compose.ui.i.j)this.aXn;
    AppMethodBeat.o(205556);
    return localObject;
  }
  
  public final List<o> aA(boolean paramBoolean)
  {
    AppMethodBeat.i(205542);
    if (this.aSy.aXe)
    {
      localList = (List)ab.aivy;
      AppMethodBeat.o(205542);
      return localList;
    }
    if (Ab())
    {
      localList = a(this, null, paramBoolean, 1);
      AppMethodBeat.o(205542);
      return localList;
    }
    List localList = az(paramBoolean);
    AppMethodBeat.o(205542);
    return localList;
  }
  
  public final androidx.compose.ui.d.g zX()
  {
    AppMethodBeat.i(205523);
    if (!this.aOb.isAttached())
    {
      localObject = androidx.compose.ui.d.g.avs;
      localObject = androidx.compose.ui.d.g.sy();
      AppMethodBeat.o(205523);
      return localObject;
    }
    Object localObject = androidx.compose.ui.h.k.d((androidx.compose.ui.h.j)Ad());
    AppMethodBeat.o(205523);
    return localObject;
  }
  
  public final androidx.compose.ui.d.g zY()
  {
    AppMethodBeat.i(205526);
    if (!this.aOb.isAttached())
    {
      localObject = androidx.compose.ui.d.g.avs;
      localObject = androidx.compose.ui.d.g.sy();
      AppMethodBeat.o(205526);
      return localObject;
    }
    Object localObject = androidx.compose.ui.h.k.e((androidx.compose.ui.h.j)Ad());
    AppMethodBeat.o(205526);
    return localObject;
  }
  
  public final long zZ()
  {
    AppMethodBeat.i(205531);
    if (!this.aOb.isAttached())
    {
      e.a locala = e.avo;
      l = e.su();
      AppMethodBeat.o(205531);
      return l;
    }
    long l = androidx.compose.ui.h.k.c((androidx.compose.ui.h.j)Ad());
    AppMethodBeat.o(205531);
    return l;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements b<f, Boolean>
  {
    public static final c aXr;
    
    static
    {
      AppMethodBeat.i(205485);
      aXr = new c();
      AppMethodBeat.o(205485);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements b<f, Boolean>
  {
    public static final d aXs;
    
    static
    {
      AppMethodBeat.i(205484);
      aXs = new d();
      AppMethodBeat.o(205484);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.o
 * JD-Core Version:    0.7.0.1
 */