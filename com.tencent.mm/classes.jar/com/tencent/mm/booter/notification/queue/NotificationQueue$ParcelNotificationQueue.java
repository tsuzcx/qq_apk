package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.booter.notification.NotificationItem;
import java.util.Iterator;
import java.util.LinkedList;

public class NotificationQueue$ParcelNotificationQueue
  extends LinkedList<NotificationItem>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelNotificationQueue> CREATOR = new NotificationQueue.ParcelNotificationQueue.1();
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(size());
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((NotificationItem)localIterator.next(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.queue.NotificationQueue.ParcelNotificationQueue
 * JD-Core Version:    0.7.0.1
 */