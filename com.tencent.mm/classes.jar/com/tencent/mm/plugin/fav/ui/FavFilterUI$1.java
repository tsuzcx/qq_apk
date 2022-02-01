package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class FavFilterUI$1
  implements AdapterView.OnItemLongClickListener
{
  FavFilterUI$1(FavFilterUI paramFavFilterUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(106691);
    if (FavFilterUI.a(this.tek) == 2)
    {
      Log.w("MicroMsg.FavFilterUI", "on edit mode long click, ignore");
      AppMethodBeat.o(106691);
      return true;
    }
    if (paramInt < FavFilterUI.b(this.tek).getHeaderViewsCount())
    {
      Log.w("MicroMsg.FavFilterUI", "on header view long click, ignore");
      AppMethodBeat.o(106691);
      return true;
    }
    FavFilterUI.a(this.tek, paramView, paramInt, paramLong, FavFilterUI.c(this.tek));
    AppMethodBeat.o(106691);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI.1
 * JD-Core Version:    0.7.0.1
 */