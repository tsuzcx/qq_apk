package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bp;

public final class i
{
  public static void di(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14392);
    if ((ab.getLogLevel() == 0) && (bp.dud())) {
      al.d(new i.1(paramString2));
    }
    ab.i(paramString1, paramString2);
    AppMethodBeat.o(14392);
  }
  
  public static void showToast(String paramString)
  {
    AppMethodBeat.i(14391);
    di("MicroMsg.PreloadUtil", paramString);
    AppMethodBeat.o(14391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.i
 * JD-Core Version:    0.7.0.1
 */