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
    this.CKU = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42282);
    paramView = dx(paramView.getTag());
    if (paramView == null)
    {
      Log.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
      AppMethodBeat.o(42282);
      return;
    }
    String str = g.a(null, null, paramView.CJY, null);
    switch (paramView.field_msgType)
    {
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = a(this.mContext, paramView);
      g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.CKU, paramView.field_msgType, paramView.field_gameMsgId, paramView.CJX, str);
    }
    do
    {
      do
      {
        AppMethodBeat.o(42282);
        return;
        if (!Util.isNullOrNil(paramView.CIX))
        {
          i = c.aY(this.mContext, paramView.CIX);
          g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.CKU, paramView.field_msgType, paramView.field_gameMsgId, paramView.CJX, str);
          AppMethodBeat.o(42282);
          return;
        }
        i = a(this.mContext, paramView);
        g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.CKU, paramView.field_msgType, paramView.field_gameMsgId, paramView.CJX, str);
        AppMethodBeat.o(42282);
        return;
      } while (Util.isNullOrNil(paramView.CJA));
      i = c.aY(this.mContext, paramView.CJA);
      g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.CKU, paramView.field_msgType, paramView.field_gameMsgId, paramView.CJX, str);
      AppMethodBeat.o(42282);
      return;
    } while (Util.isNullOrNil(paramView.CJD));
    int i = c.aY(this.mContext, paramView.CJD);
    g.a(this.mContext, 13, 1301, 3, i, 0, paramView.field_appId, this.CKU, paramView.field_msgType, paramView.field_gameMsgId, paramView.CJX, str);
    AppMethodBeat.o(42282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.p
 * JD-Core Version:    0.7.0.1
 */