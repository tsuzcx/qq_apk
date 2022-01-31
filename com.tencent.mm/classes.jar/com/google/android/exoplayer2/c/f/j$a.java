package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.k.a;
import com.google.android.exoplayer2.i.k.b;
import com.google.android.exoplayer2.i.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class j$a
{
  final m aCe;
  boolean aKA;
  boolean aKD;
  final boolean aKG;
  final boolean aKH;
  private final SparseArray<k.b> aKN;
  private final SparseArray<k.a> aKO;
  private final n aKP;
  int aKQ;
  int aKR;
  long aKS;
  long aKT;
  j.a.a aKU;
  j.a.a aKV;
  boolean aKW;
  long aKr;
  long aKz;
  private byte[] buffer;
  
  public j$a(m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95117);
    this.aCe = paramm;
    this.aKG = paramBoolean1;
    this.aKH = paramBoolean2;
    this.aKN = new SparseArray();
    this.aKO = new SparseArray();
    this.aKU = new j.a.a((byte)0);
    this.aKV = new j.a.a((byte)0);
    this.buffer = new byte[''];
    this.aKP = new n(this.buffer, 0, 0);
    reset();
    AppMethodBeat.o(95117);
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(95119);
    this.aKO.append(parama.aLc, parama);
    AppMethodBeat.o(95119);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(95118);
    this.aKN.append(paramb.baV, paramb);
    AppMethodBeat.o(95118);
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95121);
    if (!this.aKD)
    {
      AppMethodBeat.o(95121);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.buffer.length < this.aKQ + paramInt2) {
      this.buffer = Arrays.copyOf(this.buffer, (this.aKQ + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.aKQ, paramInt2);
    this.aKQ = (paramInt2 + this.aKQ);
    this.aKP.l(this.buffer, 0, this.aKQ);
    if (!this.aKP.ep(8))
    {
      AppMethodBeat.o(95121);
      return;
    }
    this.aKP.qK();
    int i3 = this.aKP.dD(2);
    this.aKP.dE(5);
    if (!this.aKP.qX())
    {
      AppMethodBeat.o(95121);
      return;
    }
    this.aKP.qZ();
    if (!this.aKP.qX())
    {
      AppMethodBeat.o(95121);
      return;
    }
    int i4 = this.aKP.qZ();
    if (!this.aKH)
    {
      this.aKD = false;
      this.aKV.dG(i4);
      AppMethodBeat.o(95121);
      return;
    }
    if (!this.aKP.qX())
    {
      AppMethodBeat.o(95121);
      return;
    }
    int i5 = this.aKP.qZ();
    if (this.aKO.indexOfKey(i5) < 0)
    {
      this.aKD = false;
      AppMethodBeat.o(95121);
      return;
    }
    paramArrayOfByte = (k.a)this.aKO.get(i5);
    k.b localb = (k.b)this.aKN.get(paramArrayOfByte.baV);
    if (localb.baY)
    {
      if (!this.aKP.ep(2))
      {
        AppMethodBeat.o(95121);
        return;
      }
      this.aKP.dE(2);
    }
    if (!this.aKP.ep(localb.bba))
    {
      AppMethodBeat.o(95121);
      return;
    }
    boolean bool2 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    int i6 = this.aKP.dD(localb.bba);
    boolean bool3 = bool5;
    boolean bool1 = bool6;
    if (!localb.baZ)
    {
      if (!this.aKP.ep(1))
      {
        AppMethodBeat.o(95121);
        return;
      }
      bool4 = this.aKP.oj();
      bool2 = bool4;
      bool3 = bool5;
      bool1 = bool6;
      if (bool4)
      {
        if (!this.aKP.ep(1))
        {
          AppMethodBeat.o(95121);
          return;
        }
        bool1 = this.aKP.oj();
        bool3 = true;
        bool2 = bool4;
      }
    }
    if (this.aKR == 5) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      paramInt1 = 0;
      if (!bool4) {
        break label508;
      }
      if (this.aKP.qX()) {
        break;
      }
      AppMethodBeat.o(95121);
      return;
    }
    paramInt1 = this.aKP.qZ();
    label508:
    int i1 = 0;
    int m = 0;
    int i2 = 0;
    int n = 0;
    int i;
    int j;
    int k;
    if (localb.bbb == 0)
    {
      if (!this.aKP.ep(localb.bbc))
      {
        AppMethodBeat.o(95121);
        return;
      }
      i1 = this.aKP.dD(localb.bbc);
      i = i1;
      j = m;
      paramInt2 = i2;
      k = n;
      if (paramArrayOfByte.baW)
      {
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (!bool2)
        {
          if (!this.aKP.qX())
          {
            AppMethodBeat.o(95121);
            return;
          }
          j = this.aKP.qY();
          k = n;
          paramInt2 = i2;
          i = i1;
        }
      }
    }
    for (;;)
    {
      this.aKV.a(localb, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
      this.aKD = false;
      AppMethodBeat.o(95121);
      return;
      i = i1;
      j = m;
      paramInt2 = i2;
      k = n;
      if (localb.bbb == 1)
      {
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (!localb.bbd)
        {
          if (!this.aKP.qX())
          {
            AppMethodBeat.o(95121);
            return;
          }
          i2 = this.aKP.qY();
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (paramArrayOfByte.baW)
          {
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (!bool2)
            {
              if (!this.aKP.qX())
              {
                AppMethodBeat.o(95121);
                return;
              }
              k = this.aKP.qY();
              i = i1;
              j = m;
              paramInt2 = i2;
            }
          }
        }
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(95120);
    this.aKD = false;
    this.aKW = false;
    this.aKV.clear();
    AppMethodBeat.o(95120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.j.a
 * JD-Core Version:    0.7.0.1
 */