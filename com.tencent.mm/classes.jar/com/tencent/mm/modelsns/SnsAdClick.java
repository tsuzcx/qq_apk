package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public long ece;
  public int jkT;
  public int jkU;
  public int jkV;
  public int jkW;
  public int jkX;
  public long jkY;
  public long jkZ;
  public int jla;
  public long jlb;
  public long jlc;
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
    this.jkT = 0;
    this.jkU = 0;
    this.jkV = 0;
    this.startTime = 0L;
    this.jkW = 0;
    this.jkX = 0;
    this.jkY = 0L;
    this.jkZ = 0L;
    this.jla = 0;
    this.jlb = 0L;
    this.jlc = 0L;
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
    this.jkT = 0;
    this.jkU = 0;
    this.jkV = 0;
    this.startTime = 0L;
    this.jkW = 0;
    this.jkX = 0;
    this.jkY = 0L;
    this.jkZ = 0L;
    this.jla = 0;
    this.jlb = 0L;
    this.jlc = 0L;
    this.source = paramInt1;
    this.jkT = paramInt2;
    this.ece = paramLong;
    this.jkU = paramInt3;
    this.jkV = paramInt4;
    this.jkW = 0;
    this.jkX = 0;
    this.jla = paramInt5;
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
    paramParcel.writeInt(this.jkT);
    paramParcel.writeLong(this.ece);
    paramParcel.writeInt(this.jkU);
    paramParcel.writeInt(this.jkV);
    paramParcel.writeInt(this.jkW);
    paramParcel.writeInt(this.jkX);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.jkZ);
    paramParcel.writeLong(this.jlb);
    paramParcel.writeLong(this.jlc);
    AppMethodBeat.o(125654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */