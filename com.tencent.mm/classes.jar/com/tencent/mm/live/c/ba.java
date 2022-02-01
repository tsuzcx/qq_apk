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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.a.v;
import com.tencent.mm.live.b.l.e;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.b.u.b;
import com.tencent.mm.live.d.e;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ba
  extends a
  implements i
{
  public static final a kHj;
  private final b kCL;
  private final TextView kEA;
  private final TextView kEB;
  private final WeImageView kEr;
  private final Button kEt;
  private final ImageView kHe;
  private final WeImageView kHf;
  private final LinearLayout kHg;
  private final TextView kHh;
  private boolean kHi;
  private String kwF;
  
  static
  {
    AppMethodBeat.i(188614);
    kHj = new a((byte)0);
    AppMethodBeat.o(188614);
  }
  
  public ba(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(188613);
    this.kCL = paramb;
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_ok_btn);
    p.j(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.kEt = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_top_back);
    p.j(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.kEr = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_item_selector);
    p.j(paramb, "root.findViewById(R.id.live_verify_item_selector)");
    this.kHe = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_icon);
    p.j(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.kHf = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_title);
    p.j(paramb, "root.findViewById(R.id.live_verify_title)");
    this.kEA = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_content_tip);
    p.j(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.kEB = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_agreement_group);
    p.j(paramb, "root.findViewById(R.id.l…e_verify_agreement_group)");
    this.kHg = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_agreement);
    p.j(paramb, "root.findViewById(R.id.live_verify_agreement)");
    this.kHh = ((TextView)paramb);
    this.kwF = "";
    this.kEr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188322);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.b.a(ba.a(this.kHk), b.c.kyW);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188322);
      }
    });
    this.kHe.setEnabled(true);
    this.kHe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194253);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ba.b(this.kHk).isActivated())
        {
          paramAnonymousView = u.kwz;
          u.fp(false);
          ba.b(this.kHk).setActivated(false);
          ba.c(this.kHk).setEnabled(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194253);
          return;
          paramAnonymousView = u.kwz;
          u.fp(true);
          ba.b(this.kHk).setActivated(true);
          ba.c(this.kHk).setEnabled(true);
        }
      }
    });
    this.kEt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193212);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (ba.b(this.kHk).isActivated())
        {
          paramAnonymousView = l.e.kuB;
          paramAnonymousView = MultiProcessMMKV.getSingleMMKV(l.e.aNJ());
          localObject = l.e.kuB;
          paramAnonymousView.putBoolean(l.e.aNK(), true);
          paramAnonymousView = h.aHF();
          p.j(paramAnonymousView, "MMKernel.network()");
          paramAnonymousView.aGY().a(3895, (i)this.kHk);
          paramAnonymousView = h.aHF();
          p.j(paramAnonymousView, "MMKernel.network()");
          paramAnonymousView.aGY().b((q)new v());
          Log.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(193212);
          return;
          paramAnonymousView = paramRelativeLayout.getContext();
          localObject = paramRelativeLayout.getContext();
          p.j(localObject, "root.context");
          w.makeText(paramAnonymousView, (CharSequence)((Context)localObject).getResources().getString(b.h.live_no_select_agreement), 0).show();
        }
      }
    });
    this.kHh.setOnClickListener((View.OnClickListener)new ba.4(paramRelativeLayout));
    this.kHg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196753);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ba.b(this.kHk).performClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196753);
      }
    });
    AppMethodBeat.o(188613);
  }
  
  public static boolean aPI()
  {
    AppMethodBeat.i(188607);
    Object localObject = l.e.kuB;
    localObject = MultiProcessMMKV.getSingleMMKV(l.e.aNJ());
    l.e locale = l.e.kuB;
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean(l.e.aNK(), false);
    AppMethodBeat.o(188607);
    return bool;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(188610);
    if (this.kiF.getVisibility() == 0)
    {
      this.kCL.statusChange(b.c.kyW, new Bundle());
      AppMethodBeat.o(188610);
      return true;
    }
    AppMethodBeat.o(188610);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = false;
    AppMethodBeat.i(188609);
    if ((paramq instanceof v))
    {
      paramString = h.aHF();
      p.j(paramString, "MMKernel.network()");
      paramString.aGY().b(3895, (i)this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + paramInt1 + " errCode:" + paramInt2);
        AppMethodBeat.o(188609);
        return;
      }
      if (p.h(((v)paramq).kye, Boolean.TRUE)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.kHi = bool1;
        paramq = ((v)paramq).kwF;
        paramString = paramq;
        if (paramq == null) {
          paramString = "";
        }
        this.kwF = paramString;
        boolean bool3 = this.kHi;
        bool1 = bool2;
        if (p.h(this.kwF, "")) {
          bool1 = true;
        }
        Log.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!this.kHi) {
          break;
        }
        this.kCL.statusChange(b.c.kyP, new Bundle());
        AppMethodBeat.o(188609);
        return;
      }
      paramString = u.kwz;
      u.aOE().Oh(this.kwF);
      paramString = u.kwz;
      u.aOE().kwG = true;
      this.kCL.statusChange(b.c.kyQ, new Bundle());
    }
    AppMethodBeat.o(188609);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(188601);
    p.k(paramc, "status");
    switch (bb.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      tU(8);
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(188601);
      return;
      tU(0);
      Object localObject1 = u.kwz;
      u.fo(true);
      continue;
      if (this.kiF.getVisibility() == 0)
      {
        localObject1 = u.kwz;
        localObject1 = u.aOm();
        Object localObject2 = u.kwz;
        boolean bool1 = u.aOI();
        localObject2 = u.kwz;
        boolean bool2 = u.aOJ();
        localObject2 = u.kwz;
        localObject2 = u.aOr().Srb;
        Object localObject3 = u.kwz;
        boolean bool3 = u.aOH();
        localObject3 = this.kiF.getResources();
        p.j(localObject3, "root.resources");
        e.a((String)localObject1, bool1, bool2, (String)localObject2, bool3, ((Resources)localObject3).getConfiguration().orientation, 1);
        com.tencent.mm.live.d.a.aPT();
      }
      tU(8);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ba
 * JD-Core Version:    0.7.0.1
 */