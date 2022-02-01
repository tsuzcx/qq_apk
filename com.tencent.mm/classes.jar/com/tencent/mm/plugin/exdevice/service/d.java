package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
{
  public static boolean eJ(Context paramContext)
  {
    AppMethodBeat.i(23644);
    if (l.co(paramContext))
    {
      ae.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(23644);
      return false;
    }
    paramContext = new Intent(paramContext, ExDeviceService.class);
    paramContext.setFlags(268435456);
    com.tencent.mm.br.d.l(paramContext, "exdevice");
    AppMethodBeat.o(23644);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.d
 * JD-Core Version:    0.7.0.1
 */