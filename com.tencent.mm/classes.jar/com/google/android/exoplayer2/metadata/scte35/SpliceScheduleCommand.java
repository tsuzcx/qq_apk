package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR;
  public final List<SpliceScheduleCommand.b> aOC;
  
  static
  {
    AppMethodBeat.i(95381);
    CREATOR = new SpliceScheduleCommand.1();
    AppMethodBeat.o(95381);
  }
  
  private SpliceScheduleCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(95378);
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new SpliceScheduleCommand.b(paramParcel));
      i += 1;
    }
    this.aOC = Collections.unmodifiableList(localArrayList);
    AppMethodBeat.o(95378);
  }
  
  private SpliceScheduleCommand(List<SpliceScheduleCommand.b> paramList)
  {
    AppMethodBeat.i(95377);
    this.aOC = Collections.unmodifiableList(paramList);
    AppMethodBeat.o(95377);
  }
  
  static SpliceScheduleCommand y(m paramm)
  {
    AppMethodBeat.i(95379);
    int j = paramm.readUnsignedByte();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(SpliceScheduleCommand.b.z(paramm));
      i += 1;
    }
    paramm = new SpliceScheduleCommand(localArrayList);
    AppMethodBeat.o(95379);
    return paramm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95380);
    int j = this.aOC.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      SpliceScheduleCommand.b localb = (SpliceScheduleCommand.b)this.aOC.get(paramInt);
      paramParcel.writeLong(localb.aOm);
      if (localb.aOn)
      {
        i = 1;
        paramParcel.writeByte((byte)i);
        if (!localb.aOo) {
          break label174;
        }
        i = 1;
        label80:
        paramParcel.writeByte((byte)i);
        if (!localb.aOp) {
          break label179;
        }
      }
      label174:
      label179:
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        int k = localb.aOt.size();
        paramParcel.writeInt(k);
        i = 0;
        while (i < k)
        {
          SpliceScheduleCommand.a locala = (SpliceScheduleCommand.a)localb.aOt.get(i);
          paramParcel.writeInt(locala.aOz);
          paramParcel.writeLong(locala.aOD);
          i += 1;
        }
        i = 0;
        break;
        i = 0;
        break label80;
      }
      paramParcel.writeLong(localb.aOD);
      if (localb.aOu) {}
      for (i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeLong(localb.aOv);
        paramParcel.writeInt(localb.aOw);
        paramParcel.writeInt(localb.aOx);
        paramParcel.writeInt(localb.aOy);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(95380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand
 * JD-Core Version:    0.7.0.1
 */