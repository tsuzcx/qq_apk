package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.kernel.b;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
{
  private static n.a fTY = new g.1();
  
  public static void initialize()
  {
    if (!ae.cqV()) {
      return;
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().a(fTY);
  }
  
  public static void release()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().b(fTY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g
 * JD-Core Version:    0.7.0.1
 */