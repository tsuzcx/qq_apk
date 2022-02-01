package com.tencent.mm.openim.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/view/BaseDialogModel;", "", "dismissDialog", "", "exitType", "", "isShowingDialog", "", "onPause", "onResume", "showDialog", "Companion", "OnCloseClickListener", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a puL = a.puM;
  
  public abstract void xM(int paramInt);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/view/BaseDialogModel$Companion;", "", "()V", "CLOSE_TYPE_BACK_PRESSED", "", "CLOSE_TYPE_CLICK_CLOSE_BUTTON", "CLOSE_TYPE_DEFAULT", "CLOSE_TYPE_SCROLL_DOWN", "CLOSE_TYPE_SCROLL_LEFT", "CLOSE_TYPE_TOUCH_OUTSIDE", "DIALOG_STATE_DEFAULT", "DIALOG_STATE_FULL_SCREEN", "DIALOG_STATE_HALF_SCREEN", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(235946);
      puM = new a();
      AppMethodBeat.o(235946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.ui.view.a
 * JD-Core Version:    0.7.0.1
 */