package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.b;

final class FavCleanUI$4
  implements AdapterView.OnItemClickListener
{
  FavCleanUI$4(FavCleanUI paramFavCleanUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(73952);
    if (FavCleanUI.e(this.mwa) != null) {
      FavCleanUI.e(this.mwa).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(73952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavCleanUI.4
 * JD-Core Version:    0.7.0.1
 */