package com.tencent.mm.plugin.game.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class k$3
  implements View.OnClickListener
{
  k$3(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41047);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    k.f(this.ujd).setVisibility(8);
    a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k.3
 * JD-Core Version:    0.7.0.1
 */