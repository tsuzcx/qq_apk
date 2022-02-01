package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.Log;

final class q$12
  implements Runnable
{
  q$12(q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(184479);
    Object localObject = (Bundle)j.a(q.access$100(), null, q.b.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      Log.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
      af.KN((String)localObject);
      AppMethodBeat.o(184479);
      return;
    }
    Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
    AppMethodBeat.o(184479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.12
 * JD-Core Version:    0.7.0.1
 */