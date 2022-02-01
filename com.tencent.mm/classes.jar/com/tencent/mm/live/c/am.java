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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class am
  extends a
{
  Context context;
  boolean gCP;
  private final ImageView gCQ;
  private final RelativeLayout gCR;
  final b gzb;
  
  public am(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190257);
    this.gzb = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307715);
    k.g(paramb, "root.findViewById(R.id.live_minimiza_icon_btn)");
    this.gCQ = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307716);
    k.g(paramb, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
    this.gCR = ((RelativeLayout)paramb);
    nj(4);
    paramb = this.gCQ;
    Context localContext = paramViewGroup.getContext();
    k.g(localContext, "root.context");
    paramb.setImageDrawable(com.tencent.mm.ui.am.e(localContext.getResources().getDrawable(2131691528), -1));
    this.gCR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190254);
        if (!com.tencent.mm.compatible.d.b.cc(ai.getContext()))
        {
          ac.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
          b.b.a(this.gCS.gzb, b.c.gya);
          RequestFloatWindowPermissionDialog.a(this.gCS.context, this.gCS.context.getString(2131766708), (RequestFloatWindowPermissionDialog.a)new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(190251);
              k.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              if (this.gCT.gCS.gCP)
              {
                if (this.gCT.gCS.gzb.getLiveRole() != 1) {
                  break label101;
                }
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.gnC;
                paramAnonymous2RequestFloatWindowPermissionDialog = this.gCT.gzm.getContext();
                k.g(paramAnonymous2RequestFloatWindowPermissionDialog, "root.context");
              }
              for (com.tencent.mm.live.core.core.a.b.a.ct(paramAnonymous2RequestFloatWindowPermissionDialog).goL.gnZ = true;; com.tencent.mm.live.core.core.c.b.a.cu(paramAnonymous2RequestFloatWindowPermissionDialog).goL.gnZ = true)
              {
                b.b.a(this.gCT.gCS.gzb, b.c.gxY);
                AppMethodBeat.o(190251);
                return;
                label101:
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.c.b.gqt;
                paramAnonymous2RequestFloatWindowPermissionDialog = this.gCT.gzm.getContext();
                k.g(paramAnonymous2RequestFloatWindowPermissionDialog, "root.context");
              }
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(190252);
              k.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              b.b.a(this.gCT.gCS.gzb, b.c.gyb);
              AppMethodBeat.o(190252);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(190253);
              k.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              b.b.a(this.gCT.gCS.gzb, b.c.gyc);
              AppMethodBeat.o(190253);
            }
          }, false, com.tencent.mm.bq.a.Zb());
          AppMethodBeat.o(190254);
          return;
        }
        b.b.a(this.gCS.gzb, b.c.gxY);
        AppMethodBeat.o(190254);
      }
    });
    AppMethodBeat.o(190257);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190256);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (an.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190256);
      return;
      nj(4);
      this.gCP = false;
      AppMethodBeat.o(190256);
      return;
      nj(0);
      this.gCP = true;
      AppMethodBeat.o(190256);
      return;
      if (this.gzb.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nj(4);
          AppMethodBeat.o(190256);
          return;
        }
        nj(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.am
 * JD-Core Version:    0.7.0.1
 */