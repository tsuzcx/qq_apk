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
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class am
  extends a
{
  final b IIs;
  boolean KwA;
  private final ImageView KwB;
  private final RelativeLayout KwC;
  Context context;
  
  public am(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203023);
    this.IIs = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307632);
    k.g(paramb, "root.findViewById(R.id.live_minimiza_icon_btn)");
    this.KwB = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307633);
    k.g(paramb, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
    this.KwC = ((RelativeLayout)paramb);
    agK(4);
    paramb = this.KwB;
    paramViewGroup = paramViewGroup.getContext();
    k.g(paramViewGroup, "root.context");
    paramb.setImageDrawable(com.tencent.mm.ui.am.e(paramViewGroup.getResources().getDrawable(2131691516), -1));
    this.KwC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203020);
        if (!com.tencent.mm.compatible.d.b.bZ(aj.getContext()))
        {
          ad.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
          b.b.a(this.KwD.IIs, b.c.FBm);
          RequestFloatWindowPermissionDialog.a(this.KwD.context, this.KwD.context.getString(2131766673), (RequestFloatWindowPermissionDialog.a)new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(203017);
              k.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              if (this.KwE.KwD.KwA) {
                b.b.a(this.KwE.KwD.IIs, b.c.FBk);
              }
              AppMethodBeat.o(203017);
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(203018);
              k.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(203018);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(203019);
              k.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              AppMethodBeat.o(203019);
            }
          }, false, com.tencent.mm.br.a.Ye());
          AppMethodBeat.o(203020);
          return;
        }
        b.b.a(this.KwD.IIs, b.c.FBk);
        AppMethodBeat.o(203020);
      }
    });
    AppMethodBeat.o(203023);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203022);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (an.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203022);
      return;
      agK(4);
      this.KwA = false;
      AppMethodBeat.o(203022);
      return;
      agK(0);
      this.KwA = true;
      AppMethodBeat.o(203022);
      return;
      if (this.IIs.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          agK(4);
          AppMethodBeat.o(203022);
          return;
        }
        agK(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.am
 * JD-Core Version:    0.7.0.1
 */