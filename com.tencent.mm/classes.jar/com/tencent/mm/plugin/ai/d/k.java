package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class k
  extends a<j>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(267404);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.info, "WechatSessionHistory") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(267404);
  }
  
  public k(o.a parama)
  {
    super(parama, j.info, "WechatSessionHistory", INDEX_CREATE);
  }
  
  public final boolean a(j paramj)
  {
    AppMethodBeat.i(267424);
    boolean bool = super.insertNotify(paramj, false);
    AppMethodBeat.o(267424);
    return bool;
  }
  
  public final int caF()
  {
    return 7;
  }
  
  public final String caG()
  {
    return "ds";
  }
  
  public final String tableName()
  {
    return "WechatSessionHistory";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.k
 * JD-Core Version:    0.7.0.1
 */