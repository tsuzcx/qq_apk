package com.tencent.mm.plugin.gallery.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.m.a;
import java.util.ArrayList;

final class ImagePreviewUI$18
  implements m.a
{
  ImagePreviewUI$18(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void a(m paramm)
  {
    if (paramm.position != ImagePreviewUI.g(this.kKb).intValue()) {
      return;
    }
    if ((paramm.kHv.eAx >= 300000) || ((paramm.kHv.eAx > 0) && (paramm.kHv.eAx < 1000)))
    {
      ImagePreviewUI.a(this.kKb).setVisibility(0);
      TextView localTextView = ImagePreviewUI.x(this.kKb);
      if (paramm.kHv.eAx >= 300000) {}
      for (paramm = this.kKb.getString(R.l.gallery_pic_video_too_long_desc);; paramm = this.kKb.getString(R.l.gallery_pic_video_too_short_desc))
      {
        localTextView.setText(paramm);
        ImagePreviewUI.y(this.kKb).setEnabled(false);
        ImagePreviewUI.e(this.kKb).setEnabled(false);
        ImagePreviewUI.y(this.kKb).setTextColor(this.kKb.getResources().getColor(R.e.white_text_color_disabled));
        if (ImagePreviewUI.d(this.kKb).size() != 0) {
          break;
        }
        this.kKb.enableOptionMenu(false);
        return;
      }
    }
    ImagePreviewUI.y(this.kKb).setEnabled(true);
    ImagePreviewUI.e(this.kKb).setEnabled(true);
    ImagePreviewUI.y(this.kKb).setTextColor(this.kKb.getResources().getColor(R.e.white_text_color));
    ImagePreviewUI.a(this.kKb).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.18
 * JD-Core Version:    0.7.0.1
 */