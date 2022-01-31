package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public final class m
  extends i<l>
{
  public static final String[] dUb = { i.a(l.dUa, "WxaWidgetInfo") };
  public static final String[] dUc = new String[0];
  
  public m(e parame)
  {
    super(parame, l.dUa, "WxaWidgetInfo", dUc);
  }
  
  public final l wY(String paramString)
  {
    if (bk.bl(paramString)) {}
    l locall;
    do
    {
      return null;
      locall = new l();
      locall.field_appId = paramString;
      locall.field_appIdHash = paramString.hashCode();
    } while (!b(locall, new String[] { "appIdHash" }));
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.m
 * JD-Core Version:    0.7.0.1
 */