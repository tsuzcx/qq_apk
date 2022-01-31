package com.tencent.mm.plugin.appbrand.game.g;

import a.y;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.magicbrush.MagicBrushView;
import com.tencent.magicbrush.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.lang.ref.WeakReference;

final class a$b
  extends a.a
{
  c huM = null;
  b.c huN = null;
  private VideoTransPara huO = null;
  
  a$b(MagicBrushView paramMagicBrushView)
  {
    super(paramMagicBrushView, (byte)0);
  }
  
  final void a(b.c paramc)
  {
    try
    {
      this.huN = paramc;
      return;
    }
    finally {}
  }
  
  @SuppressLint({"DefaultLocale"})
  final void a(c.b paramb, d<String> paramd)
  {
    AppMethodBeat.i(143208);
    Object localObject = (MagicBrushView)this.huL.get();
    if (localObject == null)
    {
      paramd.a(1, 111, "magic brush view not found", "");
      AppMethodBeat.o(143208);
      return;
    }
    com.tencent.mm.plugin.appbrand.game.f.a.b localb = (com.tencent.mm.plugin.appbrand.game.f.a.b)((MagicBrushView)localObject).getTextureView();
    if (localb == null)
    {
      paramd.a(1, 111, "texture view not found", "");
      AppMethodBeat.o(143208);
      return;
    }
    if (!localb.isAvailable()) {
      paramd.a(1, 111, "view not prepared", "");
    }
    this.huO = new VideoTransPara();
    this.huO.videoBitrate = paramb.bitrate;
    this.huO.width = paramb.width;
    this.huO.height = paramb.height;
    this.huO.fps = paramb.fps;
    this.huO.fzU = paramb.gop;
    this.huO.fzW = 1;
    this.huO.fzV = 2;
    this.huO.duration = paramb.duration;
    this.huO.fzT = 64000;
    this.huO.audioSampleRate = 44100;
    this.huO.fAg = 200;
    ab.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: record param is %s", new Object[] { this.huO });
    this.huM = new c(this.huO, localb.getAbsSurfaceRenderer(), localb.getEGLContext(), localb.getPreviewTextureId(), new a.b.1(this));
    if (paramb.hvy == null)
    {
      AppMethodBeat.o(143208);
      return;
    }
    if (paramb.hvx == null)
    {
      AppMethodBeat.o(143208);
      return;
    }
    localObject = ((MagicBrushView)localObject).getTextureView().getBitmap();
    if (localObject == null) {
      ab.e("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: can not get current bitmap! just a hint");
    }
    for (;;)
    {
      this.huM.setMute(true);
      this.huM.s(localb.getSurfaceWidth(), localb.getSurfaceHeight(), this.huO.width, this.huO.height);
      this.huM.setFilePath(paramb.hvy.getAbsolutePath());
      this.huM.km(0);
      int i = this.huM.b(0, false, 0);
      if (i == 0) {
        break;
      }
      paramd.a(1, 110, String.format("media recoder start failed: %d", new Object[] { Integer.valueOf(i) }), "");
      AppMethodBeat.o(143208);
      return;
      try
      {
        com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, 70, Bitmap.CompressFormat.JPEG, paramb.hvx.getAbsolutePath(), true);
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.BaseGameRecord.HardwareMgrImp", localIOException, "hy: save thumb bitmap failed!", new Object[0]);
      }
    }
    this.huM.fcJ = true;
    localb.setOnTextureDrawFinishDelegate(new a.f.a.b() {});
    ab.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: start succ!");
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(143208);
  }
  
  final void a(final d<String> paramd)
  {
    AppMethodBeat.i(143209);
    if (this.huM == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(143209);
      return;
    }
    this.huM.u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143207);
        ab.i("MicroMsg.BaseGameRecord.HardwareMgrImp", "hy: stopRecord, stop callback");
        a.b.this.huM.clear();
        paramd.a(0, 0, "ok", "");
        AppMethodBeat.o(143207);
      }
    });
    AppMethodBeat.o(143209);
  }
  
  final void aAW()
  {
    try
    {
      this.huN = null;
      return;
    }
    finally {}
  }
  
  final VideoTransPara aAX()
  {
    return this.huO;
  }
  
  final void b(d<String> paramd)
  {
    AppMethodBeat.i(143210);
    if (this.huM == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(143210);
      return;
    }
    this.huM.pause();
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(143210);
  }
  
  final void c(d<String> paramd)
  {
    AppMethodBeat.i(143211);
    if (this.huM == null)
    {
      paramd.a(1, -1, "no recorder", "");
      AppMethodBeat.o(143211);
      return;
    }
    Object localObject = (MagicBrushView)this.huL.get();
    if (localObject == null)
    {
      paramd.a(1, 111, "magic brush view not found", "");
      AppMethodBeat.o(143211);
      return;
    }
    localObject = (com.tencent.mm.plugin.appbrand.game.f.a.b)((MagicBrushView)localObject).getTextureView();
    if (localObject == null)
    {
      paramd.a(1, 111, "texture view not found", "");
      AppMethodBeat.o(143211);
      return;
    }
    if (!((com.tencent.mm.plugin.appbrand.game.f.a.b)localObject).isAvailable()) {
      paramd.a(1, 111, "view not prepared", "");
    }
    this.huM.G(0, ((com.tencent.mm.plugin.appbrand.game.f.a.b)localObject).getSurfaceWidth(), ((com.tencent.mm.plugin.appbrand.game.f.a.b)localObject).getSurfaceHeight());
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(143211);
  }
  
  final void d(d<String> paramd)
  {
    AppMethodBeat.i(143212);
    if (this.huM != null)
    {
      this.huM.cancel();
      this.huM.clear();
    }
    paramd.a(0, 0, "ok", "");
    AppMethodBeat.o(143212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.b
 * JD-Core Version:    0.7.0.1
 */