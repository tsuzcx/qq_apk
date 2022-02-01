package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public static String gno;
  public static String hPO;
  public static String openId;
  public static String viH;
  public static int viI;
  public static int viJ;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    openId = paramString1;
    gno = paramString3;
    viH = paramString4;
    viI = paramInt1;
    viJ = paramInt2;
    hPO = paramString2;
  }
  
  public static void br(int paramInt, String paramString)
  {
    AppMethodBeat.i(168790);
    if (bt.isNullOrNil(openId))
    {
      AppMethodBeat.o(168790);
      return;
    }
    g.yhR.f(16598, new Object[] { Integer.valueOf(paramInt), hPO, paramString, gno, viH, Integer.valueOf(0), openId, Integer.valueOf(viI), Integer.valueOf(viJ) });
    AppMethodBeat.o(168790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.c
 * JD-Core Version:    0.7.0.1
 */