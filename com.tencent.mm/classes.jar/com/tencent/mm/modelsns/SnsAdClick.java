package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public long fWg;
  public int maU;
  public int maV;
  public int maW;
  public int maX;
  public int maY;
  public long maZ;
  public long mba;
  public int mbb;
  public long mbc;
  public long mbd;
  public int mbe;
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
    this.maU = 0;
    this.maV = 0;
    this.maW = 0;
    this.startTime = 0L;
    this.maX = 0;
    this.maY = 0;
    this.maZ = 0L;
    this.mba = 0L;
    this.mbb = 0;
    this.mbc = 0L;
    this.mbd = 0L;
    this.mbe = 0;
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
    this.maU = 0;
    this.maV = 0;
    this.maW = 0;
    this.startTime = 0L;
    this.maX = 0;
    this.maY = 0;
    this.maZ = 0L;
    this.mba = 0L;
    this.mbb = 0;
    this.mbc = 0L;
    this.mbd = 0L;
    this.mbe = 0;
    this.source = paramInt1;
    this.maU = paramInt2;
    this.fWg = paramLong;
    this.maV = paramInt3;
    this.maW = paramInt4;
    this.maX = 0;
    this.maY = 0;
    this.mbb = paramInt5;
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
    paramParcel.writeInt(this.maU);
    paramParcel.writeLong(this.fWg);
    paramParcel.writeInt(this.maV);
    paramParcel.writeInt(this.maW);
    paramParcel.writeInt(this.maX);
    paramParcel.writeInt(this.maY);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.mba);
    paramParcel.writeLong(this.mbc);
    paramParcel.writeLong(this.mbd);
    paramParcel.writeInt(this.mbe);
    AppMethodBeat.o(125654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */