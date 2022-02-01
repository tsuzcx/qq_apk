package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateContent
  extends ShareContent<ShareMessengerGenericTemplateContent, Builder>
{
  public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR;
  private final ShareMessengerGenericTemplateElement genericTemplateElement;
  private final ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio;
  private final boolean isSharable;
  
  static
  {
    AppMethodBeat.i(8488);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareMessengerGenericTemplateContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8474);
        paramAnonymousParcel = new ShareMessengerGenericTemplateContent(paramAnonymousParcel);
        AppMethodBeat.o(8474);
        return paramAnonymousParcel;
      }
      
      public final ShareMessengerGenericTemplateContent[] newArray(int paramAnonymousInt)
      {
        return new ShareMessengerGenericTemplateContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8488);
  }
  
  ShareMessengerGenericTemplateContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8486);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSharable = bool;
      this.imageAspectRatio = ((ShareMessengerGenericTemplateContent.ImageAspectRatio)paramParcel.readSerializable());
      this.genericTemplateElement = ((ShareMessengerGenericTemplateElement)paramParcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader()));
      AppMethodBeat.o(8486);
      return;
    }
  }
  
  protected ShareMessengerGenericTemplateContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8485);
    this.isSharable = paramBuilder.isSharable;
    this.imageAspectRatio = paramBuilder.imageAspectRatio;
    this.genericTemplateElement = paramBuilder.genericTemplateElement;
    AppMethodBeat.o(8485);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ShareMessengerGenericTemplateElement getGenericTemplateElement()
  {
    return this.genericTemplateElement;
  }
  
  public final ShareMessengerGenericTemplateContent.ImageAspectRatio getImageAspectRatio()
  {
    return this.imageAspectRatio;
  }
  
  public final boolean getIsSharable()
  {
    return this.isSharable;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8487);
    super.writeToParcel(paramParcel, paramInt);
    if (this.isSharable) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeSerializable(this.imageAspectRatio);
      paramParcel.writeParcelable(this.genericTemplateElement, paramInt);
      AppMethodBeat.o(8487);
      return;
    }
  }
  
  public static class Builder
    extends ShareContent.Builder<ShareMessengerGenericTemplateContent, Builder>
  {
    private ShareMessengerGenericTemplateElement genericTemplateElement;
    private ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio;
    private boolean isSharable;
    
    public ShareMessengerGenericTemplateContent build()
    {
      AppMethodBeat.i(8477);
      ShareMessengerGenericTemplateContent localShareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(this);
      AppMethodBeat.o(8477);
      return localShareMessengerGenericTemplateContent;
    }
    
    public Builder readFrom(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
    {
      AppMethodBeat.i(8478);
      if (paramShareMessengerGenericTemplateContent == null)
      {
        AppMethodBeat.o(8478);
        return this;
      }
      paramShareMessengerGenericTemplateContent = ((Builder)super.readFrom(paramShareMessengerGenericTemplateContent)).setIsSharable(paramShareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(paramShareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(paramShareMessengerGenericTemplateContent.getGenericTemplateElement());
      AppMethodBeat.o(8478);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerGenericTemplateContent
 * JD-Core Version:    0.7.0.1
 */