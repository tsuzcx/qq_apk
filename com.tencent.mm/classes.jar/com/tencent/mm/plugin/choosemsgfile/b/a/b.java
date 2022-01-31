package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  private static final ThreadPoolExecutor iGX;
  
  static
  {
    AppMethodBeat.i(54254);
    iGX = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(54254);
  }
  
  public static void a(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    AppMethodBeat.i(54253);
    com.tencent.luggage.g.d.i("MicroMsg.MsgFileMgr", "sumbit() item:%s", new Object[] { parama });
    Object localObject = null;
    switch (parama.getType())
    {
    default: 
      parama = localObject;
    }
    while (parama == null)
    {
      com.tencent.luggage.g.d.e("MicroMsg.MsgFileMgr", "downloadTask is null, return");
      parama1.bgc();
      AppMethodBeat.o(54253);
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
      com.tencent.luggage.g.d.e("MicroMsg.MsgFileMgr", "downloadTask is invalid, return");
      parama1.bge();
      AppMethodBeat.o(54253);
      return;
    }
    if (!parama.bgf()) {
      iGX.submit(parama);
    }
    AppMethodBeat.o(54253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.b
 * JD-Core Version:    0.7.0.1
 */