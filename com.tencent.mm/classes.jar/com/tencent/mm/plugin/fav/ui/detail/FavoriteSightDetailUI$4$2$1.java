package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.ui.base.h;

final class FavoriteSightDetailUI$4$2$1
  implements DialogInterface.OnClickListener
{
  FavoriteSightDetailUI$4$2$1(FavoriteSightDetailUI.4.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74417);
    paramDialogInterface = h.b(this.mAV.mAU.mAS.getContext(), this.mAV.mAU.mAS.getString(2131296902), false, null);
    b.a(FavoriteSightDetailUI.a(this.mAV.mAU.mAS).field_localId, new FavoriteSightDetailUI.4.2.1.1(this, paramDialogInterface));
    AppMethodBeat.o(74417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.2.1
 * JD-Core Version:    0.7.0.1
 */