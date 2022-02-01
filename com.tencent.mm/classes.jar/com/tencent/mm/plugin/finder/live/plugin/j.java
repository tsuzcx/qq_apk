package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.l.f;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.gamelive.c;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isSecondDaryDevice", "", "()Z", "setSecondDaryDevice", "(Z)V", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "canClearScreen", "notifyCloseLive", "", "resume", "showQuitBottomSheet", "showSecondConfirmBottomSheet", "showSecondaryBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends b
{
  public boolean CUB;
  private final com.tencent.mm.live.b.b ngl;
  private com.tencent.mm.ui.widget.a.f ngn;
  private int ngo;
  private final u.i ngp;
  private final View niB;
  
  public j(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354687);
    this.ngl = paramb;
    this.niB = paramViewGroup.findViewById(p.e.live_visitor_close_btn_group);
    this.ngo = bf.bk(paramViewGroup.getContext());
    this.ngp = new j..ExternalSyntheticLambda3(this, paramViewGroup);
    this.niB.setOnClickListener(new j..ExternalSyntheticLambda0(this));
    if ((isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, false);
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
      AppMethodBeat.o(354687);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(354687);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramViewGroup.getContext()));
      continue;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(354687);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bd.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  private static final void a(j paramj)
  {
    AppMethodBeat.i(354745);
    kotlin.g.b.s.u(paramj, "this$0");
    paramj.ngn = null;
    AppMethodBeat.o(354745);
  }
  
  private static final void a(j paramj, View paramView)
  {
    AppMethodBeat.i(354719);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    b.b.a(paramj.ngl, b.c.nck);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354719);
  }
  
  private static final void a(j paramj, ViewGroup paramViewGroup, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(354709);
    kotlin.g.b.s.u(paramj, "this$0");
    kotlin.g.b.s.u(paramViewGroup, "$root");
    paramInt = paramMenuItem.getItemId();
    paramMenuItem = l.f.mYx;
    if (paramInt == l.f.bhw())
    {
      if (paramj.CUB)
      {
        paramViewGroup = new g.a(paramj.mJe.getContext());
        paramViewGroup.bDE(paramj.mJe.getContext().getString(p.h.fidnder_live_secondary_device_close_live_title)).NF(true);
        paramViewGroup.aEX(p.h.live_menu_item_quit_live);
        paramViewGroup.aEY(Color.parseColor("#FF6146"));
        paramViewGroup.bDJ(paramj.mJe.getContext().getString(p.h.finder_live_secondary_device_not_close_btn_text));
        paramViewGroup.c(new j..ExternalSyntheticLambda6(paramj)).jHM().show();
        AppMethodBeat.o(354709);
        return;
      }
      paramj.eoY();
      AppMethodBeat.o(354709);
      return;
    }
    paramMenuItem = l.f.mYx;
    if (paramInt == l.f.bhy())
    {
      if (((e)paramj.business(e.class)).Eet)
      {
        c localc = (c)h.ax(c.class);
        Context localContext = paramViewGroup.getContext();
        Object localObject = ((e)paramj.business(e.class)).Eeu;
        paramMenuItem = (MenuItem)localObject;
        if (localObject == null)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.Idh;
          paramMenuItem = (MenuItem)localObject;
          if (localObject == null) {
            paramMenuItem = "";
          }
        }
        paramInt = ((e)paramj.business(e.class)).Eev;
        localObject = Boolean.FALSE;
        localc.a(localContext, paramMenuItem, paramInt, (Boolean)localObject, (Boolean)localObject, Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
        paramj = paramViewGroup.getContext();
        if ((paramj instanceof AppCompatActivity)) {}
        for (paramj = (AppCompatActivity)paramj; paramj != null; paramj = null)
        {
          paramj.finish();
          AppMethodBeat.o(354709);
          return;
        }
      }
      paramViewGroup = new Bundle();
      paramViewGroup.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL", true);
      paramViewGroup.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", false);
      paramj.ngl.statusChange(b.c.ncD, paramViewGroup);
    }
    AppMethodBeat.o(354709);
  }
  
  private static final void a(j paramj, ArrayList paramArrayList1, ArrayList paramArrayList2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(354735);
    kotlin.g.b.s.u(paramj, "this$0");
    kotlin.g.b.s.u(paramArrayList1, "$titles");
    kotlin.g.b.s.u(paramArrayList2, "$ids");
    Object localObject = paramj.ngn;
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
      params.a(((Number)localObject).intValue(), paramj.mJe.getContext().getResources().getColor(p.b.live_title_host_close_btn_color), (CharSequence)paramArrayList1.get(i));
      if (j > k)
      {
        AppMethodBeat.o(354735);
        return;
      }
    }
  }
  
  private static final void a(j paramj, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(354729);
    kotlin.g.b.s.u(paramj, "this$0");
    if (paramBoolean) {
      paramj.eoY();
    }
    AppMethodBeat.o(354729);
  }
  
  private static final void b(j paramj)
  {
    AppMethodBeat.i(354767);
    kotlin.g.b.s.u(paramj, "this$0");
    paramj.ngn = null;
    AppMethodBeat.o(354767);
  }
  
  private static final void b(j paramj, ArrayList paramArrayList1, ArrayList paramArrayList2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(354758);
    kotlin.g.b.s.u(paramj, "this$0");
    kotlin.g.b.s.u(paramArrayList1, "$titles");
    kotlin.g.b.s.u(paramArrayList2, "$ids");
    Object localObject = paramj.ngn;
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
      if (i == 0)
      {
        localObject = paramArrayList2.get(i);
        kotlin.g.b.s.s(localObject, "ids[i]");
        localObject = params.c(((Number)localObject).intValue(), (CharSequence)paramArrayList1.get(i));
        if (localObject == null)
        {
          paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
          AppMethodBeat.o(354758);
          throw paramj;
        }
        ((t)localObject).BdX = ((CharSequence)paramj.mJe.getContext().getString(p.h.CrT));
      }
      while (j > k)
      {
        AppMethodBeat.o(354758);
        return;
        localObject = paramArrayList2.get(i);
        kotlin.g.b.s.s(localObject, "ids[i]");
        params.c(((Number)localObject).intValue(), (CharSequence)paramArrayList1.get(i));
      }
    }
  }
  
  private final void eoY()
  {
    AppMethodBeat.i(354695);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL", true);
    localBundle.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", true);
    this.ngl.statusChange(b.c.ncD, localBundle);
    AppMethodBeat.o(354695);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(354835);
    super.resume();
    int j = bf.bk(this.mJe.getContext());
    int i = j;
    if (j == 0) {
      i = bd.fromDPToPix(this.mJe.getContext(), 16);
    }
    this.ngo = i;
    AppMethodBeat.o(354835);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354850);
    kotlin.g.b.s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354850);
      return;
      if (this.CUB)
      {
        paramc = new ArrayList();
        paramBundle = new ArrayList();
        localObject = this.mJe.getContext().getResources();
        if (((e)business(e.class)).Eet) {}
        for (int i = p.h.Cqp;; i = p.h.CrS)
        {
          paramc.add(((Resources)localObject).getString(i));
          localObject = l.f.mYx;
          paramBundle.add(Integer.valueOf(l.f.bhy()));
          if ((((e)business(e.class)).Edr) && (!((e)business(e.class)).Eet))
          {
            paramc.add(this.mJe.getContext().getResources().getString(p.h.live_menu_item_quit_live));
            localObject = l.f.mYx;
            paramBundle.add(Integer.valueOf(l.f.bhw()));
          }
          if (this.ngn == null)
          {
            this.ngn = new com.tencent.mm.ui.widget.a.f(this.mJe.getContext(), 1, true);
            localObject = this.ngn;
            if (localObject != null) {
              ((com.tencent.mm.ui.widget.a.f)localObject).NE(true);
            }
            localObject = this.ngn;
            if (localObject != null) {
              ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new j..ExternalSyntheticLambda2(this, paramc, paramBundle);
            }
            paramc = this.ngn;
            if (paramc != null) {
              paramc.GAC = this.ngp;
            }
            paramc = this.ngn;
            if (paramc != null) {
              paramc.aeLi = new j..ExternalSyntheticLambda4(this);
            }
          }
          paramc = this.ngn;
          if (paramc != null) {
            paramc.dDn();
          }
          AppMethodBeat.o(354850);
          return;
        }
      }
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      paramc.add(this.mJe.getContext().getResources().getString(p.h.live_menu_item_quit_live));
      Object localObject = l.f.mYx;
      paramBundle.add(Integer.valueOf(l.f.bhw()));
      if (this.ngn == null) {
        this.ngn = new com.tencent.mm.ui.widget.a.f(this.mJe.getContext(), 1, false);
      }
      localObject = this.ngn;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.f)localObject).NE(true);
      }
      localObject = this.ngn;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new j..ExternalSyntheticLambda1(this, paramc, paramBundle);
      }
      paramc = this.ngn;
      if (paramc != null) {
        paramc.GAC = this.ngp;
      }
      paramc = this.ngn;
      if (paramc != null) {
        paramc.aeLi = new j..ExternalSyntheticLambda5(this);
      }
      paramc = this.ngn;
      if (paramc != null) {
        paramc.dDn();
      }
      AppMethodBeat.o(354850);
      return;
      tO(8);
      AppMethodBeat.o(354850);
      return;
      tO(0);
      AppMethodBeat.o(354850);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, false);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.j
 * JD-Core Version:    0.7.0.1
 */