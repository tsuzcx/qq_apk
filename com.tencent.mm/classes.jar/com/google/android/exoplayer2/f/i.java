package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i
  extends f
  implements d
{
  private long aTk;
  private d bpN;
  
  public final void a(long paramLong1, d paramd, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.bpN = paramd;
    paramLong1 = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      paramLong1 = this.timeUs;
    }
    this.aTk = paramLong1;
  }
  
  public final int ai(long paramLong)
  {
    return this.bpN.ai(paramLong - this.aTk);
  }
  
  public final List<a> aj(long paramLong)
  {
    return this.bpN.aj(paramLong - this.aTk);
  }
  
  public final void clear()
  {
    super.clear();
    this.bpN = null;
  }
  
  public final long eE(int paramInt)
  {
    return this.bpN.eE(paramInt) + this.aTk;
  }
  
  public abstract void release();
  
  public final int uw()
  {
    return this.bpN.uw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.i
 * JD-Core Version:    0.7.0.1
 */