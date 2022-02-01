package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import java.util.Arrays;

public abstract class j
  extends c
{
  private volatile boolean bll;
  public byte[] data;
  private int limit;
  
  public j(g paramg, com.google.android.exoplayer2.h.j paramj, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte)
  {
    super(paramg, paramj, 3, paramFormat, paramInt, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.data = paramArrayOfByte;
  }
  
  protected abstract void f(byte[] paramArrayOfByte, int paramInt);
  
  public final void tN()
  {
    this.bll = true;
  }
  
  public final boolean tO()
  {
    return this.bll;
  }
  
  public final void tP()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.aWG.a(this.bml);
        this.limit = 0;
        if ((i == -1) || (this.bll)) {
          break;
        }
        if (this.data == null)
        {
          this.data = new byte[16384];
          int j = this.aWG.read(this.data, this.limit, 16384);
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
        x.a(this.aWG);
      }
      this.data = Arrays.copyOf(this.data, this.data.length + 16384);
    }
    if (!this.bll) {
      f(this.data, this.limit);
    }
    x.a(this.aWG);
  }
  
  public final long ub()
  {
    return this.limit;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.j
 * JD-Core Version:    0.7.0.1
 */