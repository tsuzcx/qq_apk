package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.dzz;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$2$2"})
final class e$am
  implements View.OnClickListener
{
  e$am(e parame, com.tencent.mm.view.recyclerview.e parame1, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, LinkedList paramLinkedList, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197406);
    Object localObject = new dzz();
    ((dzz)localObject).feedId = this.qqY.bMs();
    ((dzz)localObject).objectNonceId = this.qqY.feedObject.getObjectNonceId();
    ((dzz)localObject).scene = 2;
    paramView = FinderReporterUIC.Ljl;
    paramView = this.qqq.getContext();
    k.g(paramView, "holder.context");
    paramView = FinderReporterUIC.a.lB(paramView);
    if (paramView != null)
    {
      paramView = paramView.fXs();
      ((dzz)localObject).contextObj = paramView;
      localObject = this.qqq.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView == null) {
        break label147;
      }
    }
    label147:
    for (paramView = (FinderLikeDrawer)paramView.findViewById(2131307328);; paramView = null)
    {
      if (paramView == null) {
        k.fvU();
      }
      paramView.p(this.qqY.feedObject);
      AppMethodBeat.o(197406);
      return;
      paramView = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.am
 * JD-Core Version:    0.7.0.1
 */