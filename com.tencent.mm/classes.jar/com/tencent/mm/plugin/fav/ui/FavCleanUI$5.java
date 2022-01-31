package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.plugin.fav.ui.widget.a.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

final class FavCleanUI$5
  implements a.a
{
  FavCleanUI$5(FavCleanUI paramFavCleanUI) {}
  
  public final void aRe()
  {
    com.tencent.mm.ui.base.h.a(this.kbE.mController.uMN, this.kbE.getString(n.i.fav_clean_delete_tips), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        long l = FavCleanUI.e(FavCleanUI.5.this.kbE).aRD();
        paramAnonymousDialogInterface = FavCleanUI.e(FavCleanUI.5.this.kbE).fX(true);
        Object localObject = FavCleanUI.f(FavCleanUI.5.this.kbE);
        ((a)localObject).kjh += l;
        com.tencent.mm.plugin.fav.a.b.en(com.tencent.mm.plugin.fav.a.b.aPN() - l);
        if (paramAnonymousDialogInterface.isEmpty()) {
          return;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(14110, new Object[] { Integer.valueOf(FavCleanUI.g(FavCleanUI.5.this.kbE)), Integer.valueOf(paramAnonymousDialogInterface.size()), Integer.valueOf((int)(l * 1.0D / 1024.0D)) });
        localObject = com.tencent.mm.ui.base.h.b(FavCleanUI.5.this.kbE.mController.uMN, FavCleanUI.5.this.kbE.getString(n.i.favorite_delete_tips), false, null);
        g.DS().O(new FavCleanUI.5.1.1(this, paramAnonymousDialogInterface, (Dialog)localObject));
        com.tencent.mm.plugin.report.service.h.nFQ.f(11125, new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()), Integer.valueOf(3) });
      }
    }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.5
 * JD-Core Version:    0.7.0.1
 */