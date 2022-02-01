package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public static String fPP;
  public static String gWU;
  public static String openId;
  public static String sXK;
  public static int sXL;
  public static int sXM;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    openId = paramString1;
    fPP = paramString3;
    sXK = paramString4;
    sXL = paramInt1;
    sXM = paramInt2;
    gWU = paramString2;
  }
  
  public static void bi(int paramInt, String paramString)
  {
    AppMethodBeat.i(168790);
    if (bt.isNullOrNil(openId))
    {
      AppMethodBeat.o(168790);
      return;
    }
    h.vKh.f(16598, new Object[] { Integer.valueOf(paramInt), gWU, paramString, fPP, sXK, Integer.valueOf(0), openId, Integer.valueOf(sXL), Integer.valueOf(sXM) });
    AppMethodBeat.o(168790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.c
 * JD-Core Version:    0.7.0.1
 */