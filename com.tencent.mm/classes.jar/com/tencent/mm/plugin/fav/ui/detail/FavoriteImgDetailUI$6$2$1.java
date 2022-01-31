package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class FavoriteImgDetailUI$6$2$1
  implements DialogInterface.OnClickListener
{
  FavoriteImgDetailUI$6$2$1(FavoriteImgDetailUI.6.2 param2) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74379);
    paramDialogInterface = h.b(this.mAz.mAy.mAv.getContext(), this.mAz.mAy.mAv.getString(2131296902), false, null);
    b.a(FavoriteImgDetailUI.b(this.mAz.mAy.mAv).field_localId, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74378);
        FavoriteImgDetailUI.6.2.1.this.mAz.mAy.mAv.mzH.mtj = true;
        paramDialogInterface.dismiss();
        ab.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteImgDetailUI.b(FavoriteImgDetailUI.6.2.1.this.mAz.mAy.mAv).field_localId) });
        FavoriteImgDetailUI.6.2.1.this.mAz.mAy.mAv.finish();
        AppMethodBeat.o(74378);
      }
    });
    AppMethodBeat.o(74379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.6.2.1
 * JD-Core Version:    0.7.0.1
 */