package com.tencent.mm.plugin.account.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  implements m
{
  public static volatile l hYt;
  public static volatile k hYu;
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(155379);
    ad.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", new Object[] { paramk });
    hYu = paramk;
    AppMethodBeat.o(155379);
  }
  
  public final void a(l paraml)
  {
    hYt = paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.a
 * JD-Core Version:    0.7.0.1
 */