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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.live.b.f.f;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.p;
import d.v;
import java.util.ArrayList;
import java.util.Collection;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"})
public final class i
  extends a
  implements f
{
  Context context;
  private final b gSM;
  com.tencent.mm.ui.widget.a.e gSS;
  final n.e gSU;
  private final ImageView gTo;
  private final RelativeLayout gTp;
  private final TextView gTq;
  private final ProgressBar gTr;
  public boolean gTs;
  
  public i(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212347);
    this.gSM = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307578);
    p.g(paramb, "root.findViewById(R.id.live_ban_comment_icon)");
    this.gTo = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307579);
    p.g(paramb, "root.findViewById(R.id.l…_comment_icon_click_area)");
    this.gTp = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307580);
    p.g(paramb, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
    this.gTq = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307582);
    p.g(paramb, "root.findViewById(R.id.live_ban_comment_loading)");
    this.gTr = ((ProgressBar)paramb);
    this.gTs = true;
    this.gSU = ((n.e)new a(this));
    paramb = this.gTo;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691513), -1));
    this.gTp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212338);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        Object localObject2;
        if (this.gTt.gTs)
        {
          paramAnonymousView = this.gTt;
          boolean bool = this.gTt.gTs;
          localObject1 = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          if (bool)
          {
            localObject2 = paramAnonymousView.context;
            p.g(localObject2, "context");
            ((ArrayList)localObject1).add(((Context)localObject2).getResources().getString(2131766640));
            localObject2 = f.f.gNo;
            localArrayList.add(Integer.valueOf(f.f.ane()));
            if (!bool) {
              break label390;
            }
            paramAnonymousView.gSS = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, true);
            Object localObject3 = View.inflate(paramAnonymousView.context, 2131496305, null);
            localObject2 = (TextView)((View)localObject3).findViewById(2131307596);
            com.tencent.mm.ui.widget.a.e locale = paramAnonymousView.gSS;
            if (locale != null) {
              locale.ha((View)localObject3);
            }
            p.g(localObject2, "bottomSheetTitleTv");
            localObject3 = paramAnonymousView.gGK.getContext();
            p.g(localObject3, "root.context");
            ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getResources().getString(2131766577));
            label232:
            localObject2 = paramAnonymousView.gSS;
            if (localObject2 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject2).a((n.d)new i.b(paramAnonymousView, (ArrayList)localObject1, localArrayList));
            }
            localObject1 = paramAnonymousView.gSS;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).fMd();
            }
            localObject1 = paramAnonymousView.gSS;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).a(paramAnonymousView.gSU);
            }
            localObject1 = paramAnonymousView.gSS;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new i.c(paramAnonymousView));
            }
            paramAnonymousView = paramAnonymousView.gSS;
            if (paramAnonymousView != null) {
              paramAnonymousView.cMW();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212338);
          return;
          localObject2 = paramAnonymousView.context;
          p.g(localObject2, "context");
          ((ArrayList)localObject1).add(((Context)localObject2).getResources().getString(2131766639));
          break;
          label390:
          paramAnonymousView.gSS = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, false);
          break label232;
          paramAnonymousView = com.tencent.mm.live.b.i.gPh;
          com.tencent.mm.live.b.i.dR(true);
          paramAnonymousView = com.tencent.mm.live.b.g.gOr;
          paramAnonymousView = com.tencent.mm.live.b.g.anm();
          localObject1 = com.tencent.mm.live.b.g.gOr;
          long l = com.tencent.mm.live.b.g.ans().Fsa;
          localObject1 = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.d.e.a(paramAnonymousView, l, com.tencent.mm.live.b.g.anu(), 4, 0);
          com.tencent.mm.live.d.a.apm();
          i.a(this.gTt);
        }
      }
    });
    if ((!aol()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212347);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += ar.ej(paramViewGroup.getContext());
    }
    AppMethodBeat.o(212347);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212345);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (j.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212345);
      return;
      nI(8);
      AppMethodBeat.o(212345);
      return;
      nI(0);
    }
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212344);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(3664, (f)this);
    AppMethodBeat.o(212344);
  }
  
  public final void aoH()
  {
    AppMethodBeat.i(212342);
    this.gTo.setVisibility(0);
    this.gTq.setVisibility(0);
    this.gTr.setVisibility(8);
    this.gTp.setClickable(true);
    if (this.gTs)
    {
      localObject = this.gTo;
      localContext = this.gGK.getContext();
      p.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691513), -1));
      localObject = this.gTq;
      localContext = this.gGK.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766570));
      AppMethodBeat.o(212342);
      return;
    }
    Object localObject = this.gTo;
    Context localContext = this.gGK.getContext();
    p.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691512), -1));
    localObject = this.gTq;
    localContext = this.gGK.getContext();
    p.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766569));
    AppMethodBeat.o(212342);
  }
  
  public final void aoz()
  {
    AppMethodBeat.i(212343);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().a(3664, (f)this);
    AppMethodBeat.o(212343);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212346);
    if ((paramn instanceof com.tencent.mm.live.b.a.i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label55;
      }
      if (this.gTs) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.gTs = bool;
      aoH();
      AppMethodBeat.o(212346);
      return;
    }
    label55:
    if (this.gTs)
    {
      paramString = this.gGK.getContext();
      p.g(paramString, "root.context");
    }
    for (paramString = paramString.getResources().getString(2131766572);; paramString = paramString.getResources().getString(2131766571))
    {
      t.makeText(this.gGK.getContext(), (CharSequence)paramString, 0).show();
      break;
      paramString = this.gGK.getContext();
      p.g(paramString, "root.context");
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.e
  {
    a(i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(212340);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.f.gNo;
      com.tencent.mm.live.b.g localg;
      long l;
      if (paramInt == f.f.ane())
      {
        if (!this.gTt.gTs) {
          break label98;
        }
        paramMenuItem = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.dR(false);
        paramMenuItem = com.tencent.mm.live.b.g.gOr;
        paramMenuItem = com.tencent.mm.live.b.g.anm();
        localg = com.tencent.mm.live.b.g.gOr;
        l = com.tencent.mm.live.b.g.ans().Fsa;
        localg = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, com.tencent.mm.live.b.g.anu(), 4, 1);
        com.tencent.mm.live.d.a.apl();
      }
      for (;;)
      {
        i.a(this.gTt);
        AppMethodBeat.o(212340);
        return;
        label98:
        paramMenuItem = com.tencent.mm.live.b.i.gPh;
        com.tencent.mm.live.b.i.dR(true);
        paramMenuItem = com.tencent.mm.live.b.g.gOr;
        paramMenuItem = com.tencent.mm.live.b.g.anm();
        localg = com.tencent.mm.live.b.g.gOr;
        l = com.tencent.mm.live.b.g.ans().Fsa;
        localg = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, com.tencent.mm.live.b.g.anu(), 4, 0);
        com.tencent.mm.live.d.a.apm();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.d
  {
    b(i parami, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(212341);
      Object localObject = this.gTt.gSS;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paraml.clear();
      int i = 0;
      int j = ((Collection)this.gSY).size();
      while (i < j)
      {
        localObject = this.gSZ.get(i);
        p.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.gTt.context;
        p.g(localObject, "context");
        paraml.a(k, ((Context)localObject).getResources().getColor(2131101209), (CharSequence)this.gSY.get(i));
        i += 1;
      }
      AppMethodBeat.o(212341);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(i parami) {}
    
    public final void onDismiss()
    {
      this.gTt.gSS = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.i
 * JD-Core Version:    0.7.0.1
 */