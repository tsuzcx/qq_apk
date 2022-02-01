package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends b
{
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.xGR = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42282);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      Log.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
      paramView = null;
    }
    while (paramView == null)
    {
      Log.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
      AppMethodBeat.o(42282);
      return;
      if (!(paramView instanceof Long))
      {
        Log.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
        paramView = null;
      }
      else
      {
        paramView = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().GJ(((Long)paramView).longValue());
        if (paramView != null) {
          paramView.dVl();
        }
      }
    }
    String str = com.tencent.mm.game.report.f.a(null, null, paramView.xFX, null);
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.xGR, paramView.field_msgType, paramView.field_gameMsgId, paramView.xFW, str);
    }
    do
    {
      do
      {
        AppMethodBeat.o(42282);
        return;
        if (!Util.isNullOrNil(paramView.xEW))
        {
          i = c.aQ(this.mContext, paramView.xEW);
          com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.xGR, paramView.field_msgType, paramView.field_gameMsgId, paramView.xFW, str);
          AppMethodBeat.o(42282);
          return;
        }
        i = a(this.mContext, paramView);
        com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.xGR, paramView.field_msgType, paramView.field_gameMsgId, paramView.xFW, str);
        AppMethodBeat.o(42282);
        return;
      } while (Util.isNullOrNil(paramView.xFz));
      i = c.aQ(this.mContext, paramView.xFz);
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.xGR, paramView.field_msgType, paramView.field_gameMsgId, paramView.xFW, str);
      AppMethodBeat.o(42282);
      return;
    } while (Util.isNullOrNil(paramView.xFC));
    int i = c.aQ(this.mContext, paramView.xFC);
    com.tencent.mm.game.report.f.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.xGR, paramView.field_msgType, paramView.field_gameMsgId, paramView.xFW, str);
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */