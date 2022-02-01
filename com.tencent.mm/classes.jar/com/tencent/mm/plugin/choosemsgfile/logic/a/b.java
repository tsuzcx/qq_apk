package com.tencent.mm.plugin.choosemsgfile.logic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  private static final ThreadPoolExecutor wPr;
  
  static
  {
    AppMethodBeat.i(123226);
    wPr = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(123226);
  }
  
  public static void a(com.tencent.mm.plugin.choosemsgfile.logic.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    AppMethodBeat.i(123225);
    Log.i("MicroMsg.MsgFileMgr", "sumbit() item:%s", new Object[] { parama });
    Object localObject = null;
    switch (parama.getType())
    {
    default: 
      parama = localObject;
    }
    while (parama == null)
    {
      Log.e("MicroMsg.MsgFileMgr", "downloadTask is null, return");
      parama1.dqj();
      AppMethodBeat.o(123225);
      return;
      parama = new e(parama, parama1, paramb);
      continue;
      parama = new f(parama, parama1, paramb);
      continue;
      parama = new g(parama, parama1, paramb);
      continue;
      parama = new d(parama, parama1, paramb);
    }
    if (!parama.checkValid())
    {
      Log.e("MicroMsg.MsgFileMgr", "downloadTask is invalid, return");
      parama1.dql();
      AppMethodBeat.o(123225);
      return;
    }
    if (!parama.dqm()) {
      wPr.submit(parama);
    }
    AppMethodBeat.o(123225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.a.b
 * JD-Core Version:    0.7.0.1
 */