package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  private static final ThreadPoolExecutor oRM;
  
  static
  {
    AppMethodBeat.i(123226);
    oRM = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(123226);
  }
  
  public static void a(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    AppMethodBeat.i(123225);
    ad.i("MicroMsg.MsgFileMgr", "sumbit() item:%s", new Object[] { parama });
    Object localObject = null;
    switch (parama.getType())
    {
    default: 
      parama = localObject;
    }
    while (parama == null)
    {
      ad.e("MicroMsg.MsgFileMgr", "downloadTask is null, return");
      parama1.bZe();
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
      ad.e("MicroMsg.MsgFileMgr", "downloadTask is invalid, return");
      parama1.bZg();
      AppMethodBeat.o(123225);
      return;
    }
    if (!parama.bZh()) {
      oRM.submit(parama);
    }
    AppMethodBeat.o(123225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.b
 * JD-Core Version:    0.7.0.1
 */