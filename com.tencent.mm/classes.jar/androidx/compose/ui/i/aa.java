package androidx.compose.ui.i;

import androidx.compose.runtime.a.c;
import androidx.compose.runtime.a.d;
import androidx.compose.runtime.a.e;
import androidx.compose.runtime.f.u.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/OwnerSnapshotObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "observer", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onCommitAffectingLayout", "Landroidx/compose/ui/node/LayoutNode;", "onCommitAffectingMeasure", "clear", "target", "clear$ui_release", "clearInvalidObservations", "clearInvalidObservations$ui_release", "observeLayoutSnapshotReads", "node", "block", "observeLayoutSnapshotReads$ui_release", "observeMeasureSnapshotReads", "observeMeasureSnapshotReads$ui_release", "observeReads", "T", "Landroidx/compose/ui/node/OwnerScope;", "onChanged", "observeReads$ui_release", "(Landroidx/compose/ui/node/OwnerScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "startObserving", "startObserving$ui_release", "stopObserving", "stopObserving$ui_release", "withNoSnapshotReadObservation", "withNoSnapshotReadObservation$ui_release", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public final androidx.compose.runtime.f.u aQm;
  final b<f, ah> aQn;
  private final b<f, ah> aQo;
  
  public aa(b<? super a<ah>, ah> paramb)
  {
    AppMethodBeat.i(204565);
    this.aQm = new androidx.compose.runtime.f.u(paramb);
    this.aQn = ((b)c.aQr);
    this.aQo = ((b)b.aQq);
    AppMethodBeat.o(204565);
  }
  
  public final void a(f paramf, a<ah> parama)
  {
    AppMethodBeat.i(204582);
    s.u(paramf, "node");
    s.u(parama, "block");
    a((z)paramf, this.aQo, parama);
    AppMethodBeat.o(204582);
  }
  
  public final <T extends z> void a(T paramT, b<? super T, ah> paramb, a<ah> parama)
  {
    AppMethodBeat.i(204586);
    s.u(paramT, "target");
    s.u(paramb, "onChanged");
    s.u(parama, "block");
    this.aQm.a(paramT, paramb, parama);
    AppMethodBeat.o(204586);
  }
  
  public final void k(a<ah> parama)
  {
    AppMethodBeat.i(204573);
    s.u(parama, "block");
    this.aQm.h(parama);
    AppMethodBeat.o(204573);
  }
  
  public final void yo()
  {
    AppMethodBeat.i(204599);
    Object localObject3 = this.aQm;
    Object localObject1 = (b)a.aQp;
    s.u(localObject1, "predicate");
    int i4;
    int j;
    d locald;
    int k;
    int i5;
    int m;
    int i2;
    int i6;
    c localc;
    int n;
    int i7;
    int i1;
    int i3;
    Object localObject4;
    synchronized (((androidx.compose.runtime.f.u)localObject3).atf)
    {
      localObject3 = ((androidx.compose.runtime.f.u)localObject3).atf;
      i4 = ((e)localObject3).size;
      if (i4 <= 0) {
        break label386;
      }
      localObject3 = ((e)localObject3).aqq;
      j = 0;
      locald = ((u.a)localObject3[j]).atk;
      i = 0;
      k = 0;
      i5 = locald.size;
      if (i5 <= 0) {
        break label329;
      }
      m = 0;
      i2 = m + 1;
      i6 = locald.aqo[m];
      localc = locald.aqp[i6];
      s.checkNotNull(localc);
      i = 0;
      n = 0;
      i7 = localc.size();
      if (i7 <= 0) {
        break label240;
      }
      i1 = 0;
      i3 = i1 + 1;
      localObject4 = localc.aqm[i1];
      if (localObject4 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        AppMethodBeat.o(204599);
        throw ((Throwable)localObject1);
      }
    }
    int i = n;
    if (!((Boolean)localObject2.invoke(localObject4)).booleanValue()) {
      if (n != i1)
      {
        localc.aqm[n] = localObject4;
        break label435;
        label240:
        i3 = localc.size();
        if (i < i3)
        {
          n = i;
          label256:
          i1 = n + 1;
          localc.aqm[n] = null;
          if (i1 < i3) {}
        }
        else
        {
          localc.size = i;
          i = k;
          if (localc.size() <= 0) {
            break label454;
          }
          if (k == m) {
            break label450;
          }
          i = locald.aqo[k];
          locald.aqo[k] = i6;
          locald.aqo[m] = i;
          break label450;
        }
      }
    }
    for (;;)
    {
      label329:
      n = locald.size;
      if (i < n) {}
      for (k = i;; k = m)
      {
        m = k + 1;
        locald.aqm[locald.aqo[k]] = null;
        if (m >= n)
        {
          locald.size = i;
          j += 1;
          if (j >= i4)
          {
            label386:
            ah localah = ah.aiuX;
            AppMethodBeat.o(204599);
            return;
          }
          break;
        }
      }
      label435:
      label450:
      label454:
      do
      {
        m = i2;
        k = i;
        break;
        n = i1;
        break label256;
        do
        {
          i1 = i3;
          n = i;
          break;
          i = n + 1;
        } while (i3 < i7);
        break label240;
        i = k + 1;
      } while (i2 < i5);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements b<Object, Boolean>
  {
    public static final a aQp;
    
    static
    {
      AppMethodBeat.i(204678);
      aQp = new a();
      AppMethodBeat.o(204678);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements b<f, ah>
  {
    public static final b aQq;
    
    static
    {
      AppMethodBeat.i(204676);
      aQq = new b();
      AppMethodBeat.o(204676);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements b<f, ah>
  {
    public static final c aQr;
    
    static
    {
      AppMethodBeat.i(204650);
      aQr = new c();
      AppMethodBeat.o(204650);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.aa
 * JD-Core Version:    0.7.0.1
 */