package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class o
  extends j<n>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(42335);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "LuckyMoneyEnvelopeResource") };
    AppMethodBeat.o(42335);
  }
  
  public o(e parame)
  {
    super(parame, n.info, "LuckyMoneyEnvelopeResource", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.o
 * JD-Core Version:    0.7.0.1
 */