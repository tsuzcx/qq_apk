package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  public final long aFL;
  public final byte[] bor;
  public final long bos;
  public final int flags;
  public final String key;
  public final long position;
  public final Uri uri;
  
  public j(Uri paramUri)
  {
    this(paramUri, 0);
  }
  
  public j(Uri paramUri, int paramInt)
  {
    this(paramUri, 0L, -1L, null, paramInt);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    this(paramUri, null, paramLong1, paramLong2, paramLong3, paramString, paramInt);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, String paramString)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, 0);
    AppMethodBeat.i(93043);
    AppMethodBeat.o(93043);
  }
  
  public j(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, paramInt);
    AppMethodBeat.i(93044);
    AppMethodBeat.o(93044);
  }
  
  public j(Uri paramUri, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    AppMethodBeat.i(93045);
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
      this.bor = paramArrayOfByte;
      this.bos = paramLong1;
      this.position = paramLong2;
      this.aFL = paramLong3;
      this.key = paramString;
      this.flags = paramInt;
      AppMethodBeat.o(93045);
      return;
      bool = false;
      break;
      bool = false;
      break label33;
    }
  }
  
  private j k(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93048);
    if ((paramLong1 == 0L) && (this.aFL == paramLong2))
    {
      AppMethodBeat.o(93048);
      return this;
    }
    j localj = new j(this.uri, this.bor, this.bos + paramLong1, this.position + paramLong1, paramLong2, this.key, this.flags);
    AppMethodBeat.o(93048);
    return localj;
  }
  
  public final j ao(long paramLong)
  {
    long l = -1L;
    AppMethodBeat.i(93047);
    if (this.aFL == -1L) {}
    for (;;)
    {
      j localj = k(paramLong, l);
      AppMethodBeat.o(93047);
      return localj;
      l = this.aFL - paramLong;
    }
  }
  
  public final boolean fp(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93046);
    String str = "DataSpec[" + this.uri + ", " + Arrays.toString(this.bor) + ", " + this.bos + ", " + this.position + ", " + this.aFL + ", " + this.key + ", " + this.flags + "]";
    AppMethodBeat.o(93046);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.j
 * JD-Core Version:    0.7.0.1
 */