package com.tencent.mm.plugin.appbrand.t;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends i<a.a>
{
  public static final String[] dUb = { i.a(a.a.fCU, "AppBrandCommonKVBinaryData") };
  
  public a(e parame)
  {
    super(parame, a.a.fCU, "AppBrandCommonKVBinaryData", null);
  }
  
  public final void clear(String paramString)
  {
    a.a locala = new a.a();
    locala.field_key = paramString;
    locala.field_value = new byte[0];
    super.a(locala);
  }
  
  public final <T extends com.tencent.mm.bv.a> T g(String paramString, Class<T> paramClass)
  {
    paramString = wh(paramString);
    if (bk.bE(paramString)) {
      return null;
    }
    try
    {
      com.tencent.mm.bv.a locala = (com.tencent.mm.bv.a)paramClass.newInstance();
      locala.aH(paramString);
      return locala;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", new Object[] { paramClass.getSimpleName(), paramString });
    }
    return null;
  }
  
  public final void l(String paramString, byte[] paramArrayOfByte)
  {
    if (bk.bl(paramString)) {
      return;
    }
    a.a locala = new a.a();
    locala.field_key = paramString;
    locala.field_value = paramArrayOfByte;
    super.a(locala);
  }
  
  public final byte[] wh(String paramString)
  {
    if (bk.bl(paramString)) {}
    a.a locala;
    do
    {
      return null;
      locala = new a.a();
      locala.field_key = paramString;
    } while (!super.b(locala, new String[0]));
    return locala.field_value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a
 * JD-Core Version:    0.7.0.1
 */