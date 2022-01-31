package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceProNative$FaceResult$1
  implements Parcelable.Creator<FaceProNative.FaceResult>
{
  public final FaceProNative.FaceResult createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(30);
    paramParcel = new FaceProNative.FaceResult(paramParcel);
    AppMethodBeat.o(30);
    return paramParcel;
  }
  
  public final FaceProNative.FaceResult[] newArray(int paramInt)
  {
    return new FaceProNative.FaceResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult.1
 * JD-Core Version:    0.7.0.1
 */