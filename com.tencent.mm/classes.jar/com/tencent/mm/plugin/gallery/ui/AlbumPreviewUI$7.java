package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class AlbumPreviewUI$7
  implements a.a
{
  private View.OnClickListener kdc = new AlbumPreviewUI.7.1(this);
  
  AlbumPreviewUI$7(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final View getView()
  {
    View localView = View.inflate(this.kIF.mController.uMN, R.i.cemera_icon, null);
    localView.setOnClickListener(this.kdc);
    TextView localTextView = (TextView)localView.findViewById(R.h.media_thumb);
    if ((c.aXb().aXF() == 2) || (c.aXb().aXE() == 13)) {
      localTextView.setText(R.l.gallery_take_vedio);
    }
    for (;;)
    {
      localView.setLayerType(1, null);
      return localView;
      if (c.aXb().aXF() == 1) {
        localTextView.setText(R.l.gallery_take_picture);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.7
 * JD-Core Version:    0.7.0.1
 */