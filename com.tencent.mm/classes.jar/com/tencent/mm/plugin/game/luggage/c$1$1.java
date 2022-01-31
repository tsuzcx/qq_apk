package com.tencent.mm.plugin.game.luggage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, Map paramMap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(135823);
    String str1;
    String str2;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.njq != null)
    {
      str1 = "." + bo.aqm(this.njr);
      str2 = bo.aqm(this.njr);
      c.jQ(ah.getContext());
      localObject1 = b.dYg();
      localObject2 = this.njq.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((b)localObject1).setCookie(str2, (String)localObject3 + "=" + (String)this.njq.get(localObject3));
      }
      if (!bo.isNullOrNil(this.njr))
      {
        localObject2 = Uri.parse(this.njr).getQueryParameter("pass_ticket");
        if (!bo.isNullOrNil((String)localObject2))
        {
          ((b)localObject1).setCookie(str2, "pass_ticket=".concat(String.valueOf(localObject2)));
          ((b)localObject1).setCookie(str1, "pass_ticket=".concat(String.valueOf(localObject2)));
        }
      }
      ((b)localObject1).setCookie(str2, "httponly");
      ((b)localObject1).setCookie(str1, "httponly");
      c.dYi();
      c.sync();
      ab.i("MicroMsg.LuggageGetA8KeyUtil", "cookies:%s", new Object[] { ((b)localObject1).getCookie(str2) });
    }
    for (;;)
    {
      l.q(new c.2(this.njs.njp, this.njr));
      AppMethodBeat.o(135823);
      return;
      localObject1 = this.njr;
      str1 = "." + bo.aqm((String)localObject1);
      str2 = bo.aqm((String)localObject1);
      localObject3 = Uri.parse((String)localObject1);
      localObject1 = ((Uri)localObject3).getQueryParameter("uin");
      localObject2 = ((Uri)localObject3).getQueryParameter("key");
      localObject3 = ((Uri)localObject3).getQueryParameter("pass_ticket");
      c.jQ(ah.getContext());
      b localb = b.dYg();
      if (!bo.isNullOrNil((String)localObject1))
      {
        localb.setCookie(str1, "uin=".concat(String.valueOf(localObject1)));
        localb.setCookie(str2, "uin=".concat(String.valueOf(localObject1)));
      }
      if (!bo.isNullOrNil((String)localObject2))
      {
        localb.setCookie(str1, "key=".concat(String.valueOf(localObject2)));
        localb.setCookie(str2, "key=".concat(String.valueOf(localObject2)));
      }
      if (!bo.isNullOrNil((String)localObject3))
      {
        localb.setCookie(str1, "pass_ticket=".concat(String.valueOf(localObject3)));
        localb.setCookie(str2, "pass_ticket=".concat(String.valueOf(localObject3)));
      }
      localb.setCookie(str2, "httponly");
      localb.setCookie(str1, "httponly");
      c.dYi();
      c.sync();
      ab.i("MicroMsg.LuggageGetA8KeyUtil", "getUinKeyFromFullUrl, cookies:%s", new Object[] { localb.getCookie(str2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.1.1
 * JD-Core Version:    0.7.0.1
 */