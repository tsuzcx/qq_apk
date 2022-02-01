package com.tencent.mm.media.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
final class a$b
  implements MMHandler.Callback
{
  a$b(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(93472);
    if (paramMessage.what == 1024)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.media.codec.MediaCodecAACCodec.EncoderData");
        AppMethodBeat.o(93472);
        throw paramMessage;
      }
      paramMessage = (a.a)paramMessage;
      Log.i(this.ids.TAG, "start encode data " + paramMessage.data.length + ", pts:" + paramMessage.pts + ", isLast: " + paramMessage.idt);
      com.tencent.mm.media.e.a locala = this.ids.icY;
      if (locala == null) {
        p.btv("mAudioEncoder");
      }
      locala.b(paramMessage.data, paramMessage.pts, paramMessage.idt);
    }
    AppMethodBeat.o(93472);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.a.a.b
 * JD-Core Version:    0.7.0.1
 */