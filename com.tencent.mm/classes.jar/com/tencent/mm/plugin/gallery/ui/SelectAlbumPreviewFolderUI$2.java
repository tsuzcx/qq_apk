package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import java.util.ArrayList;

final class SelectAlbumPreviewFolderUI$2
  implements Runnable
{
  SelectAlbumPreviewFolderUI$2(SelectAlbumPreviewFolderUI paramSelectAlbumPreviewFolderUI, ArrayList paramArrayList) {}
  
  public final void run()
  {
    SelectAlbumPreviewFolderUI.a(this.kKF).addAll(this.kKG);
    SelectAlbumPreviewFolderUI.b(this.kKF).agL.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.2
 * JD-Core Version:    0.7.0.1
 */