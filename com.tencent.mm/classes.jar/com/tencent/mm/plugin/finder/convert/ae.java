package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.aj.a;
import com.tencent.mm.plugin.finder.feed.model.l.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.o;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setIcon", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "plugin-finder_release"})
public final class ae
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.b>
{
  private final String qom;
  private final String qox;
  private final float rcc;
  
  public ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201346);
    this.qox = paramString1;
    this.qom = paramString2;
    this.rcc = 1.166667F;
    AppMethodBeat.o(201346);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201344);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    AppMethodBeat.o(201344);
  }
  
  public final int getLayoutId()
  {
    return 2131496218;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(int paramInt, View paramView, BaseFinderFeed paramBaseFinderFeed, ae paramae, com.tencent.mm.plugin.finder.storage.j paramj, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201342);
      paramView = new Intent();
      switch (this.rcg.cAz().EGE)
      {
      }
      Object localObject1;
      Object localObject2;
      long l;
      do
      {
        AppMethodBeat.o(201342);
        return;
        paramView.putExtra("UI_TITLE", this.rcg.bTs());
        localObject1 = this.rcg.cAE();
        localObject2 = new ale();
        ((ale)localObject2).lastBuffer = ((alf)localObject1).lastBuffer;
        ((ale)localObject2).diw = 2;
        Object localObject3 = com.tencent.mm.ui.component.a.IrY;
        com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
        localObject3 = FinderGlobalLocationVM.cFH();
        ((ale)localObject2).doB = ((Number)((o)localObject3).first).floatValue();
        ((ale)localObject2).dmL = ((Number)((o)localObject3).second).floatValue();
        ((ale)localObject2).qYj = this.rcg.cAz();
        paramView.putExtra("KEY_CLICK_FEED_POSITION", this.nBr);
        l = System.currentTimeMillis();
        localObject3 = com.tencent.mm.plugin.finder.feed.model.l.rng;
        l.a.a(l, (List)this.rcg.rDI, ((alf)localObject1).lastBuffer);
        paramView.putExtra("KEY_CACHE_ID", l);
        paramView.putExtra("KEY_TITLE", this.rcg.bTs());
        paramView.putExtra("KEY_REQUEST_PB", ((ale)localObject2).toByteArray());
        paramView.putExtra("KEY_MORE_ACTION_TYPE", this.rcg.cAz().EGE);
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = this.rcd.getContext();
        k.g(localObject1, "feedView.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject1 = this.rcd.getContext();
        k.g(localObject1, "feedView.context");
        com.tencent.mm.plugin.finder.utils.a.O((Context)localObject1, paramView);
        AppMethodBeat.o(201342);
        return;
        localObject1 = this.rcg.cAD();
        localObject2 = (BaseFinderFeed)d.a.j.iP((List)this.rcg.rDI);
      } while (localObject2 == null);
      paramView = new Intent();
      if (this.rcg.cAz().EGE == 4)
      {
        paramView.putExtra("key_topic_type", 2);
        paramView.putExtra("KEY_FINDER_LOCATION", ((BaseFinderFeed)localObject2).feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView.putExtra("key_topic_title", ((alj)localObject1).EFc.dol);
        paramView.putExtra("key_ref_object_id", 0);
        paramView.putExtra("KEY_CLICK_FEED_ID", this.rce.feedObject.getId());
        paramView.putExtra("KEY_CLICK_FEED_POSITION", this.nBr);
        l = System.currentTimeMillis();
        localObject2 = aj.rmg;
        aj.a.a(l, (List)this.rcg.rDI, ((alj)localObject1).lastBuffer, null);
        paramView.putExtra("KEY_CACHE_ID", l);
        paramView.putExtra("KEY_SECTION_INFO", this.rcg.cAz().toByteArray());
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = this.qZS.getContext();
        k.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject1 = this.qZS.getContext();
        k.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.J((Context)localObject1, paramView);
        break;
        paramView.putExtra("key_topic_type", 1);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(com.tencent.mm.plugin.finder.storage.j paramj, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201343);
      paramView = new Intent();
      switch (this.rch.cAz().EGE)
      {
      }
      Object localObject1;
      Object localObject2;
      long l;
      do
      {
        AppMethodBeat.o(201343);
        return;
        paramView.putExtra("UI_TITLE", this.rch.bTs());
        localObject1 = this.rch.cAE();
        localObject2 = new ale();
        ((ale)localObject2).lastBuffer = ((alf)localObject1).lastBuffer;
        ((ale)localObject2).diw = 2;
        Object localObject3 = com.tencent.mm.ui.component.a.IrY;
        com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
        localObject3 = FinderGlobalLocationVM.cFH();
        ((ale)localObject2).doB = ((Number)((o)localObject3).first).floatValue();
        ((ale)localObject2).dmL = ((Number)((o)localObject3).second).floatValue();
        ((ale)localObject2).qYj = this.rch.cAz();
        l = System.currentTimeMillis();
        localObject3 = com.tencent.mm.plugin.finder.feed.model.l.rng;
        l.a.a(l, (List)this.rch.rDI, ((alf)localObject1).lastBuffer);
        paramView.putExtra("SECTION_REQ", ((ale)localObject2).toByteArray());
        paramView.putExtra("SECTION_FIRST_RSP", ((alf)localObject1).toByteArray());
        paramView.putExtra("KEY_CACHE_ID", l);
        paramView.putExtra("KEY_MORE_ACTION_TYPE", this.rch.cAz().EGE);
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = this.ojH.getContext();
        k.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject1 = this.ojH.getContext();
        k.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.N((Context)localObject1, paramView);
        AppMethodBeat.o(201343);
        return;
        localObject1 = this.rch.cAD();
        localObject2 = (BaseFinderFeed)d.a.j.iP((List)this.rch.rDI);
      } while (localObject2 == null);
      paramView = new Intent();
      if (this.rch.cAz().EGE == 4)
      {
        paramView.putExtra("key_topic_type", 2);
        paramView.putExtra("key_topic_poi_location", ((BaseFinderFeed)localObject2).feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView.putExtra("key_topic_title", ((alj)localObject1).EFc.dol);
        paramView.putExtra("key_ref_object_id", 0);
        l = System.currentTimeMillis();
        localObject2 = aj.rmg;
        aj.a.a(l, (List)this.rch.rDI, ((alj)localObject1).lastBuffer, null);
        paramView.putExtra("KEY_CACHE_ID", l);
        paramView.putExtra("KEY_SECTION_INFO", this.rch.cAz().toByteArray());
        paramView.putExtra("KEY_TOPIC_RSP", ((alj)localObject1).toByteArray());
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = this.ojH.getContext();
        k.g(localObject1, "holder.context");
        FinderReporterUIC.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject1 = this.ojH.getContext();
        k.g(localObject1, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.I((Context)localObject1, paramView);
        break;
        paramView.putExtra("key_topic_type", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ae
 * JD-Core Version:    0.7.0.1
 */