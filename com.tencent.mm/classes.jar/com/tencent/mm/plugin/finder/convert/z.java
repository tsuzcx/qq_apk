package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "minContainerWidth", "", "minTextWidth", "calcWidth", "", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.model.h>
{
  public static final a AKo;
  private final float AKp;
  private float AKq;
  
  static
  {
    AppMethodBeat.i(165410);
    AKo = new a((byte)0);
    AppMethodBeat.o(165410);
  }
  
  public z()
  {
    AppMethodBeat.i(350510);
    this.AKp = MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_10_5_A);
    this.AKq = MMApplicationContext.getContext().getResources().getDimension(e.c.finder_18_25_A);
    AppMethodBeat.o(350510);
  }
  
  public static void a(j paramj, com.tencent.mm.plugin.finder.model.h paramh)
  {
    AppMethodBeat.i(350519);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramh, "item");
    Log.i("Finder.FeedMsgNotifyConvert", "item count = " + paramh.count + ",item avatar = " + paramh.avatar);
    if (paramh.count > 0)
    {
      paramj.UH(e.e.msg_layout).setVisibility(0);
      if (Util.isNullOrNil(paramh.avatar)) {
        paramj.UH(e.e.msg_avatar).setVisibility(8);
      }
      int i;
      for (;;)
      {
        Object localObject1 = (TextView)paramj.UH(e.e.message_count);
        aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        Object localObject2 = ar.Giw;
        localObject2 = paramj.context;
        kotlin.g.b.s.s(localObject2, "holder.context");
        ((TextView)localObject1).setText((CharSequence)ar.a((Context)localObject2, paramh.ECm, paramh.likeCount, paramh.commentCount, paramh.count));
        i = ar.Giw.ffL();
        paramh = paramj.UH(e.e.msg_layout).getLayoutParams();
        if (paramh != null) {
          break;
        }
        paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(350519);
        throw paramj;
        paramj.UH(e.e.msg_avatar).setVisibility(0);
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCq();
        localObject2 = new com.tencent.mm.plugin.finder.loader.s(paramh.avatar, v.FKZ);
        Object localObject3 = paramj.UH(e.e.msg_avatar);
        kotlin.g.b.s.s(localObject3, "holder.getView<ImageView>(R.id.msg_avatar)");
        localObject3 = (ImageView)localObject3;
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      }
      paramh = (FrameLayout.LayoutParams)paramh;
      if (paramh.width != i)
      {
        Log.i("Finder.FeedMsgNotifyConvert", "change layoutParam calcWidth: " + i + " width:" + paramh.width);
        paramh.width = i;
        paramj.UH(e.e.msg_layout).setLayoutParams((ViewGroup.LayoutParams)paramh);
        AppMethodBeat.o(350519);
      }
    }
    else
    {
      paramj.UH(e.e.msg_layout).setVisibility(8);
    }
    AppMethodBeat.o(350519);
  }
  
  private static final void c(j paramj, View paramView)
  {
    AppMethodBeat.i(350529);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    int m = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcq, 0);
    int n = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcs, 0);
    int i1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adct, 0);
    int i2 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcu, 0);
    int i3 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcw, 0);
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramView = paramj.context;
    kotlin.g.b.s.s(paramView, "holder.context");
    com.tencent.mm.plugin.finder.utils.a.ha(paramView);
    localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLWxBubble");
    localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLWxBubble");
    paramView = "7";
    int k;
    if (localObject1 != null)
    {
      paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
        break label493;
      }
      k = 5;
      if (n <= 0) {
        break label521;
      }
    }
    label521:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (m > 0) {
        i = j | 0x8;
      }
      j = i;
      if (i1 > 0) {
        j = i | 0x2;
      }
      if (i2 > 0) {}
      for (i = j | 0x4;; i = j)
      {
        j = i;
        i = k;
        paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
        Object localObject3 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId;
        paramView = as.GSQ;
        paramView = paramj.context;
        kotlin.g.b.s.s(paramView, "holder.context");
        paramView = as.a.hu(paramView);
        label312:
        w localw;
        if (paramView == null)
        {
          paramView = null;
          com.tencent.mm.plugin.finder.report.z.a("7", i, 2, 2, j, m + n + i1 + i2 + i3, (String)localObject3, null, 0L, paramView, 0, 0, 3456);
          paramView = "7";
          if ((localObject1 != null) && (localObject2 != null))
          {
            i = m + n + i1 + i2 + i3;
            localObject3 = ar.Giw;
            localObject3 = paramj.context;
            kotlin.g.b.s.s(localObject3, "holder.context");
            localObject3 = ar.a((Context)localObject3, i3, n + i1 + i2, m, i);
            localw = w.FrV;
            as.a locala = as.GSQ;
            paramj = paramj.context;
            kotlin.g.b.s.s(paramj, "holder.context");
            paramj = as.a.hu(paramj);
            if (paramj != null) {
              break label508;
            }
          }
        }
        label493:
        label508:
        for (paramj = null;; paramj = paramj.fou())
        {
          w.a(localw, paramView, (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, (bxq)localObject2, 2, paramj, i, (String)localObject3, 1, 256);
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(350529);
          return;
          i = 1;
          j = 1;
          break;
          paramView = paramView.fou();
          break label312;
        }
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350556);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    paramRecyclerView = paramj.caK.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB = true;
    }
    paramj.UH(e.e.msg_layout).setOnClickListener(new z..ExternalSyntheticLambda0(paramj));
    AppMethodBeat.o(350556);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_header_msg_notify_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.z
 * JD-Core Version:    0.7.0.1
 */