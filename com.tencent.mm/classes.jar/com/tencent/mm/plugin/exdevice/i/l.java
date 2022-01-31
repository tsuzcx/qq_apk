package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.service.l.a;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import junit.framework.Assert;

public final class l
  extends l.a
{
  private final long edQ = 15000L;
  private c jAb = null;
  boolean jAc = false;
  boolean jAd = false;
  Runnable jAe = new Runnable()
  {
    public final void run()
    {
      l.a(l.this);
      if (l.b(l.this)) {
        return;
      }
      l.c(l.this).a(-1L, -1, -2, "TimeOut", null);
    }
    
    public final String toString()
    {
      return super.toString() + "|mAsyncTimeOut";
    }
  };
  
  public l(c paramc)
  {
    Assert.assertNotNull(paramc);
    this.jAb = paramc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    if (this.jAd) {}
    while (this.jAc) {
      return;
    }
    au.DS().crf().removeCallbacks(this.jAe);
    au.DS().crf().post(new l.2(this, paramLong, paramInt1, paramInt2, paramString, paramp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.l
 * JD-Core Version:    0.7.0.1
 */