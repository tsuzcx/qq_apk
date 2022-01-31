package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ub;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class af
  implements f
{
  c dii = new af.1(this);
  
  public af()
  {
    a.udP.c(this.dii);
  }
  
  private static void as(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ub localub = new ub();
    localub.cez.bHz = 8;
    localub.cez.bKQ = paramBoolean;
    localub.cez.bwK = paramString;
    a.udP.m(localub);
  }
  
  private static void at(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ub localub = new ub();
    localub.cez.bHz = 5;
    localub.cez.bKQ = paramBoolean;
    localub.cez.bwK = paramString;
    a.udP.m(localub);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof r))
    {
      au.Dk().b(541, this);
      paramString = (r)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        as(paramString.jvX, true);
      }
    }
    while (!(paramm instanceof w))
    {
      return;
      as(paramString.jvX, false);
      return;
    }
    au.Dk().b(538, this);
    paramString = (w)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      at(paramString.jvZ, true);
      return;
    }
    at(paramString.jvZ, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */