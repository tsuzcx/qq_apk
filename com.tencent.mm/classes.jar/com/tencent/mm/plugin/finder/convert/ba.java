package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ef;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.ay.a;
import com.tencent.mm.plugin.finder.feed.bl;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onClickReport", "clickType", "", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setIcon", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
  extends f<com.tencent.mm.plugin.finder.model.c>
{
  private final ay.a<com.tencent.mm.plugin.finder.model.c> ALh;
  private final float nwN;
  
  public ba(ay.a<com.tencent.mm.plugin.finder.model.c> parama)
  {
    AppMethodBeat.i(350281);
    this.ALh = parama;
    this.nwN = 1.166667F;
    AppMethodBeat.o(350281);
  }
  
  private final void a(long paramLong, q paramq, int paramInt)
  {
    AppMethodBeat.i(350284);
    ef localef = new ef();
    localef.iCB = paramLong;
    localef.iCC = cn.bDw();
    this.ALh.a(localef, paramq, paramInt);
    AppMethodBeat.o(350284);
  }
  
  private static final void a(q paramq, int paramInt, View paramView1, BaseFinderFeed paramBaseFinderFeed, j paramj, ba paramba, View paramView2)
  {
    AppMethodBeat.i(350299);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramq);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBaseFinderFeed);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramba);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramq, "$lbsItem");
    s.u(paramView1, "$feedView");
    s.u(paramBaseFinderFeed, "$feed");
    s.u(paramj, "$holder");
    s.u(paramba, "this$0");
    paramView2 = new Intent();
    switch (paramq.eZn().aacH)
    {
    }
    do
    {
      for (;;)
      {
        paramba.a(2L, paramq, paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(350299);
        return;
        paramView2.putExtra("UI_TITLE", paramq.dnV());
        paramBaseFinderFeed = paramq.eZs();
        paramj = new bav();
        paramj.lastBuffer = paramBaseFinderFeed.lastBuffer;
        paramj.hJx = 2;
        localObject1 = k.aeZF;
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
        paramj.longitude = ((Number)((r)localObject1).bsC).floatValue();
        paramj.latitude = ((Number)((r)localObject1).bsD).floatValue();
        paramj.ACr = paramq.eZn();
        localObject1 = av.GiL;
        av.a(paramInt, (List)paramq.FKS, paramBaseFinderFeed.lastBuffer, paramView2);
        paramView2.putExtra("KEY_TITLE", paramq.dnV());
        paramView2.putExtra("KEY_REQUEST_PB", paramj.toByteArray());
        paramView2.putExtra("KEY_MORE_ACTION_TYPE", paramq.eZn().aacH);
        paramBaseFinderFeed = as.GSQ;
        paramBaseFinderFeed = paramView1.getContext();
        s.s(paramBaseFinderFeed, "feedView.context");
        as.a.a(paramBaseFinderFeed, paramView2, 0L, 0, false, 124);
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramView1 = paramView1.getContext();
        s.s(paramView1, "feedView.context");
        com.tencent.mm.plugin.finder.utils.a.ak(paramView1, paramView2);
      }
      localObject2 = paramq.eZr();
      paramView1 = (BaseFinderFeed)p.oL((List)paramq.FKS);
    } while (paramView1 == null);
    localObject1 = new Intent();
    if (paramq.eZn().aacH == 4)
    {
      ((Intent)localObject1).putExtra("key_topic_type", 2);
      ((Intent)localObject1).putExtra("KEY_FINDER_LOCATION", paramView1.feedObject.getLocation().toByteArray());
      label493:
      paramView1 = ((bbg)localObject2).ZLU;
      if (paramView1 != null) {
        break label675;
      }
      paramView1 = "";
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("key_topic_title", paramView1);
      ((Intent)localObject1).putExtra("key_ref_object_id", 0);
      ((Intent)localObject1).putExtra("KEY_CLICK_FEED_ID", paramBaseFinderFeed.feedObject.getId());
      ((Intent)localObject1).putExtra("KEY_CLICK_FEED_POSITION", paramInt);
      paramView1 = av.GiL;
      av.a(paramInt, (List)paramq.FKS, ((bbg)localObject2).lastBuffer, (Intent)localObject1, (com.tencent.mm.plugin.finder.feed.model.c)new bl(null, ((bbg)localObject2).lastBuffer));
      ((Intent)localObject1).putExtra("KEY_SECTION_INFO", paramq.eZn().toByteArray());
      paramView1 = as.GSQ;
      paramView1 = paramj.context;
      s.s(paramView1, "holder.context");
      as.a.a(paramView1, (Intent)localObject1, 0L, 0, false, 124);
      paramView1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramBaseFinderFeed = paramj.context;
      s.s(paramBaseFinderFeed, "holder.context");
      paramView1.n(paramBaseFinderFeed, (Intent)localObject1);
      break;
      ((Intent)localObject1).putExtra("key_topic_type", 1);
      break label493;
      label675:
      paramView2 = paramView1.topic;
      paramView1 = paramView2;
      if (paramView2 == null) {
        paramView1 = "";
      }
    }
  }
  
  private static final void a(q paramq, j paramj, ba paramba, View paramView)
  {
    AppMethodBeat.i(350309);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramq);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramba);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramq, "$lbsItem");
    s.u(paramj, "$holder");
    s.u(paramba, "this$0");
    paramView = new Intent();
    switch (paramq.eZn().aacH)
    {
    }
    Object localObject3;
    do
    {
      for (;;)
      {
        paramba.a(1L, paramq, -1);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(350309);
        return;
        paramView.putExtra("UI_TITLE", paramq.dnV());
        localObject1 = paramq.eZs();
        localObject2 = new bav();
        ((bav)localObject2).lastBuffer = ((baw)localObject1).lastBuffer;
        ((bav)localObject2).hJx = 2;
        localObject3 = k.aeZF;
        localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
        ((bav)localObject2).longitude = ((Number)((r)localObject3).bsC).floatValue();
        ((bav)localObject2).latitude = ((Number)((r)localObject3).bsD).floatValue();
        ((bav)localObject2).ACr = paramq.eZn();
        localObject3 = av.GiL;
        av.a(0, (List)paramq.FKS, ((baw)localObject1).lastBuffer, paramView);
        paramView.putExtra("SECTION_REQ", ((bav)localObject2).toByteArray());
        paramView.putExtra("SECTION_FIRST_RSP", ((baw)localObject1).toByteArray());
        paramView.putExtra("KEY_MORE_ACTION_TYPE", paramq.eZn().aacH);
        localObject1 = as.GSQ;
        localObject1 = paramj.context;
        s.s(localObject1, "holder.context");
        as.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.aj(paramj, paramView);
      }
      localObject3 = paramq.eZr();
      paramView = (BaseFinderFeed)p.oL((List)paramq.FKS);
    } while (paramView == null);
    localObject2 = new Intent();
    if (paramq.eZn().aacH == 4)
    {
      ((Intent)localObject2).putExtra("key_topic_type", 2);
      ((Intent)localObject2).putExtra("key_topic_poi_location", paramView.feedObject.getLocation().toByteArray());
      label457:
      paramView = ((bbg)localObject3).ZLU;
      if (paramView != null) {
        break label625;
      }
      paramView = "";
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("key_topic_title", paramView);
      ((Intent)localObject2).putExtra("key_ref_object_id", 0);
      paramView = av.GiL;
      av.a(0, (List)paramq.FKS, ((bbg)localObject3).lastBuffer, (Intent)localObject2, (com.tencent.mm.plugin.finder.feed.model.c)new bl(null, ((bbg)localObject3).lastBuffer));
      ((Intent)localObject2).putExtra("KEY_SECTION_INFO", paramq.eZn().toByteArray());
      ((Intent)localObject2).putExtra("KEY_TOPIC_RSP", ((bbg)localObject3).toByteArray());
      paramView = as.GSQ;
      paramView = paramj.context;
      s.s(paramView, "holder.context");
      as.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      paramView.A(paramj, (Intent)localObject2);
      break;
      ((Intent)localObject2).putExtra("key_topic_type", 1);
      break label457;
      label625:
      localObject1 = paramView.topic;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350332);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350332);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_lbs_section_normal_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ba
 * JD-Core Version:    0.7.0.1
 */