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
    AppMethodBeat.i(8441);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareHashtag createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8430);
        paramAnonymousParcel = new ShareHashtag(paramAnonymousParcel);
        AppMethodBeat.o(8430);
        return paramAnonymousParcel;
      }
      
      public final ShareHashtag[] newArray(int paramAnonymousInt)
      {
        return new ShareHashtag[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8441);
  }
  
  ShareHashtag(Parcel paramParcel)
  {
    AppMethodBeat.i(8439);
    this.hashtag = paramParcel.readString();
    AppMethodBeat.o(8439);
  }
  
  private ShareHashtag(Builder paramBuilder)
  {
    AppMethodBeat.i(8438);
    this.hashtag = paramBuilder.hashtag;
    AppMethodBeat.o(8438);
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
    AppMethodBeat.i(8440);
    paramParcel.writeString(this.hashtag);
    AppMethodBeat.o(8440);
  }
  
  public static class Builder
    implements ShareModelBuilder<ShareHashtag, Builder>
  {
    private String hashtag;
    
    public ShareHashtag build()
    {
      AppMethodBeat.i(8435);
      ShareHashtag localShareHashtag = new ShareHashtag(this, null);
      AppMethodBeat.o(8435);
      return localShareHashtag;
    }
    
    public String getHashtag()
    {
      return this.hashtag;
    }
    
    Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8434);
      paramParcel = readFrom((ShareHashtag)paramParcel.readParcelable(ShareHashtag.class.getClassLoader()));
      AppMethodBeat.o(8434);
      return paramParcel;
    }
    
    public Builder readFrom(ShareHashtag paramShareHashtag)
    {
      AppMethodBeat.i(8433);
      if (paramShareHashtag == null)
      {
        AppMethodBeat.o(8433);
        return this;
      }
      paramShareHashtag = setHashtag(paramShareHashtag.getHashtag());
      AppMethodBeat.o(8433);
      return paramShareHashtag;
    }
    
    public Builder setHashtag(String paramString)
    {
      this.hashtag = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareHashtag
 * JD-Core Version:    0.7.0.1
 */