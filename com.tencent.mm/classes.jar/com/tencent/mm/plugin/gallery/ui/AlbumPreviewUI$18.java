package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AlbumPreviewUI$18
  implements View.OnClickListener
{
  AlbumPreviewUI$18(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21413);
    AlbumPreviewUI.x(this.neV);
    AlbumPreviewUI.y(this.neV).bEv();
    ab.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", new Object[] { Integer.valueOf(AlbumPreviewUI.z(this.neV)) });
    AppMethodBeat.o(21413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.18
 * JD-Core Version:    0.7.0.1
 */