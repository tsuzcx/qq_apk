package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareMessengerGenericTemplateContent$Builder
  extends ShareContent.Builder<ShareMessengerGenericTemplateContent, Builder>
{
  private ShareMessengerGenericTemplateElement genericTemplateElement;
  private ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio;
  private boolean isSharable;
  
  public ShareMessengerGenericTemplateContent build()
  {
    AppMethodBeat.i(97453);
    ShareMessengerGenericTemplateContent localShareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(this);
    AppMethodBeat.o(97453);
    return localShareMessengerGenericTemplateContent;
  }
  
  public Builder readFrom(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
  {
    AppMethodBeat.i(97454);
    if (paramShareMessengerGenericTemplateContent == null)
    {
      AppMethodBeat.o(97454);
      return this;
    }
    paramShareMessengerGenericTemplateContent = ((Builder)super.readFrom(paramShareMessengerGenericTemplateContent)).setIsSharable(paramShareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(paramShareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(paramShareMessengerGenericTemplateContent.getGenericTemplateElement());
    AppMethodBeat.o(97454);
    return paramShareMessengerGenericTemplateContent;
  }
  
  public Builder setGenericTemplateElement(ShareMessengerGenericTemplateElement paramShareMessengerGenericTemplateElement)
  {
    this.genericTemplateElement = paramShareMessengerGenericTemplateElement;
    return this;
  }
  
  public Builder setImageAspectRatio(ShareMessengerGenericTemplateContent.ImageAspectRatio paramImageAspectRatio)
  {
    this.imageAspectRatio = paramImageAspectRatio;
    return this;
  }
  
  public Builder setIsSharable(boolean paramBoolean)
  {
    this.isSharable = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerGenericTemplateContent.Builder
 * JD-Core Version:    0.7.0.1
 */