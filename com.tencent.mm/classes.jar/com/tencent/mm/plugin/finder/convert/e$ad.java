package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ad.f;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.c;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.component.a;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class e$ad
  implements View.OnLongClickListener
{
  e$ad(com.tencent.mm.view.recyclerview.e parame) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(197396);
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.nGG.fjf();
    paramView = a.LCX;
    paramView = this.nGG.getContext();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(197396);
      throw paramView;
    }
    FinderDebugUIC localFinderDebugUIC = (FinderDebugUIC)a.s((MMActivity)paramView).get(FinderDebugUIC.class);
    Context localContext;
    com.tencent.mm.view.recyclerview.e locale;
    com.tencent.mm.ui.widget.a.e locale1;
    long l;
    boolean bool;
    Object localObject;
    if (localFinderDebugUIC != null)
    {
      localContext = this.nGG.getContext();
      k.g(localContext, "holder.context");
      k.g(localBaseFinderFeed, "item");
      locale = this.nGG;
      k.h(localContext, "context");
      k.h(localBaseFinderFeed, "item");
      k.h(locale, "holder");
      locale1 = new com.tencent.mm.ui.widget.a.e(localContext, 0, false);
      l = localBaseFinderFeed.bMs();
      paramView = (bmd)j.iz((List)localBaseFinderFeed.feedObject.getMediaList());
      if ((paramView == null) || (paramView.mediaType != 4)) {
        break label650;
      }
      bool = true;
      paramView = new StringBuilder(" [ClickMoreDebug]FeedId=").append(c.ly(localBaseFinderFeed.feedObject.getId())).append("\n                posTriggerConfig=");
      localObject = i.KXv;
      localObject = paramView.append(i.BT(localBaseFinderFeed.feedObject.getId())).append("\n                videoDuration=");
      paramView = (bmd)j.iz((List)localBaseFinderFeed.feedObject.getMediaList());
      if (paramView == null) {
        break label656;
      }
      paramView = Integer.valueOf(paramView.videoDuration);
      label260:
      paramView = ((StringBuilder)localObject).append(paramView).append("\n                signedFeedId=").append(localBaseFinderFeed.feedObject.getId()).append("\n                username=").append(localBaseFinderFeed.feedObject.field_username).append("\n                ctFlag=");
      localObject = com.tencent.mm.plugin.finder.api.b.qnX;
      StringBuilder localStringBuilder = paramView.append(b.a.YO(localBaseFinderFeed.feedObject.field_username)).append("\n                mediaType=").append(localBaseFinderFeed.feedObject.getMediaType()).append("\n                mediaId=");
      paramView = (bmd)j.iz((List)localBaseFinderFeed.feedObject.getMediaList());
      if (paramView != null)
      {
        localObject = paramView.url;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      localObject = localStringBuilder.append(ai.du(paramView)).append("\n                url=");
      paramView = (bmd)j.iz((List)localBaseFinderFeed.feedObject.getMediaList());
      if (paramView == null) {
        break label661;
      }
      paramView = paramView.url;
      label429:
      localObject = ((StringBuilder)localObject).append(paramView).append("\n                thumbUrl=");
      paramView = (bmd)j.iz((List)localBaseFinderFeed.feedObject.getMediaList());
      if (paramView == null) {
        break label666;
      }
    }
    label650:
    label656:
    label661:
    label666:
    for (paramView = paramView.thumbUrl;; paramView = null)
    {
      paramView = paramView + "\n                description=" + localBaseFinderFeed.feedObject.getDescription() + "\n                        ";
      localObject = n.aRa("content=" + f.bG(localBaseFinderFeed.feedObject.getFeedObject()));
      ad.e(FinderDebugUIC.TAG, "long click more button! ".concat(String.valueOf(paramView)));
      ad.e(FinderDebugUIC.TAG, "long click more button allInfo! ".concat(String.valueOf(localObject)));
      if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.eEQ()))
      {
        locale1.a((n.c)new FinderDebugUIC.b(localFinderDebugUIC, bool));
        locale1.a((n.d)new FinderDebugUIC.c(localFinderDebugUIC, localContext, paramView, localBaseFinderFeed, l, (String)localObject, locale));
        locale1.csG();
      }
      this.nGG.arI.requestLayout();
      AppMethodBeat.o(197396);
      return true;
      bool = false;
      break;
      paramView = null;
      break label260;
      paramView = null;
      break label429;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.ad
 * JD-Core Version:    0.7.0.1
 */