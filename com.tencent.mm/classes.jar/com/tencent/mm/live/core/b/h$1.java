package com.tencent.mm.live.core.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
final class h$1
  implements MMHandler.Callback
{
  h$1(h paramh) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(196667);
    if (paramMessage.what == 1024)
    {
      h localh = this.hEk;
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new t("null cannot be cast to non-null type com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame");
        AppMethodBeat.o(196667);
        throw paramMessage;
      }
      h.a(localh, (TRTCCloudDef.TRTCVideoFrame)paramMessage);
    }
    AppMethodBeat.o(196667);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.b.h.1
 * JD-Core Version:    0.7.0.1
 */