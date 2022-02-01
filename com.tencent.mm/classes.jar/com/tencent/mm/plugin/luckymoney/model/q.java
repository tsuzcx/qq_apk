package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class q
  extends j<p>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(65224);
    SQL_CREATE = new String[] { j.getCreateSQLs(p.info, "LuckyMoneyEnvelopeResource") };
    AppMethodBeat.o(65224);
  }
  
  public q(e parame)
  {
    super(parame, p.info, "LuckyMoneyEnvelopeResource", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.q
 * JD-Core Version:    0.7.0.1
 */