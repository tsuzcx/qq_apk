package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b
{
  private static boolean N(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static boolean Of(String paramString)
  {
    AppMethodBeat.i(150445);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150445);
      return false;
    }
    try
    {
      int j = baT();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = Util.safeParseInt(arrayOfString2[0]);
        int m = Util.safeParseInt(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = Util.safeParseInt(arrayOfString1[0]);
        boolean bool = N(m + k * 60, Util.safeParseInt(arrayOfString1[1]) + n * 60, j);
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
      Log.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      Log.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150445);
    }
  }
  
  public static boolean ar(String paramString, int paramInt)
  {
    AppMethodBeat.i(150446);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150446);
      return false;
    }
    try
    {
      int j = baT();
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString1 = paramString[i].split("-");
        String[] arrayOfString2 = arrayOfString1[0].split(":");
        int k = Util.safeParseInt(arrayOfString2[0]);
        int m = Util.safeParseInt(arrayOfString2[1]);
        arrayOfString1 = arrayOfString1[1].split(":");
        int n = Util.safeParseInt(arrayOfString1[0]);
        boolean bool = N(m + k * 60, Util.safeParseInt(arrayOfString1[1]) + n * 60 + paramInt, j);
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
      Log.printErrStackTrace("MicroMsg.BusyTimeControlLogic", paramString, "", new Object[0]);
      Log.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + paramString.toString());
      AppMethodBeat.o(150446);
    }
  }
  
  public static boolean baS()
  {
    AppMethodBeat.i(150444);
    String str = ((a)g.af(a.class)).aqJ().getValue("C2CImgNotAutoDownloadTimeRange");
    Log.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: ".concat(String.valueOf(str)));
    boolean bool = Of(str);
    AppMethodBeat.o(150444);
    return bool;
  }
  
  private static int baT()
  {
    AppMethodBeat.i(150447);
    String[] arrayOfString = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
    int i = Util.safeParseInt(arrayOfString[0]);
    int j = Util.safeParseInt(arrayOfString[1]) + i * 60 - ((int)baU() - 8) * 60;
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
  
  public static long baU()
  {
    AppMethodBeat.i(150448);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    AppMethodBeat.o(150448);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.b
 * JD-Core Version:    0.7.0.1
 */