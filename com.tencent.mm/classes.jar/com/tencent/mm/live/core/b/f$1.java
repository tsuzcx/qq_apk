package com.tencent.mm.live.core.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
final class f$1
  implements aq.a
{
  f$1(f paramf) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(196981);
    if (paramMessage.what == 1024)
    {
      f localf = this.gOi;
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new v("null cannot be cast to non-null type com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame");
        AppMethodBeat.o(196981);
        throw paramMessage;
      }
      f.a(localf, (TRTCCloudDef.TRTCVideoFrame)paramMessage);
    }
    AppMethodBeat.o(196981);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.f.1
 * JD-Core Version:    0.7.0.1
 */