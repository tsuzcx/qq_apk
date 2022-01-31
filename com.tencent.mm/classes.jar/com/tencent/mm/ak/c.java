package com.tencent.mm.ak;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.a.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public final class c
{
  public static int eiS = 1;
  public static int eiT = 2;
  public static int eiU = 3;
  public static int eiV = -1;
  public static int eiW = 3;
  public static int eiX = 4;
  public static int eiY = 5;
  public static int eiZ = 1;
  public static int eja = 2;
  public static int ejb = -10001;
  public static int ejc = -10002;
  public static int ejd = -10003;
  public static int eje = -10004;
  
  public static String a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    Object localObject2 = null;
    y.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3, bk.csb() });
    Object localObject1;
    if (bk.bl(lN(paramString1))) {
      localObject1 = localObject2;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (bk.bl(paramString2));
        localObject1 = localObject2;
      } while (paramLong <= 0L);
      paramString3 = bk.pm(lN(paramString3));
      paramString2 = g.o((q.Gj() + "-" + paramString2).getBytes());
      paramString1 = "a" + paramString1 + "_" + paramString2.substring(0, 16) + "_" + paramLong;
      localObject1 = paramString1;
    } while (bk.bl(paramString3));
    return paramString1 + "_" + paramString3;
  }
  
  public static int b(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      paramHttpURLConnection = (List)paramHttpURLConnection.getHeaderFields().get("cache-control");
      if ((paramHttpURLConnection != null) && (paramHttpURLConnection.size() != 0))
      {
        if (!bk.bl(paramHttpURLConnection.toString()))
        {
          boolean bool = paramHttpURLConnection.toString().contains("no-cache");
          if (bool) {}
        }
        else
        {
          return 0;
        }
        return -1;
      }
    }
    catch (Exception paramHttpURLConnection)
    {
      y.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bk.j(paramHttpURLConnection) });
      return -2;
    }
    return 0;
  }
  
  public static int bw(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return eiS;
      }
      if (paramContext.getType() == 1) {
        return eiU;
      }
      if (paramContext.getSubtype() == 1) {
        return eiS;
      }
      if (paramContext.getSubtype() == 2) {
        return eiS;
      }
      if (paramContext.getSubtype() >= 3) {
        return eiT;
      }
      int i = eiS;
      return i;
    }
    catch (NullPointerException paramContext)
    {
      y.e("MicroMsg.CdnUtil", "exception:%s", new Object[] { bk.j(paramContext) });
    }
    return eiS;
  }
  
  public static int bx(Context paramContext)
  {
    int i = aq.getNetType(paramContext);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null) {
      return eiV;
    }
    if (paramContext.getType() == 1) {
      return eiZ;
    }
    if ((paramContext.getSubtype() == 1) || (paramContext.getSubtype() == 2)) {
      return eiW;
    }
    if (paramContext.getSubtype() >= 13) {
      return eiY;
    }
    if (paramContext.getSubtype() >= 3) {
      return eiX;
    }
    if (aq.isWap(i)) {
      return eja;
    }
    return eiW;
  }
  
  private static String lN(String paramString)
  {
    String str = paramString;
    int i;
    if (!bk.bl(paramString)) {
      i = 0;
    }
    for (;;)
    {
      str = paramString;
      if (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!bk.m(c)) && (!bk.n(c))) {
          str = null;
        }
      }
      else
      {
        return str;
      }
      i += 1;
    }
  }
  
  public static void outputJniLog(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (bk.bE(paramArrayOfByte)) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = new String(arrayOfByte);
    if (paramInt == 4) {
      y.e(paramString, paramArrayOfByte);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        y.w(paramString, paramArrayOfByte);
        return;
      }
      if (paramInt == 2)
      {
        y.i(paramString, paramArrayOfByte);
        return;
      }
      if (paramInt == 1)
      {
        y.d(paramString, paramArrayOfByte);
        return;
      }
    } while (paramInt != 0);
    y.v(paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.c
 * JD-Core Version:    0.7.0.1
 */