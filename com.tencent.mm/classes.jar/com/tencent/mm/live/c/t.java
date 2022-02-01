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
import com.tencent.mm.ab.i;
import com.tencent.mm.br.d;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MODE_BIND_BANKCARD", "", "MODE_BIND_MOBILE", "MODE_DEFAULT", "MODE_FACE_VERIFY", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mode", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "Landroid/widget/ImageView;", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class t
  extends a
{
  public static final t.a gAR;
  private final int MODE_DEFAULT;
  private final Button gAJ;
  private final int gAK;
  private final int gAL;
  private final int gAM;
  private final WeImageView gAN;
  private final ImageView gAO;
  private final TextView gAP;
  private final TextView gAQ;
  String guM;
  private final RelativeLayout gzJ;
  private final b gzb;
  private int mode;
  
  static
  {
    AppMethodBeat.i(190139);
    gAR = new t.a((byte)0);
    AppMethodBeat.o(190139);
  }
  
  public t(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(190138);
    this.gzb = paramb;
    this.MODE_DEFAULT = -1;
    this.gAL = 1;
    this.gAM = 2;
    paramb = paramRelativeLayout.findViewById(2131307634);
    k.g(paramb, "root.findViewById(R.id.live_face_verify_ui_root)");
    this.gzJ = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307820);
    k.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.gAJ = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307632);
    k.g(paramb, "root.findViewById(R.id.live_face_verify_top_back)");
    this.gAN = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307818);
    k.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.gAO = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307821);
    k.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.gAP = ((TextView)paramb);
    paramRelativeLayout = paramRelativeLayout.findViewById(2131307817);
    k.g(paramRelativeLayout, "root.findViewById(R.id.live_verify_content_tip)");
    this.gAQ = ((TextView)paramRelativeLayout);
    this.mode = this.MODE_DEFAULT;
    this.guM = "";
    this.gzJ.setOnClickListener((View.OnClickListener)t.1.gAS);
    AppMethodBeat.o(190138);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190135);
    k.h(paramc, "status");
    switch (u.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(190135);
      return;
      this.mode = this.gAM;
      Object localObject = g.guG;
      g.akT().guR = true;
      localObject = this.gnb.getContext();
      if (localObject == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(190135);
        throw paramc;
      }
      ((Activity)localObject).setRequestedOrientation(7);
      if (aly())
      {
        localObject = g.guG;
        if (!g.akU().guL)
        {
          paramc = g.guG;
          g.akU().guL = true;
          AppMethodBeat.o(190135);
          return;
        }
      }
      this.gAN.setVisibility(0);
      this.gAN.setOnClickListener((View.OnClickListener)new b(this));
      localObject = g.guG;
      this.guM = g.akU().guM;
      this.gAP.setText(2131766600);
      localObject = g.guG;
      if (g.akU().guN) {
        this.gAQ.setText(2131766602);
      }
      for (;;)
      {
        this.gAJ.setText(2131766603);
        localObject = this.gAJ;
        localContext = this.gnb.getContext();
        k.g(localContext, "root.context");
        ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101180));
        this.gAJ.setBackgroundResource(2131231372);
        this.gAJ.setOnClickListener((View.OnClickListener)new c(this));
        nj(0);
        break;
        this.gAQ.setText(2131766601);
      }
      this.mode = this.gAK;
      localObject = g.guG;
      g.akT().guR = true;
      this.gAN.setVisibility(4);
      this.gAP.setText(2131766644);
      this.gAQ.setText(2131766643);
      this.gAJ.setText(2131766735);
      localObject = this.gAJ;
      Context localContext = this.gnb.getContext();
      k.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101180));
      this.gAJ.setBackgroundResource(2131231372);
      this.gAJ.setOnClickListener((View.OnClickListener)new d(this));
      nj(0);
      continue;
      this.mode = this.gAL;
      localObject = g.guG;
      g.akT().guR = true;
      this.gAN.setVisibility(4);
      this.gAP.setText(2131766598);
      this.gAQ.setText(2131766599);
      this.gAJ.setText(2131766735);
      localObject = this.gAJ;
      localContext = this.gnb.getContext();
      k.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131100161));
      this.gAJ.setBackgroundResource(2131231365);
      this.gAJ.setOnClickListener((View.OnClickListener)new e(this));
      nj(0);
    }
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190137);
    if (this.gnb.getVisibility() == 0)
    {
      g localg = g.guG;
      g.akT().guR = false;
      int i = this.mode;
      if ((i == this.gAM) || (i == this.gAL)) {
        nj(8);
      }
      for (;;)
      {
        AppMethodBeat.o(190137);
        return true;
        if (i == this.gAK) {
          b.b.a(this.gzb, b.c.gxL);
        }
      }
    }
    AppMethodBeat.o(190137);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190136);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, requestCode" + paramInt1 + ", resultCode" + paramInt2);
    if (paramInt1 == 9)
    {
      Object localObject = g.guG;
      g.akT().guR = false;
      localObject = null;
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject != null))
      {
        paramIntent = ((Bundle)localObject).getString("go_next", "");
        localObject = ((Bundle)localObject).getString("result_json");
        if (!bs.isNullOrNil((String)localObject))
        {
          paramInt1 = new i((String)localObject).getInt("code");
          ac.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, nextStep" + paramIntent + ", code" + paramInt1);
          if ((paramIntent.equals("roomlive_verify")) && (paramInt1 == 0))
          {
            nj(8);
            AppMethodBeat.o(190136);
            return;
          }
          if (paramInt1 == 1000)
          {
            a(b.c.gxF, new Bundle());
            AppMethodBeat.o(190136);
            return;
          }
          nj(8);
          paramIntent = new Bundle();
          paramIntent.putInt("PARAM_FACE_VERIFY_ERROR", 2131766596);
          this.gzb.a(b.c.gxG, paramIntent);
          AppMethodBeat.o(190136);
          return;
        }
      }
      nj(8);
    }
    AppMethodBeat.o(190136);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190131);
      t.a(this.gAT).setVisibility(4);
      this.gAT.nj(8);
      AppMethodBeat.o(190131);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190132);
      paramView = new Intent();
      paramView.putExtra("open_custom_style_url", true);
      paramView.putExtra("forceHideShare", true);
      paramView.putExtra("show_native_web_view", true);
      paramView.putExtra("rawUrl", this.gAT.guM);
      paramView.putExtra("screen_orientation", 1);
      d.b(this.gAT.gnb.getContext(), "webview", ".ui.tools.WebViewUI", paramView, 9);
      AppMethodBeat.o(190132);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190133);
      paramView = g.guG;
      g.akT().guR = false;
      b.b.a(t.b(this.gAT), b.c.gxL);
      AppMethodBeat.o(190133);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190134);
      paramView = g.guG;
      g.akT().guR = false;
      paramView = t.c(this.gAT);
      Context localContext = this.gAT.gnb.getContext();
      k.g(localContext, "root.context");
      paramView.setTextColor(localContext.getResources().getColor(2131101180));
      t.c(this.gAT).setBackgroundResource(2131231372);
      this.gAT.nj(8);
      AppMethodBeat.o(190134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.t
 * JD-Core Version:    0.7.0.1
 */