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
import com.tencent.mm.ac.i;
import com.tencent.mm.bs.d;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MODE_BIND_BANKCARD", "", "MODE_BIND_MOBILE", "MODE_DEFAULT", "MODE_FACE_VERIFY", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mode", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "Landroid/widget/ImageView;", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class t
  extends a
{
  public static final t.a gUB;
  private final int MODE_DEFAULT;
  String gOx;
  private final b gSM;
  private final RelativeLayout gTu;
  private final TextView gUA;
  private final Button gUt;
  private final int gUu;
  private final int gUv;
  private final int gUw;
  private final WeImageView gUx;
  private final ImageView gUy;
  private final TextView gUz;
  private int mode;
  
  static
  {
    AppMethodBeat.i(212428);
    gUB = new t.a((byte)0);
    AppMethodBeat.o(212428);
  }
  
  public t(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(212427);
    this.gSM = paramb;
    this.MODE_DEFAULT = -1;
    this.gUv = 1;
    this.gUw = 2;
    paramb = paramRelativeLayout.findViewById(2131307634);
    p.g(paramb, "root.findViewById(R.id.live_face_verify_ui_root)");
    this.gTu = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307820);
    p.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.gUt = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307632);
    p.g(paramb, "root.findViewById(R.id.live_face_verify_top_back)");
    this.gUx = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307818);
    p.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.gUy = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307821);
    p.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.gUz = ((TextView)paramb);
    paramRelativeLayout = paramRelativeLayout.findViewById(2131307817);
    p.g(paramRelativeLayout, "root.findViewById(R.id.live_verify_content_tip)");
    this.gUA = ((TextView)paramRelativeLayout);
    this.mode = this.MODE_DEFAULT;
    this.gOx = "";
    this.gTu.setOnClickListener((View.OnClickListener)t.1.gUC);
    AppMethodBeat.o(212427);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212424);
    p.h(paramc, "status");
    switch (u.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(212424);
      return;
      this.mode = this.gUw;
      Object localObject = g.gOr;
      g.anG().gOC = true;
      localObject = this.gGK.getContext();
      if (localObject == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(212424);
        throw paramc;
      }
      ((Activity)localObject).setRequestedOrientation(7);
      if (aol())
      {
        localObject = g.gOr;
        if (!g.anH().gOw)
        {
          paramc = g.gOr;
          g.anH().gOw = true;
          AppMethodBeat.o(212424);
          return;
        }
      }
      this.gUx.setVisibility(0);
      this.gUx.setOnClickListener((View.OnClickListener)new b(this));
      localObject = g.gOr;
      this.gOx = g.anH().gOx;
      this.gUz.setText(2131766600);
      localObject = g.gOr;
      if (g.anH().gOy) {
        this.gUA.setText(2131766602);
      }
      for (;;)
      {
        this.gUt.setText(2131766603);
        localObject = this.gUt;
        localContext = this.gGK.getContext();
        p.g(localContext, "root.context");
        ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101180));
        this.gUt.setBackgroundResource(2131231372);
        this.gUt.setOnClickListener((View.OnClickListener)new c(this));
        nI(0);
        break;
        this.gUA.setText(2131766601);
      }
      this.mode = this.gUu;
      localObject = g.gOr;
      g.anG().gOC = true;
      this.gUx.setVisibility(4);
      this.gUz.setText(2131766644);
      this.gUA.setText(2131766643);
      this.gUt.setText(2131766735);
      localObject = this.gUt;
      Context localContext = this.gGK.getContext();
      p.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101180));
      this.gUt.setBackgroundResource(2131231372);
      this.gUt.setOnClickListener((View.OnClickListener)new d(this));
      nI(0);
      continue;
      this.mode = this.gUv;
      localObject = g.gOr;
      g.anG().gOC = true;
      this.gUx.setVisibility(4);
      this.gUz.setText(2131766598);
      this.gUA.setText(2131766599);
      this.gUt.setText(2131766735);
      localObject = this.gUt;
      localContext = this.gGK.getContext();
      p.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131100161));
      this.gUt.setBackgroundResource(2131231365);
      this.gUt.setOnClickListener((View.OnClickListener)new e(this));
      nI(0);
    }
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212426);
    if (this.gGK.getVisibility() == 0)
    {
      g localg = g.gOr;
      g.anG().gOC = false;
      int i = this.mode;
      if ((i == this.gUw) || (i == this.gUv)) {
        nI(8);
      }
      for (;;)
      {
        AppMethodBeat.o(212426);
        return true;
        if (i == this.gUu) {
          b.b.a(this.gSM, b.c.gRw);
        }
      }
    }
    AppMethodBeat.o(212426);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212425);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, requestCode" + paramInt1 + ", resultCode" + paramInt2);
    if (paramInt1 == 9)
    {
      Object localObject = g.gOr;
      g.anG().gOC = false;
      localObject = null;
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject != null))
      {
        paramIntent = ((Bundle)localObject).getString("go_next", "");
        localObject = ((Bundle)localObject).getString("result_json");
        if (!bt.isNullOrNil((String)localObject))
        {
          paramInt1 = new i((String)localObject).getInt("code");
          ad.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, nextStep" + paramIntent + ", code" + paramInt1);
          if ((paramIntent.equals("roomlive_verify")) && (paramInt1 == 0))
          {
            nI(8);
            AppMethodBeat.o(212425);
            return;
          }
          if (paramInt1 == 1000)
          {
            a(b.c.gRq, new Bundle());
            AppMethodBeat.o(212425);
            return;
          }
          nI(8);
          paramIntent = new Bundle();
          paramIntent.putInt("PARAM_FACE_VERIFY_ERROR", 2131766596);
          this.gSM.a(b.c.gRr, paramIntent);
          AppMethodBeat.o(212425);
          return;
        }
      }
      nI(8);
    }
    AppMethodBeat.o(212425);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212420);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      t.a(this.gUD).setVisibility(4);
      this.gUD.nI(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212420);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212421);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = new Intent();
      paramView.putExtra("open_custom_style_url", true);
      paramView.putExtra("forceHideShare", true);
      paramView.putExtra("show_native_web_view", true);
      paramView.putExtra("rawUrl", this.gUD.gOx);
      paramView.putExtra("screen_orientation", 1);
      d.b(this.gUD.gGK.getContext(), "webview", ".ui.tools.WebViewUI", paramView, 9);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212421);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212422);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = g.gOr;
      g.anG().gOC = false;
      b.b.a(t.b(this.gUD), b.c.gRw);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212422);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212423);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = g.gOr;
      g.anG().gOC = false;
      paramView = t.c(this.gUD);
      localObject = this.gUD.gGK.getContext();
      p.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(2131101180));
      t.c(this.gUD).setBackgroundResource(2131231372);
      this.gUD.nI(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212423);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.t
 * JD-Core Version:    0.7.0.1
 */