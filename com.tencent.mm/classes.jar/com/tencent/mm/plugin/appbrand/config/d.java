package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends j<c>
{
  public static final String[] hlS;
  public final e jnc;
  
  static
  {
    AppMethodBeat.i(146960);
    hlS = new String[] { j.getCreateSQLs(c.hlR, "AppBrandCommonKVData") };
    AppMethodBeat.o(146960);
  }
  
  public d(e parame)
  {
    super(parame, c.hlR, "AppBrandCommonKVData", null);
    this.jnc = parame;
  }
  
  public final void JQ(String paramString)
  {
    AppMethodBeat.i(146959);
    super.execSQL("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[] { "AppBrandCommonKVData", "key", paramString }));
    AppMethodBeat.o(146959);
  }
  
  public final boolean cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146956);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146956);
      return false;
    }
    c localc = new c();
    localc.field_key = paramString1;
    localc.field_value = paramString2;
    if (bs.isNullOrNil(localc.field_value))
    {
      if (!super.delete(localc, new String[0]))
      {
        AppMethodBeat.o(146956);
        return true;
      }
      AppMethodBeat.o(146956);
      return false;
    }
    boolean bool = super.replace(localc);
    AppMethodBeat.o(146956);
    return bool;
  }
  
  public final String get(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146957);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146957);
      return paramString2;
    }
    c localc = new c();
    localc.field_key = paramString1;
    if (super.get(localc, new String[0]))
    {
      paramString1 = localc.field_value;
      AppMethodBeat.o(146957);
      return paramString1;
    }
    AppMethodBeat.o(146957);
    return paramString2;
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(146958);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146958);
      return false;
    }
    c localc = new c();
    localc.field_key = paramString;
    localc.field_value = get(paramString, "");
    if ((TextUtils.isEmpty(localc.field_value)) || (super.delete(localc, new String[0])))
    {
      AppMethodBeat.o(146958);
      return true;
    }
    AppMethodBeat.o(146958);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.d
 * JD-Core Version:    0.7.0.1
 */