package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataInputStream;
import java.util.TreeSet;

final class i
{
  long aFL;
  final TreeSet<n> bpY;
  public final int id;
  public final String key;
  
  public i(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(92977);
    this.id = paramInt;
    this.key = paramString;
    this.aFL = paramLong;
    this.bpY = new TreeSet();
    AppMethodBeat.o(92977);
  }
  
  public i(DataInputStream paramDataInputStream)
  {
    this(paramDataInputStream.readInt(), paramDataInputStream.readUTF(), paramDataInputStream.readLong());
    AppMethodBeat.i(92976);
    AppMethodBeat.o(92976);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(92978);
    this.bpY.add(paramn);
    AppMethodBeat.o(92978);
  }
  
  public final n aq(long paramLong)
  {
    AppMethodBeat.i(92979);
    n localn1 = n.k(this.key, paramLong);
    n localn2 = (n)this.bpY.floor(localn1);
    if ((localn2 != null) && (localn2.position + localn2.aFL > paramLong))
    {
      AppMethodBeat.o(92979);
      return localn2;
    }
    localn1 = (n)this.bpY.ceiling(localn1);
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
  
  public final int uV()
  {
    AppMethodBeat.i(92980);
    int i = this.id;
    int j = this.key.hashCode();
    int k = (int)(this.aFL ^ this.aFL >>> 32);
    AppMethodBeat.o(92980);
    return (i * 31 + j) * 31 + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.i
 * JD-Core Version:    0.7.0.1
 */