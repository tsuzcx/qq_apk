package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E extends ShareContent.Builder>
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
  
  protected ShareContent(ShareContent.Builder paramBuilder)
  {
    this.contentUrl = ShareContent.Builder.access$000(paramBuilder);
    this.peopleIds = ShareContent.Builder.access$100(paramBuilder);
    this.placeId = ShareContent.Builder.access$200(paramBuilder);
    this.pageId = ShareContent.Builder.access$300(paramBuilder);
    this.ref = ShareContent.Builder.access$400(paramBuilder);
    this.hashtag = ShareContent.Builder.access$500(paramBuilder);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.model.ShareContent
 * JD-Core Version:    0.7.0.1
 */