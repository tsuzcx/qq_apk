package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "onBackPress", "onSwipeBack", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class am
  extends a
{
  private Context context;
  private final b kCL;
  private boolean kGE;
  private final ImageView kGF;
  private final RelativeLayout kGG;
  
  public am(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(193744);
    this.kCL = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_minimiza_icon_btn);
    p.j(paramb, "root.findViewById(R.id.live_minimiza_icon_btn)");
    this.kGF = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(b.e.live_minimiza_icon_btn_click_area);
    p.j(paramViewGroup, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
    this.kGG = ((RelativeLayout)paramViewGroup);
    tU(4);
    paramViewGroup = this.kGF;
    paramb = this.context;
    p.j(paramb, "context");
    paramViewGroup.setImageDrawable(au.e(paramb.getResources().getDrawable(b.g.icons_outlined_mini_window), -1));
    this.kGG.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194597);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
          b.b.a(am.a(this.kGH), b.c.kzk);
          RequestFloatWindowPermissionDialog.a(am.b(this.kGH), am.b(this.kGH).getString(b.h.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(193277);
              p.k(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              if (am.c(this.kGI.kGH))
              {
                if (am.a(this.kGI.kGH).getLiveRole() != 1) {
                  break label109;
                }
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.klq;
              }
              for (com.tencent.mm.live.core.core.a.b.b.aLh().knA.kmv = true;; c.a.aMm().knA.kmv = true)
              {
                paramAnonymous2RequestFloatWindowPermissionDialog = new Bundle();
                paramAnonymous2RequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
                paramAnonymous2RequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
                am.a(this.kGI.kGH).statusChange(b.c.kzi, paramAnonymous2RequestFloatWindowPermissionDialog);
                AppMethodBeat.o(193277);
                return;
                label109:
                paramAnonymous2RequestFloatWindowPermissionDialog = c.kqq;
              }
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(193281);
              p.k(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              b.b.a(am.a(this.kGI.kGH), b.c.kzl);
              AppMethodBeat.o(193281);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(193282);
              p.k(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              b.b.a(am.a(this.kGI.kGH), b.c.kzm);
              AppMethodBeat.o(193282);
            }
          }, false, com.tencent.mm.bx.a.awc());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194597);
          return;
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
          paramAnonymousView.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
          am.a(this.kGH).statusChange(b.c.kzi, paramAnonymousView);
        }
      }
    });
    AppMethodBeat.o(193744);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(193740);
    if (this.kCL.isLiving())
    {
      this.kGG.performClick();
      AppMethodBeat.o(193740);
      return true;
    }
    AppMethodBeat.o(193740);
    return false;
  }
  
  public final boolean onSwipeBack()
  {
    AppMethodBeat.i(193742);
    if (this.kCL.isLiving())
    {
      this.kGG.performClick();
      AppMethodBeat.o(193742);
      return true;
    }
    AppMethodBeat.o(193742);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(193739);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (an.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(193739);
      return;
      tU(4);
      this.kGE = false;
      AppMethodBeat.o(193739);
      return;
      tU(0);
      this.kGE = true;
      AppMethodBeat.o(193739);
      return;
      if (this.kCL.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          tU(4);
          AppMethodBeat.o(193739);
          return;
        }
        tU(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.am
 * JD-Core Version:    0.7.0.1
 */