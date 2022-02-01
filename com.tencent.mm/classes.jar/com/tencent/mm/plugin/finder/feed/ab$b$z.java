package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class ab$b$z
  implements u.b
{
  ab$b$z(ab.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
  
  public final void dU(View paramView)
  {
    AppMethodBeat.i(258537);
    Object localObject;
    if (paramView != null)
    {
      localObject = (TextView)paramView.findViewById(2131309260);
      if (localObject != null) {
        ((TextView)localObject).setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(2131309259);
      if (paramView != null)
      {
        paramView.setImageResource(2131690537);
        localObject = paramView.getContext();
        p.g(localObject, "context");
        paramView.setIconColor(((Context)localObject).getResources().getColor(2131101426));
      }
    }
    this.tPI.a(this.tEM.feedObject, false, null);
    AppMethodBeat.o(258537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab.b.z
 * JD-Core Version:    0.7.0.1
 */