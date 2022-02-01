package com.pay.http;

import android.text.TextUtils;
import android.util.Patterns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APToolNetwork
{
  private static final int BASE_16 = 16;
  private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
  private static final int IPV6_MAX_HEX_GROUPS = 8;
  private static final int MAX_UNSIGNED_SHORT = 65535;
  private static final Pattern PATTERN;
  
  static
  {
    AppMethodBeat.i(193270);
    PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    AppMethodBeat.o(193270);
  }
  
  public static boolean isIPAddress(String paramString)
  {
    AppMethodBeat.i(193267);
    if ((validateIPV4(paramString)) || (validateIPV6(paramString)))
    {
      AppMethodBeat.o(193267);
      return true;
    }
    AppMethodBeat.o(193267);
    return false;
  }
  
  public static String joinDomainPort(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193269);
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!validateIPV4(paramString1)) {
        break label52;
      }
      str = paramString1 + ":" + paramString2;
    }
    for (;;)
    {
      AppMethodBeat.o(193269);
      return str;
      label52:
      str = paramString1;
      if (validateIPV6(paramString1)) {
        str = "[" + paramString1 + "]:" + paramString2;
      }
    }
  }
  
  public static boolean validateIPV4(String paramString)
  {
    AppMethodBeat.i(193266);
    boolean bool = Patterns.IP_ADDRESS.matcher(paramString).matches();
    AppMethodBeat.o(193266);
    return bool;
  }
  
  public static boolean validateIPV6(String paramString)
  {
    AppMethodBeat.i(193268);
    boolean bool = paramString.contains("::");
    if ((bool) && (paramString.indexOf("::") != paramString.lastIndexOf("::")))
    {
      AppMethodBeat.o(193268);
      return false;
    }
    if (((paramString.startsWith(":")) && (!paramString.startsWith("::"))) || ((paramString.endsWith(":")) && (!paramString.endsWith("::"))))
    {
      AppMethodBeat.o(193268);
      return false;
    }
    String[] arrayOfString = paramString.split(":");
    Object localObject = arrayOfString;
    if (bool)
    {
      localObject = new ArrayList(Arrays.asList(arrayOfString));
      if (!paramString.endsWith("::")) {
        break label170;
      }
      ((List)localObject).add("");
    }
    for (;;)
    {
      localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
      if (localObject.length <= 8) {
        break;
      }
      AppMethodBeat.o(193268);
      return false;
      label170:
      if ((paramString.startsWith("::")) && (!((List)localObject).isEmpty())) {
        ((List)localObject).remove(0);
      }
    }
    int k = 0;
    int j = 0;
    int i = 0;
    if (k < localObject.length)
    {
      paramString = localObject[k];
      if (paramString.length() == 0)
      {
        int m = i + 1;
        i = m;
        if (m > 1)
        {
          AppMethodBeat.o(193268);
          return false;
        }
      }
      else if ((k == localObject.length - 1) && (paramString.contains(".")))
      {
        if (!Patterns.IP_ADDRESS.matcher(paramString).matches())
        {
          AppMethodBeat.o(193268);
          return false;
        }
        j += 2;
        i = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramString.length() > 4)
        {
          AppMethodBeat.o(193268);
          return false;
        }
        try
        {
          i = Integer.parseInt(paramString, 16);
          if ((i < 0) || (i > 65535))
          {
            AppMethodBeat.o(193268);
            return false;
          }
        }
        catch (NumberFormatException paramString)
        {
          AppMethodBeat.o(193268);
          return false;
        }
        i = 0;
        j += 1;
      }
    }
    if ((j > 8) || ((j < 8) && (!bool)))
    {
      AppMethodBeat.o(193268);
      return false;
    }
    AppMethodBeat.o(193268);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.pay.http.APToolNetwork
 * JD-Core Version:    0.7.0.1
 */