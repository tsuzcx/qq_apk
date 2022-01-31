package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;

final class FavCapacityPanel$1
  implements View.OnClickListener
{
  FavCapacityPanel$1(FavCapacityPanel paramFavCapacityPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74663);
    paramView = new Intent();
    if (this.mDO.mDM == 0) {
      paramView.putExtra("key_enter_fav_cleanui_from", 1);
    }
    for (;;)
    {
      b.b(this.mDO.getContext(), ".ui.FavCleanUI", paramView);
      AppMethodBeat.o(74663);
      return;
      paramView.putExtra("key_enter_fav_cleanui_from", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel.1
 * JD-Core Version:    0.7.0.1
 */