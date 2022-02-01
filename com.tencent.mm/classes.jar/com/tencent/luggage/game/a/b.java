package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends d
{
  private final boolean eke;
  private final boolean ekf;
  private final int ekg;
  private final boolean ekh;
  
  public b(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    AppMethodBeat.i(220109);
    this.eke = paramBoolean1;
    this.ekf = paramBoolean2;
    this.ekg = paramInt;
    this.ekh = paramBoolean3;
    AppMethodBeat.o(220109);
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(130732);
    s.u(paramf, "builder");
    super.a(paramf);
    paramf.dl(false);
    paramf.di(this.eke);
    boolean bool = this.ekf;
    paramf.eIa.a(g.aYe[9], Boolean.valueOf(bool));
    int i = this.ekg;
    paramf.eIj.a(g.aYe[16], Integer.valueOf(i));
    paramf.eIl.a(g.aYe[18], Boolean.TRUE);
    bool = this.ekh;
    paramf.eIk.a(g.aYe[17], Boolean.valueOf(bool));
    AppMethodBeat.o(130732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */