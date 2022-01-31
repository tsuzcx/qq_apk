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
  final String BL;
  private final CharSequence BM;
  private final CharSequence BN;
  private final CharSequence BO;
  private final Bitmap BP;
  private final Uri BQ;
  private final Uri BR;
  private Object BS;
  private final Bundle mExtras;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.BL = paramParcel.readString();
    this.BM = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.BN = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.BO = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.BP = ((Bitmap)paramParcel.readParcelable(null));
    this.BQ = ((Uri)paramParcel.readParcelable(null));
    this.mExtras = paramParcel.readBundle();
    this.BR = ((Uri)paramParcel.readParcelable(null));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.BL = paramString;
    this.BM = paramCharSequence1;
    this.BN = paramCharSequence2;
    this.BO = paramCharSequence3;
    this.BP = paramBitmap;
    this.BQ = paramUri1;
    this.mExtras = paramBundle;
    this.BR = paramUri2;
  }
  
  public static MediaDescriptionCompat t(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      a locala = new a();
      locala.BL = ((MediaDescription)paramObject).getMediaId();
      locala.BM = ((MediaDescription)paramObject).getTitle();
      locala.BN = ((MediaDescription)paramObject).getSubtitle();
      locala.BO = ((MediaDescription)paramObject).getDescription();
      locala.BP = ((MediaDescription)paramObject).getIconBitmap();
      locala.BQ = ((MediaDescription)paramObject).getIconUri();
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
        locala.BR = ((Uri)localObject);
      }
      for (;;)
      {
        localObject = new MediaDescriptionCompat(locala.BL, locala.BM, locala.BN, locala.BO, locala.BP, locala.BQ, locala.mExtras, locala.BR);
        ((MediaDescriptionCompat)localObject).BS = paramObject;
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
          locala.BR = ((MediaDescription)paramObject).getMediaUri();
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
    return this.BM + ", " + this.BN + ", " + this.BO;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.BL);
      TextUtils.writeToParcel(this.BM, paramParcel, paramInt);
      TextUtils.writeToParcel(this.BN, paramParcel, paramInt);
      TextUtils.writeToParcel(this.BO, paramParcel, paramInt);
      paramParcel.writeParcelable(this.BP, paramInt);
      paramParcel.writeParcelable(this.BQ, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.BR, paramInt);
      return;
    }
    if ((this.BS != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.BS;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.BL;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.BM;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.BN;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.BO;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.BP;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.BQ;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.mExtras;
    if ((Build.VERSION.SDK_INT < 23) && (this.BR != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.BR);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.BR;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.BS = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.BS;
      break;
      localObject = localBundle;
    }
  }
  
  public static final class a
  {
    String BL;
    CharSequence BM;
    CharSequence BN;
    CharSequence BO;
    Bitmap BP;
    Uri BQ;
    Uri BR;
    Bundle mExtras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */