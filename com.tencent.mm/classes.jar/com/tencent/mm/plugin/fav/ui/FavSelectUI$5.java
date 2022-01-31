package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class FavSelectUI$5
  implements View.OnClickListener
{
  FavSelectUI$5(FavSelectUI paramFavSelectUI) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = new Intent();
    paramView.putExtra("key_preset_search_type", i);
    FavSelectUI.a(this.kdd, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI.5
 * JD-Core Version:    0.7.0.1
 */