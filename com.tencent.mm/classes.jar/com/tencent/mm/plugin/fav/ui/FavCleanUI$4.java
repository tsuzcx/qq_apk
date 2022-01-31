package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.fav.ui.a.b;

final class FavCleanUI$4
  implements AdapterView.OnItemClickListener
{
  FavCleanUI$4(FavCleanUI paramFavCleanUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (FavCleanUI.e(this.kbE) != null) {
      FavCleanUI.e(this.kbE).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.4
 * JD-Core Version:    0.7.0.1
 */