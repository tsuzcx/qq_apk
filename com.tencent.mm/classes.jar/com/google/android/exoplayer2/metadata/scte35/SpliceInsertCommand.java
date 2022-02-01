package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceInsertCommand> CREATOR;
  public final long buG;
  public final boolean buH;
  public final boolean buI;
  public final boolean buJ;
  public final boolean buK;
  public final long buL;
  public final long buM;
  public final List<a> buN;
  public final boolean buO;
  public final long buP;
  public final int buQ;
  public final int buR;
  public final int buS;
  
  static
  {
    AppMethodBeat.i(92492);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92492);
  }
  
  private SpliceInsertCommand(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong2, long paramLong3, List<a> paramList, boolean paramBoolean5, long paramLong4, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(92488);
    this.buG = paramLong1;
    this.buH = paramBoolean1;
    this.buI = paramBoolean2;
    this.buJ = paramBoolean3;
    this.buK = paramBoolean4;
    this.buL = paramLong2;
    this.buM = paramLong3;
    this.buN = Collections.unmodifiableList(paramList);
    this.buO = paramBoolean5;
    this.buP = paramLong4;
    this.buQ = paramInt1;
    this.buR = paramInt2;
    this.buS = paramInt3;
    AppMethodBeat.o(92488);
  }
  
  private SpliceInsertCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(92489);
    this.buG = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.buH = bool1;
      if (paramParcel.readByte() != 1) {
        break label166;
      }
      bool1 = true;
      label48:
      this.buI = bool1;
      if (paramParcel.readByte() != 1) {
        break label172;
      }
      bool1 = true;
      label65:
      this.buJ = bool1;
      if (paramParcel.readByte() != 1) {
        break label178;
      }
    }
    ArrayList localArrayList;
    label166:
    label172:
    label178:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.buK = bool1;
      this.buL = paramParcel.readLong();
      this.buM = paramParcel.readLong();
      int j = paramParcel.readInt();
      localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new a(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong()));
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label48;
      bool1 = false;
      break label65;
    }
    this.buN = Collections.unmodifiableList(localArrayList);
    if (paramParcel.readByte() == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.buO = bool1;
      this.buP = paramParcel.readLong();
      this.buQ = paramParcel.readInt();
      this.buR = paramParcel.readInt();
      this.buS = paramParcel.readInt();
      AppMethodBeat.o(92489);
      return;
    }
  }
  
  static SpliceInsertCommand a(m paramm, long paramLong, u paramu)
  {
    AppMethodBeat.i(92490);
    long l3 = paramm.dE();
    boolean bool5;
    boolean bool1;
    boolean bool3;
    long l2;
    Object localObject;
    int i;
    int j;
    int k;
    boolean bool4;
    if ((paramm.readUnsignedByte() & 0x80) != 0)
    {
      bool5 = true;
      bool1 = false;
      bool3 = false;
      bool2 = false;
      l2 = -9223372036854775807L;
      localObject = Collections.emptyList();
      i = 0;
      j = 0;
      k = 0;
      bool4 = false;
      if (bool5) {
        break label375;
      }
      j = paramm.readUnsignedByte();
      if ((j & 0x80) == 0) {
        break label237;
      }
      bool1 = true;
      label79:
      if ((j & 0x40) == 0) {
        break label243;
      }
      bool3 = true;
      label90:
      if ((j & 0x20) == 0) {
        break label249;
      }
      i = 1;
      label101:
      if ((j & 0x10) == 0) {
        break label255;
      }
    }
    long l1;
    label237:
    label243:
    label249:
    label255:
    for (boolean bool2 = true;; bool2 = false)
    {
      l1 = l2;
      if (bool3)
      {
        l1 = l2;
        if (!bool2) {
          l1 = TimeSignalCommand.c(paramm, paramLong);
        }
      }
      if (bool3) {
        break label261;
      }
      k = paramm.readUnsignedByte();
      ArrayList localArrayList = new ArrayList(k);
      j = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (j >= k) {
          break;
        }
        int m = paramm.readUnsignedByte();
        l2 = -9223372036854775807L;
        if (!bool2) {
          l2 = TimeSignalCommand.c(paramm, paramLong);
        }
        localArrayList.add(new a(m, l2, paramu.ao(l2), (byte)0));
        j += 1;
      }
      bool5 = false;
      break;
      bool1 = false;
      break label79;
      bool3 = false;
      break label90;
      i = 0;
      break label101;
    }
    label261:
    if (i != 0)
    {
      paramLong = paramm.readUnsignedByte();
      if ((0x80 & paramLong) != 0L)
      {
        bool4 = true;
        paramLong = (paramLong & 1L) << 32 | paramm.dE();
        label297:
        i = paramm.readUnsignedShort();
        j = paramm.readUnsignedByte();
        k = paramm.readUnsignedByte();
      }
    }
    for (;;)
    {
      paramm = new SpliceInsertCommand(l3, bool5, bool1, bool3, bool2, l1, paramu.ao(l1), (List)localObject, bool4, paramLong, i, j, k);
      AppMethodBeat.o(92490);
      return paramm;
      bool4 = false;
      break;
      paramLong = -9223372036854775807L;
      bool4 = false;
      break label297;
      label375:
      paramLong = -9223372036854775807L;
      l1 = l2;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(92491);
    paramParcel.writeLong(this.buG);
    if (this.buH)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.buI) {
        break label170;
      }
      paramInt = 1;
      label39:
      paramParcel.writeByte((byte)paramInt);
      if (!this.buJ) {
        break label175;
      }
      paramInt = 1;
      label54:
      paramParcel.writeByte((byte)paramInt);
      if (!this.buK) {
        break label180;
      }
    }
    label170:
    label175:
    label180:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.buL);
      paramParcel.writeLong(this.buM);
      int j = this.buN.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        a locala = (a)this.buN.get(paramInt);
        paramParcel.writeInt(locala.buT);
        paramParcel.writeLong(locala.buU);
        paramParcel.writeLong(locala.buV);
        paramInt += 1;
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label39;
      paramInt = 0;
      break label54;
    }
    if (this.buO) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.buP);
      paramParcel.writeInt(this.buQ);
      paramParcel.writeInt(this.buR);
      paramParcel.writeInt(this.buS);
      AppMethodBeat.o(92491);
      return;
    }
  }
  
  public static final class a
  {
    public final int buT;
    public final long buU;
    public final long buV;
    
    a(int paramInt, long paramLong1, long paramLong2)
    {
      this.buT = paramInt;
      this.buU = paramLong1;
      this.buV = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand
 * JD-Core Version:    0.7.0.1
 */