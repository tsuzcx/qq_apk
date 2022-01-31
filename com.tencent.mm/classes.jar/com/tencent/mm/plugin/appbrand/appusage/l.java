package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.d;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class l
{
  private static volatile l fIs;
  public final Set<l.b> fIt = new HashSet();
  public volatile ank fIu = null;
  public final Object mLock = new Object();
  
  public static l acW()
  {
    if (fIs == null) {}
    try
    {
      if (fIs == null) {
        fIs = new l();
      }
      return fIs;
    }
    finally {}
  }
  
  public static boolean enabled()
  {
    if (g.DK())
    {
      Object localObject = com.tencent.mm.model.c.c.IX().fJ("100328");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        localObject = l.a.kx(bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get("isOpenGameEntry"), 0));
        if ((localObject != null) && (localObject == l.a.fIx)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final void refresh()
  {
    this.fIu = null;
    b.a locala = new b.a();
    locala.ecG = 1841;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxagame";
    locala.ecH = new anj();
    locala.ecI = new ank();
    w.a(locala.Kt(), new l.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l
 * JD-Core Version:    0.7.0.1
 */