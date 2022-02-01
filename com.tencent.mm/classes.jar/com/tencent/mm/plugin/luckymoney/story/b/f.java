package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;

public final class f
  extends j<e>
{
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(199016);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "LuckyMoneyDetailOpenRecord") };
    AppMethodBeat.o(199016);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, e.info, "LuckyMoneyDetailOpenRecord", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.f
 * JD-Core Version:    0.7.0.1
 */