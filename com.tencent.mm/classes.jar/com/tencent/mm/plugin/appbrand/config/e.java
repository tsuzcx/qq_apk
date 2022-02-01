package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<d>
{
  public static final String[] iBh;
  public final ISQLiteDatabase kLX;
  
  static
  {
    AppMethodBeat.i(146960);
    iBh = new String[] { MAutoStorage.getCreateSQLs(d.iBg, "AppBrandCommonKVData") };
    AppMethodBeat.o(146960);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.iBg, "AppBrandCommonKVData", null);
    this.kLX = paramISQLiteDatabase;
  }
  
  public final void WY(String paramString)
  {
    AppMethodBeat.i(146959);
    super.execSQL("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[] { "AppBrandCommonKVData", "key", paramString }));
    AppMethodBeat.o(146959);
  }
  
  public final boolean cN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146956);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146956);
      return false;
    }
    d locald = new d();
    locald.field_key = paramString1;
    locald.field_value = paramString2;
    if (Util.isNullOrNil(locald.field_value))
    {
      if (!super.delete(locald, new String[0]))
      {
        AppMethodBeat.o(146956);
        return true;
      }
      AppMethodBeat.o(146956);
      return false;
    }
    boolean bool = super.replace(locald);
    AppMethodBeat.o(146956);
    return bool;
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(146958);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146958);
      return false;
    }
    d locald = new d();
    locald.field_key = paramString;
    locald.field_value = get(paramString, "");
    if ((TextUtils.isEmpty(locald.field_value)) || (super.delete(locald, new String[0])))
    {
      AppMethodBeat.o(146958);
      return true;
    }
    AppMethodBeat.o(146958);
    return false;
  }
  
  public final String get(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146957);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146957);
      return paramString2;
    }
    d locald = new d();
    locald.field_key = paramString1;
    if (super.get(locald, new String[0]))
    {
      paramString1 = locald.field_value;
      AppMethodBeat.o(146957);
      return paramString1;
    }
    AppMethodBeat.o(146957);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.e
 * JD-Core Version:    0.7.0.1
 */