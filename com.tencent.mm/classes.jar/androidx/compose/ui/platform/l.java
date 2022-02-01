package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.platform.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidTextToolbar;", "Landroidx/compose/ui/platform/TextToolbar;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "actionMode", "Landroid/view/ActionMode;", "<set-?>", "Landroidx/compose/ui/platform/TextToolbarStatus;", "status", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "textActionModeCallback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/ActionCallback;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements ao
{
  private final a aSY;
  private ap aSZ;
  private final View view;
  
  public l(View paramView)
  {
    AppMethodBeat.i(206896);
    this.view = paramView;
    this.aSY = new a();
    this.aSZ = ap.aVj;
    AppMethodBeat.o(206896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.platform.l
 * JD-Core Version:    0.7.0.1
 */