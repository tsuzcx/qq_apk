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
  final String cY;
  private final CharSequence cZ;
  private final CharSequence da;
  private final CharSequence dc;
  private final Bitmap dd;
  private final Uri de;
  private final Uri dg;
  private Object dh;
  private final Bundle mExtras;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.cY = paramParcel.readString();
    this.cZ = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.da = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.dc = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.dd = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    this.de = ((Uri)paramParcel.readParcelable(localClassLoader));
    this.mExtras = paramParcel.readBundle(localClassLoader);
    this.dg = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.cY = paramString;
    this.cZ = paramCharSequence1;
    this.da = paramCharSequence2;
    this.dc = paramCharSequence3;
    this.dd = paramBitmap;
    this.de = paramUri1;
    this.mExtras = paramBundle;
    this.dg = paramUri2;
  }
  
  public static MediaDescriptionCompat d(Object paramObject)
  {
    a locala;
    Bundle localBundle;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      locala = new a();
      locala.cY = ((MediaDescription)paramObject).getMediaId();
      locala.cZ = ((MediaDescription)paramObject).getTitle();
      locala.da = ((MediaDescription)paramObject).getSubtitle();
      locala.dc = ((MediaDescription)paramObject).getDescription();
      locala.dd = ((MediaDescription)paramObject).getIconBitmap();
      locala.de = ((MediaDescription)paramObject).getIconUri();
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
          locala.dg = ((Uri)localObject);
        }
      }
      for (;;)
      {
        localObject = new MediaDescriptionCompat(locala.cY, locala.cZ, locala.da, locala.dc, locala.dd, locala.de, locala.mExtras, locala.dg);
        ((MediaDescriptionCompat)localObject).dh = paramObject;
        return localObject;
        localBundle.remove("android.support.v4.media.description.MEDIA_URI");
        localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        break;
        if (Build.VERSION.SDK_INT >= 23) {
          locala.dg = ((MediaDescription)paramObject).getMediaUri();
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
    return this.cZ + ", " + this.da + ", " + this.dc;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.cY);
      TextUtils.writeToParcel(this.cZ, paramParcel, paramInt);
      TextUtils.writeToParcel(this.da, paramParcel, paramInt);
      TextUtils.writeToParcel(this.dc, paramParcel, paramInt);
      paramParcel.writeParcelable(this.dd, paramInt);
      paramParcel.writeParcelable(this.de, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.dg, paramInt);
      return;
    }
    if ((this.dh != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.dh;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.cY;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.cZ;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.da;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.dc;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.dd;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.de;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.mExtras;
    if ((Build.VERSION.SDK_INT < 23) && (this.dg != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.dg);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.dg;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.dh = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.dh;
      break;
      localObject = localBundle;
    }
  }
  
  public static final class a
  {
    String cY;
    CharSequence cZ;
    CharSequence da;
    CharSequence dc;
    Bitmap dd;
    Uri de;
    Uri dg;
    Bundle mExtras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */