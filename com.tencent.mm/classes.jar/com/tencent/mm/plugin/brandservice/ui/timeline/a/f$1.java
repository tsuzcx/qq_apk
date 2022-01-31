package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;

final class f$1
  implements View.OnClickListener
{
  f$1(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14257);
    paramView = (q)paramView.getTag();
    paramView.field_isExpand = true;
    z.afo().i(paramView);
    this.jYm.jXV.jVS.d(paramView, 0);
    AppMethodBeat.o(14257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.f.1
 * JD-Core Version:    0.7.0.1
 */