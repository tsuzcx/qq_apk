package com.facebook.share.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareMessengerOpenGraphMusicTemplateContent$Builder
  extends ShareContent.Builder<ShareMessengerOpenGraphMusicTemplateContent, Builder>
{
  private ShareMessengerActionButton button;
  private Uri url;
  
  public ShareMessengerOpenGraphMusicTemplateContent build()
  {
    AppMethodBeat.i(97496);
    ShareMessengerOpenGraphMusicTemplateContent localShareMessengerOpenGraphMusicTemplateContent = new ShareMessengerOpenGraphMusicTemplateContent(this, null);
    AppMethodBeat.o(97496);
    return localShareMessengerOpenGraphMusicTemplateContent;
  }
  
  public Builder readFrom(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
  {
    AppMethodBeat.i(97495);
    if (paramShareMessengerOpenGraphMusicTemplateContent == null)
    {
      AppMethodBeat.o(97495);
      return this;
    }
    paramShareMessengerOpenGraphMusicTemplateContent = ((Builder)super.readFrom(paramShareMessengerOpenGraphMusicTemplateContent)).setUrl(paramShareMessengerOpenGraphMusicTemplateContent.getUrl()).setButton(paramShareMessengerOpenGraphMusicTemplateContent.getButton());
    AppMethodBeat.o(97495);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent.Builder
 * JD-Core Version:    0.7.0.1
 */