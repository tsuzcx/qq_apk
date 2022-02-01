package androidx.compose.ui.g.b;

import androidx.compose.ui.f.c;
import androidx.compose.ui.i.f;
import androidx.compose.ui.i.j;
import androidx.compose.ui.i.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "nestedScrollModifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;)V", "childScrollConnection", "Landroidx/compose/ui/input/nestedscroll/ParentWrapperNestedScrollConnection;", "value", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScopeEvaluation", "getCoroutineScopeEvaluation", "()Lkotlin/jvm/functions/Function0;", "setCoroutineScopeEvaluation", "(Lkotlin/jvm/functions/Function0;)V", "lastModifier", "modifier", "getModifier", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;", "setModifier", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;)V", "nestedScrollChildrenResult", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "parentConnection", "setParentConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "attach", "", "detach", "findNextNestedScrollWrapper", "findPreviousNestedScrollWrapper", "loopChildrenForNestedScroll", "children", "Landroidx/compose/ui/node/LayoutNode;", "onModifierChanged", "refreshChildrenWithParentConnection", "newParent", "refreshSelfIfNeeded", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends androidx.compose.ui.i.b<e>
{
  private a aKs;
  private e aKt;
  private final h aKu;
  private final androidx.compose.runtime.a.e<b> aKv;
  
  public b(j paramj, e parame)
  {
    super(paramj, (f.c)parame);
    AppMethodBeat.i(205734);
    a locala = this.aKs;
    paramj = locala;
    if (locala == null) {
      paramj = c.wc();
    }
    this.aKu = new h(paramj, parame.wf());
    this.aKv = new androidx.compose.runtime.a.e(new b[16]);
    AppMethodBeat.o(205734);
  }
  
  private final void a(androidx.compose.runtime.a.e<f> parame)
  {
    AppMethodBeat.i(205770);
    int j = parame.size;
    int i;
    if (j > 0)
    {
      parame = parame.aqq;
      i = 0;
    }
    for (;;)
    {
      f localf = (f)parame[i];
      b localb = localf.aOD.aPZ.vZ();
      if (localb != null) {
        this.aKv.add(localb);
      }
      for (;;)
      {
        i += 1;
        if (i < j) {
          break;
        }
        AppMethodBeat.o(205770);
        return;
        a(localf.xr());
      }
    }
  }
  
  private final void b(a parama)
  {
    AppMethodBeat.i(205742);
    ((e)super.wb()).we().aKB = parama;
    h localh = this.aKu;
    if (parama == null) {}
    for (a locala = c.wc();; locala = parama)
    {
      s.u(locala, "<set-?>");
      localh.aKB = locala;
      this.aKs = parama;
      AppMethodBeat.o(205742);
      return;
    }
  }
  
  private final void c(a parama)
  {
    AppMethodBeat.i(205764);
    this.aKv.clear();
    b localb1 = this.aNN.vZ();
    label60:
    Object localObject;
    int j;
    Object[] arrayOfObject;
    int i;
    if (localb1 != null)
    {
      this.aKv.add(localb1);
      if (!this.aKv.qn()) {
        break label153;
      }
      localb1 = (b)this.aKv.aqq[0];
      localObject = this.aKv;
      j = ((androidx.compose.runtime.a.e)localObject).size;
      if (j > 0)
      {
        arrayOfObject = ((androidx.compose.runtime.a.e)localObject).aqq;
        i = 0;
      }
    }
    label153:
    label176:
    for (;;)
    {
      b localb2 = (b)arrayOfObject[i];
      localb2.b(parama);
      if (parama != null) {}
      for (localObject = (kotlin.g.a.a)new a(this);; localObject = (kotlin.g.a.a)new b(localb1))
      {
        localb2.j((kotlin.g.a.a)localObject);
        i += 1;
        if (i < j) {
          break label176;
        }
        AppMethodBeat.o(205764);
        return;
        a(this.aOb.xr());
        break;
        localb1 = null;
        break label60;
      }
    }
  }
  
  private final void j(kotlin.g.a.a<? extends aq> parama)
  {
    AppMethodBeat.i(205750);
    d locald = ((e)super.wb()).we();
    s.u(parama, "<set-?>");
    locald.aKz = parama;
    AppMethodBeat.o(205750);
  }
  
  private final kotlin.g.a.a<aq> vU()
  {
    AppMethodBeat.i(205747);
    kotlin.g.a.a locala = ((e)super.wb()).we().aKz;
    AppMethodBeat.o(205747);
    return locala;
  }
  
  private final void wa()
  {
    AppMethodBeat.i(205758);
    Object localObject = this.aKt;
    int i;
    b localb;
    if ((localObject == null) || (((e)localObject).wf() != ((e)super.wb()).wf()) || (((e)localObject).we() != ((e)super.wb()).we()))
    {
      i = 1;
      if ((i != 0) && (isAttached()))
      {
        localb = super.vY();
        if (localb != null) {
          break label135;
        }
        localObject = null;
        label80:
        b((a)localObject);
        if (localb != null) {
          break label143;
        }
      }
    }
    label135:
    label143:
    for (localObject = vU();; localObject = localb.vU())
    {
      j((kotlin.g.a.a)localObject);
      c((a)this.aKu);
      this.aKt = ((e)super.wb());
      AppMethodBeat.o(205758);
      return;
      i = 0;
      break;
      localObject = localb.aKu;
      break label80;
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(205792);
    super.detach();
    c(this.aKs);
    this.aKt = null;
    AppMethodBeat.o(205792);
  }
  
  public final void vV()
  {
    AppMethodBeat.i(205778);
    super.vV();
    h localh = this.aKu;
    a locala = ((e)super.wb()).wf();
    s.u(locala, "<set-?>");
    localh.aKP = locala;
    ((e)super.wb()).we().aKB = this.aKs;
    wa();
    AppMethodBeat.o(205778);
  }
  
  public final e vW()
  {
    AppMethodBeat.i(369518);
    e locale = (e)super.wb();
    AppMethodBeat.o(369518);
    return locale;
  }
  
  public final void vX()
  {
    AppMethodBeat.i(205788);
    super.vX();
    wa();
    AppMethodBeat.o(205788);
  }
  
  public final b vY()
  {
    return this;
  }
  
  public final b vZ()
  {
    return this;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<aq>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<aq>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.b.b
 * JD-Core Version:    0.7.0.1
 */