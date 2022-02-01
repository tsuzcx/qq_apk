package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class a
  implements s
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
      paramString = new hi();
      paramString.fEb.type = 38;
      paramString.fEb.fEk = ((String)paramMap.get(".sysmsg.favids"));
      EventCenter.instance.asyncPublish(paramString, Looper.getMainLooper());
      h.LD(1);
      continue;
      paramString = new hi();
      paramString.fEb.type = 39;
      paramString.fEb.fEk = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.fEb.fEl = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      EventCenter.instance.asyncPublish(paramString, Looper.getMainLooper());
      h.LD(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */