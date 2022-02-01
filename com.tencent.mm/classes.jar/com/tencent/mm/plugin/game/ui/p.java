package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class p
  extends b
{
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.rXI = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42282);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      ad.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
      paramView = null;
    }
    while (paramView == null)
    {
      ad.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
      AppMethodBeat.o(42282);
      return;
      if (!(paramView instanceof Long))
      {
        ad.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
        paramView = null;
      }
      else
      {
        paramView = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().qV(((Long)paramView).longValue());
        if (paramView != null) {
          paramView.cDf();
        }
      }
    }
    String str = com.tencent.mm.game.report.e.a(null, null, paramView.rWS, null);
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, str);
    }
    do
    {
      do
      {
        AppMethodBeat.o(42282);
        return;
        if (!bt.isNullOrNil(paramView.rVU))
        {
          i = c.ax(this.mContext, paramView.rVU);
          com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, str);
          AppMethodBeat.o(42282);
          return;
        }
        i = a(this.mContext, paramView);
        com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, str);
        AppMethodBeat.o(42282);
        return;
      } while (bt.isNullOrNil(paramView.rWx));
      i = c.ax(this.mContext, paramView.rWx);
      com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, str);
      AppMethodBeat.o(42282);
      return;
    } while (bt.isNullOrNil(paramView.rWA));
    int i = c.ax(this.mContext, paramView.rWA);
    com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.rXI, paramView.field_msgType, paramView.field_gameMsgId, paramView.rWR, str);
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */