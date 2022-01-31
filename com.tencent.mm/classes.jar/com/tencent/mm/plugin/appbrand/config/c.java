package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends j<b>
{
  public static final String[] fkl;
  public final e gVl;
  
  static
  {
    AppMethodBeat.i(101788);
    fkl = new String[] { j.getCreateSQLs(b.fkk, "AppBrandCommonKVData") };
    AppMethodBeat.o(101788);
  }
  
  public c(e parame)
  {
    super(parame, b.fkk, "AppBrandCommonKVData", null);
    this.gVl = parame;
  }
  
  public final boolean bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101784);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(101784);
      return false;
    }
    b localb = new b();
    localb.field_key = paramString1;
    localb.field_value = paramString2;
    if (bo.isNullOrNil(localb.field_value))
    {
      if (!super.delete(localb, new String[0]))
      {
        AppMethodBeat.o(101784);
        return true;
      }
      AppMethodBeat.o(101784);
      return false;
    }
    boolean bool = super.replace(localb);
    AppMethodBeat.o(101784);
    return bool;
  }
  
  public final String get(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101785);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(101785);
      return paramString2;
    }
    b localb = new b();
    localb.field_key = paramString1;
    if (super.get(localb, new String[0]))
    {
      paramString1 = localb.field_value;
      AppMethodBeat.o(101785);
      return paramString1;
    }
    AppMethodBeat.o(101785);
    return paramString2;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(101786);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101786);
      return false;
    }
    b localb = new b();
    localb.field_key = paramString;
    localb.field_value = get(paramString, "");
    if ((TextUtils.isEmpty(localb.field_value)) || (super.delete(localb, new String[0])))
    {
      AppMethodBeat.o(101786);
      return true;
    }
    AppMethodBeat.o(101786);
    return false;
  }
  
  public final void zY(String paramString)
  {
    AppMethodBeat.i(101787);
    super.execSQL("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[] { "AppBrandCommonKVData", "key", paramString }));
    AppMethodBeat.o(101787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.c
 * JD-Core Version:    0.7.0.1
 */