package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
{
  public static String gpK;
  public static String hSG;
  public static String openId;
  public static String vuM;
  public static int vuN;
  public static int vuO;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    openId = paramString1;
    gpK = paramString3;
    vuM = paramString4;
    vuN = paramInt1;
    vuO = paramInt2;
    hSG = paramString2;
  }
  
  public static void bq(int paramInt, String paramString)
  {
    AppMethodBeat.i(168790);
    if (bu.isNullOrNil(openId))
    {
      AppMethodBeat.o(168790);
      return;
    }
    g.yxI.f(16598, new Object[] { Integer.valueOf(paramInt), hSG, paramString, gpK, vuM, Integer.valueOf(0), openId, Integer.valueOf(vuN), Integer.valueOf(vuO) });
    AppMethodBeat.o(168790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.c
 * JD-Core Version:    0.7.0.1
 */