package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  public static boolean dN(Context paramContext)
  {
    AppMethodBeat.i(19576);
    if (l.bQ(paramContext))
    {
      ab.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(19576);
      return false;
    }
    paramContext = new Intent(paramContext, ExDeviceService.class);
    paramContext.setFlags(268435456);
    com.tencent.mm.bq.d.j(paramContext, "exdevice");
    AppMethodBeat.o(19576);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.d
 * JD-Core Version:    0.7.0.1
 */