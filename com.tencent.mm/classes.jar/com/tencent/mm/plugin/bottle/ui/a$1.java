package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22655);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
    this.plc.plb.ebp();
    if (this.plc.pla != null) {
      this.plc.pla.cZ(paramView.getTag());
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bottle/ui/BottleConversationAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(22655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a.1
 * JD-Core Version:    0.7.0.1
 */