package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;

final class PluginOpenIM$10
  implements h.b
{
  public final String[] getSQLs()
  {
    AppMethodBeat.i(235734);
    Log.i("MicroMsg.PluginOpenIM", "OpenIMFinderInfoNew_TABLE " + h.SQL_CREATE[0]);
    String[] arrayOfString = h.SQL_CREATE;
    AppMethodBeat.o(235734);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM.10
 * JD-Core Version:    0.7.0.1
 */