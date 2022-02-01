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
  private final CharSequence Hn;
  final String Mc;
  private final CharSequence Md;
  private final CharSequence Me;
  private final Bitmap Mf;
  private final Uri Mg;
  private final Uri Mh;
  private Object Mi;
  private final Bundle mExtras;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.Mc = paramParcel.readString();
    this.Hn = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Md = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Me = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.Mf = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    this.Mg = ((Uri)paramParcel.readParcelable(localClassLoader));
    this.mExtras = paramParcel.readBundle(localClassLoader);
    this.Mh = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.Mc = paramString;
    this.Hn = paramCharSequence1;
    this.Md = paramCharSequence2;
    this.Me = paramCharSequence3;
    this.Mf = paramBitmap;
    this.Mg = paramUri1;
    this.mExtras = paramBundle;
    this.Mh = paramUri2;
  }
  
  public static MediaDescriptionCompat v(Object paramObject)
  {
    a locala;
    Bundle localBundle;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      locala = new a();
      locala.Mc = ((MediaDescription)paramObject).getMediaId();
      locala.Hn = ((MediaDescription)paramObject).getTitle();
      locala.Md = ((MediaDescription)paramObject).getSubtitle();
      locala.Me = ((MediaDescription)paramObject).getDescription();
      locala.Mf = ((MediaDescription)paramObject).getIconBitmap();
      locala.Mg = ((MediaDescription)paramObject).getIconUri();
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
          locala.Mh = ((Uri)localObject);
        }
      }
      for (;;)
      {
        localObject = new MediaDescriptionCompat(locala.Mc, locala.Hn, locala.Md, locala.Me, locala.Mf, locala.Mg, locala.mExtras, locala.Mh);
        ((MediaDescriptionCompat)localObject).Mi = paramObject;
        return localObject;
        localBundle.remove("android.support.v4.media.description.MEDIA_URI");
        localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        break;
        if (Build.VERSION.SDK_INT >= 23) {
          locala.Mh = ((MediaDescription)paramObject).getMediaUri();
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
    return this.Hn + ", " + this.Md + ", " + this.Me;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.Mc);
      TextUtils.writeToParcel(this.Hn, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Md, paramParcel, paramInt);
      TextUtils.writeToParcel(this.Me, paramParcel, paramInt);
      paramParcel.writeParcelable(this.Mf, paramInt);
      paramParcel.writeParcelable(this.Mg, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.Mh, paramInt);
      return;
    }
    if ((this.Mi != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.Mi;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.Mc;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.Hn;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.Md;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.Me;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.Mf;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.Mg;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.mExtras;
    if ((Build.VERSION.SDK_INT < 23) && (this.Mh != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.Mh);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.Mh;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.Mi = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.Mi;
      break;
      localObject = localBundle;
    }
  }
  
  public static final class a
  {
    CharSequence Hn;
    String Mc;
    CharSequence Md;
    CharSequence Me;
    Bitmap Mf;
    Uri Mg;
    Uri Mh;
    Bundle mExtras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */