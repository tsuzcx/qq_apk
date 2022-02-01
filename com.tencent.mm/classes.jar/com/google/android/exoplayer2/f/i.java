package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private d bAi;
  private long bdF;
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.bAi = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.timeUs;
    }
    this.bdF = paramLong1;
  }
  
  public final int ai(long paramLong)
  {
    return this.bAi.ai(paramLong - this.bdF);
  }
  
  public final List<a> aj(long paramLong)
  {
    return this.bAi.aj(paramLong - this.bdF);
  }
  
  public final void clear()
  {
    super.clear();
    this.bAi = null;
  }
  
  public final long eI(int paramInt)
  {
    return this.bAi.eI(paramInt) + this.bdF;
  }
  
  public abstract void release();
  
  public final int vV()
  {
    return this.bAi.vV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */