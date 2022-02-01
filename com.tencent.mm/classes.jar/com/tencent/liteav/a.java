package com.tencent.liteav;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  public static void a(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(219873);
    StatusBucket localStatusBucket = TXCAudioEngine.getInstance().getStatus(1);
    TXCStatus.a(paramString, 14003, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10001)));
    TXCStatus.a(paramString, 8005, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10002)));
    TXCStatus.a(paramString, 14017, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10000)));
    TXCStatus.a(paramString, 14002, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10003)));
    TXCStatus.a(paramString, 14006, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10004)));
    TXCStatus.a(paramString, 14018, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10005)));
    TXCStatus.a(paramString, 18029, Integer.valueOf(localStatusBucket.getIntStatus("18446744073709551615", 10006)));
    if (paramArrayList == null)
    {
      AppMethodBeat.o(219873);
      return;
    }
    paramString = paramArrayList.iterator();
    if (paramString.hasNext())
    {
      paramArrayList = (String)paramString.next();
      int i = localStatusBucket.getIntStatus(paramArrayList, 10114);
      int j = localStatusBucket.getIntStatus(paramArrayList, 10115);
      TXCStatus.a(paramArrayList, 18031, Integer.valueOf(i));
      TXCStatus.a(paramArrayList, 18032, Integer.valueOf(j));
      if (j > 0)
      {
        i /= j;
        label247:
        TXCStatus.a(paramArrayList, 2001, Integer.valueOf(i));
        TXCStatus.a(paramArrayList, 2002, Integer.valueOf(j));
        TXCStatus.a(paramArrayList, 2005, Integer.valueOf(j));
        TXCStatus.a(paramArrayList, 2004, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10300)));
        TXCStatus.a(paramArrayList, 2034, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10301)));
        TXCStatus.a(paramArrayList, 2035, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10302)));
        TXCStatus.a(paramArrayList, 2014, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10303)));
        TXCStatus.a(paramArrayList, 2008, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10112)));
        TXCStatus.a(paramArrayList, 2010, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10106)));
        TXCStatus.a(paramArrayList, 2007, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10105)));
        TXCStatus.a(paramArrayList, 2011, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10107)));
        TXCStatus.a(paramArrayList, 18001, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10103)));
        TXCStatus.a(paramArrayList, 18002, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10104)));
        TXCStatus.a(paramArrayList, 18006, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10202)));
        TXCStatus.a(paramArrayList, 18007, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10203)));
        TXCStatus.a(paramArrayList, 18008, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10204)));
        TXCStatus.a(paramArrayList, 18015, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10205)));
        TXCStatus.a(paramArrayList, 18013, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10206)));
        i = localStatusBucket.getIntStatus(paramArrayList, 10203);
        j = localStatusBucket.getIntStatus(paramArrayList, 10202);
        if (j <= 0) {
          break label1374;
        }
      }
      label1374:
      for (i = i * 100 / j;; i = 0)
      {
        TXCStatus.a(paramArrayList, 18014, Integer.valueOf(i));
        TXCStatus.a(paramArrayList, 18023, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10200)));
        TXCStatus.a(paramArrayList, 18026, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10110)));
        TXCStatus.a(paramArrayList, 18027, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10111)));
        TXCStatus.a(paramArrayList, 18028, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10201)));
        TXCStatus.a(paramArrayList, 18030, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10113)));
        TXCStatus.a(paramArrayList, 18003, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10100)));
        TXCStatus.a(paramArrayList, 2019, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10100)));
        TXCStatus.a(paramArrayList, 2020, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10101)));
        TXCStatus.a(paramArrayList, 18016, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10102)));
        TXCStatus.a(paramArrayList, 18009, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10207)));
        TXCStatus.a(paramArrayList, 18010, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10208)));
        TXCStatus.a(paramArrayList, 18012, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10209)));
        TXCStatus.a(paramArrayList, 2021, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10109)));
        TXCStatus.a(paramArrayList, 2036, Long.valueOf(localStatusBucket.getLongStatus(paramArrayList, 10410)));
        TXCStatus.a(paramArrayList, 2037, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10411)));
        TXCStatus.a(paramArrayList, 2038, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10412)));
        TXCStatus.a(paramArrayList, 2039, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10413)));
        TXCStatus.a(paramArrayList, 2040, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10414)));
        TXCStatus.a(paramArrayList, 2041, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10415)));
        TXCStatus.a(paramArrayList, 2042, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10416)));
        TXCStatus.a(paramArrayList, 2043, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10417)));
        TXCStatus.a(paramArrayList, 2044, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10418)));
        TXCStatus.a(paramArrayList, 2045, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10419)));
        TXCStatus.a(paramArrayList, 2046, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10420)));
        TXCStatus.a(paramArrayList, 2047, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10421)));
        TXCStatus.a(paramArrayList, 2048, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10422)));
        TXCStatus.a(paramArrayList, 2049, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10423)));
        TXCStatus.a(paramArrayList, 2050, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10424)));
        TXCStatus.a(paramArrayList, 2051, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10425)));
        TXCStatus.a(paramArrayList, 2052, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10426)));
        TXCStatus.a(paramArrayList, 2053, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10427)));
        TXCStatus.a(paramArrayList, 2054, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10428)));
        TXCStatus.a(paramArrayList, 2055, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10429)));
        TXCStatus.a(paramArrayList, 2056, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10430)));
        TXCStatus.a(paramArrayList, 2057, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10431)));
        TXCStatus.a(paramArrayList, 2058, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10432)));
        TXCStatus.a(paramArrayList, 2059, Integer.valueOf(localStatusBucket.getIntStatus(paramArrayList, 10433)));
        break;
        i = 0;
        break label247;
      }
    }
    AppMethodBeat.o(219873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.a
 * JD-Core Version:    0.7.0.1
 */