package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends b
{
  public o(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.rXI = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42277);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.o))
    {
      AppMethodBeat.o(42277);
      return;
    }
    paramView = (com.tencent.mm.plugin.game.model.o)paramView.getTag();
    switch (paramView.field_msgType)
    {
    default: 
      localObject = new Bundle();
      ((Bundle)localObject).putCharSequence("game_app_id", paramView.field_appId);
      ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      i = c.a(this.mContext, paramView.field_appId, null, (Bundle)localObject);
      localObject = e.a(null, null, paramView.rWS, null);
      e.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, (String)localObject);
    }
    do
    {
      AppMethodBeat.o(42277);
      return;
    } while (bt.isNullOrNil(paramView.rWb));
    int i = c.ax(this.mContext, paramView.rWb);
    Object localObject = e.a(null, null, paramView.rWS, null);
    e.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, (String)localObject);
    AppMethodBeat.o(42277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.o
 * JD-Core Version:    0.7.0.1
 */