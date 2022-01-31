package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import java.util.HashSet;

final class MassSendSelectContactUI$3
  implements MultiSelectContactView.c
{
  MassSendSelectContactUI$3(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(22876);
    if (paramString != null)
    {
      MassSendSelectContactUI.a(this.oCt).remove(paramString);
      MassSendSelectContactUI.a(this.oCt, MassSendSelectContactUI.a(this.oCt).size());
    }
    AppMethodBeat.o(22876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */