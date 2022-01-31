package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new MediaDescriptionCompat.1();
  private final Uri CA;
  private Object CB;
  final String Cu;
  private final CharSequence Cv;
  private final CharSequence Cw;
  private final CharSequence Cx;
  private final Bitmap Cy;
  private final Uri Cz;
  private final Bundle mExtras;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.Cu = paramParcel.readString();
    this.Cv = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Cw = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Cx = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Cy = ((Bitmap)paramParcel.readParcelable(null));
    this.Cz = ((Uri)paramParcel.readParcelable(null));
    this.mExtras = paramParcel.readBundle();
    this.CA = ((Uri)paramParcel.readParcelable(null));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.Cu = paramString;
    this.Cv = paramCharSequence1;
    this.Cw = paramCharSequence2;
    this.Cx = paramCharSequence3;
    this.Cy = paramBitmap;
    this.Cz = paramUri1;
    this.mExtras = paramBundle;
    this.CA = paramUri2;
  }
  
  public static MediaDescriptionCompat t(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      a locala = new a();
      locala.Cu = ((MediaDescription)paramObject).getMediaId();
      locala.Cv = ((MediaDescription)paramObject).getTitle();
      locala.Cw = ((MediaDescription)paramObject).getSubtitle();
      locala.Cx = ((MediaDescription)paramObject).getDescription();
      locala.Cy = ((MediaDescription)paramObject).getIconBitmap();
      locala.Cz = ((MediaDescription)paramObject).getIconUri();
      Bundle localBundle = ((MediaDescription)paramObject).getExtras();
      Object localObject;
      if (localBundle == null)
      {
        localObject = null;
        if (localObject == null) {
          break label209;
        }
        if ((!localBundle.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) || (localBundle.size() != 2)) {
          break label197;
        }
        localBundle = null;
        label123:
        locala.mExtras = localBundle;
        if (localObject == null) {
          break label212;
        }
        locala.CA = ((Uri)localObject);
      }
      for (;;)
      {
        localObject = new MediaDescriptionCompat(locala.Cu, locala.Cv, locala.Cw, locala.Cx, locala.Cy, locala.Cz, locala.mExtras, locala.CA);
        ((MediaDescriptionCompat)localObject).CB = paramObject;
        return localObject;
        localObject = (Uri)localBundle.getParcelable("android.support.v4.media.description.MEDIA_URI");
        break;
        label197:
        localBundle.remove("android.support.v4.media.description.MEDIA_URI");
        localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        label209:
        break label123;
        label212:
        if (Build.VERSION.SDK_INT >= 23) {
          locala.CA = ((MediaDescription)paramObject).getMediaUri();
        }
      }
    }
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return this.Cv + ", " + this.Cw + ", " + this.Cx;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.Cu);
      TextUtils.writeToParcel(this.Cv, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Cw, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Cx, paramParcel, paramInt);
      paramParcel.writeParcelable(this.Cy, paramInt);
      paramParcel.writeParcelable(this.Cz, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.CA, paramInt);
      return;
    }
    if ((this.CB != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.CB;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.Cu;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.Cv;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.Cw;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.Cx;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.Cy;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.Cz;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.mExtras;
    if ((Build.VERSION.SDK_INT < 23) && (this.CA != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.CA);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.CA;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.CB = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.CB;
      break;
      localObject = localBundle;
    }
  }
  
  public static final class a
  {
    Uri CA;
    String Cu;
    CharSequence Cv;
    CharSequence Cw;
    CharSequence Cx;
    Bitmap Cy;
    Uri Cz;
    Bundle mExtras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */