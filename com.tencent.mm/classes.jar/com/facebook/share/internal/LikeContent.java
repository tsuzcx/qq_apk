package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeContent
  implements ShareModel
{
  @Deprecated
  public static final Parcelable.Creator<LikeContent> CREATOR;
  private final String objectId;
  private final String objectType;
  
  static
  {
    AppMethodBeat.i(8122);
    CREATOR = new Parcelable.Creator()
    {
      public final LikeContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8112);
        paramAnonymousParcel = new LikeContent(paramAnonymousParcel);
        AppMethodBeat.o(8112);
        return paramAnonymousParcel;
      }
      
      public final LikeContent[] newArray(int paramAnonymousInt)
      {
        return new LikeContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8122);
  }
  
  @Deprecated
  LikeContent(Parcel paramParcel)
  {
    AppMethodBeat.i(8120);
    this.objectId = paramParcel.readString();
    this.objectType = paramParcel.readString();
    AppMethodBeat.o(8120);
  }
  
  private LikeContent(Builder paramBuilder)
  {
    AppMethodBeat.i(8119);
    this.objectId = paramBuilder.objectId;
    this.objectType = paramBuilder.objectType;
    AppMethodBeat.o(8119);
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public String getObjectId()
  {
    return this.objectId;
  }
  
  @Deprecated
  public String getObjectType()
  {
    return this.objectType;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8121);
    paramParcel.writeString(this.objectId);
    paramParcel.writeString(this.objectType);
    AppMethodBeat.o(8121);
  }
  
  @Deprecated
  public static class Builder
    implements ShareModelBuilder<LikeContent, Builder>
  {
    private String objectId;
    private String objectType;
    
    @Deprecated
    public LikeContent build()
    {
      AppMethodBeat.i(8115);
      LikeContent localLikeContent = new LikeContent(this, null);
      AppMethodBeat.o(8115);
      return localLikeContent;
    }
    
    @Deprecated
    public Builder readFrom(LikeContent paramLikeContent)
    {
      AppMethodBeat.i(8116);
      if (paramLikeContent == null)
      {
        AppMethodBeat.o(8116);
        return this;
      }
      paramLikeContent = setObjectId(paramLikeContent.getObjectId()).setObjectType(paramLikeContent.getObjectType());
      AppMethodBeat.o(8116);
      return paramLikeContent;
    }
    
    @Deprecated
    public Builder setObjectId(String paramString)
    {
      this.objectId = paramString;
      return this;
    }
    
    @Deprecated
    public Builder setObjectType(String paramString)
    {
      this.objectType = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeContent
 * JD-Core Version:    0.7.0.1
 */