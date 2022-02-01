package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.sdk.b.a.e.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  implements b.b
{
  public final boolean arS()
  {
    AppMethodBeat.i(327769);
    int i = ((c)h.ax(c.class)).a(c.a.yGJ, 0);
    Log.i("MicroMsg.Audio.WxAudioSupportDelegateImpl", "wegame_android_use_wxaudio:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(327769);
      return true;
    }
    AppMethodBeat.o(327769);
    return false;
  }
  
  public final boolean arT()
  {
    AppMethodBeat.i(327771);
    Log.i("MicroMsg.Audio.WxAudioSupportDelegateImpl", "doCheckResUpdate");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, null, a.class, null);
    AppMethodBeat.o(327771);
    return true;
  }
  
  static final class a
    implements d<IPCVoid, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.s
 * JD-Core Version:    0.7.0.1
 */