package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] lqL;
  private final boolean omY;
  
  static
  {
    AppMethodBeat.i(45098);
    lqL = new String[] { MAutoStorage.getCreateSQLs(a.info, "WxagGameInfo") };
    AppMethodBeat.o(45098);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "WxagGameInfo", null);
    AppMethodBeat.i(45096);
    if (paramISQLiteDatabase != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.omY = bool;
      if (!this.omY) {
        Log.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
      }
      AppMethodBeat.o(45096);
      return;
    }
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(45097);
    add("MicroMsg.MiniGameInfoStorage.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(45097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.b
 * JD-Core Version:    0.7.0.1
 */