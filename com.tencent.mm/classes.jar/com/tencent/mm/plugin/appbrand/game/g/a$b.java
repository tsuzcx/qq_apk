package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.z;
import java.lang.ref.WeakReference;

final class a$b
  extends a.a
{
  c knI = null;
  b.b knJ = null;
  private VideoTransPara knK = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.b paramb)
  {
    try
    {
      this.knJ = paramb;
      return;
    }
    finally {}
  }
  
  @SuppressLint({"DefaultLocale"})
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(45315);
    Object localObject = (MagicBrushView)this.knH.get();
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
    this.knK = new VideoTransPara();
    this.knK.videoBitrate = paramb.bitrate;
    this.knK.width = paramb.width;
    this.knK.height = paramb.height;
    this.knK.fps = paramb.fps;
    this.knK.hmx = paramb.gop;
    this.knK.hVf = 1;
    this.knK.hVe = 2;
    this.knK.duration = paramb.duration;
    this.knK.audioBitrate = 64000;
    this.knK.audioSampleRate = 44100;
    this.knK.hVp = 200;
    ad.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.knK });
    this.knI = new c(this.knK, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getAbsSurfaceRenderer(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getEGLContext(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getPreviewTextureId(), new com.tencent.mm.media.widget.c.c.a()
    {
      public final void rE(long paramAnonymousLong)
      {
        AppMethodBeat.i(45312);
        try
        {
          if (a.b.this.knJ != null) {
            a.b.this.knJ.sK(paramAnonymousLong / 1000L);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(45312);
        }
      }
    });
    if (paramb.koA == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    if (paramb.koz == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    ad.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    this.knI.setMute(true);
    this.knI.s(((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight(), this.knK.width, this.knK.height);
    this.knI.setFilePath(paramb.koA.getAbsolutePath());
    this.knI.od(0);
    int i = this.knI.b(0, false, 0);
    if (i != 0)
    {
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(45315);
      return;
    }
    this.knI.hvv = true;
    ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).setOnTextureDrawFinishDelegate(new b() {});
    ad.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45315);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(45316);
    if (this.knI == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45316);
      return;
    }
    this.knI.D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45314);
        ad.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.knI.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(45314);
      }
    });
    AppMethodBeat.o(45316);
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(45317);
    if (this.knI == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45317);
      return;
    }
    this.knI.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45317);
  }
  
  final void bhC()
  {
    try
    {
      this.knJ = null;
      return;
    }
    finally {}
  }
  
  final VideoTransPara bhD()
  {
    return this.knK;
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(45318);
    if (this.knI == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45318);
      return;
    }
    Object localObject = (MagicBrushView)this.knH.get();
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
    this.knI.L(0, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45318);
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(45319);
    if (this.knI != null)
    {
      this.knI.cancel();
      this.knI.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */