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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MODE_BIND_BANKCARD", "", "MODE_BIND_MOBILE", "MODE_DEFAULT", "MODE_FACE_VERIFY", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mode", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "Landroid/widget/ImageView;", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class t
  extends a
{
  public static final t.a gXk;
  private final int MODE_DEFAULT;
  String gRf;
  private final b gVv;
  private final RelativeLayout gWd;
  private final Button gXc;
  private final int gXd;
  private final int gXe;
  private final int gXf;
  private final WeImageView gXg;
  private final ImageView gXh;
  private final TextView gXi;
  private final TextView gXj;
  private int mode;
  
  static
  {
    AppMethodBeat.i(216048);
    gXk = new t.a((byte)0);
    AppMethodBeat.o(216048);
  }
  
  public t(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(216047);
    this.gVv = paramb;
    this.MODE_DEFAULT = -1;
    this.gXe = 1;
    this.gXf = 2;
    paramb = paramRelativeLayout.findViewById(2131307634);
    p.g(paramb, "root.findViewById(R.id.live_face_verify_ui_root)");
    this.gWd = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307820);
    p.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.gXc = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307632);
    p.g(paramb, "root.findViewById(R.id.live_face_verify_top_back)");
    this.gXg = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307818);
    p.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.gXh = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307821);
    p.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.gXi = ((TextView)paramb);
    paramRelativeLayout = paramRelativeLayout.findViewById(2131307817);
    p.g(paramRelativeLayout, "root.findViewById(R.id.live_verify_content_tip)");
    this.gXj = ((TextView)paramRelativeLayout);
    this.mode = this.MODE_DEFAULT;
    this.gRf = "";
    this.gWd.setOnClickListener((View.OnClickListener)t.1.gXl);
    AppMethodBeat.o(216047);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216044);
    p.h(paramc, "status");
    switch (u.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(216044);
      return;
      this.mode = this.gXf;
      Object localObject = g.gQZ;
      g.anV().gRk = true;
      localObject = this.gJt.getContext();
      if (localObject == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(216044);
        throw paramc;
      }
      ((Activity)localObject).setRequestedOrientation(7);
      if (aoA())
      {
        localObject = g.gQZ;
        if (!g.anW().gRe)
        {
          paramc = g.gQZ;
          g.anW().gRe = true;
          AppMethodBeat.o(216044);
          return;
        }
      }
      this.gXg.setVisibility(0);
      this.gXg.setOnClickListener((View.OnClickListener)new b(this));
      localObject = g.gQZ;
      this.gRf = g.anW().gRf;
      this.gXi.setText(2131766600);
      localObject = g.gQZ;
      if (g.anW().gRg) {
        this.gXj.setText(2131766602);
      }
      for (;;)
      {
        this.gXc.setText(2131766603);
        localObject = this.gXc;
        localContext = this.gJt.getContext();
        p.g(localContext, "root.context");
        ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101180));
        this.gXc.setBackgroundResource(2131231372);
        this.gXc.setOnClickListener((View.OnClickListener)new c(this));
        nL(0);
        break;
        this.gXj.setText(2131766601);
      }
      this.mode = this.gXd;
      localObject = g.gQZ;
      g.anV().gRk = true;
      this.gXg.setVisibility(4);
      this.gXi.setText(2131766644);
      this.gXj.setText(2131766643);
      this.gXc.setText(2131766735);
      localObject = this.gXc;
      Context localContext = this.gJt.getContext();
      p.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101180));
      this.gXc.setBackgroundResource(2131231372);
      this.gXc.setOnClickListener((View.OnClickListener)new d(this));
      nL(0);
      continue;
      this.mode = this.gXe;
      localObject = g.gQZ;
      g.anV().gRk = true;
      this.gXg.setVisibility(4);
      this.gXi.setText(2131766598);
      this.gXj.setText(2131766599);
      this.gXc.setText(2131766735);
      localObject = this.gXc;
      localContext = this.gJt.getContext();
      p.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131100161));
      this.gXc.setBackgroundResource(2131231365);
      this.gXc.setOnClickListener((View.OnClickListener)new e(this));
      nL(0);
    }
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(216046);
    if (this.gJt.getVisibility() == 0)
    {
      g localg = g.gQZ;
      g.anV().gRk = false;
      int i = this.mode;
      if ((i == this.gXf) || (i == this.gXe)) {
        nL(8);
      }
      for (;;)
      {
        AppMethodBeat.o(216046);
        return true;
        if (i == this.gXd) {
          b.b.a(this.gVv, b.c.gUe);
        }
      }
    }
    AppMethodBeat.o(216046);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(216045);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, requestCode" + paramInt1 + ", resultCode" + paramInt2);
    if (paramInt1 == 9)
    {
      Object localObject = g.gQZ;
      g.anV().gRk = false;
      localObject = null;
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject != null))
      {
        paramIntent = ((Bundle)localObject).getString("go_next", "");
        localObject = ((Bundle)localObject).getString("result_json");
        if (!bu.isNullOrNil((String)localObject))
        {
          paramInt1 = new i((String)localObject).getInt("code");
          ae.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, nextStep" + paramIntent + ", code" + paramInt1);
          if ((paramIntent.equals("roomlive_verify")) && (paramInt1 == 0))
          {
            nL(8);
            AppMethodBeat.o(216045);
            return;
          }
          if (paramInt1 == 1000)
          {
            a(b.c.gTY, new Bundle());
            AppMethodBeat.o(216045);
            return;
          }
          nL(8);
          paramIntent = new Bundle();
          paramIntent.putInt("PARAM_FACE_VERIFY_ERROR", 2131766596);
          this.gVv.a(b.c.gTZ, paramIntent);
          AppMethodBeat.o(216045);
          return;
        }
      }
      nL(8);
    }
    AppMethodBeat.o(216045);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216040);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      t.a(this.gXm).setVisibility(4);
      this.gXm.nL(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216040);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216041);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = new Intent();
      paramView.putExtra("open_custom_style_url", true);
      paramView.putExtra("forceHideShare", true);
      paramView.putExtra("show_native_web_view", true);
      paramView.putExtra("rawUrl", this.gXm.gRf);
      paramView.putExtra("screen_orientation", 1);
      d.b(this.gXm.gJt.getContext(), "webview", ".ui.tools.WebViewUI", paramView, 9);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216041);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216042);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = g.gQZ;
      g.anV().gRk = false;
      b.b.a(t.b(this.gXm), b.c.gUe);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216042);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216043);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = g.gQZ;
      g.anV().gRk = false;
      paramView = t.c(this.gXm);
      localObject = this.gXm.gJt.getContext();
      p.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(2131101180));
      t.c(this.gXm).setBackgroundResource(2131231372);
      this.gXm.nL(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216043);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.t
 * JD-Core Version:    0.7.0.1
 */