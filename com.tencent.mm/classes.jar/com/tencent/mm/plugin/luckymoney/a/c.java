package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
{
  public static String fTK;
  public static String hxt;
  public static String openId;
  public static String ufX;
  public static int ufY;
  public static int ufZ;
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    openId = paramString1;
    fTK = paramString3;
    ufX = paramString4;
    ufY = paramInt1;
    ufZ = paramInt2;
    hxt = paramString2;
  }
  
  public static void bn(int paramInt, String paramString)
  {
    AppMethodBeat.i(168790);
    if (bs.isNullOrNil(openId))
    {
      AppMethodBeat.o(168790);
      return;
    }
    h.wUl.f(16598, new Object[] { Integer.valueOf(paramInt), hxt, paramString, fTK, ufX, Integer.valueOf(0), openId, Integer.valueOf(ufY), Integer.valueOf(ufZ) });
    AppMethodBeat.o(168790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.c
 * JD-Core Version:    0.7.0.1
 */