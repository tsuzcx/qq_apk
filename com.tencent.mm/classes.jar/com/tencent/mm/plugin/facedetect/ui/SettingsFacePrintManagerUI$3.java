package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsFacePrintManagerUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsFacePrintManagerUI$3(SettingsFacePrintManagerUI paramSettingsFacePrintManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(529);
    this.mnf.finish();
    AppMethodBeat.o(529);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI.3
 * JD-Core Version:    0.7.0.1
 */