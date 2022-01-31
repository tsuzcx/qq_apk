package com.tencent.mm.plugin.game.media;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.game.report.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.ab;

final class GameVideoDownloadUI$1
  implements View.OnClickListener
{
  GameVideoDownloadUI$1(GameVideoDownloadUI paramGameVideoDownloadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151845);
    ab.i("MicroMsg.GameVideoDownloadUI", "cancel video download!");
    o.alF().j(GameVideoDownloadUI.a(this.nlB), null);
    a.a(GameVideoDownloadUI.b(this.nlB), 1, 2, GameVideoDownloadUI.c(this.nlB), a.a(GameVideoDownloadUI.d(this.nlB), GameVideoDownloadUI.a(this.nlB, 0)));
    if (GameVideoDownloadUI.d(this.nlB) == 1) {
      i.c(GameVideoDownloadUI.e(this.nlB), "video download cancel", GameVideoDownloadUI.c(this.nlB), -2, "video download cancel");
    }
    for (;;)
    {
      this.nlB.finish();
      AppMethodBeat.o(151845);
      return;
      if (GameVideoDownloadUI.d(this.nlB) == 4) {
        this.nlB.setResult(-1, new Intent().putExtra("webview_callback_err", 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */