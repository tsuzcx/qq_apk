package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class b
  implements View.OnClickListener
{
  protected int jMs;
  protected int kQh;
  protected Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.jMs = 1301;
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null.");
    }
  }
  
  protected static int a(Context paramContext, o paramo)
  {
    if (paramo == null)
    {
      y.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
      return 0;
    }
    if (!bk.bl(paramo.field_appId))
    {
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("game_app_id", paramo.field_appId);
      localBundle.putInt("game_report_from_scene", 1301);
      return c.b(paramContext, paramo.field_appId, null, localBundle);
    }
    y.e("MicroMsg.GameMessageOnClickListener", "message type : " + paramo.field_msgType + " ,message.field_appId is null.");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.b
 * JD-Core Version:    0.7.0.1
 */