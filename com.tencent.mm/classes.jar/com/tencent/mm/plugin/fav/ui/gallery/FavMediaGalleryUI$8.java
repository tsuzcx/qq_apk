package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.base.n.d;
import java.util.Map;

final class FavMediaGalleryUI$8
  implements n.d
{
  FavMediaGalleryUI$8(FavMediaGalleryUI paramFavMediaGalleryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74515);
    Object localObject1 = FavMediaGalleryUI.d(this.mBV).vX(FavMediaGalleryUI.c(this.mBV));
    if (localObject1 == null)
    {
      AppMethodBeat.o(74515);
      return;
    }
    Object localObject2 = b.b(((f)localObject1).cuL);
    if ((!e.cN((String)localObject2)) && (paramMenuItem.getItemId() != 4))
    {
      ab.w("MicroMsg.FavMediaGalleryUI", "file not exists");
      AppMethodBeat.o(74515);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74515);
      return;
      h.i(FavMediaGalleryUI.e(this.mBV), 1, 0);
      if (((f)localObject1).cuL.dataType == 2)
      {
        if (r.aoY((String)localObject2))
        {
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Select_Conv_Type", 3);
          paramMenuItem.putExtra("select_is_ret", true);
          d.b(this.mBV, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
          AppMethodBeat.o(74515);
          return;
        }
        b.c((String)localObject2, this.mBV);
        AppMethodBeat.o(74515);
        return;
      }
      paramMenuItem = b.c(((f)localObject1).cuL);
      localObject1 = b.b(((f)localObject1).cuL);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
      ((Intent)localObject2).putExtra("select_is_ret", true);
      ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
      if (e.cN(paramMenuItem)) {
        ((Intent)localObject2).putExtra("image_path", paramMenuItem);
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("Retr_Msg_Type", 1);
        d.b(this.mBV.getContext(), ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1);
        AppMethodBeat.o(74515);
        return;
        ((Intent)localObject2).putExtra("image_path", (String)localObject1);
      }
      b.d((String)localObject2, this.mBV);
      h.i(FavMediaGalleryUI.e(this.mBV), 0, 0);
      AppMethodBeat.o(74515);
      return;
      if (((f)localObject1).cuL.dataType == 2)
      {
        FavMediaGalleryUI.a(this.mBV, (String)localObject2);
        AppMethodBeat.o(74515);
        return;
      }
      FavMediaGalleryUI.b(this.mBV, (String)localObject2);
      AppMethodBeat.o(74515);
      return;
      localObject2 = (ny)FavMediaGalleryUI.f(this.mBV).get(localObject2);
      if (localObject2 != null)
      {
        paramMenuItem = new cg();
        paramMenuItem.cpD.activity = this.mBV;
        paramMenuItem.cpD.cnR = ((ny)localObject2).cEy.result;
        paramMenuItem.cpD.cpE = ((ny)localObject2).cEy.cpE;
        paramMenuItem.cpD.cpG = 7;
        if ((localObject1 != null) && (((f)localObject1).cuL != null))
        {
          paramMenuItem.cpD.imagePath = ((f)localObject1).cuL.wSC;
          paramMenuItem.cpD.cpI = ((f)localObject1).cuL.wSE;
        }
        paramMenuItem.cpD.cpF = ((ny)localObject2).cEy.cpF;
        localObject1 = new Bundle(1);
        ((Bundle)localObject1).putInt("stat_scene", 5);
        paramMenuItem.cpD.cpJ = ((Bundle)localObject1);
        a.ymk.l(paramMenuItem);
        AppMethodBeat.o(74515);
        return;
        this.mBV.mBU.index = (FavMediaGalleryUI.d(this.mBV).getCount() - FavMediaGalleryUI.c(this.mBV));
        ((y)g.E(y.class)).a(this.mBV.getContext(), ((f)localObject1).mwn, this.mBV.mBU);
        this.mBV.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.8
 * JD-Core Version:    0.7.0.1
 */