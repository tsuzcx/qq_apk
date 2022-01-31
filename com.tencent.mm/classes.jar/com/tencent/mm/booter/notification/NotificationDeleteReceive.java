package com.tencent.mm.booter.notification;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;

public class NotificationDeleteReceive
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    try
    {
      i = paramIntent.getIntExtra("com.tencent.notification.id.key", -1);
      y.d("MicroMsg.Notification.Delete.Receive", "receive: %d", new Object[] { Integer.valueOf(i) });
      if (i == -1) {
        return;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Notification.Delete.Receive", paramContext, "", new Object[0]);
        i = -1;
      }
      paramIntent = b.wz().iterator();
    }
    do
    {
      if (!paramIntent.hasNext()) {
        break;
      }
      paramContext = (NotificationItem)paramIntent.next();
    } while ((paramContext == null) || (paramContext.id != i));
    for (;;)
    {
      if (paramContext == null)
      {
        y.w("MicroMsg.Notification.Delete.Receive", "receive delete notification: %d, but no item in queue", new Object[] { Integer.valueOf(i) });
        return;
      }
      if (paramContext.djC != null) {}
      try
      {
        paramContext.djC.send();
        b.wz().remove(i);
        return;
      }
      catch (PendingIntent.CanceledException paramContext)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NotificationItem", paramContext, "Delete intent send Exception?", new Object[0]);
        }
      }
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.notification.NotificationDeleteReceive
 * JD-Core Version:    0.7.0.1
 */