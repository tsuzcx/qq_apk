package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DISABLE_TXT", "", "ENABLE_TXT", "TAG", "autoInputMsg", "postContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "postHint", "Landroid/widget/TextView;", "canClearScreen", "", "checkComment", "", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class ca
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final View ywu;
  private final TextView ywv;
  private String yww;
  private final String ywx;
  private final String ywy;
  
  public ca(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(237139);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveNewVisitorPostPlugin";
    this.ywu = paramViewGroup.findViewById(b.f.finder_live_visitor_post_wrap_content);
    this.ywv = ((TextView)paramViewGroup.findViewById(b.f.finder_live_visitor_post_txt));
    this.yww = "";
    paramb = MMApplicationContext.getContext();
    p.j(paramb, "MMApplicationContext.getContext()");
    paramb = paramb.getResources().getString(b.j.finder_live_comment_tip);
    p.j(paramb, "MMApplicationContext.get….finder_live_comment_tip)");
    this.ywx = paramb;
    paramb = MMApplicationContext.getContext();
    p.j(paramb, "MMApplicationContext.getContext()");
    paramb = paramb.getResources().getString(b.j.finder_post_disable_hint);
    p.j(paramb, "MMApplicationContext.get…finder_post_disable_hint)");
    this.ywy = paramb;
    this.ywu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(271853);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ywz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfb) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ywz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc))
        {
          paramAnonymousView = paramViewGroup.getContext();
          localObject = MMApplicationContext.getContext();
          p.j(localObject, "MMApplicationContext.getContext()");
          w.makeText(paramAnonymousView, (CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_risk_control_disable_comment), 0).show();
        }
        for (;;)
        {
          ca.a(this.ywz, "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(271853);
          return;
          paramAnonymousView = ca.a(this.ywz);
          p.j(paramAnonymousView, "postHint");
          if (p.h(paramAnonymousView.getText(), ca.b(this.ywz)))
          {
            paramAnonymousView = new Bundle();
            paramAnonymousView.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
            paramAnonymousView.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", ca.c(this.ywz));
            ca.d(this.ywz).statusChange(b.c.kzy, paramAnonymousView);
          }
          else
          {
            paramAnonymousView = ca.a(this.ywz);
            p.j(paramAnonymousView, "postHint");
            if (p.h(paramAnonymousView.getText(), ca.e(this.ywz)))
            {
              paramAnonymousView = paramViewGroup.getContext();
              localObject = MMApplicationContext.getContext();
              p.j(localObject, "MMApplicationContext.getContext()");
              w.a(paramAnonymousView, ((Context)localObject).getResources().getString(b.j.finder_live_comment_anchor_disable), (w.b)1.ywA);
            }
          }
        }
      }
    });
    if (!isLandscape())
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(237139);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += ax.aB(paramViewGroup.getContext());
    }
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a((d)this, true);
    AppMethodBeat.o(237139);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dCn()
  {
    AppMethodBeat.i(237134);
    TextView localTextView;
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfb) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfd) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc))
    {
      localTextView = this.ywv;
      p.j(localTextView, "postHint");
      localTextView.setText((CharSequence)this.ywx);
    }
    for (;;)
    {
      Log.i(this.TAG, "riskControlEnableComment:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfb + ",enableLiveRoomComment:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfd + ",enableCustomerComment:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc);
      AppMethodBeat.o(237134);
      return;
      localTextView = this.ywv;
      p.j(localTextView, "postHint");
      localTextView.setText((CharSequence)this.ywy);
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(237136);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (cb.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(237136);
      return;
      tU(8);
      AppMethodBeat.o(237136);
      return;
      dCn();
      AppMethodBeat.o(237136);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, true);
      AppMethodBeat.o(237136);
      return;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG");
        paramc = paramBundle;
        if (paramBundle != null) {}
      }
      else
      {
        paramc = "";
      }
      this.yww = paramc;
      this.ywu.performClick();
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(237131);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(237131);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(237131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ca
 * JD-Core Version:    0.7.0.1
 */