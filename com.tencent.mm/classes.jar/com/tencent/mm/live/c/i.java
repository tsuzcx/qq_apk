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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"})
public final class i
  extends a
  implements com.tencent.mm.ak.i
{
  Context context;
  private final ImageView hOR;
  private final RelativeLayout hOS;
  private final TextView hOT;
  private final ProgressBar hOU;
  public boolean hOV;
  private final b hOp;
  com.tencent.mm.ui.widget.a.e hOv;
  final com.tencent.mm.ui.base.o.g hOx;
  
  public i(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(207929);
    this.hOp = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303338);
    p.g(paramb, "root.findViewById(R.id.live_ban_comment_icon)");
    this.hOR = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303339);
    p.g(paramb, "root.findViewById(R.id.l…_comment_icon_click_area)");
    this.hOS = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131303340);
    p.g(paramb, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
    this.hOT = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303342);
    p.g(paramb, "root.findViewById(R.id.live_ban_comment_loading)");
    this.hOU = ((ProgressBar)paramb);
    this.hOV = true;
    this.hOx = ((com.tencent.mm.ui.base.o.g)new a(this));
    paramb = this.hOR;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690508), -1));
    this.hOS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207920);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Object localObject2;
        Object localObject3;
        if (this.hOW.hOV)
        {
          paramAnonymousView = this.hOW;
          boolean bool = this.hOW.hOV;
          localObject1 = new ArrayList();
          localObject2 = new ArrayList();
          if (bool)
          {
            localObject3 = paramAnonymousView.context;
            p.g(localObject3, "context");
            ((ArrayList)localObject1).add(((Context)localObject3).getResources().getString(2131762333));
            localObject3 = com.tencent.mm.live.b.o.g.hHa;
            ((ArrayList)localObject2).add(Integer.valueOf(com.tencent.mm.live.b.o.g.aFF()));
            if (!bool) {
              break label390;
            }
            paramAnonymousView.hOv = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, true);
            Object localObject4 = View.inflate(paramAnonymousView.context, 2131495244, null);
            localObject3 = (TextView)((View)localObject4).findViewById(2131303357);
            com.tencent.mm.ui.widget.a.e locale = paramAnonymousView.hOv;
            if (locale != null) {
              locale.setTitleView((View)localObject4);
            }
            p.g(localObject3, "bottomSheetTitleTv");
            localObject4 = paramAnonymousView.hwr.getContext();
            p.g(localObject4, "root.context");
            ((TextView)localObject3).setText((CharSequence)((Context)localObject4).getResources().getString(2131762265));
            label232:
            localObject3 = paramAnonymousView.hOv;
            if (localObject3 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject3).a((o.f)new i.b(paramAnonymousView, (ArrayList)localObject1, (ArrayList)localObject2));
            }
            localObject1 = paramAnonymousView.hOv;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).hbr();
            }
            localObject1 = paramAnonymousView.hOv;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).a(paramAnonymousView.hOx);
            }
            localObject1 = paramAnonymousView.hOv;
            if (localObject1 != null) {
              ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new i.c(paramAnonymousView));
            }
            paramAnonymousView = paramAnonymousView.hOv;
            if (paramAnonymousView != null) {
              paramAnonymousView.dGm();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207920);
          return;
          localObject3 = paramAnonymousView.context;
          p.g(localObject3, "context");
          ((ArrayList)localObject1).add(((Context)localObject3).getResources().getString(2131762332));
          break;
          label390:
          paramAnonymousView.hOv = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.context, 1, false);
          break label232;
          paramAnonymousView = r.hIg;
          r.eF(true);
          paramAnonymousView = x.hJf;
          paramAnonymousView = x.aGm();
          localObject1 = x.hJf;
          long l = x.aGr().hyH;
          localObject1 = x.hJf;
          localObject1 = x.aGt();
          localObject2 = x.hJf;
          com.tencent.mm.live.d.e.a(paramAnonymousView, l, (String)localObject1, 4, 0, x.aGr().LIa);
          com.tencent.mm.live.d.a.aHZ();
          i.a(this.hOW);
        }
      }
    });
    if ((!isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(207929);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += au.aD(paramViewGroup.getContext());
    }
    AppMethodBeat.o(207929);
  }
  
  public final void aHu()
  {
    AppMethodBeat.i(207924);
    this.hOR.setVisibility(0);
    this.hOT.setVisibility(0);
    this.hOU.setVisibility(8);
    this.hOS.setClickable(true);
    if (this.hOV)
    {
      localObject = this.hOR;
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690508), -1));
      localObject = this.hOT;
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131762257));
      AppMethodBeat.o(207924);
      return;
    }
    Object localObject = this.hOR;
    Context localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690488), -1));
    localObject = this.hOT;
    localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131762256));
    AppMethodBeat.o(207924);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(207925);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3664, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(207925);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(207928);
    if ((paramq instanceof com.tencent.mm.live.b.a.i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label55;
      }
      if (this.hOV) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.hOV = bool;
      aHu();
      AppMethodBeat.o(207928);
      return;
    }
    label55:
    if (this.hOV)
    {
      paramString = this.hwr.getContext();
      p.g(paramString, "root.context");
    }
    for (paramString = paramString.getResources().getString(2131762259);; paramString = paramString.getResources().getString(2131762258))
    {
      p.g(paramString, "if (enableComment) {\n   …il_tip)\n                }");
      u.makeText(this.hwr.getContext(), (CharSequence)paramString, 0).show();
      break;
      paramString = this.hwr.getContext();
      p.g(paramString, "root.context");
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(207927);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (j.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207927);
      return;
      rg(8);
      AppMethodBeat.o(207927);
      return;
      rg(0);
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(207926);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3664, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(207926);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements com.tencent.mm.ui.base.o.g
  {
    a(i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(207922);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = com.tencent.mm.live.b.o.g.hHa;
      Object localObject;
      long l;
      x localx;
      if (paramInt == com.tencent.mm.live.b.o.g.aFF())
      {
        if (!this.hOW.hOV) {
          break label113;
        }
        paramMenuItem = r.hIg;
        r.eF(false);
        paramMenuItem = x.hJf;
        paramMenuItem = x.aGm();
        localObject = x.hJf;
        l = x.aGr().hyH;
        localObject = x.hJf;
        localObject = x.aGt();
        localx = x.hJf;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, (String)localObject, 4, 1, x.aGr().LIa);
        com.tencent.mm.live.d.a.aHY();
      }
      for (;;)
      {
        i.a(this.hOW);
        AppMethodBeat.o(207922);
        return;
        label113:
        paramMenuItem = r.hIg;
        r.eF(true);
        paramMenuItem = x.hJf;
        paramMenuItem = x.aGm();
        localObject = x.hJf;
        l = x.aGr().hyH;
        localObject = x.hJf;
        localObject = x.aGt();
        localx = x.hJf;
        com.tencent.mm.live.d.e.a(paramMenuItem, l, (String)localObject, 4, 0, x.aGr().LIa);
        com.tencent.mm.live.d.a.aHZ();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements o.f
  {
    b(i parami, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(207923);
      Object localObject = this.hOW.hOv;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramm.clear();
      int i = 0;
      int j = ((Collection)this.hOB).size();
      while (i < j)
      {
        localObject = this.hOC.get(i);
        p.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.hOW.context;
        p.g(localObject, "context");
        paramm.a(k, ((Context)localObject).getResources().getColor(2131100712), (CharSequence)this.hOB.get(i));
        i += 1;
      }
      AppMethodBeat.o(207923);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(i parami) {}
    
    public final void onDismiss()
    {
      this.hOW.hOv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.i
 * JD-Core Version:    0.7.0.1
 */