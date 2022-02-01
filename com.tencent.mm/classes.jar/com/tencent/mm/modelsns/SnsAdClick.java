package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public long ibq;
  public int oTO;
  public int oTP;
  public int oTQ;
  public int oTR;
  public int oTS;
  public long oTT;
  public long oTU;
  public int oTV;
  public long oTW;
  public long oTX;
  public int oTY;
  public int source;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(125655);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(125655);
  }
  
  public SnsAdClick()
  {
    this.oTO = 0;
    this.oTP = 0;
    this.oTQ = 0;
    this.startTime = 0L;
    this.oTR = 0;
    this.oTS = 0;
    this.oTT = 0L;
    this.oTU = 0L;
    this.oTV = 0;
    this.oTW = 0L;
    this.oTX = 0L;
    this.oTY = 0;
  }
  
  public SnsAdClick(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, 0);
  }
  
  public SnsAdClick(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, byte paramByte)
  {
    this(paramInt1, paramInt2, paramLong, 22, paramInt3, paramInt4);
  }
  
  private SnsAdClick(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(125653);
    this.oTO = 0;
    this.oTP = 0;
    this.oTQ = 0;
    this.startTime = 0L;
    this.oTR = 0;
    this.oTS = 0;
    this.oTT = 0L;
    this.oTU = 0L;
    this.oTV = 0;
    this.oTW = 0L;
    this.oTX = 0L;
    this.oTY = 0;
    this.source = paramInt1;
    this.oTO = paramInt2;
    this.ibq = paramLong;
    this.oTP = paramInt3;
    this.oTQ = paramInt4;
    this.oTR = 0;
    this.oTS = 0;
    this.oTV = paramInt5;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(125653);
  }
  
  public SnsAdClick(int paramInt, long paramLong)
  {
    this(paramInt, 7, paramLong, 0, 0, 0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(125654);
    paramParcel.writeInt(this.source);
    paramParcel.writeInt(this.oTO);
    paramParcel.writeLong(this.ibq);
    paramParcel.writeInt(this.oTP);
    paramParcel.writeInt(this.oTQ);
    paramParcel.writeInt(this.oTR);
    paramParcel.writeInt(this.oTS);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.oTU);
    paramParcel.writeLong(this.oTW);
    paramParcel.writeLong(this.oTX);
    paramParcel.writeInt(this.oTY);
    AppMethodBeat.o(125654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */