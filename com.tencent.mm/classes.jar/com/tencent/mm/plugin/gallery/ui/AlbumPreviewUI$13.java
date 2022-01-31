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

final class AlbumPreviewUI$13
  implements View.OnClickListener
{
  AlbumPreviewUI$13(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.kIF;
    boolean bool;
    if (!AlbumPreviewUI.d(this.kIF))
    {
      bool = true;
      AlbumPreviewUI.a(paramView, bool);
      AlbumPreviewUI.e(this.kIF);
      AlbumPreviewUI.f(this.kIF).setText(this.kIF.mController.uMN.getString(R.l.gallery_pic_orignal) + AlbumPreviewUI.aXN());
      if (!AlbumPreviewUI.d(this.kIF)) {
        break label111;
      }
      AlbumPreviewUI.c(this.kIF).setImageResource(R.k.radio_on);
    }
    for (;;)
    {
      AlbumPreviewUI.g(this.kIF);
      return;
      bool = false;
      break;
      label111:
      AlbumPreviewUI.c(this.kIF).setImageResource(R.k.radio_off);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.13
 * JD-Core Version:    0.7.0.1
 */