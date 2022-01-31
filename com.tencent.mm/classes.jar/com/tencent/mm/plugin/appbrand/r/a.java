package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends j<a.a>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(132776);
    fkl = new String[] { j.getCreateSQLs(a.a.gUb, "AppBrandCommonKVBinaryData") };
    AppMethodBeat.o(132776);
  }
  
  public a(e parame)
  {
    super(parame, a.a.gUb, "AppBrandCommonKVBinaryData", null);
  }
  
  public final void clear(String paramString)
  {
    AppMethodBeat.i(132772);
    a.a locala = new a.a();
    locala.field_key = paramString;
    locala.field_value = new byte[0];
    super.replace(locala);
    AppMethodBeat.o(132772);
  }
  
  public final <T extends com.tencent.mm.bv.a> T f(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(132775);
    paramString = get(paramString);
    if (bo.ce(paramString))
    {
      AppMethodBeat.o(132775);
      return null;
    }
    try
    {
      com.tencent.mm.bv.a locala = (com.tencent.mm.bv.a)paramClass.newInstance();
      locala.parseFrom(paramString);
      AppMethodBeat.o(132775);
      return locala;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", new Object[] { paramClass.getSimpleName(), paramString });
      AppMethodBeat.o(132775);
    }
    return null;
  }
  
  public final byte[] get(String paramString)
  {
    AppMethodBeat.i(132774);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132774);
      return null;
    }
    a.a locala = new a.a();
    locala.field_key = paramString;
    if (super.get(locala, new String[0]))
    {
      paramString = locala.field_value;
      AppMethodBeat.o(132774);
      return paramString;
    }
    AppMethodBeat.o(132774);
    return null;
  }
  
  public final void s(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132773);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132773);
      return;
    }
    a.a locala = new a.a();
    locala.field_key = paramString;
    locala.field_value = paramArrayOfByte;
    super.replace(locala);
    AppMethodBeat.o(132773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a
 * JD-Core Version:    0.7.0.1
 */