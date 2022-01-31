package com.tencent.mm.ag;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

public final class b
{
  public static boolean M(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    h localh2 = o.Kh().kp(paramString);
    if ((localh2 != null) && (paramString.equals(localh2.getUsername())) && (paramInt == localh2.cCq)) {
      return true;
    }
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h();
    }
    localh1.username = paramString;
    localh1.cCq = paramInt;
    localh1.bcw = 3;
    return o.Kh().a(localh1);
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((bk.bl(paramString)) || (!g.DN().Dc())) {
      return null;
    }
    if (!g.DP().DC()) {
      return o.JQ().bv(ae.getContext());
    }
    String str = paramString;
    if (ad.hd(paramString)) {
      str = ad.aaZ(paramString);
    }
    return o.Kj().b(str, paramBoolean, paramInt);
  }
  
  public static h a(String paramString, axd paramaxd)
  {
    h localh = new h();
    localh.bcw = -1;
    localh.username = paramString;
    localh.ebS = paramaxd.sLE;
    localh.ebT = paramaxd.sLD;
    y.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.JX(), localh.JY() });
    boolean bool;
    if (paramaxd.ttp != 0)
    {
      bool = true;
      localh.bK(bool);
      if ((paramaxd.ttk != 3) && (paramaxd.ttk != 4)) {
        break label111;
      }
      localh.cCq = paramaxd.ttk;
    }
    label111:
    do
    {
      do
      {
        return localh;
        bool = false;
        break;
      } while (paramaxd.ttk != 2);
      localh.cCq = 3;
    } while (q.Gj().equals(paramString));
    o.JQ();
    d.B(paramString, false);
    o.JQ();
    d.B(paramString, true);
    o.Kj().kb(paramString);
    return localh;
  }
  
  public static String ah(String paramString1, String paramString2)
  {
    return paramString1 + "?access_token=" + paramString2;
  }
  
  private static String bF(long paramLong)
  {
    return new com.tencent.mm.a.o(paramLong) + "@qqim";
  }
  
  public static Bitmap bG(long paramLong)
  {
    return a(bF(paramLong), false, -1);
  }
  
  public static Bitmap c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((bk.bl(paramString)) || (!g.DN().Dc())) {
      paramString = null;
    }
    Object localObject;
    do
    {
      return paramString;
      o.JQ();
      y.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (bk.bl(paramString)) {}
      for (localObject = null; localObject == null; localObject = com.tencent.mm.sdk.platformtools.c.a(d.z(paramString, true), paramInt1, paramInt2, null, 0, new int[] { 0, 1 }))
      {
        localObject = new e();
        ((e)localObject).a(paramString, new e.b()
        {
          public final int bl(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            this.eba.JU();
            y.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            return 0;
          }
        });
        return a(paramString, false, paramInt3);
      }
      paramString = (String)localObject;
    } while (paramInt3 <= 5);
    return com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject, false, paramInt3);
  }
  
  public static boolean c(long paramLong, int paramInt)
  {
    if (paramInt != 3) {
      return false;
    }
    return jX(bF(paramLong));
  }
  
  public static Bitmap jR(String paramString)
  {
    return a(paramString + "@google", false, -1);
  }
  
  private static String jS(String paramString)
  {
    return "http://graph.facebook.com/" + paramString + "/picture";
  }
  
  public static void jT(String paramString)
  {
    if (bk.bl(paramString)) {}
    String str;
    h localh2;
    do
    {
      return;
      str = paramString + "@fb";
      localh2 = o.Kh().kp(str);
    } while ((localh2 != null) && (str.equals(localh2.getUsername())) && (3 == localh2.cCq));
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h();
    }
    localh1.username = str;
    localh1.cCq = 3;
    localh1.ebT = jS(paramString);
    localh1.ebS = jS(paramString);
    localh1.bK(true);
    localh1.bcw = 31;
    o.Kh().a(localh1);
  }
  
  public static Bitmap jU(String paramString)
  {
    return a(paramString + "@fb", false, -1);
  }
  
  public static long jV(String paramString)
  {
    if (!ad.aaW(paramString)) {
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bk.getLong(paramString[0], -1L);
      return l;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  public static long jW(String paramString)
  {
    if (!ad.aaT(paramString)) {
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bk.getLong(paramString[0], -1L);
      return l;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  public static boolean jX(String paramString)
  {
    if (paramString == null)
    {
      y.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      y.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      return false;
    }
    h localh = new h();
    localh.username = paramString;
    localh.cCq = 3;
    localh.bcw = 3;
    return o.Kh().a(localh);
  }
  
  public static Bitmap jY(String paramString)
  {
    return a(paramString, false, -1);
  }
  
  public static String jZ(String paramString)
  {
    if ((bk.bl(paramString)) || (!g.DN().Dc())) {}
    while (!g.DP().DC()) {
      return null;
    }
    if (ad.hd(paramString))
    {
      o.JQ();
      return d.z(ad.aaZ(paramString), false);
    }
    o.JQ();
    return d.z(paramString, false);
  }
  
  public static void ka(String paramString)
  {
    h localh = o.Kh().kp(paramString);
    if (localh == null) {}
    while (!paramString.equals(localh.getUsername())) {
      return;
    }
    localh.ebV = 0;
    localh.bcw = 64;
    o.Kh().a(localh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.b
 * JD-Core Version:    0.7.0.1
 */