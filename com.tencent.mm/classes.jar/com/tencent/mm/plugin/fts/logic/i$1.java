package com.tencent.mm.plugin.fts.logic;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class i$1
  implements com.tencent.mm.am.h
{
  i$1(i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(52766);
    if ((paramp instanceof i.c))
    {
      paramp = (i.c)paramp;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        List localList = paramp.XRr;
        if (paramInt2 == -44)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(1));
          HashMap localHashMap = new HashMap();
          localHashMap.put((String)localList.get(0), Integer.valueOf(0));
          paramp = new i.c(this.Hws, localList, localLinkedList, "你好，我是珍惜", paramp.pPi, localHashMap, paramp.pPi);
          com.tencent.mm.kernel.h.aZW().a(paramp, 0);
        }
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
        AppMethodBeat.o(52766);
        return;
      }
      Log.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[] { paramp.XRr.toString() });
    }
    AppMethodBeat.o(52766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.i.1
 * JD-Core Version:    0.7.0.1
 */