package com.tencent.mm.live.c;

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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.live.b.a.v;
import com.tencent.mm.live.b.f.e;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ba
  extends a
  implements f
{
  public static final ba.a gXg;
  private String gOx;
  private final b gSM;
  private final TextView gUA;
  private final WeImageView gUr;
  private final Button gUt;
  private final TextView gUz;
  private final ImageView gXb;
  private final WeImageView gXc;
  private final LinearLayout gXd;
  private final TextView gXe;
  private boolean gXf;
  
  static
  {
    AppMethodBeat.i(212608);
    gXg = new ba.a((byte)0);
    AppMethodBeat.o(212608);
  }
  
  public ba(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(212607);
    this.gSM = paramb;
    paramb = paramRelativeLayout.findViewById(2131307820);
    p.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.gUt = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307823);
    p.g(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.gUr = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307819);
    p.g(paramb, "root.findViewById(R.id.live_verify_item_selector)");
    this.gXb = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307818);
    p.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.gXc = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307821);
    p.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.gUz = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307817);
    p.g(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.gUA = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307815);
    p.g(paramb, "root.findViewById(R.id.l…e_verify_agreement_group)");
    this.gXd = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307814);
    p.g(paramb, "root.findViewById(R.id.live_verify_agreement)");
    this.gXe = ((TextView)paramb);
    this.gOx = "";
    this.gUr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212597);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.b.a(ba.a(this.gXh), b.c.gRw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212597);
      }
    });
    this.gXb.setEnabled(true);
    this.gXb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212598);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ba.b(this.gXh).isActivated())
        {
          paramAnonymousView = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.dM(false);
          ba.b(this.gXh).setActivated(false);
          ba.c(this.gXh).setEnabled(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212598);
          return;
          paramAnonymousView = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.dM(true);
          ba.b(this.gXh).setActivated(true);
          ba.c(this.gXh).setEnabled(true);
        }
      }
    });
    this.gUt.setOnClickListener((View.OnClickListener)new ba.3(this));
    this.gXe.setOnClickListener((View.OnClickListener)new ba.4(paramRelativeLayout));
    this.gXd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212601);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ba.b(this.gXh).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212601);
      }
    });
    AppMethodBeat.o(212607);
  }
  
  public static boolean aoX()
  {
    AppMethodBeat.i(212604);
    Object localObject = f.e.gNl;
    localObject = ax.aQA(f.e.anb());
    f.e locale = f.e.gNl;
    boolean bool = ((ax)localObject).getBoolean(f.e.anc(), false);
    AppMethodBeat.o(212604);
    return bool;
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212603);
    p.h(paramc, "status");
    switch (bb.cpQ[paramc.ordinal()])
    {
    default: 
      nI(8);
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(212603);
      return;
      nI(0);
      Object localObject1 = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.dL(true);
      continue;
      if (this.gGK.getVisibility() == 0)
      {
        localObject1 = com.tencent.mm.live.b.g.gOr;
        localObject1 = com.tencent.mm.live.b.g.anm();
        Object localObject2 = com.tencent.mm.live.b.g.gOr;
        boolean bool1 = com.tencent.mm.live.b.g.anL();
        localObject2 = com.tencent.mm.live.b.g.gOr;
        boolean bool2 = com.tencent.mm.live.b.g.anM();
        localObject2 = com.tencent.mm.live.b.g.gOr;
        localObject2 = com.tencent.mm.live.b.g.ans().Gbw;
        Object localObject3 = com.tencent.mm.live.b.g.gOr;
        boolean bool3 = com.tencent.mm.live.b.g.anK();
        localObject3 = this.gGK.getResources();
        p.g(localObject3, "root.resources");
        e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, 1);
        com.tencent.mm.live.d.a.api();
      }
      nI(8);
    }
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212606);
    if (this.gGK.getVisibility() == 0)
    {
      this.gSM.a(b.c.gRw, new Bundle());
      AppMethodBeat.o(212606);
      return true;
    }
    AppMethodBeat.o(212606);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = false;
    AppMethodBeat.i(212605);
    if ((paramn instanceof v))
    {
      paramString = com.tencent.mm.kernel.g.ajB();
      p.g(paramString, "MMKernel.network()");
      paramString.aiU().b(3895, (f)this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + paramInt1 + " errCode:" + paramInt2);
        AppMethodBeat.o(212605);
        return;
      }
      if (p.i(((v)paramn).gQF, Boolean.TRUE)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.gXf = bool1;
        paramn = ((v)paramn).gOx;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        this.gOx = paramString;
        boolean bool3 = this.gXf;
        bool1 = bool2;
        if (p.i(this.gOx, "")) {
          bool1 = true;
        }
        ad.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!this.gXf) {
          break;
        }
        this.gSM.a(b.c.gRo, new Bundle());
        AppMethodBeat.o(212605);
        return;
      }
      paramString = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.anH().xK(this.gOx);
      paramString = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.anH().gOy = true;
      this.gSM.a(b.c.gRp, new Bundle());
    }
    AppMethodBeat.o(212605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ba
 * JD-Core Version:    0.7.0.1
 */