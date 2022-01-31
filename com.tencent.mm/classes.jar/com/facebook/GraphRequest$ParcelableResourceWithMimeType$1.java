package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GraphRequest$ParcelableResourceWithMimeType$1
  implements Parcelable.Creator<GraphRequest.ParcelableResourceWithMimeType>
{
  public final GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(71646);
    paramParcel = new GraphRequest.ParcelableResourceWithMimeType(paramParcel, null);
    AppMethodBeat.o(71646);
    return paramParcel;
  }
  
  public final GraphRequest.ParcelableResourceWithMimeType[] newArray(int paramInt)
  {
    return new GraphRequest.ParcelableResourceWithMimeType[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.GraphRequest.ParcelableResourceWithMimeType.1
 * JD-Core Version:    0.7.0.1
 */