package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  public static boolean db(Context paramContext)
  {
    if (l.bm(paramContext))
    {
      y.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
      return false;
    }
    Intent localIntent = new Intent(paramContext, ExDeviceService.class);
    localIntent.setFlags(268435456);
    paramContext.startService(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.d
 * JD-Core Version:    0.7.0.1
 */