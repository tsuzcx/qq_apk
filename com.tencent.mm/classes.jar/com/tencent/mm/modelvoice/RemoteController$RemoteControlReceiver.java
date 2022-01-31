package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public class RemoteController$RemoteControlReceiver
  extends BroadcastReceiver
{
  private static am byQ;
  private static RemoteController.a eKd;
  
  public static void SY()
  {
    eKd = null;
    if (byQ != null)
    {
      byQ.stopTimer();
      byQ = null;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      if (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction()))
      {
        y.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + paramIntent.getAction());
        return;
      }
      if ((byQ == null) && (eKd != null))
      {
        y.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
        byQ = new am(new RemoteController.RemoteControlReceiver.1(this), true);
      }
    } while (byQ == null);
    byQ.S(1000L, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.RemoteController.RemoteControlReceiver
 * JD-Core Version:    0.7.0.1
 */