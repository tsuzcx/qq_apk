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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class am
  extends a
{
  Context context;
  final b gVv;
  boolean gZm;
  private final ImageView gZn;
  private final RelativeLayout gZo;
  
  public am(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216173);
    this.gVv = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307715);
    p.g(paramb, "root.findViewById(R.id.live_minimiza_icon_btn)");
    this.gZn = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307716);
    p.g(paramb, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
    this.gZo = ((RelativeLayout)paramb);
    nL(4);
    paramb = this.gZn;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691528), -1));
    this.gZo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216170);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!com.tencent.mm.compatible.d.b.cc(ak.getContext()))
        {
          ae.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
          b.b.a(this.gZp.gVv, b.c.gUt);
          RequestFloatWindowPermissionDialog.a(this.gZp.context, this.gZp.context.getString(2131766708), (RequestFloatWindowPermissionDialog.a)new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(216167);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              if (this.gZq.gZp.gZm)
              {
                if (this.gZq.gZp.gVv.getLiveRole() != 1) {
                  break label101;
                }
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.gJU;
                paramAnonymous2RequestFloatWindowPermissionDialog = this.gZq.gVG.getContext();
                p.g(paramAnonymous2RequestFloatWindowPermissionDialog, "root.context");
              }
              for (com.tencent.mm.live.core.core.a.b.a.cs(paramAnonymous2RequestFloatWindowPermissionDialog).gLc.gKr = true;; com.tencent.mm.live.core.core.c.b.a.ct(paramAnonymous2RequestFloatWindowPermissionDialog).gLc.gKr = true)
              {
                b.b.a(this.gZq.gZp.gVv, b.c.gUr);
                AppMethodBeat.o(216167);
                return;
                label101:
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.c.b.gMM;
                paramAnonymous2RequestFloatWindowPermissionDialog = this.gZq.gVG.getContext();
                p.g(paramAnonymous2RequestFloatWindowPermissionDialog, "root.context");
              }
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(216168);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              b.b.a(this.gZq.gZp.gVv, b.c.gUu);
              AppMethodBeat.o(216168);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(216169);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              b.b.a(this.gZq.gZp.gVv, b.c.gUv);
              AppMethodBeat.o(216169);
            }
          }, false, com.tencent.mm.bq.a.abK());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216170);
          return;
          b.b.a(this.gZp.gVv, b.c.gUr);
        }
      }
    });
    AppMethodBeat.o(216173);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216172);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (an.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216172);
      return;
      nL(4);
      this.gZm = false;
      AppMethodBeat.o(216172);
      return;
      nL(0);
      this.gZm = true;
      AppMethodBeat.o(216172);
      return;
      if (this.gVv.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nL(4);
          AppMethodBeat.o(216172);
          return;
        }
        nL(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.am
 * JD-Core Version:    0.7.0.1
 */