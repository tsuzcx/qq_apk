package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class v
  extends i<u>
{
  public static final String[] dUb = { i.a(u.fCU, "PkgUpdateStats") };
  
  public v(e parame)
  {
    super(parame, u.fCU, "PkgUpdateStats", u.cqY);
  }
  
  final boolean ag(String paramString, int paramInt)
  {
    u localu = new u();
    localu.field_key = paramString;
    localu.field_version = paramInt;
    return super.a(localu, u.fCT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */