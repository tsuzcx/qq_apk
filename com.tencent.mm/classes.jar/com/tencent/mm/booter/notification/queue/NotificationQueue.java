package com.tencent.mm.booter.notification.queue;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.k.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue
{
  public ParcelNotificationQueue luu;
  
  private void sz()
  {
    AppMethodBeat.i(20014);
    if (this.luu == null)
    {
      AppMethodBeat.o(20014);
      return;
    }
    Log.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[] { Integer.valueOf(this.luu.size()) });
    if (this.luu.isEmpty())
    {
      h.aQD().edit().putString("com.tencent.preference.notification.queue", "").apply();
      if (this.luu == null) {
        restore();
      }
      Log.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[] { Integer.valueOf(this.luu.size()) });
      AppMethodBeat.o(20014);
      return;
    }
    AppMethodBeat.o(20014);
  }
  
  public final boolean d(NotificationItem paramNotificationItem)
  {
    try
    {
      AppMethodBeat.i(20016);
      if (this.luu == null) {
        restore();
      }
      boolean bool = this.luu.remove(paramNotificationItem);
      if (bool) {
        sz();
      }
      AppMethodBeat.o(20016);
      return bool;
    }
    finally {}
  }
  
  public final boolean e(NotificationItem paramNotificationItem)
  {
    try
    {
      AppMethodBeat.i(20018);
      if (this.luu == null) {
        restore();
      }
      boolean bool = this.luu.add(paramNotificationItem);
      if (bool) {
        sz();
      }
      AppMethodBeat.o(20018);
      return bool;
    }
    finally {}
  }
  
  public final NotificationItem ql(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(20017);
        if (this.luu == null) {
          restore();
        }
        Iterator localIterator = this.luu.iterator();
        if (localIterator.hasNext())
        {
          NotificationItem localNotificationItem = (NotificationItem)localIterator.next();
          if (localNotificationItem.id != paramInt) {
            continue;
          }
          if ((localNotificationItem != null) && (this.luu.remove(localNotificationItem))) {
            sz();
          }
          AppMethodBeat.o(20017);
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
      AppMethodBeat.i(20015);
      Log.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
      if (this.luu == null) {
        this.luu = new ParcelNotificationQueue();
      }
      Log.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[] { Integer.valueOf(this.luu.size()) });
      AppMethodBeat.o(20015);
      return;
    }
    finally {}
  }
  
  public final int size()
  {
    AppMethodBeat.i(20019);
    if (this.luu == null) {
      restore();
    }
    int i = this.luu.size();
    AppMethodBeat.o(20019);
    return i;
  }
  
  public static class ParcelNotificationQueue
    extends LinkedList<NotificationItem>
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelNotificationQueue> CREATOR;
    
    static
    {
      AppMethodBeat.i(20013);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(20013);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(20012);
      paramParcel.writeInt(size());
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeParcelable((NotificationItem)localIterator.next(), 0);
      }
      AppMethodBeat.o(20012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.NotificationQueue
 * JD-Core Version:    0.7.0.1
 */