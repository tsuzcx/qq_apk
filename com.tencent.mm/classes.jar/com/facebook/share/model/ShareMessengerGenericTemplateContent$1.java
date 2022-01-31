package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareMessengerGenericTemplateContent$1
  implements Parcelable.Creator<ShareMessengerGenericTemplateContent>
{
  public final ShareMessengerGenericTemplateContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97450);
    paramParcel = new ShareMessengerGenericTemplateContent(paramParcel);
    AppMethodBeat.o(97450);
    return paramParcel;
  }
  
  public final ShareMessengerGenericTemplateContent[] newArray(int paramInt)
  {
    return new ShareMessengerGenericTemplateContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerGenericTemplateContent.1
 * JD-Core Version:    0.7.0.1
 */