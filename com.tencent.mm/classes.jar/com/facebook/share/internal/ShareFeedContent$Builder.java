package com.facebook.share.internal;

import com.facebook.share.model.ShareContent.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareFeedContent$Builder
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
    AppMethodBeat.i(97246);
    ShareFeedContent localShareFeedContent = new ShareFeedContent(this, null);
    AppMethodBeat.o(97246);
    return localShareFeedContent;
  }
  
  public final Builder readFrom(ShareFeedContent paramShareFeedContent)
  {
    AppMethodBeat.i(97247);
    if (paramShareFeedContent == null)
    {
      AppMethodBeat.o(97247);
      return this;
    }
    paramShareFeedContent = ((Builder)super.readFrom(paramShareFeedContent)).setToId(paramShareFeedContent.getToId()).setLink(paramShareFeedContent.getLink()).setLinkName(paramShareFeedContent.getLinkName()).setLinkCaption(paramShareFeedContent.getLinkCaption()).setLinkDescription(paramShareFeedContent.getLinkDescription()).setPicture(paramShareFeedContent.getPicture()).setMediaSource(paramShareFeedContent.getMediaSource());
    AppMethodBeat.o(97247);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.ShareFeedContent.Builder
 * JD-Core Version:    0.7.0.1
 */