package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class b
  extends d
{
  private final boolean caU;
  private final boolean caV;
  private final int caW;
  private final boolean caX;
  
  public b(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    AppMethodBeat.i(194664);
    this.caU = paramBoolean1;
    this.caV = paramBoolean2;
    this.caW = paramInt;
    this.caX = paramBoolean3;
    AppMethodBeat.o(194664);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130732);
    k.h(parame, "builder");
    super.a(parame);
    parame.bP(false);
    parame.bN(this.caU);
    boolean bool = this.caV;
    parame.cpB.a(f.$$delegatedProperties[9], Boolean.valueOf(bool));
    int i = this.caW;
    parame.cpK.a(f.$$delegatedProperties[16], Integer.valueOf(i));
    parame.cpM.a(f.$$delegatedProperties[18], Boolean.TRUE);
    bool = this.caX;
    parame.cpL.a(f.$$delegatedProperties[17], Boolean.valueOf(bool));
    AppMethodBeat.o(130732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */