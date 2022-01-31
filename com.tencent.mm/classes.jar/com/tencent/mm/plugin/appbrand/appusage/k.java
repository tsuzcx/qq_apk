package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public final class k
  extends i<b>
{
  public static final String[] dUb = { i.a(b.dUa, "AppBrandAppLaunchUsernameDuplicateRecord") };
  public final e fCV;
  
  public k(e parame)
  {
    super(parame, b.dUa, "AppBrandAppLaunchUsernameDuplicateRecord", b.cqY);
    this.fCV = parame;
  }
  
  public final boolean v(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    b localb = new b();
    localb.field_username = paramString;
    boolean bool = b(localb, new String[0]);
    localb.field_updateTime = paramLong;
    if (bool) {
      return c(localb, new String[0]);
    }
    return b(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */