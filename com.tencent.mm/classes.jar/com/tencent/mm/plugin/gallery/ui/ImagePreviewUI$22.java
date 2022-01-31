package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

final class ImagePreviewUI$22
  implements View.OnClickListener
{
  ImagePreviewUI$22(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.kKb;
    boolean bool;
    if (!ImagePreviewUI.b(this.kKb))
    {
      bool = true;
      ImagePreviewUI.b(paramView, bool);
      if (!ImagePreviewUI.b(this.kKb)) {
        break label138;
      }
      ImagePreviewUI.c(this.kKb).setImageResource(R.k.radio_on);
      if (ImagePreviewUI.d(this.kKb).size() == 0) {
        ImagePreviewUI.e(this.kKb).performClick();
      }
    }
    for (;;)
    {
      ImagePreviewUI.f(this.kKb).setText(this.kKb.mController.uMN.getString(R.l.gallery_pic_orignal) + ImagePreviewUI.aXU());
      ImagePreviewUI.a(this.kKb, ImagePreviewUI.g(this.kKb).intValue());
      return;
      bool = false;
      break;
      label138:
      ImagePreviewUI.c(this.kKb).setImageResource(R.k.radio_off);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.22
 * JD-Core Version:    0.7.0.1
 */