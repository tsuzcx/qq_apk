package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E extends Builder>
  implements ShareModel
{
  private final Uri contentUrl;
  private final ShareHashtag hashtag;
  private final String pageId;
  private final List<String> peopleIds;
  private final String placeId;
  private final String ref;
  
  protected ShareContent(Parcel paramParcel)
  {
    this.contentUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.peopleIds = readUnmodifiableStringList(paramParcel);
    this.placeId = paramParcel.readString();
    this.pageId = paramParcel.readString();
    this.ref = paramParcel.readString();
    this.hashtag = new ShareHashtag.Builder().readFrom(paramParcel).build();
  }
  
  protected ShareContent(Builder paramBuilder)
  {
    this.contentUrl = paramBuilder.contentUrl;
    this.peopleIds = paramBuilder.peopleIds;
    this.placeId = paramBuilder.placeId;
    this.pageId = paramBuilder.pageId;
    this.ref = paramBuilder.ref;
    this.hashtag = paramBuilder.hashtag;
  }
  
  private List<String> readUnmodifiableStringList(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    paramParcel.readStringList(localArrayList);
    if (localArrayList.size() == 0) {
      return null;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Uri getContentUrl()
  {
    return this.contentUrl;
  }
  
  public String getPageId()
  {
    return this.pageId;
  }
  
  public List<String> getPeopleIds()
  {
    return this.peopleIds;
  }
  
  public String getPlaceId()
  {
    return this.placeId;
  }
  
  public String getRef()
  {
    return this.ref;
  }
  
  public ShareHashtag getShareHashtag()
  {
    return this.hashtag;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.contentUrl, 0);
    paramParcel.writeStringList(this.peopleIds);
    paramParcel.writeString(this.placeId);
    paramParcel.writeString(this.pageId);
    paramParcel.writeString(this.ref);
    paramParcel.writeParcelable(this.hashtag, 0);
  }
  
  public static abstract class Builder<P extends ShareContent, E extends Builder>
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareContent
 * JD-Core Version:    0.7.0.1
 */