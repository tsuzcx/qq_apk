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
    this.udq = paramInt;
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
        paramView = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().xF(((Long)paramView).longValue());
        if (paramView != null) {
          paramView.cYU();
        }
      }
    }
    String str = com.tencent.mm.game.report.f.a(null, null, paramView.ucB, null);
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.udq, paramView.field_msgType, paramView.field_gameMsgId, paramView.ucA, str);
    }
    do
    {
      do
      {
        AppMethodBeat.o(42282);
        return;
        if (!bt.isNullOrNil(paramView.ubC))
        {
          i = c.aB(this.mContext, paramView.ubC);
          com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.udq, paramView.field_msgType, paramView.field_gameMsgId, paramView.ucA, str);
          AppMethodBeat.o(42282);
          return;
        }
        i = a(this.mContext, paramView);
        com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.udq, paramView.field_msgType, paramView.field_gameMsgId, paramView.ucA, str);
        AppMethodBeat.o(42282);
        return;
      } while (bt.isNullOrNil(paramView.ucf));
      i = c.aB(this.mContext, paramView.ucf);
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.udq, paramView.field_msgType, paramView.field_gameMsgId, paramView.ucA, str);
      AppMethodBeat.o(42282);
      return;
    } while (bt.isNullOrNil(paramView.uci));
    int i = c.aB(this.mContext, paramView.uci);
    com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.udq, paramView.field_msgType, paramView.field_gameMsgId, paramView.ucA, str);
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */