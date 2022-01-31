package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareHashtag
  implements ShareModel
{
  public static final Parcelable.Creator<ShareHashtag> CREATOR;
  private final String hashtag;
  
  static
  {
    AppMethodBeat.i(97417);
    CREATOR = new ShareHashtag.1();
    AppMethodBeat.o(97417);
  }
  
  ShareHashtag(Parcel paramParcel)
  {
    AppMethodBeat.i(97415);
    this.hashtag = paramParcel.readString();
    AppMethodBeat.o(97415);
  }
  
  private ShareHashtag(ShareHashtag.Builder paramBuilder)
  {
    AppMethodBeat.i(97414);
    this.hashtag = ShareHashtag.Builder.access$000(paramBuilder);
    AppMethodBeat.o(97414);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getHashtag()
  {
    return this.hashtag;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97416);
    paramParcel.writeString(this.hashtag);
    AppMethodBeat.o(97416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.model.ShareHashtag
 * JD-Core Version:    0.7.0.1
 */