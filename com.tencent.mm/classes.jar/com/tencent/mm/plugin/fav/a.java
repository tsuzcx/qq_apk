package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public final class a
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
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
      paramString = new gs();
      paramString.dkc.type = 38;
      paramString.dkc.dkl = ((String)paramMap.get(".sysmsg.favids"));
      com.tencent.mm.sdk.b.a.ESL.a(paramString, Looper.getMainLooper());
      h.Ci(1);
      continue;
      paramString = new gs();
      paramString.dkc.type = 39;
      paramString.dkc.dkl = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.dkc.dkm = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      com.tencent.mm.sdk.b.a.ESL.a(paramString, Looper.getMainLooper());
      h.Ci(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */