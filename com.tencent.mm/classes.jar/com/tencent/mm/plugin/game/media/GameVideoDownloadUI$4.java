package com.tencent.mm.plugin.game.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.i;

final class GameVideoDownloadUI$4
  implements DialogInterface.OnClickListener
{
  GameVideoDownloadUI$4(GameVideoDownloadUI paramGameVideoDownloadUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(151849);
    if (GameVideoDownloadUI.d(this.nlB) == 1) {
      i.c(GameVideoDownloadUI.e(this.nlB), "video download cancel", GameVideoDownloadUI.c(this.nlB), -2, "video download cancel");
    }
    for (;;)
    {
      this.nlB.finish();
      AppMethodBeat.o(151849);
      return;
      if (GameVideoDownloadUI.d(this.nlB) == 4) {
        this.nlB.setResult(-1, new Intent().putExtra("webview_callback_err", 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.4
 * JD-Core Version:    0.7.0.1
 */