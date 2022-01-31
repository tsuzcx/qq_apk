package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private d aMr;
  private long auG;
  
  public final int S(long paramLong)
  {
    return this.aMr.S(paramLong - this.auG);
  }
  
  public final List<a> T(long paramLong)
  {
    return this.aMr.T(paramLong - this.auG);
  }
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.ayE = paramLong1;
    this.aMr = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.ayE;
    }
    this.auG = paramLong1;
  }
  
  public final void clear()
  {
    super.clear();
    this.aMr = null;
  }
  
  public final long dn(int paramInt)
  {
    return this.aMr.dn(paramInt) + this.auG;
  }
  
  public final int nk()
  {
    return this.aMr.nk();
  }
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */