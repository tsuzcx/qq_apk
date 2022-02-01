package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.m;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.model.z;
import com.tencent.mm.plugin.finder.feed.model.z.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import d.o;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setIcon", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "plugin-finder_release"})
public final class al
  extends b<v>
{
  private final String KHW;
  private final String qwV;
  private final float rQP;
  
  public al(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197471);
    this.qwV = paramString1;
    this.KHW = paramString2;
    this.rQP = 1.166667F;
    AppMethodBeat.o(197471);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(197469);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(197469);
  }
  
  public final int getLayoutId()
  {
    return 2131496217;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(int paramInt, View paramView, BaseFinderFeed paramBaseFinderFeed, al paramal, p paramp, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197467);
      paramView = new Intent();
      switch (this.KLr.fUQ().Lyg)
      {
      }
      Object localObject1;
      Object localObject2;
      long l;
      do
      {
        AppMethodBeat.o(197467);
        return;
        paramView.putExtra("UI_TITLE", this.KLr.bMf());
        localObject1 = this.KLr.fUV();
        localObject2 = new dyz();
        ((dyz)localObject2).lastBuffer = ((dza)localObject1).lastBuffer;
        ((dyz)localObject2).IoU = 2;
        Object localObject3 = com.tencent.mm.ui.component.a.LCX;
        com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
        localObject3 = FinderGlobalLocationVM.fXf();
        ((dyz)localObject2).dqQ = ((Number)((o)localObject3).first).floatValue();
        ((dyz)localObject2).dpb = ((Number)((o)localObject3).second).floatValue();
        ((dyz)localObject2).KJJ = this.KLr.fUQ();
        paramView.putExtra("KEY_CLICK_FEED_POSITION", this.mYS);
        l = System.currentTimeMillis();
        localObject3 = z.KQl;
        z.a.a(l, (List)this.KLr.KWI, ((dza)localObject1).lastBuffer);
        paramView.putExtra("KEY_CACHE_ID", l);
        paramView.putExtra("KEY_TITLE", this.KLr.bMf());
        paramView.putExtra("KEY_REQUEST_PB", ((dyz)localObject2).toByteArray());
        localObject1 = FinderReporterUIC.Ljl;
        localObject1 = this.KLp.getContext();
        k.g(localObject1, "feedView.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject1 = this.KLp.getContext();
        k.g(localObject1, "feedView.context");
        com.tencent.mm.plugin.finder.utils.a.af((Context)localObject1, paramView);
        AppMethodBeat.o(197467);
        return;
        localObject1 = this.KLr.fUU();
        localObject2 = (BaseFinderFeed)j.iz((List)this.KLr.KWI);
      } while (localObject2 == null);
      paramView = new Intent();
      if (this.KLr.fUQ().Lyg == 4)
      {
        paramView.putExtra("key_topic_type", 2);
        paramView.putExtra("KEY_FINDER_LOCATION", ((BaseFinderFeed)localObject2).feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView.putExtra("key_topic_title", ((aji)localObject1).LxB.dqA);
        paramView.putExtra("key_ref_object_id", 0);
        paramView.putExtra("KEY_CLICK_FEED_ID", this.qug.feedObject.getId());
        paramView.putExtra("KEY_CLICK_FEED_POSITION", this.mYS);
        l = System.currentTimeMillis();
        localObject2 = m.qxS;
        m.a.a(l, (List)this.KLr.KWI, ((aji)localObject1).lastBuffer, null);
        paramView.putExtra("KEY_CACHE_ID", l);
        paramView.putExtra("KEY_SECTION_INFO", this.KLr.fUQ().toByteArray());
        localObject1 = FinderReporterUIC.Ljl;
        localObject1 = this.qqq.getContext();
        k.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject1 = this.qqq.getContext();
        k.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.G((Context)localObject1, paramView);
        break;
        paramView.putExtra("key_topic_type", 1);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(p paramp, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197468);
      paramView = new Intent();
      switch (this.KLs.fUQ().Lyg)
      {
      }
      Object localObject1;
      Object localObject2;
      long l;
      do
      {
        AppMethodBeat.o(197468);
        return;
        paramView.putExtra("UI_TITLE", this.KLs.bMf());
        localObject1 = this.KLs.fUV();
        localObject2 = new dyz();
        ((dyz)localObject2).lastBuffer = ((dza)localObject1).lastBuffer;
        ((dyz)localObject2).IoU = 2;
        Object localObject3 = com.tencent.mm.ui.component.a.LCX;
        com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
        localObject3 = FinderGlobalLocationVM.fXf();
        ((dyz)localObject2).dqQ = ((Number)((o)localObject3).first).floatValue();
        ((dyz)localObject2).dpb = ((Number)((o)localObject3).second).floatValue();
        ((dyz)localObject2).KJJ = this.KLs.fUQ();
        l = System.currentTimeMillis();
        localObject3 = z.KQl;
        z.a.a(l, (List)this.KLs.KWI, ((dza)localObject1).lastBuffer);
        paramView.putExtra("SECTION_REQ", ((dyz)localObject2).toByteArray());
        paramView.putExtra("SECTION_FIRST_RSP", ((dza)localObject1).toByteArray());
        paramView.putExtra("KEY_CACHE_ID", l);
        localObject1 = FinderReporterUIC.Ljl;
        localObject1 = this.nGG.getContext();
        k.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject1 = this.nGG.getContext();
        k.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.ae((Context)localObject1, paramView);
        AppMethodBeat.o(197468);
        return;
        localObject1 = this.KLs.fUU();
        localObject2 = (BaseFinderFeed)j.iz((List)this.KLs.KWI);
      } while (localObject2 == null);
      paramView = new Intent();
      if (this.KLs.fUQ().Lyg == 4)
      {
        paramView.putExtra("key_topic_type", 2);
        paramView.putExtra("key_topic_poi_location", ((BaseFinderFeed)localObject2).feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView.putExtra("key_topic_title", ((aji)localObject1).LxB.dqA);
        paramView.putExtra("key_ref_object_id", 0);
        l = System.currentTimeMillis();
        localObject2 = m.qxS;
        m.a.a(l, (List)this.KLs.KWI, ((aji)localObject1).lastBuffer, null);
        paramView.putExtra("KEY_CACHE_ID", l);
        paramView.putExtra("KEY_SECTION_INFO", this.KLs.fUQ().toByteArray());
        paramView.putExtra("KEY_TOPIC_RSP", ((aji)localObject1).toByteArray());
        localObject1 = FinderReporterUIC.Ljl;
        localObject1 = this.nGG.getContext();
        k.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject1 = this.nGG.getContext();
        k.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.F((Context)localObject1, paramView);
        break;
        paramView.putExtra("key_topic_type", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.al
 * JD-Core Version:    0.7.0.1
 */