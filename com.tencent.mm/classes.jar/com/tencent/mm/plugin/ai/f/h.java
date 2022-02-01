package com.tencent.mm.plugin.ai.f;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class h
  extends MAutoStorage<g>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private r.a nqN;
  private int nqO;
  
  static
  {
    AppMethodBeat.i(240461);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(g.info, "WechatSessionHistory") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(240461);
  }
  
  public h(r.a parama, int paramInt)
  {
    super(parama, g.info, "WechatSessionHistory", INDEX_CREATE);
    AppMethodBeat.i(240444);
    this.nqO = 0;
    this.nqN = parama;
    this.nqO = paramInt;
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240114);
        h.a(h.this);
        AppMethodBeat.o(240114);
      }
    });
    AppMethodBeat.o(240444);
  }
  
  public final boolean a(g paramg)
  {
    AppMethodBeat.i(240449);
    boolean bool = super.insertNotify(paramg, false);
    AppMethodBeat.o(240449);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.h
 * JD-Core Version:    0.7.0.1
 */