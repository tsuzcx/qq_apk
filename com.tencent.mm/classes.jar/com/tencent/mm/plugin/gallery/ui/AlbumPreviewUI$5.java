package com.tencent.mm.plugin.gallery.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class AlbumPreviewUI$5
  implements MenuItem.OnMenuItemClickListener
{
  AlbumPreviewUI$5(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.i("MicroMsg.AlbumPreviewUI", "backBtn");
    this.kIF.setResult(-2);
    if (AlbumPreviewUI.v(this.kIF).Yq)
    {
      AlbumPreviewUI.v(this.kIF).aXP();
      return true;
    }
    this.kIF.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */