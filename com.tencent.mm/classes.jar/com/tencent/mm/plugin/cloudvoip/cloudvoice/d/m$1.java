package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class m$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(184467);
    PlatformComm.init(MMApplicationContext.getContext(), new Handler(Looper.getMainLooper()));
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "PlatformComm.init finish");
    AppMethodBeat.o(184467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m.1
 * JD-Core Version:    0.7.0.1
 */