package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.ui.base.h;
import java.util.List;

final class FavoriteIndexUI$5
  implements b.a
{
  FavoriteIndexUI$5(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void bxJ()
  {
    AppMethodBeat.i(74225);
    if (!FavoriteIndexUI.a(FavoriteIndexUI.a(this.myP).hB(false), this.myP, new FavoriteIndexUI.5.1(this)))
    {
      AppMethodBeat.o(74225);
      return;
    }
    FavoriteIndexUI.a(this.myP, 4105);
    AppMethodBeat.o(74225);
  }
  
  public final void bxK()
  {
    AppMethodBeat.i(74227);
    if (FavoriteIndexUI.a(this.myP).bxS() <= 0)
    {
      AppMethodBeat.o(74227);
      return;
    }
    if (FavoriteIndexUI.a(this.myP).bxS() > 1)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_fav_scene", 3);
      com.tencent.mm.plugin.fav.a.b.a(this.myP.getContext(), ".ui.FavTagEditUI", (Intent)localObject, 4104);
      i.NI("FavTagEditUI");
      AppMethodBeat.o(74227);
      return;
    }
    Object localObject = (g)FavoriteIndexUI.a(this.myP).hB(false).get(0);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_fav_scene", 3);
    localIntent.putExtra("key_fav_item_id", ((g)localObject).field_localId);
    com.tencent.mm.plugin.fav.a.b.b(this.myP.getContext(), ".ui.FavTagEditUI", localIntent);
    i.NI("FavTagEditUI");
    if (FavoriteIndexUI.a(this.myP).mzp) {
      FavoriteIndexUI.b(this.myP);
    }
    AppMethodBeat.o(74227);
  }
  
  public final void bxs()
  {
    AppMethodBeat.i(74226);
    h.a(this.myP.getContext(), this.myP.getString(2131299685), "", new FavoriteIndexUI.5.2(this), null);
    AppMethodBeat.o(74226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.5
 * JD-Core Version:    0.7.0.1
 */