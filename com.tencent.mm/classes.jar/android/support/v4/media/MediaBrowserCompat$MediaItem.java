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
  public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator() {};
  private final int FV;
  private final MediaDescriptionCompat Ln;
  
  MediaBrowserCompat$MediaItem(Parcel paramParcel)
  {
    this.FV = paramParcel.readInt();
    this.Ln = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
  }
  
  private MediaBrowserCompat$MediaItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
  {
    if (paramMediaDescriptionCompat == null) {
      throw new IllegalArgumentException("description cannot be null");
    }
    if (TextUtils.isEmpty(paramMediaDescriptionCompat.Mc)) {
      throw new IllegalArgumentException("description must have a non-empty media id");
    }
    this.FV = paramInt;
    this.Ln = paramMediaDescriptionCompat;
  }
  
  public static List<MediaItem> i(List<?> paramList)
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
      for (paramList = null;; paramList = new MediaItem(MediaDescriptionCompat.v(((MediaBrowser.MediaItem)paramList).getDescription()), i))
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
    localStringBuilder.append("mFlags=").append(this.FV);
    localStringBuilder.append(", mDescription=").append(this.Ln);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.FV);
    this.Ln.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.MediaItem
 * JD-Core Version:    0.7.0.1
 */