package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ap
  extends MAutoStorage<r>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(184428);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(r.info, "OldAccountFriend") };
    AppMethodBeat.o(184428);
  }
  
  public ap(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, r.info, "OldAccountFriend", null);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ap
 * JD-Core Version:    0.7.0.1
 */