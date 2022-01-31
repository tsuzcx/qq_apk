package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FavoriteIndexUI$20
  implements AdapterView.OnItemLongClickListener
{
  FavoriteIndexUI$20(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74246);
    if (paramInt < this.myP.mvw.getHeaderViewsCount())
    {
      ab.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
      AppMethodBeat.o(74246);
      return true;
    }
    FavoriteIndexUI.a(this.myP, paramView, paramInt, paramLong, FavoriteIndexUI.c(this.myP));
    AppMethodBeat.o(74246);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.20
 * JD-Core Version:    0.7.0.1
 */