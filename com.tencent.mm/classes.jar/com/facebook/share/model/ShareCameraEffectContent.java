package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareCameraEffectContent
  extends ShareContent<ShareCameraEffectContent, Builder>
{
  public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR;
  private CameraEffectArguments arguments;
  private String effectId;
  private CameraEffectTextures textures;
  
  static
  {
    AppMethodBeat.i(8429);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareCameraEffectContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8418);
        paramAnonymousParcel = new ShareCameraEffectContent(paramAnonymousParcel);
        AppMethodBeat.o(8418);
        return paramAnonymousParcel;
      }
      
      public final ShareCameraEffectContent[] newArray(int paramAnonymousInt)
      {
        return new ShareCameraEffectContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8429);
  }
  
  ShareCameraEffectContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8427);
    this.effectId = paramParcel.readString();
    this.arguments = new CameraEffectArguments.Builder().readFrom(paramParcel).build();
    this.textures = new CameraEffectTextures.Builder().readFrom(paramParcel).build();
    AppMethodBeat.o(8427);
  }
  
  private ShareCameraEffectContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8426);
    this.effectId = paramBuilder.effectId;
    this.arguments = paramBuilder.arguments;
    this.textures = paramBuilder.textures;
    AppMethodBeat.o(8426);
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
    AppMethodBeat.i(8428);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.effectId);
    paramParcel.writeParcelable(this.arguments, 0);
    paramParcel.writeParcelable(this.textures, 0);
    AppMethodBeat.o(8428);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareCameraEffectContent, Builder>
  {
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;
    
    public final ShareCameraEffectContent build()
    {
      AppMethodBeat.i(8421);
      ShareCameraEffectContent localShareCameraEffectContent = new ShareCameraEffectContent(this, null);
      AppMethodBeat.o(8421);
      return localShareCameraEffectContent;
    }
    
    public final Builder readFrom(ShareCameraEffectContent paramShareCameraEffectContent)
    {
      AppMethodBeat.i(8422);
      if (paramShareCameraEffectContent == null)
      {
        AppMethodBeat.o(8422);
        return this;
      }
      paramShareCameraEffectContent = ((Builder)super.readFrom(paramShareCameraEffectContent)).setEffectId(this.effectId).setArguments(this.arguments);
      AppMethodBeat.o(8422);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareCameraEffectContent
 * JD-Core Version:    0.7.0.1
 */