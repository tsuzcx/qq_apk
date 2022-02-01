package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.y;
import java.lang.ref.WeakReference;

final class a$b
  extends a.a
{
  c jTu = null;
  b.b jTv = null;
  private VideoTransPara jTw = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.b paramb)
  {
    try
    {
      this.jTv = paramb;
      return;
    }
    finally {}
  }
  
  @SuppressLint({"DefaultLocale"})
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(45315);
    Object localObject = (MagicBrushView)this.jTt.get();
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
    this.jTw = new VideoTransPara();
    this.jTw.videoBitrate = paramb.bitrate;
    this.jTw.width = paramb.width;
    this.jTw.height = paramb.height;
    this.jTw.fps = paramb.fps;
    this.jTw.hCy = paramb.gop;
    this.jTw.hCA = 1;
    this.jTw.hCz = 2;
    this.jTw.duration = paramb.duration;
    this.jTw.audioBitrate = 64000;
    this.jTw.audioSampleRate = 44100;
    this.jTw.hCK = 200;
    ac.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.jTw });
    this.jTu = new c(this.jTw, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getAbsSurfaceRenderer(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getEGLContext(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getPreviewTextureId(), new com.tencent.mm.media.widget.c.c.a()
    {
      public final void pF(long paramAnonymousLong)
      {
        AppMethodBeat.i(45312);
        try
        {
          if (a.b.this.jTv != null) {
            a.b.this.jTv.qM(paramAnonymousLong / 1000L);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(45312);
        }
      }
    });
    if (paramb.jUm == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    if (paramb.jUl == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    ac.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    this.jTu.setMute(true);
    this.jTu.s(((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight(), this.jTw.width, this.jTw.height);
    this.jTu.setFilePath(paramb.jUm.getAbsolutePath());
    this.jTu.nE(0);
    int i = this.jTu.b(0, false, 0);
    if (i != 0)
    {
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(45315);
      return;
    }
    this.jTu.hdn = true;
    ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).setOnTextureDrawFinishDelegate(new b() {});
    ac.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45315);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(45316);
    if (this.jTu == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45316);
      return;
    }
    this.jTu.E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45314);
        ac.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.jTu.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(45314);
      }
    });
    AppMethodBeat.o(45316);
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(45317);
    if (this.jTu == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45317);
      return;
    }
    this.jTu.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45317);
  }
  
  final void bdY()
  {
    try
    {
      this.jTv = null;
      return;
    }
    finally {}
  }
  
  final VideoTransPara bdZ()
  {
    return this.jTw;
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(45318);
    if (this.jTu == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45318);
      return;
    }
    Object localObject = (MagicBrushView)this.jTt.get();
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
    this.jTu.K(0, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45318);
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(45319);
    if (this.jTu != null)
    {
      this.jTu.cancel();
      this.jTu.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */