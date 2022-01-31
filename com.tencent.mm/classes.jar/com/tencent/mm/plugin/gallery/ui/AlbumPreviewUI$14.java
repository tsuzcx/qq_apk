package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AlbumPreviewUI$14
  implements View.OnClickListener
{
  AlbumPreviewUI$14(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21409);
    paramView = this.neV;
    boolean bool;
    if (!AlbumPreviewUI.d(this.neV))
    {
      bool = true;
      AlbumPreviewUI.a(paramView, bool);
      AlbumPreviewUI.e(this.neV);
      AlbumPreviewUI.f(this.neV).setText(this.neV.getContext().getString(2131300289) + AlbumPreviewUI.bEs());
      if (!AlbumPreviewUI.d(this.neV)) {
        break label118;
      }
      AlbumPreviewUI.c(this.neV).setImageResource(2131231906);
    }
    for (;;)
    {
      AlbumPreviewUI.g(this.neV);
      AppMethodBeat.o(21409);
      return;
      bool = false;
      break;
      label118:
      AlbumPreviewUI.c(this.neV).setImageResource(2131231905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.14
 * JD-Core Version:    0.7.0.1
 */