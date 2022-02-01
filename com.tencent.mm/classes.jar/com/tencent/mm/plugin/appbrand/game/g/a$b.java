package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.a.b;
import kotlin.x;

final class a$b
  extends a.a
{
  c luH = null;
  b.b luI = null;
  private VideoTransPara luJ = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.b paramb)
  {
    try
    {
      this.luI = paramb;
      return;
    }
    finally {}
  }
  
  @SuppressLint({"DefaultLocale"})
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(45315);
    Object localObject = (MagicBrushView)this.luG.get();
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
    this.luJ = new VideoTransPara();
    this.luJ.videoBitrate = paramb.bitrate;
    this.luJ.width = paramb.width;
    this.luJ.height = paramb.height;
    this.luJ.fps = paramb.fps;
    this.luJ.iiH = paramb.gop;
    this.luJ.iSV = 1;
    this.luJ.iSU = 2;
    this.luJ.duration = paramb.duration;
    this.luJ.audioBitrate = 64000;
    this.luJ.audioSampleRate = 44100;
    this.luJ.iTf = 200;
    Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.luJ });
    this.luH = new c(this.luJ, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getAbsSurfaceRenderer(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getEGLContext(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getPreviewTextureId(), new com.tencent.mm.media.widget.c.c.a()
    {
      public final void zV(long paramAnonymousLong)
      {
        AppMethodBeat.i(45312);
        try
        {
          if (a.b.this.luI != null) {
            a.b.this.luI.Bc(paramAnonymousLong / 1000L);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(45312);
        }
      }
    });
    if (paramb.lvz == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    if (paramb.lvy == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    Log.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    this.luH.setMute(true);
    this.luH.s(((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight(), this.luJ.width, this.luJ.height);
    this.luH.setFilePath(paramb.lvz.getAbsolutePath());
    this.luH.rC(0);
    int i = this.luH.b(0, false, 0);
    if (i != 0)
    {
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(45315);
      return;
    }
    this.luH.ish = true;
    ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).setOnTextureDrawFinishDelegate(new b() {});
    Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45315);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(45316);
    if (this.luH == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45316);
      return;
    }
    this.luH.E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45314);
        Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.luH.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(45314);
      }
    });
    AppMethodBeat.o(45316);
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(45317);
    if (this.luH == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45317);
      return;
    }
    this.luH.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45317);
  }
  
  final VideoTransPara bDA()
  {
    return this.luJ;
  }
  
  final void bDz()
  {
    try
    {
      this.luI = null;
      return;
    }
    finally {}
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(45318);
    if (this.luH == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45318);
      return;
    }
    Object localObject = (MagicBrushView)this.luG.get();
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
    this.luH.M(0, ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.d)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45318);
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(45319);
    if (this.luH != null)
    {
      this.luH.cancel();
      this.luH.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */