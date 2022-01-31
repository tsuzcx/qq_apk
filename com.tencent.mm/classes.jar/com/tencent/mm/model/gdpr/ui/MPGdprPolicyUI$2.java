package com.tencent.mm.model.gdpr.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.b;

final class MPGdprPolicyUI$2
  implements b
{
  MPGdprPolicyUI$2(MPGdprPolicyUI paramMPGdprPolicyUI) {}
  
  public final boolean pW(String paramString)
  {
    AppMethodBeat.i(1503);
    this.foM.runOnUiThread(new MPGdprPolicyUI.2.1(this, paramString));
    AppMethodBeat.o(1503);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.2
 * JD-Core Version:    0.7.0.1
 */