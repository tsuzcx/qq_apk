package com.tencent.mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public class ShortcutBroadCastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      y.e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
      return;
    }
    h.bC(paramContext, paramContext.getString(a.h.app_added));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.ShortcutBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */