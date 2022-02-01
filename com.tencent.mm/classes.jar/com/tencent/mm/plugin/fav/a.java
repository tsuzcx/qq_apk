package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class a
  implements p
{
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(101532);
    Log.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
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
      paramString = new hb();
      paramString.dLm.type = 38;
      paramString.dLm.dLv = ((String)paramMap.get(".sysmsg.favids"));
      EventCenter.instance.asyncPublish(paramString, Looper.getMainLooper());
      h.HT(1);
      continue;
      paramString = new hb();
      paramString.dLm.type = 39;
      paramString.dLm.dLv = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.dLm.dLw = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      EventCenter.instance.asyncPublish(paramString, Looper.getMainLooper());
      h.HT(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */