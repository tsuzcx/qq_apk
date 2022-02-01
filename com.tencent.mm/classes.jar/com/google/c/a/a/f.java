package com.google.c.a.a;

import com.google.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

final class f
{
  static final f bRT;
  private final g bRU;
  final int bRV;
  final int bRW;
  final int mode;
  
  static
  {
    AppMethodBeat.i(12368);
    bRT = new f(g.bRX, 0, 0, 0);
    AppMethodBeat.o(12368);
  }
  
  private f(g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bRU = paramg;
    this.mode = paramInt1;
    this.bRV = paramInt2;
    this.bRW = paramInt3;
  }
  
  final boolean a(f paramf)
  {
    int j = this.bRW + (d.bRN[this.mode][paramf.mode] >> 16);
    int i = j;
    if (paramf.bRV > 0) {
      if (this.bRV != 0)
      {
        i = j;
        if (this.bRV <= paramf.bRV) {}
      }
      else
      {
        i = j + 10;
      }
    }
    return i <= paramf.bRW;
  }
  
  final f bD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12362);
    int i = this.bRW;
    Object localObject = this.bRU;
    int j;
    if (paramInt1 != this.mode)
    {
      j = d.bRN[this.mode][paramInt1];
      localObject = ((g)localObject).bF(0xFFFF & j, j >> 16);
      i += (j >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 2) {}
      for (j = 4;; j = 5)
      {
        localObject = new f(((g)localObject).bF(paramInt2, j), paramInt1, 0, j + i);
        AppMethodBeat.o(12362);
        return localObject;
      }
    }
  }
  
  final f bE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12363);
    Object localObject = this.bRU;
    if (this.mode == 2) {}
    for (int i = 4;; i = 5)
    {
      localObject = new f(((g)localObject).bF(d.bRP[this.mode][paramInt1], i).bF(paramInt2, 5), this.mode, 0, i + this.bRW + 5);
      AppMethodBeat.o(12363);
      return localObject;
    }
  }
  
  final f fS(int paramInt)
  {
    AppMethodBeat.i(12364);
    g localg = this.bRU;
    int m = this.mode;
    int i = this.bRW;
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
      j = d.bRN[m][0];
      localObject = localg.bF(0xFFFF & j, j >> 16);
      k = i + (j >> 16);
      j = 0;
    }
    if ((this.bRV == 0) || (this.bRV == 31))
    {
      i = 18;
      localObject = new f((g)localObject, j, this.bRV + 1, k + i);
      if (((f)localObject).bRV != 2078) {
        break label175;
      }
      localObject = ((f)localObject).fT(paramInt + 1);
    }
    label175:
    for (;;)
    {
      AppMethodBeat.o(12364);
      return localObject;
      if (this.bRV == 62)
      {
        i = 9;
        break;
      }
      i = 8;
      break;
    }
  }
  
  final f fT(int paramInt)
  {
    AppMethodBeat.i(12365);
    if (this.bRV == 0)
    {
      AppMethodBeat.o(12365);
      return this;
    }
    f localf = new f(this.bRU.bG(paramInt - this.bRV, this.bRV), this.mode, 0, this.bRW);
    AppMethodBeat.o(12365);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12367);
    String str = String.format("%s bits=%d bytes=%d", new Object[] { d.bRM[this.mode], Integer.valueOf(this.bRW), Integer.valueOf(this.bRV) });
    AppMethodBeat.o(12367);
    return str;
  }
  
  final a v(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12366);
    Object localObject2 = new LinkedList();
    for (Object localObject1 = fT(paramArrayOfByte.length).bRU; localObject1 != null; localObject1 = ((g)localObject1).bRY) {
      ((Deque)localObject2).addFirst(localObject1);
    }
    localObject1 = new a();
    localObject2 = ((Deque)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((g)((Iterator)localObject2).next()).a((a)localObject1, paramArrayOfByte);
    }
    AppMethodBeat.o(12366);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.a.a.f
 * JD-Core Version:    0.7.0.1
 */