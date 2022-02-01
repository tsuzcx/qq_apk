package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.game.f.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.a.b;
import kotlin.x;

final class a$b
  extends a.a
{
  c opE = null;
  b.b opF = null;
  private VideoTransPara opG = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.b paramb)
  {
    try
    {
      this.opF = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(45315);
    Object localObject = (MagicBrushView)this.opD.get();
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
    this.opG = new VideoTransPara();
    this.opG.videoBitrate = paramb.bitrate;
    this.opG.width = paramb.width;
    this.opG.height = paramb.height;
    this.opG.fps = paramb.fps;
    this.opG.kXt = paramb.gop;
    this.opG.lJn = 1;
    this.opG.lJm = 2;
    this.opG.duration = paramb.duration;
    this.opG.audioBitrate = 64000;
    this.opG.audioSampleRate = 44100;
    this.opG.lJy = 200;
    Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.opG });
    this.opE = new c(this.opG, ((e)localObject).getAbsSurfaceRenderer(), ((e)localObject).getEGLContext(), ((e)localObject).getPreviewTextureId(), new com.tencent.mm.media.widget.c.c.a()
    {
      public final void Gc(long paramAnonymousLong)
      {
        AppMethodBeat.i(45312);
        try
        {
          if (a.b.this.opF != null) {
            a.b.this.opF.Ho(paramAnonymousLong / 1000L);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(45312);
        }
      }
    });
    if (paramb.oqv == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    if (paramb.oqu == null)
    {
      AppMethodBeat.o(45315);
      return;
    }
    Log.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    this.opE.setMute(true);
    this.opE.u(((e)localObject).getSurfaceWidth(), ((e)localObject).getSurfaceHeight(), this.opG.width, this.opG.height);
    this.opE.setFilePath(paramb.oqv.bOF());
    this.opE.uw(0);
    int i = this.opE.b(0, false, 0);
    if (i != 0)
    {
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(45315);
      return;
    }
    this.opE.lhl = true;
    ((e)localObject).setOnTextureDrawFinishDelegate(new b() {});
    Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45315);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(45316);
    if (this.opE == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45316);
      return;
    }
    this.opE.E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45314);
        Log.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.opE.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(45314);
      }
    });
    AppMethodBeat.o(45316);
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(45317);
    if (this.opE == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45317);
      return;
    }
    this.opE.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45317);
  }
  
  final void bOX()
  {
    try
    {
      this.opF = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final VideoTransPara bOY()
  {
    return this.opG;
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(45318);
    if (this.opE == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(45318);
      return;
    }
    Object localObject = (MagicBrushView)this.opD.get();
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
    this.opE.P(0, ((e)localObject).getSurfaceWidth(), ((e)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45318);
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(45319);
    if (this.opE != null)
    {
      this.opE.cancel();
      this.opE.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(45319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */