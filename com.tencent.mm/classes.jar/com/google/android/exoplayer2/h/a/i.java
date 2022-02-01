package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;
import java.util.TreeSet;

final class i
{
  final TreeSet<m> bvP;
  public final int id;
  public final String key;
  long length;
  
  public i(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(92977);
    this.id = paramInt;
    this.key = paramString;
    this.length = paramLong;
    this.bvP = new TreeSet();
    AppMethodBeat.o(92977);
  }
  
  public i(DataInputStream paramDataInputStream)
  {
    this(paramDataInputStream.readInt(), paramDataInputStream.readUTF(), paramDataInputStream.readLong());
    AppMethodBeat.i(92976);
    AppMethodBeat.o(92976);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(92978);
    this.bvP.add(paramm);
    AppMethodBeat.o(92978);
  }
  
  public final m am(long paramLong)
  {
    AppMethodBeat.i(92979);
    m localm1 = m.j(this.key, paramLong);
    m localm2 = (m)this.bvP.floor(localm1);
    if ((localm2 != null) && (localm2.position + localm2.length > paramLong))
    {
      AppMethodBeat.o(92979);
      return localm2;
    }
    localm1 = (m)this.bvP.ceiling(localm1);
    if (localm1 == null)
    {
      localm1 = m.k(this.key, paramLong);
      AppMethodBeat.o(92979);
      return localm1;
    }
    localm1 = m.g(this.key, paramLong, localm1.position - paramLong);
    AppMethodBeat.o(92979);
    return localm1;
  }
  
  public final int vo()
  {
    AppMethodBeat.i(92980);
    int i = this.id;
    int j = this.key.hashCode();
    int k = (int)(this.length ^ this.length >>> 32);
    AppMethodBeat.o(92980);
    return (i * 31 + j) * 31 + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.i
 * JD-Core Version:    0.7.0.1
 */