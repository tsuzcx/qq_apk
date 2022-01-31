package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareLinkContent
  extends ShareContent<ShareLinkContent, ShareLinkContent.Builder>
{
  public static final Parcelable.Creator<ShareLinkContent> CREATOR;
  @Deprecated
  private final String contentDescription;
  @Deprecated
  private final String contentTitle;
  @Deprecated
  private final Uri imageUrl;
  private final String quote;
  
  static
  {
    AppMethodBeat.i(97430);
    CREATOR = new ShareLinkContent.1();
    AppMethodBeat.o(97430);
  }
  
  ShareLinkContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97428);
    this.contentDescription = paramParcel.readString();
    this.contentTitle = paramParcel.readString();
    this.imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.quote = paramParcel.readString();
    AppMethodBeat.o(97428);
  }
  
  private ShareLinkContent(ShareLinkContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97427);
    this.contentDescription = ShareLinkContent.Builder.access$000(paramBuilder);
    this.contentTitle = ShareLinkContent.Builder.access$100(paramBuilder);
    this.imageUrl = ShareLinkContent.Builder.access$200(paramBuilder);
    this.quote = ShareLinkContent.Builder.access$300(paramBuilder);
    AppMethodBeat.o(97427);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public final String getContentDescription()
  {
    return this.contentDescription;
  }
  
  @Deprecated
  public final String getContentTitle()
  {
    return this.contentTitle;
  }
  
  @Deprecated
  public final Uri getImageUrl()
  {
    return this.imageUrl;
  }
  
  public final String getQuote()
  {
    return this.quote;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97429);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.contentDescription);
    paramParcel.writeString(this.contentTitle);
    paramParcel.writeParcelable(this.imageUrl, 0);
    paramParcel.writeString(this.quote);
    AppMethodBeat.o(97429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.model.ShareLinkContent
 * JD-Core Version:    0.7.0.1
 */