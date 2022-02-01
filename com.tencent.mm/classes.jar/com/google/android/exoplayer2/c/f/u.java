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
  public static final h aXT;
  private static final long bid;
  private static final long bie;
  private static final long bif;
  private g beR;
  private final List<com.google.android.exoplayer2.i.u> big;
  private final m bih;
  private final SparseIntArray bii;
  private final v.c bij;
  private final SparseArray<v> bik;
  private final SparseBooleanArray bil;
  private int bim;
  private boolean bin;
  private v bio;
  private final int mode;
  
  static
  {
    AppMethodBeat.i(92299);
    aXT = new h()
    {
      public final com.google.android.exoplayer2.c.e[] sT()
      {
        AppMethodBeat.i(92287);
        u localu = new u();
        AppMethodBeat.o(92287);
        return new com.google.android.exoplayer2.c.e[] { localu };
      }
    };
    bid = x.aQ("AC-3");
    bie = x.aQ("EAC3");
    bif = x.aQ("HEVC");
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
    this.bij = ((v.c)a.checkNotNull(paramc));
    this.mode = paramInt;
    if ((paramInt == 1) || (paramInt == 2)) {
      this.big = Collections.singletonList(paramu);
    }
    for (;;)
    {
      this.bih = new m(9400);
      this.bil = new SparseBooleanArray();
      this.bik = new SparseArray();
      this.bii = new SparseIntArray();
      tp();
      AppMethodBeat.o(92293);
      return;
      this.big = new ArrayList();
      this.big.add(paramu);
    }
  }
  
  private void tp()
  {
    AppMethodBeat.i(92298);
    this.bil.clear();
    this.bik.clear();
    SparseArray localSparseArray = this.bij.to();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.bik.put(localSparseArray.keyAt(i), localSparseArray.valueAt(i));
      i += 1;
    }
    this.bik.put(0, new r(new a()));
    this.bio = null;
    AppMethodBeat.o(92298);
  }
  
  public final int a(f paramf, k paramk)
  {
    int k = 1;
    AppMethodBeat.i(92297);
    paramk = this.bih.data;
    if (9400 - this.bih.position < 188)
    {
      i = this.bih.vy();
      if (i > 0) {
        System.arraycopy(paramk, this.bih.position, paramk, 0, i);
      }
      this.bih.n(paramk, i);
    }
    int j;
    while (this.bih.vy() < 188)
    {
      i = this.bih.limit;
      j = paramf.read(paramk, i, 9400 - i);
      if (j == -1)
      {
        AppMethodBeat.o(92297);
        return -1;
      }
      this.bih.eW(i + j);
    }
    int m = this.bih.limit;
    int i = this.bih.position;
    while ((i < m) && (paramk[i] != 71)) {
      i += 1;
    }
    this.bih.setPosition(i);
    int n = i + 188;
    if (n > m)
    {
      AppMethodBeat.o(92297);
      return 0;
    }
    int i2 = this.bih.readInt();
    if ((0x800000 & i2) != 0)
    {
      this.bih.setPosition(n);
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
        int i3 = this.bii.get(i1, i2 - 1);
        this.bii.put(i1, i2);
        if (i3 == i2)
        {
          if (j == 0) {
            break label473;
          }
          this.bih.setPosition(n);
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
        i = this.bih.readUnsignedByte();
        this.bih.eX(i);
      }
      if (j != 0)
      {
        paramf = (v)this.bik.get(i1);
        if (paramf != null)
        {
          if (k != 0) {
            paramf.tg();
          }
          this.bih.eW(n);
          paramf.a(this.bih, bool);
          this.bih.eW(m);
        }
      }
      this.bih.setPosition(n);
      AppMethodBeat.o(92297);
      return 0;
      label473:
      k = 0;
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(92295);
    this.beR = paramg;
    paramg.a(new l.a(-9223372036854775807L));
    AppMethodBeat.o(92295);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92294);
    byte[] arrayOfByte = this.bih.data;
    paramf.b(arrayOfByte, 0, 940);
    int i = 0;
    while (i < 188)
    {
      int j = 0;
      for (;;)
      {
        if (j == 5)
        {
          paramf.dQ(i);
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
    int j = this.big.size();
    int i = 0;
    while (i < j)
    {
      ((com.google.android.exoplayer2.i.u)this.big.get(i)).bxb = -9223372036854775807L;
      i += 1;
    }
    this.bih.reset();
    this.bii.clear();
    tp();
    AppMethodBeat.o(92296);
  }
  
  final class a
    implements q
  {
    private final l bip;
    
    public a()
    {
      AppMethodBeat.i(92288);
      this.bip = new l(new byte[4]);
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
      paramm.eX(7);
      int j = paramm.vy() / 4;
      int i = 0;
      if (i < j)
      {
        paramm.c(this.bip, 4);
        int k = this.bip.eo(16);
        this.bip.ep(3);
        if (k == 0) {
          this.bip.ep(13);
        }
        for (;;)
        {
          i += 1;
          break;
          k = this.bip.eo(13);
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
    private final l bir;
    private final SparseArray<v> bis;
    private final SparseIntArray bit;
    private final int pid;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(92290);
      this.bir = new l(new byte[5]);
      this.bis = new SparseArray();
      this.bit = new SparseIntArray();
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
        paramm.eX(2);
        i1 = paramm.readUnsignedShort();
        paramm.eX(5);
        paramm.c(this.bir, 2);
        this.bir.ep(4);
        paramm.eX(this.bir.eo(12));
        if ((u.c(u.this) == 2) && (u.f(u.this) == null))
        {
          localObject1 = new v.b(21, null, null, new byte[0]);
          u.a(u.this, u.g(u.this).a(21, (v.b)localObject1));
          u.f(u.this).a(localu, u.h(u.this), new v.d(i1, 21, 8192));
        }
        this.bis.clear();
        this.bit.clear();
        j = paramm.vy();
        if (j <= 0) {
          break label871;
        }
        paramm.c(this.bir, 5);
        k = this.bir.eo(8);
        this.bir.ep(3);
        m = this.bir.eo(13);
        this.bir.ep(4);
        i2 = this.bir.eo(12);
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
        l = paramm.dm();
        if (l != u.bid) {
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
          paramm.eX(i5 - paramm.position);
          localObject3 = localObject2;
          localObject1 = localObject4;
          break label314;
          localu = new com.google.android.exoplayer2.i.u(((com.google.android.exoplayer2.i.u)u.e(u.this).get(0)).bfV);
          u.e(u.this).add(localu);
          break;
          if (l == u.tq())
          {
            i = 135;
            localObject2 = localObject3;
            localObject4 = localObject1;
          }
          else
          {
            localObject2 = localObject3;
            localObject4 = localObject1;
            if (l == u.tr())
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
          if ((u.c(u.this) != 2) || (m < this.bit.get(k, 8192)))
          {
            this.bit.put(k, m);
            this.bis.put(k, localObject1);
          }
          break;
          k = m;
          break label750;
        }
        label871:
        j = this.bit.size();
        i = 0;
        while (i < j)
        {
          k = this.bit.keyAt(i);
          u.i(u.this).put(k, true);
          paramm = (v)this.bis.valueAt(i);
          if (paramm != null)
          {
            if (paramm != u.f(u.this)) {
              paramm.a(localu, u.h(u.this), new v.d(i1, k, 8192));
            }
            u.a(u.this).put(this.bit.valueAt(i), paramm);
          }
          i += 1;
        }
        if (u.c(u.this) == 2)
        {
          if (!u.j(u.this))
          {
            u.h(u.this).sU();
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
            u.h(u.this).sU();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.u
 * JD-Core Version:    0.7.0.1
 */