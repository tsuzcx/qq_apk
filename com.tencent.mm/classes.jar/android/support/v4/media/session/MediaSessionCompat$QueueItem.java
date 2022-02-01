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
  private final MediaDescriptionCompat Ln;
  private final long MS;
  private Object MT;
  
  MediaSessionCompat$QueueItem(Parcel paramParcel)
  {
    this.Ln = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    this.MS = paramParcel.readLong();
  }
  
  private MediaSessionCompat$QueueItem(Object paramObject, MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong)
  {
    if (paramMediaDescriptionCompat == null) {
      throw new IllegalArgumentException("Description cannot be null.");
    }
    if (paramLong == -1L) {
      throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
    }
    this.Ln = paramMediaDescriptionCompat;
    this.MS = paramLong;
    this.MT = paramObject;
  }
  
  public static List<QueueItem> l(List<?> paramList)
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
      for (paramList = null;; paramList = new QueueItem(paramList, MediaDescriptionCompat.v(((MediaSession.QueueItem)paramList).getDescription()), ((MediaSession.QueueItem)paramList).getQueueId()))
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
    return "MediaSession.QueueItem {Description=" + this.Ln + ", Id=" + this.MS + " }";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.Ln.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.MS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.QueueItem
 * JD-Core Version:    0.7.0.1
 */