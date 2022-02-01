package com.tencent.mm.plugin.game.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class GamePublishGalleryUI$5
  implements DialogInterface.OnClickListener
{
  GamePublishGalleryUI$5(GamePublishGalleryUI paramGamePublishGalleryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(276832);
    b.lx(this.Izu.getContext());
    this.Izu.finish();
    AppMethodBeat.o(276832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GamePublishGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */