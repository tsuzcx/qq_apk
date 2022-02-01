package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import com.tencent.mm.view.recyclerview.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doReport", "", "index", "getLayoutId", "isFinderClose", "", "extStatus", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "openFinderEntrance", "toIntSafely", "Companion", "plugin-finder_release"})
public final class bw
  extends e<com.tencent.mm.plugin.finder.model.b>
{
  public static final a tFl;
  private final int dLS;
  final bbn ttO;
  
  static
  {
    AppMethodBeat.i(243221);
    tFl = new a((byte)0);
    AppMethodBeat.o(243221);
  }
  
  public bw(bbn parambbn, int paramInt)
  {
    this.ttO = parambbn;
    this.dLS = paramInt;
  }
  
  public final void a(final RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(243219);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    TextView localTextView = (TextView)paramh.aus.findViewById(2131305622);
    p.g(localTextView, "tipsTv");
    ao.a((Paint)localTextView.getPaint(), 0.8F);
    final LinearLayout localLinearLayout = (LinearLayout)paramh.aus.findViewById(2131305621);
    View localView = paramh.aus;
    p.g(localView, "holder.itemView");
    f.a(localView, (e.b)new b(this, localLinearLayout));
    localLinearLayout.setOnClickListener((View.OnClickListener)new c(this, localLinearLayout, paramRecyclerView));
    if (y.a(y.vXH, this.dLS, 0, 2))
    {
      paramRecyclerView = paramh.getContext();
      p.g(paramRecyclerView, "holder.context");
      paramInt = paramRecyclerView.getResources().getColor(2131100631);
      localTextView.setTextColor(paramInt);
      paramRecyclerView = (WeImageView)paramh.aus.findViewById(2131305620);
      if (paramRecyclerView != null) {
        paramRecyclerView.setIconColor(paramInt);
      }
      paramRecyclerView = paramh.aus.findViewById(2131305621);
      if (paramRecyclerView != null)
      {
        paramRecyclerView.setBackgroundResource(2131100495);
        AppMethodBeat.o(243219);
        return;
      }
    }
    AppMethodBeat.o(243219);
  }
  
  public final int getLayoutId()
  {
    return 2131494549;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$Companion;", "", "()V", "FINDER_ENTRANCE_ID", "", "STATUS_CLOSE", "STATUS_OPEN", "TAB_FOLLOW", "TAB_FRIEND", "TAB_HOT", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
  public static final class b
    extends e.b
  {
    b(LinearLayout paramLinearLayout) {}
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(243217);
      p.h(paramView, "view");
      if (paramBoolean)
      {
        paramView = localLinearLayout;
        p.g(paramView, "tipsLl");
        int i = bw.dj(paramView.getTag());
        paramView = m.vfD;
        m.dof();
        m.a(this.tFm.ttO, 1, System.currentTimeMillis(), i - 1);
      }
      AppMethodBeat.o(243217);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(bw parambw, LinearLayout paramLinearLayout, RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243218);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.tFm.ttO;
      int k;
      int i;
      if (paramView != null)
      {
        paramView = paramView.sGQ;
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(paramView);
        long l = z.aUd();
        if (bw.Ef(l)) {
          bw.Eg(l);
        }
        paramView = localLinearLayout;
        p.g(paramView, "tipsLl");
        k = bw.dj(paramView.getTag());
        j = 18;
        localObject = "KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB";
        paramView = c.vCb;
        paramView = (View)localObject;
        i = j;
        switch (((Number)c.dvK().value()).intValue())
        {
        default: 
          i = j;
          paramView = (View)localObject;
        }
      }
      for (;;)
      {
        bw.a(this.tFm, k);
        if (!(paramRecyclerView.getContext() instanceof Activity)) {
          break label241;
        }
        localObject = paramRecyclerView.getContext();
        if (localObject != null) {
          break label233;
        }
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(243218);
        throw paramView;
        paramView = null;
        break;
        i = 19;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_HOT_TAB";
        continue;
        i = 17;
        paramView = "KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB";
      }
      label233:
      ((Activity)localObject).finish();
      label241:
      localObject = new Intent();
      ((Intent)localObject).putExtra(paramView, true);
      ((Intent)localObject).putExtra("KEY_FROM_SHARE_REL", true);
      paramView = this.tFm.ttO;
      if (paramView != null)
      {
        paramView = paramView.sGQ;
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
          ((aj)g.ah(aj.class)).fillContextIdToIntent(j, 9, i, (Intent)localObject);
        }
        paramView = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.dnS();
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramView = paramRecyclerView.getContext();
        p.g(paramView, "recyclerView.context");
        com.tencent.mm.plugin.finder.utils.a.a(paramView, (Intent)localObject, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243218);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bw
 * JD-Core Version:    0.7.0.1
 */