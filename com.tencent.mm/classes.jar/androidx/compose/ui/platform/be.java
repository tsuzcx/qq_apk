package androidx.compose.ui.platform;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import androidx.compose.runtime.aw;
import androidx.compose.runtime.l;
import androidx.compose.ui.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"value", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "createLifecycleAwareViewTreeRecomposer", "findViewTreeCompositionContext", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class be
{
  static final View A(View paramView)
  {
    AppMethodBeat.i(206850);
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView instanceof View); paramView = localView.getParent())
    {
      if (((View)paramView).getId() == 16908290)
      {
        AppMethodBeat.o(206850);
        return localView;
      }
      localView = (View)paramView;
    }
    AppMethodBeat.o(206850);
    return localView;
  }
  
  public static final void a(View paramView, l paraml)
  {
    AppMethodBeat.i(206843);
    s.u(paramView, "<this>");
    paramView.setTag(g.a.androidx_compose_ui_view_composition_context, paraml);
    AppMethodBeat.o(206843);
  }
  
  public static final l z(View paramView)
  {
    AppMethodBeat.i(206835);
    s.u(paramView, "<this>");
    paramView = paramView.getTag(g.a.androidx_compose_ui_view_composition_context);
    if ((paramView instanceof l))
    {
      paramView = (l)paramView;
      AppMethodBeat.o(206835);
      return paramView;
    }
    AppMethodBeat.o(206835);
    return null;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/platform/WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(View paramView, aw paramaw) {}
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(206794);
      this.aVS.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
      this.aVT.cancel();
      AppMethodBeat.o(206794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.be
 * JD-Core Version:    0.7.0.1
 */