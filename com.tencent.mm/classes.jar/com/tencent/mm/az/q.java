package com.tencent.mm.az;

import com.tencent.mm.h.a.md;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class q
  extends com.tencent.mm.sdk.b.c<md>
{
  private static long dil = 86400000L;
  
  public q()
  {
    this.udX = md.class.getName().hashCode();
  }
  
  private static boolean PI()
  {
    y.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + we());
    if (we()) {
      c.PE().update();
    }
    return false;
  }
  
  private static boolean we()
  {
    return bk.cn(Long.valueOf(bk.c((Long)g.DP().Dz().get(81938, null))).longValue()) * 1000L > dil;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.q
 * JD-Core Version:    0.7.0.1
 */