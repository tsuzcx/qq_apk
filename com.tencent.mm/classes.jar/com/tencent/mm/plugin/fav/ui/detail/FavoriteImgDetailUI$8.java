package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.e;

final class FavoriteImgDetailUI$8
  implements n.d
{
  FavoriteImgDetailUI$8(FavoriteImgDetailUI paramFavoriteImgDetailUI, FavoriteImgDetailUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = b.b(this.kfR.bNt);
    if (!e.bK((String)localObject))
    {
      y.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      b.d((String)localObject, this.kfM.mController.uMN);
      h.f(FavoriteImgDetailUI.b(this.kfM).field_localId, 0, 0);
      return;
    case 2: 
      if (o.Za((String)localObject))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Select_Conv_Type", 3);
        paramMenuItem.putExtra("select_is_ret", true);
        d.c(this.kfM, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      }
      for (;;)
      {
        h.f(FavoriteImgDetailUI.b(this.kfM).field_localId, 1, 0);
        return;
        b.c((String)localObject, this.kfM.mController.uMN);
      }
    case 3: 
      FavoriteImgDetailUI.a((String)localObject, this.kfM.getString(n.i.favorite_save_fail), this.kfM.mController.uMN);
      return;
    }
    y.i("MicroMsg.FavoriteImgDetailUI", "request deal QBAR string");
    paramMenuItem = new cd();
    paramMenuItem.bIi.activity = this.kfM;
    paramMenuItem.bIi.bGE = this.kfR.kfV;
    paramMenuItem.bIi.bIj = this.kfR.bIj;
    paramMenuItem.bIi.bIl = 7;
    if (this.kfR.bNt != null)
    {
      paramMenuItem.bIi.imagePath = this.kfR.bNt.sUG;
      paramMenuItem.bIi.bIn = this.kfR.bNt.sUI;
    }
    paramMenuItem.bIi.bIk = this.kfR.bIk;
    localObject = new Bundle(1);
    ((Bundle)localObject).putInt("stat_scene", 5);
    paramMenuItem.bIi.bIo = ((Bundle)localObject);
    a.udP.m(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.8
 * JD-Core Version:    0.7.0.1
 */