package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand$b
{
  public final long aOD;
  public final long aOm;
  public final boolean aOn;
  public final boolean aOo;
  public final boolean aOp;
  public final List<SpliceScheduleCommand.a> aOt;
  public final boolean aOu;
  public final long aOv;
  public final int aOw;
  public final int aOx;
  public final int aOy;
  
  private SpliceScheduleCommand$b(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<SpliceScheduleCommand.a> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95374);
    this.aOm = paramLong1;
    this.aOn = paramBoolean1;
    this.aOo = paramBoolean2;
    this.aOp = paramBoolean3;
    this.aOt = Collections.unmodifiableList(paramList);
    this.aOD = paramLong2;
    this.aOu = paramBoolean4;
    this.aOv = paramLong3;
    this.aOw = paramInt1;
    this.aOx = paramInt2;
    this.aOy = paramInt3;
    AppMethodBeat.o(95374);
  }
  
  SpliceScheduleCommand$b(Parcel paramParcel)
  {
    AppMethodBeat.i(95375);
    this.aOm = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.aOn = bool1;
      if (paramParcel.readByte() != 1) {
        break label127;
      }
      bool1 = true;
      label48:
      this.aOo = bool1;
      if (paramParcel.readByte() != 1) {
        break label133;
      }
    }
    ArrayList localArrayList;
    label133:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aOp = bool1;
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
      label127:
      bool1 = false;
      break label48;
    }
    this.aOt = Collections.unmodifiableList(localArrayList);
    this.aOD = paramParcel.readLong();
    if (paramParcel.readByte() == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.aOu = bool1;
      this.aOv = paramParcel.readLong();
      this.aOw = paramParcel.readInt();
      this.aOx = paramParcel.readInt();
      this.aOy = paramParcel.readInt();
      AppMethodBeat.o(95375);
      return;
    }
  }
  
  static b z(m paramm)
  {
    AppMethodBeat.i(95376);
    long l3 = paramm.cc();
    boolean bool4;
    boolean bool1;
    boolean bool2;
    long l1;
    Object localObject;
    int j;
    int k;
    boolean bool5;
    boolean bool3;
    if ((paramm.readUnsignedByte() & 0x80) != 0)
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
        break label293;
      }
      i = paramm.readUnsignedByte();
      if ((i & 0x80) == 0) {
        break label174;
      }
      bool1 = true;
      label78:
      if ((i & 0x40) == 0) {
        break label180;
      }
      bool2 = true;
      label88:
      if ((i & 0x20) == 0) {
        break label186;
      }
    }
    label174:
    label180:
    label186:
    for (int i = 1;; i = 0)
    {
      if (bool2) {
        l1 = paramm.cc();
      }
      if (bool2) {
        break label191;
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
        localArrayList.add(new SpliceScheduleCommand.a(paramm.readUnsignedByte(), paramm.cc(), (byte)0));
        j += 1;
      }
      bool4 = false;
      break;
      bool1 = false;
      break label78;
      bool2 = false;
      break label88;
    }
    label191:
    long l2;
    if (i != 0)
    {
      l2 = paramm.readUnsignedByte();
      if ((0x80 & l2) != 0L)
      {
        bool3 = true;
        l2 = (l2 & 1L) << 32 | paramm.cc();
        label230:
        i = paramm.readUnsignedShort();
        j = paramm.readUnsignedByte();
        k = paramm.readUnsignedByte();
      }
    }
    for (;;)
    {
      paramm = new b(l3, bool4, bool1, bool2, (List)localObject, l1, bool3, l2, i, j, k);
      AppMethodBeat.o(95376);
      return paramm;
      bool3 = false;
      break;
      l2 = -9223372036854775807L;
      break label230;
      label293:
      l2 = -9223372036854775807L;
      bool3 = bool5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.b
 * JD-Core Version:    0.7.0.1
 */