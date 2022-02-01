package com.tencent.mm.plugin.account.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  implements n
{
  public static volatile l iUA;
  public static volatile m iUz;
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(155379);
    ae.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", new Object[] { paraml });
    iUA = paraml;
    AppMethodBeat.o(155379);
  }
  
  public final void a(m paramm)
  {
    iUz = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.a
 * JD-Core Version:    0.7.0.1
 */