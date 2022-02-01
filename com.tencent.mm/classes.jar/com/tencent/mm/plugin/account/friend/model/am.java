package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class am
  extends MAutoStorage<o>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(184428);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(o.info, "OldAccountFriend") };
    AppMethodBeat.o(184428);
  }
  
  public am(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, o.info, "OldAccountFriend", null);
    this.db = paramISQLiteDatabase;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.am
 * JD-Core Version:    0.7.0.1
 */