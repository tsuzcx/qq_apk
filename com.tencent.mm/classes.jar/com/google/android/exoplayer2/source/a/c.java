package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public abstract class c
  extends a
{
  private volatile boolean aJg;
  public byte[] data;
  private int limit;
  
  public c(f paramf, i parami, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte)
  {
    super(paramf, parami, 3, paramFormat, paramInt, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.data = paramArrayOfByte;
  }
  
  public abstract void e(byte[] paramArrayOfByte, int paramInt);
  
  public final long mQ()
  {
    return this.limit;
  }
  
  public final void mR()
  {
    this.aJg = true;
  }
  
  public final boolean mS()
  {
    return this.aJg;
  }
  
  public final void mT()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.ayZ.a(this.aJa);
        this.limit = 0;
        if ((i == -1) || (this.aJg)) {
          break;
        }
        if (this.data == null)
        {
          this.data = new byte[16384];
          int j = this.ayZ.read(this.data, this.limit, 16384);
          i = j;
          if (j == -1) {
            continue;
          }
          this.limit += j;
          i = j;
          continue;
        }
        if (this.data.length >= this.limit + 16384) {
          continue;
        }
      }
      finally
      {
        t.a(this.ayZ);
      }
      this.data = Arrays.copyOf(this.data, this.data.length + 16384);
    }
    if (!this.aJg) {
      e(this.data, this.limit);
    }
    t.a(this.ayZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.c
 * JD-Core Version:    0.7.0.1
 */