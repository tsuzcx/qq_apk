package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;
import java.util.Map;

final class FavImgGalleryUI$7
  implements n.d
{
  FavImgGalleryUI$7(FavImgGalleryUI paramFavImgGalleryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject1 = FavImgGalleryUI.e(this.kbW).rb(FavImgGalleryUI.d(this.kbW));
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = b.b(((f)localObject1).bNt);
      if (!e.bK((String)localObject2))
      {
        y.w("MicroMsg.FavImgGalleryUI", "file not exists");
        return;
      }
      switch (paramMenuItem.getItemId())
      {
      default: 
        return;
      case 0: 
        h.f(FavImgGalleryUI.f(this.kbW), 1, 0);
        if (o.Za((String)localObject2))
        {
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Select_Conv_Type", 3);
          paramMenuItem.putExtra("select_is_ret", true);
          d.c(this.kbW, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
          return;
        }
        b.c((String)localObject2, this.kbW);
        return;
      case 1: 
        b.d((String)localObject2, this.kbW);
        h.f(FavImgGalleryUI.f(this.kbW), 0, 0);
        return;
      case 2: 
        FavImgGalleryUI.a((String)localObject2, this.kbW.getString(n.i.favorite_save_fail), this.kbW);
        return;
      }
      localObject2 = (nb)FavImgGalleryUI.g(this.kbW).get(localObject2);
    } while (localObject2 == null);
    paramMenuItem = new cd();
    paramMenuItem.bIi.activity = this.kbW;
    paramMenuItem.bIi.bGE = ((nb)localObject2).bWI.result;
    paramMenuItem.bIi.bIj = ((nb)localObject2).bWI.bIj;
    paramMenuItem.bIi.bIl = 7;
    if ((localObject1 != null) && (((f)localObject1).bNt != null))
    {
      paramMenuItem.bIi.imagePath = ((f)localObject1).bNt.sUG;
      paramMenuItem.bIi.bIn = ((f)localObject1).bNt.sUI;
    }
    paramMenuItem.bIi.bIk = ((nb)localObject2).bWI.bIk;
    localObject1 = new Bundle(1);
    ((Bundle)localObject1).putInt("stat_scene", 5);
    paramMenuItem.bIi.bIo = ((Bundle)localObject1);
    a.udP.m(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.7
 * JD-Core Version:    0.7.0.1
 */