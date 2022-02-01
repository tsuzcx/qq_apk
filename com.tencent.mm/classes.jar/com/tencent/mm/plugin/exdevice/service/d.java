package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  public static boolean fd(Context paramContext)
  {
    AppMethodBeat.i(23644);
    if (l.cK(paramContext))
    {
      Log.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
      AppMethodBeat.o(23644);
      return false;
    }
    paramContext = new Intent(paramContext, ExDeviceService.class);
    paramContext.setFlags(268435456);
    c.m(paramContext, "exdevice");
    AppMethodBeat.o(23644);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.d
 * JD-Core Version:    0.7.0.1
 */