package com.tencent.mm.plugin.location.ui.impl;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.3;
import com.tencent.mm.plugin.location.ui.l.4;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.ui.base.h;

final class g$7
  implements View.OnClickListener
{
  g$7(g paramg) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.lKi.lJX;
    h.a(paramView.mContext, paramView.mResources.getString(a.h.location_sharing_end_tips), "", paramView.mResources.getString(a.h.app_endshare), paramView.mResources.getString(a.h.app_cancel), new l.3(paramView), new l.4(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.7
 * JD-Core Version:    0.7.0.1
 */