package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    AppMethodBeat.i(8589);
    CREATOR = new Parcelable.Creator()
    {
      public final SharePhoto createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8575);
        paramAnonymousParcel = new SharePhoto(paramAnonymousParcel);
        AppMethodBeat.o(8575);
        return paramAnonymousParcel;
      }
      
      public final SharePhoto[] newArray(int paramAnonymousInt)
      {
        return new SharePhoto[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8589);
  }
  
  SharePhoto(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8587);
    this.bitmap = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    this.imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.userGenerated = bool;
      this.caption = paramParcel.readString();
      AppMethodBeat.o(8587);
      return;
    }
  }
  
  private SharePhoto(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8586);
    this.bitmap = paramBuilder.bitmap;
    this.imageUrl = paramBuilder.imageUrl;
    this.userGenerated = paramBuilder.userGenerated;
    this.caption = paramBuilder.caption;
    AppMethodBeat.o(8586);
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
    AppMethodBeat.i(8588);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.bitmap, 0);
    paramParcel.writeParcelable(this.imageUrl, 0);
    paramInt = i;
    if (this.userGenerated) {
      paramInt = 1;
    }
    paramParcel.writeByte((byte)paramInt);
    paramParcel.writeString(this.caption);
    AppMethodBeat.o(8588);
  }
  
  public static final class Builder
    extends ShareMedia.Builder<SharePhoto, Builder>
  {
    private Bitmap bitmap;
    private String caption;
    private Uri imageUrl;
    private boolean userGenerated;
    
    static List<SharePhoto> readPhotoListFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8582);
      Object localObject = readListFrom(paramParcel);
      paramParcel = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ShareMedia localShareMedia = (ShareMedia)((Iterator)localObject).next();
        if ((localShareMedia instanceof SharePhoto)) {
          paramParcel.add((SharePhoto)localShareMedia);
        }
      }
      AppMethodBeat.o(8582);
      return paramParcel;
    }
    
    static void writePhotoListTo(Parcel paramParcel, int paramInt, List<SharePhoto> paramList)
    {
      AppMethodBeat.i(8581);
      ShareMedia[] arrayOfShareMedia = new ShareMedia[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfShareMedia[i] = ((ShareMedia)paramList.get(i));
        i += 1;
      }
      paramParcel.writeParcelableArray(arrayOfShareMedia, paramInt);
      AppMethodBeat.o(8581);
    }
    
    public final SharePhoto build()
    {
      AppMethodBeat.i(8578);
      SharePhoto localSharePhoto = new SharePhoto(this, null);
      AppMethodBeat.o(8578);
      return localSharePhoto;
    }
    
    final Bitmap getBitmap()
    {
      return this.bitmap;
    }
    
    final Uri getImageUrl()
    {
      return this.imageUrl;
    }
    
    final Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8580);
      paramParcel = readFrom((SharePhoto)paramParcel.readParcelable(SharePhoto.class.getClassLoader()));
      AppMethodBeat.o(8580);
      return paramParcel;
    }
    
    public final Builder readFrom(SharePhoto paramSharePhoto)
    {
      AppMethodBeat.i(8579);
      if (paramSharePhoto == null)
      {
        AppMethodBeat.o(8579);
        return this;
      }
      paramSharePhoto = ((Builder)super.readFrom(paramSharePhoto)).setBitmap(paramSharePhoto.getBitmap()).setImageUrl(paramSharePhoto.getImageUrl()).setUserGenerated(paramSharePhoto.getUserGenerated()).setCaption(paramSharePhoto.getCaption());
      AppMethodBeat.o(8579);
      return paramSharePhoto;
    }
    
    public final Builder setBitmap(Bitmap paramBitmap)
    {
      this.bitmap = paramBitmap;
      return this;
    }
    
    public final Builder setCaption(String paramString)
    {
      this.caption = paramString;
      return this;
    }
    
    public final Builder setImageUrl(Uri paramUri)
    {
      this.imageUrl = paramUri;
      return this;
    }
    
    public final Builder setUserGenerated(boolean paramBoolean)
    {
      this.userGenerated = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.SharePhoto
 * JD-Core Version:    0.7.0.1
 */