package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class b
  implements View.OnClickListener
{
  protected Context mContext;
  protected int mgy;
  protected int nok;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.mgy = 1301;
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null.");
    }
  }
  
  protected static int a(Context paramContext, n paramn)
  {
    if (paramn == null)
    {
      ab.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
      return 0;
    }
    if (!bo.isNullOrNil(paramn.field_appId))
    {
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("game_app_id", paramn.field_appId);
      localBundle.putInt("game_report_from_scene", 1301);
      return c.b(paramContext, paramn.field_appId, null, localBundle);
    }
    ab.e("MicroMsg.GameMessageOnClickListener", "message type : " + paramn.field_msgType + " ,message.field_appId is null.");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.b
 * JD-Core Version:    0.7.0.1
 */