package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareCameraEffectContent
  extends ShareContent<ShareCameraEffectContent, ShareCameraEffectContent.Builder>
{
  public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR;
  private CameraEffectArguments arguments;
  private String effectId;
  private CameraEffectTextures textures;
  
  static
  {
    AppMethodBeat.i(97405);
    CREATOR = new ShareCameraEffectContent.1();
    AppMethodBeat.o(97405);
  }
  
  ShareCameraEffectContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97403);
    this.effectId = paramParcel.readString();
    this.arguments = new CameraEffectArguments.Builder().readFrom(paramParcel).build();
    this.textures = new CameraEffectTextures.Builder().readFrom(paramParcel).build();
    AppMethodBeat.o(97403);
  }
  
  private ShareCameraEffectContent(ShareCameraEffectContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97402);
    this.effectId = ShareCameraEffectContent.Builder.access$000(paramBuilder);
    this.arguments = ShareCameraEffectContent.Builder.access$100(paramBuilder);
    this.textures = ShareCameraEffectContent.Builder.access$200(paramBuilder);
    AppMethodBeat.o(97402);
  }
  
  public CameraEffectArguments getArguments()
  {
    return this.arguments;
  }
  
  public String getEffectId()
  {
    return this.effectId;
  }
  
  public CameraEffectTextures getTextures()
  {
    return this.textures;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97404);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.effectId);
    paramParcel.writeParcelable(this.arguments, 0);
    paramParcel.writeParcelable(this.textures, 0);
    AppMethodBeat.o(97404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.model.ShareCameraEffectContent
 * JD-Core Version:    0.7.0.1
 */