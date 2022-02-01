package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$b
  implements View.OnClickListener
{
  a$b(a parama, d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209180);
    this.goP.ais();
    Object localObject = new Intent(this.goP.context, Class.forName(this.goQ.gnV.name));
    ((Intent)localObject).putExtra("route_to_maximize", true);
    ((Intent)localObject).addFlags(268435456);
    paramView = ai.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$setup$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(209180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b
 * JD-Core Version:    0.7.0.1
 */