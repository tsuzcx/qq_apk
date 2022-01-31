package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SharePhoto
  extends ShareMedia
{
  public static final Parcelable.Creator<SharePhoto> CREATOR;
  private final Bitmap bitmap;
  private final String caption;
  private final Uri imageUrl;
  private final boolean userGenerated;
  
  static
  {
    AppMethodBeat.i(97565);
    CREATOR = new Parcelable.Creator()
    {
      public final SharePhoto createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(97551);
        paramAnonymousParcel = new SharePhoto(paramAnonymousParcel);
        AppMethodBeat.o(97551);
        return paramAnonymousParcel;
      }
      
      public final SharePhoto[] newArray(int paramAnonymousInt)
      {
        return new SharePhoto[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(97565);
  }
  
  SharePhoto(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97563);
    this.bitmap = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.userGenerated = bool;
      this.caption = paramParcel.readString();
      AppMethodBeat.o(97563);
      return;
    }
  }
  
  private SharePhoto(SharePhoto.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97562);
    this.bitmap = SharePhoto.Builder.access$000(paramBuilder);
    this.imageUrl = SharePhoto.Builder.access$100(paramBuilder);
    this.userGenerated = SharePhoto.Builder.access$200(paramBuilder);
    this.caption = SharePhoto.Builder.access$300(paramBuilder);
    AppMethodBeat.o(97562);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final String getCaption()
  {
    return this.caption;
  }
  
  public final Uri getImageUrl()
  {
    return this.imageUrl;
  }
  
  public final ShareMedia.Type getMediaType()
  {
    return ShareMedia.Type.PHOTO;
  }
  
  public final boolean getUserGenerated()
  {
    return this.userGenerated;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(97564);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.bitmap, 0);
    paramParcel.writeParcelable(this.imageUrl, 0);
    paramInt = i;
    if (this.userGenerated) {
      paramInt = 1;
    }
    paramParcel.writeByte((byte)paramInt);
    paramParcel.writeString(this.caption);
    AppMethodBeat.o(97564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.SharePhoto
 * JD-Core Version:    0.7.0.1
 */