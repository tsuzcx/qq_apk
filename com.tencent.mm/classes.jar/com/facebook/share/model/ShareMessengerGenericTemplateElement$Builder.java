package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareMessengerGenericTemplateElement$Builder
  implements ShareModelBuilder<ShareMessengerGenericTemplateElement, Builder>
{
  private ShareMessengerActionButton button;
  private ShareMessengerActionButton defaultAction;
  private Uri imageUrl;
  private String subtitle;
  private String title;
  
  public ShareMessengerGenericTemplateElement build()
  {
    AppMethodBeat.i(97468);
    ShareMessengerGenericTemplateElement localShareMessengerGenericTemplateElement = new ShareMessengerGenericTemplateElement(this, null);
    AppMethodBeat.o(97468);
    return localShareMessengerGenericTemplateElement;
  }
  
  Builder readFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97470);
    paramParcel = readFrom((ShareMessengerGenericTemplateElement)paramParcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader()));
    AppMethodBeat.o(97470);
    return paramParcel;
  }
  
  public Builder readFrom(ShareMessengerGenericTemplateElement paramShareMessengerGenericTemplateElement)
  {
    AppMethodBeat.i(97469);
    if (paramShareMessengerGenericTemplateElement == null)
    {
      AppMethodBeat.o(97469);
      return this;
    }
    paramShareMessengerGenericTemplateElement = setTitle(ShareMessengerGenericTemplateElement.access$1000(paramShareMessengerGenericTemplateElement)).setSubtitle(ShareMessengerGenericTemplateElement.access$900(paramShareMessengerGenericTemplateElement)).setImageUrl(ShareMessengerGenericTemplateElement.access$800(paramShareMessengerGenericTemplateElement)).setDefaultAction(ShareMessengerGenericTemplateElement.access$700(paramShareMessengerGenericTemplateElement)).setButton(ShareMessengerGenericTemplateElement.access$600(paramShareMessengerGenericTemplateElement));
    AppMethodBeat.o(97469);
    return paramShareMessengerGenericTemplateElement;
  }
  
  public Builder setButton(ShareMessengerActionButton paramShareMessengerActionButton)
  {
    this.button = paramShareMessengerActionButton;
    return this;
  }
  
  public Builder setDefaultAction(ShareMessengerActionButton paramShareMessengerActionButton)
  {
    this.defaultAction = paramShareMessengerActionButton;
    return this;
  }
  
  public Builder setImageUrl(Uri paramUri)
  {
    this.imageUrl = paramUri;
    return this;
  }
  
  public Builder setSubtitle(String paramString)
  {
    this.subtitle = paramString;
    return this;
  }
  
  public Builder setTitle(String paramString)
  {
    this.title = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerGenericTemplateElement.Builder
 * JD-Core Version:    0.7.0.1
 */