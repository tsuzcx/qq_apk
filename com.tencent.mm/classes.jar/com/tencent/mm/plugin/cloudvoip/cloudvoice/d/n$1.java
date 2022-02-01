package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.sdk.platformtools.ac;

final class n$1
  implements e.a
{
  n$1(n paramn) {}
  
  public final void BE()
  {
    AppMethodBeat.i(200742);
    n localn = this.otP;
    SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
    d locald = v2protocal.AIm;
    if ((localSurfaceTexture == null) || (locald == null))
    {
      ac.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { localSurfaceTexture, locald });
      AppMethodBeat.o(200742);
      return;
    }
    if ((!localn.otN) || (localn.otL == null))
    {
      ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(locald.gRW), Boolean.valueOf(localn.otN) });
      AppMethodBeat.o(200742);
      return;
    }
    localn.otL.a(localSurfaceTexture, locald);
    ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(locald.gRW) });
    AppMethodBeat.o(200742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n.1
 * JD-Core Version:    0.7.0.1
 */