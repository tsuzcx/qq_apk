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
  public static int haU = 1;
  public static int haV = 2;
  public static int haW = 3;
  public static int haX = -1;
  public static int haY = 3;
  public static int haZ = 4;
  public static int hba = 5;
  public static int hbb = 1;
  public static int hbc = 2;
  public static int hbd = -10001;
  public static int hbe = -10002;
  public static int hbf = -10003;
  public static int hbg = -10004;
  
  public static String a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150420);
    ad.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, bt.eGN() });
    if (bt.isNullOrNil(xM(paramString1)))
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
    paramString3 = bt.nullAsNil(xM(paramString3));
    paramString2 = g.getMessageDigest((u.aqG() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!bt.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(150420);
    return paramString1;
  }
  
  public static int ct(Context paramContext)
  {
    AppMethodBeat.i(150421);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = haU;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = haW;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = haU;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = haU;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = haV;
        AppMethodBeat.o(150421);
        return i;
      }
      i = haU;
      AppMethodBeat.o(150421);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      ad.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bt.m(paramContext) });
      i = haU;
      AppMethodBeat.o(150421);
    }
    return i;
  }
  
  public static int cu(Context paramContext)
  {
    AppMethodBeat.i(150422);
    int i = ay.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = haX;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = hbb;
      AppMethodBeat.o(150422);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = haY;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = hba;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = haZ;
      AppMethodBeat.o(150422);
      return i;
    }
    if (ay.isWap(i))
    {
      i = hbc;
      AppMethodBeat.o(150422);
      return i;
    }
    i = haY;
    AppMethodBeat.o(150422);
    return i;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(150418);
    byte[] arrayOfByte = paramArrayOfByte;
    if (bt.cw(paramArrayOfByte)) {
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
  
  private static String xM(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.c
 * JD-Core Version:    0.7.0.1
 */