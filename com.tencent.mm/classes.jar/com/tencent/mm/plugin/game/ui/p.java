package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class p
  extends b
{
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.uoy = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42282);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      ae.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
      paramView = null;
    }
    while (paramView == null)
    {
      ae.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
      AppMethodBeat.o(42282);
      return;
      if (!(paramView instanceof Long))
      {
        ae.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
        paramView = null;
      }
      else
      {
        paramView = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().xZ(((Long)paramView).longValue());
        if (paramView != null) {
          paramView.dbE();
        }
      }
    }
    String str = com.tencent.mm.game.report.f.a(null, null, paramView.unF, null);
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.uoy, paramView.field_msgType, paramView.field_gameMsgId, paramView.unE, str);
    }
    do
    {
      do
      {
        AppMethodBeat.o(42282);
        return;
        if (!bu.isNullOrNil(paramView.umE))
        {
          i = c.aD(this.mContext, paramView.umE);
          com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.uoy, paramView.field_msgType, paramView.field_gameMsgId, paramView.unE, str);
          AppMethodBeat.o(42282);
          return;
        }
        i = a(this.mContext, paramView);
        com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.uoy, paramView.field_msgType, paramView.field_gameMsgId, paramView.unE, str);
        AppMethodBeat.o(42282);
        return;
      } while (bu.isNullOrNil(paramView.unh));
      i = c.aD(this.mContext, paramView.unh);
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.uoy, paramView.field_msgType, paramView.field_gameMsgId, paramView.unE, str);
      AppMethodBeat.o(42282);
      return;
    } while (bu.isNullOrNil(paramView.unk));
    int i = c.aD(this.mContext, paramView.unk);
    com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.uoy, paramView.field_msgType, paramView.field_gameMsgId, paramView.unE, str);
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */