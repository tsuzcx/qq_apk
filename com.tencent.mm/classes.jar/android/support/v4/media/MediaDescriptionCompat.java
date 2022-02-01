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
  private final CharSequence Eo;
  final String Jh;
  private final CharSequence Ji;
  private final CharSequence Jj;
  private final Bitmap Jk;
  private final Uri Jl;
  private final Uri Jm;
  private Object Jn;
  private final Bundle mExtras;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.Jh = paramParcel.readString();
    this.Eo = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Ji = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Jj = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.Jk = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    this.Jl = ((Uri)paramParcel.readParcelable(localClassLoader));
    this.mExtras = paramParcel.readBundle(localClassLoader);
    this.Jm = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.Jh = paramString;
    this.Eo = paramCharSequence1;
    this.Ji = paramCharSequence2;
    this.Jj = paramCharSequence3;
    this.Jk = paramBitmap;
    this.Jl = paramUri1;
    this.mExtras = paramBundle;
    this.Jm = paramUri2;
  }
  
  public static MediaDescriptionCompat s(Object paramObject)
  {
    a locala;
    Bundle localBundle;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      locala = new a();
      locala.Jh = ((MediaDescription)paramObject).getMediaId();
      locala.Eo = ((MediaDescription)paramObject).getTitle();
      locala.Ji = ((MediaDescription)paramObject).getSubtitle();
      locala.Jj = ((MediaDescription)paramObject).getDescription();
      locala.Jk = ((MediaDescription)paramObject).getIconBitmap();
      locala.Jl = ((MediaDescription)paramObject).getIconUri();
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
          locala.Jm = ((Uri)localObject);
        }
      }
      for (;;)
      {
        localObject = new MediaDescriptionCompat(locala.Jh, locala.Eo, locala.Ji, locala.Jj, locala.Jk, locala.Jl, locala.mExtras, locala.Jm);
        ((MediaDescriptionCompat)localObject).Jn = paramObject;
        return localObject;
        localBundle.remove("android.support.v4.media.description.MEDIA_URI");
        localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        break;
        if (Build.VERSION.SDK_INT >= 23) {
          locala.Jm = ((MediaDescription)paramObject).getMediaUri();
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
    return this.Eo + ", " + this.Ji + ", " + this.Jj;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.Jh);
      TextUtils.writeToParcel(this.Eo, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Ji, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Jj, paramParcel, paramInt);
      paramParcel.writeParcelable(this.Jk, paramInt);
      paramParcel.writeParcelable(this.Jl, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.Jm, paramInt);
      return;
    }
    if ((this.Jn != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.Jn;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.Jh;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.Eo;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.Ji;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.Jj;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.Jk;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.Jl;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.mExtras;
    if ((Build.VERSION.SDK_INT < 23) && (this.Jm != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.Jm);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.Jm;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.Jn = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.Jn;
      break;
      localObject = localBundle;
    }
  }
  
  public static final class a
  {
    CharSequence Eo;
    String Jh;
    CharSequence Ji;
    CharSequence Jj;
    Bitmap Jk;
    Uri Jl;
    Uri Jm;
    Bundle mExtras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */