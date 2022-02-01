package com.tencent.mm.an;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
{
  public static int hWT = 1;
  public static int hWU = 2;
  public static int hWV = 3;
  public static int hWW = -1;
  public static int hWX = 3;
  public static int hWY = 4;
  public static int hWZ = 5;
  public static int hXa = 1;
  public static int hXb = 2;
  public static int hXc = -10001;
  public static int hXd = -10002;
  public static int hXe = -10003;
  public static int hXf = -10004;
  
  private static String Ft(String paramString)
  {
    AppMethodBeat.i(150419);
    if (!bu.isNullOrNil(paramString))
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!bu.F(c)) && (!bu.G(c)))
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
    ae.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, bu.fpN() });
    if (bu.isNullOrNil(Ft(paramString1)))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (bu.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(150420);
      return null;
    }
    paramString3 = bu.nullAsNil(Ft(paramString3));
    paramString2 = com.tencent.mm.b.g.getMessageDigest((v.aAC() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!bu.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(150420);
    return paramString1;
  }
  
  public static boolean aGU()
  {
    AppMethodBeat.i(218686);
    if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qOY, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.CdnUtil", "cdn UseMultiSocket(X-Lab):%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(218686);
      return bool;
    }
  }
  
  public static int cB(Context paramContext)
  {
    AppMethodBeat.i(150421);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = hWT;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = hWV;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = hWT;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = hWT;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = hWU;
        AppMethodBeat.o(150421);
        return i;
      }
      i = hWT;
      AppMethodBeat.o(150421);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      ae.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bu.o(paramContext) });
      i = hWT;
      AppMethodBeat.o(150421);
    }
    return i;
  }
  
  public static int cC(Context paramContext)
  {
    AppMethodBeat.i(150422);
    int i = az.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = hWW;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = hXa;
      AppMethodBeat.o(150422);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = hWX;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = hWZ;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = hWY;
      AppMethodBeat.o(150422);
      return i;
    }
    if (az.isWap(i))
    {
      i = hXb;
      AppMethodBeat.o(150422);
      return i;
    }
    i = hWX;
    AppMethodBeat.o(150422);
    return i;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(150418);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bu.cF(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4)
    {
      ae.e(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 3)
    {
      ae.w(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 2)
    {
      ae.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 1)
    {
      ae.d(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 0) {
      ae.v(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(150418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.an.c
 * JD-Core Version:    0.7.0.1
 */