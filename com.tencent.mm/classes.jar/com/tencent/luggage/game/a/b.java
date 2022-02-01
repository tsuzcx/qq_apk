package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class b
  extends d
{
  private final boolean bXR;
  private final boolean bXS;
  private final int bXT;
  private final boolean bXU;
  
  public b(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    AppMethodBeat.i(206112);
    this.bXR = paramBoolean1;
    this.bXS = paramBoolean2;
    this.bXT = paramInt;
    this.bXU = paramBoolean3;
    AppMethodBeat.o(206112);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130732);
    k.h(parame, "builder");
    super.a(parame);
    parame.bQ(false);
    parame.bO(this.bXR);
    boolean bool = this.bXS;
    parame.cmG.a(f.$$delegatedProperties[9], Boolean.valueOf(bool));
    int i = this.bXT;
    parame.cmP.a(f.$$delegatedProperties[16], Integer.valueOf(i));
    parame.cmR.a(f.$$delegatedProperties[18], Boolean.TRUE);
    bool = this.bXU;
    parame.cmQ.a(f.$$delegatedProperties[17], Boolean.valueOf(bool));
    AppMethodBeat.o(130732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */