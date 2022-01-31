package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class h$a
{
  static h.a.a S(String paramString, int paramInt)
  {
    if (paramInt == 5) {
      return h.a.a.ezc;
    }
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
      return h.a.a.eyZ;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      if (localObject == null) {
        return h.a.a.ezd;
      }
      String str = bk.pm(((Uri)localObject).getHost()).toLowerCase();
      if (bk.bl(((Uri)localObject).getFragment())) {}
      for (localObject = "";; localObject = "#" + ((Uri)localObject).getFragment())
      {
        y.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, localObject });
        if ((!str.equals("open.weixin.qq.com")) && (!str.equals("mp.weixin.qq.com")) && (!str.equals("mp.weixinbridge.com"))) {
          break;
        }
        return h.a.a.eza;
      }
      if (((String)localObject).contains("wechat_pay")) {
        return h.a.a.ezb;
      }
      if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
        return h.a.a.eyZ;
      }
      paramString = h.a.a.ezd;
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
    }
    return h.a.a.eyZ;
  }
  
  static b a(h.a.a parama)
  {
    b.a locala = new b.a();
    locala.ecH = new aan();
    locala.ecI = new aao();
    switch (h.1.eyX[parama.ordinal()])
    {
    default: 
      locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
      locala.ecG = 226;
      locala.ecJ = 388;
      locala.ecK = 1000000388;
    }
    for (;;)
    {
      return locala.Kt();
      locala.uri = "/cgi-bin/micromsg-bin/geta8key";
      locala.ecG = 233;
      locala.ecJ = 155;
      locala.ecK = 1000000155;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
      locala.ecG = 238;
      locala.ecJ = 345;
      locala.ecK = 1000000345;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
      locala.ecG = 835;
      locala.ecJ = 346;
      locala.ecK = 1000000346;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
      locala.ecG = 812;
      locala.ecJ = 387;
      locala.ecK = 1000000387;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
      locala.ecG = 226;
      locala.ecJ = 388;
      locala.ecK = 1000000388;
    }
  }
  
  static b d(b paramb)
  {
    aan localaan = (aan)paramb.ecE.ecN;
    g.DQ();
    String str1 = bk.pm((String)g.DP().Dz().get(46, null));
    localaan.syq = new bmk().bs(bk.ZM(str1));
    g.DQ();
    String str2 = bk.pm((String)g.DP().Dz().get(72, null));
    localaan.sZN = new bmk().bs(bk.ZM(str2));
    y.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h.a
 * JD-Core Version:    0.7.0.1
 */