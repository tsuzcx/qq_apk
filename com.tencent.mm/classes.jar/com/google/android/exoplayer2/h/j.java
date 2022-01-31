package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  public final long aPF;
  public final byte[] aYx;
  public final long aYy;
  public final int flags;
  public final String key;
  public final long position;
  public final Uri uri;
  
  public j(Uri paramUri)
  {
    this(paramUri, 0L, -1L, null, 1);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    this(paramUri, null, paramLong1, paramLong2, paramLong3, paramString, paramInt);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, String paramString)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, 0);
    AppMethodBeat.i(95801);
    AppMethodBeat.o(95801);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, paramInt);
    AppMethodBeat.i(152014);
    AppMethodBeat.o(152014);
  }
  
  public j(Uri paramUri, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    AppMethodBeat.i(95802);
    if (paramLong1 >= 0L)
    {
      bool = true;
      a.checkArgument(bool);
      if (paramLong2 < 0L) {
        break label113;
      }
      bool = true;
      label33:
      a.checkArgument(bool);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L)) {
        break label119;
      }
    }
    label113:
    label119:
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.uri = paramUri;
      this.aYx = paramArrayOfByte;
      this.aYy = paramLong1;
      this.position = paramLong2;
      this.aPF = paramLong3;
      this.key = paramString;
      this.flags = paramInt;
      AppMethodBeat.o(95802);
      return;
      bool = false;
      break;
      bool = false;
      break label33;
    }
  }
  
  private j k(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95805);
    if ((paramLong1 == 0L) && (this.aPF == paramLong2))
    {
      AppMethodBeat.o(95805);
      return this;
    }
    j localj = new j(this.uri, this.aYx, this.aYy + paramLong1, this.position + paramLong1, paramLong2, this.key, this.flags);
    AppMethodBeat.o(95805);
    return localj;
  }
  
  public final j ae(long paramLong)
  {
    long l = -1L;
    AppMethodBeat.i(95804);
    if (this.aPF == -1L) {}
    for (;;)
    {
      j localj = k(paramLong, l);
      AppMethodBeat.o(95804);
      return localj;
      l = this.aPF - paramLong;
    }
  }
  
  public final boolean ej(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(95803);
    String str = "DataSpec[" + this.uri + ", " + Arrays.toString(this.aYx) + ", " + this.aYy + ", " + this.position + ", " + this.aPF + ", " + this.key + ", " + this.flags + "]";
    AppMethodBeat.o(95803);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h.j
 * JD-Core Version:    0.7.0.1
 */