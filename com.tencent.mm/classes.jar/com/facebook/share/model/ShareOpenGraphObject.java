package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphObject
  extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR;
  
  static
  {
    AppMethodBeat.i(8574);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareOpenGraphObject createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8567);
        paramAnonymousParcel = new ShareOpenGraphObject(paramAnonymousParcel);
        AppMethodBeat.o(8567);
        return paramAnonymousParcel;
      }
      
      public final ShareOpenGraphObject[] newArray(int paramAnonymousInt)
      {
        return new ShareOpenGraphObject[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8574);
  }
  
  ShareOpenGraphObject(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  private ShareOpenGraphObject(Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public static final class Builder
    extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder>
  {
    public Builder()
    {
      AppMethodBeat.i(8570);
      putBoolean("fbsdk:create_object", true);
      AppMethodBeat.o(8570);
    }
    
    public final ShareOpenGraphObject build()
    {
      AppMethodBeat.i(8571);
      ShareOpenGraphObject localShareOpenGraphObject = new ShareOpenGraphObject(this, null);
      AppMethodBeat.o(8571);
      return localShareOpenGraphObject;
    }
    
    final Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8572);
      paramParcel = (Builder)readFrom((ShareOpenGraphObject)paramParcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
      AppMethodBeat.o(8572);
      return paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphObject
 * JD-Core Version:    0.7.0.1
 */