package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand$b
{
  public final boolean aHA;
  public final long aHB;
  public final int aHC;
  public final int aHD;
  public final int aHE;
  public final long aHJ;
  public final long aHs;
  public final boolean aHt;
  public final boolean aHu;
  public final boolean aHv;
  public final List<SpliceScheduleCommand.a> aHz;
  
  private SpliceScheduleCommand$b(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<SpliceScheduleCommand.a> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.aHs = paramLong1;
    this.aHt = paramBoolean1;
    this.aHu = paramBoolean2;
    this.aHv = paramBoolean3;
    this.aHz = Collections.unmodifiableList(paramList);
    this.aHJ = paramLong2;
    this.aHA = paramBoolean4;
    this.aHB = paramLong3;
    this.aHC = paramInt1;
    this.aHD = paramInt2;
    this.aHE = paramInt3;
  }
  
  SpliceScheduleCommand$b(Parcel paramParcel)
  {
    this.aHs = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.aHt = bool1;
      if (paramParcel.readByte() != 1) {
        break label122;
      }
      bool1 = true;
      label43:
      this.aHu = bool1;
      if (paramParcel.readByte() != 1) {
        break label128;
      }
    }
    ArrayList localArrayList;
    label128:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aHv = bool1;
      int j = paramParcel.readInt();
      localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new SpliceScheduleCommand.a(paramParcel.readInt(), paramParcel.readLong()));
        i += 1;
      }
      bool1 = false;
      break;
      label122:
      bool1 = false;
      break label43;
    }
    this.aHz = Collections.unmodifiableList(localArrayList);
    this.aHJ = paramParcel.readLong();
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
  
  static b d(j paramj)
  {
    long l3 = paramj.bp();
    boolean bool4;
    boolean bool1;
    boolean bool2;
    long l1;
    Object localObject;
    int j;
    int k;
    boolean bool5;
    boolean bool3;
    if ((paramj.readUnsignedByte() & 0x80) != 0)
    {
      bool4 = true;
      bool1 = false;
      bool2 = false;
      l1 = -9223372036854775807L;
      localObject = new ArrayList();
      i = 0;
      j = 0;
      k = 0;
      bool5 = false;
      bool3 = false;
      if (bool4) {
        break label281;
      }
      i = paramj.readUnsignedByte();
      if ((i & 0x80) == 0) {
        break label169;
      }
      bool1 = true;
      label73:
      if ((i & 0x40) == 0) {
        break label175;
      }
      bool2 = true;
      label83:
      if ((i & 0x20) == 0) {
        break label181;
      }
    }
    label169:
    label175:
    label181:
    for (int i = 1;; i = 0)
    {
      if (bool2) {
        l1 = paramj.bp();
      }
      if (bool2) {
        break label186;
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
        localArrayList.add(new SpliceScheduleCommand.a(paramj.readUnsignedByte(), paramj.bp(), (byte)0));
        j += 1;
      }
      bool4 = false;
      break;
      bool1 = false;
      break label73;
      bool2 = false;
      break label83;
    }
    label186:
    long l2;
    if (i != 0)
    {
      l2 = paramj.readUnsignedByte();
      if ((0x80 & l2) != 0L)
      {
        bool3 = true;
        l2 = (l2 & 1L) << 32 | paramj.bp();
        label225:
        i = paramj.readUnsignedShort();
        j = paramj.readUnsignedByte();
        k = paramj.readUnsignedByte();
      }
    }
    for (;;)
    {
      return new b(l3, bool4, bool1, bool2, (List)localObject, l1, bool3, l2, i, j, k);
      bool3 = false;
      break;
      l2 = -9223372036854775807L;
      break label225;
      label281:
      l2 = -9223372036854775807L;
      bool3 = bool5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.b
 * JD-Core Version:    0.7.0.1
 */