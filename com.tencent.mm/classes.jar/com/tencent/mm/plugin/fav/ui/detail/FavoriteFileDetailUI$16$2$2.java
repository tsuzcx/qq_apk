package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.ui.base.h;

final class FavoriteFileDetailUI$16$2$2
  implements DialogInterface.OnClickListener
{
  FavoriteFileDetailUI$16$2$2(FavoriteFileDetailUI.16.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74341);
    paramDialogInterface = h.b(this.mAn.mAm.mAf.getContext(), this.mAn.mAm.mAf.getString(2131296902), false, null);
    b.a(FavoriteFileDetailUI.b(this.mAn.mAm.mAf).field_localId, new FavoriteFileDetailUI.16.2.2.1(this, paramDialogInterface));
    AppMethodBeat.o(74341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.16.2.2
 * JD-Core Version:    0.7.0.1
 */