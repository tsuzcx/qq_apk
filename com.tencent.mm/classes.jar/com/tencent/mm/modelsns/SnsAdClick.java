package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR = new SnsAdClick.1();
  public long eAA;
  public int eAB = 0;
  public int eAC = 0;
  public int eAD = 0;
  public int eAE = 0;
  public long eAF = 0L;
  public long eAG = 0L;
  public int eAH = 0;
  public int eAz = 0;
  public int source;
  public long startTime = 0L;
  
  public SnsAdClick() {}
  
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
    this.source = paramInt1;
    this.eAz = paramInt2;
    this.eAA = paramLong;
    this.eAB = paramInt3;
    this.eAC = paramInt4;
    this.eAD = 0;
    this.eAE = 0;
    this.eAH = paramInt5;
    this.startTime = System.currentTimeMillis();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.source);
    paramParcel.writeInt(this.eAz);
    paramParcel.writeLong(this.eAA);
    paramParcel.writeInt(this.eAB);
    paramParcel.writeInt(this.eAC);
    paramParcel.writeInt(this.eAD);
    paramParcel.writeInt(this.eAE);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.eAG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */