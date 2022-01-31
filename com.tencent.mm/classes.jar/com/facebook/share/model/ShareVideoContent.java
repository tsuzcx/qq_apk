package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideoContent
  extends ShareContent<ShareVideoContent, ShareVideoContent.Builder>
  implements ShareModel
{
  public static final Parcelable.Creator<ShareVideoContent> CREATOR;
  private final String contentDescription;
  private final String contentTitle;
  private final SharePhoto previewPhoto;
  private final ShareVideo video;
  
  static
  {
    AppMethodBeat.i(97623);
    CREATOR = new ShareVideoContent.1();
    AppMethodBeat.o(97623);
  }
  
  ShareVideoContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97621);
    this.contentDescription = paramParcel.readString();
    this.contentTitle = paramParcel.readString();
    SharePhoto.Builder localBuilder = new SharePhoto.Builder().readFrom(paramParcel);
    if ((localBuilder.getImageUrl() != null) || (localBuilder.getBitmap() != null)) {}
    for (this.previewPhoto = localBuilder.build();; this.previewPhoto = null)
    {
      this.video = new ShareVideo.Builder().readFrom(paramParcel).build();
      AppMethodBeat.o(97621);
      return;
    }
  }
  
  private ShareVideoContent(ShareVideoContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97620);
    this.contentDescription = ShareVideoContent.Builder.access$000(paramBuilder);
    this.contentTitle = ShareVideoContent.Builder.access$100(paramBuilder);
    this.previewPhoto = ShareVideoContent.Builder.access$200(paramBuilder);
    this.video = ShareVideoContent.Builder.access$300(paramBuilder);
    AppMethodBeat.o(97620);
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
    AppMethodBeat.i(97622);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.contentDescription);
    paramParcel.writeString(this.contentTitle);
    paramParcel.writeParcelable(this.previewPhoto, 0);
    paramParcel.writeParcelable(this.video, 0);
    AppMethodBeat.o(97622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.model.ShareVideoContent
 * JD-Core Version:    0.7.0.1
 */