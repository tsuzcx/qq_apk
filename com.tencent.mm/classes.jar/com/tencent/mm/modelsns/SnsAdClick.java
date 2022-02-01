package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public int dbL;
  public long dwQ;
  public int hTA;
  public int hTB;
  public int hTC;
  public long hTD;
  public long hTE;
  public int hTF;
  public long hTG;
  public long hTH;
  public int hTy;
  public int hTz;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(125655);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(125655);
  }
  
  public SnsAdClick()
  {
    this.hTy = 0;
    this.hTz = 0;
    this.hTA = 0;
    this.startTime = 0L;
    this.hTB = 0;
    this.hTC = 0;
    this.hTD = 0L;
    this.hTE = 0L;
    this.hTF = 0;
    this.hTG = 0L;
    this.hTH = 0L;
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
    this.hTy = 0;
    this.hTz = 0;
    this.hTA = 0;
    this.startTime = 0L;
    this.hTB = 0;
    this.hTC = 0;
    this.hTD = 0L;
    this.hTE = 0L;
    this.hTF = 0;
    this.hTG = 0L;
    this.hTH = 0L;
    this.dbL = paramInt1;
    this.hTy = paramInt2;
    this.dwQ = paramLong;
    this.hTz = paramInt3;
    this.hTA = paramInt4;
    this.hTB = 0;
    this.hTC = 0;
    this.hTF = paramInt5;
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
    paramParcel.writeInt(this.dbL);
    paramParcel.writeInt(this.hTy);
    paramParcel.writeLong(this.dwQ);
    paramParcel.writeInt(this.hTz);
    paramParcel.writeInt(this.hTA);
    paramParcel.writeInt(this.hTB);
    paramParcel.writeInt(this.hTC);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.hTE);
    paramParcel.writeLong(this.hTG);
    paramParcel.writeLong(this.hTH);
    AppMethodBeat.o(125654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */