package com.tencent.mm.compatible.deviceinfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MediaCodecProxyUtils$MediaCodecRetryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaCodecRetryInfo> CREATOR;
  int fFh;
  
  static
  {
    AppMethodBeat.i(155805);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(155805);
  }
  
  protected MediaCodecProxyUtils$MediaCodecRetryInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(155803);
    this.fFh = paramParcel.readInt();
    AppMethodBeat.o(155803);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(155804);
    paramParcel.writeInt(this.fFh);
    AppMethodBeat.o(155804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.MediaCodecRetryInfo
 * JD-Core Version:    0.7.0.1
 */