package androidx.compose.ui.platform;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewVerificationHelperMethods;", "", "()V", "focusable", "", "view", "Landroid/view/View;", "", "defaultFocusHighlightEnabled", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h aSF;
  
  static
  {
    AppMethodBeat.i(206861);
    aSF = new h();
    AppMethodBeat.o(206861);
  }
  
  public final void b(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(206866);
    s.u(paramView, "view");
    paramView.setFocusable(paramInt);
    paramView.setDefaultFocusHighlightEnabled(paramBoolean);
    AppMethodBeat.o(206866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.platform.h
 * JD-Core Version:    0.7.0.1
 */