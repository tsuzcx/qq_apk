package com.tencent.mm.plugin.downloader_app.ui;

import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DownloadMainUI$3
  implements DownloadMainUI.a
{
  DownloadMainUI$3(DownloadMainUI paramDownloadMainUI) {}
  
  public final void gC(boolean paramBoolean)
  {
    AppMethodBeat.i(136226);
    if (paramBoolean)
    {
      DownloadMainUI.a(this.lci).setVisibility(0);
      DownloadMainUI.a(this.lci).startAnimation(AnimationUtils.loadAnimation(this.lci, 2131034150));
      DownloadMainUI.b(this.lci).setVisibility(0);
      DownloadMainUI.b(this.lci).startAnimation(AnimationUtils.loadAnimation(this.lci, 2131034286));
      AppMethodBeat.o(136226);
      return;
    }
    DownloadMainUI.a(this.lci).setVisibility(8);
    DownloadMainUI.a(this.lci).startAnimation(AnimationUtils.loadAnimation(this.lci, 2131034151));
    DownloadMainUI.b(this.lci).setVisibility(8);
    DownloadMainUI.b(this.lci).startAnimation(AnimationUtils.loadAnimation(this.lci, 2131034287));
    AppMethodBeat.o(136226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.3
 * JD-Core Version:    0.7.0.1
 */