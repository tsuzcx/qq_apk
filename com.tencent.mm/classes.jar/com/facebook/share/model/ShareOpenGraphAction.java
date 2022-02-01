package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphAction
  extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR;
  
  static
  {
    AppMethodBeat.i(8553);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareOpenGraphAction createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8542);
        paramAnonymousParcel = new ShareOpenGraphAction(paramAnonymousParcel);
        AppMethodBeat.o(8542);
        return paramAnonymousParcel;
      }
      
      public final ShareOpenGraphAction[] newArray(int paramAnonymousInt)
      {
        return new ShareOpenGraphAction[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8553);
  }
  
  ShareOpenGraphAction(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  private ShareOpenGraphAction(Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public final String getActionType()
  {
    AppMethodBeat.i(8552);
    String str = getString("og:type");
    AppMethodBeat.o(8552);
    return str;
  }
  
  public static final class Builder
    extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder>
  {
    private static final String ACTION_TYPE_KEY = "og:type";
    
    public final ShareOpenGraphAction build()
    {
      AppMethodBeat.i(8546);
      ShareOpenGraphAction localShareOpenGraphAction = new ShareOpenGraphAction(this, null);
      AppMethodBeat.o(8546);
      return localShareOpenGraphAction;
    }
    
    final Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8548);
      paramParcel = readFrom((ShareOpenGraphAction)paramParcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
      AppMethodBeat.o(8548);
      return paramParcel;
    }
    
    public final Builder readFrom(ShareOpenGraphAction paramShareOpenGraphAction)
    {
      AppMethodBeat.i(8547);
      if (paramShareOpenGraphAction == null)
      {
        AppMethodBeat.o(8547);
        return this;
      }
      paramShareOpenGraphAction = ((Builder)super.readFrom(paramShareOpenGraphAction)).setActionType(paramShareOpenGraphAction.getActionType());
      AppMethodBeat.o(8547);
      return paramShareOpenGraphAction;
    }
    
    public final Builder setActionType(String paramString)
    {
      AppMethodBeat.i(8545);
      putString("og:type", paramString);
      AppMethodBeat.o(8545);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphAction
 * JD-Core Version:    0.7.0.1
 */