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
    AppMethodBeat.i(8500);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareMessengerGenericTemplateElement createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8489);
        paramAnonymousParcel = new ShareMessengerGenericTemplateElement(paramAnonymousParcel);
        AppMethodBeat.o(8489);
        return paramAnonymousParcel;
      }
      
      public final ShareMessengerGenericTemplateElement[] newArray(int paramAnonymousInt)
      {
        return new ShareMessengerGenericTemplateElement[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8500);
  }
  
  ShareMessengerGenericTemplateElement(Parcel paramParcel)
  {
    AppMethodBeat.i(8498);
    this.title = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    this.imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.defaultAction = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    this.button = ((ShareMessengerActionButton)paramParcel.readParcelable(ShareMessengerActionButton.class.getClassLoader()));
    AppMethodBeat.o(8498);
  }
  
  private ShareMessengerGenericTemplateElement(Builder paramBuilder)
  {
    AppMethodBeat.i(8497);
    this.title = paramBuilder.title;
    this.subtitle = paramBuilder.subtitle;
    this.imageUrl = paramBuilder.imageUrl;
    this.defaultAction = paramBuilder.defaultAction;
    this.button = paramBuilder.button;
    AppMethodBeat.o(8497);
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
    AppMethodBeat.i(8499);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.subtitle);
    paramParcel.writeParcelable(this.imageUrl, paramInt);
    paramParcel.writeParcelable(this.defaultAction, paramInt);
    paramParcel.writeParcelable(this.button, paramInt);
    AppMethodBeat.o(8499);
  }
  
  public static class Builder
    implements ShareModelBuilder<ShareMessengerGenericTemplateElement, Builder>
  {
    private ShareMessengerActionButton button;
    private ShareMessengerActionButton defaultAction;
    private Uri imageUrl;
    private String subtitle;
    private String title;
    
    public ShareMessengerGenericTemplateElement build()
    {
      AppMethodBeat.i(8492);
      ShareMessengerGenericTemplateElement localShareMessengerGenericTemplateElement = new ShareMessengerGenericTemplateElement(this, null);
      AppMethodBeat.o(8492);
      return localShareMessengerGenericTemplateElement;
    }
    
    Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8494);
      paramParcel = readFrom((ShareMessengerGenericTemplateElement)paramParcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader()));
      AppMethodBeat.o(8494);
      return paramParcel;
    }
    
    public Builder readFrom(ShareMessengerGenericTemplateElement paramShareMessengerGenericTemplateElement)
    {
      AppMethodBeat.i(8493);
      if (paramShareMessengerGenericTemplateElement == null)
      {
        AppMethodBeat.o(8493);
        return this;
      }
      paramShareMessengerGenericTemplateElement = setTitle(paramShareMessengerGenericTemplateElement.title).setSubtitle(paramShareMessengerGenericTemplateElement.subtitle).setImageUrl(paramShareMessengerGenericTemplateElement.imageUrl).setDefaultAction(paramShareMessengerGenericTemplateElement.defaultAction).setButton(paramShareMessengerGenericTemplateElement.button);
      AppMethodBeat.o(8493);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerGenericTemplateElement
 * JD-Core Version:    0.7.0.1
 */