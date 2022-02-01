package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.live.b.e.f;
import com.tencent.mm.live.b.f;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"})
public final class i
  extends a
  implements com.tencent.mm.al.g
{
  private final b IIs;
  com.tencent.mm.ui.widget.a.e IIx;
  final n.d IIy;
  final ImageView KtZ;
  final RelativeLayout Kua;
  final TextView Kub;
  final ProgressBar Kuc;
  public boolean Kud;
  Context context;
  
  public i(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202855);
    this.IIs = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307500);
    k.g(paramb, "root.findViewById(R.id.live_ban_comment_icon)");
    this.KtZ = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307501);
    k.g(paramb, "root.findViewById(R.id.l…_comment_icon_click_area)");
    this.Kua = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307502);
    k.g(paramb, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
    this.Kub = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307504);
    k.g(paramb, "root.findViewById(R.id.live_ban_comment_loading)");
    this.Kuc = ((ProgressBar)paramb);
    this.Kud = true;
    this.IIy = ((n.d)new a(this));
    paramb = this.KtZ;
    Context localContext = paramViewGroup.getContext();
    k.g(localContext, "root.context");
    paramb.setImageDrawable(am.e(localContext.getResources().getDrawable(2131691502), -1));
    this.Kua.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202846);
        paramAnonymousView = this.Kue;
        boolean bool = this.Kue.Kud;
        Object localObject1 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        Object localObject2;
        if (bool)
        {
          localObject2 = paramAnonymousView.context;
          k.g(localObject2, "context");
          ((ArrayList)localObject1).add(((Context)localObject2).getResources().getString(2131766607));
          localObject2 = e.f.rDA;
          localArrayList.add(Integer.valueOf(e.f.eNb()));
          if (!bool) {
            break label252;
          }
          paramAnonymousView.IIx = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, true);
          localObject2 = paramAnonymousView.IIx;
          if (localObject2 != null) {
            ((com.tencent.mm.ui.widget.a.e)localObject2).gU(View.inflate(paramAnonymousView.context, 2131496304, null));
          }
        }
        for (;;)
        {
          localObject2 = paramAnonymousView.IIx;
          if (localObject2 != null) {
            ((com.tencent.mm.ui.widget.a.e)localObject2).a((n.c)new i.b(paramAnonymousView, (ArrayList)localObject1, localArrayList));
          }
          localObject1 = paramAnonymousView.IIx;
          if (localObject1 != null) {
            ((com.tencent.mm.ui.widget.a.e)localObject1).a(paramAnonymousView.IIy);
          }
          localObject1 = paramAnonymousView.IIx;
          if (localObject1 != null) {
            ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new i.c(paramAnonymousView));
          }
          paramAnonymousView = paramAnonymousView.IIx;
          if (paramAnonymousView == null) {
            break label272;
          }
          paramAnonymousView.csG();
          AppMethodBeat.o(202846);
          return;
          localObject2 = paramAnonymousView.context;
          k.g(localObject2, "context");
          ((ArrayList)localObject1).add(((Context)localObject2).getResources().getString(2131766606));
          break;
          label252:
          paramAnonymousView.IIx = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, false);
        }
        label272:
        AppMethodBeat.o(202846);
      }
    });
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new LinearLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ap.eb(this.context);
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Linear…>(R.id.content_root_view)");
      ((LinearLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(202855);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202853);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (j.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202853);
      return;
      agK(8);
      AppMethodBeat.o(202853);
      return;
      agK(0);
    }
  }
  
  public final void fOM()
  {
    AppMethodBeat.i(202851);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(3664, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(202851);
  }
  
  public final void fON()
  {
    AppMethodBeat.i(202852);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b(3664, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(202852);
  }
  
  public final void fOR()
  {
    AppMethodBeat.i(202850);
    this.KtZ.setVisibility(0);
    this.Kub.setVisibility(0);
    this.Kuc.setVisibility(8);
    this.Kua.setClickable(true);
    if (this.Kud)
    {
      localObject = this.KtZ;
      localContext = this.pTc.getContext();
      k.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691502), -1));
      localObject = this.Kub;
      localContext = this.pTc.getContext();
      k.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766550));
      AppMethodBeat.o(202850);
      return;
    }
    Object localObject = this.KtZ;
    Context localContext = this.pTc.getContext();
    k.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691501), -1));
    localObject = this.Kub;
    localContext = this.pTc.getContext();
    k.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766549));
    AppMethodBeat.o(202850);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(202854);
    if ((paramn instanceof com.tencent.mm.live.b.a.h))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label55;
      }
      if (this.Kud) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.Kud = bool;
      fOR();
      AppMethodBeat.o(202854);
      return;
    }
    label55:
    if (this.Kud)
    {
      paramString = this.pTc.getContext();
      k.g(paramString, "root.context");
    }
    for (paramString = paramString.getResources().getString(2131766552);; paramString = paramString.getResources().getString(2131766551))
    {
      t.makeText(this.pTc.getContext(), (CharSequence)paramString, 0).show();
      break;
      paramString = this.pTc.getContext();
      k.g(paramString, "root.context");
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.d
  {
    a(i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(202848);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = e.f.rDA;
      f localf;
      long l;
      if (paramInt == e.f.eNb())
      {
        if (!this.Kue.Kud) {
          break label128;
        }
        paramMenuItem = com.tencent.mm.live.b.h.xfu;
        com.tencent.mm.live.b.h.ng(false);
        paramMenuItem = f.rGw;
        paramMenuItem = f.eNB();
        localf = f.rGw;
        l = f.eNG().LwA;
        localf = f.rGw;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, f.eNI(), 4, 1);
        com.tencent.mm.live.d.a.fPm();
      }
      for (;;)
      {
        paramMenuItem = this.Kue;
        paramMenuItem.KtZ.setVisibility(4);
        paramMenuItem.Kub.setVisibility(4);
        paramMenuItem.Kuc.setVisibility(0);
        paramMenuItem.Kua.setClickable(false);
        AppMethodBeat.o(202848);
        return;
        label128:
        paramMenuItem = com.tencent.mm.live.b.h.xfu;
        com.tencent.mm.live.b.h.ng(true);
        paramMenuItem = f.rGw;
        paramMenuItem = f.eNB();
        localf = f.rGw;
        l = f.eNG().LwA;
        localf = f.rGw;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, f.eNI(), 4, 0);
        com.tencent.mm.live.d.a.fPn();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.c
  {
    b(i parami, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(202849);
      Object localObject = this.Kue.IIx;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paraml.clear();
      int i = 0;
      int j = ((Collection)this.IIC).size();
      while (i < j)
      {
        localObject = this.IID.get(i);
        k.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.Kue.context;
        k.g(localObject, "context");
        paraml.a(k, ((Context)localObject).getResources().getColor(2131101208), (CharSequence)this.IIC.get(i));
        i += 1;
      }
      AppMethodBeat.o(202849);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(i parami) {}
    
    public final void onDismiss()
    {
      this.Kue.IIx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.i
 * JD-Core Version:    0.7.0.1
 */