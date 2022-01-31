package com.tencent.mm.plugin.account.security.ui;

import android.widget.EditText;
import com.tencent.mm.ui.widget.MMEditText.b;

final class ModSafeDeviceNameUI$3
  implements MMEditText.b
{
  ModSafeDeviceNameUI$3(ModSafeDeviceNameUI paramModSafeDeviceNameUI) {}
  
  public final void XC()
  {
    if (ModSafeDeviceNameUI.a(this.fke).getText().toString().trim().length() > 0)
    {
      this.fke.enableOptionMenu(true);
      return;
    }
    this.fke.enableOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI.3
 * JD-Core Version:    0.7.0.1
 */