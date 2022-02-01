package com.google.c.a.a;

import com.google.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

final class f
{
  static final f cdV;
  private final g cdW;
  final int cdX;
  final int cdY;
  final int mode;
  
  static
  {
    AppMethodBeat.i(12368);
    cdV = new f(g.cdZ, 0, 0, 0);
    AppMethodBeat.o(12368);
  }
  
  private f(g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cdW = paramg;
    this.mode = paramInt1;
    this.cdX = paramInt2;
    this.cdY = paramInt3;
  }
  
  final a H(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12366);
    Object localObject2 = new LinkedList();
    for (Object localObject1 = hV(paramArrayOfByte.length).cdW; localObject1 != null; localObject1 = ((g)localObject1).cea) {
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
  
  final boolean a(f paramf)
  {
    int j = this.cdY + (d.cdP[this.mode][paramf.mode] >> 16);
    int i = j;
    if (paramf.cdX > 0) {
      if (this.cdX != 0)
      {
        i = j;
        if (this.cdX <= paramf.cdX) {}
      }
      else
      {
        i = j + 10;
      }
    }
    return i <= paramf.cdY;
  }
  
  final f bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12362);
    int i = this.cdY;
    Object localObject = this.cdW;
    int j;
    if (paramInt1 != this.mode)
    {
      j = d.cdP[this.mode][paramInt1];
      localObject = ((g)localObject).bW(0xFFFF & j, j >> 16);
      i += (j >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 2) {}
      for (j = 4;; j = 5)
      {
        localObject = new f(((g)localObject).bW(paramInt2, j), paramInt1, 0, j + i);
        AppMethodBeat.o(12362);
        return localObject;
      }
    }
  }
  
  final f bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12363);
    Object localObject = this.cdW;
    if (this.mode == 2) {}
    for (int i = 4;; i = 5)
    {
      localObject = new f(((g)localObject).bW(d.cdR[this.mode][paramInt1], i).bW(paramInt2, 5), this.mode, 0, i + this.cdY + 5);
      AppMethodBeat.o(12363);
      return localObject;
    }
  }
  
  final f hU(int paramInt)
  {
    AppMethodBeat.i(12364);
    g localg = this.cdW;
    int m = this.mode;
    int i = this.cdY;
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
      j = d.cdP[m][0];
      localObject = localg.bW(0xFFFF & j, j >> 16);
      k = i + (j >> 16);
      j = 0;
    }
    if ((this.cdX == 0) || (this.cdX == 31))
    {
      i = 18;
      localObject = new f((g)localObject, j, this.cdX + 1, k + i);
      if (((f)localObject).cdX != 2078) {
        break label175;
      }
      localObject = ((f)localObject).hV(paramInt + 1);
    }
    label175:
    for (;;)
    {
      AppMethodBeat.o(12364);
      return localObject;
      if (this.cdX == 62)
      {
        i = 9;
        break;
      }
      i = 8;
      break;
    }
  }
  
  final f hV(int paramInt)
  {
    AppMethodBeat.i(12365);
    if (this.cdX == 0)
    {
      AppMethodBeat.o(12365);
      return this;
    }
    f localf = new f(this.cdW.bX(paramInt - this.cdX, this.cdX), this.mode, 0, this.cdY);
    AppMethodBeat.o(12365);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12367);
    String str = String.format("%s bits=%d bytes=%d", new Object[] { d.cdO[this.mode], Integer.valueOf(this.cdY), Integer.valueOf(this.cdX) });
    AppMethodBeat.o(12367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.a.a.f
 * JD-Core Version:    0.7.0.1
 */