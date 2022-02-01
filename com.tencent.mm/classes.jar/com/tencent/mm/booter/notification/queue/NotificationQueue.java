package com.tencent.mm.booter.notification.queue;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class NotificationQueue
{
  public ParcelNotificationQueue fJa;
  
  private void save()
  {
    AppMethodBeat.i(20014);
    if (this.fJa == null)
    {
      AppMethodBeat.o(20014);
      return;
    }
    ae.d("MicroMsg.NotificationCustomQueue", "jacks save: %d", new Object[] { Integer.valueOf(this.fJa.size()) });
    if (this.fJa.isEmpty())
    {
      f.abM().edit().putString("com.tencent.preference.notification.queue", "").apply();
      if (this.fJa == null) {
        restore();
      }
      ae.d("MicroMsg.NotificationCustomQueue", "jacks _reset: %d", new Object[] { Integer.valueOf(this.fJa.size()) });
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
      if (this.fJa == null) {
        restore();
      }
      boolean bool = this.fJa.remove(paramNotificationItem);
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
      if (this.fJa == null) {
        restore();
      }
      boolean bool = this.fJa.add(paramNotificationItem);
      if (bool) {
        save();
      }
      AppMethodBeat.o(20018);
      return bool;
    }
    finally {}
  }
  
  public final NotificationItem kU(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(20017);
        if (this.fJa == null) {
          restore();
        }
        Iterator localIterator = this.fJa.iterator();
        if (localIterator.hasNext())
        {
          NotificationItem localNotificationItem = (NotificationItem)localIterator.next();
          if (localNotificationItem.id != paramInt) {
            continue;
          }
          if ((localNotificationItem != null) && (this.fJa.remove(localNotificationItem))) {
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
      ae.d("MicroMsg.NotificationCustomQueue", "jacks _restore");
      if (this.fJa == null) {
        this.fJa = new ParcelNotificationQueue();
      }
      ae.d("MicroMsg.NotificationCustomQueue", "jacks _restore: %d", new Object[] { Integer.valueOf(this.fJa.size()) });
      AppMethodBeat.o(20015);
      return;
    }
    finally {}
  }
  
  public final int size()
  {
    AppMethodBeat.i(20019);
    if (this.fJa == null) {
      restore();
    }
    int i = this.fJa.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.NotificationQueue
 * JD-Core Version:    0.7.0.1
 */