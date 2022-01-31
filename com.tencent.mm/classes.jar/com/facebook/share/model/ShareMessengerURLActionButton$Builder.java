package com.facebook.share.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerURLActionButton$Builder
  extends ShareMessengerActionButton.Builder<ShareMessengerURLActionButton, Builder>
{
  private Uri fallbackUrl;
  private boolean isMessengerExtensionURL;
  private boolean shouldHideWebviewShareButton;
  private Uri url;
  private ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio;
  
  public final ShareMessengerURLActionButton build()
  {
    AppMethodBeat.i(97508);
    ShareMessengerURLActionButton localShareMessengerURLActionButton = new ShareMessengerURLActionButton(this, null);
    AppMethodBeat.o(97508);
    return localShareMessengerURLActionButton;
  }
  
  public final Builder readFrom(ShareMessengerURLActionButton paramShareMessengerURLActionButton)
  {
    AppMethodBeat.i(97507);
    if (paramShareMessengerURLActionButton == null)
    {
      AppMethodBeat.o(97507);
      return this;
    }
    paramShareMessengerURLActionButton = setUrl(paramShareMessengerURLActionButton.getUrl()).setIsMessengerExtensionURL(paramShareMessengerURLActionButton.getIsMessengerExtensionURL()).setFallbackUrl(paramShareMessengerURLActionButton.getFallbackUrl()).setWebviewHeightRatio(paramShareMessengerURLActionButton.getWebviewHeightRatio()).setShouldHideWebviewShareButton(paramShareMessengerURLActionButton.getShouldHideWebviewShareButton());
    AppMethodBeat.o(97507);
    return paramShareMessengerURLActionButton;
  }
  
  public final Builder setFallbackUrl(Uri paramUri)
  {
    this.fallbackUrl = paramUri;
    return this;
  }
  
  public final Builder setIsMessengerExtensionURL(boolean paramBoolean)
  {
    this.isMessengerExtensionURL = paramBoolean;
    return this;
  }
  
  public final Builder setShouldHideWebviewShareButton(boolean paramBoolean)
  {
    this.shouldHideWebviewShareButton = paramBoolean;
    return this;
  }
  
  public final Builder setUrl(Uri paramUri)
  {
    this.url = paramUri;
    return this;
  }
  
  public final Builder setWebviewHeightRatio(ShareMessengerURLActionButton.WebviewHeightRatio paramWebviewHeightRatio)
  {
    this.webviewHeightRatio = paramWebviewHeightRatio;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerURLActionButton.Builder
 * JD-Core Version:    0.7.0.1
 */