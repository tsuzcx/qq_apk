package com.tencent.mm.plugin.location.ui.impl;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.3;
import com.tencent.mm.plugin.location.ui.l.4;
import com.tencent.mm.ui.base.h;

final class g$9
  implements View.OnClickListener
{
  g$9(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113677);
    paramView = this.ohw.ohl;
    h.d(paramView.mContext, paramView.mResources.getString(2131301110), "", paramView.mResources.getString(2131296921), paramView.mResources.getString(2131296888), new l.3(paramView), new l.4(paramView));
    AppMethodBeat.o(113677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.9
 * JD-Core Version:    0.7.0.1
 */