package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j
{
  public final long absoluteStreamPosition;
  public final byte[] bEK;
  public final int flags;
  public final String key;
  public final long length;
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
      this.bEK = paramArrayOfByte;
      this.absoluteStreamPosition = paramLong1;
      this.position = paramLong2;
      this.length = paramLong3;
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
  
  private j j(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93048);
    if ((paramLong1 == 0L) && (this.length == paramLong2))
    {
      AppMethodBeat.o(93048);
      return this;
    }
    j localj = new j(this.uri, this.bEK, this.absoluteStreamPosition + paramLong1, this.position + paramLong1, paramLong2, this.key, this.flags);
    AppMethodBeat.o(93048);
    return localj;
  }
  
  public final j al(long paramLong)
  {
    long l = -1L;
    AppMethodBeat.i(93047);
    if (this.length == -1L) {}
    for (;;)
    {
      j localj = j(paramLong, l);
      AppMethodBeat.o(93047);
      return localj;
      l = this.length - paramLong;
    }
  }
  
  public final boolean isFlagSet(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93046);
    String str = "DataSpec[" + this.uri + ", " + Arrays.toString(this.bEK) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    AppMethodBeat.o(93046);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.j
 * JD-Core Version:    0.7.0.1
 */