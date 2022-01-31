package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bk;

public final class o
  extends b
{
  public o(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.kQh = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.o)) {}
    do
    {
      return;
      paramView = (com.tencent.mm.plugin.game.model.o)paramView.getTag();
      switch (paramView.field_msgType)
      {
      default: 
        Bundle localBundle = new Bundle();
        localBundle.putCharSequence("game_app_id", paramView.field_appId);
        localBundle.putInt("game_report_from_scene", 1301);
        i = c.b(this.mContext, paramView.field_appId, null, localBundle);
        com.tencent.mm.plugin.game.e.b.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
        return;
      }
    } while (bk.bl(paramView.kPc));
    int i = c.an(this.mContext, paramView.kPc);
    com.tencent.mm.plugin.game.e.b.a(this.mContext, 13, 1301, 5, i, 0, paramView.field_appId, this.kQh, paramView.field_msgType, paramView.field_gameMsgId, paramView.kPN, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.o
 * JD-Core Version:    0.7.0.1
 */