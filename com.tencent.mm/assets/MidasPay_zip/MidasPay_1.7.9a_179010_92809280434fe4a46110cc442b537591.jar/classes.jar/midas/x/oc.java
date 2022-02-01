package midas.x;

import android.util.Patterns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class oc
{
  static
  {
    Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
  }
  
  public static boolean a(String paramString)
  {
    return (b(paramString)) || (c(paramString));
  }
  
  public static boolean b(String paramString)
  {
    return Patterns.IP_ADDRESS.matcher(paramString).matches();
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = paramString.contains("::");
    if ((bool) && (paramString.indexOf("::") != paramString.lastIndexOf("::"))) {
      return false;
    }
    if (((paramString.startsWith(":")) && (!paramString.startsWith("::"))) || ((paramString.endsWith(":")) && (!paramString.endsWith("::")))) {
      return false;
    }
    String[] arrayOfString = paramString.split(":");
    Object localObject = arrayOfString;
    if (bool)
    {
      localObject = new ArrayList(Arrays.asList(arrayOfString));
      if (paramString.endsWith("::")) {
        ((List)localObject).add("");
      } else if ((paramString.startsWith("::")) && (!((List)localObject).isEmpty())) {
        ((List)localObject).remove(0);
      }
      localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    }
    if (localObject.length > 8) {
      return false;
    }
    int k = 0;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (k < localObject.length)
      {
        paramString = localObject[k];
        if (paramString.length() == 0)
        {
          int m = i + 1;
          i = m;
          if (m > 1) {
            return false;
          }
        }
        else
        {
          if ((k == localObject.length - 1) && (paramString.contains(".")))
          {
            if (!b(paramString)) {
              return false;
            }
            j += 2;
            i = 0;
            break label293;
          }
          if (paramString.length() > 4) {
            return false;
          }
        }
      }
      try
      {
        i = Integer.parseInt(paramString, 16);
        if (i >= 0)
        {
          if (i > 65535) {
            return false;
          }
          i = 0;
          j += 1;
          label293:
          k += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    if (j <= 8) {
      return (j >= 8) || (bool);
    }
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.oc
 * JD-Core Version:    0.7.0.1
 */