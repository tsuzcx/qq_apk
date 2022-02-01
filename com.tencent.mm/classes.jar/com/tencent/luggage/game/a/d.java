package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class d
  extends f
{
  private final boolean cil;
  private final boolean cim;
  private final int cin;
  private final boolean cio;
  
  public d(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    AppMethodBeat.i(220745);
    this.cil = paramBoolean1;
    this.cim = paramBoolean2;
    this.cin = paramInt;
    this.cio = paramBoolean3;
    AppMethodBeat.o(220745);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130732);
    p.h(parame, "builder");
    super.a(parame);
    parame.bQ(false);
    parame.bO(this.cil);
    boolean bool = this.cim;
    parame.cxO.a(com.tencent.magicbrush.f.cxA[9], Boolean.valueOf(bool));
    int i = this.cin;
    parame.cxX.a(com.tencent.magicbrush.f.cxA[16], Integer.valueOf(i));
    parame.cxZ.a(com.tencent.magicbrush.f.cxA[18], Boolean.TRUE);
    bool = this.cio;
    parame.cxY.a(com.tencent.magicbrush.f.cxA[17], Boolean.valueOf(bool));
    parame.cyi = j.vM("mmbox2d");
    AppMethodBeat.o(130732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.d
 * JD-Core Version:    0.7.0.1
 */