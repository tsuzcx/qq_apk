package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.f.f;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"})
public final class i
  extends a
  implements com.tencent.mm.ak.g
{
  Context context;
  private final ImageView gzD;
  private final RelativeLayout gzE;
  private final TextView gzF;
  private final ProgressBar gzG;
  public boolean gzH;
  private final b gzb;
  com.tencent.mm.ui.widget.a.e gzh;
  final n.d gzj;
  
  public i(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190059);
    this.gzb = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307578);
    k.g(paramb, "root.findViewById(R.id.live_ban_comment_icon)");
    this.gzD = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307579);
    k.g(paramb, "root.findViewById(R.id.l…_comment_icon_click_area)");
    this.gzE = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307580);
    k.g(paramb, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
    this.gzF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307582);
    k.g(paramb, "root.findViewById(R.id.live_ban_comment_loading)");
    this.gzG = ((ProgressBar)paramb);
    this.gzH = true;
    this.gzj = ((n.d)new a(this));
    paramb = this.gzD;
    Context localContext = paramViewGroup.getContext();
    k.g(localContext, "root.context");
    paramb.setImageDrawable(am.e(localContext.getResources().getDrawable(2131691513), -1));
    this.gzE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190050);
        if (this.gzI.gzH)
        {
          paramAnonymousView = this.gzI;
          boolean bool = this.gzI.gzH;
          localObject1 = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          Object localObject2;
          if (bool)
          {
            localObject2 = paramAnonymousView.context;
            k.g(localObject2, "context");
            ((ArrayList)localObject1).add(((Context)localObject2).getResources().getString(2131766640));
            localObject2 = f.f.gtD;
            localArrayList.add(Integer.valueOf(f.f.aks()));
            if (!bool) {
              break label346;
            }
            paramAnonymousView.gzh = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, true);
            Object localObject3 = View.inflate(paramAnonymousView.context, 2131496305, null);
            localObject2 = (TextView)((View)localObject3).findViewById(2131307596);
            com.tencent.mm.ui.widget.a.e locale = paramAnonymousView.gzh;
            if (locale != null) {
              locale.gJ((View)localObject3);
            }
            k.g(localObject2, "bottomSheetTitleTv");
            localObject3 = paramAnonymousView.gnb.getContext();
            k.g(localObject3, "root.context");
            ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getResources().getString(2131766577));
          }
          for (;;)
          {
            localObject2 = paramAnonymousView.gzh;
            if (localObject2 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject2).a((n.c)new i.b(paramAnonymousView, (ArrayList)localObject1, localArrayList));
            }
            localObject1 = paramAnonymousView.gzh;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).fvr();
            }
            localObject1 = paramAnonymousView.gzh;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).a(paramAnonymousView.gzj);
            }
            localObject1 = paramAnonymousView.gzh;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new i.c(paramAnonymousView));
            }
            paramAnonymousView = paramAnonymousView.gzh;
            if (paramAnonymousView == null) {
              break label366;
            }
            paramAnonymousView.cED();
            AppMethodBeat.o(190050);
            return;
            localObject2 = paramAnonymousView.context;
            k.g(localObject2, "context");
            ((ArrayList)localObject1).add(((Context)localObject2).getResources().getString(2131766639));
            break;
            label346:
            paramAnonymousView.gzh = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, false);
          }
          label366:
          AppMethodBeat.o(190050);
          return;
        }
        paramAnonymousView = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.dP(true);
        paramAnonymousView = com.tencent.mm.live.b.g.guG;
        paramAnonymousView = com.tencent.mm.live.b.g.akA();
        Object localObject1 = com.tencent.mm.live.b.g.guG;
        long l = com.tencent.mm.live.b.g.akF().DMV;
        localObject1 = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.d.e.a(paramAnonymousView, l, com.tencent.mm.live.b.g.akH(), 4, 0);
        com.tencent.mm.live.d.a.amz();
        i.a(this.gzI);
        AppMethodBeat.o(190050);
      }
    });
    if ((!aly()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190059);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += ap.ej(paramViewGroup.getContext());
    }
    AppMethodBeat.o(190059);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190057);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (j.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190057);
      return;
      nj(8);
      AppMethodBeat.o(190057);
      return;
      nj(0);
    }
  }
  
  public final void alM()
  {
    AppMethodBeat.i(190055);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().a(3664, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190055);
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190056);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().b(3664, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190056);
  }
  
  public final void alU()
  {
    AppMethodBeat.i(190054);
    this.gzD.setVisibility(0);
    this.gzF.setVisibility(0);
    this.gzG.setVisibility(8);
    this.gzE.setClickable(true);
    if (this.gzH)
    {
      localObject = this.gzD;
      localContext = this.gnb.getContext();
      k.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691513), -1));
      localObject = this.gzF;
      localContext = this.gnb.getContext();
      k.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766570));
      AppMethodBeat.o(190054);
      return;
    }
    Object localObject = this.gzD;
    Context localContext = this.gnb.getContext();
    k.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691512), -1));
    localObject = this.gzF;
    localContext = this.gnb.getContext();
    k.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766569));
    AppMethodBeat.o(190054);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190058);
    if ((paramn instanceof com.tencent.mm.live.b.a.i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label55;
      }
      if (this.gzH) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.gzH = bool;
      alU();
      AppMethodBeat.o(190058);
      return;
    }
    label55:
    if (this.gzH)
    {
      paramString = this.gnb.getContext();
      k.g(paramString, "root.context");
    }
    for (paramString = paramString.getResources().getString(2131766572);; paramString = paramString.getResources().getString(2131766571))
    {
      t.makeText(this.gnb.getContext(), (CharSequence)paramString, 0).show();
      break;
      paramString = this.gnb.getContext();
      k.g(paramString, "root.context");
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.d
  {
    a(i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(190052);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.f.gtD;
      com.tencent.mm.live.b.g localg;
      long l;
      if (paramInt == f.f.aks())
      {
        if (!this.gzI.gzH) {
          break label98;
        }
        paramMenuItem = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.dP(false);
        paramMenuItem = com.tencent.mm.live.b.g.guG;
        paramMenuItem = com.tencent.mm.live.b.g.akA();
        localg = com.tencent.mm.live.b.g.guG;
        l = com.tencent.mm.live.b.g.akF().DMV;
        localg = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, com.tencent.mm.live.b.g.akH(), 4, 1);
        com.tencent.mm.live.d.a.amy();
      }
      for (;;)
      {
        i.a(this.gzI);
        AppMethodBeat.o(190052);
        return;
        label98:
        paramMenuItem = com.tencent.mm.live.b.i.gvw;
        com.tencent.mm.live.b.i.dP(true);
        paramMenuItem = com.tencent.mm.live.b.g.guG;
        paramMenuItem = com.tencent.mm.live.b.g.akA();
        localg = com.tencent.mm.live.b.g.guG;
        l = com.tencent.mm.live.b.g.akF().DMV;
        localg = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, com.tencent.mm.live.b.g.akH(), 4, 0);
        com.tencent.mm.live.d.a.amz();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.i
 * JD-Core Version:    0.7.0.1
 */