package com.tencent.mm.plugin.appbrand.game.g;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.game.f.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.ah;
import kotlin.g.a.b;

final class a$b
  extends a.a
{
  c rtn = null;
  b.b rto = null;
  private VideoTransPara rtp = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.b paramb)
  {
    try
    {
      this.rto = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(45315);
    Object localObject = (MagicBrushView)this.rtm.get();
    if (localObject == null)
    {
      paramd.a(1, 111, "magic brush view not found", "");
      AppMethodBeat.o(45315);
      return;
    }
    localObject = (e)((MagicBrushView)localObject).getRendererView();
    if (localObject == null)
    {
      paramd.a(1, 111, "texture view not found", "");
      AppMethodBeat.o(45315);
      return;
    }
    if (!((e)localObject).isAvailable()) {
      paramd.a(1, 111, "view not prepared", "");
    }
    this.rtp = new VideoTransPara();
    this.rtp.videoBitrate = paramb.bitrate;
    this.rtp.width = paramb.width;
    this.rtp.height = paramb.height;
    this.rtp.fps = paramb.fps;
    this.rtp.nCd = paramb.gop;
    this.rtp.oBP = 1;
    this.rtp.oBO = 2;
    this.rtp.duration = paramb.duration;
    this.rtp.audioBitrate = 64000;
    this.rtp.audioSampleRate = 44100;
    this.rtp.oCa = 200;
    Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.rtp });
    this.rtn = new c(this.rtp, ((e)localObject).getAbsSurfaceRenderer(), ((e)localObject).getEGLContext(), ((e)localObject).getPreviewTextureId(), new com.tencent.mm.media.widget.c.c.a()
    {
      public final void ik(long paramAnonymousLong)
      {
        AppMethodBeat.i(45312);
        try
        {
          if (a.b.this.rto != null) {
            a.b.this.rto.jE(paramAnonymousLong / 1000L);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(45312);
        }
      }
    });
    if (paramb.ruf == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    if (paramb.rue == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    Log.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    this.rtn.setMute(true);
    this.rtn.A(((e)localObject).getSurfaceWidth(), ((e)localObject).getSurfaceHeight(), this.rtp.width, this.rtp.height);
    this.rtn.setFilePath(paramb.ruf.coT());
    this.rtn.uw(0);
    int i = this.rtn.b(0, false, 0);
    if (i != 0)
    {
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(45315);
      return;
    }
    this.rtn.nLV = true;
    ((e)localObject).setOnTextureDrawFinishDelegate(new b() {});
    Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45315);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(45316);
    if (this.rtn == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45316);
      return;
    }
    this.rtn.J(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45314);
        Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.rtn.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(45314);
      }
    });
    AppMethodBeat.o(45316);
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(45317);
    if (this.rtn == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45317);
      return;
    }
    this.rtn.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45317);
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(45318);
    if (this.rtn == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45318);
      return;
    }
    Object localObject = (MagicBrushView)this.rtm.get();
    if (localObject == null)
    {
      paramd.a(1, 111, "magic brush view not found", "");
      AppMethodBeat.o(45318);
      return;
    }
    localObject = (e)((MagicBrushView)localObject).getRendererView();
    if (localObject == null)
    {
      paramd.a(1, 111, "texture view not found", "");
      AppMethodBeat.o(45318);
      return;
    }
    if (!((e)localObject).isAvailable()) {
      paramd.a(1, 111, "view not prepared", "");
    }
    this.rtn.ae(0, ((e)localObject).getSurfaceWidth(), ((e)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45318);
  }
  
  final void cpl()
  {
    try
    {
      this.rto = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final boolean cpm()
  {
    return true;
  }
  
  final VideoTransPara cpn()
  {
    return this.rtp;
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(45319);
    if (this.rtn != null)
    {
      this.rtn.cancel();
      this.rtn.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */