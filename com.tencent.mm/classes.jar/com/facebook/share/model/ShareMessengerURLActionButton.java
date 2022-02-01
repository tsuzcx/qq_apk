package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerURLActionButton
  extends ShareMessengerActionButton
{
  public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR;
  private final Uri fallbackUrl;
  private final boolean isMessengerExtensionURL;
  private final boolean shouldHideWebviewShareButton;
  private final Uri url;
  private final ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio;
  
  static
  {
    AppMethodBeat.i(8541);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareMessengerURLActionButton createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8528);
        paramAnonymousParcel = new ShareMessengerURLActionButton(paramAnonymousParcel);
        AppMethodBeat.o(8528);
        return paramAnonymousParcel;
      }
      
      public final ShareMessengerURLActionButton[] newArray(int paramAnonymousInt)
      {
        return new ShareMessengerURLActionButton[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8541);
  }
  
  ShareMessengerURLActionButton(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8540);
    this.url = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.isMessengerExtensionURL = bool1;
      this.fallbackUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      this.webviewHeightRatio = ((ShareMessengerURLActionButton.WebviewHeightRatio)paramParcel.readSerializable());
      if (paramParcel.readByte() == 0) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.shouldHideWebviewShareButton = bool1;
      AppMethodBeat.o(8540);
      return;
      bool1 = false;
      break;
    }
  }
  
  private ShareMessengerURLActionButton(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8539);
    this.url = paramBuilder.url;
    this.isMessengerExtensionURL = paramBuilder.isMessengerExtensionURL;
    this.fallbackUrl = paramBuilder.fallbackUrl;
    this.webviewHeightRatio = paramBuilder.webviewHeightRatio;
    this.shouldHideWebviewShareButton = paramBuilder.shouldHideWebviewShareButton;
    AppMethodBeat.o(8539);
  }
  
  public final Uri getFallbackUrl()
  {
    return this.fallbackUrl;
  }
  
  public final boolean getIsMessengerExtensionURL()
  {
    return this.isMessengerExtensionURL;
  }
  
  public final boolean getShouldHideWebviewShareButton()
  {
    return this.shouldHideWebviewShareButton;
  }
  
  public final Uri getUrl()
  {
    return this.url;
  }
  
  public final ShareMessengerURLActionButton.WebviewHeightRatio getWebviewHeightRatio()
  {
    return this.webviewHeightRatio;
  }
  
  public static final class Builder
    extends ShareMessengerActionButton.Builder<ShareMessengerURLActionButton, Builder>
  {
    private Uri fallbackUrl;
    private boolean isMessengerExtensionURL;
    private boolean shouldHideWebviewShareButton;
    private Uri url;
    private ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio;
    
    public final ShareMessengerURLActionButton build()
    {
      AppMethodBeat.i(8532);
      ShareMessengerURLActionButton localShareMessengerURLActionButton = new ShareMessengerURLActionButton(this, null);
      AppMethodBeat.o(8532);
      return localShareMessengerURLActionButton;
    }
    
    public final Builder readFrom(ShareMessengerURLActionButton paramShareMessengerURLActionButton)
    {
      AppMethodBeat.i(8531);
      if (paramShareMessengerURLActionButton == null)
      {
        AppMethodBeat.o(8531);
        return this;
      }
      paramShareMessengerURLActionButton = setUrl(paramShareMessengerURLActionButton.getUrl()).setIsMessengerExtensionURL(paramShareMessengerURLActionButton.getIsMessengerExtensionURL()).setFallbackUrl(paramShareMessengerURLActionButton.getFallbackUrl()).setWebviewHeightRatio(paramShareMessengerURLActionButton.getWebviewHeightRatio()).setShouldHideWebviewShareButton(paramShareMessengerURLActionButton.getShouldHideWebviewShareButton());
      AppMethodBeat.o(8531);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerURLActionButton
 * JD-Core Version:    0.7.0.1
 */