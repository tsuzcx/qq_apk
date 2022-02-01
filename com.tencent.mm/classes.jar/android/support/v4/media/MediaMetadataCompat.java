package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.b.a;

public final class MediaMetadataCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator() {};
  static final a<String, Integer> di;
  private static final String[] dj;
  private static final String[] dk;
  private static final String[] dl;
  private Object dm;
  final Bundle mBundle;
  
  static
  {
    a locala = new a();
    di = locala;
    locala.put("android.media.metadata.TITLE", Integer.valueOf(1));
    di.put("android.media.metadata.ARTIST", Integer.valueOf(1));
    di.put("android.media.metadata.DURATION", Integer.valueOf(0));
    di.put("android.media.metadata.ALBUM", Integer.valueOf(1));
    di.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
    di.put("android.media.metadata.WRITER", Integer.valueOf(1));
    di.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
    di.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
    di.put("android.media.metadata.DATE", Integer.valueOf(1));
    di.put("android.media.metadata.YEAR", Integer.valueOf(0));
    di.put("android.media.metadata.GENRE", Integer.valueOf(1));
    di.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
    di.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
    di.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
    di.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
    di.put("android.media.metadata.ART", Integer.valueOf(2));
    di.put("android.media.metadata.ART_URI", Integer.valueOf(1));
    di.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
    di.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
    di.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
    di.put("android.media.metadata.RATING", Integer.valueOf(3));
    di.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
    di.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
    di.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
    di.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
    di.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
    di.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
    di.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
    di.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
    di.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
    di.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
    dj = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
    dk = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    dl = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
  }
  
  MediaMetadataCompat(Parcel paramParcel)
  {
    this.mBundle = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
  }
  
  public static MediaMetadataCompat e(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      ((MediaMetadata)paramObject).writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      MediaMetadataCompat localMediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      localMediaMetadataCompat.dm = paramObject;
      return localMediaMetadataCompat;
    }
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.mBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaMetadataCompat
 * JD-Core Version:    0.7.0.1
 */