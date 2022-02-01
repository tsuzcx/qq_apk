package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.y;
import java.lang.ref.WeakReference;

final class a$b
  extends a.a
{
  c jta = null;
  b.b jtb = null;
  private VideoTransPara jtc = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.b paramb)
  {
    try
    {
      this.jtb = paramb;
      return;
    }
    finally {}
  }
  
  @SuppressLint({"DefaultLocale"})
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(45315);
    Object localObject = (MagicBrushView)this.jsZ.get();
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
    this.jtc = new VideoTransPara();
    this.jtc.videoBitrate = paramb.bitrate;
    this.jtc.width = paramb.width;
    this.jtc.height = paramb.height;
    this.jtc.fps = paramb.fps;
    this.jtc.hbW = paramb.gop;
    this.jtc.hbY = 1;
    this.jtc.hbX = 2;
    this.jtc.duration = paramb.duration;
    this.jtc.audioBitrate = 64000;
    this.jtc.audioSampleRate = 44100;
    this.jtc.hci = 200;
    ad.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.jtc });
    this.jta = new c(this.jtc, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getAbsSurfaceRenderer(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getEGLContext(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getPreviewTextureId(), new com.tencent.mm.media.widget.c.c.a()
    {
      public final void lR(long paramAnonymousLong)
      {
        AppMethodBeat.i(45312);
        try
        {
          if (a.b.this.jtb != null) {
            a.b.this.jtb.mY(paramAnonymousLong / 1000L);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(45312);
        }
      }
    });
    if (paramb.jtR == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    if (paramb.jtQ == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    ad.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    this.jta.setMute(true);
    this.jta.s(((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight(), this.jtc.width, this.jtc.height);
    this.jta.setFilePath(paramb.jtR.getAbsolutePath());
    this.jta.mQ(0);
    int i = this.jta.b(0, false, 0);
    if (i != 0)
    {
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(45315);
      return;
    }
    this.jta.gCP = true;
    ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).setOnTextureDrawFinishDelegate(new b() {});
    ad.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45315);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(45316);
    if (this.jta == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45316);
      return;
    }
    this.jta.C(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45314);
        ad.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.jta.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(45314);
      }
    });
    AppMethodBeat.o(45316);
  }
  
  final void aXa()
  {
    try
    {
      this.jtb = null;
      return;
    }
    finally {}
  }
  
  final VideoTransPara aXb()
  {
    return this.jtc;
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(45317);
    if (this.jta == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45317);
      return;
    }
    this.jta.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45317);
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(45318);
    if (this.jta == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45318);
      return;
    }
    Object localObject = (MagicBrushView)this.jsZ.get();
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
    this.jta.J(0, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45318);
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(45319);
    if (this.jta != null)
    {
      this.jta.cancel();
      this.jta.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */