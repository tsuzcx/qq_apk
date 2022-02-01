package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doReport", "", "index", "wording", "", "getLayoutId", "isFinderClose", "", "extStatus", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "openFinderEntrance", "toIntSafely", "Companion", "plugin-finder_release"})
public final class bz
  extends e<com.tencent.mm.plugin.finder.model.b>
{
  public static final a xnM;
  private final int fEH;
  final bid xbu;
  
  static
  {
    AppMethodBeat.i(285854);
    xnM = new a((byte)0);
    AppMethodBeat.o(285854);
  }
  
  public bz(bid parambid, int paramInt)
  {
    this.xbu = parambid;
    this.fEH = paramInt;
  }
  
  public final void a(final RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(285852);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    TextView localTextView = (TextView)parami.amk.findViewById(b.f.open_entrance_tv);
    p.j(localTextView, "tipsTv");
    ar.a((Paint)localTextView.getPaint(), 0.8F);
    final String str = paramRecyclerView.getContext().getString(b.j.finder_feed_active_and_jump_finder);
    p.j(str, "recyclerView.context.get…d_active_and_jump_finder)");
    final LinearLayout localLinearLayout = (LinearLayout)parami.amk.findViewById(b.f.open_entrance_ll);
    View localView = parami.amk;
    p.j(localView, "holder.itemView");
    f.a(localView, (e.b)new b(this, localLinearLayout, str));
    localLinearLayout.setOnClickListener((View.OnClickListener)new c(this, localLinearLayout, str, paramRecyclerView));
    if (aj.a(aj.AGc, this.fEH, 0, 2))
    {
      paramRecyclerView = parami.getContext();
      p.j(paramRecyclerView, "holder.context");
      paramInt = paramRecyclerView.getResources().getColor(b.c.hot_tab_stream_link_color);
      localTextView.setTextColor(paramInt);
      paramRecyclerView = (WeImageView)parami.amk.findViewById(b.f.open_entrance_ic);
      if (paramRecyclerView != null) {
        paramRecyclerView.setIconColor(paramInt);
      }
      paramRecyclerView = parami.amk.findViewById(b.f.open_entrance_ll);
      if (paramRecyclerView != null)
      {
        paramRecyclerView.setBackgroundResource(b.c.full_black);
        AppMethodBeat.o(285852);
        return;
      }
    }
    AppMethodBeat.o(285852);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_open_entrance_tip_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$Companion;", "", "()V", "FINDER_ENTRANCE_ID", "", "STATUS_CLOSE", "STATUS_OPEN", "TAB_FOLLOW", "TAB_FRIEND", "TAB_HOT", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
  public static final class b
    extends e.b
  {
    b(LinearLayout paramLinearLayout, String paramString) {}
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(277698);
      p.k(paramView, "view");
      if (paramBoolean)
      {
        paramView = localLinearLayout;
        p.j(paramView, "tipsLl");
        int i = bz.dg(paramView.getTag());
        paramView = q.zWJ;
        q.dPF();
        q.a(this.xnN.xbu, 1, cm.bfD(), i - 1, str);
      }
      AppMethodBeat.o(277698);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(bz parambz, LinearLayout paramLinearLayout, String paramString, RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264279);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.xnN.xbu;
      int k;
      int i;
      if (paramView != null)
      {
        paramView = paramView.wmL;
        com.tencent.mm.plugin.expt.hellhound.core.b.awV(paramView);
        long l = z.bde();
        if (bz.Ku(l)) {
          bz.Kv(l);
        }
        paramView = localLinearLayout;
        p.j(paramView, "tipsLl");
        k = bz.dg(paramView.getTag());
        j = 18;
        localObject = "KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB";
        paramView = d.AjH;
        paramView = (View)localObject;
        i = j;
        switch (((Number)d.dWk().aSr()).intValue())
        {
        default: 
          i = j;
          paramView = (View)localObject;
        }
      }
      for (;;)
      {
        bz.a(this.xnN, k, str);
        if (!(paramRecyclerView.getContext() instanceof Activity)) {
          break label245;
        }
        localObject = paramRecyclerView.getContext();
        if (localObject != null) {
          break label237;
        }
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(264279);
        throw paramView;
        paramView = null;
        break;
        i = 19;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_HOT_TAB";
        continue;
        i = 17;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB";
      }
      label237:
      ((Activity)localObject).finish();
      label245:
      localObject = new Intent();
      ((Intent)localObject).putExtra(paramView, true);
      ((Intent)localObject).putExtra("KEY_FROM_SHARE_REL", true);
      paramView = this.xnN.xbu;
      if (paramView != null)
      {
        paramView = paramView.wmL;
        if (paramView != null)
        {
          paramView = n.b((CharSequence)paramView, new char[] { '-' });
          if (paramView != null)
          {
            paramView = (String)paramView.get(0);
            if (paramView == null) {}
          }
        }
      }
      for (int j = Integer.parseInt(paramView);; j = -1)
      {
        if ((j > 0) && (i > 0)) {
          ((ak)h.ag(ak.class)).fillContextIdToIntent(j, 9, i, (Intent)localObject);
        }
        paramView = j.zVy;
        j.dPt();
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = paramRecyclerView.getContext();
        p.j(paramView, "recyclerView.context");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, (Intent)localObject, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264279);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bz
 * JD-Core Version:    0.7.0.1
 */