package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;

final class p$12
  implements Runnable
{
  p$12(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(184479);
    Object localObject = (Bundle)h.a("com.tencent.mm", null, p.b.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
      com.tencent.mm.compatible.deviceinfo.ae.vE((String)localObject);
      AppMethodBeat.o(184479);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
    AppMethodBeat.o(184479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.12
 * JD-Core Version:    0.7.0.1
 */