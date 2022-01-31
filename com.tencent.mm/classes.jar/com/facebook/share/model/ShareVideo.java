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
    AppMethodBeat.i(97609);
    CREATOR = new ShareVideo.1();
    AppMethodBeat.o(97609);
  }
  
  ShareVideo(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97607);
    this.localUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    AppMethodBeat.o(97607);
  }
  
  private ShareVideo(ShareVideo.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97606);
    this.localUrl = ShareVideo.Builder.access$000(paramBuilder);
    AppMethodBeat.o(97606);
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
    AppMethodBeat.i(97608);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.localUrl, 0);
    AppMethodBeat.o(97608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.model.ShareVideo
 * JD-Core Version:    0.7.0.1
 */