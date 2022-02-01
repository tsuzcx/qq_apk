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
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.l;
import d.o;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setIcon", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "plugin-finder_release"})
public final class ag
  extends com.tencent.mm.view.recyclerview.b<c>
{
  private final float rXz;
  private final String rfA;
  private final String rfo;
  
  public ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201882);
    this.rfA = paramString1;
    this.rfo = paramString2;
    this.rXz = 1.166667F;
    AppMethodBeat.o(201882);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201880);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    AppMethodBeat.o(201880);
  }
  
  public final int getLayoutId()
  {
    return 2131496218;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(int paramInt, View paramView, BaseFinderFeed paramBaseFinderFeed, ag paramag, m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201878);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = new Intent();
      switch (this.rXD.cKZ().GIs)
      {
      }
      Object localObject3;
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201878);
          return;
          paramView.putExtra("UI_TITLE", this.rXD.bZm());
          localObject1 = this.rXD.cLe();
          localObject2 = new aow();
          ((aow)localObject2).lastBuffer = ((aox)localObject1).lastBuffer;
          ((aow)localObject2).dvm = 2;
          localObject3 = com.tencent.mm.ui.component.a.KEX;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject3 = FinderGlobalLocationVM.cQL();
          ((aow)localObject2).dBu = ((Number)((o)localObject3).first).floatValue();
          ((aow)localObject2).dzE = ((Number)((o)localObject3).second).floatValue();
          ((aow)localObject2).rRJ = this.rXD.cKZ();
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.a(this.ojd, (List)this.rXD.sJl, ((aox)localObject1).lastBuffer, paramView);
          paramView.putExtra("KEY_TITLE", this.rXD.bZm());
          paramView.putExtra("KEY_REQUEST_PB", ((aow)localObject2).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.rXD.cKZ().GIs);
          localObject1 = FinderReporterUIC.tnG;
          localObject1 = this.rXA.getContext();
          d.g.b.p.g(localObject1, "feedView.context");
          FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
          localObject1 = this.rXA.getContext();
          d.g.b.p.g(localObject1, "feedView.context");
          com.tencent.mm.plugin.finder.utils.a.N((Context)localObject1, paramView);
        }
        localObject3 = this.rXD.cLd();
        paramView = (BaseFinderFeed)j.jm((List)this.rXD.sJl);
      } while (paramView == null);
      Object localObject2 = new Intent();
      if (this.rXD.cKZ().GIs == 4)
      {
        ((Intent)localObject2).putExtra("key_topic_type", 2);
        ((Intent)localObject2).putExtra("KEY_FINDER_LOCATION", paramView.feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView = ((apb)localObject3).GGo;
        if (paramView != null)
        {
          localObject1 = paramView.dBe;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ((Intent)localObject2).putExtra("key_topic_title", paramView);
        ((Intent)localObject2).putExtra("key_ref_object_id", 0);
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_ID", this.rXB.feedObject.getId());
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", this.ojd);
        paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.a(this.ojd, (List)this.rXD.sJl, ((apb)localObject3).lastBuffer, (Intent)localObject2, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.b(null, ((apb)localObject3).lastBuffer));
        ((Intent)localObject2).putExtra("KEY_SECTION_INFO", this.rXD.cKZ().toByteArray());
        paramView = FinderReporterUIC.tnG;
        paramView = this.rUu.getContext();
        d.g.b.p.g(paramView, "holder.context");
        FinderReporterUIC.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramView = this.rUu.getContext();
        d.g.b.p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.K(paramView, (Intent)localObject2);
        break;
        ((Intent)localObject2).putExtra("key_topic_type", 1);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201879);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = new Intent();
      switch (this.rXE.cKZ().GIs)
      {
      }
      Object localObject3;
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201879);
          return;
          paramView.putExtra("UI_TITLE", this.rXE.bZm());
          localObject1 = this.rXE.cLe();
          localObject2 = new aow();
          ((aow)localObject2).lastBuffer = ((aox)localObject1).lastBuffer;
          ((aow)localObject2).dvm = 2;
          localObject3 = com.tencent.mm.ui.component.a.KEX;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject3 = FinderGlobalLocationVM.cQL();
          ((aow)localObject2).dBu = ((Number)((o)localObject3).first).floatValue();
          ((aow)localObject2).dzE = ((Number)((o)localObject3).second).floatValue();
          ((aow)localObject2).rRJ = this.rXE.cKZ();
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.a(0, (List)this.rXE.sJl, ((aox)localObject1).lastBuffer, paramView);
          paramView.putExtra("SECTION_REQ", ((aow)localObject2).toByteArray());
          paramView.putExtra("SECTION_FIRST_RSP", ((aox)localObject1).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.rXE.cKZ().GIs);
          localObject1 = FinderReporterUIC.tnG;
          localObject1 = this.oTF.getContext();
          d.g.b.p.g(localObject1, "holder.context");
          FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
          localObject1 = this.oTF.getContext();
          d.g.b.p.g(localObject1, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.M((Context)localObject1, paramView);
        }
        localObject3 = this.rXE.cLd();
        paramView = (BaseFinderFeed)j.jm((List)this.rXE.sJl);
      } while (paramView == null);
      Object localObject2 = new Intent();
      if (this.rXE.cKZ().GIs == 4)
      {
        ((Intent)localObject2).putExtra("key_topic_type", 2);
        ((Intent)localObject2).putExtra("key_topic_poi_location", paramView.feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView = ((apb)localObject3).GGo;
        if (paramView != null)
        {
          localObject1 = paramView.dBe;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ((Intent)localObject2).putExtra("key_topic_title", paramView);
        ((Intent)localObject2).putExtra("key_ref_object_id", 0);
        paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.a(0, (List)this.rXE.sJl, ((apb)localObject3).lastBuffer, (Intent)localObject2, (com.tencent.mm.plugin.finder.feed.model.a)new FinderTopicTimelineUIContract.b(null, ((apb)localObject3).lastBuffer));
        ((Intent)localObject2).putExtra("KEY_SECTION_INFO", this.rXE.cKZ().toByteArray());
        ((Intent)localObject2).putExtra("KEY_TOPIC_RSP", ((apb)localObject3).toByteArray());
        paramView = FinderReporterUIC.tnG;
        paramView = this.oTF.getContext();
        d.g.b.p.g(paramView, "holder.context");
        FinderReporterUIC.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramView = this.oTF.getContext();
        d.g.b.p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.J(paramView, (Intent)localObject2);
        break;
        ((Intent)localObject2).putExtra("key_topic_type", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ag
 * JD-Core Version:    0.7.0.1
 */