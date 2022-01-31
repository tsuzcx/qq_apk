package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphObject
  extends ShareOpenGraphValueContainer<ShareOpenGraphObject, ShareOpenGraphObject.Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR;
  
  static
  {
    AppMethodBeat.i(97550);
    CREATOR = new ShareOpenGraphObject.1();
    AppMethodBeat.o(97550);
  }
  
  ShareOpenGraphObject(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  private ShareOpenGraphObject(ShareOpenGraphObject.Builder paramBuilder)
  {
    super(paramBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphObject
 * JD-Core Version:    0.7.0.1
 */