package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g.c;

final class ContactLabelManagerUI$14
  implements g.c
{
  ContactLabelManagerUI$14(ContactLabelManagerUI paramContactLabelManagerUI, Runnable paramRunnable) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(268814);
    Log.i("MicroMsg.Label.ContactLabelManagerUI", "showTextToast, has shown tip");
    if (this.JVO != null) {
      this.JVO.run();
    }
    AppMethodBeat.o(268814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.14
 * JD-Core Version:    0.7.0.1
 */