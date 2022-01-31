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
    AppMethodBeat.i(97353);
    CREATOR = new CameraEffectArguments.1();
    AppMethodBeat.o(97353);
  }
  
  CameraEffectArguments(Parcel paramParcel)
  {
    AppMethodBeat.i(97347);
    this.params = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(97347);
  }
  
  private CameraEffectArguments(Builder paramBuilder)
  {
    AppMethodBeat.i(97346);
    this.params = paramBuilder.params;
    AppMethodBeat.o(97346);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(97350);
    paramString = this.params.get(paramString);
    AppMethodBeat.o(97350);
    return paramString;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(97348);
    paramString = this.params.getString(paramString);
    AppMethodBeat.o(97348);
    return paramString;
  }
  
  public String[] getStringArray(String paramString)
  {
    AppMethodBeat.i(97349);
    paramString = this.params.getStringArray(paramString);
    AppMethodBeat.o(97349);
    return paramString;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(97351);
    Set localSet = this.params.keySet();
    AppMethodBeat.o(97351);
    return localSet;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97352);
    paramParcel.writeBundle(this.params);
    AppMethodBeat.o(97352);
  }
  
  public static class Builder
    implements ShareModelBuilder<CameraEffectArguments, Builder>
  {
    private Bundle params;
    
    public Builder()
    {
      AppMethodBeat.i(97338);
      this.params = new Bundle();
      AppMethodBeat.o(97338);
    }
    
    public CameraEffectArguments build()
    {
      AppMethodBeat.i(97343);
      CameraEffectArguments localCameraEffectArguments = new CameraEffectArguments(this, null);
      AppMethodBeat.o(97343);
      return localCameraEffectArguments;
    }
    
    public Builder putArgument(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97339);
      this.params.putString(paramString1, paramString2);
      AppMethodBeat.o(97339);
      return this;
    }
    
    public Builder putArgument(String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(97340);
      this.params.putStringArray(paramString, paramArrayOfString);
      AppMethodBeat.o(97340);
      return this;
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(97342);
      paramParcel = readFrom((CameraEffectArguments)paramParcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
      AppMethodBeat.o(97342);
      return paramParcel;
    }
    
    public Builder readFrom(CameraEffectArguments paramCameraEffectArguments)
    {
      AppMethodBeat.i(97341);
      if (paramCameraEffectArguments != null) {
        this.params.putAll(paramCameraEffectArguments.params);
      }
      AppMethodBeat.o(97341);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.CameraEffectArguments
 * JD-Core Version:    0.7.0.1
 */