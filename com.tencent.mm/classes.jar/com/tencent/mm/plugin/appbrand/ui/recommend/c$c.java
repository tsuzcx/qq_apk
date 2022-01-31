package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class c$c
  implements b.a
{
  private boolean hkG = false;
  private int hkH = 0;
  private int[] hkI = { -1, -1 };
  private bjt[] hkJ = new bjt[2];
  
  c$c(c paramc) {}
  
  public final void a(int paramInt, bjt parambjt)
  {
    y.i("MicroMsg.AppBrandRecommendUILogic", "collectExposeData pos:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.hkH > 0) && ((paramInt > this.hkH + 1) || (paramInt < this.hkH - 1)))
    {
      this.hkI[1] = this.hkI[0];
      this.hkI[0] = paramInt;
      this.hkJ[1] = this.hkJ[0];
      this.hkJ[0] = parambjt;
      if ((this.hkI[1] == -1) || ((this.hkH - this.hkI[1] > 0) && (this.hkI[1] - this.hkI[0] < 0)) || ((this.hkH - this.hkI[1] < 0) && (this.hkI[1] - this.hkI[0] > 0)))
      {
        y.e("MicroMsg.AppBrandRecommendUILogic", "collectExposeData ignore pos:%d", new Object[] { Integer.valueOf(paramInt) });
        this.hkG = true;
      }
    }
    for (;;)
    {
      return;
      this.hkG = false;
      if (this.hkJ[1] != null)
      {
        if (!this.hkA.hkz.containsKey(this.hkJ[1].username)) {
          break label305;
        }
        int i = ((Integer)this.hkA.hkz.get(this.hkJ[1].username)).intValue();
        this.hkA.hkz.put(this.hkJ[1].username, Integer.valueOf(i + 1));
      }
      while ((this.hkG == true) && (paramInt == this.hkH))
      {
        this.hkG = false;
        y.e("MicroMsg.AppBrandRecommendUILogic", "collectExposeData ignore pos:%d", new Object[] { Integer.valueOf(paramInt) });
        return;
        label305:
        this.hkA.hkz.put(this.hkJ[1].username, Integer.valueOf(1));
      }
      if (this.hkG)
      {
        y.e("MicroMsg.AppBrandRecommendUILogic", "collectExposeData ignore pos:%d", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      this.hkG = false;
      Object localObject = this.hkI;
      this.hkI[1] = -1;
      localObject[0] = -1;
      localObject = this.hkJ;
      this.hkJ[1] = null;
      localObject[0] = null;
      this.hkH = paramInt;
      if (this.hkA.hkz.containsKey(parambjt.username))
      {
        paramInt = ((Integer)this.hkA.hkz.get(parambjt.username)).intValue();
        this.hkA.hkz.put(parambjt.username, Integer.valueOf(paramInt + 1));
      }
      while (this.hkA.hkx == 0L)
      {
        this.hkA.hkx = bk.UX();
        return;
        this.hkA.hkz.put(parambjt.username, Integer.valueOf(1));
      }
    }
  }
  
  public final void aqg()
  {
    this.hkA.aql();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.c
 * JD-Core Version:    0.7.0.1
 */