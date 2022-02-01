package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.h;
import androidx.compose.ui.g.a;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/WrappedComposition;", "Landroidx/compose/runtime/Composition;", "Landroidx/lifecycle/LifecycleEventObserver;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "original", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/Composition;)V", "addedToLifecycle", "Landroidx/lifecycle/Lifecycle;", "disposed", "", "hasInvalidations", "getHasInvalidations", "()Z", "isDisposed", "lastContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "getOriginal", "()Landroidx/compose/runtime/Composition;", "getOwner", "()Landroidx/compose/ui/platform/AndroidComposeView;", "dispose", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setContent", "content", "(Lkotlin/jvm/functions/Function2;)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class WrappedComposition
  implements androidx.compose.runtime.k, o
{
  final AndroidComposeView aVX;
  final androidx.compose.runtime.k aVY;
  private j aVZ;
  private m<? super h, ? super Integer, ah> aWa;
  private boolean anC;
  
  public WrappedComposition(AndroidComposeView paramAndroidComposeView, androidx.compose.runtime.k paramk)
  {
    AppMethodBeat.i(206662);
    this.aVX = paramAndroidComposeView;
    this.aVY = paramk;
    paramAndroidComposeView = t.aTq;
    this.aWa = t.wE();
    AppMethodBeat.o(206662);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(206681);
    if (!this.anC)
    {
      this.anC = true;
      this.aVX.getView().setTag(g.a.wrapped_composition_tag, null);
      j localj = this.aVZ;
      if (localj != null) {
        localj.removeObserver((p)this);
      }
    }
    this.aVY.dispose();
    AppMethodBeat.o(206681);
  }
  
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(206695);
    s.u(paramq, "source");
    s.u(parama, "event");
    if (parama == j.a.ON_DESTROY)
    {
      dispose();
      AppMethodBeat.o(206695);
      return;
    }
    if ((parama == j.a.ON_CREATE) && (!this.anC)) {
      setContent(this.aWa);
    }
    AppMethodBeat.o(206695);
  }
  
  public final boolean pa()
  {
    AppMethodBeat.i(206686);
    boolean bool = this.aVY.pa();
    AppMethodBeat.o(206686);
    return bool;
  }
  
  public final boolean pb()
  {
    AppMethodBeat.i(206692);
    boolean bool = this.aVY.pb();
    AppMethodBeat.o(206692);
    return bool;
  }
  
  public final void setContent(final m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(206678);
    s.u(paramm, "content");
    this.aVX.setOnViewTreeOwnersAvailable((b)new a(this, paramm));
    AppMethodBeat.o(206678);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<AndroidComposeView.b, ah>
  {
    a(WrappedComposition paramWrappedComposition, m<? super h, ? super Integer, ah> paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.WrappedComposition
 * JD-Core Version:    0.7.0.1
 */