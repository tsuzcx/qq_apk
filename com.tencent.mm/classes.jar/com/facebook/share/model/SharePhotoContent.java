package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent
  extends ShareContent<SharePhotoContent, SharePhotoContent.Builder>
{
  public static final Parcelable.Creator<SharePhotoContent> CREATOR;
  private final List<SharePhoto> photos;
  
  static
  {
    AppMethodBeat.i(97581);
    CREATOR = new SharePhotoContent.1();
    AppMethodBeat.o(97581);
  }
  
  SharePhotoContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97579);
    this.photos = Collections.unmodifiableList(SharePhoto.Builder.readPhotoListFrom(paramParcel));
    AppMethodBeat.o(97579);
  }
  
  private SharePhotoContent(SharePhotoContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97578);
    this.photos = Collections.unmodifiableList(SharePhotoContent.Builder.access$000(paramBuilder));
    AppMethodBeat.o(97578);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final List<SharePhoto> getPhotos()
  {
    return this.photos;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97580);
    super.writeToParcel(paramParcel, paramInt);
    SharePhoto.Builder.writePhotoListTo(paramParcel, paramInt, this.photos);
    AppMethodBeat.o(97580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.model.SharePhotoContent
 * JD-Core Version:    0.7.0.1
 */