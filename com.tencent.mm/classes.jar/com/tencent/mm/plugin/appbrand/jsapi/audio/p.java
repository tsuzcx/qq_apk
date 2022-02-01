package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.sdk.b.a.d.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  implements b.b
{
  public final boolean RE()
  {
    AppMethodBeat.i(278393);
    int i = ((b)h.ae(b.class)).a(b.a.vuf, 0);
    Log.i("MicroMsg.Audio.WxAudioSupportDelegateImpl", "wegame_android_use_wxaudio:%d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(278393);
      return true;
    }
    AppMethodBeat.o(278393);
    return false;
  }
  
  public final boolean RF()
  {
    AppMethodBeat.i(278394);
    Log.i("MicroMsg.Audio.WxAudioSupportDelegateImpl", "doCheckResUpdate");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, null, a.class, null);
    AppMethodBeat.o(278394);
    return true;
  }
  
  static final class a
    implements d<IPCVoid, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.p
 * JD-Core Version:    0.7.0.1
 */