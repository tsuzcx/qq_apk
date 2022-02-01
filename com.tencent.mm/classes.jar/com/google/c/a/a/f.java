package com.google.c.a.a;

import com.google.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

final class f
{
  static final f bJX;
  private final g bJY;
  final int bJZ;
  final int bKa;
  final int mode;
  
  static
  {
    AppMethodBeat.i(12368);
    bJX = new f(g.bKb, 0, 0, 0);
    AppMethodBeat.o(12368);
  }
  
  private f(g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bJY = paramg;
    this.mode = paramInt1;
    this.bJZ = paramInt2;
    this.bKa = paramInt3;
  }
  
  final boolean a(f paramf)
  {
    int j = this.bKa + (d.bJR[this.mode][paramf.mode] >> 16);
    int i = j;
    if (paramf.bJZ > 0) {
      if (this.bJZ != 0)
      {
        i = j;
        if (this.bJZ <= paramf.bJZ) {}
      }
      else
      {
        i = j + 10;
      }
    }
    return i <= paramf.bKa;
  }
  
  final f bE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12362);
    int i = this.bKa;
    Object localObject = this.bJY;
    int j;
    if (paramInt1 != this.mode)
    {
      j = d.bJR[this.mode][paramInt1];
      localObject = ((g)localObject).bG(0xFFFF & j, j >> 16);
      i += (j >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 2) {}
      for (j = 4;; j = 5)
      {
        localObject = new f(((g)localObject).bG(paramInt2, j), paramInt1, 0, j + i);
        AppMethodBeat.o(12362);
        return localObject;
      }
    }
  }
  
  final f bF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12363);
    Object localObject = this.bJY;
    if (this.mode == 2) {}
    for (int i = 4;; i = 5)
    {
      localObject = new f(((g)localObject).bG(d.bJT[this.mode][paramInt1], i).bG(paramInt2, 5), this.mode, 0, i + this.bKa + 5);
      AppMethodBeat.o(12363);
      return localObject;
    }
  }
  
  final f gd(int paramInt)
  {
    AppMethodBeat.i(12364);
    g localg = this.bJY;
    int m = this.mode;
    int i = this.bKa;
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
      j = d.bJR[m][0];
      localObject = localg.bG(0xFFFF & j, j >> 16);
      k = i + (j >> 16);
      j = 0;
    }
    if ((this.bJZ == 0) || (this.bJZ == 31))
    {
      i = 18;
      localObject = new f((g)localObject, j, this.bJZ + 1, k + i);
      if (((f)localObject).bJZ != 2078) {
        break label175;
      }
      localObject = ((f)localObject).ge(paramInt + 1);
    }
    label175:
    for (;;)
    {
      AppMethodBeat.o(12364);
      return localObject;
      if (this.bJZ == 62)
      {
        i = 9;
        break;
      }
      i = 8;
      break;
    }
  }
  
  final f ge(int paramInt)
  {
    AppMethodBeat.i(12365);
    if (this.bJZ == 0)
    {
      AppMethodBeat.o(12365);
      return this;
    }
    f localf = new f(this.bJY.bH(paramInt - this.bJZ, this.bJZ), this.mode, 0, this.bKa);
    AppMethodBeat.o(12365);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12367);
    String str = String.format("%s bits=%d bytes=%d", new Object[] { d.bJQ[this.mode], Integer.valueOf(this.bKa), Integer.valueOf(this.bJZ) });
    AppMethodBeat.o(12367);
    return str;
  }
  
  final a x(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12366);
    Object localObject2 = new LinkedList();
    for (Object localObject1 = ge(paramArrayOfByte.length).bJY; localObject1 != null; localObject1 = ((g)localObject1).bKc) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.a.a.f
 * JD-Core Version:    0.7.0.1
 */