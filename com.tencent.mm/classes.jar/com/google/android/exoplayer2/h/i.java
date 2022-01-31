package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

public final class i
{
  public final byte[] aQU;
  public final long aQV;
  public final long aQW;
  public final int flags;
  public final String key;
  public final long position;
  public final Uri uri;
  
  public i(Uri paramUri)
  {
    this(paramUri, (byte)0);
  }
  
  public i(Uri paramUri, byte paramByte)
  {
    this(paramUri, 0L, 0L, -1L, 1);
  }
  
  public i(Uri paramUri, long paramLong1, long paramLong2)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, 0);
  }
  
  private i(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    this(paramUri, null, paramLong1, paramLong2, paramLong3, null, paramInt);
  }
  
  private i(Uri paramUri, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    if (paramLong1 >= 0L)
    {
      bool = true;
      a.aB(bool);
      if (paramLong2 < 0L) {
        break label103;
      }
      bool = true;
      label28:
      a.aB(bool);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L)) {
        break label109;
      }
    }
    label103:
    label109:
    for (boolean bool = true;; bool = false)
    {
      a.aB(bool);
      this.uri = paramUri;
      this.aQU = paramArrayOfByte;
      this.aQV = paramLong1;
      this.position = paramLong2;
      this.aQW = paramLong3;
      this.key = paramString;
      this.flags = paramInt;
      return;
      bool = false;
      break;
      bool = false;
      break label28;
    }
  }
  
  public final i U(long paramLong)
  {
    long l = -1L;
    if (this.aQW == -1L) {}
    while ((paramLong == 0L) && (this.aQW == l))
    {
      return this;
      l = this.aQW - paramLong;
    }
    return new i(this.uri, this.aQU, this.aQV + paramLong, this.position + paramLong, l, this.key, this.flags);
  }
  
  public final boolean nR()
  {
    return (this.flags & 0x1) == 1;
  }
  
  public final String toString()
  {
    return "DataSpec[" + this.uri + ", " + Arrays.toString(this.aQU) + ", " + this.aQV + ", " + this.position + ", " + this.aQW + ", " + this.key + ", " + this.flags + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.i
 * JD-Core Version:    0.7.0.1
 */