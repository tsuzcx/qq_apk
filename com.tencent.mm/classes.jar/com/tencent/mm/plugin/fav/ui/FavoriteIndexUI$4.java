package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteIndexUI$4
  implements View.OnClickListener
{
  FavoriteIndexUI$4(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74222);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = new Intent();
    paramView.putExtra("key_enter_fav_search_from", 0);
    paramView.putExtra("key_preset_search_type", i);
    FavoriteIndexUI.a(this.myP, paramView);
    AppMethodBeat.o(74222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.4
 * JD-Core Version:    0.7.0.1
 */