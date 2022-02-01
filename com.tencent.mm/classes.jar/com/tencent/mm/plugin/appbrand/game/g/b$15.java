package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class b$15
  implements MediaSdk.MediaCallbacker
{
  b$15(b paramb) {}
  
  public final void onResult(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222364);
    ae.d("MicroMsg.GameRecorderMgr", "global notify, " + new String(paramArrayOfByte));
    AppMethodBeat.o(222364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.15
 * JD-Core Version:    0.7.0.1
 */