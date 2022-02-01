package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.z;
import java.lang.ref.WeakReference;

final class a$b
  extends a.a
{
  c kqY = null;
  b.b kqZ = null;
  private VideoTransPara kra = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.b paramb)
  {
    try
    {
      this.kqZ = paramb;
      return;
    }
    finally {}
  }
  
  @SuppressLint({"DefaultLocale"})
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(45315);
    Object localObject = (MagicBrushView)this.kqX.get();
    if (localObject == null)
    {
      paramd.a(1, 111, "magic brush view not found", "");
      AppMethodBeat.o(45315);
      return;
    }
    localObject = (com.tencent.mm.plugin.appbrand.game.f.a.d)((MagicBrushView)localObject).getRendererView();
    if (localObject == null)
    {
      paramd.a(1, 111, "texture view not found", "");
      AppMethodBeat.o(45315);
      return;
    }
    if (!((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).isAvailable()) {
      paramd.a(1, 111, "view not prepared", "");
    }
    this.kra = new VideoTransPara();
    this.kra.videoBitrate = paramb.bitrate;
    this.kra.width = paramb.width;
    this.kra.height = paramb.height;
    this.kra.fps = paramb.fps;
    this.kra.hpl = paramb.gop;
    this.kra.hXX = 1;
    this.kra.hXW = 2;
    this.kra.duration = paramb.duration;
    this.kra.audioBitrate = 64000;
    this.kra.audioSampleRate = 44100;
    this.kra.hYh = 200;
    ae.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.kra });
    this.kqY = new c(this.kra, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getAbsSurfaceRenderer(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getEGLContext(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getPreviewTextureId(), new com.tencent.mm.media.widget.c.c.a()
    {
      public final void rR(long paramAnonymousLong)
      {
        AppMethodBeat.i(45312);
        try
        {
          if (a.b.this.kqZ != null) {
            a.b.this.kqZ.sX(paramAnonymousLong / 1000L);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(45312);
        }
      }
    });
    if (paramb.krQ == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    if (paramb.krP == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    ae.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    this.kqY.setMute(true);
    this.kqY.s(((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight(), this.kra.width, this.kra.height);
    this.kqY.setFilePath(paramb.krQ.getAbsolutePath());
    this.kqY.og(0);
    int i = this.kqY.b(0, false, 0);
    if (i != 0)
    {
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(45315);
      return;
    }
    this.kqY.hyj = true;
    ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).setOnTextureDrawFinishDelegate(new b() {});
    ae.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45315);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(45316);
    if (this.kqY == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45316);
      return;
    }
    this.kqY.B(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45314);
        ae.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.kqY.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(45314);
      }
    });
    AppMethodBeat.o(45316);
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(45317);
    if (this.kqY == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45317);
      return;
    }
    this.kqY.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45317);
  }
  
  final void bik()
  {
    try
    {
      this.kqZ = null;
      return;
    }
    finally {}
  }
  
  final VideoTransPara bil()
  {
    return this.kra;
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(45318);
    if (this.kqY == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45318);
      return;
    }
    Object localObject = (MagicBrushView)this.kqX.get();
    if (localObject == null)
    {
      paramd.a(1, 111, "magic brush view not found", "");
      AppMethodBeat.o(45318);
      return;
    }
    localObject = (com.tencent.mm.plugin.appbrand.game.f.a.d)((MagicBrushView)localObject).getRendererView();
    if (localObject == null)
    {
      paramd.a(1, 111, "texture view not found", "");
      AppMethodBeat.o(45318);
      return;
    }
    if (!((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).isAvailable()) {
      paramd.a(1, 111, "view not prepared", "");
    }
    this.kqY.L(0, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45318);
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(45319);
    if (this.kqY != null)
    {
      this.kqY.cancel();
      this.kqY.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */