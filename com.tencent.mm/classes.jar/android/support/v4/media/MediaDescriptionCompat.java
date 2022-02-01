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
  private final CharSequence Fm;
  final String Kc;
  private final CharSequence Kd;
  private final CharSequence Ke;
  private final Bitmap Kf;
  private final Uri Kg;
  private final Uri Kh;
  private Object Ki;
  private final Bundle mExtras;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.Kc = paramParcel.readString();
    this.Fm = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Kd = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Ke = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.Kf = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    this.Kg = ((Uri)paramParcel.readParcelable(localClassLoader));
    this.mExtras = paramParcel.readBundle(localClassLoader);
    this.Kh = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.Kc = paramString;
    this.Fm = paramCharSequence1;
    this.Kd = paramCharSequence2;
    this.Ke = paramCharSequence3;
    this.Kf = paramBitmap;
    this.Kg = paramUri1;
    this.mExtras = paramBundle;
    this.Kh = paramUri2;
  }
  
  public static MediaDescriptionCompat u(Object paramObject)
  {
    a locala;
    Bundle localBundle;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      locala = new a();
      locala.Kc = ((MediaDescription)paramObject).getMediaId();
      locala.Fm = ((MediaDescription)paramObject).getTitle();
      locala.Kd = ((MediaDescription)paramObject).getSubtitle();
      locala.Ke = ((MediaDescription)paramObject).getDescription();
      locala.Kf = ((MediaDescription)paramObject).getIconBitmap();
      locala.Kg = ((MediaDescription)paramObject).getIconUri();
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
          locala.Kh = ((Uri)localObject);
        }
      }
      for (;;)
      {
        localObject = new MediaDescriptionCompat(locala.Kc, locala.Fm, locala.Kd, locala.Ke, locala.Kf, locala.Kg, locala.mExtras, locala.Kh);
        ((MediaDescriptionCompat)localObject).Ki = paramObject;
        return localObject;
        localBundle.remove("android.support.v4.media.description.MEDIA_URI");
        localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        break;
        if (Build.VERSION.SDK_INT >= 23) {
          locala.Kh = ((MediaDescription)paramObject).getMediaUri();
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
    return this.Fm + ", " + this.Kd + ", " + this.Ke;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.Kc);
      TextUtils.writeToParcel(this.Fm, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Kd, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Ke, paramParcel, paramInt);
      paramParcel.writeParcelable(this.Kf, paramInt);
      paramParcel.writeParcelable(this.Kg, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.Kh, paramInt);
      return;
    }
    if ((this.Ki != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.Ki;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.Kc;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.Fm;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.Kd;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.Ke;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.Kf;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.Kg;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.mExtras;
    if ((Build.VERSION.SDK_INT < 23) && (this.Kh != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.Kh);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.Kh;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.Ki = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.Ki;
      break;
      localObject = localBundle;
    }
  }
  
  public static final class a
  {
    CharSequence Fm;
    String Kc;
    CharSequence Kd;
    CharSequence Ke;
    Bitmap Kf;
    Uri Kg;
    Uri Kh;
    Bundle mExtras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */