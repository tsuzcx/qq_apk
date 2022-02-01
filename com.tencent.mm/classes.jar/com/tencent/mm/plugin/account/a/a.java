package com.tencent.mm.plugin.account.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements n
{
  public static volatile m jRt;
  public static volatile l jRu;
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(155379);
    Log.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", new Object[] { paraml });
    jRu = paraml;
    AppMethodBeat.o(155379);
  }
  
  public final void a(m paramm)
  {
    jRt = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.a
 * JD-Core Version:    0.7.0.1
 */