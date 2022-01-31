package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class CustomSmileyPreviewUI$6
  implements Runnable
{
  CustomSmileyPreviewUI$6(CustomSmileyPreviewUI paramCustomSmileyPreviewUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(138343);
    if (bo.isNullOrNil(this.lgI))
    {
      ab.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
      AppMethodBeat.o(138343);
      return;
    }
    if ((CustomSmileyPreviewUI.q(this.lkP) != null) && (CustomSmileyPreviewUI.q(this.lkP).leO != null))
    {
      CustomSmileyPreviewUI.q(this.lkP).bY(this.lgI, this.gQj);
      CustomSmileyPreviewUI.q(this.lkP).refreshView();
    }
    AppMethodBeat.o(138343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.6
 * JD-Core Version:    0.7.0.1
 */