package android.support.v4.media.session;

import android.media.session.MediaSession.QueueItem;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MediaSessionCompat$QueueItem
  implements Parcelable
{
  public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator() {};
  private final MediaDescriptionCompat Iq;
  private final long JV;
  private Object JW;
  
  MediaSessionCompat$QueueItem(Parcel paramParcel)
  {
    this.Iq = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    this.JV = paramParcel.readLong();
  }
  
  private MediaSessionCompat$QueueItem(Object paramObject, MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong)
  {
    if (paramMediaDescriptionCompat == null) {
      throw new IllegalArgumentException("Description cannot be null.");
    }
    if (paramLong == -1L) {
      throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
    }
    this.Iq = paramMediaDescriptionCompat;
    this.JV = paramLong;
    this.JW = paramObject;
  }
  
  public static List<QueueItem> m(List<?> paramList)
  {
    if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {}
      for (paramList = null;; paramList = new QueueItem(paramList, MediaDescriptionCompat.s(((MediaSession.QueueItem)paramList).getDescription()), ((MediaSession.QueueItem)paramList).getQueueId()))
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return localArrayList;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "MediaSession.QueueItem {Description=" + this.Iq + ", Id=" + this.JV + " }";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.Iq.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.JV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.QueueItem
 * JD-Core Version:    0.7.0.1
 */