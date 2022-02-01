package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public long dJc;
  public int dnh;
  public int imS;
  public int imT;
  public int imU;
  public int imV;
  public int imW;
  public long imX;
  public long imY;
  public int imZ;
  public long ina;
  public long inb;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(125655);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(125655);
  }
  
  public SnsAdClick()
  {
    this.imS = 0;
    this.imT = 0;
    this.imU = 0;
    this.startTime = 0L;
    this.imV = 0;
    this.imW = 0;
    this.imX = 0L;
    this.imY = 0L;
    this.imZ = 0;
    this.ina = 0L;
    this.inb = 0L;
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
    this.imS = 0;
    this.imT = 0;
    this.imU = 0;
    this.startTime = 0L;
    this.imV = 0;
    this.imW = 0;
    this.imX = 0L;
    this.imY = 0L;
    this.imZ = 0;
    this.ina = 0L;
    this.inb = 0L;
    this.dnh = paramInt1;
    this.imS = paramInt2;
    this.dJc = paramLong;
    this.imT = paramInt3;
    this.imU = paramInt4;
    this.imV = 0;
    this.imW = 0;
    this.imZ = paramInt5;
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
    paramParcel.writeInt(this.dnh);
    paramParcel.writeInt(this.imS);
    paramParcel.writeLong(this.dJc);
    paramParcel.writeInt(this.imT);
    paramParcel.writeInt(this.imU);
    paramParcel.writeInt(this.imV);
    paramParcel.writeInt(this.imW);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.imY);
    paramParcel.writeLong(this.ina);
    paramParcel.writeLong(this.inb);
    AppMethodBeat.o(125654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */