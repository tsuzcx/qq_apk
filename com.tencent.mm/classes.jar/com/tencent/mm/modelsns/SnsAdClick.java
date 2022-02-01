package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdClick
  implements Parcelable
{
  public static final Parcelable.Creator<SnsAdClick> CREATOR;
  public long dKq;
  public int doj;
  public int ipM;
  public int ipN;
  public int ipO;
  public int ipP;
  public int ipQ;
  public long ipR;
  public long ipS;
  public int ipT;
  public long ipU;
  public long ipV;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(125655);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(125655);
  }
  
  public SnsAdClick()
  {
    this.ipM = 0;
    this.ipN = 0;
    this.ipO = 0;
    this.startTime = 0L;
    this.ipP = 0;
    this.ipQ = 0;
    this.ipR = 0L;
    this.ipS = 0L;
    this.ipT = 0;
    this.ipU = 0L;
    this.ipV = 0L;
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
    this.ipM = 0;
    this.ipN = 0;
    this.ipO = 0;
    this.startTime = 0L;
    this.ipP = 0;
    this.ipQ = 0;
    this.ipR = 0L;
    this.ipS = 0L;
    this.ipT = 0;
    this.ipU = 0L;
    this.ipV = 0L;
    this.doj = paramInt1;
    this.ipM = paramInt2;
    this.dKq = paramLong;
    this.ipN = paramInt3;
    this.ipO = paramInt4;
    this.ipP = 0;
    this.ipQ = 0;
    this.ipT = paramInt5;
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
    paramParcel.writeInt(this.doj);
    paramParcel.writeInt(this.ipM);
    paramParcel.writeLong(this.dKq);
    paramParcel.writeInt(this.ipN);
    paramParcel.writeInt(this.ipO);
    paramParcel.writeInt(this.ipP);
    paramParcel.writeInt(this.ipQ);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.ipS);
    paramParcel.writeLong(this.ipU);
    paramParcel.writeLong(this.ipV);
    AppMethodBeat.o(125654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.SnsAdClick
 * JD-Core Version:    0.7.0.1
 */