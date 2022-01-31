package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareCameraEffectContent$Builder
  extends ShareContent.Builder<ShareCameraEffectContent, Builder>
{
  private CameraEffectArguments arguments;
  private String effectId;
  private CameraEffectTextures textures;
  
  public final ShareCameraEffectContent build()
  {
    AppMethodBeat.i(97397);
    ShareCameraEffectContent localShareCameraEffectContent = new ShareCameraEffectContent(this, null);
    AppMethodBeat.o(97397);
    return localShareCameraEffectContent;
  }
  
  public final Builder readFrom(ShareCameraEffectContent paramShareCameraEffectContent)
  {
    AppMethodBeat.i(97398);
    if (paramShareCameraEffectContent == null)
    {
      AppMethodBeat.o(97398);
      return this;
    }
    paramShareCameraEffectContent = ((Builder)super.readFrom(paramShareCameraEffectContent)).setEffectId(this.effectId).setArguments(this.arguments);
    AppMethodBeat.o(97398);
    return paramShareCameraEffectContent;
  }
  
  public final Builder setArguments(CameraEffectArguments paramCameraEffectArguments)
  {
    this.arguments = paramCameraEffectArguments;
    return this;
  }
  
  public final Builder setEffectId(String paramString)
  {
    this.effectId = paramString;
    return this;
  }
  
  public final Builder setTextures(CameraEffectTextures paramCameraEffectTextures)
  {
    this.textures = paramCameraEffectTextures;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.model.ShareCameraEffectContent.Builder
 * JD-Core Version:    0.7.0.1
 */