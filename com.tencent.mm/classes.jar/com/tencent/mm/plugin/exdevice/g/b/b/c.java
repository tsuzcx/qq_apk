package com.tencent.mm.plugin.exdevice.g.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a.b;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c
  extends MAutoStorage<b>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(23575);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "HardDeviceProfileRankDetail") };
    AppMethodBeat.o(23575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.c
 * JD-Core Version:    0.7.0.1
 */