package com.tencent.mm.game.report.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class a
{
  private static String eAx = null;
  
  public static int F(Context paramContext, String paramString)
  {
    AppMethodBeat.i(59600);
    paramContext = b.getPackageInfo(paramContext, paramString);
    if (paramContext == null)
    {
      AppMethodBeat.o(59600);
      return 0;
    }
    int i = paramContext.versionCode;
    AppMethodBeat.o(59600);
    return i;
  }
  
  public static String Pu()
  {
    AppMethodBeat.i(59599);
    if (eAx == null)
    {
      str = q.LK();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < str.length() - 1)
      {
        localStringBuilder.append(Integer.toHexString(str.charAt(i)));
        i += 1;
      }
      localStringBuilder.append("00");
      eAx = localStringBuilder.toString();
    }
    String str = eAx;
    AppMethodBeat.o(59599);
    return str;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(59595);
    if (at.is3G(paramContext))
    {
      AppMethodBeat.o(59595);
      return 4;
    }
    if (at.is4G(paramContext))
    {
      AppMethodBeat.o(59595);
      return 5;
    }
    switch (at.getNetType(paramContext))
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      AppMethodBeat.o(59595);
      return 6;
    case -1: 
      AppMethodBeat.o(59595);
      return 255;
    case 0: 
      AppMethodBeat.o(59595);
      return 1;
    case 5: 
      AppMethodBeat.o(59595);
      return 2;
    }
    AppMethodBeat.o(59595);
    return 3;
  }
  
  public static String gf(long paramLong)
  {
    AppMethodBeat.i(59601);
    String str = new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(paramLong)).toString();
    ab.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = ".concat(String.valueOf(str)));
    AppMethodBeat.o(59601);
    return str;
  }
  
  public static String h(Map<String, String> paramMap)
  {
    AppMethodBeat.i(140320);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(140320);
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
        ab.e("MicroMsg.GameReportUtil", paramMap.getMessage());
        AppMethodBeat.o(140320);
        return "";
      }
    }
    try
    {
      paramMap = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      AppMethodBeat.o(140320);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      ab.e("MicroMsg.GameReportUtil", paramMap.getMessage());
      AppMethodBeat.o(140320);
    }
    return "";
  }
  
  public static String lR(String paramString)
  {
    AppMethodBeat.i(59596);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59596);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(59596);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "";
        ab.e("MicroMsg.GameReportUtil", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.game.report.c.a
 * JD-Core Version:    0.7.0.1
 */