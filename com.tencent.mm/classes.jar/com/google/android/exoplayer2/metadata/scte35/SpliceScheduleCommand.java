package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new SpliceScheduleCommand.1();
  public final List<SpliceScheduleCommand.b> aHI;
  
  private SpliceScheduleCommand(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new SpliceScheduleCommand.b(paramParcel));
      i += 1;
    }
    this.aHI = Collections.unmodifiableList(localArrayList);
  }
  
  private SpliceScheduleCommand(List<SpliceScheduleCommand.b> paramList)
  {
    this.aHI = Collections.unmodifiableList(paramList);
  }
  
  static SpliceScheduleCommand c(j paramj)
  {
    int j = paramj.readUnsignedByte();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(SpliceScheduleCommand.b.d(paramj));
      i += 1;
    }
    return new SpliceScheduleCommand(localArrayList);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = this.aHI.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      SpliceScheduleCommand.b localb = (SpliceScheduleCommand.b)this.aHI.get(paramInt);
      paramParcel.writeLong(localb.aHs);
      if (localb.aHt)
      {
        i = 1;
        paramParcel.writeByte((byte)i);
        if (!localb.aHu) {
          break label169;
        }
        i = 1;
        label75:
        paramParcel.writeByte((byte)i);
        if (!localb.aHv) {
          break label174;
        }
      }
      label169:
      label174:
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        int k = localb.aHz.size();
        paramParcel.writeInt(k);
        i = 0;
        while (i < k)
        {
          SpliceScheduleCommand.a locala = (SpliceScheduleCommand.a)localb.aHz.get(i);
          paramParcel.writeInt(locala.aHF);
          paramParcel.writeLong(locala.aHJ);
          i += 1;
        }
        i = 0;
        break;
        i = 0;
        break label75;
      }
      paramParcel.writeLong(localb.aHJ);
      if (localb.aHA) {}
      for (i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeLong(localb.aHB);
        paramParcel.writeInt(localb.aHC);
        paramParcel.writeInt(localb.aHD);
        paramParcel.writeInt(localb.aHE);
        paramInt += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand
 * JD-Core Version:    0.7.0.1
 */