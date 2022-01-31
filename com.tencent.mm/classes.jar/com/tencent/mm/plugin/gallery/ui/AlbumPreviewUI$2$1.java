package com.tencent.mm.plugin.gallery.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ab;

final class AlbumPreviewUI$2$1
  implements DialogInterface.OnClickListener
{
  AlbumPreviewUI$2$1(AlbumPreviewUI.2 param2, GalleryItem.MediaItem paramMediaItem, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(155063);
    if (this.neW == null)
    {
      ab.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", new Object[] { Integer.valueOf(this.lU) });
      this.neX.neV.setResult(0);
    }
    for (;;)
    {
      this.neX.neV.finish();
      AppMethodBeat.o(155063);
      return;
      ab.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
      paramDialogInterface = new Intent();
      paramDialogInterface.setData(Uri.parse("file://" + Uri.encode(this.neW.fQn)));
      this.neX.neV.setResult(-1, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.2.1
 * JD-Core Version:    0.7.0.1
 */