package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;

final class FavoriteTextDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteTextDetailUI$2(FavoriteTextDetailUI paramFavoriteTextDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74442);
    paramMenuItem = new d(this.mBc.getContext(), 1, false);
    paramMenuItem.sao = new FavoriteTextDetailUI.2.1(this);
    paramMenuItem.sap = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(74441);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(74441);
          return;
          if ((FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc).field_favProto != null))
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("key_value", FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc).field_favProto.desc);
            paramAnonymousMenuItem.putExtra("key_max_count", FavoriteTextDetailUI.access$100());
            paramAnonymousMenuItem.putExtra("key_show_confirm", true);
            paramAnonymousMenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc).field_id);
            b.a(FavoriteTextDetailUI.2.this.mBc, ".ui.FavTextEditUI", paramAnonymousMenuItem, 1);
            paramAnonymousMenuItem = FavoriteTextDetailUI.2.this.mBc.mzH;
            paramAnonymousMenuItem.mth += 1;
            AppMethodBeat.o(74441);
            return;
            com.tencent.mm.plugin.fav.ui.g.a(FavoriteTextDetailUI.2.this.mBc, FavoriteTextDetailUI.b(FavoriteTextDetailUI.2.this.mBc), FavoriteTextDetailUI.2.this.mBc.mzH);
            AppMethodBeat.o(74441);
            return;
            if ((FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc).field_favProto != null))
            {
              paramAnonymousMenuItem = FavoriteTextDetailUI.2.this.mBc.mzH;
              paramAnonymousMenuItem.mtf += 1;
              b.e(FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc).field_favProto.desc, FavoriteTextDetailUI.2.this.mBc);
              com.tencent.mm.plugin.fav.a.h.i(FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc).field_localId, 1, 0);
              AppMethodBeat.o(74441);
              return;
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("key_fav_scene", 2);
              paramAnonymousMenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.2.this.mBc).field_localId);
              b.b(FavoriteTextDetailUI.2.this.mBc.getContext(), ".ui.FavTagEditUI", paramAnonymousMenuItem);
              paramAnonymousMenuItem = FavoriteTextDetailUI.2.this.mBc.mzH;
              paramAnonymousMenuItem.mti += 1;
              AppMethodBeat.o(74441);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteTextDetailUI.2.this.mBc.getContext(), FavoriteTextDetailUI.2.this.mBc.getString(2131296902), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(74440);
                  paramAnonymous2DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteTextDetailUI.2.this.mBc.getContext(), FavoriteTextDetailUI.2.this.mBc.getString(2131296902), false, null);
                  b.a(FavoriteTextDetailUI.b(FavoriteTextDetailUI.2.this.mBc), new FavoriteTextDetailUI.2.2.1.1(this, paramAnonymous2DialogInterface));
                  AppMethodBeat.o(74440);
                }
              }, null);
            }
          }
        }
      }
    };
    paramMenuItem.crd();
    AppMethodBeat.o(74442);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2
 * JD-Core Version:    0.7.0.1
 */