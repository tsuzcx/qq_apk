package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.aa.f;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addSingleVoiceTmpMode$acceptWithVoiceView$1$2$1", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$$special$$inlined$also$lambda$1"})
final class c$i
  implements View.OnClickListener
{
  c$i(c paramc, aa.f paramf, c.e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(263490);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addSingleVoiceTmpMode$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = com.tencent.mm.msgsubscription.voice.a.mtE;
    long l = com.tencent.mm.msgsubscription.voice.a.Zk(this.msP.msK);
    c.a(this.msv, (kotlin.g.a.a)new q(l) {});
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addSingleVoiceTmpMode$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(263490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.i
 * JD-Core Version:    0.7.0.1
 */