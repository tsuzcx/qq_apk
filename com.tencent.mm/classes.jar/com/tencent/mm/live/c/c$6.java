package com.tencent.mm.live.c;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.d.d;
import com.tencent.mm.live.ui.LiveUID;
import com.tencent.mm.model.v;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$6
  implements View.OnClickListener
{
  c$6(RelativeLayout paramRelativeLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(215919);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    localObject = new Intent(this.gVw.getContext(), LiveUID.class);
    ((Intent)localObject).putExtra("FROM_SENCE", 2);
    paramView = this.gVw.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView = g.gQZ;
    if (p.i(g.anJ(), v.aAC())) {
      d.aqe();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(215919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.c.6
 * JD-Core Version:    0.7.0.1
 */