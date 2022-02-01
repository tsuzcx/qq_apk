package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static String EsU;
  public static int EsV;
  public static int EsW;
  public static String jLI;
  public static String lEm;
  public static String openId;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    openId = paramString1;
    jLI = paramString3;
    EsU = paramString4;
    EsV = paramInt1;
    EsW = paramInt2;
    lEm = paramString2;
  }
  
  public static void bz(int paramInt, String paramString)
  {
    AppMethodBeat.i(168790);
    if (Util.isNullOrNil(openId))
    {
      AppMethodBeat.o(168790);
      return;
    }
    h.IzE.a(16598, new Object[] { Integer.valueOf(paramInt), lEm, paramString, jLI, EsU, Integer.valueOf(0), openId, Integer.valueOf(EsV), Integer.valueOf(EsW) });
    AppMethodBeat.o(168790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.c
 * JD-Core Version:    0.7.0.1
 */