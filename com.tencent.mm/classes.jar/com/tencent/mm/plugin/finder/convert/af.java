package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.l;
import d.o;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setIcon", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "plugin-finder_release"})
public final class af
  extends com.tencent.mm.view.recyclerview.b<c>
{
  private final String qXj;
  private final String qXu;
  private final float rOY;
  
  public af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201440);
    this.qXu = paramString1;
    this.qXj = paramString2;
    this.rOY = 1.166667F;
    AppMethodBeat.o(201440);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201438);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    AppMethodBeat.o(201438);
  }
  
  public final int getLayoutId()
  {
    return 2131496218;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(int paramInt, View paramView, BaseFinderFeed paramBaseFinderFeed, af paramaf, m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201436);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      paramView = new Intent();
      switch (this.rPc.cIu().Gpc)
      {
      }
      Object localObject2;
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201436);
          return;
          paramView.putExtra("UI_TITLE", this.rPc.bXX());
          localObject1 = this.rPc.cIz();
          localObject2 = new aoj();
          ((aoj)localObject2).lastBuffer = ((aok)localObject1).lastBuffer;
          ((aoj)localObject2).duh = 2;
          Object localObject3 = com.tencent.mm.ui.component.a.KiD;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject3 = FinderGlobalLocationVM.cOb();
          ((aoj)localObject2).dAp = ((Number)((o)localObject3).first).floatValue();
          ((aoj)localObject2).dyz = ((Number)((o)localObject3).second).floatValue();
          ((aoj)localObject2).rJv = this.rPc.cIu();
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.a(this.odp, (List)this.rPc.syu, ((aok)localObject1).lastBuffer, paramView);
          paramView.putExtra("KEY_TITLE", this.rPc.bXX());
          paramView.putExtra("KEY_REQUEST_PB", ((aoj)localObject2).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.rPc.cIu().Gpc);
          localObject1 = FinderReporterUIC.tcM;
          localObject1 = this.rOZ.getContext();
          d.g.b.p.g(localObject1, "feedView.context");
          FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
          localObject1 = this.rOZ.getContext();
          d.g.b.p.g(localObject1, "feedView.context");
          com.tencent.mm.plugin.finder.utils.a.N((Context)localObject1, paramView);
        }
        localObject1 = this.rPc.cIy();
        localObject2 = (BaseFinderFeed)j.jd((List)this.rPc.syu);
      } while (localObject2 == null);
      paramView = new Intent();
      if (this.rPc.cIu().Gpc == 4)
      {
        paramView.putExtra("key_topic_type", 2);
        paramView.putExtra("KEY_FINDER_LOCATION", ((BaseFinderFeed)localObject2).feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView.putExtra("key_topic_title", ((aoo)localObject1).Gni.dzZ);
        paramView.putExtra("key_ref_object_id", 0);
        paramView.putExtra("KEY_CLICK_FEED_ID", this.rPa.feedObject.getId());
        paramView.putExtra("KEY_CLICK_FEED_POSITION", this.odp);
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
        com.tencent.mm.plugin.finder.utils.p.a(this.odp, (List)this.rPc.syu, ((aoo)localObject1).lastBuffer, paramView, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.b(null, ((aoo)localObject1).lastBuffer));
        paramView.putExtra("KEY_SECTION_INFO", this.rPc.cIu().toByteArray());
        localObject1 = FinderReporterUIC.tcM;
        localObject1 = this.rMh.getContext();
        d.g.b.p.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
        localObject1 = this.rMh.getContext();
        d.g.b.p.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.K((Context)localObject1, paramView);
        break;
        paramView.putExtra("key_topic_type", 1);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201437);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      paramView = new Intent();
      switch (this.rPd.cIu().Gpc)
      {
      }
      Object localObject2;
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201437);
          return;
          paramView.putExtra("UI_TITLE", this.rPd.bXX());
          localObject1 = this.rPd.cIz();
          localObject2 = new aoj();
          ((aoj)localObject2).lastBuffer = ((aok)localObject1).lastBuffer;
          ((aoj)localObject2).duh = 2;
          Object localObject3 = com.tencent.mm.ui.component.a.KiD;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject3 = FinderGlobalLocationVM.cOb();
          ((aoj)localObject2).dAp = ((Number)((o)localObject3).first).floatValue();
          ((aoj)localObject2).dyz = ((Number)((o)localObject3).second).floatValue();
          ((aoj)localObject2).rJv = this.rPd.cIu();
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.a(0, (List)this.rPd.syu, ((aok)localObject1).lastBuffer, paramView);
          paramView.putExtra("SECTION_REQ", ((aoj)localObject2).toByteArray());
          paramView.putExtra("SECTION_FIRST_RSP", ((aok)localObject1).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.rPd.cIu().Gpc);
          localObject1 = FinderReporterUIC.tcM;
          localObject1 = this.oNd.getContext();
          d.g.b.p.g(localObject1, "holder.context");
          FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
          localObject1 = this.oNd.getContext();
          d.g.b.p.g(localObject1, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.M((Context)localObject1, paramView);
        }
        localObject1 = this.rPd.cIy();
        localObject2 = (BaseFinderFeed)j.jd((List)this.rPd.syu);
      } while (localObject2 == null);
      paramView = new Intent();
      if (this.rPd.cIu().Gpc == 4)
      {
        paramView.putExtra("key_topic_type", 2);
        paramView.putExtra("key_topic_poi_location", ((BaseFinderFeed)localObject2).feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView.putExtra("key_topic_title", ((aoo)localObject1).Gni.dzZ);
        paramView.putExtra("key_ref_object_id", 0);
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
        com.tencent.mm.plugin.finder.utils.p.a(0, (List)this.rPd.syu, ((aoo)localObject1).lastBuffer, paramView, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.b(null, ((aoo)localObject1).lastBuffer));
        paramView.putExtra("KEY_SECTION_INFO", this.rPd.cIu().toByteArray());
        paramView.putExtra("KEY_TOPIC_RSP", ((aoo)localObject1).toByteArray());
        localObject1 = FinderReporterUIC.tcM;
        localObject1 = this.oNd.getContext();
        d.g.b.p.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
        localObject1 = this.oNd.getContext();
        d.g.b.p.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.J((Context)localObject1, paramView);
        break;
        paramView.putExtra("key_topic_type", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.af
 * JD-Core Version:    0.7.0.1
 */