package com.facebook.share.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphObject$Builder
  extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder>
{
  public ShareOpenGraphObject$Builder()
  {
    AppMethodBeat.i(97546);
    putBoolean("fbsdk:create_object", true);
    AppMethodBeat.o(97546);
  }
  
  public final ShareOpenGraphObject build()
  {
    AppMethodBeat.i(97547);
    ShareOpenGraphObject localShareOpenGraphObject = new ShareOpenGraphObject(this, null);
    AppMethodBeat.o(97547);
    return localShareOpenGraphObject;
  }
  
  final Builder readFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97548);
    paramParcel = (Builder)readFrom((ShareOpenGraphObject)paramParcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
    AppMethodBeat.o(97548);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphObject.Builder
 * JD-Core Version:    0.7.0.1
 */