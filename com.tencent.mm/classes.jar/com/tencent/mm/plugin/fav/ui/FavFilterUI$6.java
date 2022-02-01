package com.tencent.mm.plugin.fav.ui;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;

final class FavFilterUI$6
  implements Runnable
{
  FavFilterUI$6(FavFilterUI paramFavFilterUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(235289);
    View localView = this.tek.getSupportActionBar().getCustomView().findViewById(2131296429);
    if (localView != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      localMarginLayoutParams.leftMargin = at.fromDPToPix(this.tek.getContext(), 54);
      localView.setLayoutParams(localMarginLayoutParams);
    }
    Log.i("MicroMsg.FavFilterUI", "mActionBar center mode");
    AppMethodBeat.o(235289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI.6
 * JD-Core Version:    0.7.0.1
 */