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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.f.f;
import com.tencent.mm.protocal.protobuf.bvk;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"})
public final class i
  extends a
  implements f
{
  Context context;
  com.tencent.mm.ui.widget.a.e gVB;
  final n.e gVD;
  private final ImageView gVX;
  private final RelativeLayout gVY;
  private final TextView gVZ;
  private final b gVv;
  private final ProgressBar gWa;
  public boolean gWb;
  
  public i(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(215967);
    this.gVv = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307578);
    p.g(paramb, "root.findViewById(R.id.live_ban_comment_icon)");
    this.gVX = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307579);
    p.g(paramb, "root.findViewById(R.id.l…_comment_icon_click_area)");
    this.gVY = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307580);
    p.g(paramb, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
    this.gVZ = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307582);
    p.g(paramb, "root.findViewById(R.id.live_ban_comment_loading)");
    this.gWa = ((ProgressBar)paramb);
    this.gWb = true;
    this.gVD = ((n.e)new a(this));
    paramb = this.gVX;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691513), -1));
    this.gVY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215958);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        Object localObject2;
        Object localObject3;
        if (this.gWc.gWb)
        {
          paramAnonymousView = this.gWc;
          boolean bool = this.gWc.gWb;
          localObject1 = new ArrayList();
          localObject2 = new ArrayList();
          if (bool)
          {
            localObject3 = paramAnonymousView.context;
            p.g(localObject3, "context");
            ((ArrayList)localObject1).add(((Context)localObject3).getResources().getString(2131766640));
            localObject3 = f.f.gPX;
            ((ArrayList)localObject2).add(Integer.valueOf(f.f.anu()));
            if (!bool) {
              break label390;
            }
            paramAnonymousView.gVB = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, true);
            Object localObject4 = View.inflate(paramAnonymousView.context, 2131496305, null);
            localObject3 = (TextView)((View)localObject4).findViewById(2131307596);
            com.tencent.mm.ui.widget.a.e locale = paramAnonymousView.gVB;
            if (locale != null) {
              locale.hf((View)localObject4);
            }
            p.g(localObject3, "bottomSheetTitleTv");
            localObject4 = paramAnonymousView.gJt.getContext();
            p.g(localObject4, "root.context");
            ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getResources().getString(2131766577));
            label232:
            localObject3 = paramAnonymousView.gVB;
            if (localObject3 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject3).a((n.d)new i.b(paramAnonymousView, (ArrayList)localObject1, (ArrayList)localObject2));
            }
            localObject1 = paramAnonymousView.gVB;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).fQx();
            }
            localObject1 = paramAnonymousView.gVB;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).a(paramAnonymousView.gVD);
            }
            localObject1 = paramAnonymousView.gVB;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new i.c(paramAnonymousView));
            }
            paramAnonymousView = paramAnonymousView.gVB;
            if (paramAnonymousView != null) {
              paramAnonymousView.cPF();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215958);
          return;
          localObject3 = paramAnonymousView.context;
          p.g(localObject3, "context");
          ((ArrayList)localObject1).add(((Context)localObject3).getResources().getString(2131766639));
          break;
          label390:
          paramAnonymousView.gVB = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, false);
          break label232;
          paramAnonymousView = com.tencent.mm.live.b.i.gRP;
          com.tencent.mm.live.b.i.dT(true);
          paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
          paramAnonymousView = com.tencent.mm.live.b.g.anC();
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          long l = com.tencent.mm.live.b.g.anH().FKy;
          localObject1 = com.tencent.mm.live.b.g.gQZ;
          localObject1 = com.tencent.mm.live.b.g.anJ();
          localObject2 = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.d.e.a(paramAnonymousView, l, (String)localObject1, 4, 0, com.tencent.mm.live.b.g.anH().GTv);
          com.tencent.mm.live.d.a.apA();
          i.a(this.gWc);
        }
      }
    });
    if ((!aoA()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(215967);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += ar.en(paramViewGroup.getContext());
    }
    AppMethodBeat.o(215967);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(215965);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (j.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215965);
      return;
      nL(8);
      AppMethodBeat.o(215965);
      return;
      nL(0);
    }
  }
  
  public final void aoO()
  {
    AppMethodBeat.i(215963);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().a(3664, (f)this);
    AppMethodBeat.o(215963);
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(215964);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(3664, (f)this);
    AppMethodBeat.o(215964);
  }
  
  public final void aoV()
  {
    AppMethodBeat.i(215962);
    this.gVX.setVisibility(0);
    this.gVZ.setVisibility(0);
    this.gWa.setVisibility(8);
    this.gVY.setClickable(true);
    if (this.gWb)
    {
      localObject = this.gVX;
      localContext = this.gJt.getContext();
      p.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691513), -1));
      localObject = this.gVZ;
      localContext = this.gJt.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766570));
      AppMethodBeat.o(215962);
      return;
    }
    Object localObject = this.gVX;
    Context localContext = this.gJt.getContext();
    p.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691512), -1));
    localObject = this.gVZ;
    localContext = this.gJt.getContext();
    p.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766569));
    AppMethodBeat.o(215962);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215966);
    if ((paramn instanceof com.tencent.mm.live.b.a.i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label55;
      }
      if (this.gWb) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.gWb = bool;
      aoV();
      AppMethodBeat.o(215966);
      return;
    }
    label55:
    if (this.gWb)
    {
      paramString = this.gJt.getContext();
      p.g(paramString, "root.context");
    }
    for (paramString = paramString.getResources().getString(2131766572);; paramString = paramString.getResources().getString(2131766571))
    {
      t.makeText(this.gJt.getContext(), (CharSequence)paramString, 0).show();
      break;
      paramString = this.gJt.getContext();
      p.g(paramString, "root.context");
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.e
  {
    a(i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(215960);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.f.gPX;
      Object localObject;
      long l;
      com.tencent.mm.live.b.g localg;
      if (paramInt == f.f.anu())
      {
        if (!this.gWc.gWb) {
          break label113;
        }
        paramMenuItem = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.dT(false);
        paramMenuItem = com.tencent.mm.live.b.g.gQZ;
        paramMenuItem = com.tencent.mm.live.b.g.anC();
        localObject = com.tencent.mm.live.b.g.gQZ;
        l = com.tencent.mm.live.b.g.anH().FKy;
        localObject = com.tencent.mm.live.b.g.gQZ;
        localObject = com.tencent.mm.live.b.g.anJ();
        localg = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, (String)localObject, 4, 1, com.tencent.mm.live.b.g.anH().GTv);
        com.tencent.mm.live.d.a.apz();
      }
      for (;;)
      {
        i.a(this.gWc);
        AppMethodBeat.o(215960);
        return;
        label113:
        paramMenuItem = com.tencent.mm.live.b.i.gRP;
        com.tencent.mm.live.b.i.dT(true);
        paramMenuItem = com.tencent.mm.live.b.g.gQZ;
        paramMenuItem = com.tencent.mm.live.b.g.anC();
        localObject = com.tencent.mm.live.b.g.gQZ;
        l = com.tencent.mm.live.b.g.anH().FKy;
        localObject = com.tencent.mm.live.b.g.gQZ;
        localObject = com.tencent.mm.live.b.g.anJ();
        localg = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, (String)localObject, 4, 0, com.tencent.mm.live.b.g.anH().GTv);
        com.tencent.mm.live.d.a.apA();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.d
  {
    b(i parami, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(215961);
      Object localObject = this.gWc.gVB;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paraml.clear();
      int i = 0;
      int j = ((Collection)this.gVH).size();
      while (i < j)
      {
        localObject = this.gVI.get(i);
        p.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.gWc.context;
        p.g(localObject, "context");
        paraml.a(k, ((Context)localObject).getResources().getColor(2131101209), (CharSequence)this.gVH.get(i));
        i += 1;
      }
      AppMethodBeat.o(215961);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(i parami) {}
    
    public final void onDismiss()
    {
      this.gWc.gVB = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.i
 * JD-Core Version:    0.7.0.1
 */