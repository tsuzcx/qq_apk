package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MMReceivers$BootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {}
    do
    {
      return;
      new StringBuilder("system booted, pid=").append(Process.myPid());
    } while (b.s(paramContext, "auto"));
    MMReceivers.AlarmReceiver.aW(paramContext);
    y.cqL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.BootReceiver
 * JD-Core Version:    0.7.0.1
 */