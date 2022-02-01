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
  public final List<b> bey;
  
  static
  {
    AppMethodBeat.i(92503);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92503);
  }
  
  private SpliceScheduleCommand(Parcel paramParcel)
  {
    AppMethodBeat.i(92500);
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new b(paramParcel));
      i += 1;
    }
    this.bey = Collections.unmodifiableList(localArrayList);
    AppMethodBeat.o(92500);
  }
  
  private SpliceScheduleCommand(List<b> paramList)
  {
    AppMethodBeat.i(92499);
    this.bey = Collections.unmodifiableList(paramList);
    AppMethodBeat.o(92499);
  }
  
  static SpliceScheduleCommand y(m paramm)
  {
    AppMethodBeat.i(92501);
    int j = paramm.readUnsignedByte();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(b.z(paramm));
      i += 1;
    }
    paramm = new SpliceScheduleCommand(localArrayList);
    AppMethodBeat.o(92501);
    return paramm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92502);
    int j = this.bey.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      b localb = (b)this.bey.get(paramInt);
      paramParcel.writeLong(localb.bei);
      if (localb.bej)
      {
        i = 1;
        paramParcel.writeByte((byte)i);
        if (!localb.bek) {
          break label174;
        }
        i = 1;
        label80:
        paramParcel.writeByte((byte)i);
        if (!localb.bel) {
          break label179;
        }
      }
      label174:
      label179:
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        int k = localb.bep.size();
        paramParcel.writeInt(k);
        i = 0;
        while (i < k)
        {
          a locala = (a)localb.bep.get(i);
          paramParcel.writeInt(locala.bev);
          paramParcel.writeLong(locala.bez);
          i += 1;
        }
        i = 0;
        break;
        i = 0;
        break label80;
      }
      paramParcel.writeLong(localb.bez);
      if (localb.beq) {}
      for (i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeLong(localb.ber);
        paramParcel.writeInt(localb.bes);
        paramParcel.writeInt(localb.bet);
        paramParcel.writeInt(localb.beu);
        paramInt += 1;
        break;
      }
    }
    AppMethodBeat.o(92502);
  }
  
  public static final class a
  {
    public final int bev;
    public final long bez;
    
    a(int paramInt, long paramLong)
    {
      this.bev = paramInt;
      this.bez = paramLong;
    }
  }
  
  public static final class b
  {
    public final long bei;
    public final boolean bej;
    public final boolean bek;
    public final boolean bel;
    public final List<SpliceScheduleCommand.a> bep;
    public final boolean beq;
    public final long ber;
    public final int bes;
    public final int bet;
    public final int beu;
    public final long bez;
    
    private b(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<SpliceScheduleCommand.a> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(92496);
      this.bei = paramLong1;
      this.bej = paramBoolean1;
      this.bek = paramBoolean2;
      this.bel = paramBoolean3;
      this.bep = Collections.unmodifiableList(paramList);
      this.bez = paramLong2;
      this.beq = paramBoolean4;
      this.ber = paramLong3;
      this.bes = paramInt1;
      this.bet = paramInt2;
      this.beu = paramInt3;
      AppMethodBeat.o(92496);
    }
    
    b(Parcel paramParcel)
    {
      AppMethodBeat.i(92497);
      this.bei = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.bej = bool1;
        if (paramParcel.readByte() != 1) {
          break label127;
        }
        bool1 = true;
        label48:
        this.bek = bool1;
        if (paramParcel.readByte() != 1) {
          break label133;
        }
      }
      ArrayList localArrayList;
      label133:
      for (boolean bool1 = true;; bool1 = false)
      {
        this.bel = bool1;
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
      this.bep = Collections.unmodifiableList(localArrayList);
      this.bez = paramParcel.readLong();
      if (paramParcel.readByte() == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.beq = bool1;
        this.ber = paramParcel.readLong();
        this.bes = paramParcel.readInt();
        this.bet = paramParcel.readInt();
        this.beu = paramParcel.readInt();
        AppMethodBeat.o(92497);
        return;
      }
    }
    
    static b z(m paramm)
    {
      AppMethodBeat.i(92498);
      long l3 = paramm.ii();
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
          l1 = paramm.ii();
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
          localArrayList.add(new SpliceScheduleCommand.a(paramm.readUnsignedByte(), paramm.ii(), (byte)0));
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
          l2 = (l2 & 1L) << 32 | paramm.ii();
          label230:
          i = paramm.readUnsignedShort();
          j = paramm.readUnsignedByte();
          k = paramm.readUnsignedByte();
        }
      }
      for (;;)
      {
        paramm = new b(l3, bool4, bool1, bool2, (List)localObject, l1, bool3, l2, i, j, k);
        AppMethodBeat.o(92498);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand
 * JD-Core Version:    0.7.0.1
 */