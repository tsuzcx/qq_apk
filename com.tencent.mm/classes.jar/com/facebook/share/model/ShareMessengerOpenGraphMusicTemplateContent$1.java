package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareMessengerOpenGraphMusicTemplateContent$1
  implements Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent>
{
  public final ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97492);
    paramParcel = new ShareMessengerOpenGraphMusicTemplateContent(paramParcel);
    AppMethodBeat.o(97492);
    return paramParcel;
  }
  
  public final ShareMessengerOpenGraphMusicTemplateContent[] newArray(int paramInt)
  {
    return new ShareMessengerOpenGraphMusicTemplateContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent.1
 * JD-Core Version:    0.7.0.1
 */