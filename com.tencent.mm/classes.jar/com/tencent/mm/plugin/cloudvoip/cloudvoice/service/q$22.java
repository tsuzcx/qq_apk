package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class q$22
  implements Runnable
{
  q$22(q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(268333);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "wechat VoIP call is coming and broken. exit room if in room");
    q.a(this.wVY, q.a.wWQ);
    AppMethodBeat.o(268333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.22
 * JD-Core Version:    0.7.0.1
 */