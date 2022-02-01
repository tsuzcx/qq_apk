package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private long aNc;
  private d bjM;
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.bjM = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.timeUs;
    }
    this.aNc = paramLong1;
  }
  
  public final int al(long paramLong)
  {
    return this.bjM.al(paramLong - this.aNc);
  }
  
  public final List<a> am(long paramLong)
  {
    return this.bjM.am(paramLong - this.aNc);
  }
  
  public final void clear()
  {
    super.clear();
    this.bjM = null;
  }
  
  public final long eX(int paramInt)
  {
    return this.bjM.eX(paramInt) + this.aNc;
  }
  
  public abstract void release();
  
  public final int ua()
  {
    return this.bjM.ua();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */