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
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator() {};
  private final CharSequence Hd;
  final String LS;
  private final CharSequence LT;
  private final CharSequence LU;
  private final Bitmap LV;
  private final Uri LW;
  private final Uri LX;
  private Object LY;
  private final Bundle mExtras;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.LS = paramParcel.readString();
    this.Hd = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.LT = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.LU = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.LV = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    this.LW = ((Uri)paramParcel.readParcelable(localClassLoader));
    this.mExtras = paramParcel.readBundle(localClassLoader);
    this.LX = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.LS = paramString;
    this.Hd = paramCharSequence1;
    this.LT = paramCharSequence2;
    this.LU = paramCharSequence3;
    this.LV = paramBitmap;
    this.LW = paramUri1;
    this.mExtras = paramBundle;
    this.LX = paramUri2;
  }
  
  public static MediaDescriptionCompat v(Object paramObject)
  {
    a locala;
    Bundle localBundle;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      locala = new a();
      locala.LS = ((MediaDescription)paramObject).getMediaId();
      locala.Hd = ((MediaDescription)paramObject).getTitle();
      locala.LT = ((MediaDescription)paramObject).getSubtitle();
      locala.LU = ((MediaDescription)paramObject).getDescription();
      locala.LV = ((MediaDescription)paramObject).getIconBitmap();
      locala.LW = ((MediaDescription)paramObject).getIconUri();
      localBundle = ((MediaDescription)paramObject).getExtras();
      if (localBundle == null) {
        break label235;
      }
      MediaSessionCompat.d(localBundle);
    }
    label211:
    label235:
    for (Object localObject = (Uri)localBundle.getParcelable("android.support.v4.media.description.MEDIA_URI");; localObject = null)
    {
      if (localObject != null) {
        if ((localBundle.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) && (localBundle.size() == 2))
        {
          localBundle = null;
          locala.mExtras = localBundle;
          if (localObject == null) {
            break label211;
          }
          locala.LX = ((Uri)localObject);
        }
      }
      for (;;)
      {
        localObject = new MediaDescriptionCompat(locala.LS, locala.Hd, locala.LT, locala.LU, locala.LV, locala.LW, locala.mExtras, locala.LX);
        ((MediaDescriptionCompat)localObject).LY = paramObject;
        return localObject;
        localBundle.remove("android.support.v4.media.description.MEDIA_URI");
        localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        break;
        if (Build.VERSION.SDK_INT >= 23) {
          locala.LX = ((MediaDescription)paramObject).getMediaUri();
        }
      }
      return null;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return this.Hd + ", " + this.LT + ", " + this.LU;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.LS);
      TextUtils.writeToParcel(this.Hd, paramParcel, paramInt);
      TextUtils.writeToParcel(this.LT, paramParcel, paramInt);
      TextUtils.writeToParcel(this.LU, paramParcel, paramInt);
      paramParcel.writeParcelable(this.LV, paramInt);
      paramParcel.writeParcelable(this.LW, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.LX, paramInt);
      return;
    }
    if ((this.LY != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.LY;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.LS;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.Hd;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.LT;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.LU;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.LV;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.LW;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.mExtras;
    if ((Build.VERSION.SDK_INT < 23) && (this.LX != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.LX);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.LX;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.LY = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.LY;
      break;
      localObject = localBundle;
    }
  }
  
  public static final class a
  {
    CharSequence Hd;
    String LS;
    CharSequence LT;
    CharSequence LU;
    Bitmap LV;
    Uri LW;
    Uri LX;
    Bundle mExtras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */