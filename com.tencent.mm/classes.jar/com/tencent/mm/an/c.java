package com.tencent.mm.an;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
{
  public static int hBA = 4;
  public static int hBB = 5;
  public static int hBC = 1;
  public static int hBD = 2;
  public static int hBE = -10001;
  public static int hBF = -10002;
  public static int hBG = -10003;
  public static int hBH = -10004;
  public static int hBv = 1;
  public static int hBw = 2;
  public static int hBx = 3;
  public static int hBy = -1;
  public static int hBz = 3;
  
  private static String BS(String paramString)
  {
    AppMethodBeat.i(150419);
    if (!bs.isNullOrNil(paramString))
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!bs.D(c)) && (!bs.E(c)))
        {
          AppMethodBeat.o(150419);
          return null;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(150419);
    return paramString;
  }
  
  public static String a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150420);
    ac.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, bs.eWi() });
    if (bs.isNullOrNil(BS(paramString1)))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(150420);
      return null;
    }
    paramString3 = bs.nullAsNil(BS(paramString3));
    paramString2 = g.getMessageDigest((u.axw() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!bs.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(150420);
    return paramString1;
  }
  
  public static int cC(Context paramContext)
  {
    AppMethodBeat.i(150421);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = hBv;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = hBx;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = hBv;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = hBv;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = hBw;
        AppMethodBeat.o(150421);
        return i;
      }
      i = hBv;
      AppMethodBeat.o(150421);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      ac.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bs.m(paramContext) });
      i = hBv;
      AppMethodBeat.o(150421);
    }
    return i;
  }
  
  public static int cD(Context paramContext)
  {
    AppMethodBeat.i(150422);
    int i = ax.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = hBy;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = hBC;
      AppMethodBeat.o(150422);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = hBz;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = hBB;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = hBA;
      AppMethodBeat.o(150422);
      return i;
    }
    if (ax.isWap(i))
    {
      i = hBD;
      AppMethodBeat.o(150422);
      return i;
    }
    i = hBz;
    AppMethodBeat.o(150422);
    return i;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(150418);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bs.cv(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4)
    {
      ac.e(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 3)
    {
      ac.w(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 2)
    {
      ac.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 1)
    {
      ac.d(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 0) {
      ac.v(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(150418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.c
 * JD-Core Version:    0.7.0.1
 */