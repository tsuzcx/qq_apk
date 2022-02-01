package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

final class j$a
  implements j.b
{
  public final void EW(long paramLong)
  {
    AppMethodBeat.i(146331);
    Log.v("Luggage.RecordStat", "ID:%d, key:%d, val:%d, isImportant:%b", new Object[] { Long.valueOf(689L), Long.valueOf(paramLong), Long.valueOf(1L), Boolean.TRUE });
    AppMethodBeat.o(146331);
  }
  
  public final void K(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(146332);
    Log.v("Luggage.RecordStat", "lstIdKeyDataInfos:%s, isImportant:%b", new Object[] { paramArrayList, Boolean.TRUE });
    AppMethodBeat.o(146332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.j.a
 * JD-Core Version:    0.7.0.1
 */