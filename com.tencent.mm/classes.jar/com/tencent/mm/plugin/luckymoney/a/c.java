package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static String KlA;
  public static int KlB;
  public static int KlC;
  public static int KlD;
  public static String mkQ;
  public static String openId;
  public static String ovT;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    openId = paramString1;
    mkQ = paramString3;
    KlA = paramString4;
    KlB = paramInt1;
    KlC = paramInt2;
    ovT = paramString2;
  }
  
  public static void cg(int paramInt, String paramString)
  {
    AppMethodBeat.i(168790);
    if (Util.isNullOrNil(openId))
    {
      AppMethodBeat.o(168790);
      return;
    }
    h.OAn.b(16598, new Object[] { Integer.valueOf(paramInt), ovT, paramString, mkQ, KlA, Integer.valueOf(0), openId, Integer.valueOf(KlB), Integer.valueOf(KlC), Integer.valueOf(KlD) });
    AppMethodBeat.o(168790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.c
 * JD-Core Version:    0.7.0.1
 */