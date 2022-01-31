package com.tencent.mm.plugin.location.ui.impl;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;

final class c$3
  implements ActionBarSearchView.b
{
  c$3(c paramc) {}
  
  public final void GH(String paramString)
  {
    y.d("MicroMsg.MMPoiMapUI", "searchText: %s", new Object[] { paramString });
    c.a(this.lJp, paramString);
    c.w(this.lJp).cAP();
    c.y(this.lJp).setVisibility(8);
    if (bk.bl(paramString))
    {
      c.v(this.lJp).clean();
      c.v(this.lJp).notifyDataSetChanged();
      return;
    }
    c.z(this.lJp);
  }
  
  public final void Wn()
  {
    y.d("MicroMsg.MMPoiMapUI", "clear btn click");
    c.v(this.lJp).clean();
    c.v(this.lJp).notifyDataSetChanged();
  }
  
  public final void beQ() {}
  
  public final void beR() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.3
 * JD-Core Version:    0.7.0.1
 */