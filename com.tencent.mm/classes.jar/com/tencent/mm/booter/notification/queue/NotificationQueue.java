package com.tencent.mm.booter.notification.queue;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue
{
  public ParcelNotificationQueue flu;
  
  private void save()
  {
    AppMethodBeat.i(191132);
    if (this.flu == null)
    {
      AppMethodBeat.o(191132);
      return;
    }
    ad.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[] { Integer.valueOf(this.flu.size()) });
    if (this.flu.isEmpty())
    {
      f.Yg().edit().putString("com.tencent.preference.notification.queue", "").apply();
      if (this.flu == null) {
        restore();
      }
      ad.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[] { Integer.valueOf(this.flu.size()) });
      AppMethodBeat.o(191132);
      return;
    }
    AppMethodBeat.o(191132);
  }
  
  public final boolean d(NotificationItem paramNotificationItem)
  {
    try
    {
      AppMethodBeat.i(20016);
      if (this.flu == null) {
        restore();
      }
      boolean bool = this.flu.remove(paramNotificationItem);
      if (bool) {
        save();
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
      if (this.flu == null) {
        restore();
      }
      boolean bool = this.flu.add(paramNotificationItem);
      if (bool) {
        save();
      }
      AppMethodBeat.o(20018);
      return bool;
    }
    finally {}
  }
  
  public final NotificationItem ky(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(20017);
        if (this.flu == null) {
          restore();
        }
        Iterator localIterator = this.flu.iterator();
        if (localIterator.hasNext())
        {
          NotificationItem localNotificationItem = (NotificationItem)localIterator.next();
          if (localNotificationItem.id != paramInt) {
            continue;
          }
          if ((localNotificationItem != null) && (this.flu.remove(localNotificationItem))) {
            save();
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
      ad.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
      if (this.flu == null) {
        this.flu = new ParcelNotificationQueue();
      }
      ad.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[] { Integer.valueOf(this.flu.size()) });
      AppMethodBeat.o(20015);
      return;
    }
    finally {}
  }
  
  public final int size()
  {
    AppMethodBeat.i(20019);
    if (this.flu == null) {
      restore();
    }
    int i = this.flu.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.NotificationQueue
 * JD-Core Version:    0.7.0.1
 */