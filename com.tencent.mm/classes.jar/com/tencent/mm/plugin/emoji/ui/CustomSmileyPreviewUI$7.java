package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class CustomSmileyPreviewUI$7
  implements Runnable
{
  CustomSmileyPreviewUI$7(CustomSmileyPreviewUI paramCustomSmileyPreviewUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(53227);
    if (bo.isNullOrNil(this.lgI))
    {
      ab.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
      AppMethodBeat.o(53227);
      return;
    }
    if ((CustomSmileyPreviewUI.q(this.lkP) != null) && (CustomSmileyPreviewUI.q(this.lkP).leO != null)) {
      CustomSmileyPreviewUI.q(this.lkP).bX(this.lgI, this.fUa);
    }
    AppMethodBeat.o(53227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.7
 * JD-Core Version:    0.7.0.1
 */