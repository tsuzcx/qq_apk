package com.b.a.a;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

final class v
{
  static String a(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(55572);
    if ((paramString1 == null) || (!paramString1.startsWith("|")))
    {
      AppMethodBeat.o(55572);
      return null;
    }
    paramString1 = "&OD[]=ST," + String.valueOf(paramLong) + ',' + paramString2 + paramString1;
    AppMethodBeat.o(55572);
    return paramString1;
  }
  
  static String a(List<ScanResult> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(55568);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator;
    if (paramList != null) {
      localIterator = paramList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        paramList = localStringBuilder.toString();
        AppMethodBeat.o(55568);
        return paramList;
      }
      paramList = (ScanResult)localIterator.next();
      if ((paramList.capabilities != null) && (!paramList.capabilities.contains("IBSS"))) {
        try
        {
          String str1 = new BigInteger(bs(paramList.BSSID), 16).toString();
          String str2 = String.valueOf(paramList.level);
          if (paramBoolean) {}
          for (paramList = "&WD[]=";; paramList = "|WD,")
          {
            localStringBuilder.append(paramList);
            localStringBuilder.append(str1);
            localStringBuilder.append(',');
            localStringBuilder.append(str2);
            localStringBuilder.append(',');
            localStringBuilder.append(str2);
            localStringBuilder.append(',');
            localStringBuilder.append(str2);
            localStringBuilder.append(',');
            localStringBuilder.append(1);
            localStringBuilder.append(',');
            localStringBuilder.append(1);
            localStringBuilder.append(',');
            localStringBuilder.append(0);
            localStringBuilder.append(',');
            localStringBuilder.append("");
            break;
          }
        }
        catch (Error paramList) {}catch (NumberFormatException paramList) {}catch (NullPointerException paramList) {}
      }
    }
  }
  
  private static String bs(String paramString)
  {
    AppMethodBeat.i(55567);
    if (paramString == null)
    {
      paramString = new NullPointerException("trying to manipulate null string");
      AppMethodBeat.o(55567);
      throw paramString;
    }
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length())
      {
        AppMethodBeat.o(55567);
        return localObject1;
      }
      Object localObject2 = localObject1;
      if (paramString.charAt(i) != ':') {
        localObject2 = localObject1 + paramString.charAt(i);
      }
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  static String bt(String paramString)
  {
    AppMethodBeat.i(55570);
    if (paramString == null)
    {
      AppMethodBeat.o(55570);
      return null;
    }
    paramString = paramString.replace("&SD=", "|SD,");
    AppMethodBeat.o(55570);
    return paramString;
  }
  
  static String bu(String paramString)
  {
    AppMethodBeat.i(55571);
    if (paramString == null)
    {
      AppMethodBeat.o(55571);
      return null;
    }
    paramString = paramString.replace("&GD=", "|GD,");
    AppMethodBeat.o(55571);
    return paramString;
  }
  
  static boolean e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(55569);
    if ((Math.abs(paramDouble1) <= 90.0D) && (Math.abs(paramDouble2) <= 180.0D))
    {
      AppMethodBeat.o(55569);
      return true;
    }
    AppMethodBeat.o(55569);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.b.a.a.v
 * JD-Core Version:    0.7.0.1
 */