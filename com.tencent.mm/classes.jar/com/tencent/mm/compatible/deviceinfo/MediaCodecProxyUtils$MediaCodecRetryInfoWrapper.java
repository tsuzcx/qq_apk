package com.tencent.mm.compatible.deviceinfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class MediaCodecProxyUtils$MediaCodecRetryInfoWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<MediaCodecRetryInfoWrapper> CREATOR;
  List<MediaCodecProxyUtils.MediaCodecRetryInfo> gey;
  
  static
  {
    AppMethodBeat.i(155809);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(155809);
  }
  
  protected MediaCodecProxyUtils$MediaCodecRetryInfoWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(155807);
    this.gey = paramParcel.createTypedArrayList(MediaCodecProxyUtils.MediaCodecRetryInfo.CREATOR);
    AppMethodBeat.o(155807);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(155808);
    paramParcel.writeTypedList(this.gey);
    AppMethodBeat.o(155808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.MediaCodecRetryInfoWrapper
 * JD-Core Version:    0.7.0.1
 */