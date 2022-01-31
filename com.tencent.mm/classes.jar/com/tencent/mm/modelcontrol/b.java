package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b
{
  private static boolean H(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      if ((paramInt3 >= paramInt2) || (paramInt3 < paramInt1)) {}
    }
    while (((paramInt3 <= 1440) && (paramInt3 >= paramInt1)) || ((paramInt3 < paramInt2) && (paramInt3 >= 0)))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean W(String paramString, int paramInt)
  {
    AppMethodBeat.i(78088);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78088);
      return false;
    }
    try
    {
      int j = afR();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bo.apV(arrayOfString2[0]);
        int m = bo.apV(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bo.apV(arrayOfString1[0]);
        boolean bool = H(m + k * 60, bo.apV(arrayOfString1[1]) + n * 60 + paramInt, j);
        if (bool)
        {
          AppMethodBeat.o(78088);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ab.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(78088);
    }
  }
  
  public static boolean afQ()
  {
    AppMethodBeat.i(78086);
    String str = ((a)g.E(a.class)).Nq().getValue("C2CImgNotAutoDownloadTimeRange");
    ab.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(str)));
    boolean bool = sM(str);
    AppMethodBeat.o(78086);
    return bool;
  }
  
  private static int afR()
  {
    AppMethodBeat.i(78089);
    String[] arrayOfString = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
    int i = bo.apV(arrayOfString[0]);
    int j = bo.apV(arrayOfString[1]) + i * 60 - ((int)afS() - 8) * 60;
    if (j < 0) {
      i = j + 1440;
    }
    for (;;)
    {
      AppMethodBeat.o(78089);
      return i;
      i = j;
      if (j >= 1440) {
        i = j - 1440;
      }
    }
  }
  
  public static long afS()
  {
    AppMethodBeat.i(78090);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    AppMethodBeat.o(78090);
    return l;
  }
  
  public static boolean sM(String paramString)
  {
    AppMethodBeat.i(78087);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78087);
      return false;
    }
    try
    {
      int j = afR();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bo.apV(arrayOfString2[0]);
        int m = bo.apV(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bo.apV(arrayOfString1[0]);
        boolean bool = H(m + k * 60, bo.apV(arrayOfString1[1]) + n * 60, j);
        if (bool)
        {
          AppMethodBeat.o(78087);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ab.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(78087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.b
 * JD-Core Version:    0.7.0.1
 */