package com.tencent.mm.modelcdntran;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  public static int oAI = 1;
  public static int oAJ = 2;
  public static int oAK = 3;
  public static int oAL = -1;
  public static int oAM = 3;
  public static int oAN = 4;
  public static int oAO = 5;
  public static int oAP = 1;
  public static int oAQ = 2;
  public static int oAR = -10001;
  public static int oAS = -10002;
  public static int oAT = -10003;
  public static int oAU = -10004;
  
  private static String LQ(String paramString)
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
    if (Util.isNullOrNil(LQ(paramString1)))
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
    paramString3 = Util.nullAsNil(LQ(paramString3));
    paramString2 = g.getMessageDigest((z.bAM() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!Util.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(150420);
    return paramString1;
  }
  
  public static int bHP()
  {
    AppMethodBeat.i(237862);
    int i;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null)
      {
        i = oAI;
        AppMethodBeat.o(237862);
        return i;
      }
      if (localNetworkInfo.getType() == 1)
      {
        i = oAK;
        AppMethodBeat.o(237862);
        return i;
      }
      if (localNetworkInfo.getSubtype() == 1)
      {
        i = oAI;
        AppMethodBeat.o(237862);
        return i;
      }
      if (localNetworkInfo.getSubtype() == 2)
      {
        i = oAI;
        AppMethodBeat.o(237862);
        return i;
      }
      if (localNetworkInfo.getSubtype() >= 3)
      {
        i = oAJ;
        AppMethodBeat.o(237862);
        return i;
      }
      i = oAI;
      AppMethodBeat.o(237862);
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { Util.stackTraceToString(localNullPointerException) });
      i = oAI;
      AppMethodBeat.o(237862);
    }
    return i;
  }
  
  public static boolean bHQ()
  {
    AppMethodBeat.i(237866);
    if (1 == ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zpz, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CdnUtil", "cdn UseMultiSocket(X-Lab):%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(237866);
      return bool;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.h
 * JD-Core Version:    0.7.0.1
 */