package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import java.util.HashSet;

final class MassSendSelectContactUI$3
  implements MultiSelectContactView.a
{
  MassSendSelectContactUI$3(MassSendSelectContactUI paramMassSendSelectContactUI) {}
  
  public final void pw(String paramString)
  {
    if (paramString != null)
    {
      MassSendSelectContactUI.a(this.mbS).remove(paramString);
      MassSendSelectContactUI.a(this.mbS, MassSendSelectContactUI.a(this.mbS).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */