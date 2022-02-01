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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveMinimizePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isLiving", "", "minimizeBtn", "Landroid/widget/ImageView;", "minimizeBtnClickArea", "Landroid/widget/RelativeLayout;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class am
  extends a
{
  Context context;
  final b hOp;
  boolean hSh;
  private final ImageView hSi;
  private final RelativeLayout hSj;
  
  public am(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208135);
    this.hOp = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303499);
    p.g(paramb, "root.findViewById(R.id.live_minimiza_icon_btn)");
    this.hSi = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303500);
    p.g(paramb, "root.findViewById(R.id.l…miza_icon_btn_click_area)");
    this.hSj = ((RelativeLayout)paramb);
    rg(4);
    paramb = this.hSi;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690838), -1));
    this.hSj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208132);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.LiveCoreMini", "showVideoTalking, permission denied");
          b.b.a(this.hSk.hOp, b.c.hLS);
          RequestFloatWindowPermissionDialog.a(this.hSk.context, this.hSk.context.getString(2131762405), (RequestFloatWindowPermissionDialog.a)new RequestFloatWindowPermissionDialog.a()
          {
            public final void onResultAllow(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(208129);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              if (this.hSl.hSk.hSh)
              {
                if (this.hSl.hSk.hOp.getLiveRole() != 1) {
                  break label120;
                }
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.hyv;
                this.hSl.hOA.getContext();
              }
              for (com.tencent.mm.live.core.core.a.b.a.aDo().hAz.hzz = true;; com.tencent.mm.live.core.core.d.b.a.aEf().hAz.hzz = true)
              {
                paramAnonymous2RequestFloatWindowPermissionDialog = new Bundle();
                paramAnonymous2RequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
                paramAnonymous2RequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
                this.hSl.hSk.hOp.statusChange(b.c.hLQ, paramAnonymous2RequestFloatWindowPermissionDialog);
                AppMethodBeat.o(208129);
                return;
                label120:
                paramAnonymous2RequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.d.b.hCo;
                this.hSl.hOA.getContext();
              }
            }
            
            public final void onResultCancel(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(208131);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              b.b.a(this.hSl.hSk.hOp, b.c.hLU);
              AppMethodBeat.o(208131);
            }
            
            public final void onResultRefuse(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(208130);
              p.h(paramAnonymous2RequestFloatWindowPermissionDialog, "dialog");
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              b.b.a(this.hSl.hSk.hOp, b.c.hLT);
              AppMethodBeat.o(208130);
            }
          }, false, com.tencent.mm.bq.a.apJ());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveMinimizePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208132);
          return;
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
          paramAnonymousView.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
          this.hSk.hOp.statusChange(b.c.hLQ, paramAnonymousView);
        }
      }
    });
    AppMethodBeat.o(208135);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208134);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (an.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208134);
      return;
      rg(4);
      this.hSh = false;
      AppMethodBeat.o(208134);
      return;
      rg(0);
      this.hSh = true;
      AppMethodBeat.o(208134);
      return;
      if (this.hOp.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          rg(4);
          AppMethodBeat.o(208134);
          return;
        }
        rg(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.am
 * JD-Core Version:    0.7.0.1
 */