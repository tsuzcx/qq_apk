package com.tencent.mm.al;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public final class c
{
  public static int fyW = 1;
  public static int fyX = 2;
  public static int fyY = 3;
  public static int fyZ = -1;
  public static int fza = 3;
  public static int fzb = 4;
  public static int fzc = 5;
  public static int fzd = 1;
  public static int fze = 2;
  public static int fzf = -10001;
  public static int fzg = -10002;
  public static int fzh = -10003;
  public static int fzi = -10004;
  
  public static String a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78061);
    ab.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, bo.dtY() });
    if (bo.isNullOrNil(sK(paramString1)))
    {
      AppMethodBeat.o(78061);
      return null;
    }
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(78061);
      return null;
    }
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(78061);
      return null;
    }
    paramString3 = bo.nullAsNil(sK(paramString3));
    paramString2 = g.w((r.Zn() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!bo.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(78061);
    return paramString1;
  }
  
  public static int c(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(78064);
    try
    {
      paramHttpURLConnection = (List)paramHttpURLConnection.getHeaderFields().get("cache-control");
      if (paramHttpURLConnection != null)
      {
        int i = paramHttpURLConnection.size();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(78064);
        return 0;
      }
      if (!bo.isNullOrNil(paramHttpURLConnection.toString()))
      {
        boolean bool = paramHttpURLConnection.toString().contains("no-cache");
        if (bool) {}
      }
      else
      {
        AppMethodBeat.o(78064);
        return 0;
      }
      AppMethodBeat.o(78064);
      return -1;
    }
    catch (Exception paramHttpURLConnection)
    {
      ab.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bo.l(paramHttpURLConnection) });
      AppMethodBeat.o(78064);
    }
    return -2;
  }
  
  public static int ca(Context paramContext)
  {
    AppMethodBeat.i(78062);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = fyW;
        AppMethodBeat.o(78062);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = fyY;
        AppMethodBeat.o(78062);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = fyW;
        AppMethodBeat.o(78062);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = fyW;
        AppMethodBeat.o(78062);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = fyX;
        AppMethodBeat.o(78062);
        return i;
      }
      i = fyW;
      AppMethodBeat.o(78062);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      ab.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bo.l(paramContext) });
      i = fyW;
      AppMethodBeat.o(78062);
    }
    return i;
  }
  
  public static int cb(Context paramContext)
  {
    AppMethodBeat.i(78063);
    int i = at.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = fyZ;
      AppMethodBeat.o(78063);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = fzd;
      AppMethodBeat.o(78063);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = fza;
      AppMethodBeat.o(78063);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = fzc;
      AppMethodBeat.o(78063);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = fzb;
      AppMethodBeat.o(78063);
      return i;
    }
    if (at.isWap(i))
    {
      i = fze;
      AppMethodBeat.o(78063);
      return i;
    }
    i = fza;
    AppMethodBeat.o(78063);
    return i;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(78059);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bo.ce(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4)
    {
      ab.e(paramString, paramArrayOfByte);
      AppMethodBeat.o(78059);
      return;
    }
    if (paramInt == 3)
    {
      ab.w(paramString, paramArrayOfByte);
      AppMethodBeat.o(78059);
      return;
    }
    if (paramInt == 2)
    {
      ab.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(78059);
      return;
    }
    if (paramInt == 1)
    {
      ab.d(paramString, paramArrayOfByte);
      AppMethodBeat.o(78059);
      return;
    }
    if (paramInt == 0) {
      ab.v(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(78059);
  }
  
  private static String sK(String paramString)
  {
    AppMethodBeat.i(78060);
    if (!bo.isNullOrNil(paramString))
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!bo.C(c)) && (!bo.D(c)))
        {
          AppMethodBeat.o(78060);
          return null;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(78060);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.al.c
 * JD-Core Version:    0.7.0.1
 */