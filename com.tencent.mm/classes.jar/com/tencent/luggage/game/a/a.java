package com.tencent.luggage.game.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.luggage.g.d;
import com.tencent.luggage.game.c.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.m;
import com.tencent.mm.plugin.appbrand.i.n;
import com.tencent.mm.plugin.appbrand.i.s;
import com.tencent.mm.sdk.platformtools.bo;

public class a
{
  private Context bzE;
  private c bzF;
  
  public a(Context paramContext)
  {
    this.bzE = paramContext;
  }
  
  protected void a(c paramc)
  {
    paramc.bzO.enable_2d = false;
    paramc.bzO.animationFrameHandlerStrategy = a.b.bLq;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.i.i parami)
  {
    AppMethodBeat.i(140321);
    long l = bo.yB();
    this.bzF = new c();
    a(this.bzF);
    Object localObject = this.bzF;
    ((c)localObject).bzL = parami;
    if (parami.v(s.class) == null)
    {
      parami = new IllegalArgumentException("JsRuntime not support addon: V8");
      AppMethodBeat.o(140321);
      throw parami;
    }
    if (parami.v(n.class) == null)
    {
      parami = new IllegalArgumentException("JsRuntime not support addon: JsThread");
      AppMethodBeat.o(140321);
      throw parami;
    }
    if (parami.v(m.class) == null)
    {
      parami = new IllegalArgumentException("JsRuntime not support addon: DestroyListener");
      AppMethodBeat.o(140321);
      throw parami;
    }
    ((c)localObject).bzM = new c.c(parami, (byte)0);
    parami = this.bzF;
    localObject = this.bzE;
    if (parami.bzL == null)
    {
      parami = new IllegalStateException("JsRuntime invalid");
      AppMethodBeat.o(140321);
      throw parami;
    }
    if (parami.bzM == null)
    {
      parami = new IllegalStateException("JsThreadHandler invalid");
      AppMethodBeat.o(140321);
      throw parami;
    }
    parami.bzO.device_pixel_ratio_ = com.tencent.magicbrush.d.a.getDensity((Context)localObject);
    localObject = com.tencent.magicbrush.d.a.ay((Context)localObject);
    parami.bzO.screen_width_ = ((Point)localObject).x;
    parami.bzO.screen_height_ = ((Point)localObject).y;
    parami.bzO.use_command_buffer = parami.bzG;
    parami.bzO.adjust_thread_priority = parami.bzJ;
    parami.bzO.enable_request_animation_frame = parami.bzK;
    parami.bzI = new MBRuntime(parami.bzO);
    if (parami.bzN != null) {
      parami.bzI.registerEventListener(parami.bzN);
    }
    parami.bzI.registerEventListener(new c.b(parami));
    parami.bzI.setJsThreadHandler(parami.bzM);
    parami.bzI.init();
    parami.bzM.post(new c.1(parami));
    l = bo.av(l);
    d.i("Luggage.MBRuntimeInstallHelper", "setup magicbrush, done. cost?[%d]", new Object[] { Long.valueOf(l) });
    as(l);
    AppMethodBeat.o(140321);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(140322);
    b localb = b.bzW;
    b.a(this.bzF.bzI, parami, paramBoolean);
    AppMethodBeat.o(140322);
  }
  
  public void as(long paramLong) {}
  
  public final void cleanup()
  {
    AppMethodBeat.i(140323);
    c localc = this.bzF;
    d.i("MicroMsg.MBRuntimeSimple", "destroy");
    ((m)localc.bzL.v(m.class)).a(localc.bzP);
    AppMethodBeat.o(140323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.a.a
 * JD-Core Version:    0.7.0.1
 */