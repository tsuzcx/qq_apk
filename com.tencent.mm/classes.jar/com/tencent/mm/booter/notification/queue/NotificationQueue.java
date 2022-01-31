package com.tencent.mm.booter.notification.queue;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;

public final class NotificationQueue
{
  public NotificationQueue.ParcelNotificationQueue djO;
  
  private void save()
  {
    if (this.djO == null) {}
    do
    {
      return;
      y.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[] { Integer.valueOf(this.djO.size()) });
    } while (!this.djO.isEmpty());
    f.zO().edit().putString("com.tencent.preference.notification.queue", "").apply();
    if (this.djO == null) {
      restore();
    }
    y.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[] { Integer.valueOf(this.djO.size()) });
  }
  
  public final boolean c(NotificationItem paramNotificationItem)
  {
    try
    {
      if (this.djO == null) {
        restore();
      }
      boolean bool = this.djO.remove(paramNotificationItem);
      if (bool) {
        save();
      }
      return bool;
    }
    finally {}
  }
  
  public final boolean d(NotificationItem paramNotificationItem)
  {
    try
    {
      if (this.djO == null) {
        restore();
      }
      boolean bool = this.djO.add(paramNotificationItem);
      if (bool) {
        save();
      }
      return bool;
    }
    finally {}
  }
  
  public final NotificationItem fY(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.djO == null) {
          restore();
        }
        Iterator localIterator = this.djO.iterator();
        if (localIterator.hasNext())
        {
          NotificationItem localNotificationItem = (NotificationItem)localIterator.next();
          if (localNotificationItem.id != paramInt) {
            continue;
          }
          if ((localNotificationItem != null) && (this.djO.remove(localNotificationItem))) {
            save();
          }
          return localNotificationItem;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public final void restore()
  {
    try
    {
      y.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
      if (this.djO == null) {
        this.djO = new NotificationQueue.ParcelNotificationQueue();
      }
      y.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[] { Integer.valueOf(this.djO.size()) });
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.NotificationQueue
 * JD-Core Version:    0.7.0.1
 */