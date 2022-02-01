package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import java.util.List;

final class MassSendSelectContactUI$3
  implements MultiSelectContactView.c
{
  MassSendSelectContactUI$3(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(26500);
    if ((paramInt == 1) && (paramString != null))
    {
      MassSendSelectContactUI.a(this.zoz).remove(paramString);
      MassSendSelectContactUI.a(this.zoz, MassSendSelectContactUI.a(this.zoz).size());
    }
    AppMethodBeat.o(26500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */