package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerOpenGraphMusicTemplateContent
  extends ShareContent<ShareMessengerOpenGraphMusicTemplateContent, Builder>
{
  public static final Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> CREATOR;
  private final ShareMessengerActionButton button;
  private final Uri url;
  
  static
  {
    AppMethodBeat.i(8527);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8516);
        paramAnonymousParcel = new ShareMessengerOpenGraphMusicTemplateContent(paramAnonymousParcel);
        AppMethodBeat.o(8516);
        return paramAnonymousParcel;
      }
      
      public final ShareMessengerOpenGraphMusicTemplateContent[] newArray(int paramAnonymousInt)
      {
        return new ShareMessengerOpenGraphMusicTemplateContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8527);
  }
  
  ShareMessengerOpenGraphMusicTemplateContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8525);
    this.url = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.button = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    AppMethodBeat.o(8525);
  }
  
  private ShareMessengerOpenGraphMusicTemplateContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8524);
    this.url = paramBuilder.url;
    this.button = paramBuilder.button;
    AppMethodBeat.o(8524);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ShareMessengerActionButton getButton()
  {
    return this.button;
  }
  
  public final Uri getUrl()
  {
    return this.url;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8526);
    paramParcel.writeParcelable(this.url, paramInt);
    paramParcel.writeParcelable(this.button, paramInt);
    AppMethodBeat.o(8526);
  }
  
  public static class Builder
    extends ShareContent.Builder<ShareMessengerOpenGraphMusicTemplateContent, Builder>
  {
    private ShareMessengerActionButton button;
    private Uri url;
    
    public ShareMessengerOpenGraphMusicTemplateContent build()
    {
      AppMethodBeat.i(8520);
      ShareMessengerOpenGraphMusicTemplateContent localShareMessengerOpenGraphMusicTemplateContent = new ShareMessengerOpenGraphMusicTemplateContent(this, null);
      AppMethodBeat.o(8520);
      return localShareMessengerOpenGraphMusicTemplateContent;
    }
    
    public Builder readFrom(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
    {
      AppMethodBeat.i(8519);
      if (paramShareMessengerOpenGraphMusicTemplateContent == null)
      {
        AppMethodBeat.o(8519);
        return this;
      }
      paramShareMessengerOpenGraphMusicTemplateContent = ((Builder)super.readFrom(paramShareMessengerOpenGraphMusicTemplateContent)).setUrl(paramShareMessengerOpenGraphMusicTemplateContent.getUrl()).setButton(paramShareMessengerOpenGraphMusicTemplateContent.getButton());
      AppMethodBeat.o(8519);
      return paramShareMessengerOpenGraphMusicTemplateContent;
    }
    
    public Builder setButton(ShareMessengerActionButton paramShareMessengerActionButton)
    {
      this.button = paramShareMessengerActionButton;
      return this;
    }
    
    public Builder setUrl(Uri paramUri)
    {
      this.url = paramUri;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent
 * JD-Core Version:    0.7.0.1
 */