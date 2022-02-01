package com.tencent.mm.plugin.finder.view;

import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
final class FinderBottomCustomDialogHelper$Companion$showConfirmTextDialog$3
  implements e.b
{
  FinderBottomCustomDialogHelper$Companion$showConfirmTextDialog$3(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(277632);
    DialogInterface.OnDismissListener localOnDismissListener = this.$ldismiss;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss(null);
      AppMethodBeat.o(277632);
      return;
    }
    AppMethodBeat.o(277632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog.3
 * JD-Core Version:    0.7.0.1
 */