package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public final class c
  extends i<b>
{
  public static final String[] dUb = { i.a(b.dUa, "AppBrandCommonKVData") };
  public final e fCV;
  
  public c(e parame)
  {
    super(parame, b.dUa, "AppBrandCommonKVData", null);
    this.fCV = parame;
  }
  
  public final boolean bi(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {}
    b localb;
    do
    {
      return false;
      localb = new b();
      localb.field_key = paramString1;
      localb.field_value = paramString2;
      if (!bk.bl(localb.field_value)) {
        break;
      }
    } while (super.a(localb, new String[0]));
    return true;
    return super.a(localb);
  }
  
  public final String get(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {}
    b localb;
    do
    {
      return paramString2;
      localb = new b();
      localb.field_key = paramString1;
    } while (!super.b(localb, new String[0]));
    return localb.field_value;
  }
  
  public final boolean jJ(String paramString)
  {
    if (bk.bl(paramString)) {}
    b localb;
    do
    {
      return false;
      localb = new b();
      localb.field_key = paramString;
      localb.field_value = get(paramString, "");
    } while ((!TextUtils.isEmpty(localb.field_value)) && (!super.a(localb, new String[0])));
    return true;
  }
  
  public final void sh(String paramString)
  {
    super.gk("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[] { "AppBrandCommonKVData", "key", paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.c
 * JD-Core Version:    0.7.0.1
 */