package com.tencent.mm.aq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static int lIj = 1;
  public static int lIk = 2;
  public static int lIl = 3;
  public static int lIm = -1;
  public static int lIn = 3;
  public static int lIo = 4;
  public static int lIp = 5;
  public static int lIq = 1;
  public static int lIr = 2;
  public static int lIs = -10001;
  public static int lIt = -10002;
  public static int lIu = -10003;
  public static int lIv = -10004;
  
  private static String VA(String paramString)
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
    if (Util.isNullOrNil(VA(paramString1)))
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
    paramString3 = Util.nullAsNil(VA(paramString3));
    paramString2 = g.getMessageDigest((z.bcZ() + "-" + paramString2).getBytes());
    paramString2 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
    paramString1 = paramString2;
    if (!Util.isNullOrNil(paramString3)) {
      paramString1 = paramString2 + "_" + paramString3;
    }
    AppMethodBeat.o(150420);
    return paramString1;
  }
  
  public static boolean bka()
  {
    AppMethodBeat.i(187974);
    if (1 == ((b)h.ae(b.class)).a(b.a.vWU, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.CdnUtil", "cdn UseMultiSocket(X-Lab):%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(187974);
      return bool;
    }
  }
  
  public static int cU(Context paramContext)
  {
    AppMethodBeat.i(150421);
    int i;
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        i = lIj;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getType() == 1)
      {
        i = lIl;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 1)
      {
        i = lIj;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() == 2)
      {
        i = lIj;
        AppMethodBeat.o(150421);
        return i;
      }
      if (paramContext.getSubtype() >= 3)
      {
        i = lIk;
        AppMethodBeat.o(150421);
        return i;
      }
      i = lIj;
      AppMethodBeat.o(150421);
      return i;
    }
    catch (NullPointerException paramContext)
    {
      Log.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { Util.stackTraceToString(paramContext) });
      i = lIj;
      AppMethodBeat.o(150421);
    }
    return i;
  }
  
  public static int cV(Context paramContext)
  {
    AppMethodBeat.i(150422);
    int i = NetStatusUtil.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      i = lIm;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getType() == 1)
    {
      i = lIq;
      AppMethodBeat.o(150422);
      return i;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2))
    {
      i = lIn;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 13)
    {
      i = lIp;
      AppMethodBeat.o(150422);
      return i;
    }
    if (paramContext.getSubtype() >= 3)
    {
      i = lIo;
      AppMethodBeat.o(150422);
      return i;
    }
    if (NetStatusUtil.isWap(i))
    {
      i = lIr;
      AppMethodBeat.o(150422);
      return i;
    }
    i = lIn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aq.c
 * JD-Core Version:    0.7.0.1
 */