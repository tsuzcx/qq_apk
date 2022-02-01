package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideo
  extends ShareMedia
{
  public static final Parcelable.Creator<ShareVideo> CREATOR;
  private final Uri localUrl;
  
  static
  {
    AppMethodBeat.i(8633);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareVideo createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8621);
        paramAnonymousParcel = new ShareVideo(paramAnonymousParcel);
        AppMethodBeat.o(8621);
        return paramAnonymousParcel;
      }
      
      public final ShareVideo[] newArray(int paramAnonymousInt)
      {
        return new ShareVideo[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8633);
  }
  
  ShareVideo(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8631);
    this.localUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    AppMethodBeat.o(8631);
  }
  
  private ShareVideo(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8630);
    this.localUrl = paramBuilder.localUrl;
    AppMethodBeat.o(8630);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Uri getLocalUrl()
  {
    return this.localUrl;
  }
  
  public final ShareMedia.Type getMediaType()
  {
    return ShareMedia.Type.VIDEO;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8632);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.localUrl, 0);
    AppMethodBeat.o(8632);
  }
  
  public static final class Builder
    extends ShareMedia.Builder<ShareVideo, Builder>
  {
    private Uri localUrl;
    
    public final ShareVideo build()
    {
      AppMethodBeat.i(8624);
      ShareVideo localShareVideo = new ShareVideo(this, null);
      AppMethodBeat.o(8624);
      return localShareVideo;
    }
    
    final Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8626);
      paramParcel = readFrom((ShareVideo)paramParcel.readParcelable(ShareVideo.class.getClassLoader()));
      AppMethodBeat.o(8626);
      return paramParcel;
    }
    
    public final Builder readFrom(ShareVideo paramShareVideo)
    {
      AppMethodBeat.i(8625);
      if (paramShareVideo == null)
      {
        AppMethodBeat.o(8625);
        return this;
      }
      paramShareVideo = ((Builder)super.readFrom(paramShareVideo)).setLocalUrl(paramShareVideo.getLocalUrl());
      AppMethodBeat.o(8625);
      return paramShareVideo;
    }
    
    public final Builder setLocalUrl(Uri paramUri)
    {
      this.localUrl = paramUri;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareVideo
 * JD-Core Version:    0.7.0.1
 */