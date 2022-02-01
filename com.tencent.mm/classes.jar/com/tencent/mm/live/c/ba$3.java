package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.v;
import com.tencent.mm.live.b.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ba$3
  implements View.OnClickListener
{
  ba$3(ba paramba) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212599);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    paramView = f.e.gNl;
    paramView = ax.aQA(f.e.anb());
    localObject = f.e.gNl;
    paramView.putBoolean(f.e.anc(), true);
    paramView = g.ajB();
    p.g(paramView, "MMKernel.network()");
    paramView.aiU().a(3895, (f)this.gXh);
    paramView = g.ajB();
    p.g(paramView, "MMKernel.network()");
    paramView.aiU().b((n)new v());
    ad.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
    a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.ba.3
 * JD-Core Version:    0.7.0.1
 */