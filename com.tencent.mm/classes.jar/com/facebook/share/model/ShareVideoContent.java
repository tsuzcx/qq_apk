package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideoContent
  extends ShareContent<ShareVideoContent, Builder>
  implements ShareModel
{
  public static final Parcelable.Creator<ShareVideoContent> CREATOR;
  private final String contentDescription;
  private final String contentTitle;
  private final SharePhoto previewPhoto;
  private final ShareVideo video;
  
  static
  {
    AppMethodBeat.i(8647);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareVideoContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8634);
        paramAnonymousParcel = new ShareVideoContent(paramAnonymousParcel);
        AppMethodBeat.o(8634);
        return paramAnonymousParcel;
      }
      
      public final ShareVideoContent[] newArray(int paramAnonymousInt)
      {
        return new ShareVideoContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8647);
  }
  
  ShareVideoContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8645);
    this.contentDescription = paramParcel.readString();
    this.contentTitle = paramParcel.readString();
    SharePhoto.Builder localBuilder = new SharePhoto.Builder().readFrom(paramParcel);
    if ((localBuilder.getImageUrl() != null) || (localBuilder.getBitmap() != null)) {}
    for (this.previewPhoto = localBuilder.build();; this.previewPhoto = null)
    {
      this.video = new ShareVideo.Builder().readFrom(paramParcel).build();
      AppMethodBeat.o(8645);
      return;
    }
  }
  
  private ShareVideoContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8644);
    this.contentDescription = paramBuilder.contentDescription;
    this.contentTitle = paramBuilder.contentTitle;
    this.previewPhoto = paramBuilder.previewPhoto;
    this.video = paramBuilder.video;
    AppMethodBeat.o(8644);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getContentDescription()
  {
    return this.contentDescription;
  }
  
  public final String getContentTitle()
  {
    return this.contentTitle;
  }
  
  public final SharePhoto getPreviewPhoto()
  {
    return this.previewPhoto;
  }
  
  public final ShareVideo getVideo()
  {
    return this.video;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8646);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.contentDescription);
    paramParcel.writeString(this.contentTitle);
    paramParcel.writeParcelable(this.previewPhoto, 0);
    paramParcel.writeParcelable(this.video, 0);
    AppMethodBeat.o(8646);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareVideoContent, Builder>
  {
    private String contentDescription;
    private String contentTitle;
    private SharePhoto previewPhoto;
    private ShareVideo video;
    
    public final ShareVideoContent build()
    {
      AppMethodBeat.i(8639);
      ShareVideoContent localShareVideoContent = new ShareVideoContent(this, null);
      AppMethodBeat.o(8639);
      return localShareVideoContent;
    }
    
    public final Builder readFrom(ShareVideoContent paramShareVideoContent)
    {
      AppMethodBeat.i(8640);
      if (paramShareVideoContent == null)
      {
        AppMethodBeat.o(8640);
        return this;
      }
      paramShareVideoContent = ((Builder)super.readFrom(paramShareVideoContent)).setContentDescription(paramShareVideoContent.getContentDescription()).setContentTitle(paramShareVideoContent.getContentTitle()).setPreviewPhoto(paramShareVideoContent.getPreviewPhoto()).setVideo(paramShareVideoContent.getVideo());
      AppMethodBeat.o(8640);
      return paramShareVideoContent;
    }
    
    public final Builder setContentDescription(String paramString)
    {
      this.contentDescription = paramString;
      return this;
    }
    
    public final Builder setContentTitle(String paramString)
    {
      this.contentTitle = paramString;
      return this;
    }
    
    public final Builder setPreviewPhoto(SharePhoto paramSharePhoto)
    {
      AppMethodBeat.i(8637);
      if (paramSharePhoto == null) {}
      for (paramSharePhoto = null;; paramSharePhoto = new SharePhoto.Builder().readFrom(paramSharePhoto).build())
      {
        this.previewPhoto = paramSharePhoto;
        AppMethodBeat.o(8637);
        return this;
      }
    }
    
    public final Builder setVideo(ShareVideo paramShareVideo)
    {
      AppMethodBeat.i(8638);
      if (paramShareVideo == null)
      {
        AppMethodBeat.o(8638);
        return this;
      }
      this.video = new ShareVideo.Builder().readFrom(paramShareVideo).build();
      AppMethodBeat.o(8638);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareVideoContent
 * JD-Core Version:    0.7.0.1
 */