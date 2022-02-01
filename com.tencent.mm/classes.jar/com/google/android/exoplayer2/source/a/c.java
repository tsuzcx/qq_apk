package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.x;
import java.util.Arrays;

public abstract class c
  extends a
{
  private volatile boolean cZB;
  public byte[] data;
  private int limit;
  
  public c(g paramg, j paramj, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte)
  {
    super(paramg, paramj, 3, paramFormat, paramInt, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.data = paramArrayOfByte;
  }
  
  public final void Tb()
  {
    this.cZB = true;
  }
  
  public final boolean Tc()
  {
    return this.cZB;
  }
  
  public final void Td()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.cLk.a(this.daF);
        this.limit = 0;
        if ((i == -1) || (this.cZB)) {
          break;
        }
        if (this.data == null)
        {
          this.data = new byte[16384];
          int j = this.cLk.read(this.data, this.limit, 16384);
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
        x.a(this.cLk);
      }
      this.data = Arrays.copyOf(this.data, this.data.length + 16384);
    }
    if (!this.cZB) {
      f(this.data, this.limit);
    }
    x.a(this.cLk);
  }
  
  public final long To()
  {
    return this.limit;
  }
  
  protected abstract void f(byte[] paramArrayOfByte, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.c
 * JD-Core Version:    0.7.0.1
 */