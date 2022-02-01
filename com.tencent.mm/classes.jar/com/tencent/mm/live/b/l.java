package com.tencent.mm.live.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.br.c;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.model.u;
import com.tencent.mm.live.model.u.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MODE_BIND_BANKCARD", "", "MODE_BIND_MOBILE", "MODE_DEFAULT", "MODE_FACE_VERIFY", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mode", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "Landroid/widget/ImageView;", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a
{
  public static final l.a nhD;
  private int mode;
  private String nag;
  private final b nfT;
  private final RelativeLayout ngJ;
  private final Button nhC;
  private final int nhE;
  private final int nhF;
  private final int nhG;
  private final int nhH;
  private final WeImageView nhI;
  private final ImageView nhJ;
  private final TextView nhK;
  private final TextView nhL;
  
  static
  {
    AppMethodBeat.i(247120);
    nhD = new l.a((byte)0);
    AppMethodBeat.o(247120);
  }
  
  public l(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(247064);
    this.nfT = paramb;
    this.nhE = -1;
    this.nhG = 1;
    this.nhH = 2;
    paramb = paramRelativeLayout.findViewById(b.e.live_face_verify_ui_root);
    s.s(paramb, "root.findViewById(R.id.live_face_verify_ui_root)");
    this.ngJ = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_ok_btn);
    s.s(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.nhC = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_face_verify_top_back);
    s.s(paramb, "root.findViewById(R.id.live_face_verify_top_back)");
    this.nhI = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_icon);
    s.s(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.nhJ = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_title);
    s.s(paramb, "root.findViewById(R.id.live_verify_title)");
    this.nhK = ((TextView)paramb);
    paramRelativeLayout = paramRelativeLayout.findViewById(b.e.live_verify_content_tip);
    s.s(paramRelativeLayout, "root.findViewById(R.id.live_verify_content_tip)");
    this.nhL = ((TextView)paramRelativeLayout);
    this.mode = this.nhE;
    this.nag = "";
    this.ngJ.setOnClickListener(l..ExternalSyntheticLambda4.INSTANCE);
    AppMethodBeat.o(247064);
  }
  
  private static final void a(l paraml, View paramView)
  {
    AppMethodBeat.i(247082);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    paraml.nhI.setVisibility(4);
    paraml.tO(8);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247082);
  }
  
  private static final void b(l paraml, View paramView)
  {
    AppMethodBeat.i(247091);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    paramView = new Intent();
    paramView.putExtra("open_custom_style_url", true);
    paramView.putExtra("forceHideShare", true);
    paramView.putExtra("show_native_web_view", true);
    paramView.putExtra("rawUrl", paraml.nag);
    paramView.putExtra("screen_orientation", 1);
    c.b(paraml.mJe.getContext(), "webview", ".ui.tools.WebViewUI", paramView, 9);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247091);
  }
  
  private static final void c(l paraml, View paramView)
  {
    AppMethodBeat.i(247103);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    paramView = u.mZl;
    u.biq().nal = false;
    b.b.a(paraml.nfT, b.c.ncl);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247103);
  }
  
  private static final void d(l paraml, View paramView)
  {
    AppMethodBeat.i(247113);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    paramView = u.mZl;
    u.biq().nal = false;
    paraml.nhC.setTextColor(paraml.mJe.getContext().getResources().getColor(com.tencent.mm.live.b.b.white_btn_text_selector));
    paraml.nhC.setBackgroundResource(b.d.btn_solid_white);
    paraml.tO(8);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247113);
  }
  
  private static final void dg(View paramView)
  {
    AppMethodBeat.i(247070);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247070);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(247198);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, requestCode" + paramInt1 + ", resultCode" + paramInt2);
    if (paramInt1 == 9)
    {
      Object localObject = u.mZl;
      u.biq().nal = false;
      localObject = null;
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject != null))
      {
        paramIntent = ((Bundle)localObject).getString("go_next", "");
        localObject = ((Bundle)localObject).getString("result_json");
        if (!Util.isNullOrNil((String)localObject))
        {
          paramInt1 = new i((String)localObject).getInt("code");
          Log.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, nextStep" + paramIntent + ", code" + paramInt1);
          if ((paramIntent.equals("roomlive_verify")) && (paramInt1 == 0))
          {
            tO(8);
            AppMethodBeat.o(247198);
            return;
          }
          if (paramInt1 == 1000)
          {
            statusChange(b.c.ncg, new Bundle());
            AppMethodBeat.o(247198);
            return;
          }
          tO(8);
          paramIntent = new Bundle();
          paramIntent.putInt("PARAM_FACE_VERIFY_ERROR", b.h.live_face_verify_failed);
          this.nfT.statusChange(b.c.nch, paramIntent);
          AppMethodBeat.o(247198);
          return;
        }
      }
      tO(8);
    }
    AppMethodBeat.o(247198);
  }
  
  public final boolean onBackPress()
  {
    int i = 0;
    AppMethodBeat.i(247207);
    if (this.mJe.getVisibility() == 0)
    {
      u localu = u.mZl;
      u.biq().nal = false;
      int j = this.mode;
      if (j == this.nhH)
      {
        i = 1;
        if (i == 0) {
          break label75;
        }
        tO(8);
      }
      for (;;)
      {
        AppMethodBeat.o(247207);
        return true;
        if (j != this.nhG) {
          break;
        }
        i = 1;
        break;
        label75:
        if (j == this.nhF) {
          b.b.a(this.nfT, b.c.ncl);
        }
      }
    }
    AppMethodBeat.o(247207);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247181);
    s.u(paramc, "status");
    switch (l.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(247181);
      return;
      this.mode = this.nhH;
      Object localObject = u.mZl;
      u.biq().nal = true;
      localObject = this.mJe.getContext();
      if (localObject == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(247181);
        throw paramc;
      }
      ((Activity)localObject).setRequestedOrientation(7);
      if (isLandscape())
      {
        localObject = u.mZl;
        if (!u.bir().naf)
        {
          paramc = u.mZl;
          u.bir().naf = true;
          AppMethodBeat.o(247181);
          return;
        }
      }
      this.nhI.setVisibility(0);
      this.nhI.setOnClickListener(new l..ExternalSyntheticLambda2(this));
      localObject = u.mZl;
      this.nag = u.bir().nag;
      this.nhK.setText(b.h.live_face_verify_need_verify);
      localObject = u.mZl;
      if (u.bir().nah) {
        this.nhL.setText(b.h.live_face_verify_need_verify_tips);
      }
      for (;;)
      {
        this.nhC.setText(b.h.live_face_verify_ok);
        this.nhC.setTextColor(this.mJe.getContext().getResources().getColor(com.tencent.mm.live.b.b.white_btn_text_selector));
        this.nhC.setBackgroundResource(b.d.btn_solid_white);
        this.nhC.setOnClickListener(new l..ExternalSyntheticLambda0(this));
        tO(0);
        break;
        this.nhL.setText(b.h.live_face_verify_need_verify_mic_tips);
      }
      this.mode = this.nhF;
      localObject = u.mZl;
      u.biq().nal = true;
      this.nhI.setVisibility(4);
      this.nhK.setText(b.h.live_need_bind_mobile_title);
      this.nhL.setText(b.h.live_need_bind_mobile_tips);
      this.nhC.setText(b.h.live_verify_ok);
      this.nhC.setTextColor(this.mJe.getContext().getResources().getColor(com.tencent.mm.live.b.b.white_btn_text_selector));
      this.nhC.setBackgroundResource(b.d.btn_solid_white);
      this.nhC.setOnClickListener(new l..ExternalSyntheticLambda3(this));
      tO(0);
      continue;
      this.mode = this.nhG;
      localObject = u.mZl;
      u.biq().nal = true;
      this.nhI.setVisibility(4);
      this.nhK.setText(b.h.live_face_verify_need_bind_bankcard);
      this.nhL.setText(b.h.live_face_verify_need_bind_bankcard_tips);
      this.nhC.setText(b.h.live_verify_ok);
      this.nhC.setTextColor(this.mJe.getContext().getResources().getColor(com.tencent.mm.live.b.b.color_btn_text_selector));
      this.nhC.setBackgroundResource(b.d.btn_solid_green);
      this.nhC.setOnClickListener(new l..ExternalSyntheticLambda1(this));
      tO(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.l
 * JD-Core Version:    0.7.0.1
 */