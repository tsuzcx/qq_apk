package com.tencent.mm.plugin.exdevice.g.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a.b;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c
  extends MAutoStorage<b>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(23575);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "HardDeviceProfileRankDetail") };
    AppMethodBeat.o(23575);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.info, "HardDeviceProfileRankDetail", null);
    AppMethodBeat.i(268142);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("HardDeviceProfileRankDetail", "CREATE INDEX IF NOT EXISTS ExdeviceRankDetailInfoRankIdAppNameIndex ON HardDeviceProfileRankDetail ( appusername )");
    AppMethodBeat.o(268142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.c
 * JD-Core Version:    0.7.0.1
 */