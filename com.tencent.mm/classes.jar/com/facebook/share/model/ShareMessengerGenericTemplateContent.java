package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateContent
  extends ShareContent<ShareMessengerGenericTemplateContent, ShareMessengerGenericTemplateContent.Builder>
{
  public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR;
  private final ShareMessengerGenericTemplateElement genericTemplateElement;
  private final ImageAspectRatio imageAspectRatio;
  private final boolean isSharable;
  
  static
  {
    AppMethodBeat.i(97464);
    CREATOR = new ShareMessengerGenericTemplateContent.1();
    AppMethodBeat.o(97464);
  }
  
  ShareMessengerGenericTemplateContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97462);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isSharable = bool;
      this.imageAspectRatio = ((ImageAspectRatio)paramParcel.readSerializable());
      this.genericTemplateElement = ((ShareMessengerGenericTemplateElement)paramParcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader()));
      AppMethodBeat.o(97462);
      return;
    }
  }
  
  protected ShareMessengerGenericTemplateContent(ShareMessengerGenericTemplateContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97461);
    this.isSharable = ShareMessengerGenericTemplateContent.Builder.access$000(paramBuilder);
    this.imageAspectRatio = ShareMessengerGenericTemplateContent.Builder.access$100(paramBuilder);
    this.genericTemplateElement = ShareMessengerGenericTemplateContent.Builder.access$200(paramBuilder);
    AppMethodBeat.o(97461);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ShareMessengerGenericTemplateElement getGenericTemplateElement()
  {
    return this.genericTemplateElement;
  }
  
  public final ImageAspectRatio getImageAspectRatio()
  {
    return this.imageAspectRatio;
  }
  
  public final boolean getIsSharable()
  {
    return this.isSharable;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97463);
    super.writeToParcel(paramParcel, paramInt);
    if (this.isSharable) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeSerializable(this.imageAspectRatio);
      paramParcel.writeParcelable(this.genericTemplateElement, paramInt);
      AppMethodBeat.o(97463);
      return;
    }
  }
  
  public static enum ImageAspectRatio
  {
    static
    {
      AppMethodBeat.i(97460);
      HORIZONTAL = new ImageAspectRatio("HORIZONTAL", 0);
      SQUARE = new ImageAspectRatio("SQUARE", 1);
      $VALUES = new ImageAspectRatio[] { HORIZONTAL, SQUARE };
      AppMethodBeat.o(97460);
    }
    
    private ImageAspectRatio() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerGenericTemplateContent
 * JD-Core Version:    0.7.0.1
 */