package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.clean.c.b;
import java.util.ArrayList;

final class CleanChattingDetailUI$5
  implements DialogInterface.OnClickListener
{
  CleanChattingDetailUI$5(CleanChattingDetailUI paramCleanChattingDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (CleanChattingDetailUI.c(this.iEb).iBu.size() == 0) {
      this.iEb.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI.5
 * JD-Core Version:    0.7.0.1
 */