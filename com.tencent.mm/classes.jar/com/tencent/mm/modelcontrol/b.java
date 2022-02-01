package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b
{
  private static boolean K(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static boolean ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(150446);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150446);
      return false;
    }
    try
    {
      int j = awO();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bt.aGh(arrayOfString2[0]);
        int m = bt.aGh(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bt.aGh(arrayOfString1[0]);
        boolean bool = K(m + k * 60, bt.aGh(arrayOfString1[1]) + n * 60 + paramInt, j);
        if (bool)
        {
          AppMethodBeat.o(150446);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ad.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150446);
    }
  }
  
  public static boolean awN()
  {
    AppMethodBeat.i(150444);
    String str = ((a)g.ab(a.class)).Zd().getValue("C2CImgNotAutoDownloadTimeRange");
    ad.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(str)));
    boolean bool = xO(str);
    AppMethodBeat.o(150444);
    return bool;
  }
  
  private static int awO()
  {
    AppMethodBeat.i(150447);
    String[] arrayOfString = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
    int i = bt.aGh(arrayOfString[0]);
    int j = bt.aGh(arrayOfString[1]) + i * 60 - ((int)awP() - 8) * 60;
    if (j < 0) {
      i = j + 1440;
    }
    for (;;)
    {
      AppMethodBeat.o(150447);
      return i;
      i = j;
      if (j >= 1440) {
        i = j - 1440;
      }
    }
  }
  
  public static long awP()
  {
    AppMethodBeat.i(150448);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    AppMethodBeat.o(150448);
    return l;
  }
  
  public static boolean xO(String paramString)
  {
    AppMethodBeat.i(150445);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150445);
      return false;
    }
    try
    {
      int j = awO();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bt.aGh(arrayOfString2[0]);
        int m = bt.aGh(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bt.aGh(arrayOfString1[0]);
        boolean bool = K(m + k * 60, bt.aGh(arrayOfString1[1]) + n * 60, j);
        if (bool)
        {
          AppMethodBeat.o(150445);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ad.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.b
 * JD-Core Version:    0.7.0.1
 */