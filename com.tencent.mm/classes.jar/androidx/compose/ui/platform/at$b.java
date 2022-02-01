package androidx.compose.ui.platform;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindow;", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "()V", "installFor", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at$b
  implements at
{
  public static final b aVn;
  
  static
  {
    AppMethodBeat.i(206583);
    aVn = new b();
    AppMethodBeat.o(206583);
  }
  
  public final a<ah> a(AbstractComposeView paramAbstractComposeView)
  {
    AppMethodBeat.i(206591);
    s.u(paramAbstractComposeView, "view");
    final b localb = new b(paramAbstractComposeView);
    paramAbstractComposeView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)localb);
    paramAbstractComposeView = (a)new a(paramAbstractComposeView, localb);
    AppMethodBeat.o(206591);
    return paramAbstractComposeView;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(AbstractComposeView paramAbstractComposeView, at.b.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements View.OnAttachStateChangeListener
  {
    b(AbstractComposeView paramAbstractComposeView) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(206538);
      s.u(paramView, "v");
      AppMethodBeat.o(206538);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(206546);
      this.aVo.yt();
      AppMethodBeat.o(206546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.at.b
 * JD-Core Version:    0.7.0.1
 */