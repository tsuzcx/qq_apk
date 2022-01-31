package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectTextures
  implements ShareModel
{
  public static final Parcelable.Creator<CameraEffectTextures> CREATOR;
  private final Bundle textures;
  
  static
  {
    AppMethodBeat.i(97373);
    CREATOR = new Parcelable.Creator()
    {
      public final CameraEffectTextures createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(97354);
        paramAnonymousParcel = new CameraEffectTextures(paramAnonymousParcel);
        AppMethodBeat.o(97354);
        return paramAnonymousParcel;
      }
      
      public final CameraEffectTextures[] newArray(int paramAnonymousInt)
      {
        return new CameraEffectTextures[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(97373);
  }
  
  CameraEffectTextures(Parcel paramParcel)
  {
    AppMethodBeat.i(97367);
    this.textures = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(97367);
  }
  
  private CameraEffectTextures(CameraEffectTextures.Builder paramBuilder)
  {
    AppMethodBeat.i(97366);
    this.textures = CameraEffectTextures.Builder.access$000(paramBuilder);
    AppMethodBeat.o(97366);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(97370);
    paramString = this.textures.get(paramString);
    AppMethodBeat.o(97370);
    return paramString;
  }
  
  public Bitmap getTextureBitmap(String paramString)
  {
    AppMethodBeat.i(97368);
    paramString = this.textures.get(paramString);
    if ((paramString instanceof Bitmap))
    {
      paramString = (Bitmap)paramString;
      AppMethodBeat.o(97368);
      return paramString;
    }
    AppMethodBeat.o(97368);
    return null;
  }
  
  public Uri getTextureUri(String paramString)
  {
    AppMethodBeat.i(97369);
    paramString = this.textures.get(paramString);
    if ((paramString instanceof Uri))
    {
      paramString = (Uri)paramString;
      AppMethodBeat.o(97369);
      return paramString;
    }
    AppMethodBeat.o(97369);
    return null;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(97371);
    Set localSet = this.textures.keySet();
    AppMethodBeat.o(97371);
    return localSet;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97372);
    paramParcel.writeBundle(this.textures);
    AppMethodBeat.o(97372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.model.CameraEffectTextures
 * JD-Core Version:    0.7.0.1
 */