package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareFeedContent
  extends ShareContent<ShareFeedContent, Builder>
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
    AppMethodBeat.i(8278);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareFeedContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8267);
        paramAnonymousParcel = new ShareFeedContent(paramAnonymousParcel);
        AppMethodBeat.o(8267);
        return paramAnonymousParcel;
      }
      
      public final ShareFeedContent[] newArray(int paramAnonymousInt)
      {
        return new ShareFeedContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8278);
  }
  
  ShareFeedContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8276);
    this.toId = paramParcel.readString();
    this.link = paramParcel.readString();
    this.linkName = paramParcel.readString();
    this.linkCaption = paramParcel.readString();
    this.linkDescription = paramParcel.readString();
    this.picture = paramParcel.readString();
    this.mediaSource = paramParcel.readString();
    AppMethodBeat.o(8276);
  }
  
  private ShareFeedContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8275);
    this.toId = paramBuilder.toId;
    this.link = paramBuilder.link;
    this.linkName = paramBuilder.linkName;
    this.linkCaption = paramBuilder.linkCaption;
    this.linkDescription = paramBuilder.linkDescription;
    this.picture = paramBuilder.picture;
    this.mediaSource = paramBuilder.mediaSource;
    AppMethodBeat.o(8275);
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
    AppMethodBeat.i(8277);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.toId);
    paramParcel.writeString(this.link);
    paramParcel.writeString(this.linkName);
    paramParcel.writeString(this.linkCaption);
    paramParcel.writeString(this.linkDescription);
    paramParcel.writeString(this.picture);
    paramParcel.writeString(this.mediaSource);
    AppMethodBeat.o(8277);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareFeedContent, Builder>
  {
    private String link;
    private String linkCaption;
    private String linkDescription;
    private String linkName;
    private String mediaSource;
    private String picture;
    private String toId;
    
    public final ShareFeedContent build()
    {
      AppMethodBeat.i(8270);
      ShareFeedContent localShareFeedContent = new ShareFeedContent(this, null);
      AppMethodBeat.o(8270);
      return localShareFeedContent;
    }
    
    public final Builder readFrom(ShareFeedContent paramShareFeedContent)
    {
      AppMethodBeat.i(8271);
      if (paramShareFeedContent == null)
      {
        AppMethodBeat.o(8271);
        return this;
      }
      paramShareFeedContent = ((Builder)super.readFrom(paramShareFeedContent)).setToId(paramShareFeedContent.getToId()).setLink(paramShareFeedContent.getLink()).setLinkName(paramShareFeedContent.getLinkName()).setLinkCaption(paramShareFeedContent.getLinkCaption()).setLinkDescription(paramShareFeedContent.getLinkDescription()).setPicture(paramShareFeedContent.getPicture()).setMediaSource(paramShareFeedContent.getMediaSource());
      AppMethodBeat.o(8271);
      return paramShareFeedContent;
    }
    
    public final Builder setLink(String paramString)
    {
      this.link = paramString;
      return this;
    }
    
    public final Builder setLinkCaption(String paramString)
    {
      this.linkCaption = paramString;
      return this;
    }
    
    public final Builder setLinkDescription(String paramString)
    {
      this.linkDescription = paramString;
      return this;
    }
    
    public final Builder setLinkName(String paramString)
    {
      this.linkName = paramString;
      return this;
    }
    
    public final Builder setMediaSource(String paramString)
    {
      this.mediaSource = paramString;
      return this;
    }
    
    public final Builder setPicture(String paramString)
    {
      this.picture = paramString;
      return this;
    }
    
    public final Builder setToId(String paramString)
    {
      this.toId = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.internal.ShareFeedContent
 * JD-Core Version:    0.7.0.1
 */