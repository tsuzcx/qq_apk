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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DISABLE_TXT", "", "ENABLE_TXT", "TAG", "autoInputMsg", "postContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "postHint", "Landroid/widget/TextView;", "canClearScreen", "", "checkComment", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class aw
  extends d
{
  private final String TAG;
  final com.tencent.mm.live.c.b hOp;
  private final View uto;
  final TextView utp;
  String utq;
  final String utr;
  final String uts;
  
  public aw(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246945);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveNewVisitorPostPlugin";
    this.uto = paramViewGroup.findViewById(2131301324);
    this.utp = ((TextView)paramViewGroup.findViewById(2131301322));
    this.utq = "";
    paramb = MMApplicationContext.getContext();
    p.g(paramb, "MMApplicationContext.getContext()");
    paramb = paramb.getResources().getString(2131759906);
    p.g(paramb, "MMApplicationContext.get….finder_live_comment_tip)");
    this.utr = paramb;
    paramb = MMApplicationContext.getContext();
    p.g(paramb, "MMApplicationContext.getContext()");
    paramb = paramb.getResources().getString(2131760415);
    p.g(paramb, "MMApplicationContext.get…finder_post_disable_hint)");
    this.uts = paramb;
    this.uto.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246941);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((!this.utt.getLiveData().uDB) || (!this.utt.getLiveData().uDC))
        {
          paramAnonymousView = paramViewGroup.getContext();
          localObject = MMApplicationContext.getContext();
          p.g(localObject, "MMApplicationContext.getContext()");
          u.makeText(paramAnonymousView, (CharSequence)((Context)localObject).getResources().getString(2131760172), 0).show();
        }
        for (;;)
        {
          this.utt.utq = "";
          a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(246941);
          return;
          paramAnonymousView = this.utt.utp;
          p.g(paramAnonymousView, "postHint");
          if (p.j(paramAnonymousView.getText(), this.utt.utr))
          {
            paramAnonymousView = new Bundle();
            paramAnonymousView.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
            paramAnonymousView.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", this.utt.utq);
            this.utt.hOp.statusChange(b.c.hMd, paramAnonymousView);
          }
          else
          {
            paramAnonymousView = this.utt.utp;
            p.g(paramAnonymousView, "postHint");
            if (p.j(paramAnonymousView.getText(), this.utt.uts))
            {
              paramAnonymousView = paramViewGroup.getContext();
              localObject = MMApplicationContext.getContext();
              p.g(localObject, "MMApplicationContext.getContext()");
              u.a(paramAnonymousView, ((Context)localObject).getResources().getString(2131759895), (u.b)1.utu);
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
        AppMethodBeat.o(246945);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += au.aD(paramViewGroup.getContext());
    }
    paramViewGroup = m.vVH;
    m.a((d)this, true);
    AppMethodBeat.o(246945);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dhK()
  {
    AppMethodBeat.i(246943);
    TextView localTextView;
    if ((getLiveData().uDB) && (getLiveData().uDD) && (getLiveData().uDC))
    {
      localTextView = this.utp;
      p.g(localTextView, "postHint");
      localTextView.setText((CharSequence)this.utr);
    }
    for (;;)
    {
      Log.i(this.TAG, "riskControlEnableComment:" + getLiveData().uDB + ",enableLiveRoomComment:" + getLiveData().uDD + ",enableCustomerComment:" + getLiveData().uDC);
      AppMethodBeat.o(246943);
      return;
      localTextView = this.utp;
      p.g(localTextView, "postHint");
      localTextView.setText((CharSequence)this.uts);
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246944);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ax.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246944);
      return;
      rg(8);
      AppMethodBeat.o(246944);
      return;
      dhK();
      AppMethodBeat.o(246944);
      return;
      paramc = m.vVH;
      m.a((d)this, true);
      AppMethodBeat.o(246944);
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
      this.utq = paramc;
      this.uto.performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aw
 * JD-Core Version:    0.7.0.1
 */