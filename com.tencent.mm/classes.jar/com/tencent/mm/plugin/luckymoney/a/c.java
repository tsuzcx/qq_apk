package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static String haD;
  public static String iNV;
  public static String openId;
  public static String yOW;
  public static int yOX;
  public static int yOY;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    openId = paramString1;
    haD = paramString3;
    yOW = paramString4;
    yOX = paramInt1;
    yOY = paramInt2;
    iNV = paramString2;
  }
  
  public static void bC(int paramInt, String paramString)
  {
    AppMethodBeat.i(168790);
    if (Util.isNullOrNil(openId))
    {
      AppMethodBeat.o(168790);
      return;
    }
    h.CyF.a(16598, new Object[] { Integer.valueOf(paramInt), iNV, paramString, haD, yOW, Integer.valueOf(0), openId, Integer.valueOf(yOX), Integer.valueOf(yOY) });
    AppMethodBeat.o(168790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.c
 * JD-Core Version:    0.7.0.1
 */