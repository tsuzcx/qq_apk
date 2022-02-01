package com.tencent.mm.live.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.live.b.a.u;
import com.tencent.mm.live.b.e.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class bb
  extends a
  implements com.tencent.mm.al.g
{
  public static final a Kxa;
  private final b IIs;
  private final WeImageView KuV;
  private final WeImageView KuX;
  private final TextView KuY;
  private final ImageView KwW;
  private final LinearLayout KwX;
  private final TextView KwY;
  private boolean KwZ;
  private final Button hJh;
  private final TextView igV;
  private String ivl;
  
  static
  {
    AppMethodBeat.i(203081);
    Kxa = new a((byte)0);
    AppMethodBeat.o(203081);
  }
  
  public bb(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(203080);
    this.IIs = paramb;
    paramb = paramRelativeLayout.findViewById(2131307739);
    k.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.hJh = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307742);
    k.g(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.KuV = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307738);
    k.g(paramb, "root.findViewById(R.id.live_verify_item_selector)");
    this.KwW = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307737);
    k.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.KuX = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307740);
    k.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.igV = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307736);
    k.g(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.KuY = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307734);
    k.g(paramb, "root.findViewById(R.id.l…e_verify_agreement_group)");
    this.KwX = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307733);
    k.g(paramb, "root.findViewById(R.id.live_verify_agreement)");
    this.KwY = ((TextView)paramb);
    this.ivl = "";
    this.KuV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203071);
        b.b.a(bb.a(this.Kxb), b.c.FAX);
        AppMethodBeat.o(203071);
      }
    });
    this.KwW.setEnabled(true);
    this.KwW.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203072);
        if (bb.b(this.Kxb).isActivated())
        {
          bb.b(this.Kxb).setActivated(false);
          bb.c(this.Kxb).setEnabled(false);
          AppMethodBeat.o(203072);
          return;
        }
        bb.b(this.Kxb).setActivated(true);
        bb.c(this.Kxb).setEnabled(true);
        AppMethodBeat.o(203072);
      }
    });
    this.hJh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203073);
        paramAnonymousView = e.e.rBl;
        paramAnonymousView = ax.aFD(e.e.equ());
        e.e locale = e.e.rBl;
        paramAnonymousView.putBoolean(e.e.eqw(), true);
        paramAnonymousView = com.tencent.mm.kernel.g.afA();
        k.g(paramAnonymousView, "MMKernel.network()");
        paramAnonymousView.aeS().a(3895, (com.tencent.mm.al.g)this.Kxb);
        paramAnonymousView = com.tencent.mm.kernel.g.afA();
        k.g(paramAnonymousView, "MMKernel.network()");
        paramAnonymousView.aeS().b((n)new u());
        ad.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
        AppMethodBeat.o(203073);
      }
    });
    this.KwY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203074);
        ad.i("MicroMsg.LiveVerifyPlugin", "jumpToVerifyAgreementLink.");
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("title", this.IIt.getContext().getString(2131766698));
        paramAnonymousView.putExtra("rawUrl", this.IIt.getContext().getString(2131766696, new Object[] { ac.eFu() }));
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("neverGetA8Key", true);
        d.b(this.IIt.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(203074);
      }
    });
    this.KwX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203075);
        bb.b(this.Kxb).performClick();
        AppMethodBeat.o(203075);
      }
    });
    AppMethodBeat.o(203080);
  }
  
  public static boolean fOZ()
  {
    AppMethodBeat.i(203078);
    Object localObject = e.e.rBl;
    localObject = ax.aFD(e.e.equ());
    e.e locale = e.e.rBl;
    boolean bool = ((ax)localObject).getBoolean(e.e.eqw(), false);
    AppMethodBeat.o(203078);
    return bool;
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203077);
    k.h(paramc, "status");
    switch (bc.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(203077);
      return;
      agK(8);
      Object localObject1 = f.rGw;
      f.fps();
      localObject1 = f.rGw;
      f.kW(false);
      continue;
      if (this.pTc.getVisibility() == 0)
      {
        localObject1 = f.rGw;
        localObject1 = f.eNB();
        Object localObject2 = f.rGw;
        boolean bool1 = f.fiE();
        localObject2 = f.rGw;
        boolean bool2 = f.fiF();
        localObject2 = f.rGw;
        localObject2 = f.eNG().LwZ;
        Object localObject3 = f.rGw;
        boolean bool3 = f.fhK();
        localObject3 = this.pTc.getResources();
        k.g(localObject3, "root.resources");
        e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, 1);
      }
      agK(8);
      continue;
      agK(0);
      localObject1 = f.rGw;
      f.kW(true);
      continue;
      agK(8);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = false;
    AppMethodBeat.i(203079);
    if ((paramn instanceof u))
    {
      paramString = com.tencent.mm.kernel.g.afA();
      k.g(paramString, "MMKernel.network()");
      paramString.aeS().b(3895, (com.tencent.mm.al.g)this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + paramInt1 + " errCode:" + paramInt2);
        AppMethodBeat.o(203079);
        return;
      }
      if (k.g(((u)paramn).AZw, Boolean.TRUE)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.KwZ = bool1;
        paramn = ((u)paramn).ivl;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        this.ivl = paramString;
        boolean bool3 = this.KwZ;
        bool1 = bool2;
        if (k.g(this.ivl, "")) {
          bool1 = true;
        }
        ad.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!this.KwZ) {
          break;
        }
        this.IIs.a(b.c.FAP, new Bundle());
        AppMethodBeat.o(203079);
        return;
      }
      paramString = new Bundle();
      paramString.putString("PARAM_VERIFY_URL", this.ivl);
      this.IIs.a(b.c.FAQ, paramString);
    }
    AppMethodBeat.o(203079);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.bb
 * JD-Core Version:    0.7.0.1
 */