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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.v;
import com.tencent.mm.live.b.o.f;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.b.x.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ba
  extends a
  implements i
{
  public static final a hSM;
  private String hJl;
  private final b hOp;
  private final WeImageView hPV;
  private final Button hPX;
  private final TextView hQd;
  private final TextView hQe;
  private final ImageView hSH;
  private final WeImageView hSI;
  private final LinearLayout hSJ;
  private final TextView hSK;
  private boolean hSL;
  
  static
  {
    AppMethodBeat.i(208195);
    hSM = new a((byte)0);
    AppMethodBeat.o(208195);
  }
  
  public ba(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(208194);
    this.hOp = paramb;
    paramb = paramRelativeLayout.findViewById(2131303608);
    p.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.hPX = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131303611);
    p.g(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.hPV = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303607);
    p.g(paramb, "root.findViewById(R.id.live_verify_item_selector)");
    this.hSH = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303606);
    p.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.hSI = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303609);
    p.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.hQd = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303605);
    p.g(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.hQe = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303603);
    p.g(paramb, "root.findViewById(R.id.l…e_verify_agreement_group)");
    this.hSJ = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303602);
    p.g(paramb, "root.findViewById(R.id.live_verify_agreement)");
    this.hSK = ((TextView)paramb);
    this.hJl = "";
    this.hPV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208184);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(ba.a(this.hSN), b.c.hLD);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208184);
      }
    });
    this.hSH.setEnabled(true);
    this.hSH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ba.b(this.hSN).isActivated())
        {
          paramAnonymousView = x.hJf;
          x.eJ(false);
          ba.b(this.hSN).setActivated(false);
          ba.c(this.hSN).setEnabled(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208185);
          return;
          paramAnonymousView = x.hJf;
          x.eJ(true);
          ba.b(this.hSN).setActivated(true);
          ba.c(this.hSN).setEnabled(true);
        }
      }
    });
    this.hPX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208186);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (ba.b(this.hSN).isActivated())
        {
          paramAnonymousView = o.f.hGW;
          paramAnonymousView = MultiProcessMMKV.getSingleMMKV(o.f.aFC());
          localObject = o.f.hGW;
          paramAnonymousView.putBoolean(o.f.aFD(), true);
          paramAnonymousView = g.aAg();
          p.g(paramAnonymousView, "MMKernel.network()");
          paramAnonymousView.azz().a(3895, (i)this.hSN);
          paramAnonymousView = g.aAg();
          p.g(paramAnonymousView, "MMKernel.network()");
          paramAnonymousView.azz().b((q)new v());
          Log.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208186);
          return;
          paramAnonymousView = paramRelativeLayout.getContext();
          localObject = paramRelativeLayout.getContext();
          p.g(localObject, "root.context");
          u.makeText(paramAnonymousView, (CharSequence)((Context)localObject).getResources().getString(2131762344), 0).show();
        }
      }
    });
    this.hSK.setOnClickListener((View.OnClickListener)new ba.4(paramRelativeLayout));
    this.hSJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208188);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ba.b(this.hSN).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208188);
      }
    });
    AppMethodBeat.o(208194);
  }
  
  public static boolean aHK()
  {
    AppMethodBeat.i(208191);
    Object localObject = o.f.hGW;
    localObject = MultiProcessMMKV.getSingleMMKV(o.f.aFC());
    o.f localf = o.f.hGW;
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean(o.f.aFD(), false);
    AppMethodBeat.o(208191);
    return bool;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(208193);
    if (this.hwr.getVisibility() == 0)
    {
      this.hOp.statusChange(b.c.hLD, new Bundle());
      AppMethodBeat.o(208193);
      return true;
    }
    AppMethodBeat.o(208193);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = false;
    AppMethodBeat.i(208192);
    if ((paramq instanceof v))
    {
      paramString = g.aAg();
      p.g(paramString, "MMKernel.network()");
      paramString.azz().b(3895, (i)this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + paramInt1 + " errCode:" + paramInt2);
        AppMethodBeat.o(208192);
        return;
      }
      if (p.j(((v)paramq).hKK, Boolean.TRUE)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.hSL = bool1;
        paramq = ((v)paramq).hJl;
        paramString = paramq;
        if (paramq == null) {
          paramString = "";
        }
        this.hJl = paramString;
        boolean bool3 = this.hSL;
        bool1 = bool2;
        if (p.j(this.hJl, "")) {
          bool1 = true;
        }
        Log.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!this.hSL) {
          break;
        }
        this.hOp.statusChange(b.c.hLv, new Bundle());
        AppMethodBeat.o(208192);
        return;
      }
      paramString = x.hJf;
      x.aGE().GW(this.hJl);
      paramString = x.hJf;
      x.aGE().hJm = true;
      this.hOp.statusChange(b.c.hLw, new Bundle());
    }
    AppMethodBeat.o(208192);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208190);
    p.h(paramc, "status");
    switch (bb.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      rg(8);
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(208190);
      return;
      rg(0);
      Object localObject1 = x.hJf;
      x.eI(true);
      continue;
      if (this.hwr.getVisibility() == 0)
      {
        localObject1 = x.hJf;
        localObject1 = x.aGm();
        Object localObject2 = x.hJf;
        boolean bool1 = x.aGI();
        localObject2 = x.hJf;
        boolean bool2 = x.aGJ();
        localObject2 = x.hJf;
        localObject2 = x.aGr().LpF;
        Object localObject3 = x.hJf;
        boolean bool3 = x.aGH();
        localObject3 = this.hwr.getResources();
        p.g(localObject3, "root.resources");
        e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, 1);
        com.tencent.mm.live.d.a.aHV();
      }
      rg(8);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.ba
 * JD-Core Version:    0.7.0.1
 */