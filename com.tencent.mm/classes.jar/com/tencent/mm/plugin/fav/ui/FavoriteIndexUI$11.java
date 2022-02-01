package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class FavoriteIndexUI$11
  implements DialogInterface.OnClickListener
{
  FavoriteIndexUI$11(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(107009);
    paramDialogInterface.dismiss();
    b.lx(this.Aji.getContext());
    AppMethodBeat.o(107009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.11
 * JD-Core Version:    0.7.0.1
 */