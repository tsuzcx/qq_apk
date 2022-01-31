package com.tencent.mm.plugin.account.security.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.b;

final class ModSafeDeviceNameUI$3
  implements MMEditText.b
{
  ModSafeDeviceNameUI$3(ModSafeDeviceNameUI paramModSafeDeviceNameUI) {}
  
  public final void are()
  {
    AppMethodBeat.i(69865);
    if (ModSafeDeviceNameUI.a(this.gBv).getText().toString().trim().length() > 0)
    {
      this.gBv.enableOptionMenu(true);
      AppMethodBeat.o(69865);
      return;
    }
    this.gBv.enableOptionMenu(false);
    AppMethodBeat.o(69865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.3
 * JD-Core Version:    0.7.0.1
 */