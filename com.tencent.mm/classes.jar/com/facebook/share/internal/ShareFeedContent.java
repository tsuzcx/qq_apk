package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareFeedContent
  extends ShareContent<ShareFeedContent, ShareFeedContent.Builder>
{
  public static final Parcelable.Creator<ShareFeedContent> CREATOR;
  private final String link;
  private final String linkCaption;
  private final String linkDescription;
  private final String linkName;
  private final String mediaSource;
  private final String picture;
  private final String toId;
  
  static
  {
    AppMethodBeat.i(97254);
    CREATOR = new ShareFeedContent.1();
    AppMethodBeat.o(97254);
  }
  
  ShareFeedContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97252);
    this.toId = paramParcel.readString();
    this.link = paramParcel.readString();
    this.linkName = paramParcel.readString();
    this.linkCaption = paramParcel.readString();
    this.linkDescription = paramParcel.readString();
    this.picture = paramParcel.readString();
    this.mediaSource = paramParcel.readString();
    AppMethodBeat.o(97252);
  }
  
  private ShareFeedContent(ShareFeedContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97251);
    this.toId = ShareFeedContent.Builder.access$000(paramBuilder);
    this.link = ShareFeedContent.Builder.access$100(paramBuilder);
    this.linkName = ShareFeedContent.Builder.access$200(paramBuilder);
    this.linkCaption = ShareFeedContent.Builder.access$300(paramBuilder);
    this.linkDescription = ShareFeedContent.Builder.access$400(paramBuilder);
    this.picture = ShareFeedContent.Builder.access$500(paramBuilder);
    this.mediaSource = ShareFeedContent.Builder.access$600(paramBuilder);
    AppMethodBeat.o(97251);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public String getLinkCaption()
  {
    return this.linkCaption;
  }
  
  public String getLinkDescription()
  {
    return this.linkDescription;
  }
  
  public String getLinkName()
  {
    return this.linkName;
  }
  
  public String getMediaSource()
  {
    return this.mediaSource;
  }
  
  public String getPicture()
  {
    return this.picture;
  }
  
  public String getToId()
  {
    return this.toId;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97253);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.toId);
    paramParcel.writeString(this.link);
    paramParcel.writeString(this.linkName);
    paramParcel.writeString(this.linkCaption);
    paramParcel.writeString(this.linkDescription);
    paramParcel.writeString(this.picture);
    paramParcel.writeString(this.mediaSource);
    AppMethodBeat.o(97253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.internal.ShareFeedContent
 * JD-Core Version:    0.7.0.1
 */