package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceProNative$FaceStatus$1
  implements Parcelable.Creator<FaceProNative.FaceStatus>
{
  public final FaceProNative.FaceStatus createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(37);
    paramParcel = new FaceProNative.FaceStatus(paramParcel);
    AppMethodBeat.o(37);
    return paramParcel;
  }
  
  public final FaceProNative.FaceStatus[] newArray(int paramInt)
  {
    return new FaceProNative.FaceStatus[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus.1
 * JD-Core Version:    0.7.0.1
 */