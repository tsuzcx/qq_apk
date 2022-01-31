package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

final class g
{
  long aPF;
  final TreeSet<k> bae;
  public final int id;
  public final String key;
  
  public g(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(151956);
    this.id = paramInt;
    this.key = paramString;
    this.aPF = paramLong;
    this.bae = new TreeSet();
    AppMethodBeat.o(151956);
  }
  
  public g(DataInputStream paramDataInputStream)
  {
    this(paramDataInputStream.readInt(), paramDataInputStream.readUTF(), paramDataInputStream.readLong());
    AppMethodBeat.i(151955);
    AppMethodBeat.o(151955);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(151957);
    this.bae.add(paramk);
    AppMethodBeat.o(151957);
  }
  
  public final k af(long paramLong)
  {
    AppMethodBeat.i(151958);
    k localk1 = k.j(this.key, paramLong);
    k localk2 = (k)this.bae.floor(localk1);
    if ((localk2 != null) && (localk2.position + localk2.aPF > paramLong))
    {
      AppMethodBeat.o(151958);
      return localk2;
    }
    localk1 = (k)this.bae.ceiling(localk1);
    if (localk1 == null)
    {
      localk1 = k.k(this.key, paramLong);
      AppMethodBeat.o(151958);
      return localk1;
    }
    localk1 = k.h(this.key, paramLong, localk1.position - paramLong);
    AppMethodBeat.o(151958);
    return localk1;
  }
  
  public final long m(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151959);
    Object localObject = af(paramLong1);
    int i;
    if (!((e)localObject).aZZ)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      if (!((k)localObject).qA()) {
        break label60;
      }
    }
    label60:
    for (paramLong1 = 9223372036854775807L;; paramLong1 = ((k)localObject).aPF)
    {
      paramLong1 = -Math.min(paramLong1, paramLong2);
      AppMethodBeat.o(151959);
      return paramLong1;
      i = 0;
      break;
    }
    label69:
    long l3 = paramLong1 + paramLong2;
    long l2 = ((k)localObject).position + ((k)localObject).aPF;
    long l1 = l2;
    if (l2 < l3)
    {
      localObject = this.bae.tailSet(localObject, false).iterator();
      l1 = l2;
      if (!((Iterator)localObject).hasNext()) {
        break label202;
      }
      k localk = (k)((Iterator)localObject).next();
      if (localk.position > l1) {
        break label202;
      }
      l2 = localk.position;
      l1 = Math.max(l1, localk.aPF + l2);
      if (l1 < l3) {
        break label199;
      }
    }
    label199:
    label202:
    for (;;)
    {
      paramLong1 = Math.min(l1 - paramLong1, paramLong2);
      AppMethodBeat.o(151959);
      return paramLong1;
      break;
    }
  }
  
  public final int qB()
  {
    AppMethodBeat.i(151960);
    int i = this.id;
    int j = this.key.hashCode();
    int k = (int)(this.aPF ^ this.aPF >>> 32);
    AppMethodBeat.o(151960);
    return (i * 31 + j) * 31 + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.g
 * JD-Core Version:    0.7.0.1
 */