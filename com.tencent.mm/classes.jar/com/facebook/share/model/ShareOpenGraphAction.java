package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphAction
  extends ShareOpenGraphValueContainer<ShareOpenGraphAction, ShareOpenGraphAction.Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR;
  
  static
  {
    AppMethodBeat.i(97529);
    CREATOR = new ShareOpenGraphAction.1();
    AppMethodBeat.o(97529);
  }
  
  ShareOpenGraphAction(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  private ShareOpenGraphAction(ShareOpenGraphAction.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public final String getActionType()
  {
    AppMethodBeat.i(97528);
    String str = getString("og:type");
    AppMethodBeat.o(97528);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphAction
 * JD-Core Version:    0.7.0.1
 */