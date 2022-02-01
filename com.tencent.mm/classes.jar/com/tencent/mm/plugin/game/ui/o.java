package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
  extends b
{
  public o(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.CKU = paramInt;
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
      i = c.b(this.mContext, paramView.field_appId, null, (Bundle)localObject);
      localObject = g.a(null, null, paramView.CJY, null);
      g.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.CKU, paramView.field_msgType, paramView.field_gameMsgId, paramView.CJX, (String)localObject);
    }
    do
    {
      AppMethodBeat.o(42277);
      return;
    } while (Util.isNullOrNil(paramView.CJe));
    int i = c.aY(this.mContext, paramView.CJe);
    Object localObject = g.a(null, null, paramView.CJY, null);
    g.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.CKU, paramView.field_msgType, paramView.field_gameMsgId, paramView.CJX, (String)localObject);
    AppMethodBeat.o(42277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.o
 * JD-Core Version:    0.7.0.1
 */