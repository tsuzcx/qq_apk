package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b
{
  public static boolean Fv(String paramString)
  {
    AppMethodBeat.i(150445);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150445);
      return false;
    }
    try
    {
      int j = aHc();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bu.aSB(arrayOfString2[0]);
        int m = bu.aSB(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bu.aSB(arrayOfString1[0]);
        boolean bool = M(m + k * 60, bu.aSB(arrayOfString1[1]) + n * 60, j);
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
      ae.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ae.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150445);
    }
  }
  
  private static boolean M(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static boolean aHb()
  {
    AppMethodBeat.i(150444);
    String str = ((a)g.ab(a.class)).acL().getValue("C2CImgNotAutoDownloadTimeRange");
    ae.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(str)));
    boolean bool = Fv(str);
    AppMethodBeat.o(150444);
    return bool;
  }
  
  private static int aHc()
  {
    AppMethodBeat.i(150447);
    String[] arrayOfString = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
    int i = bu.aSB(arrayOfString[0]);
    int j = bu.aSB(arrayOfString[1]) + i * 60 - ((int)aHd() - 8) * 60;
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
  
  public static long aHd()
  {
    AppMethodBeat.i(150448);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    AppMethodBeat.o(150448);
    return l;
  }
  
  public static boolean an(String paramString, int paramInt)
  {
    AppMethodBeat.i(150446);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150446);
      return false;
    }
    try
    {
      int j = aHc();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = bu.aSB(arrayOfString2[0]);
        int m = bu.aSB(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = bu.aSB(arrayOfString1[0]);
        boolean bool = M(m + k * 60, bu.aSB(arrayOfString1[1]) + n * 60 + paramInt, j);
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
      ae.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      ae.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.b
 * JD-Core Version:    0.7.0.1
 */