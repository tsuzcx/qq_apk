package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

final class f
{
  static final f bid;
  private final g bie;
  final int bif;
  final int big;
  final int mode;
  
  static
  {
    AppMethodBeat.i(57303);
    bid = new f(g.bih, 0, 0, 0);
    AppMethodBeat.o(57303);
  }
  
  private f(g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bie = paramg;
    this.mode = paramInt1;
    this.bif = paramInt2;
    this.big = paramInt3;
  }
  
  final boolean a(f paramf)
  {
    int j = this.big + (d.bhX[this.mode][paramf.mode] >> 16);
    int i = j;
    if (paramf.bif > 0) {
      if (this.bif != 0)
      {
        i = j;
        if (this.bif <= paramf.bif) {}
      }
      else
      {
        i = j + 10;
      }
    }
    return i <= paramf.big;
  }
  
  final f bp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57297);
    int i = this.big;
    Object localObject = this.bie;
    int j;
    if (paramInt1 != this.mode)
    {
      j = d.bhX[this.mode][paramInt1];
      localObject = ((g)localObject).br(0xFFFF & j, j >> 16);
      i += (j >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 2) {}
      for (j = 4;; j = 5)
      {
        localObject = new f(((g)localObject).br(paramInt2, j), paramInt1, 0, j + i);
        AppMethodBeat.o(57297);
        return localObject;
      }
    }
  }
  
  final f bq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57298);
    Object localObject = this.bie;
    if (this.mode == 2) {}
    for (int i = 4;; i = 5)
    {
      localObject = new f(((g)localObject).br(d.bhZ[this.mode][paramInt1], i).br(paramInt2, 5), this.mode, 0, i + this.big + 5);
      AppMethodBeat.o(57298);
      return localObject;
    }
  }
  
  final f fb(int paramInt)
  {
    AppMethodBeat.i(57299);
    g localg = this.bie;
    int m = this.mode;
    int i = this.big;
    int k;
    int j;
    Object localObject;
    if (this.mode != 4)
    {
      k = i;
      j = m;
      localObject = localg;
      if (this.mode != 2) {}
    }
    else
    {
      j = d.bhX[m][0];
      localObject = localg.br(0xFFFF & j, j >> 16);
      k = i + (j >> 16);
      j = 0;
    }
    if ((this.bif == 0) || (this.bif == 31))
    {
      i = 18;
      localObject = new f((g)localObject, j, this.bif + 1, k + i);
      if (((f)localObject).bif != 2078) {
        break label173;
      }
      localObject = ((f)localObject).fc(paramInt + 1);
    }
    label173:
    for (;;)
    {
      AppMethodBeat.o(57299);
      return localObject;
      if (this.bif == 62)
      {
        i = 9;
        break;
      }
      i = 8;
      break;
    }
  }
  
  final f fc(int paramInt)
  {
    AppMethodBeat.i(57300);
    if (this.bif == 0)
    {
      AppMethodBeat.o(57300);
      return this;
    }
    f localf = new f(this.bie.bs(paramInt - this.bif, this.bif), this.mode, 0, this.big);
    AppMethodBeat.o(57300);
    return localf;
  }
  
  final a q(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57301);
    Object localObject2 = new LinkedList();
    for (Object localObject1 = fc(paramArrayOfByte.length).bie; localObject1 != null; localObject1 = ((g)localObject1).bii) {
      ((Deque)localObject2).addFirst(localObject1);
    }
    localObject1 = new a();
    localObject2 = ((Deque)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((g)((Iterator)localObject2).next()).a((a)localObject1, paramArrayOfByte);
    }
    AppMethodBeat.o(57301);
    return localObject1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57302);
    String str = String.format("%s bits=%d bytes=%d", new Object[] { d.bhW[this.mode], Integer.valueOf(this.big), Integer.valueOf(this.bif) });
    AppMethodBeat.o(57302);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */