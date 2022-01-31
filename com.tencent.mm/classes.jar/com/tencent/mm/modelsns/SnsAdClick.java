package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public long cIo;
  public int cpt;
  public long fQA;
  public int fQs;
  public int fQt;
  public int fQu;
  public int fQv;
  public int fQw;
  public long fQx;
  public long fQy;
  public int fQz;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(94456);
    CREATOR = new SnsAdClick.1();
    AppMethodBeat.o(94456);
  }
  
  public SnsAdClick()
  {
    this.fQs = 0;
    this.fQt = 0;
    this.fQu = 0;
    this.startTime = 0L;
    this.fQv = 0;
    this.fQw = 0;
    this.fQx = 0L;
    this.fQy = 0L;
    this.fQz = 0;
    this.fQA = 0L;
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
    AppMethodBeat.i(94454);
    this.fQs = 0;
    this.fQt = 0;
    this.fQu = 0;
    this.startTime = 0L;
    this.fQv = 0;
    this.fQw = 0;
    this.fQx = 0L;
    this.fQy = 0L;
    this.fQz = 0;
    this.fQA = 0L;
    this.cpt = paramInt1;
    this.fQs = paramInt2;
    this.cIo = paramLong;
    this.fQt = paramInt3;
    this.fQu = paramInt4;
    this.fQv = 0;
    this.fQw = 0;
    this.fQz = paramInt5;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(94454);
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
    AppMethodBeat.i(94455);
    paramParcel.writeInt(this.cpt);
    paramParcel.writeInt(this.fQs);
    paramParcel.writeLong(this.cIo);
    paramParcel.writeInt(this.fQt);
    paramParcel.writeInt(this.fQu);
    paramParcel.writeInt(this.fQv);
    paramParcel.writeInt(this.fQw);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.fQy);
    paramParcel.writeLong(this.fQA);
    AppMethodBeat.o(94455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */