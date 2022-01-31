package com.tencent.mm.bc;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;

public final class b
{
  private static final b exH = new b();
  public long exG;
  
  public b()
  {
    if (g.DK())
    {
      this.exG = q.Go();
      return;
    }
    a.udP.b(new b.1(this));
  }
  
  public static b PP()
  {
    return exH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bc.b
 * JD-Core Version:    0.7.0.1
 */