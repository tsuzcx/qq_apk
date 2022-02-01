package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class a
  implements s
{
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
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
      paramString = new ht();
      paramString.hIR.type = 38;
      paramString.hIR.hJa = ((String)paramMap.get(".sysmsg.favids"));
      paramString.asyncPublish(Looper.getMainLooper());
      h.MA(1);
      continue;
      paramString = new ht();
      paramString.hIR.type = 39;
      paramString.hIR.hJa = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.hIR.hJb = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      paramString.asyncPublish(Looper.getMainLooper());
      h.MA(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */