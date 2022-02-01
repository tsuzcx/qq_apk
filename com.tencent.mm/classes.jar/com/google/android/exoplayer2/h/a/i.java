package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;
import java.util.TreeSet;

final class i
{
  final TreeSet<n> djC;
  public final int id;
  public final String key;
  long length;
  
  public i(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(92977);
    this.id = paramInt;
    this.key = paramString;
    this.length = paramLong;
    this.djC = new TreeSet();
    AppMethodBeat.o(92977);
  }
  
  public i(DataInputStream paramDataInputStream)
  {
    this(paramDataInputStream.readInt(), paramDataInputStream.readUTF(), paramDataInputStream.readLong());
    AppMethodBeat.i(92976);
    AppMethodBeat.o(92976);
  }
  
  public final int Uu()
  {
    AppMethodBeat.i(92980);
    int i = this.id;
    int j = this.key.hashCode();
    int k = (int)(this.length ^ this.length >>> 32);
    AppMethodBeat.o(92980);
    return (i * 31 + j) * 31 + k;
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(92978);
    this.djC.add(paramn);
    AppMethodBeat.o(92978);
  }
  
  public final n cE(long paramLong)
  {
    AppMethodBeat.i(92979);
    n localn1 = n.k(this.key, paramLong);
    n localn2 = (n)this.djC.floor(localn1);
    if ((localn2 != null) && (localn2.position + localn2.length > paramLong))
    {
      AppMethodBeat.o(92979);
      return localn2;
    }
    localn1 = (n)this.djC.ceiling(localn1);
    if (localn1 == null)
    {
      localn1 = n.l(this.key, paramLong);
      AppMethodBeat.o(92979);
      return localn1;
    }
    localn1 = n.g(this.key, paramLong, localn1.position - paramLong);
    AppMethodBeat.o(92979);
    return localn1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.i
 * JD-Core Version:    0.7.0.1
 */