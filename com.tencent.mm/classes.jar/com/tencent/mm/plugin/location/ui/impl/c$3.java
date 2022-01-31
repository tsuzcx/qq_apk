package com.tencent.mm.plugin.location.ui.impl;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;

final class c$3
  implements ActionBarSearchView.b
{
  c$3(c paramc) {}
  
  public final void Sk(String paramString)
  {
    AppMethodBeat.i(113596);
    ab.d("MicroMsg.MMPoiMapUI", "searchText: %s", new Object[] { paramString });
    c.a(this.ogD, paramString);
    c.w(this.ogD).dDZ();
    c.y(this.ogD).setVisibility(8);
    if (bo.isNullOrNil(paramString))
    {
      c.v(this.ogD).clean();
      c.v(this.ogD).notifyDataSetChanged();
      AppMethodBeat.o(113596);
      return;
    }
    c.z(this.ogD);
    AppMethodBeat.o(113596);
  }
  
  public final void apP()
  {
    AppMethodBeat.i(113597);
    ab.d("MicroMsg.MMPoiMapUI", "clear btn click");
    c.v(this.ogD).clean();
    c.v(this.ogD).notifyDataSetChanged();
    AppMethodBeat.o(113597);
  }
  
  public final void bMl() {}
  
  public final void bMm() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.3
 * JD-Core Version:    0.7.0.1
 */