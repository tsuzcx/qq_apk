package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.sdk.platformtools.al;
import java.util.List;

final class FavCleanUI$5$1
  implements DialogInterface.OnClickListener
{
  FavCleanUI$5$1(FavCleanUI.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73956);
    long l = FavCleanUI.e(this.mwb.mwa).bxT();
    paramDialogInterface = FavCleanUI.e(this.mwb.mwa).hB(true);
    Object localObject = FavCleanUI.f(this.mwb.mwa);
    ((a)localObject).mDN += l;
    com.tencent.mm.plugin.fav.a.b.jK(com.tencent.mm.plugin.fav.a.b.bwb() - l);
    if (paramDialogInterface.isEmpty())
    {
      AppMethodBeat.o(73956);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(14110, new Object[] { Integer.valueOf(FavCleanUI.g(this.mwb.mwa)), Integer.valueOf(paramDialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
    localObject = com.tencent.mm.ui.base.h.b(this.mwb.mwa.getContext(), this.mwb.mwa.getString(2131299686), false, null);
    g.RO().ac(new FavCleanUI.5.1.1(this, paramDialogInterface, (Dialog)localObject));
    com.tencent.mm.plugin.report.service.h.qsU.e(11125, new Object[] { Integer.valueOf(paramDialogInterface.size()), Integer.valueOf(3) });
    AppMethodBeat.o(73956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.5.1
 * JD-Core Version:    0.7.0.1
 */