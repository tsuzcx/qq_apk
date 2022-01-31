package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class a
  implements n
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    y.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      return null;
      if (!paramString.equals("uploadfavitem")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("resendfavitem")) {
        break;
      }
      i = 1;
      break;
      paramString = new gf();
      paramString.bNF.type = 38;
      paramString.bNF.bNO = ((String)paramMap.get(".sysmsg.favids"));
      com.tencent.mm.sdk.b.a.udP.a(paramString, Looper.getMainLooper());
      h.qV(1);
      continue;
      paramString = new gf();
      paramString.bNF.type = 39;
      paramString.bNF.bNO = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.bNF.bNP = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      com.tencent.mm.sdk.b.a.udP.a(paramString, Looper.getMainLooper());
      h.qV(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */