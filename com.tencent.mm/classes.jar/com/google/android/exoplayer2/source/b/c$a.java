package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a.c;
import java.util.Arrays;

final class c$a
  extends c
{
  public final String aJD;
  byte[] result;
  
  public c$a(f paramf, i parami, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
  {
    super(paramf, parami, paramFormat, paramInt, paramObject, paramArrayOfByte);
    this.aJD = paramString;
  }
  
  protected final void e(byte[] paramArrayOfByte, int paramInt)
  {
    this.result = Arrays.copyOf(paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c.a
 * JD-Core Version:    0.7.0.1
 */