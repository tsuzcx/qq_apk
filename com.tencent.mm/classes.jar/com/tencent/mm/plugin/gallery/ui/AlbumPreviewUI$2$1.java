package com.tencent.mm.plugin.gallery.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.y;

final class AlbumPreviewUI$2$1
  implements DialogInterface.OnClickListener
{
  AlbumPreviewUI$2$1(AlbumPreviewUI.2 param2, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = AlbumPreviewUI.a(this.kIG.kIF).rS(this.kX);
    if (paramDialogInterface == null)
    {
      y.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", new Object[] { Integer.valueOf(this.kX) });
      this.kIG.kIF.setResult(0);
    }
    for (;;)
    {
      this.kIG.kIF.finish();
      return;
      y.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse("file://" + Uri.encode(paramDialogInterface.eAu)));
      this.kIG.kIF.setResult(-1, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.2.1
 * JD-Core Version:    0.7.0.1
 */