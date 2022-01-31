package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ExdeviceRankChampionInfoView$2
  implements View.OnClickListener
{
  ExdeviceRankChampionInfoView$2(ExdeviceRankChampionInfoView paramExdeviceRankChampionInfoView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20110);
    if (bo.isNullOrNil(ExdeviceRankChampionInfoView.a(this.lOP)))
    {
      ab.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
      AppMethodBeat.o(20110);
      return;
    }
    paramView = new Intent(this.val$context, ExdeviceProfileUI.class);
    paramView.putExtra("username", ExdeviceRankChampionInfoView.a(this.lOP));
    this.val$context.startActivity(paramView);
    AppMethodBeat.o(20110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView.2
 * JD-Core Version:    0.7.0.1
 */