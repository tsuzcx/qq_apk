package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private d aTL;
  private long awY;
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.aAT = paramLong1;
    this.aTL = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.aAT;
    }
    this.awY = paramLong1;
  }
  
  public final int ab(long paramLong)
  {
    return this.aTL.ab(paramLong - this.awY);
  }
  
  public final List<a> ac(long paramLong)
  {
    return this.aTL.ac(paramLong - this.awY);
  }
  
  public final void clear()
  {
    super.clear();
    this.aTL = null;
  }
  
  public final long dT(int paramInt)
  {
    return this.aTL.dT(paramInt) + this.awY;
  }
  
  public final int pH()
  {
    return this.aTL.pH();
  }
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */