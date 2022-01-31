package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class e
{
  d lLB;
  
  public e()
  {
    init();
  }
  
  private void init()
  {
    this.lLB = new d();
    g.DQ();
    String str = (String)g.DP().Dz().get(356355, null);
    if (bk.bl(str))
    {
      this.lLB.lLa = 2000.0D;
      this.lLB.lKX = 100;
      this.lLB.lLb = 200.0D;
      this.lLB.lKZ = 0.01D;
      this.lLB.lKY = 200.0D;
    }
    for (;;)
    {
      y.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.lLB.lLa + " maxTotalNum:" + this.lLB.lKX + " perGroupMaxValue:" + this.lLB.lLb + " perMinValue:" + this.lLB.lKZ + " perPersonMaxValue:" + this.lLB.lKY);
      return;
      try
      {
        this.lLB.aH(str.getBytes("ISO-8859-1"));
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
        this.lLB.lLa = 2000.0D;
        this.lLB.lKX = 100;
        this.lLB.lLb = 200.0D;
        this.lLB.lKZ = 0.01D;
        this.lLB.lKY = 200.0D;
      }
    }
  }
  
  public final d bfG()
  {
    if (this.lLB == null) {
      init();
    }
    return this.lLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.e
 * JD-Core Version:    0.7.0.1
 */