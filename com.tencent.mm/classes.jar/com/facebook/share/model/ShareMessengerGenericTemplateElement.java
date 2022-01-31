package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateElement
  implements ShareModel
{
  public static final Parcelable.Creator<ShareMessengerGenericTemplateElement> CREATOR;
  private final ShareMessengerActionButton button;
  private final ShareMessengerActionButton defaultAction;
  private final Uri imageUrl;
  private final String subtitle;
  private final String title;
  
  static
  {
    AppMethodBeat.i(97476);
    CREATOR = new ShareMessengerGenericTemplateElement.1();
    AppMethodBeat.o(97476);
  }
  
  ShareMessengerGenericTemplateElement(Parcel paramParcel)
  {
    AppMethodBeat.i(97474);
    this.title = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    this.imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.defaultAction = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    this.button = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    AppMethodBeat.o(97474);
  }
  
  private ShareMessengerGenericTemplateElement(ShareMessengerGenericTemplateElement.Builder paramBuilder)
  {
    AppMethodBeat.i(97473);
    this.title = ShareMessengerGenericTemplateElement.Builder.access$000(paramBuilder);
    this.subtitle = ShareMessengerGenericTemplateElement.Builder.access$100(paramBuilder);
    this.imageUrl = ShareMessengerGenericTemplateElement.Builder.access$200(paramBuilder);
    this.defaultAction = ShareMessengerGenericTemplateElement.Builder.access$300(paramBuilder);
    this.button = ShareMessengerGenericTemplateElement.Builder.access$400(paramBuilder);
    AppMethodBeat.o(97473);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ShareMessengerActionButton getButton()
  {
    return this.button;
  }
  
  public final ShareMessengerActionButton getDefaultAction()
  {
    return this.defaultAction;
  }
  
  public final Uri getImageUrl()
  {
    return this.imageUrl;
  }
  
  public final String getSubtitle()
  {
    return this.subtitle;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97475);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.subtitle);
    paramParcel.writeParcelable(this.imageUrl, paramInt);
    paramParcel.writeParcelable(this.defaultAction, paramInt);
    paramParcel.writeParcelable(this.button, paramInt);
    AppMethodBeat.o(97475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerGenericTemplateElement
 * JD-Core Version:    0.7.0.1
 */