package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerMediaTemplateContent
  extends ShareContent<ShareMessengerMediaTemplateContent, Builder>
{
  public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR;
  private final String attachmentId;
  private final ShareMessengerActionButton button;
  private final ShareMessengerMediaTemplateContent.MediaType mediaType;
  private final Uri mediaUrl;
  
  static
  {
    AppMethodBeat.i(8515);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareMessengerMediaTemplateContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8501);
        paramAnonymousParcel = new ShareMessengerMediaTemplateContent(paramAnonymousParcel);
        AppMethodBeat.o(8501);
        return paramAnonymousParcel;
      }
      
      public final ShareMessengerMediaTemplateContent[] newArray(int paramAnonymousInt)
      {
        return new ShareMessengerMediaTemplateContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8515);
  }
  
  ShareMessengerMediaTemplateContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8513);
    this.mediaType = ((ShareMessengerMediaTemplateContent.MediaType)paramParcel.readSerializable());
    this.attachmentId = paramParcel.readString();
    this.mediaUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.button = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    AppMethodBeat.o(8513);
  }
  
  private ShareMessengerMediaTemplateContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8512);
    this.mediaType = paramBuilder.mediaType;
    this.attachmentId = paramBuilder.attachmentId;
    this.mediaUrl = paramBuilder.mediaUrl;
    this.button = paramBuilder.button;
    AppMethodBeat.o(8512);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getAttachmentId()
  {
    return this.attachmentId;
  }
  
  public final ShareMessengerActionButton getButton()
  {
    return this.button;
  }
  
  public final ShareMessengerMediaTemplateContent.MediaType getMediaType()
  {
    return this.mediaType;
  }
  
  public final Uri getMediaUrl()
  {
    return this.mediaUrl;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8514);
    paramParcel.writeSerializable(this.mediaType);
    paramParcel.writeString(this.attachmentId);
    paramParcel.writeParcelable(this.mediaUrl, paramInt);
    paramParcel.writeParcelable(this.button, paramInt);
    AppMethodBeat.o(8514);
  }
  
  public static class Builder
    extends ShareContent.Builder<ShareMessengerMediaTemplateContent, Builder>
  {
    private String attachmentId;
    private ShareMessengerActionButton button;
    private ShareMessengerMediaTemplateContent.MediaType mediaType;
    private Uri mediaUrl;
    
    public ShareMessengerMediaTemplateContent build()
    {
      AppMethodBeat.i(8505);
      ShareMessengerMediaTemplateContent localShareMessengerMediaTemplateContent = new ShareMessengerMediaTemplateContent(this, null);
      AppMethodBeat.o(8505);
      return localShareMessengerMediaTemplateContent;
    }
    
    public Builder readFrom(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
    {
      AppMethodBeat.i(8504);
      if (paramShareMessengerMediaTemplateContent == null)
      {
        AppMethodBeat.o(8504);
        return this;
      }
      paramShareMessengerMediaTemplateContent = ((Builder)super.readFrom(paramShareMessengerMediaTemplateContent)).setMediaType(paramShareMessengerMediaTemplateContent.getMediaType()).setAttachmentId(paramShareMessengerMediaTemplateContent.getAttachmentId()).setMediaUrl(paramShareMessengerMediaTemplateContent.getMediaUrl()).setButton(paramShareMessengerMediaTemplateContent.getButton());
      AppMethodBeat.o(8504);
      return paramShareMessengerMediaTemplateContent;
    }
    
    public Builder setAttachmentId(String paramString)
    {
      this.attachmentId = paramString;
      return this;
    }
    
    public Builder setButton(ShareMessengerActionButton paramShareMessengerActionButton)
    {
      this.button = paramShareMessengerActionButton;
      return this;
    }
    
    public Builder setMediaType(ShareMessengerMediaTemplateContent.MediaType paramMediaType)
    {
      this.mediaType = paramMediaType;
      return this;
    }
    
    public Builder setMediaUrl(Uri paramUri)
    {
      this.mediaUrl = paramUri;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerMediaTemplateContent
 * JD-Core Version:    0.7.0.1
 */