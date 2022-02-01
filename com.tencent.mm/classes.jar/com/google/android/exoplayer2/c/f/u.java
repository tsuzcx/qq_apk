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
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class u
  implements com.google.android.exoplayer2.c.e
{
  public static final h bil;
  private static final long bss;
  private static final long bst;
  private static final long bsu;
  private g bph;
  private final SparseBooleanArray bsA;
  private int bsB;
  private boolean bsC;
  private v bsD;
  private final List<com.google.android.exoplayer2.i.u> bsv;
  private final m bsw;
  private final SparseIntArray bsx;
  private final v.c bsy;
  private final SparseArray<v> bsz;
  private final int mode;
  
  static
  {
    AppMethodBeat.i(92299);
    bil = new h()
    {
      public final com.google.android.exoplayer2.c.e[] ux()
      {
        AppMethodBeat.i(92287);
        u localu = new u();
        AppMethodBeat.o(92287);
        return new com.google.android.exoplayer2.c.e[] { localu };
      }
    };
    bss = x.bJ("AC-3");
    bst = x.bJ("EAC3");
    bsu = x.bJ("HEVC");
    AppMethodBeat.o(92299);
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
    AppMethodBeat.i(92292);
    AppMethodBeat.o(92292);
  }
  
  public u(int paramInt, com.google.android.exoplayer2.i.u paramu, v.c paramc)
  {
    AppMethodBeat.i(92293);
    this.bsy = ((v.c)a.checkNotNull(paramc));
    this.mode = paramInt;
    if ((paramInt == 1) || (paramInt == 2)) {
      this.bsv = Collections.singletonList(paramu);
    }
    for (;;)
    {
      this.bsw = new m(9400);
      this.bsA = new SparseBooleanArray();
      this.bsz = new SparseArray();
      this.bsx = new SparseIntArray();
      uT();
      AppMethodBeat.o(92293);
      return;
      this.bsv = new ArrayList();
      this.bsv.add(paramu);
    }
  }
  
  private void uT()
  {
    AppMethodBeat.i(92298);
    this.bsA.clear();
    this.bsz.clear();
    SparseArray localSparseArray = this.bsy.uS();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.bsz.put(localSparseArray.keyAt(i), localSparseArray.valueAt(i));
      i += 1;
    }
    this.bsz.put(0, new r(new a()));
    this.bsD = null;
    AppMethodBeat.o(92298);
  }
  
  public final int a(f paramf, k paramk)
  {
    int k = 1;
    AppMethodBeat.i(92297);
    paramk = this.bsw.data;
    if (9400 - this.bsw.position < 188)
    {
      i = this.bsw.xd();
      if (i > 0) {
        System.arraycopy(paramk, this.bsw.position, paramk, 0, i);
      }
      this.bsw.n(paramk, i);
    }
    int j;
    while (this.bsw.xd() < 188)
    {
      i = this.bsw.limit;
      j = paramf.read(paramk, i, 9400 - i);
      if (j == -1)
      {
        AppMethodBeat.o(92297);
        return -1;
      }
      this.bsw.eY(i + j);
    }
    int m = this.bsw.limit;
    int i = this.bsw.position;
    while ((i < m) && (paramk[i] != 71)) {
      i += 1;
    }
    this.bsw.setPosition(i);
    int n = i + 188;
    if (n > m)
    {
      AppMethodBeat.o(92297);
      return 0;
    }
    int i2 = this.bsw.readInt();
    if ((0x800000 & i2) != 0)
    {
      this.bsw.setPosition(n);
      AppMethodBeat.o(92297);
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
        int i3 = this.bsx.get(i1, i2 - 1);
        this.bsx.put(i1, i2);
        if (i3 == i2)
        {
          if (j == 0) {
            break label473;
          }
          this.bsw.setPosition(n);
          AppMethodBeat.o(92297);
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
        i = this.bsw.readUnsignedByte();
        this.bsw.eZ(i);
      }
      if (j != 0)
      {
        paramf = (v)this.bsz.get(i1);
        if (paramf != null)
        {
          if (k != 0) {
            paramf.uK();
          }
          this.bsw.eY(n);
          paramf.a(this.bsw, bool);
          this.bsw.eY(m);
        }
      }
      this.bsw.setPosition(n);
      AppMethodBeat.o(92297);
      return 0;
      label473:
      k = 0;
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92295);
    this.bph = paramg;
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(92295);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92294);
    byte[] arrayOfByte = this.bsw.data;
    paramf.b(arrayOfByte, 0, 940);
    int i = 0;
    while (i < 188)
    {
      int j = 0;
      for (;;)
      {
        if (j == 5)
        {
          paramf.dP(i);
          AppMethodBeat.o(92294);
          return true;
        }
        if (arrayOfByte[(j * 188 + i)] != 71) {
          break;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(92294);
    return false;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92296);
    int j = this.bsv.size();
    int i = 0;
    while (i < j)
    {
      ((com.google.android.exoplayer2.i.u)this.bsv.get(i)).bHG = -9223372036854775807L;
      i += 1;
    }
    this.bsw.reset();
    this.bsx.clear();
    uT();
    AppMethodBeat.o(92296);
  }
  
  final class a
    implements q
  {
    private final l bsE;
    
    public a()
    {
      AppMethodBeat.i(92288);
      this.bsE = new l(new byte[4]);
      AppMethodBeat.o(92288);
    }
    
    public final void a(com.google.android.exoplayer2.i.u paramu, g paramg, v.d paramd) {}
    
    public final void t(m paramm)
    {
      AppMethodBeat.i(92289);
      if (paramm.readUnsignedByte() != 0)
      {
        AppMethodBeat.o(92289);
        return;
      }
      paramm.eZ(7);
      int j = paramm.xd() / 4;
      int i = 0;
      if (i < j)
      {
        paramm.c(this.bsE, 4);
        int k = this.bsE.em(16);
        this.bsE.en(3);
        if (k == 0) {
          this.bsE.en(13);
        }
        for (;;)
        {
          i += 1;
          break;
          k = this.bsE.em(13);
          u.a(u.this).put(k, new r(new u.b(u.this, k)));
          u.b(u.this);
        }
      }
      if (u.c(u.this) != 2) {
        u.a(u.this).remove(0);
      }
      AppMethodBeat.o(92289);
    }
  }
  
  final class b
    implements q
  {
    private final l bsG;
    private final SparseArray<v> bsH;
    private final SparseIntArray bsI;
    private final int pid;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(92290);
      this.bsG = new l(new byte[5]);
      this.bsH = new SparseArray();
      this.bsI = new SparseIntArray();
      this.pid = paramInt;
      AppMethodBeat.o(92290);
    }
    
    public final void a(com.google.android.exoplayer2.i.u paramu, g paramg, v.d paramd) {}
    
    public final void t(m paramm)
    {
      AppMethodBeat.i(92291);
      if (paramm.readUnsignedByte() != 2)
      {
        AppMethodBeat.o(92291);
        return;
      }
      com.google.android.exoplayer2.i.u localu;
      int i1;
      int j;
      int k;
      int m;
      int i2;
      int i3;
      int i4;
      label314:
      int i5;
      long l;
      Object localObject4;
      Object localObject2;
      if ((u.c(u.this) == 1) || (u.c(u.this) == 2) || (u.d(u.this) == 1))
      {
        localu = (com.google.android.exoplayer2.i.u)u.e(u.this).get(0);
        paramm.eZ(2);
        i1 = paramm.readUnsignedShort();
        paramm.eZ(5);
        paramm.c(this.bsG, 2);
        this.bsG.en(4);
        paramm.eZ(this.bsG.em(12));
        if ((u.c(u.this) == 2) && (u.f(u.this) == null))
        {
          localObject1 = new v.b(21, null, null, new byte[0]);
          u.a(u.this, u.g(u.this).a(21, (v.b)localObject1));
          u.f(u.this).a(localu, u.h(u.this), new v.d(i1, 21, 8192));
        }
        this.bsH.clear();
        this.bsI.clear();
        j = paramm.xd();
        if (j <= 0) {
          break label871;
        }
        paramm.c(this.bsG, 5);
        k = this.bsG.em(8);
        this.bsG.en(3);
        m = this.bsG.em(13);
        this.bsG.en(4);
        i2 = this.bsG.em(12);
        i3 = paramm.position;
        i4 = i3 + i2;
        i = -1;
        localObject1 = null;
        localObject3 = null;
        if (paramm.position >= i4) {
          break label685;
        }
        n = paramm.readUnsignedByte();
        i5 = paramm.readUnsignedByte() + paramm.position;
        if (n != 5) {
          break label496;
        }
        l = paramm.dE();
        if (l != u.bss) {
          break label441;
        }
        i = 129;
        localObject4 = localObject1;
        localObject2 = localObject3;
      }
      label441:
      label496:
      do
      {
        for (;;)
        {
          paramm.eZ(i5 - paramm.position);
          localObject3 = localObject2;
          localObject1 = localObject4;
          break label314;
          localu = new com.google.android.exoplayer2.i.u(((com.google.android.exoplayer2.i.u)u.e(u.this).get(0)).bqk);
          u.e(u.this).add(localu);
          break;
          if (l == u.uU())
          {
            i = 135;
            localObject2 = localObject3;
            localObject4 = localObject1;
          }
          else
          {
            localObject2 = localObject3;
            localObject4 = localObject1;
            if (l == u.uV())
            {
              i = 36;
              localObject2 = localObject3;
              localObject4 = localObject1;
              continue;
              if (n == 106)
              {
                i = 129;
                localObject2 = localObject3;
                localObject4 = localObject1;
              }
              else if (n == 122)
              {
                i = 135;
                localObject2 = localObject3;
                localObject4 = localObject1;
              }
              else if (n == 123)
              {
                i = 138;
                localObject2 = localObject3;
                localObject4 = localObject1;
              }
              else
              {
                if (n != 10) {
                  break label586;
                }
                localObject4 = paramm.readString(3).trim();
                localObject2 = localObject3;
              }
            }
          }
        }
        localObject2 = localObject3;
        localObject4 = localObject1;
      } while (n != 89);
      label586:
      int n = 89;
      Object localObject3 = new ArrayList();
      for (;;)
      {
        localObject2 = localObject3;
        localObject4 = localObject1;
        i = n;
        if (paramm.position >= i5) {
          break;
        }
        localObject2 = paramm.readString(3).trim();
        i = paramm.readUnsignedByte();
        localObject4 = new byte[4];
        paramm.readBytes((byte[])localObject4, 0, 4);
        ((List)localObject3).add(new v.a((String)localObject2, i, (byte[])localObject4));
      }
      label685:
      paramm.setPosition(i4);
      Object localObject1 = new v.b(i, (String)localObject1, (List)localObject3, Arrays.copyOfRange(paramm.data, i3, i4));
      if (k == 6) {}
      for (int i = ((v.b)localObject1).streamType;; i = k)
      {
        j -= i2 + 5;
        if (u.c(u.this) == 2)
        {
          k = i;
          label750:
          if (u.i(u.this).get(k)) {
            break label1134;
          }
          if ((u.c(u.this) != 2) || (i != 21)) {
            break label851;
          }
        }
        label851:
        for (localObject1 = u.f(u.this);; localObject1 = u.g(u.this).a(i, (v.b)localObject1))
        {
          if ((u.c(u.this) != 2) || (m < this.bsI.get(k, 8192)))
          {
            this.bsI.put(k, m);
            this.bsH.put(k, localObject1);
          }
          break;
          k = m;
          break label750;
        }
        label871:
        j = this.bsI.size();
        i = 0;
        while (i < j)
        {
          k = this.bsI.keyAt(i);
          u.i(u.this).put(k, true);
          paramm = (v)this.bsH.valueAt(i);
          if (paramm != null)
          {
            if (paramm != u.f(u.this)) {
              paramm.a(localu, u.h(u.this), new v.d(i1, k, 8192));
            }
            u.a(u.this).put(this.bsI.valueAt(i), paramm);
          }
          i += 1;
        }
        if (u.c(u.this) == 2)
        {
          if (!u.j(u.this))
          {
            u.h(u.this).uy();
            u.a(u.this, 0);
            u.k(u.this);
            AppMethodBeat.o(92291);
          }
        }
        else
        {
          u.a(u.this).remove(this.pid);
          paramm = u.this;
          if (u.c(u.this) != 1) {
            break label1121;
          }
        }
        label1121:
        for (i = 0;; i = u.d(u.this) - 1)
        {
          u.a(paramm, i);
          if (u.d(u.this) == 0)
          {
            u.h(u.this).uy();
            u.k(u.this);
          }
          AppMethodBeat.o(92291);
          return;
        }
        label1134:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.u
 * JD-Core Version:    0.7.0.1
 */