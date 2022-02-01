package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/WrapperRenderNodeLayerHelperMethods;", "", "()V", "onDescendantInvalidated", "", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
{
  public static final bf aWc;
  
  static
  {
    AppMethodBeat.i(206857);
    aWc = new bf();
    AppMethodBeat.o(206857);
  }
  
  public final void b(AndroidComposeView paramAndroidComposeView)
  {
    AppMethodBeat.i(206864);
    s.u(paramAndroidComposeView, "ownerView");
    ViewParent localViewParent = paramAndroidComposeView.getParent();
    if (localViewParent != null) {
      localViewParent.onDescendantInvalidated((View)paramAndroidComposeView, (View)paramAndroidComposeView);
    }
    AppMethodBeat.o(206864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.bf
 * JD-Core Version:    0.7.0.1
 */