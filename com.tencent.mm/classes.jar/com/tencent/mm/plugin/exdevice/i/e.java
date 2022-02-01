package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<d>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(274557);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(d.info, "HardIotCdnInfo") };
    AppMethodBeat.o(274557);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.info, "HardIotCdnInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean lN(long paramLong)
  {
    AppMethodBeat.i(274560);
    if (this.db.delete("HardIotCdnInfo", "msgid=?", new String[] { String.valueOf(paramLong) }) <= 0)
    {
      Log.i("MicroMsg.exdevice.HardIotCdnInfoStorage", "delete HardIotCdnInfo fail, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(274560);
      return false;
    }
    Log.i("MicroMsg.exdevice.HardIotCdnInfoStorage", "delete HardIotCdnInfo ok, msgId = %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(274560);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.e
 * JD-Core Version:    0.7.0.1
 */