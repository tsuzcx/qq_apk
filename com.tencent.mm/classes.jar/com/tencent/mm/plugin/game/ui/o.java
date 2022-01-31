package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  extends b
{
  public o(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.nok = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112083);
    if (!(paramView.getTag() instanceof n))
    {
      AppMethodBeat.o(112083);
      return;
    }
    paramView = (n)paramView.getTag();
    switch (paramView.field_msgType)
    {
    default: 
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("game_app_id", paramView.field_appId);
      localBundle.putInt("game_report_from_scene", 1301);
      i = com.tencent.mm.plugin.game.f.c.b(this.mContext, paramView.field_appId, null, localBundle);
      com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
    }
    do
    {
      AppMethodBeat.o(112083);
      return;
    } while (bo.isNullOrNil(paramView.nmY));
    int i = com.tencent.mm.plugin.game.f.c.ax(this.mContext, paramView.nmY);
    com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
    AppMethodBeat.o(112083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.o
 * JD-Core Version:    0.7.0.1
 */