package com.tencent.mm.plugin.gallery.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class AlbumPreviewUI$9
  implements DialogInterface.OnClickListener
{
  AlbumPreviewUI$9(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.kIF.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.9
 * JD-Core Version:    0.7.0.1
 */