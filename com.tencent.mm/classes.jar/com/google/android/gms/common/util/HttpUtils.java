package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtils
{
  private static final Pattern zzaab;
  private static final Pattern zzaac;
  private static final Pattern zzaad;
  
  static
  {
    AppMethodBeat.i(90217);
    zzaab = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    zzaac = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    zzaad = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    AppMethodBeat.o(90217);
  }
  
  private static String decode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90212);
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramString1 = URLDecoder.decode(paramString1, paramString2);
        AppMethodBeat.o(90212);
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1 = new IllegalArgumentException(paramString1);
        AppMethodBeat.o(90212);
        throw paramString1;
      }
      paramString2 = "ISO-8859-1";
    }
  }
  
  public static boolean isIPv4Address(String paramString)
  {
    AppMethodBeat.i(90213);
    boolean bool = zzaab.matcher(paramString).matches();
    AppMethodBeat.o(90213);
    return bool;
  }
  
  public static boolean isIPv6Address(String paramString)
  {
    AppMethodBeat.i(90216);
    if ((isIPv6StdAddress(paramString)) || (isIPv6HexCompressedAddress(paramString)))
    {
      AppMethodBeat.o(90216);
      return true;
    }
    AppMethodBeat.o(90216);
    return false;
  }
  
  public static boolean isIPv6HexCompressedAddress(String paramString)
  {
    AppMethodBeat.i(90215);
    boolean bool = zzaad.matcher(paramString).matches();
    AppMethodBeat.o(90215);
    return bool;
  }
  
  public static boolean isIPv6StdAddress(String paramString)
  {
    AppMethodBeat.i(90214);
    boolean bool = zzaac.matcher(paramString).matches();
    AppMethodBeat.o(90214);
    return bool;
  }
  
  public static Map<String, String> parse(URI paramURI, String paramString)
  {
    AppMethodBeat.i(90211);
    Object localObject1 = Collections.emptyMap();
    Object localObject2 = paramURI.getRawQuery();
    paramURI = (URI)localObject1;
    if (localObject2 != null)
    {
      paramURI = (URI)localObject1;
      if (((String)localObject2).length() > 0)
      {
        localObject1 = new HashMap();
        localObject2 = new Scanner((String)localObject2);
        ((Scanner)localObject2).useDelimiter("&");
        while (((Scanner)localObject2).hasNext())
        {
          String[] arrayOfString = ((Scanner)localObject2).next().split("=");
          if ((arrayOfString.length == 0) || (arrayOfString.length > 2))
          {
            paramURI = new IllegalArgumentException("bad parameter");
            AppMethodBeat.o(90211);
            throw paramURI;
          }
          String str = decode(arrayOfString[0], paramString);
          paramURI = null;
          if (arrayOfString.length == 2) {
            paramURI = decode(arrayOfString[1], paramString);
          }
          ((Map)localObject1).put(str, paramURI);
        }
        paramURI = (URI)localObject1;
      }
    }
    AppMethodBeat.o(90211);
    return paramURI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.util.HttpUtils
 * JD-Core Version:    0.7.0.1
 */