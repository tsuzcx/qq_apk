package com.tencent.mm.plugin.account.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  implements o
{
  public static volatile n gmO;
  public static volatile m gmP;
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(73678);
    ab.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", new Object[] { paramm });
    gmP = paramm;
    AppMethodBeat.o(73678);
  }
  
  public final void a(n paramn)
  {
    gmO = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.a.a
 * JD-Core Version:    0.7.0.1
 */