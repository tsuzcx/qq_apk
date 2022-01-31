package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class p
  extends b
{
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.nok = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112087);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      ab.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
      paramView = null;
    }
    while (paramView == null)
    {
      ab.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
      AppMethodBeat.o(112087);
      return;
      if (!(paramView instanceof Long))
      {
        ab.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
        paramView = null;
      }
      else
      {
        paramView = ((e)g.E(e.class)).bES().kl(((Long)paramView).longValue());
        if (paramView != null) {
          paramView.bGm();
        }
      }
    }
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
    }
    do
    {
      do
      {
        AppMethodBeat.o(112087);
        return;
        if (!bo.isNullOrNil(paramView.nmR))
        {
          i = com.tencent.mm.plugin.game.f.c.ax(this.mContext, paramView.nmR);
          com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
          AppMethodBeat.o(112087);
          return;
        }
        i = a(this.mContext, paramView);
        com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
        AppMethodBeat.o(112087);
        return;
      } while (bo.isNullOrNil(paramView.nnt));
      i = com.tencent.mm.plugin.game.f.c.ax(this.mContext, paramView.nnt);
      com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
      AppMethodBeat.o(112087);
      return;
    } while (bo.isNullOrNil(paramView.nnw));
    int i = com.tencent.mm.plugin.game.f.c.ax(this.mContext, paramView.nnw);
    com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.nok, paramView.field_msgType, paramView.field_gameMsgId, paramView.nnM, null);
    AppMethodBeat.o(112087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */