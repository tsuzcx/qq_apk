package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.report.service.h;
import java.util.List;

final class FavoriteIndexUI$3$2
  implements DialogInterface.OnClickListener
{
  FavoriteIndexUI$3$2(FavoriteIndexUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = FavoriteIndexUI.a(this.kef.kee).fX(true);
    FavoriteIndexUI.a(this.kef.kee, paramDialogInterface);
    h.nFQ.f(11125, new Object[] { Integer.valueOf(paramDialogInterface.size()), Integer.valueOf(3) });
    if (FavoriteIndexUI.a(this.kef.kee).keG) {
      FavoriteIndexUI.b(this.kef.kee);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.3.2
 * JD-Core Version:    0.7.0.1
 */