package com.tencent.mm.live.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.model.l.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "resume", "", "showQuitBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  private final b ngl;
  private final TextView ngm;
  private f ngn;
  private int ngo;
  private final u.i ngp;
  
  public d(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247017);
    this.ngl = paramb;
    this.ngm = ((TextView)paramViewGroup.findViewById(b.e.live_anchor_close_btn));
    this.ngo = bf.bk(paramViewGroup.getContext());
    this.ngp = new d..ExternalSyntheticLambda2(paramViewGroup, this);
    this.ngm.setOnClickListener(new d..ExternalSyntheticLambda0(this));
    if ((isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(247017);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247017);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramViewGroup.getContext()));
      AppMethodBeat.o(247017);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247017);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bd.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  private static final void a(ViewGroup paramViewGroup, d paramd, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(247023);
    kotlin.g.b.s.u(paramViewGroup, "$root");
    kotlin.g.b.s.u(paramd, "this$0");
    paramInt = paramMenuItem.getItemId();
    paramMenuItem = l.f.mYx;
    if (paramInt == l.f.bhw())
    {
      paramViewGroup = paramViewGroup.getContext();
      if (paramViewGroup == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(247023);
        throw paramViewGroup;
      }
      ((Activity)paramViewGroup).getIntent().putExtra("key_is_live_finished", true);
      b.b.a(paramd.ngl, b.c.ncD);
      com.tencent.mm.live.c.a.bjM();
    }
    AppMethodBeat.o(247023);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(247045);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.ngn = null;
    AppMethodBeat.o(247045);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(247030);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAnchorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    b.b.a(paramd.ngl, b.c.nck);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveAnchorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247030);
  }
  
  private static final void a(d paramd, ArrayList paramArrayList1, ArrayList paramArrayList2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(247038);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(paramArrayList1, "$titles");
    kotlin.g.b.s.u(paramArrayList2, "$ids");
    Object localObject = paramd.ngn;
    if (localObject != null) {
      ((f)localObject).setFooterView(null);
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
      params.a(((Number)localObject).intValue(), paramd.mJe.getContext().getResources().getColor(com.tencent.mm.live.b.b.live_title_host_close_btn_color), (CharSequence)paramArrayList1.get(i));
      if (j > k)
      {
        AppMethodBeat.o(247038);
        return;
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(247083);
    super.resume();
    int j = bf.bk(this.mJe.getContext());
    int i = j;
    if (j == 0) {
      i = bd.fromDPToPix(this.mJe.getContext(), 16);
    }
    this.ngo = i;
    AppMethodBeat.o(247083);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247102);
    kotlin.g.b.s.u(paramc, "status");
    switch (d.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247102);
      return;
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      paramc.add(this.mJe.getContext().getResources().getString(b.h.live_menu_item_quit_live));
      Object localObject = l.f.mYx;
      paramBundle.add(Integer.valueOf(l.f.bhw()));
      if (this.ngn == null) {
        this.ngn = new f(this.mJe.getContext(), 1, false);
      }
      localObject = this.ngn;
      if (localObject != null) {
        ((f)localObject).NE(true);
      }
      localObject = this.ngn;
      if (localObject != null) {
        ((f)localObject).Vtg = new d..ExternalSyntheticLambda1(this, paramc, paramBundle);
      }
      paramc = this.ngn;
      if (paramc != null) {
        paramc.GAC = this.ngp;
      }
      paramc = this.ngn;
      if (paramc != null) {
        paramc.aeLi = new d..ExternalSyntheticLambda3(this);
      }
      paramc = this.ngn;
      if (paramc != null) {
        paramc.dDn();
      }
      AppMethodBeat.o(247102);
      return;
      tO(8);
      AppMethodBeat.o(247102);
      return;
      tO(0);
      AppMethodBeat.o(247102);
      return;
      if ((this.mJe.getLayoutParams() != null) && ((this.mJe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        switch (getCurrentOrientation())
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramc = this.mJe.getLayoutParams();
          if (paramc == null)
          {
            paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(247102);
            throw paramc;
          }
        case 3: 
          paramc = this.mJe.getLayoutParams();
          if (paramc == null)
          {
            paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(247102);
            throw paramc;
          }
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(this.ngo);
          AppMethodBeat.o(247102);
          return;
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(bd.fromDPToPix(this.mJe.getContext(), 16));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.d
 * JD-Core Version:    0.7.0.1
 */