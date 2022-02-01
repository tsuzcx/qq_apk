package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.Log;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107447);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.FavBaseListItem", "manual restart upload");
    if ((paramView.getTag() instanceof g)) {
      com.tencent.mm.plugin.fav.a.b.l((g)paramView.getTag());
    }
    a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(107447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.b.2
 * JD-Core Version:    0.7.0.1
 */