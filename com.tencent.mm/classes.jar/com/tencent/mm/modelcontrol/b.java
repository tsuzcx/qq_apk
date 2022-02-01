package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b
{
  public static boolean BU(String paramString)
  {
    AppMethodBeat.i(150445);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150445);
      return false;
    }
    try
    {
      int j = aDG();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bs.aLy(arrayOfString2[0]);
        int m = bs.aLy(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bs.aLy(arrayOfString1[0]);
        boolean bool = L(m + k * 60, bs.aLy(arrayOfString1[1]) + n * 60, j);
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
      ac.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ac.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150445);
    }
  }
  
  private static boolean L(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static boolean aDF()
  {
    AppMethodBeat.i(150444);
    String str = ((a)g.ab(a.class)).ZY().getValue("C2CImgNotAutoDownloadTimeRange");
    ac.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(str)));
    boolean bool = BU(str);
    AppMethodBeat.o(150444);
    return bool;
  }
  
  private static int aDG()
  {
    AppMethodBeat.i(150447);
    String[] arrayOfString = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
    int i = bs.aLy(arrayOfString[0]);
    int j = bs.aLy(arrayOfString[1]) + i * 60 - ((int)aDH() - 8) * 60;
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
  
  public static long aDH()
  {
    AppMethodBeat.i(150448);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    AppMethodBeat.o(150448);
    return l;
  }
  
  public static boolean ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(150446);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150446);
      return false;
    }
    try
    {
      int j = aDG();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bs.aLy(arrayOfString2[0]);
        int m = bs.aLy(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bs.aLy(arrayOfString1[0]);
        boolean bool = L(m + k * 60, bs.aLy(arrayOfString1[1]) + n * 60 + paramInt, j);
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
      ac.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ac.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.b
 * JD-Core Version:    0.7.0.1
 */