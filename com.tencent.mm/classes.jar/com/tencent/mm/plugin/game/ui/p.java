package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class p
  extends b
{
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.tfA = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42282);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      ac.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
      paramView = null;
    }
    while (paramView == null)
    {
      ac.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
      AppMethodBeat.o(42282);
      return;
      if (!(paramView instanceof Long))
      {
        ac.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
        paramView = null;
      }
      else
      {
        paramView = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().vy(((Long)paramView).longValue());
        if (paramView != null) {
          paramView.cQp();
        }
      }
    }
    String str = com.tencent.mm.game.report.e.a(null, null, paramView.teK, null);
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.tfA, paramView.field_msgType, paramView.field_gameMsgId, paramView.teJ, str);
    }
    do
    {
      do
      {
        AppMethodBeat.o(42282);
        return;
        if (!bs.isNullOrNil(paramView.tdM))
        {
          i = c.ay(this.mContext, paramView.tdM);
          com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.tfA, paramView.field_msgType, paramView.field_gameMsgId, paramView.teJ, str);
          AppMethodBeat.o(42282);
          return;
        }
        i = a(this.mContext, paramView);
        com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.tfA, paramView.field_msgType, paramView.field_gameMsgId, paramView.teJ, str);
        AppMethodBeat.o(42282);
        return;
      } while (bs.isNullOrNil(paramView.tep));
      i = c.ay(this.mContext, paramView.tep);
      com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.tfA, paramView.field_msgType, paramView.field_gameMsgId, paramView.teJ, str);
      AppMethodBeat.o(42282);
      return;
    } while (bs.isNullOrNil(paramView.tes));
    int i = c.ay(this.mContext, paramView.tes);
    com.tencent.mm.game.report.e.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.tfA, paramView.field_msgType, paramView.field_gameMsgId, paramView.teJ, str);
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */