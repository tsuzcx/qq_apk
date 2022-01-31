package com.tencent.mm.media.a;

import a.f.b.j;
import a.l;
import a.v;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
final class a$b
  implements ak.a
{
  a$b(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(12816);
    if (paramMessage.what == 1024)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.media.codec.MediaCodecAACCodec.EncoderData");
        AppMethodBeat.o(12816);
        throw paramMessage;
      }
      paramMessage = (a.a)paramMessage;
      ab.i(this.eRp.TAG, "start encode data " + paramMessage.data.length + ", islast: " + paramMessage.eRq);
      com.tencent.mm.media.d.a locala = this.eRp.eQW;
      if (locala == null) {
        j.ays("mAudioEncoder");
      }
      locala.b(paramMessage.data, paramMessage.pts, paramMessage.eRq);
    }
    AppMethodBeat.o(12816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.a.a.b
 * JD-Core Version:    0.7.0.1
 */