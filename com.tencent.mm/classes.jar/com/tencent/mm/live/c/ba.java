package com.tencent.mm.live.c;

import android.content.Context;
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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.a.v;
import com.tencent.mm.live.b.f.e;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ba
  extends a
  implements f
{
  public static final ba.a gZS;
  private String gRf;
  private final b gVv;
  private final WeImageView gXa;
  private final Button gXc;
  private final TextView gXi;
  private final TextView gXj;
  private final ImageView gZO;
  private final LinearLayout gZP;
  private final TextView gZQ;
  private boolean gZR;
  private final WeImageView jCF;
  
  static
  {
    AppMethodBeat.i(216234);
    gZS = new ba.a((byte)0);
    AppMethodBeat.o(216234);
  }
  
  public ba(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(216233);
    this.gVv = paramb;
    paramb = paramRelativeLayout.findViewById(2131307820);
    p.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.gXc = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307823);
    p.g(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.gXa = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307819);
    p.g(paramb, "root.findViewById(R.id.live_verify_item_selector)");
    this.gZO = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307818);
    p.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.jCF = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307821);
    p.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.gXi = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307817);
    p.g(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.gXj = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307815);
    p.g(paramb, "root.findViewById(R.id.l…e_verify_agreement_group)");
    this.gZP = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307814);
    p.g(paramb, "root.findViewById(R.id.live_verify_agreement)");
    this.gZQ = ((TextView)paramb);
    this.gRf = "";
    this.gXa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b.a(ba.a(this.gZT), b.c.gUe);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216223);
      }
    });
    this.gZO.setEnabled(true);
    this.gZO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ba.b(this.gZT).isActivated())
        {
          paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.dN(false);
          ba.b(this.gZT).setActivated(false);
          ba.c(this.gZT).setEnabled(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216224);
          return;
          paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.dN(true);
          ba.b(this.gZT).setActivated(true);
          ba.c(this.gZT).setEnabled(true);
        }
      }
    });
    this.gXc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216225);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (ba.b(this.gZT).isActivated())
        {
          paramAnonymousView = f.e.gPU;
          paramAnonymousView = ay.aRX(f.e.anq());
          localObject = f.e.gPU;
          paramAnonymousView.putBoolean(f.e.ans(), true);
          paramAnonymousView = com.tencent.mm.kernel.g.ajQ();
          p.g(paramAnonymousView, "MMKernel.network()");
          paramAnonymousView.ajj().a(3895, (f)this.gZT);
          paramAnonymousView = com.tencent.mm.kernel.g.ajQ();
          p.g(paramAnonymousView, "MMKernel.network()");
          paramAnonymousView.ajj().b((n)new v());
          ae.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216225);
          return;
          paramAnonymousView = paramRelativeLayout.getContext();
          localObject = paramRelativeLayout.getContext();
          p.g(localObject, "root.context");
          t.makeText(paramAnonymousView, (CharSequence)((Context)localObject).getResources().getString(2131767243), 0).show();
        }
      }
    });
    this.gZQ.setOnClickListener((View.OnClickListener)new ba.4(paramRelativeLayout));
    this.gZP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216227);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ba.b(this.gZT).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216227);
      }
    });
    AppMethodBeat.o(216233);
  }
  
  public static boolean apl()
  {
    AppMethodBeat.i(216230);
    Object localObject = f.e.gPU;
    localObject = ay.aRX(f.e.anq());
    f.e locale = f.e.gPU;
    boolean bool = ((ay)localObject).getBoolean(f.e.ans(), false);
    AppMethodBeat.o(216230);
    return bool;
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216229);
    p.h(paramc, "status");
    switch (bb.cqt[paramc.ordinal()])
    {
    default: 
      nL(8);
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(216229);
      return;
      nL(0);
      Object localObject1 = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.dM(true);
      continue;
      if (this.gJt.getVisibility() == 0)
      {
        localObject1 = com.tencent.mm.live.b.g.gQZ;
        localObject1 = com.tencent.mm.live.b.g.anC();
        Object localObject2 = com.tencent.mm.live.b.g.gQZ;
        boolean bool1 = com.tencent.mm.live.b.g.aoa();
        localObject2 = com.tencent.mm.live.b.g.gQZ;
        boolean bool2 = com.tencent.mm.live.b.g.aob();
        localObject2 = com.tencent.mm.live.b.g.gQZ;
        localObject2 = com.tencent.mm.live.b.g.anH().Gud;
        Object localObject3 = com.tencent.mm.live.b.g.gQZ;
        boolean bool3 = com.tencent.mm.live.b.g.anZ();
        localObject3 = this.gJt.getResources();
        p.g(localObject3, "root.resources");
        e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, 1);
        com.tencent.mm.live.d.a.apw();
      }
      nL(8);
    }
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(216232);
    if (this.gJt.getVisibility() == 0)
    {
      this.gVv.a(b.c.gUe, new Bundle());
      AppMethodBeat.o(216232);
      return true;
    }
    AppMethodBeat.o(216232);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = false;
    AppMethodBeat.i(216231);
    if ((paramn instanceof v))
    {
      paramString = com.tencent.mm.kernel.g.ajQ();
      p.g(paramString, "MMKernel.network()");
      paramString.ajj().b(3895, (f)this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + paramInt1 + " errCode:" + paramInt2);
        AppMethodBeat.o(216231);
        return;
      }
      if (p.i(((v)paramn).gTn, Boolean.TRUE)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.gZR = bool1;
        paramn = ((v)paramn).gRf;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        this.gRf = paramString;
        boolean bool3 = this.gZR;
        bool1 = bool2;
        if (p.i(this.gRf, "")) {
          bool1 = true;
        }
        ae.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!this.gZR) {
          break;
        }
        this.gVv.a(b.c.gTW, new Bundle());
        AppMethodBeat.o(216231);
        return;
      }
      paramString = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anW().yt(this.gRf);
      paramString = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anW().gRg = true;
      this.gVv.a(b.c.gTX, new Bundle());
    }
    AppMethodBeat.o(216231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.ba
 * JD-Core Version:    0.7.0.1
 */