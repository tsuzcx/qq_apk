package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class u
  implements com.google.android.exoplayer2.c.e
{
  public static final h aBP;
  private static final long aLY;
  private static final long aLZ;
  private static final long aMa;
  private g aIN;
  private final List<com.google.android.exoplayer2.i.u> aMb;
  private final m aMc;
  private final SparseIntArray aMd;
  private final v.c aMe;
  private final SparseArray<v> aMf;
  private final SparseBooleanArray aMg;
  private int aMh;
  private boolean aMi;
  private v aMj;
  private final int mode;
  
  static
  {
    AppMethodBeat.i(95177);
    aBP = new u.1();
    aLY = x.aS("AC-3");
    aLZ = x.aS("EAC3");
    aMa = x.aS("HEVC");
    AppMethodBeat.o(95177);
  }
  
  public u()
  {
    this((byte)0);
  }
  
  private u(byte paramByte)
  {
    this(1, 0);
  }
  
  public u(int paramInt1, int paramInt2)
  {
    this(paramInt1, new com.google.android.exoplayer2.i.u(0L), new e(paramInt2));
    AppMethodBeat.i(95170);
    AppMethodBeat.o(95170);
  }
  
  public u(int paramInt, com.google.android.exoplayer2.i.u paramu, v.c paramc)
  {
    AppMethodBeat.i(95171);
    this.aMe = ((v.c)a.checkNotNull(paramc));
    this.mode = paramInt;
    if ((paramInt == 1) || (paramInt == 2)) {
      this.aMb = Collections.singletonList(paramu);
    }
    for (;;)
    {
      this.aMc = new m(9400);
      this.aMg = new SparseBooleanArray();
      this.aMf = new SparseArray();
      this.aMd = new SparseIntArray();
      ou();
      AppMethodBeat.o(95171);
      return;
      this.aMb = new ArrayList();
      this.aMb.add(paramu);
    }
  }
  
  private void ou()
  {
    AppMethodBeat.i(95176);
    this.aMg.clear();
    this.aMf.clear();
    SparseArray localSparseArray = this.aMe.ot();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.aMf.put(localSparseArray.keyAt(i), localSparseArray.valueAt(i));
      i += 1;
    }
    this.aMf.put(0, new r(new u.a(this)));
    this.aMj = null;
    AppMethodBeat.o(95176);
  }
  
  public final int a(f paramf, k paramk)
  {
    int k = 1;
    AppMethodBeat.i(95175);
    paramk = this.aMc.data;
    if (9400 - this.aMc.position < 188)
    {
      i = this.aMc.qM();
      if (i > 0) {
        System.arraycopy(paramk, this.aMc.position, paramk, 0, i);
      }
      this.aMc.l(paramk, i);
    }
    int j;
    while (this.aMc.qM() < 188)
    {
      i = this.aMc.limit;
      j = paramf.read(paramk, i, 9400 - i);
      if (j == -1)
      {
        AppMethodBeat.o(95175);
        return -1;
      }
      this.aMc.em(i + j);
    }
    int m = this.aMc.limit;
    int i = this.aMc.position;
    while ((i < m) && (paramk[i] != 71)) {
      i += 1;
    }
    this.aMc.setPosition(i);
    int n = i + 188;
    if (n > m)
    {
      AppMethodBeat.o(95175);
      return 0;
    }
    int i2 = this.aMc.readInt();
    if ((0x800000 & i2) != 0)
    {
      this.aMc.setPosition(n);
      AppMethodBeat.o(95175);
      return 0;
    }
    boolean bool;
    int i1;
    if ((0x400000 & i2) != 0)
    {
      bool = true;
      i1 = (0x1FFF00 & i2) >> 8;
      if ((i2 & 0x20) == 0) {
        break label351;
      }
      i = 1;
      label265:
      if ((i2 & 0x10) == 0) {
        break label356;
      }
      j = 1;
    }
    for (;;)
    {
      if (this.mode != 2)
      {
        i2 &= 0xF;
        int i3 = this.aMd.get(i1, i2 - 1);
        this.aMd.put(i1, i2);
        if (i3 == i2)
        {
          if (j == 0) {
            break label473;
          }
          this.aMc.setPosition(n);
          AppMethodBeat.o(95175);
          return 0;
          bool = false;
          break;
          label351:
          i = 0;
          break label265;
          label356:
          j = 0;
          continue;
        }
        if (i2 == (i3 + 1 & 0xF)) {}
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        i = this.aMc.readUnsignedByte();
        this.aMc.en(i);
      }
      if (j != 0)
      {
        paramf = (v)this.aMf.get(i1);
        if (paramf != null)
        {
          if (k != 0) {
            paramf.ol();
          }
          this.aMc.em(n);
          paramf.a(this.aMc, bool);
          this.aMc.em(m);
        }
      }
      this.aMc.setPosition(n);
      AppMethodBeat.o(95175);
      return 0;
      label473:
      k = 0;
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(95173);
    this.aIN = paramg;
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(95173);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(95172);
    byte[] arrayOfByte = this.aMc.data;
    paramf.b(arrayOfByte, 0, 940);
    int i = 0;
    while (i < 188)
    {
      int j = 0;
      for (;;)
      {
        if (j == 5)
        {
          paramf.dg(i);
          AppMethodBeat.o(95172);
          return true;
        }
        if (arrayOfByte[(j * 188 + i)] != 71) {
          break;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(95172);
    return false;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95174);
    int j = this.aMb.size();
    int i = 0;
    while (i < j)
    {
      ((com.google.android.exoplayer2.i.u)this.aMb.get(i)).bbs = -9223372036854775807L;
      i += 1;
    }
    this.aMc.reset();
    this.aMd.clear();
    ou();
    AppMethodBeat.o(95174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.u
 * JD-Core Version:    0.7.0.1
 */