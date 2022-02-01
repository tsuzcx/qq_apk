package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"})
public class b
  extends d
{
  private final boolean cue;
  private final boolean cuf;
  private final int cug;
  private final boolean cuh;
  
  public b(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    AppMethodBeat.i(222897);
    this.cue = paramBoolean1;
    this.cuf = paramBoolean2;
    this.cug = paramInt;
    this.cuh = paramBoolean3;
    AppMethodBeat.o(222897);
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(130732);
    p.h(paramf, "builder");
    super.a(paramf);
    paramf.cr(false);
    paramf.co(this.cue);
    boolean bool = this.cuf;
    paramf.cLW.a(g.cLI[9], Boolean.valueOf(bool));
    int i = this.cug;
    paramf.cMf.a(g.cLI[16], Integer.valueOf(i));
    paramf.cMh.a(g.cLI[18], Boolean.TRUE);
    bool = this.cuh;
    paramf.cMg.a(g.cLI[17], Boolean.valueOf(bool));
    AppMethodBeat.o(130732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */