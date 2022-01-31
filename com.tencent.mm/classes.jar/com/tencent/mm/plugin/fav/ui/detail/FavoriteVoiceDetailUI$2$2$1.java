package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.ui.base.h;

final class FavoriteVoiceDetailUI$2$2$1
  implements DialogInterface.OnClickListener
{
  FavoriteVoiceDetailUI$2$2$1(FavoriteVoiceDetailUI.2.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74481);
    paramDialogInterface = h.b(this.mBy.mBx.mBw.getContext(), this.mBy.mBx.mBw.getString(2131296902), false, null);
    long l1 = FavoriteVoiceDetailUI.a(this.mBy.mBx.mBw).field_localId;
    long l2 = FavoriteVoiceDetailUI.a(this.mBy.mBx.mBw).field_id;
    b.a(FavoriteVoiceDetailUI.a(this.mBy.mBx.mBw).field_localId, new FavoriteVoiceDetailUI.2.2.1.1(this, paramDialogInterface, l1, l2));
    AppMethodBeat.o(74481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2.2.1
 * JD-Core Version:    0.7.0.1
 */