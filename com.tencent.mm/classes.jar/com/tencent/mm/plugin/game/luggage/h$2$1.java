package com.tencent.mm.plugin.game.luggage;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class h$2$1
  implements Runnable
{
  h$2$1(h.2 param2, String paramString, Map paramMap) {}
  
  public final void run()
  {
    this.kMX.kMU.kMT = this.kMW;
    String str1;
    String str2;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.kME != null)
    {
      str1 = "." + bk.aai(this.kMW);
      str2 = bk.aai(this.kMW);
      c.il(ae.getContext());
      localObject1 = b.cSe();
      localObject2 = this.kME.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((b)localObject1).setCookie(str2, (String)localObject3 + "=" + (String)this.kME.get(localObject3));
      }
      if (!bk.bl(this.kMX.kMU.kMT))
      {
        localObject2 = Uri.parse(this.kMX.kMU.kMT).getQueryParameter("pass_ticket");
        if (!bk.bl((String)localObject2))
        {
          ((b)localObject1).setCookie(str2, "pass_ticket=" + (String)localObject2);
          ((b)localObject1).setCookie(str1, "pass_ticket=" + (String)localObject2);
        }
      }
      ((b)localObject1).setCookie(str2, "httponly");
      ((b)localObject1).setCookie(str1, "httponly");
      c.cSg();
      c.sync();
      y.i("MicroMsg.PreloadGameWebCore", "cookies:%s", new Object[] { ((b)localObject1).getCookie(str2) });
      this.kMX.kMU.kMz = true;
    }
    for (;;)
    {
      this.kMX.kMU.kMS = true;
      this.kMX.kMU.aYH();
      return;
      localObject1 = this.kMX.kMU.kMT;
      str1 = "." + bk.aai((String)localObject1);
      str2 = bk.aai((String)localObject1);
      localObject3 = Uri.parse((String)localObject1);
      localObject1 = ((Uri)localObject3).getQueryParameter("uin");
      localObject2 = ((Uri)localObject3).getQueryParameter("key");
      localObject3 = ((Uri)localObject3).getQueryParameter("pass_ticket");
      c.il(ae.getContext());
      b localb = b.cSe();
      if (!bk.bl((String)localObject1))
      {
        localb.setCookie(str1, "uin=" + (String)localObject1);
        localb.setCookie(str2, "uin=" + (String)localObject1);
      }
      if (!bk.bl((String)localObject2))
      {
        localb.setCookie(str1, "key=" + (String)localObject2);
        localb.setCookie(str2, "key=" + (String)localObject2);
      }
      if (!bk.bl((String)localObject3))
      {
        localb.setCookie(str1, "pass_ticket=" + (String)localObject3);
        localb.setCookie(str2, "pass_ticket=" + (String)localObject3);
      }
      localb.setCookie(str2, "httponly");
      localb.setCookie(str1, "httponly");
      c.cSg();
      c.sync();
      y.i("MicroMsg.PreloadGameWebCore", "getUinKeyFromFullUrl, cookies:%s", new Object[] { localb.getCookie(str2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.2.1
 * JD-Core Version:    0.7.0.1
 */