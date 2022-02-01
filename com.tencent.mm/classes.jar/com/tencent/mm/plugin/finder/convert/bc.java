package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.c;
import com.tencent.mm.plugin.finder.feed.aj.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onClickReport", "clickType", "", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setIcon", "plugin-finder_release"})
public final class bc
  extends e<c>
{
  private final float tEJ;
  private final aj.a<c> tEK;
  
  public bc(aj.a<c> parama)
  {
    AppMethodBeat.i(243182);
    this.tEK = parama;
    this.tEJ = 1.166667F;
    AppMethodBeat.o(243182);
  }
  
  final void a(long paramLong, com.tencent.mm.plugin.finder.storage.o paramo, int paramInt)
  {
    AppMethodBeat.i(243181);
    com.tencent.mm.g.b.a.cl localcl = new com.tencent.mm.g.b.a.cl();
    localcl.gw(paramLong);
    localcl.gx(com.tencent.mm.model.cl.aWA());
    this.tEK.a(localcl, paramo, paramInt);
    AppMethodBeat.o(243181);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243179);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243179);
  }
  
  public final int getLayoutId()
  {
    return 2131494352;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(int paramInt, View paramView, BaseFinderFeed paramBaseFinderFeed, bc parambc, com.tencent.mm.plugin.finder.storage.o paramo, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243177);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      paramView = new Intent();
      switch (this.tEO.dxE().LLo)
      {
      }
      Object localObject3;
      do
      {
        for (;;)
        {
          this.tEN.a(2L, this.tEO, this.puW);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(243177);
          return;
          paramView.putExtra("UI_TITLE", this.tEO.cxc());
          localObject1 = this.tEO.dxJ();
          localObject2 = new ato();
          ((ato)localObject2).lastBuffer = ((atp)localObject1).lastBuffer;
          ((ato)localObject2).dLS = 2;
          localObject3 = com.tencent.mm.ui.component.a.PRN;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject3 = FinderGlobalLocationVM.dHP();
          ((ato)localObject2).dTj = ((Number)((kotlin.o)localObject3).first).floatValue();
          ((ato)localObject2).latitude = ((Number)((kotlin.o)localObject3).second).floatValue();
          ((ato)localObject2).tvs = this.tEO.dxE();
          localObject3 = y.vXH;
          y.a(this.puW, (List)this.tEO.vDZ, ((atp)localObject1).lastBuffer, paramView);
          paramView.putExtra("KEY_TITLE", this.tEO.cxc());
          paramView.putExtra("KEY_REQUEST_PB", ((ato)localObject2).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.tEO.dxE().LLo);
          localObject1 = FinderReporterUIC.wzC;
          localObject1 = this.tEL.getContext();
          p.g(localObject1, "feedView.context");
          FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
          localObject1 = this.tEL.getContext();
          p.g(localObject1, "feedView.context");
          com.tencent.mm.plugin.finder.utils.a.S((Context)localObject1, paramView);
        }
        localObject3 = this.tEO.dxI();
        paramView = (BaseFinderFeed)j.kt((List)this.tEO.vDZ);
      } while (paramView == null);
      Object localObject2 = new Intent();
      if (this.tEO.dxE().LLo == 4)
      {
        ((Intent)localObject2).putExtra("key_topic_type", 2);
        ((Intent)localObject2).putExtra("KEY_FINDER_LOCATION", paramView.feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView = ((atv)localObject3).LEG;
        if (paramView != null)
        {
          localObject1 = paramView.dST;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ((Intent)localObject2).putExtra("key_topic_title", paramView);
        ((Intent)localObject2).putExtra("key_ref_object_id", 0);
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_ID", this.tEM.feedObject.getId());
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", this.puW);
        paramView = y.vXH;
        y.a(this.puW, (List)this.tEO.vDZ, ((atv)localObject3).lastBuffer, (Intent)localObject2, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.c(null, ((atv)localObject3).lastBuffer));
        ((Intent)localObject2).putExtra("KEY_SECTION_INFO", this.tEO.dxE().toByteArray());
        paramView = FinderReporterUIC.wzC;
        paramView = this.tzq.getContext();
        p.g(paramView, "holder.context");
        FinderReporterUIC.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = this.tzq.getContext();
        p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.P(paramView, (Intent)localObject2);
        break;
        ((Intent)localObject2).putExtra("key_topic_type", 1);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bc parambc, com.tencent.mm.plugin.finder.storage.o paramo, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243178);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      paramView = new Intent();
      switch (this.tEP.dxE().LLo)
      {
      }
      Object localObject3;
      do
      {
        for (;;)
        {
          this.tEN.a(1L, this.tEP, -1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(243178);
          return;
          paramView.putExtra("UI_TITLE", this.tEP.cxc());
          localObject1 = this.tEP.dxJ();
          localObject2 = new ato();
          ((ato)localObject2).lastBuffer = ((atp)localObject1).lastBuffer;
          ((ato)localObject2).dLS = 2;
          localObject3 = com.tencent.mm.ui.component.a.PRN;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject3 = FinderGlobalLocationVM.dHP();
          ((ato)localObject2).dTj = ((Number)((kotlin.o)localObject3).first).floatValue();
          ((ato)localObject2).latitude = ((Number)((kotlin.o)localObject3).second).floatValue();
          ((ato)localObject2).tvs = this.tEP.dxE();
          localObject3 = y.vXH;
          y.a(0, (List)this.tEP.vDZ, ((atp)localObject1).lastBuffer, paramView);
          paramView.putExtra("SECTION_REQ", ((ato)localObject2).toByteArray());
          paramView.putExtra("SECTION_FIRST_RSP", ((atp)localObject1).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.tEP.dxE().LLo);
          localObject1 = FinderReporterUIC.wzC;
          localObject1 = this.qhp.getContext();
          p.g(localObject1, "holder.context");
          FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
          localObject1 = this.qhp.getContext();
          p.g(localObject1, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.R((Context)localObject1, paramView);
        }
        localObject3 = this.tEP.dxI();
        paramView = (BaseFinderFeed)j.kt((List)this.tEP.vDZ);
      } while (paramView == null);
      Object localObject2 = new Intent();
      if (this.tEP.dxE().LLo == 4)
      {
        ((Intent)localObject2).putExtra("key_topic_type", 2);
        ((Intent)localObject2).putExtra("key_topic_poi_location", paramView.feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView = ((atv)localObject3).LEG;
        if (paramView != null)
        {
          localObject1 = paramView.dST;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ((Intent)localObject2).putExtra("key_topic_title", paramView);
        ((Intent)localObject2).putExtra("key_ref_object_id", 0);
        paramView = y.vXH;
        y.a(0, (List)this.tEP.vDZ, ((atv)localObject3).lastBuffer, (Intent)localObject2, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.c(null, ((atv)localObject3).lastBuffer));
        ((Intent)localObject2).putExtra("KEY_SECTION_INFO", this.tEP.dxE().toByteArray());
        ((Intent)localObject2).putExtra("KEY_TOPIC_RSP", ((atv)localObject3).toByteArray());
        paramView = FinderReporterUIC.wzC;
        paramView = this.qhp.getContext();
        p.g(paramView, "holder.context");
        FinderReporterUIC.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = this.qhp.getContext();
        p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.O(paramView, (Intent)localObject2);
        break;
        ((Intent)localObject2).putExtra("key_topic_type", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bc
 * JD-Core Version:    0.7.0.1
 */