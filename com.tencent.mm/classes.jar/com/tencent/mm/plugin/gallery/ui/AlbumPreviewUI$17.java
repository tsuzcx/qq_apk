package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class AlbumPreviewUI$17
  implements View.OnClickListener
{
  AlbumPreviewUI$17(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AlbumPreviewUI.u(this.kIF);
    AlbumPreviewUI.v(this.kIF).aXP();
    y.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", new Object[] { Integer.valueOf(AlbumPreviewUI.w(this.kIF)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.17
 * JD-Core Version:    0.7.0.1
 */