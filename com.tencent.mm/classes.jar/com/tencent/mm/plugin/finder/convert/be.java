package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.ar.a;
import com.tencent.mm.plugin.finder.feed.bd;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onClickReport", "clickType", "", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setIcon", "plugin-finder_release"})
public final class be
  extends e<com.tencent.mm.plugin.finder.model.c>
{
  private final float xnl;
  private final ar.a<com.tencent.mm.plugin.finder.model.c> xnm;
  
  public be(ar.a<com.tencent.mm.plugin.finder.model.c> parama)
  {
    AppMethodBeat.i(246508);
    this.xnm = parama;
    this.xnl = 1.166667F;
    AppMethodBeat.o(246508);
  }
  
  final void a(long paramLong, com.tencent.mm.plugin.finder.storage.p paramp, int paramInt)
  {
    AppMethodBeat.i(246507);
    dc localdc = new dc();
    localdc.ho(paramLong);
    localdc.hp(cm.bfE());
    this.xnm.a(localdc, paramp, paramInt);
    AppMethodBeat.o(246507);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(246504);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(parami, "holder");
    AppMethodBeat.o(246504);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_lbs_section_normal_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(int paramInt, View paramView, BaseFinderFeed paramBaseFinderFeed, be parambe, com.tencent.mm.plugin.finder.storage.p paramp, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291860);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      paramView = new Intent();
      switch (this.xnq.dYG().STe)
      {
      }
      Object localObject3;
      do
      {
        for (;;)
        {
          this.xnp.a(2L, this.xnq, this.nmX);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(291860);
          return;
          paramView.putExtra("UI_TITLE", this.xnq.cKF());
          localObject1 = this.xnq.dYL();
          localObject2 = new avr();
          ((avr)localObject2).lastBuffer = ((avs)localObject1).lastBuffer;
          ((avr)localObject2).fEH = 2;
          localObject3 = g.Xox;
          localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
          ((avr)localObject2).longitude = ((Number)((o)localObject3).Mx).floatValue();
          ((avr)localObject2).latitude = ((Number)((o)localObject3).My).floatValue();
          ((avr)localObject2).xcZ = this.xnq.dYG();
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.a(this.nmX, (List)this.xnq.Alp, ((avs)localObject1).lastBuffer, paramView);
          paramView.putExtra("KEY_TITLE", this.xnq.cKF());
          paramView.putExtra("KEY_REQUEST_PB", ((avr)localObject2).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.xnq.dYG().STe);
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject1 = this.xnn.getContext();
          kotlin.g.b.p.j(localObject1, "feedView.context");
          aj.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
          localObject1 = this.xnn.getContext();
          kotlin.g.b.p.j(localObject1, "feedView.context");
          com.tencent.mm.plugin.finder.utils.a.S((Context)localObject1, paramView);
        }
        localObject3 = this.xnq.dYK();
        paramView = (BaseFinderFeed)j.lp((List)this.xnq.Alp);
      } while (paramView == null);
      Object localObject2 = new Intent();
      if (this.xnq.dYG().STe == 4)
      {
        ((Intent)localObject2).putExtra("key_topic_type", 2);
        ((Intent)localObject2).putExtra("KEY_FINDER_LOCATION", paramView.feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView = ((avy)localObject3).SIo;
        if (paramView != null)
        {
          localObject1 = paramView.topic;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ((Intent)localObject2).putExtra("key_topic_title", paramView);
        ((Intent)localObject2).putExtra("key_ref_object_id", 0);
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_ID", this.xno.feedObject.getId());
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", this.nmX);
        paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.a(this.nmX, (List)this.xnq.Alp, ((avy)localObject3).lastBuffer, (Intent)localObject2, (com.tencent.mm.plugin.finder.feed.model.c)new bd(null, ((avy)localObject3).lastBuffer));
        ((Intent)localObject2).putExtra("KEY_SECTION_INFO", this.xnq.dYG().toByteArray());
        paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramView = this.xhb.getContext();
        kotlin.g.b.p.j(paramView, "holder.context");
        aj.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.xhb.getContext();
        kotlin.g.b.p.j(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.P(paramView, (Intent)localObject2);
        break;
        ((Intent)localObject2).putExtra("key_topic_type", 1);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(be parambe, com.tencent.mm.plugin.finder.storage.p paramp, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244089);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      paramView = new Intent();
      switch (this.xnr.dYG().STe)
      {
      }
      Object localObject3;
      do
      {
        for (;;)
        {
          this.xnp.a(1L, this.xnr, -1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(244089);
          return;
          paramView.putExtra("UI_TITLE", this.xnr.cKF());
          localObject1 = this.xnr.dYL();
          localObject2 = new avr();
          ((avr)localObject2).lastBuffer = ((avs)localObject1).lastBuffer;
          ((avr)localObject2).fEH = 2;
          localObject3 = g.Xox;
          localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
          ((avr)localObject2).longitude = ((Number)((o)localObject3).Mx).floatValue();
          ((avr)localObject2).latitude = ((Number)((o)localObject3).My).floatValue();
          ((avr)localObject2).xcZ = this.xnr.dYG();
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.a(0, (List)this.xnr.Alp, ((avs)localObject1).lastBuffer, paramView);
          paramView.putExtra("SECTION_REQ", ((avr)localObject2).toByteArray());
          paramView.putExtra("SECTION_FIRST_RSP", ((avs)localObject1).toByteArray());
          paramView.putExtra("KEY_MORE_ACTION_TYPE", this.xnr.dYG().STe);
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject1 = this.tDl.getContext();
          kotlin.g.b.p.j(localObject1, "holder.context");
          aj.a.a((Context)localObject1, paramView, 0L, 0, false, 124);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
          localObject1 = this.tDl.getContext();
          kotlin.g.b.p.j(localObject1, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.R((Context)localObject1, paramView);
        }
        localObject3 = this.xnr.dYK();
        paramView = (BaseFinderFeed)j.lp((List)this.xnr.Alp);
      } while (paramView == null);
      Object localObject2 = new Intent();
      if (this.xnr.dYG().STe == 4)
      {
        ((Intent)localObject2).putExtra("key_topic_type", 2);
        ((Intent)localObject2).putExtra("key_topic_poi_location", paramView.feedObject.getLocation().toByteArray());
      }
      for (;;)
      {
        paramView = ((avy)localObject3).SIo;
        if (paramView != null)
        {
          localObject1 = paramView.topic;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ((Intent)localObject2).putExtra("key_topic_title", paramView);
        ((Intent)localObject2).putExtra("key_ref_object_id", 0);
        paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.a(0, (List)this.xnr.Alp, ((avy)localObject3).lastBuffer, (Intent)localObject2, (com.tencent.mm.plugin.finder.feed.model.c)new bd(null, ((avy)localObject3).lastBuffer));
        ((Intent)localObject2).putExtra("KEY_SECTION_INFO", this.xnr.dYG().toByteArray());
        ((Intent)localObject2).putExtra("KEY_TOPIC_RSP", ((avy)localObject3).toByteArray());
        paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramView = this.tDl.getContext();
        kotlin.g.b.p.j(paramView, "holder.context");
        aj.a.a(paramView, (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.tDl.getContext();
        kotlin.g.b.p.j(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.O(paramView, (Intent)localObject2);
        break;
        ((Intent)localObject2).putExtra("key_topic_type", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.be
 * JD-Core Version:    0.7.0.1
 */