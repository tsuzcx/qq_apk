package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public int dep;
  public long dze;
  public int hsW;
  public int hsX;
  public int hsY;
  public int hsZ;
  public int hta;
  public long htb;
  public long htc;
  public int htd;
  public long hte;
  public long htf;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(125655);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(125655);
  }
  
  public SnsAdClick()
  {
    this.hsW = 0;
    this.hsX = 0;
    this.hsY = 0;
    this.startTime = 0L;
    this.hsZ = 0;
    this.hta = 0;
    this.htb = 0L;
    this.htc = 0L;
    this.htd = 0;
    this.hte = 0L;
    this.htf = 0L;
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
    this.hsW = 0;
    this.hsX = 0;
    this.hsY = 0;
    this.startTime = 0L;
    this.hsZ = 0;
    this.hta = 0;
    this.htb = 0L;
    this.htc = 0L;
    this.htd = 0;
    this.hte = 0L;
    this.htf = 0L;
    this.dep = paramInt1;
    this.hsW = paramInt2;
    this.dze = paramLong;
    this.hsX = paramInt3;
    this.hsY = paramInt4;
    this.hsZ = 0;
    this.hta = 0;
    this.htd = paramInt5;
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
    paramParcel.writeInt(this.dep);
    paramParcel.writeInt(this.hsW);
    paramParcel.writeLong(this.dze);
    paramParcel.writeInt(this.hsX);
    paramParcel.writeInt(this.hsY);
    paramParcel.writeInt(this.hsZ);
    paramParcel.writeInt(this.hta);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.htc);
    paramParcel.writeLong(this.hte);
    paramParcel.writeLong(this.htf);
    AppMethodBeat.o(125654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */