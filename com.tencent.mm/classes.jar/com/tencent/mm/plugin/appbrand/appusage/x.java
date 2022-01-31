package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.c.akd;
import java.util.concurrent.TimeUnit;

public final class x
  extends com.tencent.mm.ah.a<akd>
{
  private static final long fJz = TimeUnit.MINUTES.toSeconds(5L);
  
  public static void adv()
  {
    if (!g.DN().dJH) {
      return;
    }
    g.r(d.class);
  }
  
  static akd adw()
  {
    return (akd)e.abf().g("GetSearchShowOutWxaApp_resp", akd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.x
 * JD-Core Version:    0.7.0.1
 */