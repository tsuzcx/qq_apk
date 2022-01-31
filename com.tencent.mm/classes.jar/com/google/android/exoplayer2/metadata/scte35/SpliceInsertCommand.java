package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new SpliceInsertCommand.1();
  public final boolean aHA;
  public final long aHB;
  public final int aHC;
  public final int aHD;
  public final int aHE;
  public final long aHs;
  public final boolean aHt;
  public final boolean aHu;
  public final boolean aHv;
  public final boolean aHw;
  public final long aHx;
  public final long aHy;
  public final List<SpliceInsertCommand.a> aHz;
  
  private SpliceInsertCommand(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong2, long paramLong3, List<SpliceInsertCommand.a> paramList, boolean paramBoolean5, long paramLong4, int paramInt1, int paramInt2, int paramInt3)
  {
    this.aHs = paramLong1;
    this.aHt = paramBoolean1;
    this.aHu = paramBoolean2;
    this.aHv = paramBoolean3;
    this.aHw = paramBoolean4;
    this.aHx = paramLong2;
    this.aHy = paramLong3;
    this.aHz = Collections.unmodifiableList(paramList);
    this.aHA = paramBoolean5;
    this.aHB = paramLong4;
    this.aHC = paramInt1;
    this.aHD = paramInt2;
    this.aHE = paramInt3;
  }
  
  private SpliceInsertCommand(Parcel paramParcel)
  {
    this.aHs = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.aHt = bool1;
      if (paramParcel.readByte() != 1) {
        break label161;
      }
      bool1 = true;
      label43:
      this.aHu = bool1;
      if (paramParcel.readByte() != 1) {
        break label167;
      }
      bool1 = true;
      label60:
      this.aHv = bool1;
      if (paramParcel.readByte() != 1) {
        break label173;
      }
    }
    ArrayList localArrayList;
    label161:
    label167:
    label173:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aHw = bool1;
      this.aHx = paramParcel.readLong();
      this.aHy = paramParcel.readLong();
      int j = paramParcel.readInt();
      localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new SpliceInsertCommand.a(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong()));
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label43;
      bool1 = false;
      break label60;
    }
    this.aHz = Collections.unmodifiableList(localArrayList);
    if (paramParcel.readByte() == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.aHA = bool1;
      this.aHB = paramParcel.readLong();
      this.aHC = paramParcel.readInt();
      this.aHD = paramParcel.readInt();
      this.aHE = paramParcel.readInt();
      return;
    }
  }
  
  static SpliceInsertCommand a(j paramj, long paramLong, q paramq)
  {
    long l3 = paramj.bp();
    boolean bool5;
    boolean bool1;
    boolean bool3;
    long l2;
    Object localObject;
    int i;
    int j;
    int k;
    boolean bool4;
    if ((paramj.readUnsignedByte() & 0x80) != 0)
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
        break label363;
      }
      j = paramj.readUnsignedByte();
      if ((j & 0x80) == 0) {
        break label232;
      }
      bool1 = true;
      label74:
      if ((j & 0x40) == 0) {
        break label238;
      }
      bool3 = true;
      label85:
      if ((j & 0x20) == 0) {
        break label244;
      }
      i = 1;
      label96:
      if ((j & 0x10) == 0) {
        break label250;
      }
    }
    long l1;
    label232:
    label238:
    label244:
    label250:
    for (boolean bool2 = true;; bool2 = false)
    {
      l1 = l2;
      if (bool3)
      {
        l1 = l2;
        if (!bool2) {
          l1 = TimeSignalCommand.a(paramj, paramLong);
        }
      }
      if (bool3) {
        break label256;
      }
      k = paramj.readUnsignedByte();
      ArrayList localArrayList = new ArrayList(k);
      j = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (j >= k) {
          break;
        }
        int m = paramj.readUnsignedByte();
        l2 = -9223372036854775807L;
        if (!bool2) {
          l2 = TimeSignalCommand.a(paramj, paramLong);
        }
        localArrayList.add(new SpliceInsertCommand.a(m, l2, paramq.W(l2), (byte)0));
        j += 1;
      }
      bool5 = false;
      break;
      bool1 = false;
      break label74;
      bool3 = false;
      break label85;
      i = 0;
      break label96;
    }
    label256:
    if (i != 0)
    {
      paramLong = paramj.readUnsignedByte();
      if ((0x80 & paramLong) != 0L)
      {
        bool4 = true;
        paramLong = (paramLong & 1L) << 32 | paramj.bp();
        label292:
        i = paramj.readUnsignedShort();
        j = paramj.readUnsignedByte();
        k = paramj.readUnsignedByte();
      }
    }
    for (;;)
    {
      return new SpliceInsertCommand(l3, bool5, bool1, bool3, bool2, l1, paramq.W(l1), (List)localObject, bool4, paramLong, i, j, k);
      bool4 = false;
      break;
      paramLong = -9223372036854775807L;
      bool4 = false;
      break label292;
      label363:
      paramLong = -9223372036854775807L;
      l1 = l2;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.aHs);
    if (this.aHt)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.aHu) {
        break label165;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aHv) {
        break label170;
      }
      paramInt = 1;
      label49:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aHw) {
        break label175;
      }
    }
    label165:
    label170:
    label175:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.aHx);
      paramParcel.writeLong(this.aHy);
      int j = this.aHz.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        SpliceInsertCommand.a locala = (SpliceInsertCommand.a)this.aHz.get(paramInt);
        paramParcel.writeInt(locala.aHF);
        paramParcel.writeLong(locala.aHG);
        paramParcel.writeLong(locala.aHH);
        paramInt += 1;
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label34;
      paramInt = 0;
      break label49;
    }
    if (this.aHA) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.aHB);
      paramParcel.writeInt(this.aHC);
      paramParcel.writeInt(this.aHD);
      paramParcel.writeInt(this.aHE);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand
 * JD-Core Version:    0.7.0.1
 */