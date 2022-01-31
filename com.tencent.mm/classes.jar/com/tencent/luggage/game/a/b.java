package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime.IMBEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

public class b
  extends a
{
  public c bzF;
  public boolean bzG;
  public MBRuntime.IMBEventListener bzH;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(c paramc)
  {
    this.bzF = paramc;
    paramc.bzG = this.bzG;
    paramc.bzN = this.bzH;
    paramc.bzJ = true;
    paramc.bzK = true;
    paramc.bzO.allow_antialias_ = false;
    paramc.bzO.gc_factor = 0.0F;
    paramc.bzO.allow_opengl3 = true;
    paramc.bzO.enable_2d = true;
  }
  
  public void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(140324);
    super.a(parami, true);
    com.tencent.luggage.game.c.a.bzT.a(this.bzF.bzI, parami);
    AppMethodBeat.o(140324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */