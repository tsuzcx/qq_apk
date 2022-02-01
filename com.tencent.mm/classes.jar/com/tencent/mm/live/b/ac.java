package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.model.a.v;
import com.tencent.mm.live.model.l.e;
import com.tencent.mm.live.model.u;
import com.tencent.mm.live.model.u.b;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVerify", "", "()Z", "setVerify", "(Z)V", "okBtn", "Landroid/widget/Button;", "selectIcon", "Landroid/widget/ImageView;", "verifyAgreementGruop", "Landroid/widget/LinearLayout;", "verifyAgreementLink", "Landroid/widget/TextView;", "verifyContentTip", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "isMarkVerify", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends a
  implements com.tencent.mm.am.h
{
  public static final ac.a njW;
  private String nag;
  private final b nfT;
  private final WeImageView nhB;
  private final Button nhC;
  private final TextView nhK;
  private final TextView nhL;
  private final ImageView njX;
  private final WeImageView njY;
  private final LinearLayout njZ;
  private final TextView nka;
  private boolean nkb;
  
  static
  {
    AppMethodBeat.i(247419);
    njW = new ac.a((byte)0);
    AppMethodBeat.o(247419);
  }
  
  public ac(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(247365);
    this.nfT = paramb;
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_ok_btn);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.nhC = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_top_back);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.nhB = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_item_selector);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_verify_item_selector)");
    this.njX = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_icon);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.njY = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_title);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_verify_title)");
    this.nhK = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_content_tip);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.nhL = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_agreement_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…e_verify_agreement_group)");
    this.njZ = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_agreement);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_verify_agreement)");
    this.nka = ((TextView)paramb);
    this.nag = "";
    this.nhB.setOnClickListener(new ac..ExternalSyntheticLambda3(this));
    this.njX.setEnabled(true);
    this.njX.setOnClickListener(new ac..ExternalSyntheticLambda2(this));
    this.nhC.setOnClickListener(new ac..ExternalSyntheticLambda4(this, paramRelativeLayout));
    this.nka.setOnClickListener(new ac..ExternalSyntheticLambda0(paramRelativeLayout));
    this.njZ.setOnClickListener(new ac..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(247365);
  }
  
  private static final void a(ac paramac, View paramView)
  {
    AppMethodBeat.i(247377);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramac, "this$0");
    b.b.a(paramac.nfT, b.c.ncl);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247377);
  }
  
  private static final void a(ac paramac, RelativeLayout paramRelativeLayout, View paramView)
  {
    AppMethodBeat.i(247395);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramRelativeLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramac, "this$0");
    kotlin.g.b.s.u(paramRelativeLayout, "$root");
    if (paramac.njX.isActivated())
    {
      paramRelativeLayout = l.e.mYs;
      paramRelativeLayout = MultiProcessMMKV.getSingleMMKV(l.e.bhu());
      paramView = l.e.mYs;
      paramRelativeLayout.putBoolean(l.e.bhv(), true);
      com.tencent.mm.kernel.h.baD().mCm.a(3895, (com.tencent.mm.am.h)paramac);
      com.tencent.mm.kernel.h.baD().mCm.a((p)new v(), 0);
      Log.i("MicroMsg.LiveVerifyPlugin", "doscene NetSceneLiveVerify");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247395);
      return;
      aa.makeText(paramRelativeLayout.getContext(), (CharSequence)paramRelativeLayout.getContext().getResources().getString(b.h.live_no_select_agreement), 0).show();
    }
  }
  
  private static final void b(ac paramac, View paramView)
  {
    AppMethodBeat.i(247384);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramac, "this$0");
    if (paramac.njX.isActivated())
    {
      paramView = u.mZl;
      u.fW(false);
      paramac.njX.setActivated(false);
      paramac.nhC.setEnabled(false);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247384);
      return;
      paramView = u.mZl;
      u.fW(true);
      paramac.njX.setActivated(true);
      paramac.nhC.setEnabled(true);
    }
  }
  
  public static boolean bjw()
  {
    AppMethodBeat.i(247370);
    Object localObject = l.e.mYs;
    localObject = MultiProcessMMKV.getSingleMMKV(l.e.bhu());
    l.e locale = l.e.mYs;
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean(l.e.bhv(), false);
    AppMethodBeat.o(247370);
    return bool;
  }
  
  private static final void c(RelativeLayout paramRelativeLayout, View paramView)
  {
    AppMethodBeat.i(247404);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRelativeLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRelativeLayout, "$root");
    Log.i("MicroMsg.LiveVerifyPlugin", "jumpToVerifyAgreementLink.");
    paramView = new Intent();
    paramView.putExtra("title", paramRelativeLayout.getContext().getString(b.h.live_verify_agreement_link_title));
    paramView.putExtra("rawUrl", paramRelativeLayout.getContext().getString(b.h.live_verify_agreement_link, new Object[] { LocaleUtil.getApplicationLanguage() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    com.tencent.mm.br.c.b(paramRelativeLayout.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247404);
  }
  
  private static final void c(ac paramac, View paramView)
  {
    AppMethodBeat.i(247413);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramac, "this$0");
    paramac.njX.performClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247413);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247478);
    if (this.mJe.getVisibility() == 0)
    {
      this.nfT.statusChange(b.c.ncl, new Bundle());
      AppMethodBeat.o(247478);
      return true;
    }
    AppMethodBeat.o(247478);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool2 = false;
    AppMethodBeat.i(247475);
    if ((paramp instanceof v))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(3895, (com.tencent.mm.am.h)this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify error, errType:" + paramInt1 + " errCode:" + paramInt2);
        AppMethodBeat.o(247475);
        return;
      }
      if (kotlin.g.b.s.p(((v)paramp).nbE, Boolean.TRUE)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.nkb = bool1;
        paramp = ((v)paramp).nag;
        paramString = paramp;
        if (paramp == null) {
          paramString = "";
        }
        this.nag = paramString;
        boolean bool3 = this.nkb;
        bool1 = bool2;
        if (kotlin.g.b.s.p(this.nag, "")) {
          bool1 = true;
        }
        Log.i("MicroMsg.LiveVerifyPlugin", "NetSceneLiveVerify, isVerify:%b, verifyUrl null?:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!this.nkb) {
          break;
        }
        this.nfT.statusChange(b.c.nce, new Bundle());
        AppMethodBeat.o(247475);
        return;
      }
      paramString = u.mZl;
      u.bir().Gu(this.nag);
      paramString = u.mZl;
      u.bir().nah = true;
      this.nfT.statusChange(b.c.ncf, new Bundle());
    }
    AppMethodBeat.o(247475);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247460);
    kotlin.g.b.s.u(paramc, "status");
    switch (ac.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      tO(8);
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(247460);
      return;
      tO(0);
      Object localObject1 = u.mZl;
      u.fV(true);
      continue;
      if (this.mJe.getVisibility() == 0)
      {
        localObject1 = u.mZl;
        localObject1 = u.bhZ();
        Object localObject2 = u.mZl;
        boolean bool1 = u.biv();
        localObject2 = u.mZl;
        boolean bool2 = u.biw();
        localObject2 = u.mZl;
        localObject2 = u.bie().Zqd;
        u localu = u.mZl;
        e.a((String)localObject1, bool1, bool2, (String)localObject2, u.biu(), this.mJe.getResources().getConfiguration().orientation, 1);
        com.tencent.mm.live.c.a.bjG();
      }
      tO(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.ac
 * JD-Core Version:    0.7.0.1
 */