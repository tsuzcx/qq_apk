package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.gallery.model.c;

final class AlbumPreviewUI$14
  implements View.OnClickListener
{
  AlbumPreviewUI$14(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AlbumPreviewUI.h(this.kIF);
    paramView = new Intent(this.kIF, ImagePreviewUI.class);
    c.y(AlbumPreviewUI.a(this.kIF).kHC);
    paramView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.kIF).aXJ());
    paramView.putExtra("max_select_count", AlbumPreviewUI.i(this.kIF));
    paramView.putExtra("send_raw_img", AlbumPreviewUI.d(this.kIF));
    paramView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.kIF));
    paramView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.kIF));
    this.kIF.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.14
 * JD-Core Version:    0.7.0.1
 */