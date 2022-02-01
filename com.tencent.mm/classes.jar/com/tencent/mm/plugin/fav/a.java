package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class a
  implements p
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(101532);
    ae.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
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
      paramString = new gx();
      paramString.dub.type = 38;
      paramString.dub.duk = ((String)paramMap.get(".sysmsg.favids"));
      com.tencent.mm.sdk.b.a.IvT.a(paramString, Looper.getMainLooper());
      h.Ei(1);
      continue;
      paramString = new gx();
      paramString.dub.type = 39;
      paramString.dub.duk = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.dub.dul = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      com.tencent.mm.sdk.b.a.IvT.a(paramString, Looper.getMainLooper());
      h.Ei(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */