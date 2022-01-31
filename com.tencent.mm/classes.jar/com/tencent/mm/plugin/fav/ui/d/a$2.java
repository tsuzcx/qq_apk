package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.FavBaseListItem", "manual restart upload");
    if ((paramView.getTag() instanceof g)) {
      b.l((g)paramView.getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a.2
 * JD-Core Version:    0.7.0.1
 */