package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class t
  implements d
{
  private static final long aFj = com.google.android.exoplayer2.i.t.aG("AC-3");
  private static final long aFk = com.google.android.exoplayer2.i.t.aG("EAC3");
  private static final long aFl = com.google.android.exoplayer2.i.t.aG("HEVC");
  public static final g azq = new t.1();
  private final List<com.google.android.exoplayer2.i.q> aFm;
  private final j aFn;
  private final SparseIntArray aFo;
  private final u.c aFp;
  private final SparseArray<u> aFq;
  private final SparseBooleanArray aFr;
  private f aFs;
  private int aFt;
  private boolean aFu;
  private u aFv;
  private final int mode;
  
  public t()
  {
    this((byte)0);
  }
  
  private t(byte paramByte)
  {
    this('\000');
  }
  
  private t(char paramChar)
  {
    this(1, new com.google.android.exoplayer2.i.q(0L), new e((byte)0));
  }
  
  public t(int paramInt, com.google.android.exoplayer2.i.q paramq, u.c paramc)
  {
    this.aFp = ((u.c)a.E(paramc));
    this.mode = paramInt;
    if ((paramInt == 1) || (paramInt == 2)) {
      this.aFm = Collections.singletonList(paramq);
    }
    for (;;)
    {
      this.aFn = new j(9400);
      this.aFr = new SparseBooleanArray();
      this.aFq = new SparseArray();
      this.aFo = new SparseIntArray();
      mc();
      return;
      this.aFm = new ArrayList();
      this.aFm.add(paramq);
    }
  }
  
  private void mc()
  {
    this.aFr.clear();
    this.aFq.clear();
    SparseArray localSparseArray = this.aFp.mb();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.aFq.put(localSparseArray.keyAt(i), localSparseArray.valueAt(i));
      i += 1;
    }
    this.aFq.put(0, new q(new t.a(this)));
    this.aFv = null;
  }
  
  public final int a(com.google.android.exoplayer2.c.e parame)
  {
    int k = 1;
    int j = 0;
    byte[] arrayOfByte = this.aFn.data;
    int i;
    if (9400 - this.aFn.position < 188)
    {
      i = this.aFn.oe();
      if (i > 0) {
        System.arraycopy(arrayOfByte, this.aFn.position, arrayOfByte, 0, i);
      }
      this.aFn.m(arrayOfByte, i);
    }
    int m;
    if (this.aFn.oe() < 188)
    {
      i = this.aFn.limit;
      m = parame.read(arrayOfByte, i, 9400 - i);
      if (m == -1) {
        i = -1;
      }
    }
    int n;
    do
    {
      return i;
      this.aFn.dA(i + m);
      break;
      m = this.aFn.limit;
      i = this.aFn.position;
      while ((i < m) && (arrayOfByte[i] != 71)) {
        i += 1;
      }
      this.aFn.setPosition(i);
      n = i + 188;
      i = j;
    } while (n > m);
    int i2 = this.aFn.readInt();
    if ((0x800000 & i2) != 0)
    {
      this.aFn.setPosition(n);
      return 0;
    }
    boolean bool;
    int i1;
    if ((0x400000 & i2) != 0)
    {
      bool = true;
      i1 = (0x1FFF00 & i2) >> 8;
      if ((i2 & 0x20) == 0) {
        break label331;
      }
      i = 1;
      label252:
      if ((i2 & 0x10) == 0) {
        break label336;
      }
      j = 1;
    }
    for (;;)
    {
      if (this.mode != 2)
      {
        i2 &= 0xF;
        int i3 = this.aFo.get(i1, i2 - 1);
        this.aFo.put(i1, i2);
        if (i3 == i2)
        {
          if (j == 0) {
            break label446;
          }
          this.aFn.setPosition(n);
          return 0;
          bool = false;
          break;
          label331:
          i = 0;
          break label252;
          label336:
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
        i = this.aFn.readUnsignedByte();
        this.aFn.dB(i);
      }
      if (j != 0)
      {
        parame = (u)this.aFq.get(i1);
        if (parame != null)
        {
          if (k != 0) {
            parame.lY();
          }
          this.aFn.dA(n);
          parame.a(this.aFn, bool);
          this.aFn.dA(m);
        }
      }
      this.aFn.setPosition(n);
      return 0;
      label446:
      k = 0;
    }
  }
  
  public final void a(f paramf)
  {
    this.aFs = paramf;
    new j.a(-9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.t
 * JD-Core Version:    0.7.0.1
 */