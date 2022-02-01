package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends b
{
  public p(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.IFc = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42282);
    paramView = fO(paramView.getTag());
    if (paramView == null)
    {
      Log.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
      AppMethodBeat.o(42282);
      return;
    }
    String str = g.a(null, null, paramView.IEi, null);
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.IFc, paramView.field_msgType, paramView.field_gameMsgId, paramView.mNoticeId, str);
    }
    do
    {
      do
      {
        AppMethodBeat.o(42282);
        return;
        if (!Util.isNullOrNil(paramView.IDi))
        {
          i = c.ba(this.mContext, paramView.IDi);
          g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.IFc, paramView.field_msgType, paramView.field_gameMsgId, paramView.mNoticeId, str);
          AppMethodBeat.o(42282);
          return;
        }
        i = a(this.mContext, paramView);
        g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.IFc, paramView.field_msgType, paramView.field_gameMsgId, paramView.mNoticeId, str);
        AppMethodBeat.o(42282);
        return;
      } while (Util.isNullOrNil(paramView.IDL));
      i = c.ba(this.mContext, paramView.IDL);
      g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.IFc, paramView.field_msgType, paramView.field_gameMsgId, paramView.mNoticeId, str);
      AppMethodBeat.o(42282);
      return;
    } while (Util.isNullOrNil(paramView.IDO));
    int i = c.ba(this.mContext, paramView.IDO);
    g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.IFc, paramView.field_msgType, paramView.field_gameMsgId, paramView.mNoticeId, str);
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */