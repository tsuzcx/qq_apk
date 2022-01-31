package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class l
{
  public static boolean abF()
  {
    if (!g.DK()) {
      return false;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100310");
    return (localc.isValid()) && (bk.getInt((String)localc.ctr().get("shouldUsePatch"), 0) == 1);
  }
  
  public static boolean abG()
  {
    if (!g.DK()) {
      return false;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100342");
    return (localc.isValid()) && (bk.getInt((String)localc.ctr().get("shouldUsePatch"), 0) == 1);
  }
  
  public static boolean abH()
  {
    if (!g.DK()) {
      return false;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100320");
    return (localc.isValid()) && (bk.getInt((String)localc.ctr().get("isOpenModule"), 0) > 0);
  }
  
  public static boolean abI()
  {
    if (!g.DK()) {
      return false;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100399");
    return (localc.isValid()) && (bk.getInt((String)localc.ctr().get("isUseNewPackageLogic"), 0) > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.l
 * JD-Core Version:    0.7.0.1
 */