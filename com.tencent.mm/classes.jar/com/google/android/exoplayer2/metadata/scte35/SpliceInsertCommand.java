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
  public final long bjM;
  public final boolean bjN;
  public final boolean bjO;
  public final boolean bjP;
  public final boolean bjQ;
  public final long bjR;
  public final long bjS;
  public final List<a> bjT;
  public final boolean bjU;
  public final long bjV;
  public final int bjW;
  public final int bjX;
  public final int bjY;
  
  static
  {
    AppMethodBeat.i(92492);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92492);
  }
  
  private SpliceInsertCommand(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong2, long paramLong3, List<a> paramList, boolean paramBoolean5, long paramLong4, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(92488);
    this.bjM = paramLong1;
    this.bjN = paramBoolean1;
    this.bjO = paramBoolean2;
    this.bjP = paramBoolean3;
    this.bjQ = paramBoolean4;
    this.bjR = paramLong2;
    this.bjS = paramLong3;
    this.bjT = Collections.unmodifiableList(paramList);
    this.bjU = paramBoolean5;
    this.bjV = paramLong4;
    this.bjW = paramInt1;
    this.bjX = paramInt2;
    this.bjY = paramInt3;
    AppMethodBeat.o(92488);
  }
  
  private SpliceInsertCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(92489);
    this.bjM = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.bjN = bool1;
      if (paramParcel.readByte() != 1) {
        break label166;
      }
      bool1 = true;
      label48:
      this.bjO = bool1;
      if (paramParcel.readByte() != 1) {
        break label172;
      }
      bool1 = true;
      label65:
      this.bjP = bool1;
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
      this.bjQ = bool1;
      this.bjR = paramParcel.readLong();
      this.bjS = paramParcel.readLong();
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
    this.bjT = Collections.unmodifiableList(localArrayList);
    if (paramParcel.readByte() == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.bjU = bool1;
      this.bjV = paramParcel.readLong();
      this.bjW = paramParcel.readInt();
      this.bjX = paramParcel.readInt();
      this.bjY = paramParcel.readInt();
      AppMethodBeat.o(92489);
      return;
    }
  }
  
  static SpliceInsertCommand a(m paramm, long paramLong, u paramu)
  {
    AppMethodBeat.i(92490);
    long l3 = paramm.df();
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
        localArrayList.add(new a(m, l2, paramu.as(l2), (byte)0));
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
        paramLong = (paramLong & 1L) << 32 | paramm.df();
        label297:
        i = paramm.readUnsignedShort();
        j = paramm.readUnsignedByte();
        k = paramm.readUnsignedByte();
      }
    }
    for (;;)
    {
      paramm = new SpliceInsertCommand(l3, bool5, bool1, bool3, bool2, l1, paramu.as(l1), (List)localObject, bool4, paramLong, i, j, k);
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
    paramParcel.writeLong(this.bjM);
    if (this.bjN)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.bjO) {
        break label170;
      }
      paramInt = 1;
      label39:
      paramParcel.writeByte((byte)paramInt);
      if (!this.bjP) {
        break label175;
      }
      paramInt = 1;
      label54:
      paramParcel.writeByte((byte)paramInt);
      if (!this.bjQ) {
        break label180;
      }
    }
    label170:
    label175:
    label180:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.bjR);
      paramParcel.writeLong(this.bjS);
      int j = this.bjT.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        a locala = (a)this.bjT.get(paramInt);
        paramParcel.writeInt(locala.bjZ);
        paramParcel.writeLong(locala.bka);
        paramParcel.writeLong(locala.bkb);
        paramInt += 1;
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label39;
      paramInt = 0;
      break label54;
    }
    if (this.bjU) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.bjV);
      paramParcel.writeInt(this.bjW);
      paramParcel.writeInt(this.bjX);
      paramParcel.writeInt(this.bjY);
      AppMethodBeat.o(92491);
      return;
    }
  }
  
  public static final class a
  {
    public final int bjZ;
    public final long bka;
    public final long bkb;
    
    a(int paramInt, long paramLong1, long paramLong2)
    {
      this.bjZ = paramInt;
      this.bka = paramLong1;
      this.bkb = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand
 * JD-Core Version:    0.7.0.1
 */