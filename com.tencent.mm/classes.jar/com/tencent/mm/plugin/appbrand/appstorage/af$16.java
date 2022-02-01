package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

final class af$16
  extends af.b
{
  af$16(af paramaf)
  {
    super(paramaf, (byte)0);
  }
  
  public final r v(u paramu)
  {
    AppMethodBeat.i(323165);
    if (paramu.isDirectory())
    {
      paramu = r.qMU;
      AppMethodBeat.o(323165);
      return paramu;
    }
    if (!paramu.jKS())
    {
      paramu = r.qMR;
      AppMethodBeat.o(323165);
      return paramu;
    }
    int i = FileUnlink.Wv(ah.v(paramu.mUri));
    if (i != 0) {
      Log.e("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", new Object[] { Integer.valueOf(i), ah.v(paramu.mUri) });
    }
    if (i == 0)
    {
      paramu = r.qML;
      AppMethodBeat.o(323165);
      return paramu;
    }
    paramu = r.qMM;
    AppMethodBeat.o(323165);
    return paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.af.16
 * JD-Core Version:    0.7.0.1
 */