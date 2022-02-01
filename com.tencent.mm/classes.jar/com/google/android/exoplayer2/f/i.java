package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private long cGY;
  private d ddG;
  
  public final int TD()
  {
    return this.ddG.TD();
  }
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.ddG = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.timeUs;
    }
    this.cGY = paramLong1;
  }
  
  public final List<a> cA(long paramLong)
  {
    return this.ddG.cA(paramLong - this.cGY);
  }
  
  public final void clear()
  {
    super.clear();
    this.ddG = null;
  }
  
  public final int cz(long paramLong)
  {
    return this.ddG.cz(paramLong - this.cGY);
  }
  
  public final long in(int paramInt)
  {
    return this.ddG.in(paramInt) + this.cGY;
  }
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */