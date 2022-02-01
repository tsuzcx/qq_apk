package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class FavoriteIndexUI$19
  implements AdapterView.OnItemLongClickListener
{
  FavoriteIndexUI$19(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107018);
    if (paramInt < this.tgv.tdb.getHeaderViewsCount())
    {
      Log.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
      AppMethodBeat.o(107018);
      return true;
    }
    FavoriteIndexUI.a(this.tgv, paramView, paramInt, paramLong, FavoriteIndexUI.c(this.tgv));
    AppMethodBeat.o(107018);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.19
 * JD-Core Version:    0.7.0.1
 */