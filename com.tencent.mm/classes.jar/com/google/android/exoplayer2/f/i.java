package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private long aSr;
  private d brO;
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.brO = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.timeUs;
    }
    this.aSr = paramLong1;
  }
  
  public final int am(long paramLong)
  {
    return this.brO.am(paramLong - this.aSr);
  }
  
  public final List<a> an(long paramLong)
  {
    return this.brO.an(paramLong - this.aSr);
  }
  
  public final void clear()
  {
    super.clear();
    this.brO = null;
  }
  
  public final long eR(int paramInt)
  {
    return this.brO.eR(paramInt) + this.aSr;
  }
  
  public abstract void release();
  
  public final int uB()
  {
    return this.brO.uB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */