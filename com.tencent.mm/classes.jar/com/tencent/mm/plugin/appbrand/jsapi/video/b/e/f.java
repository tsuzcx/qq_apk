package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static final Pattern RANGE_HEADER_PATTERN;
  public static HashMap<String, Map<String, String>> ltv;
  private BufferedReader bzC;
  public String lsW;
  private LinkedHashMap<String, String> ltq;
  private LinkedHashMap<String, String> ltr;
  private int[] lts;
  private ArrayList<String> ltt;
  private String ltu;
  
  static
  {
    AppMethodBeat.i(211179);
    RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:\\s*bytes=(\\d*)\\s*-\\s*(\\d*)");
    ltv = new HashMap();
    AppMethodBeat.o(211179);
  }
  
  public f(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(211169);
    this.bzC = new BufferedReader(new InputStreamReader(paramInputStream));
    this.ltq = new LinkedHashMap();
    this.ltr = new LinkedHashMap();
    this.lts = new int[2];
    this.ltt = new ArrayList();
    this.ltu = (paramString + "HttpParser");
    try
    {
      box();
      AppMethodBeat.o(211169);
      return;
    }
    catch (IOException paramInputStream)
    {
      h.log(6, this.ltu, "error parsing request " + h.i(paramInputStream));
      AppMethodBeat.o(211169);
    }
  }
  
  private static String P(Map<String, String> paramMap)
  {
    AppMethodBeat.i(211173);
    Object localObject = "";
    Iterator localIterator = paramMap.entrySet().iterator();
    for (paramMap = (Map<String, String>)localObject; localIterator.hasNext(); paramMap = paramMap + "\r\n")
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObject = paramMap;
      if (localEntry.getKey() != null)
      {
        paramMap = paramMap + (String)localEntry.getKey();
        localObject = paramMap + ": ";
      }
      paramMap = (String)localObject + (String)localEntry.getValue();
    }
    AppMethodBeat.o(211173);
    return paramMap;
  }
  
  public static String Q(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(211174);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      int i = 0;
      label70:
      if (i < ((List)localObject).size())
      {
        if (str == null) {
          break label112;
        }
        localLinkedHashMap.put(str.toLowerCase().trim(), ((List)localObject).get(i));
      }
      for (;;)
      {
        i += 1;
        break label70;
        break;
        label112:
        localLinkedHashMap.put(str, ((List)localObject).get(i));
      }
    }
    paramMap = P(localLinkedHashMap);
    AppMethodBeat.o(211174);
    return paramMap;
  }
  
  public static long[] RB(String paramString)
  {
    AppMethodBeat.i(211178);
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = RANGE_HEADER_PATTERN.matcher(paramString);
      if (((Matcher)localObject).find())
      {
        paramString = ((Matcher)localObject).group(1);
        localObject = ((Matcher)localObject).group(2);
        try
        {
          l1 = Long.parseLong(paramString);
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            try
            {
              long l2 = Long.parseLong((String)localObject);
              AppMethodBeat.o(211178);
              return new long[] { l1, l2 };
            }
            catch (NumberFormatException paramString)
            {
              long l1;
              AppMethodBeat.o(211178);
              return new long[] { l1, -2L };
            }
            paramString = paramString;
            l1 = 0L;
          }
        }
      }
    }
    AppMethodBeat.o(211178);
    return new long[] { -1L, -1L };
  }
  
  public static Map<String, String> Rz(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(211172);
    if ((!TextUtils.isEmpty(paramString)) && (ltv.containsKey(paramString)))
    {
      paramString = (Map)ltv.get(paramString);
      AppMethodBeat.o(211172);
      return paramString;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    String[] arrayOfString1;
    if (paramString != null)
    {
      int j = paramString.indexOf('?');
      if (j >= 0) {
        arrayOfString1 = paramString.substring(j + 1).split("&");
      }
    }
    for (;;)
    {
      try
      {
        if (i < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length == 2) {
            localLinkedHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
          } else if ((arrayOfString2.length == 1) && (arrayOfString1[i].indexOf('=') == arrayOfString1[i].length() - 1)) {
            localLinkedHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
          }
        }
      }
      catch (IOException paramString)
      {
        h.log(5, "HttpParser", h.i(paramString));
      }
      for (;;)
      {
        AppMethodBeat.o(211172);
        return localLinkedHashMap;
        ltv.put(paramString, localLinkedHashMap);
      }
      i += 1;
    }
  }
  
  public static String a(long paramLong1, long paramLong2, long paramLong3, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211177);
    int i;
    int j;
    label28:
    int k;
    label38:
    long l;
    label57:
    Object localObject2;
    if (paramLong1 != -1L)
    {
      i = 1;
      if (TextUtils.isEmpty(paramString)) {
        break label673;
      }
      j = 1;
      if (paramLong3 < 0L) {
        break label679;
      }
      k = 1;
      if (i == 0) {
        break label749;
      }
      if (paramLong2 != -2L) {
        break label685;
      }
      l = paramLong3 - paramLong1;
      localObject2 = new StringBuilder().append("");
      if (i == 0) {
        break label756;
      }
      localObject1 = "HTTP/1.1 206 PARTIAL CONTENT\r\n";
      label81:
      localObject1 = (String)localObject1;
      localObject2 = (String)localObject1 + "Connection: close\r\n";
      localObject1 = localObject2;
      if (k != 0)
      {
        localObject1 = localObject2;
        if (i != 0)
        {
          if (paramLong2 != -2L) {
            break label764;
          }
          localObject1 = (String)localObject2 + String.format(Locale.US, "Content-Range: bytes %d-%d/%d\r\n", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong3 - 1L), Long.valueOf(paramLong3) });
        }
      }
      label200:
      if (!paramBoolean) {
        break label822;
      }
      localObject1 = (String)localObject1 + String.format(Locale.US, "Cache-Control: max-age=%d\r\n", new Object[] { Integer.valueOf(10800) });
      label247:
      localObject1 = new StringBuilder().append((String)localObject1);
      localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
      ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
      localObject2 = new StringBuilder("Date: ").append(((SimpleDateFormat)localObject2).format(new Date())).append(" GMT").toString() + "\r\n";
      localObject1 = localObject2;
      if (paramBoolean)
      {
        localObject1 = new StringBuilder().append((String)localObject2);
        localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
        localObject1 = new StringBuilder("Expires: ").append(((SimpleDateFormat)localObject2).format(new Date(System.currentTimeMillis() + 10800000L))).append(" GMT").toString() + "\r\n";
      }
      localObject2 = new StringBuilder().append((String)localObject1);
      if (k == 0) {
        break label848;
      }
      localObject1 = String.format(Locale.US, "Content-Length: %d\r\n", new Object[] { Long.valueOf(l) });
      label483:
      localObject1 = (String)localObject1;
      localObject1 = (String)localObject1 + "Accept-Ranges: bytes\r\n";
      localObject2 = new StringBuilder().append((String)localObject1);
      if (j == 0) {
        break label855;
      }
    }
    label673:
    label679:
    label685:
    label822:
    label848:
    label855:
    for (Object localObject1 = String.format("Content-Type: %s\r\n", new Object[] { paramString });; localObject1 = "")
    {
      localObject1 = (String)localObject1;
      localObject1 = (String)localObject1 + String.format("X-Server: %s\r\n", new Object[] { "VideoProxy 1.4.1" });
      localObject1 = (String)localObject1 + "\r\n";
      if ((i == 0) && (j != 0) && (paramString.equalsIgnoreCase("video/mp4"))) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqJ.td(paramLong3);
      }
      AppMethodBeat.o(211177);
      return localObject1;
      i = 0;
      break;
      j = 0;
      break label28;
      k = 0;
      break label38;
      if (paramLong2 > paramLong3 - 1L) {
        h.log(5, "HttpParser", "fix rangeEnd. max=" + (paramLong3 - 1L) + " current=" + paramLong2);
      }
      paramLong2 = Math.min(paramLong2, paramLong3 - 1L);
      l = paramLong2 - paramLong1 + 1L;
      break label57;
      label749:
      l = paramLong3;
      break label57;
      label756:
      localObject1 = "HTTP/1.1 200 OK\r\n";
      break label81;
      label764:
      localObject1 = (String)localObject2 + String.format(Locale.US, "Content-Range: bytes %d-%d/%d\r\n", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      break label200;
      localObject1 = (String)localObject1 + "Cache-Control: no-cache\r\n";
      break label247;
      localObject1 = "";
      break label483;
    }
  }
  
  private void box()
  {
    AppMethodBeat.i(211170);
    String[] arrayOfString1 = null;
    Object localObject = this.bzC.readLine();
    h.log(4, this.ltu, "parseRequest:".concat(String.valueOf(localObject)));
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      h.log(6, this.ltu, "initial is not valid");
      AppMethodBeat.o(211170);
      return;
    }
    if (Character.isWhitespace(((String)localObject).charAt(0)))
    {
      h.log(6, this.ltu, "character first char is whitespace");
      AppMethodBeat.o(211170);
      return;
    }
    String[] arrayOfString2 = ((String)localObject).split("\\s");
    if (arrayOfString2.length != 3)
    {
      h.log(6, this.ltu, "cmd.length is not 3");
      AppMethodBeat.o(211170);
      return;
    }
    this.ltt.add(localObject);
    this.lsW = arrayOfString2[0];
    if ((arrayOfString2[2].indexOf("HTTP/") == 0) && (arrayOfString2[2].indexOf('.') > 5))
    {
      localObject = arrayOfString2[2];
      if (localObject != null) {
        localObject = ((String)localObject).substring(5).split("\\.");
      }
    }
    for (;;)
    {
      int i;
      try
      {
        this.lts[0] = Integer.parseInt(localObject[0]);
        this.lts[1] = Integer.parseInt(localObject[1]);
        if ((!arrayOfString2[0].equals("GET")) && (!arrayOfString2[0].equals("HEAD"))) {
          break label459;
        }
        i = arrayOfString2[1].indexOf('?');
        if (i < 0) {
          break label535;
        }
        localObject = arrayOfString2[1].substring(i + 1).split("&");
        this.ltr = new LinkedHashMap();
        i = 0;
        if (i >= localObject.length) {
          break label535;
        }
        arrayOfString1 = localObject[i].split("=");
        if (arrayOfString1.length == 2)
        {
          this.ltr.put(URLDecoder.decode(arrayOfString1[0], "UTF-8"), URLDecoder.decode(arrayOfString1[1], "UTF-8"));
          i += 1;
          continue;
          localObject = arrayOfString1;
          if (arrayOfString2[0].indexOf("HTTP/") != 0) {
            break;
          }
          localObject = arrayOfString1;
          if (arrayOfString2[0].indexOf('.') <= 5) {
            break;
          }
          localObject = arrayOfString2[0];
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        h.log(6, this.ltu, "error parsing request NumberFormatException:" + h.i(localNumberFormatException));
        AppMethodBeat.o(211170);
        return;
      }
      if ((arrayOfString1.length == 1) && (localNumberFormatException[i].indexOf('=') == localNumberFormatException[i].length() - 1)) {
        this.ltr.put(URLDecoder.decode(arrayOfString1[0], "UTF-8"), "");
      }
    }
    label459:
    if ((!arrayOfString2[0].equals("POST")) && (!arrayOfString2[0].equals("OPTIONS")) && (!arrayOfString2[0].equals("PUT")) && (!arrayOfString2[0].equals("DELETE")) && (!arrayOfString2[0].equals("TRACE"))) {
      arrayOfString2[0].equals("CONNECT");
    }
    label535:
    boy();
    AppMethodBeat.o(211170);
  }
  
  private void boy()
  {
    AppMethodBeat.i(211171);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.bzC.readLine();
    localStringBuilder.append(str).append("|");
    for (;;)
    {
      int i;
      if (!str.equals(""))
      {
        i = str.indexOf(':');
        if (i < 0) {
          this.ltq = null;
        }
      }
      else
      {
        h.log(4, this.ltu, "parseHeaders:" + localStringBuilder.toString());
        AppMethodBeat.o(211171);
        return;
      }
      this.ltq.put(str.substring(0, i).toLowerCase().trim(), str.substring(i + 1).trim());
      this.ltt.add(str);
      str = this.bzC.readLine();
      localStringBuilder.append(str).append("|");
    }
  }
  
  public final String RA(String paramString)
  {
    AppMethodBeat.i(211176);
    paramString = (String)this.ltr.get(paramString);
    AppMethodBeat.o(211176);
    return paramString;
  }
  
  public final String boz()
  {
    AppMethodBeat.i(211175);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.ltt.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append((String)localIterator.next());
      ((StringBuilder)localObject).append("\n");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(211175);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.f
 * JD-Core Version:    0.7.0.1
 */