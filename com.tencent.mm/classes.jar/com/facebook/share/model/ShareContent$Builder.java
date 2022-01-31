package com.facebook.share.model;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent$Builder<P extends ShareContent, E extends Builder>
  implements ShareModelBuilder<P, E>
{
  private Uri contentUrl;
  private ShareHashtag hashtag;
  private String pageId;
  private List<String> peopleIds;
  private String placeId;
  private String ref;
  
  public E readFrom(P paramP)
  {
    if (paramP == null) {
      return this;
    }
    return setContentUrl(paramP.getContentUrl()).setPeopleIds(paramP.getPeopleIds()).setPlaceId(paramP.getPlaceId()).setPageId(paramP.getPageId()).setRef(paramP.getRef());
  }
  
  public E setContentUrl(Uri paramUri)
  {
    this.contentUrl = paramUri;
    return this;
  }
  
  public E setPageId(String paramString)
  {
    this.pageId = paramString;
    return this;
  }
  
  public E setPeopleIds(List<String> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      this.peopleIds = paramList;
      return this;
    }
  }
  
  public E setPlaceId(String paramString)
  {
    this.placeId = paramString;
    return this;
  }
  
  public E setRef(String paramString)
  {
    this.ref = paramString;
    return this;
  }
  
  public E setShareHashtag(ShareHashtag paramShareHashtag)
  {
    this.hashtag = paramShareHashtag;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.model.ShareContent.Builder
 * JD-Core Version:    0.7.0.1
 */