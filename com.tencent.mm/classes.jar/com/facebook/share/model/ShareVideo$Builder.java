package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideo$Builder
  extends ShareMedia.Builder<ShareVideo, Builder>
{
  private Uri localUrl;
  
  public final ShareVideo build()
  {
    AppMethodBeat.i(97600);
    ShareVideo localShareVideo = new ShareVideo(this, null);
    AppMethodBeat.o(97600);
    return localShareVideo;
  }
  
  final Builder readFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97602);
    paramParcel = readFrom((ShareVideo)paramParcel.readParcelable(ShareVideo.class.getClassLoader()));
    AppMethodBeat.o(97602);
    return paramParcel;
  }
  
  public final Builder readFrom(ShareVideo paramShareVideo)
  {
    AppMethodBeat.i(97601);
    if (paramShareVideo == null)
    {
      AppMethodBeat.o(97601);
      return this;
    }
    paramShareVideo = ((Builder)super.readFrom(paramShareVideo)).setLocalUrl(paramShareVideo.getLocalUrl());
    AppMethodBeat.o(97601);
    return paramShareVideo;
  }
  
  public final Builder setLocalUrl(Uri paramUri)
  {
    this.localUrl = paramUri;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareVideo.Builder
 * JD-Core Version:    0.7.0.1
 */