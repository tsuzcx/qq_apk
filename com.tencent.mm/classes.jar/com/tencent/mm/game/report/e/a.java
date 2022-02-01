package com.tencent.mm.game.report.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class a
{
  private static String uuid = null;
  
  public static String Fq(long paramLong)
  {
    AppMethodBeat.i(108278);
    String str = new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(paramLong)).toString();
    Log.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = ".concat(String.valueOf(str)));
    AppMethodBeat.o(108278);
    return str;
  }
  
  public static int G(Context paramContext, String paramString)
  {
    AppMethodBeat.i(108277);
    paramContext = b.getPackageInfo(paramContext, paramString);
    if (paramContext == null)
    {
      AppMethodBeat.o(108277);
      return 0;
    }
    int i = paramContext.versionCode;
    AppMethodBeat.o(108277);
    return i;
  }
  
  public static String Md(String paramString)
  {
    AppMethodBeat.i(108275);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(108275);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(108275);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "";
        Log.e("MicroMsg.GameReportUtil", localException.getMessage());
      }
    }
  }
  
  public static String aED()
  {
    AppMethodBeat.i(108276);
    if (uuid == null)
    {
      str = q.auM();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < str.length() - 1)
      {
        localStringBuilder.append(Integer.toHexString(str.charAt(i)));
        i += 1;
      }
      localStringBuilder.append("00");
      uuid = localStringBuilder.toString();
    }
    String str = uuid;
    AppMethodBeat.o(108276);
    return str;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(108274);
    if (NetStatusUtil.is3G(paramContext))
    {
      AppMethodBeat.o(108274);
      return 4;
    }
    if (NetStatusUtil.is4G(paramContext))
    {
      AppMethodBeat.o(108274);
      return 5;
    }
    switch (NetStatusUtil.getNetType(paramContext))
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      AppMethodBeat.o(108274);
      return 6;
    case -1: 
      AppMethodBeat.o(108274);
      return 255;
    case 0: 
      AppMethodBeat.o(108274);
      return 1;
    case 5: 
      AppMethodBeat.o(108274);
      return 2;
    }
    AppMethodBeat.o(108274);
    return 3;
  }
  
  public static String m(Map<String, String> paramMap)
  {
    AppMethodBeat.i(108279);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(108279);
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.GameReportUtil", paramMap.getMessage());
        AppMethodBeat.o(108279);
        return "";
      }
    }
    try
    {
      paramMap = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      AppMethodBeat.o(108279);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      Log.e("MicroMsg.GameReportUtil", paramMap.getMessage());
      AppMethodBeat.o(108279);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.e.a
 * JD-Core Version:    0.7.0.1
 */