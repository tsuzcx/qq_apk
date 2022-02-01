package com.c.a.a;

import android.net.wifi.ScanResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

final class v
{
  static String a(List<ScanResult> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(87913);
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
        AppMethodBeat.o(87913);
        return paramList;
      }
      paramList = (ScanResult)localIterator.next();
      if ((paramList.capabilities != null) && (!paramList.capabilities.contains("IBSS"))) {
        try
        {
          String str1 = new BigInteger(bv(paramList.BSSID), 16).toString();
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
  
  static String b(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(87917);
    if ((paramString1 == null) || (!paramString1.startsWith("|")))
    {
      AppMethodBeat.o(87917);
      return null;
    }
    paramString1 = "&OD[]=ST," + String.valueOf(paramLong) + ',' + paramString2 + paramString1;
    AppMethodBeat.o(87917);
    return paramString1;
  }
  
  static boolean b(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(87914);
    if ((Math.abs(paramDouble1) <= 90.0D) && (Math.abs(paramDouble2) <= 180.0D))
    {
      AppMethodBeat.o(87914);
      return true;
    }
    AppMethodBeat.o(87914);
    return false;
  }
  
  private static String bv(String paramString)
  {
    AppMethodBeat.i(87912);
    if (paramString == null)
    {
      paramString = new NullPointerException("trying to manipulate null string");
      AppMethodBeat.o(87912);
      throw paramString;
    }
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length())
      {
        AppMethodBeat.o(87912);
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
  
  static String bw(String paramString)
  {
    AppMethodBeat.i(87915);
    if (paramString == null)
    {
      AppMethodBeat.o(87915);
      return null;
    }
    paramString = paramString.replace("&SD=", "|SD,");
    AppMethodBeat.o(87915);
    return paramString;
  }
  
  static String bx(String paramString)
  {
    AppMethodBeat.i(87916);
    if (paramString == null)
    {
      AppMethodBeat.o(87916);
      return null;
    }
    paramString = paramString.replace("&GD=", "|GD,");
    AppMethodBeat.o(87916);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.c.a.a.v
 * JD-Core Version:    0.7.0.1
 */