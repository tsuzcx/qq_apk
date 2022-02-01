package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.model.a.i;
import com.tencent.mm.live.model.l.f;
import com.tencent.mm.live.model.o;
import com.tencent.mm.live.model.u;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
  implements com.tencent.mm.am.h
{
  private Context context;
  private final b nfT;
  private final ImageView ngE;
  private final RelativeLayout ngF;
  private final TextView ngG;
  private final ProgressBar ngH;
  public boolean ngI;
  private com.tencent.mm.ui.widget.a.f ngn;
  private final u.i ngp;
  
  public f(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247028);
    this.nfT = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_icon);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_ban_comment_icon)");
    this.ngE = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_icon_click_area);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…_comment_icon_click_area)");
    this.ngF = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_icon_desc_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
    this.ngG = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_ban_comment_loading);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_ban_comment_loading)");
    this.ngH = ((ProgressBar)paramb);
    this.ngI = true;
    this.ngp = new f..ExternalSyntheticLambda2(this);
    this.ngE.setImageDrawable(bb.e(paramViewGroup.getContext().getResources().getDrawable(b.g.icons_filled_chat), -1));
    this.ngF.setOnClickListener(new f..ExternalSyntheticLambda0(this));
    if ((!isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247028);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += bf.bk(paramViewGroup.getContext());
    }
    AppMethodBeat.o(247028);
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(247079);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.ngn = null;
    AppMethodBeat.o(247079);
  }
  
  private static final void a(f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(247044);
    kotlin.g.b.s.u(paramf, "this$0");
    paramInt = paramMenuItem.getItemId();
    paramMenuItem = l.f.mYx;
    Object localObject;
    long l;
    u localu;
    if (paramInt == l.f.bhx())
    {
      if (!paramf.ngI) {
        break label107;
      }
      paramMenuItem = o.mZb;
      o.fS(false);
      paramMenuItem = u.mZl;
      paramMenuItem = u.bhZ();
      localObject = u.mZl;
      l = u.bie().mMJ;
      localObject = u.mZl;
      localObject = u.big();
      localu = u.mZl;
      e.a(paramMenuItem, l, (String)localObject, 4, 1, u.bie().ZWw);
      com.tencent.mm.live.c.a.bjJ();
    }
    for (;;)
    {
      paramf.showLoading();
      AppMethodBeat.o(247044);
      return;
      label107:
      paramMenuItem = o.mZb;
      o.fS(true);
      paramMenuItem = u.mZl;
      paramMenuItem = u.bhZ();
      localObject = u.mZl;
      l = u.bie().mMJ;
      localObject = u.mZl;
      localObject = u.big();
      localu = u.mZl;
      e.a(paramMenuItem, l, (String)localObject, 4, 0, u.bie().ZWw);
      com.tencent.mm.live.c.a.bjK();
    }
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(247062);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveBanCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramf, "this$0");
    if (paramf.ngI)
    {
      boolean bool = paramf.ngI;
      paramView = new ArrayList();
      localObject1 = new ArrayList();
      if (bool)
      {
        paramView.add(paramf.context.getResources().getString(b.h.live_menu_item_ban_comment_on));
        localObject2 = l.f.mYx;
        ((ArrayList)localObject1).add(Integer.valueOf(l.f.bhx()));
        if (!bool) {
          break label365;
        }
        paramf.ngn = new com.tencent.mm.ui.widget.a.f(paramf.context, 1, true);
        localObject2 = View.inflate(paramf.context, b.f.live_bottom_sheet_title_view, null);
        TextView localTextView = (TextView)((View)localObject2).findViewById(b.e.live_bottom_sheet_title_tv);
        com.tencent.mm.ui.widget.a.f localf = paramf.ngn;
        if (localf != null) {
          localf.af((View)localObject2, false);
        }
        localTextView.setText((CharSequence)paramf.mJe.getContext().getResources().getString(b.h.live_comment_forbid_title));
        label222:
        localObject2 = paramf.ngn;
        if (localObject2 != null) {
          ((com.tencent.mm.ui.widget.a.f)localObject2).Vtg = new f..ExternalSyntheticLambda1(paramf, paramView, (ArrayList)localObject1);
        }
        paramView = paramf.ngn;
        if (paramView != null) {
          paramView.NE(true);
        }
        paramView = paramf.ngn;
        if (paramView != null) {
          paramView.GAC = paramf.ngp;
        }
        paramView = paramf.ngn;
        if (paramView != null) {
          paramView.aeLi = new f..ExternalSyntheticLambda3(paramf);
        }
        paramf = paramf.ngn;
        if (paramf != null) {
          paramf.dDn();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveBanCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247062);
      return;
      paramView.add(paramf.context.getResources().getString(b.h.live_menu_item_ban_comment_off));
      break;
      label365:
      paramf.ngn = new com.tencent.mm.ui.widget.a.f(paramf.context, 1, false);
      break label222;
      paramView = o.mZb;
      o.fS(true);
      paramView = u.mZl;
      paramView = u.bhZ();
      localObject1 = u.mZl;
      long l = u.bie().mMJ;
      localObject1 = u.mZl;
      localObject1 = u.big();
      localObject2 = u.mZl;
      e.a(paramView, l, (String)localObject1, 4, 0, u.bie().ZWw);
      com.tencent.mm.live.c.a.bjK();
      paramf.showLoading();
    }
  }
  
  private static final void a(f paramf, ArrayList paramArrayList1, ArrayList paramArrayList2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(247069);
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramArrayList1, "$titles");
    kotlin.g.b.s.u(paramArrayList2, "$ids");
    Object localObject = paramf.ngn;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject).setFooterView(null);
    }
    params.clear();
    int k = paramArrayList1.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject = paramArrayList2.get(i);
      kotlin.g.b.s.s(localObject, "ids[i]");
      params.a(((Number)localObject).intValue(), paramf.context.getResources().getColor(b.b.live_title_host_close_btn_color), (CharSequence)paramArrayList1.get(i));
      if (j > k)
      {
        AppMethodBeat.o(247069);
        return;
      }
    }
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(247034);
    this.ngE.setVisibility(4);
    this.ngG.setVisibility(4);
    this.ngH.setVisibility(0);
    this.ngF.setClickable(false);
    AppMethodBeat.o(247034);
  }
  
  public final void bjg()
  {
    AppMethodBeat.i(247122);
    this.ngE.setVisibility(0);
    this.ngG.setVisibility(0);
    this.ngH.setVisibility(8);
    this.ngF.setClickable(true);
    if (this.ngI)
    {
      this.ngE.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(b.g.icons_filled_chat), -1));
      this.ngG.setText((CharSequence)this.mJe.getContext().getResources().getString(b.h.live_ban_comment_desc_on));
      AppMethodBeat.o(247122);
      return;
    }
    this.ngE.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(b.g.icons_filled_ban_comment), -1));
    this.ngG.setText((CharSequence)this.mJe.getContext().getResources().getString(b.h.live_ban_comment_desc_off));
    AppMethodBeat.o(247122);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(247130);
    com.tencent.mm.kernel.h.baD().mCm.a(3664, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247130);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(247159);
    if ((paramp instanceof i))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label55;
      }
      if (this.ngI) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.ngI = bool;
      bjg();
      AppMethodBeat.o(247159);
      return;
    }
    label55:
    if (this.ngI) {}
    for (paramString = this.mJe.getContext().getResources().getString(b.h.live_ban_comment_on_fail_tip);; paramString = this.mJe.getContext().getResources().getString(b.h.live_ban_comment_off_fail_tip))
    {
      kotlin.g.b.s.s(paramString, "if (enableComment) {\n   …il_tip)\n                }");
      aa.makeText(this.mJe.getContext(), (CharSequence)paramString, 0).show();
      break;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247151);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (f.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247151);
      return;
      tO(8);
      AppMethodBeat.o(247151);
      return;
      tO(0);
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247140);
    com.tencent.mm.kernel.h.baD().mCm.b(3664, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.f
 * JD-Core Version:    0.7.0.1
 */