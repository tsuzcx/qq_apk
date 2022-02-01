package com.tencent.mm.plugin.brandservice.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.Log;

public class TransferResultInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TransferResultInfo> CREATOR;
  public String errMsg;
  public dew vBo;
  
  static
  {
    AppMethodBeat.i(301532);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(301532);
  }
  
  public TransferResultInfo() {}
  
  public TransferResultInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(301527);
    this.errMsg = paramParcel.readString();
    this.vBo = new dew();
    try
    {
      int i = paramParcel.readInt();
      if (i > 0)
      {
        byte[] arrayOfByte = new byte[i];
        paramParcel.readByteArray(arrayOfByte);
        this.vBo.parseFrom(arrayOfByte);
      }
      AppMethodBeat.o(301527);
      return;
    }
    catch (Exception paramParcel)
    {
      AppMethodBeat.o(301527);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(301548);
    paramParcel.writeString(this.errMsg);
    try
    {
      if (this.vBo != null)
      {
        byte[] arrayOfByte = this.vBo.toByteArray();
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          paramParcel.writeInt(arrayOfByte.length);
          paramParcel.writeByteArray(arrayOfByte);
          AppMethodBeat.o(301548);
          return;
        }
        paramParcel.writeInt(0);
      }
      AppMethodBeat.o(301548);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.TransferResultInfo", localException, "writeToParcel exception", new Object[0]);
      paramParcel.writeInt(0);
      AppMethodBeat.o(301548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.api.TransferResultInfo
 * JD-Core Version:    0.7.0.1
 */