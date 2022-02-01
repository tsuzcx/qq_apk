package com.tencent.mm.an;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static int iRR = 1;
  public static int iRS = 2;
  public static int iRT = 3;
  public static int iRU = -1;
  public static int iRV = 3;
  public static int iRW = 4;
  public static int iRX = 5;
  public static int iRY = 1;
  public static int iRZ = 2;
  public static int iSa = -10001;
  public static int iSb = -10002;
  public static int iSc = -10003;
  public static int iSd = -10004;
  
  private static String Od(String paramString)
  {
    AppMethodBeat.i(150419);
    if (!Util.isNullOrNil(paramString))
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!Util.isAlpha(c)) && (!Util.isNum(c)))
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
    Log.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, Util.getStack() });
    if (Util.isNullOrNil(Od(paramString1)))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(150420);
      return null;
    }
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(150420);
      return null;
    }
    paramString3 = Util.nullAsNil(Od(paramString3));
    paramString2 = com.tencent.mm.b.g.getMessageDigest((z.aTY() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!Util.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(150420);
    return paramString1;
  }
  
  public static boolean baL()
  {
    AppMethodBeat.i(223567);
    if (1 == ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.smf, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CdnUtil", "cdn UseMultiSocket(X-Lab):%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(223567);
      return bool;
    }
  }
  
  public static int cX(Context paramContext)
  {
    AppMethodBeat.i(150421);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = iRR;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = iRT;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = iRR;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = iRR;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = iRS;
        AppMethodBeat.o(150421);
        return i;
      }
      i = iRR;
      AppMethodBeat.o(150421);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      Log.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { Util.stackTraceToString(paramContext) });
      i = iRR;
      AppMethodBeat.o(150421);
    }
    return i;
  }
  
  public static int cY(Context paramContext)
  {
    AppMethodBeat.i(150422);
    int i = NetStatusUtil.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = iRU;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = iRY;
      AppMethodBeat.o(150422);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = iRV;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = iRX;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = iRW;
      AppMethodBeat.o(150422);
      return i;
    }
    if (NetStatusUtil.isWap(i))
    {
      i = iRZ;
      AppMethodBeat.o(150422);
      return i;
    }
    i = iRV;
    AppMethodBeat.o(150422);
    return i;
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    AppMethodBeat.i(150418);
    byte[] arrayOfByte = paramArrayOfByte;
    if (Util.isNullOrNil(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4)
    {
      Log.e(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 3)
    {
      Log.w(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 2)
    {
      Log.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 1)
    {
      Log.d(paramString, paramArrayOfByte);
      AppMethodBeat.o(150418);
      return;
    }
    if (paramInt == 0) {
      Log.v(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(150418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.an.c
 * JD-Core Version:    0.7.0.1
 */