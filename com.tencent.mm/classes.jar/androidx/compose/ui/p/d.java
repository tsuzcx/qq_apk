package androidx.compose.ui.p;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.l;
import androidx.compose.ui.platform.AbstractComposeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "T", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;)V", "value", "Lkotlin/Function1;", "factory", "getFactory", "()Lkotlin/jvm/functions/Function1;", "setFactory", "(Lkotlin/jvm/functions/Function1;)V", "typedView", "getTypedView$ui_release", "()Landroid/view/View;", "setTypedView$ui_release", "(Landroid/view/View;)V", "Landroid/view/View;", "", "updateBlock", "getUpdateBlock", "setUpdateBlock", "viewRoot", "getViewRoot", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T extends View>
  extends a
{
  private b<? super T, ah> bfA;
  private T bfy;
  private b<? super Context, ? extends T> bfz;
  
  public d(Context paramContext, l paraml)
  {
    super(paramContext, paraml);
    AppMethodBeat.i(204431);
    this.bfA = c.Ck();
    AppMethodBeat.o(204431);
  }
  
  public final b<Context, T> getFactory()
  {
    return this.bfz;
  }
  
  public final AbstractComposeView getSubCompositionView()
  {
    AppMethodBeat.i(204460);
    s.u(this, "this");
    AppMethodBeat.o(204460);
    return null;
  }
  
  public final T getTypedView$ui_release()
  {
    return this.bfy;
  }
  
  public final b<T, ah> getUpdateBlock()
  {
    return this.bfA;
  }
  
  public final View getViewRoot()
  {
    return (View)this;
  }
  
  public final void setFactory(b<? super Context, ? extends T> paramb)
  {
    AppMethodBeat.i(204447);
    this.bfz = paramb;
    if (paramb != null)
    {
      Context localContext = getContext();
      s.s(localContext, "context");
      this.bfy = ((View)paramb.invoke(localContext));
      setView$ui_release(this.bfy);
    }
    AppMethodBeat.o(204447);
  }
  
  public final void setTypedView$ui_release(T paramT)
  {
    this.bfy = paramT;
  }
  
  public final void setUpdateBlock(b<? super T, ah> paramb)
  {
    AppMethodBeat.i(204454);
    s.u(paramb, "value");
    this.bfA = paramb;
    setUpdate((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(204454);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(d<T> paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.p.d
 * JD-Core Version:    0.7.0.1
 */