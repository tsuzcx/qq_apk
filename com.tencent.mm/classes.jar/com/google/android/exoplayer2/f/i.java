package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private d bAk;
  private long bdC;
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.bAk = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.timeUs;
    }
    this.bdC = paramLong1;
  }
  
  public final int ai(long paramLong)
  {
    return this.bAk.ai(paramLong - this.bdC);
  }
  
  public final List<a> aj(long paramLong)
  {
    return this.bAk.aj(paramLong - this.bdC);
  }
  
  public final void clear()
  {
    super.clear();
    this.bAk = null;
  }
  
  public final long eH(int paramInt)
  {
    return this.bAk.eH(paramInt) + this.bdC;
  }
  
  public abstract void release();
  
  public final int wa()
  {
    return this.bAk.wa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */