package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceRankChampionInfoView$1
  implements View.OnClickListener
{
  ExdeviceRankChampionInfoView$1(ExdeviceRankChampionInfoView paramExdeviceRankChampionInfoView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl(ExdeviceRankChampionInfoView.a(this.jFr)))
    {
      y.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
      return;
    }
    paramView = new Intent(this.val$context, ExdeviceProfileUI.class);
    paramView.putExtra("username", ExdeviceRankChampionInfoView.a(this.jFr));
    this.val$context.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankChampionInfoView.1
 * JD-Core Version:    0.7.0.1
 */