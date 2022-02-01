package com.tencent.mm.live.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.by.c;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.b.u.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MODE_BIND_BANKCARD", "", "MODE_BIND_MOBILE", "MODE_DEFAULT", "MODE_FACE_VERIFY", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mode", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "Landroid/widget/ImageView;", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class t
  extends a
{
  public static final a kEC;
  private final b kCL;
  private final RelativeLayout kDt;
  private final TextView kEA;
  private final TextView kEB;
  private final Button kEt;
  private final int kEu;
  private final int kEv;
  private final int kEw;
  private final int kEx;
  private final WeImageView kEy;
  private final ImageView kEz;
  String kwF;
  private int mode;
  
  static
  {
    AppMethodBeat.i(192830);
    kEC = new a((byte)0);
    AppMethodBeat.o(192830);
  }
  
  public t(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(192827);
    this.kCL = paramb;
    this.kEu = -1;
    this.kEw = 1;
    this.kEx = 2;
    paramb = paramRelativeLayout.findViewById(b.e.live_face_verify_ui_root);
    p.j(paramb, "root.findViewById(R.id.live_face_verify_ui_root)");
    this.kDt = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_ok_btn);
    p.j(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.kEt = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_face_verify_top_back);
    p.j(paramb, "root.findViewById(R.id.live_face_verify_top_back)");
    this.kEy = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_icon);
    p.j(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.kEz = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_verify_title);
    p.j(paramb, "root.findViewById(R.id.live_verify_title)");
    this.kEA = ((TextView)paramb);
    paramRelativeLayout = paramRelativeLayout.findViewById(b.e.live_verify_content_tip);
    p.j(paramRelativeLayout, "root.findViewById(R.id.live_verify_content_tip)");
    this.kEB = ((TextView)paramRelativeLayout);
    this.mode = this.kEu;
    this.kwF = "";
    this.kDt.setOnClickListener((View.OnClickListener)t.1.kED);
    AppMethodBeat.o(192827);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(192804);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, requestCode" + paramInt1 + ", resultCode" + paramInt2);
    if (paramInt1 == 9)
    {
      Object localObject = u.kwz;
      u.aOD().kwK = false;
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
            tU(8);
            AppMethodBeat.o(192804);
            return;
          }
          if (paramInt1 == 1000)
          {
            statusChange(b.c.kyR, new Bundle());
            AppMethodBeat.o(192804);
            return;
          }
          tU(8);
          paramIntent = new Bundle();
          paramIntent.putInt("PARAM_FACE_VERIFY_ERROR", b.h.live_face_verify_failed);
          this.kCL.statusChange(b.c.kyS, paramIntent);
          AppMethodBeat.o(192804);
          return;
        }
      }
      tU(8);
    }
    AppMethodBeat.o(192804);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(192811);
    if (this.kiF.getVisibility() == 0)
    {
      u localu = u.kwz;
      u.aOD().kwK = false;
      int i = this.mode;
      if ((i == this.kEx) || (i == this.kEw)) {
        tU(8);
      }
      for (;;)
      {
        AppMethodBeat.o(192811);
        return true;
        if (i == this.kEv) {
          b.b.a(this.kCL, b.c.kyW);
        }
      }
    }
    AppMethodBeat.o(192811);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(192786);
    p.k(paramc, "status");
    switch (u.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(192786);
      return;
      this.mode = this.kEx;
      Object localObject = u.kwz;
      u.aOD().kwK = true;
      localObject = this.kiF.getContext();
      if (localObject == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(192786);
        throw paramc;
      }
      ((Activity)localObject).setRequestedOrientation(7);
      if (isLandscape())
      {
        localObject = u.kwz;
        if (!u.aOE().kwE)
        {
          paramc = u.kwz;
          u.aOE().kwE = true;
          AppMethodBeat.o(192786);
          return;
        }
      }
      this.kEy.setVisibility(0);
      this.kEy.setOnClickListener((View.OnClickListener)new b(this));
      localObject = u.kwz;
      this.kwF = u.aOE().kwF;
      this.kEA.setText(b.h.live_face_verify_need_verify);
      localObject = u.kwz;
      if (u.aOE().kwG) {
        this.kEB.setText(b.h.live_face_verify_need_verify_tips);
      }
      for (;;)
      {
        this.kEt.setText(b.h.live_face_verify_ok);
        localObject = this.kEt;
        localContext = this.kiF.getContext();
        p.j(localContext, "root.context");
        ((Button)localObject).setTextColor(localContext.getResources().getColor(com.tencent.mm.live.b.b.white_btn_text_selector));
        this.kEt.setBackgroundResource(b.d.btn_solid_white);
        this.kEt.setOnClickListener((View.OnClickListener)new c(this));
        tU(0);
        break;
        this.kEB.setText(b.h.live_face_verify_need_verify_mic_tips);
      }
      this.mode = this.kEv;
      localObject = u.kwz;
      u.aOD().kwK = true;
      this.kEy.setVisibility(4);
      this.kEA.setText(b.h.live_need_bind_mobile_title);
      this.kEB.setText(b.h.live_need_bind_mobile_tips);
      this.kEt.setText(b.h.live_verify_ok);
      localObject = this.kEt;
      Context localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(com.tencent.mm.live.b.b.white_btn_text_selector));
      this.kEt.setBackgroundResource(b.d.btn_solid_white);
      this.kEt.setOnClickListener((View.OnClickListener)new d(this));
      tU(0);
      continue;
      this.mode = this.kEw;
      localObject = u.kwz;
      u.aOD().kwK = true;
      this.kEy.setVisibility(4);
      this.kEA.setText(b.h.live_face_verify_need_bind_bankcard);
      this.kEB.setText(b.h.live_face_verify_need_bind_bankcard_tips);
      this.kEt.setText(b.h.live_verify_ok);
      localObject = this.kEt;
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(com.tencent.mm.live.b.b.color_btn_text_selector));
      this.kEt.setBackgroundResource(b.d.btn_solid_green);
      this.kEt.setOnClickListener((View.OnClickListener)new e(this));
      tU(0);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193402);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      t.a(this.kEE).setVisibility(4);
      this.kEE.tU(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193402);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191997);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = new Intent();
      paramView.putExtra("open_custom_style_url", true);
      paramView.putExtra("forceHideShare", true);
      paramView.putExtra("show_native_web_view", true);
      paramView.putExtra("rawUrl", this.kEE.kwF);
      paramView.putExtra("screen_orientation", 1);
      c.b(this.kEE.kiF.getContext(), "webview", ".ui.tools.WebViewUI", paramView, 9);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191997);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195217);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = u.kwz;
      u.aOD().kwK = false;
      b.b.a(t.b(this.kEE), b.c.kyW);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195217);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(194630);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = u.kwz;
      u.aOD().kwK = false;
      paramView = t.c(this.kEE);
      localObject = this.kEE.kiF.getContext();
      p.j(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(com.tencent.mm.live.b.b.white_btn_text_selector));
      t.c(this.kEE).setBackgroundResource(b.d.btn_solid_white);
      this.kEE.tU(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194630);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.t
 * JD-Core Version:    0.7.0.1
 */