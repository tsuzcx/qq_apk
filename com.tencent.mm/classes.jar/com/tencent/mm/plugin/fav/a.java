package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public final class a
  implements p
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(101532);
    ad.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
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
      AppMethodBeat.o(101532);
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
      paramString = new gw();
      paramString.dsV.type = 38;
      paramString.dsV.dte = ((String)paramMap.get(".sysmsg.favids"));
      com.tencent.mm.sdk.b.a.IbL.a(paramString, Looper.getMainLooper());
      h.DV(1);
      continue;
      paramString = new gw();
      paramString.dsV.type = 39;
      paramString.dsV.dte = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.dsV.dtf = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      com.tencent.mm.sdk.b.a.IbL.a(paramString, Looper.getMainLooper());
      h.DV(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */