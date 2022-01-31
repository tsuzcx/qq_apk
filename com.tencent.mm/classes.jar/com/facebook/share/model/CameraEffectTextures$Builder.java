package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CameraEffectTextures$Builder
  implements ShareModelBuilder<CameraEffectTextures, Builder>
{
  private Bundle textures;
  
  public CameraEffectTextures$Builder()
  {
    AppMethodBeat.i(97357);
    this.textures = new Bundle();
    AppMethodBeat.o(97357);
  }
  
  private Builder putParcelableTexture(String paramString, Parcelable paramParcelable)
  {
    AppMethodBeat.i(97360);
    if ((!Utility.isNullOrEmpty(paramString)) && (paramParcelable != null)) {
      this.textures.putParcelable(paramString, paramParcelable);
    }
    AppMethodBeat.o(97360);
    return this;
  }
  
  public CameraEffectTextures build()
  {
    AppMethodBeat.i(97363);
    CameraEffectTextures localCameraEffectTextures = new CameraEffectTextures(this, null);
    AppMethodBeat.o(97363);
    return localCameraEffectTextures;
  }
  
  public Builder putTexture(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(97358);
    paramString = putParcelableTexture(paramString, paramBitmap);
    AppMethodBeat.o(97358);
    return paramString;
  }
  
  public Builder putTexture(String paramString, Uri paramUri)
  {
    AppMethodBeat.i(97359);
    paramString = putParcelableTexture(paramString, paramUri);
    AppMethodBeat.o(97359);
    return paramString;
  }
  
  public Builder readFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97362);
    paramParcel = readFrom((CameraEffectTextures)paramParcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
    AppMethodBeat.o(97362);
    return paramParcel;
  }
  
  public Builder readFrom(CameraEffectTextures paramCameraEffectTextures)
  {
    AppMethodBeat.i(97361);
    if (paramCameraEffectTextures != null) {
      this.textures.putAll(CameraEffectTextures.access$100(paramCameraEffectTextures));
    }
    AppMethodBeat.o(97361);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.model.CameraEffectTextures.Builder
 * JD-Core Version:    0.7.0.1
 */