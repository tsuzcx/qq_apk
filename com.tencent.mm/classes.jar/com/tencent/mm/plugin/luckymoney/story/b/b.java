package com.tencent.mm.plugin.luckymoney.story.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(163693);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "LocalRedPacketStoryInfo") };
    AppMethodBeat.o(163693);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "LocalRedPacketStoryInfo", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.b
 * JD-Core Version:    0.7.0.1
 */