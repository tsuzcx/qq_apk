package com.tencent.mm.booter.notification.queue;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;

public final class NotificationQueue
{
  public NotificationQueue.ParcelNotificationQueue ebi;
  
  private void save()
  {
    AppMethodBeat.i(138161);
    if (this.ebi == null)
    {
      AppMethodBeat.o(138161);
      return;
    }
    ab.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[] { Integer.valueOf(this.ebi.size()) });
    if (this.ebi.isEmpty())
    {
      f.Mv().edit().putString("com.tencent.preference.notification.queue", "").apply();
      if (this.ebi == null) {
        restore();
      }
      ab.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[] { Integer.valueOf(this.ebi.size()) });
      AppMethodBeat.o(138161);
      return;
    }
    AppMethodBeat.o(138161);
  }
  
  public final boolean d(NotificationItem paramNotificationItem)
  {
    try
    {
      AppMethodBeat.i(15984);
      if (this.ebi == null) {
        restore();
      }
      boolean bool = this.ebi.remove(paramNotificationItem);
      if (bool) {
        save();
      }
      AppMethodBeat.o(15984);
      return bool;
    }
    finally {}
  }
  
  public final boolean e(NotificationItem paramNotificationItem)
  {
    try
    {
      AppMethodBeat.i(15986);
      if (this.ebi == null) {
        restore();
      }
      boolean bool = this.ebi.add(paramNotificationItem);
      if (bool) {
        save();
      }
      AppMethodBeat.o(15986);
      return bool;
    }
    finally {}
  }
  
  public final NotificationItem im(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(15985);
        if (this.ebi == null) {
          restore();
        }
        Iterator localIterator = this.ebi.iterator();
        if (localIterator.hasNext())
        {
          NotificationItem localNotificationItem = (NotificationItem)localIterator.next();
          if (localNotificationItem.id != paramInt) {
            continue;
          }
          if ((localNotificationItem != null) && (this.ebi.remove(localNotificationItem))) {
            save();
          }
          AppMethodBeat.o(15985);
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
      AppMethodBeat.i(15983);
      ab.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
      if (this.ebi == null) {
        this.ebi = new NotificationQueue.ParcelNotificationQueue();
      }
      ab.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[] { Integer.valueOf(this.ebi.size()) });
      AppMethodBeat.o(15983);
      return;
    }
    finally {}
  }
  
  public final int size()
  {
    AppMethodBeat.i(15987);
    if (this.ebi == null) {
      restore();
    }
    int i = this.ebi.size();
    AppMethodBeat.o(15987);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.NotificationQueue
 * JD-Core Version:    0.7.0.1
 */