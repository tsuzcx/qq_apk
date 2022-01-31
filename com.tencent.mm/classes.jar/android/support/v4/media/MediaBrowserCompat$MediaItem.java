package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaBrowserCompat$MediaItem
  implements Parcelable
{
  public static final Parcelable.Creator<MediaItem> CREATOR = new MediaBrowserCompat.MediaItem.1();
  private final MediaDescriptionCompat AY;
  private final int wg;
  
  MediaBrowserCompat$MediaItem(Parcel paramParcel)
  {
    this.wg = paramParcel.readInt();
    this.AY = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
  }
  
  private MediaBrowserCompat$MediaItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
  {
    if (paramMediaDescriptionCompat == null) {
      throw new IllegalArgumentException("description cannot be null");
    }
    if (TextUtils.isEmpty(paramMediaDescriptionCompat.BL)) {
      throw new IllegalArgumentException("description must have a non-empty media id");
    }
    this.wg = paramInt;
    this.AY = paramMediaDescriptionCompat;
  }
  
  public static List<MediaItem> j(List<?> paramList)
  {
    if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {}
      int i;
      for (paramList = null;; paramList = new MediaItem(MediaDescriptionCompat.t(((MediaBrowser.MediaItem)paramList).getDescription()), i))
      {
        localArrayList.add(paramList);
        break;
        i = ((MediaBrowser.MediaItem)paramList).getFlags();
      }
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MediaItem{");
    localStringBuilder.append("mFlags=").append(this.wg);
    localStringBuilder.append(", mDescription=").append(this.AY);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.wg);
    this.AY.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.MediaItem
 * JD-Core Version:    0.7.0.1
 */