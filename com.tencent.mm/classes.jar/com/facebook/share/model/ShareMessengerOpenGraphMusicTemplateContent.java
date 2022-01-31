package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerOpenGraphMusicTemplateContent
  extends ShareContent<ShareMessengerOpenGraphMusicTemplateContent, ShareMessengerOpenGraphMusicTemplateContent.Builder>
{
  public static final Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> CREATOR;
  private final ShareMessengerActionButton button;
  private final Uri url;
  
  static
  {
    AppMethodBeat.i(97503);
    CREATOR = new ShareMessengerOpenGraphMusicTemplateContent.1();
    AppMethodBeat.o(97503);
  }
  
  ShareMessengerOpenGraphMusicTemplateContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97501);
    this.url = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.button = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    AppMethodBeat.o(97501);
  }
  
  private ShareMessengerOpenGraphMusicTemplateContent(ShareMessengerOpenGraphMusicTemplateContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97500);
    this.url = ShareMessengerOpenGraphMusicTemplateContent.Builder.access$000(paramBuilder);
    this.button = ShareMessengerOpenGraphMusicTemplateContent.Builder.access$100(paramBuilder);
    AppMethodBeat.o(97500);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ShareMessengerActionButton getButton()
  {
    return this.button;
  }
  
  public final Uri getUrl()
  {
    return this.url;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97502);
    paramParcel.writeParcelable(this.url, paramInt);
    paramParcel.writeParcelable(this.button, paramInt);
    AppMethodBeat.o(97502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent
 * JD-Core Version:    0.7.0.1
 */