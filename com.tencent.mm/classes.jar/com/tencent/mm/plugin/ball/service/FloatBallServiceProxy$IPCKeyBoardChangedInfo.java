package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FloatBallServiceProxy$IPCKeyBoardChangedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<IPCKeyBoardChangedInfo> CREATOR;
  long gY;
  int height;
  boolean hwq;
  int oXj;
  
  static
  {
    AppMethodBeat.i(184587);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(184587);
  }
  
  FloatBallServiceProxy$IPCKeyBoardChangedInfo(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    this.height = paramInt1;
    this.oXj = paramInt2;
    this.hwq = paramBoolean;
    this.gY = paramLong;
  }
  
  FloatBallServiceProxy$IPCKeyBoardChangedInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(184585);
    this.height = paramParcel.readInt();
    this.oXj = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hwq = bool;
      this.gY = paramParcel.readLong();
      AppMethodBeat.o(184585);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(184586);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.oXj);
    if (this.hwq) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.gY);
      AppMethodBeat.o(184586);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.IPCKeyBoardChangedInfo
 * JD-Core Version:    0.7.0.1
 */