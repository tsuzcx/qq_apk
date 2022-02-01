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
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.l.f;
import com.tencent.mm.live.b.u;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"})
public final class i
  extends a
  implements com.tencent.mm.an.i
{
  private Context context;
  private final b kCL;
  private com.tencent.mm.ui.widget.a.e kCR;
  private final q.g kCT;
  private final ImageView kDn;
  private final RelativeLayout kDo;
  private final TextView kDp;
  private final ProgressBar kDq;
  public boolean kDr;
  
  public i(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190442);
    this.kCL = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_icon);
    p.j(paramb, "root.findViewById(R.id.live_ban_comment_icon)");
    this.kDn = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_icon_click_area);
    p.j(paramb, "root.findViewById(R.id.l…_comment_icon_click_area)");
    this.kDo = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_icon_desc_tv);
    p.j(paramb, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
    this.kDp = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_loading);
    p.j(paramb, "root.findViewById(R.id.live_ban_comment_loading)");
    this.kDq = ((ProgressBar)paramb);
    this.kDr = true;
    this.kCT = ((q.g)new a(this));
    paramb = this.kDn;
    Context localContext = paramViewGroup.getContext();
    p.j(localContext, "root.context");
    paramb.setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_chat), -1));
    this.kDo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193562);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (this.kDs.kDr) {
          i.a(this.kDs, this.kDs.kDr);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(193562);
          return;
          paramAnonymousView = com.tencent.mm.live.b.o.kvA;
          com.tencent.mm.live.b.o.fl(true);
          paramAnonymousView = u.kwz;
          paramAnonymousView = u.aOm();
          localObject = u.kwz;
          long l = u.aOr().klE;
          localObject = u.kwz;
          localObject = u.aOt();
          u localu = u.kwz;
          com.tencent.mm.live.d.e.a(paramAnonymousView, l, (String)localObject, 4, 0, u.aOr().SOs);
          com.tencent.mm.live.d.a.aPX();
          i.d(this.kDs);
        }
      }
    });
    if ((!isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190442);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += ax.aB(paramViewGroup.getContext());
    }
    AppMethodBeat.o(190442);
  }
  
  public final void aPu()
  {
    AppMethodBeat.i(190406);
    this.kDn.setVisibility(0);
    this.kDp.setVisibility(0);
    this.kDq.setVisibility(8);
    this.kDo.setClickable(true);
    if (this.kDr)
    {
      localObject = this.kDn;
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_chat), -1));
      localObject = this.kDp;
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.h.live_ban_comment_desc_on));
      AppMethodBeat.o(190406);
      return;
    }
    Object localObject = this.kDn;
    Context localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_ban_comment), -1));
    localObject = this.kDp;
    localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.h.live_ban_comment_desc_off));
    AppMethodBeat.o(190406);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(190411);
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(3664, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(190411);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(190430);
    if ((paramq instanceof com.tencent.mm.live.b.a.i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label55;
      }
      if (this.kDr) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.kDr = bool;
      aPu();
      AppMethodBeat.o(190430);
      return;
    }
    label55:
    if (this.kDr)
    {
      paramString = this.kiF.getContext();
      p.j(paramString, "root.context");
    }
    for (paramString = paramString.getResources().getString(b.h.live_ban_comment_on_fail_tip);; paramString = paramString.getResources().getString(b.h.live_ban_comment_off_fail_tip))
    {
      p.j(paramString, "if (enableComment) {\n   …il_tip)\n                }");
      w.makeText(this.kiF.getContext(), (CharSequence)paramString, 0).show();
      break;
      paramString = this.kiF.getContext();
      p.j(paramString, "root.context");
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190419);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (j.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190419);
      return;
      tU(8);
      AppMethodBeat.o(190419);
      return;
      tU(0);
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(190415);
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3664, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(190415);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements q.g
  {
    a(i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(200125);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = l.f.kuF;
      Object localObject;
      long l;
      u localu;
      if (paramInt == l.f.aNM())
      {
        if (!this.kDs.kDr) {
          break label113;
        }
        paramMenuItem = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.fl(false);
        paramMenuItem = u.kwz;
        paramMenuItem = u.aOm();
        localObject = u.kwz;
        l = u.aOr().klE;
        localObject = u.kwz;
        localObject = u.aOt();
        localu = u.kwz;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, (String)localObject, 4, 1, u.aOr().SOs);
        com.tencent.mm.live.d.a.aPW();
      }
      for (;;)
      {
        i.d(this.kDs);
        AppMethodBeat.o(200125);
        return;
        label113:
        paramMenuItem = com.tencent.mm.live.b.o.kvA;
        com.tencent.mm.live.b.o.fl(true);
        paramMenuItem = u.kwz;
        paramMenuItem = u.aOm();
        localObject = u.kwz;
        l = u.aOr().klE;
        localObject = u.kwz;
        localObject = u.aOt();
        localu = u.kwz;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, (String)localObject, 4, 0, u.aOr().SOs);
        com.tencent.mm.live.d.a.aPX();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    b(i parami, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(202006);
      Object localObject = i.a(this.kDs);
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramo.clear();
      int i = 0;
      int j = ((Collection)this.kCX).size();
      while (i < j)
      {
        localObject = this.kCY.get(i);
        p.j(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = i.c(this.kDs);
        p.j(localObject, "context");
        paramo.a(k, ((Context)localObject).getResources().getColor(b.b.live_title_host_close_btn_color), (CharSequence)this.kCX.get(i));
        i += 1;
      }
      AppMethodBeat.o(202006);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(i parami) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(201528);
      i.b(this.kDs);
      AppMethodBeat.o(201528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.i
 * JD-Core Version:    0.7.0.1
 */