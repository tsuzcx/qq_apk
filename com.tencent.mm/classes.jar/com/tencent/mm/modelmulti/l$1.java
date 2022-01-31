package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class l$1
  extends BroadcastReceiver
{
  l$1(l paraml, l.a parama, boolean paramBoolean) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      paramIntent = "";
      y.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", new Object[] { paramIntent });
      if (!"android.intent.action.SCREEN_OFF".equals(paramIntent)) {
        break label89;
      }
    }
    label89:
    for (this.etB.ety = Boolean.valueOf(false);; this.etB.ety = Boolean.valueOf(true))
    {
      if (this.etz != null) {
        this.etz.bX(this.etB.ety.booleanValue());
      }
      if (this.etA) {
        paramContext.unregisterReceiver(this);
      }
      return;
      paramIntent = paramIntent.getAction();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelmulti.l.1
 * JD-Core Version:    0.7.0.1
 */