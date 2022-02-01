package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class b
  extends d
{
  private final boolean cij;
  private final boolean cik;
  private final int cil;
  private final boolean cim;
  
  public b(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    AppMethodBeat.i(190396);
    this.cij = paramBoolean1;
    this.cik = paramBoolean2;
    this.cil = paramInt;
    this.cim = paramBoolean3;
    AppMethodBeat.o(190396);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130732);
    p.h(parame, "builder");
    super.a(parame);
    parame.bQ(false);
    parame.bO(this.cij);
    boolean bool = this.cik;
    parame.cxj.a(f.cwV[9], Boolean.valueOf(bool));
    int i = this.cil;
    parame.cxs.a(f.cwV[16], Integer.valueOf(i));
    parame.cxu.a(f.cwV[18], Boolean.TRUE);
    bool = this.cim;
    parame.cxt.a(f.cwV[17], Boolean.valueOf(bool));
    AppMethodBeat.o(130732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */