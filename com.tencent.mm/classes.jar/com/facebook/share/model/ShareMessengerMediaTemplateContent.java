package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerMediaTemplateContent
  extends ShareContent<ShareMessengerMediaTemplateContent, ShareMessengerMediaTemplateContent.Builder>
{
  public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR;
  private final String attachmentId;
  private final ShareMessengerActionButton button;
  private final MediaType mediaType;
  private final Uri mediaUrl;
  
  static
  {
    AppMethodBeat.i(97491);
    CREATOR = new ShareMessengerMediaTemplateContent.1();
    AppMethodBeat.o(97491);
  }
  
  ShareMessengerMediaTemplateContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97489);
    this.mediaType = ((MediaType)paramParcel.readSerializable());
    this.attachmentId = paramParcel.readString();
    this.mediaUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.button = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    AppMethodBeat.o(97489);
  }
  
  private ShareMessengerMediaTemplateContent(ShareMessengerMediaTemplateContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97488);
    this.mediaType = ShareMessengerMediaTemplateContent.Builder.access$000(paramBuilder);
    this.attachmentId = ShareMessengerMediaTemplateContent.Builder.access$100(paramBuilder);
    this.mediaUrl = ShareMessengerMediaTemplateContent.Builder.access$200(paramBuilder);
    this.button = ShareMessengerMediaTemplateContent.Builder.access$300(paramBuilder);
    AppMethodBeat.o(97488);
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
  
  public final MediaType getMediaType()
  {
    return this.mediaType;
  }
  
  public final Uri getMediaUrl()
  {
    return this.mediaUrl;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97490);
    paramParcel.writeSerializable(this.mediaType);
    paramParcel.writeString(this.attachmentId);
    paramParcel.writeParcelable(this.mediaUrl, paramInt);
    paramParcel.writeParcelable(this.button, paramInt);
    AppMethodBeat.o(97490);
  }
  
  public static enum MediaType
  {
    static
    {
      AppMethodBeat.i(97487);
      IMAGE = new MediaType("IMAGE", 0);
      VIDEO = new MediaType("VIDEO", 1);
      $VALUES = new MediaType[] { IMAGE, VIDEO };
      AppMethodBeat.o(97487);
    }
    
    private MediaType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerMediaTemplateContent
 * JD-Core Version:    0.7.0.1
 */