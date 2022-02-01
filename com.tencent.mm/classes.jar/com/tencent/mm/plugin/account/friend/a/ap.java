package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ap
  extends j<r>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(184428);
    SQL_CREATE = new String[] { j.getCreateSQLs(r.info, "OldAccountFriend") };
    AppMethodBeat.o(184428);
  }
  
  public ap(e parame)
  {
    super(parame, r.info, "OldAccountFriend", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ap
 * JD-Core Version:    0.7.0.1
 */