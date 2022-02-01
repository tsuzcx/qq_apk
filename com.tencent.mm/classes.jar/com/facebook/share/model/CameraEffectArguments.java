package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectArguments
  implements ShareModel
{
  public static final Parcelable.Creator<CameraEffectArguments> CREATOR;
  private final Bundle params;
  
  static
  {
    AppMethodBeat.i(8377);
    CREATOR = new Parcelable.Creator()
    {
      public final CameraEffectArguments createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8359);
        paramAnonymousParcel = new CameraEffectArguments(paramAnonymousParcel);
        AppMethodBeat.o(8359);
        return paramAnonymousParcel;
      }
      
      public final CameraEffectArguments[] newArray(int paramAnonymousInt)
      {
        return new CameraEffectArguments[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8377);
  }
  
  CameraEffectArguments(Parcel paramParcel)
  {
    AppMethodBeat.i(8371);
    this.params = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(8371);
  }
  
  private CameraEffectArguments(Builder paramBuilder)
  {
    AppMethodBeat.i(8370);
    this.params = paramBuilder.params;
    AppMethodBeat.o(8370);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(8374);
    paramString = this.params.get(paramString);
    AppMethodBeat.o(8374);
    return paramString;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(8372);
    paramString = this.params.getString(paramString);
    AppMethodBeat.o(8372);
    return paramString;
  }
  
  public String[] getStringArray(String paramString)
  {
    AppMethodBeat.i(8373);
    paramString = this.params.getStringArray(paramString);
    AppMethodBeat.o(8373);
    return paramString;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(8375);
    Set localSet = this.params.keySet();
    AppMethodBeat.o(8375);
    return localSet;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8376);
    paramParcel.writeBundle(this.params);
    AppMethodBeat.o(8376);
  }
  
  public static class Builder
    implements ShareModelBuilder<CameraEffectArguments, Builder>
  {
    private Bundle params;
    
    public Builder()
    {
      AppMethodBeat.i(8362);
      this.params = new Bundle();
      AppMethodBeat.o(8362);
    }
    
    public CameraEffectArguments build()
    {
      AppMethodBeat.i(8367);
      CameraEffectArguments localCameraEffectArguments = new CameraEffectArguments(this, null);
      AppMethodBeat.o(8367);
      return localCameraEffectArguments;
    }
    
    public Builder putArgument(String paramString1, String paramString2)
    {
      AppMethodBeat.i(8363);
      this.params.putString(paramString1, paramString2);
      AppMethodBeat.o(8363);
      return this;
    }
    
    public Builder putArgument(String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(8364);
      this.params.putStringArray(paramString, paramArrayOfString);
      AppMethodBeat.o(8364);
      return this;
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8366);
      paramParcel = readFrom((CameraEffectArguments)paramParcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
      AppMethodBeat.o(8366);
      return paramParcel;
    }
    
    public Builder readFrom(CameraEffectArguments paramCameraEffectArguments)
    {
      AppMethodBeat.i(8365);
      if (paramCameraEffectArguments != null) {
        this.params.putAll(paramCameraEffectArguments.params);
      }
      AppMethodBeat.o(8365);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.CameraEffectArguments
 * JD-Core Version:    0.7.0.1
 */