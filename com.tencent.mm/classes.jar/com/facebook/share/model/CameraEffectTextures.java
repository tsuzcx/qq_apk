package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectTextures
  implements ShareModel
{
  public static final Parcelable.Creator<CameraEffectTextures> CREATOR;
  private final Bundle textures;
  
  static
  {
    AppMethodBeat.i(8397);
    CREATOR = new Parcelable.Creator()
    {
      public final CameraEffectTextures createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8378);
        paramAnonymousParcel = new CameraEffectTextures(paramAnonymousParcel);
        AppMethodBeat.o(8378);
        return paramAnonymousParcel;
      }
      
      public final CameraEffectTextures[] newArray(int paramAnonymousInt)
      {
        return new CameraEffectTextures[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8397);
  }
  
  CameraEffectTextures(Parcel paramParcel)
  {
    AppMethodBeat.i(8391);
    this.textures = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(8391);
  }
  
  private CameraEffectTextures(Builder paramBuilder)
  {
    AppMethodBeat.i(8390);
    this.textures = paramBuilder.textures;
    AppMethodBeat.o(8390);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(8394);
    paramString = this.textures.get(paramString);
    AppMethodBeat.o(8394);
    return paramString;
  }
  
  public Bitmap getTextureBitmap(String paramString)
  {
    AppMethodBeat.i(8392);
    paramString = this.textures.get(paramString);
    if ((paramString instanceof Bitmap))
    {
      paramString = (Bitmap)paramString;
      AppMethodBeat.o(8392);
      return paramString;
    }
    AppMethodBeat.o(8392);
    return null;
  }
  
  public Uri getTextureUri(String paramString)
  {
    AppMethodBeat.i(8393);
    paramString = this.textures.get(paramString);
    if ((paramString instanceof Uri))
    {
      paramString = (Uri)paramString;
      AppMethodBeat.o(8393);
      return paramString;
    }
    AppMethodBeat.o(8393);
    return null;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(8395);
    Set localSet = this.textures.keySet();
    AppMethodBeat.o(8395);
    return localSet;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8396);
    paramParcel.writeBundle(this.textures);
    AppMethodBeat.o(8396);
  }
  
  public static class Builder
    implements ShareModelBuilder<CameraEffectTextures, Builder>
  {
    private Bundle textures;
    
    public Builder()
    {
      AppMethodBeat.i(8381);
      this.textures = new Bundle();
      AppMethodBeat.o(8381);
    }
    
    private Builder putParcelableTexture(String paramString, Parcelable paramParcelable)
    {
      AppMethodBeat.i(8384);
      if ((!Utility.isNullOrEmpty(paramString)) && (paramParcelable != null)) {
        this.textures.putParcelable(paramString, paramParcelable);
      }
      AppMethodBeat.o(8384);
      return this;
    }
    
    public CameraEffectTextures build()
    {
      AppMethodBeat.i(8387);
      CameraEffectTextures localCameraEffectTextures = new CameraEffectTextures(this, null);
      AppMethodBeat.o(8387);
      return localCameraEffectTextures;
    }
    
    public Builder putTexture(String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(8382);
      paramString = putParcelableTexture(paramString, paramBitmap);
      AppMethodBeat.o(8382);
      return paramString;
    }
    
    public Builder putTexture(String paramString, Uri paramUri)
    {
      AppMethodBeat.i(8383);
      paramString = putParcelableTexture(paramString, paramUri);
      AppMethodBeat.o(8383);
      return paramString;
    }
    
    public Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8386);
      paramParcel = readFrom((CameraEffectTextures)paramParcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
      AppMethodBeat.o(8386);
      return paramParcel;
    }
    
    public Builder readFrom(CameraEffectTextures paramCameraEffectTextures)
    {
      AppMethodBeat.i(8385);
      if (paramCameraEffectTextures != null) {
        this.textures.putAll(paramCameraEffectTextures.textures);
      }
      AppMethodBeat.o(8385);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.CameraEffectTextures
 * JD-Core Version:    0.7.0.1
 */