package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class FavoriteIndexUI$17
  implements AdapterView.OnItemLongClickListener
{
  FavoriteIndexUI$17(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.kee.kba.getHeaderViewsCount())
    {
      y.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
      return true;
    }
    FavoriteIndexUI.d(this.kee).a(paramView, paramInt, paramLong, this.kee, FavoriteIndexUI.c(this.kee));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.17
 * JD-Core Version:    0.7.0.1
 */