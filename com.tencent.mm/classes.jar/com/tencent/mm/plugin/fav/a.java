package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

public final class a
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(101532);
    ac.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
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
      paramString = new gt();
      paramString.dhx.type = 38;
      paramString.dhx.dhG = ((String)paramMap.get(".sysmsg.favids"));
      com.tencent.mm.sdk.b.a.GpY.a(paramString, Looper.getMainLooper());
      h.Dd(1);
      continue;
      paramString = new gt();
      paramString.dhx.type = 39;
      paramString.dhx.dhG = ((String)paramMap.get(".sysmsg.favitem.favid"));
      paramString.dhx.dhH = ((String)paramMap.get(".sysmsg.favitem.dataidlist"));
      com.tencent.mm.sdk.b.a.GpY.a(paramString, Looper.getMainLooper());
      h.Dd(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a
 * JD-Core Version:    0.7.0.1
 */