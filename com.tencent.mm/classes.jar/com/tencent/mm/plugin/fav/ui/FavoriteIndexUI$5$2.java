package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.report.service.h;
import java.util.List;

final class FavoriteIndexUI$5$2
  implements DialogInterface.OnClickListener
{
  FavoriteIndexUI$5$2(FavoriteIndexUI.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74224);
    paramDialogInterface = FavoriteIndexUI.a(this.myQ.myP).hB(true);
    FavoriteIndexUI.a(this.myQ.myP, paramDialogInterface);
    h.qsU.e(11125, new Object[] { Integer.valueOf(paramDialogInterface.size()), Integer.valueOf(3) });
    if (FavoriteIndexUI.a(this.myQ.myP).mzp) {
      FavoriteIndexUI.b(this.myQ.myP);
    }
    AppMethodBeat.o(74224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.5.2
 * JD-Core Version:    0.7.0.1
 */