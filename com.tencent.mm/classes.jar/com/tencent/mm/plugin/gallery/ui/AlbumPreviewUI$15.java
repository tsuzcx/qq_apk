package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.e;

final class AlbumPreviewUI$15
  implements View.OnClickListener
{
  AlbumPreviewUI$15(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21410);
    AlbumPreviewUI.h(this.neV);
    paramView = new Intent(this.neV, ImagePreviewUI.class);
    e.B(AlbumPreviewUI.a(this.neV).ndM);
    paramView.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.neV).bEn());
    paramView.putExtra("max_select_count", AlbumPreviewUI.i(this.neV));
    paramView.putExtra("send_raw_img", AlbumPreviewUI.d(this.neV));
    paramView.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.neV));
    paramView.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.neV));
    this.neV.startActivityForResult(paramView, 0);
    AppMethodBeat.o(21410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */