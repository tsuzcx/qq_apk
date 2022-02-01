package com.facebook.share.model;

import android.os.Parcel;

public abstract class ShareMessengerActionButton
  implements ShareModel
{
  private final String title;
  
  ShareMessengerActionButton(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
  }
  
  protected ShareMessengerActionButton(Builder paramBuilder)
  {
    this.title = paramBuilder.title;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
  }
  
  public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder>
    implements ShareModelBuilder<M, B>
  {
    private String title;
    
    public B readFrom(M paramM)
    {
      if (paramM == null) {
        return this;
      }
      return setTitle(paramM.getTitle());
    }
    
    public B setTitle(String paramString)
    {
      this.title = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerActionButton
 * JD-Core Version:    0.7.0.1
 */