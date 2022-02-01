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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.live.b.a.v;
import com.tencent.mm.live.b.f.e;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ba
  extends a
  implements com.tencent.mm.ak.g
{
  public static final ba.a gDw;
  private final WeImageView gAH;
  private final Button gAJ;
  private final TextView gAP;
  private final TextView gAQ;
  private final ImageView gDr;
  private final WeImageView gDs;
  private final LinearLayout gDt;
  private final TextView gDu;
  private boolean gDv;
  private String guM;
  private final b gzb;
  
  static
  {
    AppMethodBeat.i(190318);
    gDw = new ba.a((byte)0);
    AppMethodBeat.o(190318);
  }
  
  public ba(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(190317);
    this.gzb = paramb;
    paramb = paramRelativeLayout.findViewById(2131307820);
    k.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.gAJ = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307823);
    k.g(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.gAH = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307819);
    k.g(paramb, "root.findViewById(R.id.live_verify_item_selector)");
    this.gDr = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307818);
    k.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.gDs = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307821);
    k.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.gAP = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307817);
    k.g(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.gAQ = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307815);
    k.g(paramb, "root.findViewById(R.id.l…e_verify_agreement_group)");
    this.gDt = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307814);
    k.g(paramb, "root.findViewById(R.id.live_verify_agreement)");
    this.gDu = ((TextView)paramb);
    this.guM = "";
    this.gAH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190307);
        b.b.a(ba.a(this.gDx), b.c.gxL);
        AppMethodBeat.o(190307);
      }
    });
    this.gDr.setEnabled(true);
    this.gDr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190308);
        if (ba.b(this.gDx).isActivated())
        {
          paramAnonymousView = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.dK(false);
          ba.b(this.gDx).setActivated(false);
          ba.c(this.gDx).setEnabled(false);
          AppMethodBeat.o(190308);
          return;
        }
        paramAnonymousView = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.dK(true);
        ba.b(this.gDx).setActivated(true);
        ba.c(this.gDx).setEnabled(true);
        AppMethodBeat.o(190308);
      }
    });
    this.gAJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190309);
        paramAnonymousView = f.e.gtA;
        paramAnonymousView = aw.aKU(f.e.akp());
        f.e locale = f.e.gtA;
        paramAnonymousView.putBoolean(f.e.akq(), true);
        paramAnonymousView = com.tencent.mm.kernel.g.agQ();
        k.g(paramAnonymousView, "MMKernel.network()");
        paramAnonymousView.agi().a(3895, (com.tencent.mm.ak.g)this.gDx);
        paramAnonymousView = com.tencent.mm.kernel.g.agQ();
        k.g(paramAnonymousView, "MMKernel.network()");
        paramAnonymousView.agi().b((n)new v());
        ac.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
        AppMethodBeat.o(190309);
      }
    });
    this.gDu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190310);
        ac.i("MicroMsg.LiveVerifyPlugin", "jumpToVerifyAgreementLink.");
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("title", this.gzc.getContext().getString(2131766733));
        paramAnonymousView.putExtra("rawUrl", this.gzc.getContext().getString(2131766731, new Object[] { ab.eUO() }));
        paramAnonymousView.putExtra("showShare", false);
        paramAnonymousView.putExtra("neverGetA8Key", true);
        d.b(this.gzc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        AppMethodBeat.o(190310);
      }
    });
    this.gDt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190311);
        ba.b(this.gDx).performClick();
        AppMethodBeat.o(190311);
      }
    });
    AppMethodBeat.o(190317);
  }
  
  public static boolean amk()
  {
    AppMethodBeat.i(190314);
    Object localObject = f.e.gtA;
    localObject = aw.aKU(f.e.akp());
    f.e locale = f.e.gtA;
    boolean bool = ((aw)localObject).getBoolean(f.e.akq(), false);
    AppMethodBeat.o(190314);
    return bool;
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190313);
    k.h(paramc, "status");
    switch (bb.cfA[paramc.ordinal()])
    {
    default: 
      nj(8);
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(190313);
      return;
      nj(0);
      Object localObject1 = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.dJ(true);
      continue;
      if (this.gnb.getVisibility() == 0)
      {
        localObject1 = com.tencent.mm.live.b.g.guG;
        localObject1 = com.tencent.mm.live.b.g.akA();
        Object localObject2 = com.tencent.mm.live.b.g.guG;
        boolean bool1 = com.tencent.mm.live.b.g.akY();
        localObject2 = com.tencent.mm.live.b.g.guG;
        boolean bool2 = com.tencent.mm.live.b.g.akZ();
        localObject2 = com.tencent.mm.live.b.g.guG;
        localObject2 = com.tencent.mm.live.b.g.akF().Eud;
        Object localObject3 = com.tencent.mm.live.b.g.guG;
        boolean bool3 = com.tencent.mm.live.b.g.akX();
        localObject3 = this.gnb.getResources();
        k.g(localObject3, "root.resources");
        e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, 1);
        com.tencent.mm.live.d.a.amv();
      }
      nj(8);
    }
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190316);
    if (this.gnb.getVisibility() == 0)
    {
      this.gzb.a(b.c.gxL, new Bundle());
      AppMethodBeat.o(190316);
      return true;
    }
    AppMethodBeat.o(190316);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = false;
    AppMethodBeat.i(190315);
    if ((paramn instanceof v))
    {
      paramString = com.tencent.mm.kernel.g.agQ();
      k.g(paramString, "MMKernel.network()");
      paramString.agi().b(3895, (com.tencent.mm.ak.g)this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + paramInt1 + " errCode:" + paramInt2);
        AppMethodBeat.o(190315);
        return;
      }
      if (k.g(((v)paramn).gwU, Boolean.TRUE)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.gDv = bool1;
        paramn = ((v)paramn).guM;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        this.guM = paramString;
        boolean bool3 = this.gDv;
        bool1 = bool2;
        if (k.g(this.guM, "")) {
          bool1 = true;
        }
        ac.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!this.gDv) {
          break;
        }
        this.gzb.a(b.c.gxD, new Bundle());
        AppMethodBeat.o(190315);
        return;
      }
      paramString = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akU().uU(this.guM);
      paramString = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akU().guN = true;
      this.gzb.a(b.c.gxE, new Bundle());
    }
    AppMethodBeat.o(190315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ba
 * JD-Core Version:    0.7.0.1
 */