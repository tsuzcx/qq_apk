package com.google.c.a.a;

import com.google.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

final class f
{
  static final f bHF;
  private final g bHG;
  final int bHH;
  final int bHI;
  final int mode;
  
  static
  {
    AppMethodBeat.i(12368);
    bHF = new f(g.bHJ, 0, 0, 0);
    AppMethodBeat.o(12368);
  }
  
  private f(g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bHG = paramg;
    this.mode = paramInt1;
    this.bHH = paramInt2;
    this.bHI = paramInt3;
  }
  
  final boolean a(f paramf)
  {
    int j = this.bHI + (d.bHz[this.mode][paramf.mode] >> 16);
    int i = j;
    if (paramf.bHH > 0) {
      if (this.bHH != 0)
      {
        i = j;
        if (this.bHH <= paramf.bHH) {}
      }
      else
      {
        i = j + 10;
      }
    }
    return i <= paramf.bHI;
  }
  
  final f bB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12362);
    int i = this.bHI;
    Object localObject = this.bHG;
    int j;
    if (paramInt1 != this.mode)
    {
      j = d.bHz[this.mode][paramInt1];
      localObject = ((g)localObject).bD(0xFFFF & j, j >> 16);
      i += (j >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 2) {}
      for (j = 4;; j = 5)
      {
        localObject = new f(((g)localObject).bD(paramInt2, j), paramInt1, 0, j + i);
        AppMethodBeat.o(12362);
        return localObject;
      }
    }
  }
  
  final f bC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12363);
    Object localObject = this.bHG;
    if (this.mode == 2) {}
    for (int i = 4;; i = 5)
    {
      localObject = new f(((g)localObject).bD(d.bHB[this.mode][paramInt1], i).bD(paramInt2, 5), this.mode, 0, i + this.bHI + 5);
      AppMethodBeat.o(12363);
      return localObject;
    }
  }
  
  final f fP(int paramInt)
  {
    AppMethodBeat.i(12364);
    g localg = this.bHG;
    int m = this.mode;
    int i = this.bHI;
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
      j = d.bHz[m][0];
      localObject = localg.bD(0xFFFF & j, j >> 16);
      k = i + (j >> 16);
      j = 0;
    }
    if ((this.bHH == 0) || (this.bHH == 31))
    {
      i = 18;
      localObject = new f((g)localObject, j, this.bHH + 1, k + i);
      if (((f)localObject).bHH != 2078) {
        break label175;
      }
      localObject = ((f)localObject).fQ(paramInt + 1);
    }
    label175:
    for (;;)
    {
      AppMethodBeat.o(12364);
      return localObject;
      if (this.bHH == 62)
      {
        i = 9;
        break;
      }
      i = 8;
      break;
    }
  }
  
  final f fQ(int paramInt)
  {
    AppMethodBeat.i(12365);
    if (this.bHH == 0)
    {
      AppMethodBeat.o(12365);
      return this;
    }
    f localf = new f(this.bHG.bE(paramInt - this.bHH, this.bHH), this.mode, 0, this.bHI);
    AppMethodBeat.o(12365);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12367);
    String str = String.format("%s bits=%d bytes=%d", new Object[] { d.bHy[this.mode], Integer.valueOf(this.bHI), Integer.valueOf(this.bHH) });
    AppMethodBeat.o(12367);
    return str;
  }
  
  final a v(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12366);
    Object localObject2 = new LinkedList();
    for (Object localObject1 = fQ(paramArrayOfByte.length).bHG; localObject1 != null; localObject1 = ((g)localObject1).bHK) {
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