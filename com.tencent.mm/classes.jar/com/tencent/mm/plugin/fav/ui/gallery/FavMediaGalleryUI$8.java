package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.a.e;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import java.util.Map;

final class FavMediaGalleryUI$8
  implements n.d
{
  FavMediaGalleryUI$8(FavMediaGalleryUI paramFavMediaGalleryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject1 = FavMediaGalleryUI.d(this.khg).rb(FavMediaGalleryUI.c(this.khg));
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = b.b(((f)localObject1).bNt);
      if ((!e.bK((String)localObject2)) && (paramMenuItem.getItemId() != 4))
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.FavMediaGalleryUI", "file not exists");
        return;
      }
      switch (paramMenuItem.getItemId())
      {
      default: 
        return;
      case 0: 
        h.f(FavMediaGalleryUI.e(this.khg), 1, 0);
        if (((f)localObject1).bNt.aYU == 2)
        {
          if (o.Za((String)localObject2))
          {
            paramMenuItem = new Intent();
            paramMenuItem.putExtra("Select_Conv_Type", 3);
            paramMenuItem.putExtra("select_is_ret", true);
            d.c(this.khg, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
            return;
          }
          b.c((String)localObject2, this.khg);
          return;
        }
        paramMenuItem = b.c(((f)localObject1).bNt);
        localObject1 = b.b(((f)localObject1).bNt);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
        ((Intent)localObject2).putExtra("select_is_ret", true);
        ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
        if (e.bK(paramMenuItem)) {
          ((Intent)localObject2).putExtra("image_path", paramMenuItem);
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 1);
          d.c(this.khg.mController.uMN, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
          return;
          ((Intent)localObject2).putExtra("image_path", (String)localObject1);
        }
      case 1: 
        b.d((String)localObject2, this.khg);
        h.f(FavMediaGalleryUI.e(this.khg), 0, 0);
        return;
      case 2: 
        if (((f)localObject1).bNt.aYU == 2)
        {
          FavMediaGalleryUI.a(this.khg, (String)localObject2);
          return;
        }
        FavMediaGalleryUI.b(this.khg, (String)localObject2);
        return;
      case 3: 
        localObject2 = (nb)FavMediaGalleryUI.f(this.khg).get(localObject2);
      }
    } while (localObject2 == null);
    paramMenuItem = new cd();
    paramMenuItem.bIi.activity = this.khg;
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
    return;
    this.khg.khf.index = (FavMediaGalleryUI.d(this.khg).getCount() - FavMediaGalleryUI.c(this.khg));
    ((com.tencent.mm.plugin.fav.a.y)g.r(com.tencent.mm.plugin.fav.a.y.class)).a(this.khg.mController.uMN, ((f)localObject1).kbR, this.khg.khf);
    this.khg.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.8
 * JD-Core Version:    0.7.0.1
 */