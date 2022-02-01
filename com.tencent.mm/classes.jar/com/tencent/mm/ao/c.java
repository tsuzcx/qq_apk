package com.tencent.mm.ao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public static int hUb = 1;
  public static int hUc = 2;
  public static int hUd = 3;
  public static int hUe = -1;
  public static int hUf = 3;
  public static int hUg = 4;
  public static int hUh = 5;
  public static int hUi = 1;
  public static int hUj = 2;
  public static int hUk = -10001;
  public static int hUl = -10002;
  public static int hUm = -10003;
  public static int hUn = -10004;
  
  private static String ER(String paramString)
  {
    AppMethodBeat.i(150419);
    if (!bt.isNullOrNil(paramString))
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!bt.F(c)) && (!bt.G(c)))
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
    ad.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, bt.flS() });
    if (bt.isNullOrNil(ER(paramString1)))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(150420);
      return null;
    }
    paramString3 = bt.nullAsNil(ER(paramString3));
    paramString2 = g.getMessageDigest((u.aAm() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!bt.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(150420);
    return paramString1;
  }
  
  public static int cA(Context paramContext)
  {
    AppMethodBeat.i(150422);
    int i = ay.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = hUe;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = hUi;
      AppMethodBeat.o(150422);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = hUf;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = hUh;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = hUg;
      AppMethodBeat.o(150422);
      return i;
    }
    if (ay.isWap(i))
    {
      i = hUj;
      AppMethodBeat.o(150422);
      return i;
    }
    i = hUf;
    AppMethodBeat.o(150422);
    return i;
  }
  
  public static int cz(Context paramContext)
  {
    AppMethodBeat.i(150421);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = hUb;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = hUd;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = hUb;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = hUb;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = hUc;
        AppMethodBeat.o(150421);
        return i;
      }
      i = hUb;
      AppMethodBeat.o(150421);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      ad.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bt.n(paramContext) });
      i = hUb;
      AppMethodBeat.o(150421);
    }
    return i;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(150418);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bt.cC(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4)
    {
      ad.e(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 3)
    {
      ad.w(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 2)
    {
      ad.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 1)
    {
      ad.d(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 0) {
      ad.v(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(150418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.c
 * JD-Core Version:    0.7.0.1
 */