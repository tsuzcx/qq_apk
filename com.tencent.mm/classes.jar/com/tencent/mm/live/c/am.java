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
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class am
  extends a
{
  Context context;
  final b gSM;
  private final ImageView gWA;
  private final RelativeLayout gWB;
  boolean gWz;
  
  public am(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212547);
    this.gSM = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307715);
    p.g(paramb, "root.findViewById(R.id.live_minimiza_icon_btn)");
    this.gWA = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307716);
    p.g(paramb, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
    this.gWB = ((RelativeLayout)paramb);
    nI(4);
    paramb = this.gWA;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691528), -1));
    this.gWB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212544);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!com.tencent.mm.compatible.d.b.ca(aj.getContext()))
        {
          ad.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
          b.b.a(this.gWC.gSM, b.c.gRL);
          RequestFloatWindowPermissionDialog.a(this.gWC.context, this.gWC.context.getString(2131766708), (RequestFloatWindowPermissionDialog.a)new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(212541);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              if (this.gWD.gWC.gWz)
              {
                if (this.gWD.gWC.gSM.getLiveRole() != 1) {
                  break label101;
                }
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.gHl;
                paramAnonymous2RequestFloatWindowPermissionDialog = this.gWD.gSX.getContext();
                p.g(paramAnonymous2RequestFloatWindowPermissionDialog, "root.context");
              }
              for (com.tencent.mm.live.core.core.a.b.a.cq(paramAnonymous2RequestFloatWindowPermissionDialog).gIt.gHI = true;; com.tencent.mm.live.core.core.c.b.a.cr(paramAnonymous2RequestFloatWindowPermissionDialog).gIt.gHI = true)
              {
                b.b.a(this.gWD.gWC.gSM, b.c.gRJ);
                AppMethodBeat.o(212541);
                return;
                label101:
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.c.b.gKd;
                paramAnonymous2RequestFloatWindowPermissionDialog = this.gWD.gSX.getContext();
                p.g(paramAnonymous2RequestFloatWindowPermissionDialog, "root.context");
              }
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(212542);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              b.b.a(this.gWD.gWC.gSM, b.c.gRM);
              AppMethodBeat.o(212542);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(212543);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              b.b.a(this.gWD.gWC.gSM, b.c.gRN);
              AppMethodBeat.o(212543);
            }
          }, false, com.tencent.mm.br.a.abB());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212544);
          return;
          b.b.a(this.gWC.gSM, b.c.gRJ);
        }
      }
    });
    AppMethodBeat.o(212547);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212546);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (an.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212546);
      return;
      nI(4);
      this.gWz = false;
      AppMethodBeat.o(212546);
      return;
      nI(0);
      this.gWz = true;
      AppMethodBeat.o(212546);
      return;
      if (this.gSM.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nI(4);
          AppMethodBeat.o(212546);
          return;
        }
        nI(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.am
 * JD-Core Version:    0.7.0.1
 */