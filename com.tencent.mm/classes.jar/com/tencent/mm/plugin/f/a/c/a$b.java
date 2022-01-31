package com.tencent.mm.plugin.f.a.c;

import java.util.HashMap;

public final class a$b
  implements Runnable
{
  private long hUf = 0L;
  private long hUg = 0L;
  
  public a$b(a parama, long paramLong1, long paramLong2)
  {
    this.hUf = paramLong1;
    this.hUg = paramLong2;
  }
  
  public final void run()
  {
    a locala = this.hWV;
    b localb1 = new b(this.hUf);
    long l = localb1.mSessionId;
    b localb2 = (b)locala.hTU.remove(Long.valueOf(l));
    if (localb2 != null) {
      localb2.disconnect();
    }
    locala.hTU.put(Long.valueOf(l), localb1);
    if (this.hWV.hWS != null) {
      this.hWV.hWS.e(l, this.hUf, this.hUg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */