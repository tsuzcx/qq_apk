package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class b
  implements View.OnClickListener
{
  protected int CKU;
  protected Context mContext;
  protected int wvn;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.wvn = 1301;
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null.");
    }
  }
  
  protected static int a(Context paramContext, o paramo)
  {
    if (paramo == null)
    {
      Log.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
      return 0;
    }
    if (!Util.isNullOrNil(paramo.field_appId))
    {
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("game_app_id", paramo.field_appId);
      localBundle.putInt("game_report_from_scene", 1301);
      return c.b(paramContext, paramo.field_appId, null, localBundle);
    }
    Log.e("MicroMsg.GameMessageOnClickListener", "message type : " + paramo.field_msgType + " ,message.field_appId is null.");
    return 0;
  }
  
  protected static o dx(Object paramObject)
  {
    o localo = null;
    if (paramObject == null)
    {
      Log.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
      paramObject = localo;
    }
    do
    {
      return paramObject;
      if (!(paramObject instanceof Long))
      {
        Log.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
        return null;
      }
      localo = ((f)h.ae(f.class)).evo().NP(((Long)paramObject).longValue());
      paramObject = localo;
    } while (localo == null);
    localo.eyt();
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.b
 * JD-Core Version:    0.7.0.1
 */