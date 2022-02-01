package com.tencent.mm.plugin.fts.b;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class g$1
  implements i
{
  g$1(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(52766);
    if ((paramq instanceof g.c))
    {
      paramq = (g.c)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        List localList = paramq.JVj;
        if (paramInt2 == -44)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(1));
          HashMap localHashMap = new HashMap();
          localHashMap.put(localList.get(0), Integer.valueOf(0));
          paramq = new g.c(this.wZx, localList, localLinkedList, "你好，我是珍惜", paramq.wZz, localHashMap, paramq.wZz);
          com.tencent.mm.kernel.g.azz().a(paramq, 0);
        }
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
        }
        AppMethodBeat.o(52766);
        return;
      }
      Log.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[] { paramq.JVj.toString() });
    }
    AppMethodBeat.o(52766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g.1
 * JD-Core Version:    0.7.0.1
 */