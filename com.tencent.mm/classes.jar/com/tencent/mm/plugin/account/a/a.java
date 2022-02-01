package com.tencent.mm.plugin.account.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  implements m
{
  public static volatile l iyx;
  public static volatile k iyy;
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(155379);
    ac.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", new Object[] { paramk });
    iyy = paramk;
    AppMethodBeat.o(155379);
  }
  
  public final void a(l paraml)
  {
    iyx = paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.a
 * JD-Core Version:    0.7.0.1
 */