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
import com.tencent.mm.br.c;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.b.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MODE_BIND_BANKCARD", "", "MODE_BIND_MOBILE", "MODE_DEFAULT", "MODE_FACE_VERIFY", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mode", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "Landroid/widget/ImageView;", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class t
  extends a
{
  public static final a hQf;
  private final int MODE_DEFAULT;
  String hJl;
  private final RelativeLayout hOX;
  private final b hOp;
  private final Button hPX;
  private final int hPY;
  private final int hPZ;
  private final int hQa;
  private final WeImageView hQb;
  private final ImageView hQc;
  private final TextView hQd;
  private final TextView hQe;
  private int mode;
  
  static
  {
    AppMethodBeat.i(208006);
    hQf = new a((byte)0);
    AppMethodBeat.o(208006);
  }
  
  public t(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(208005);
    this.hOp = paramb;
    this.MODE_DEFAULT = -1;
    this.hPZ = 1;
    this.hQa = 2;
    paramb = paramRelativeLayout.findViewById(2131303396);
    p.g(paramb, "root.findViewById(R.id.live_face_verify_ui_root)");
    this.hOX = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303608);
    p.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.hPX = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131303394);
    p.g(paramb, "root.findViewById(R.id.live_face_verify_top_back)");
    this.hQb = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303606);
    p.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.hQc = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303609);
    p.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.hQd = ((TextView)paramb);
    paramRelativeLayout = paramRelativeLayout.findViewById(2131303605);
    p.g(paramRelativeLayout, "root.findViewById(R.id.live_verify_content_tip)");
    this.hQe = ((TextView)paramRelativeLayout);
    this.mode = this.MODE_DEFAULT;
    this.hJl = "";
    this.hOX.setOnClickListener((View.OnClickListener)t.1.hQg);
    AppMethodBeat.o(208005);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(208003);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, requestCode" + paramInt1 + ", resultCode" + paramInt2);
    if (paramInt1 == 9)
    {
      Object localObject = x.hJf;
      x.aGD().hJq = false;
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
            rg(8);
            AppMethodBeat.o(208003);
            return;
          }
          if (paramInt1 == 1000)
          {
            statusChange(b.c.hLx, new Bundle());
            AppMethodBeat.o(208003);
            return;
          }
          rg(8);
          paramIntent = new Bundle();
          paramIntent.putInt("PARAM_FACE_VERIFY_ERROR", 2131762286);
          this.hOp.statusChange(b.c.hLy, paramIntent);
          AppMethodBeat.o(208003);
          return;
        }
      }
      rg(8);
    }
    AppMethodBeat.o(208003);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(208004);
    if (this.hwr.getVisibility() == 0)
    {
      x localx = x.hJf;
      x.aGD().hJq = false;
      int i = this.mode;
      if ((i == this.hQa) || (i == this.hPZ)) {
        rg(8);
      }
      for (;;)
      {
        AppMethodBeat.o(208004);
        return true;
        if (i == this.hPY) {
          b.b.a(this.hOp, b.c.hLD);
        }
      }
    }
    AppMethodBeat.o(208004);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208002);
    p.h(paramc, "status");
    switch (u.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      super.statusChange(paramc, paramBundle);
      AppMethodBeat.o(208002);
      return;
      this.mode = this.hQa;
      Object localObject = x.hJf;
      x.aGD().hJq = true;
      localObject = this.hwr.getContext();
      if (localObject == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(208002);
        throw paramc;
      }
      ((Activity)localObject).setRequestedOrientation(7);
      if (isLandscape())
      {
        localObject = x.hJf;
        if (!x.aGE().hJk)
        {
          paramc = x.hJf;
          x.aGE().hJk = true;
          AppMethodBeat.o(208002);
          return;
        }
      }
      this.hQb.setVisibility(0);
      this.hQb.setOnClickListener((View.OnClickListener)new b(this));
      localObject = x.hJf;
      this.hJl = x.aGE().hJl;
      this.hQd.setText(2131762290);
      localObject = x.hJf;
      if (x.aGE().hJm) {
        this.hQe.setText(2131762292);
      }
      for (;;)
      {
        this.hPX.setText(2131762293);
        localObject = this.hPX;
        localContext = this.hwr.getContext();
        p.g(localContext, "root.context");
        ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101425));
        this.hPX.setBackgroundResource(2131231436);
        this.hPX.setOnClickListener((View.OnClickListener)new c(this));
        rg(0);
        break;
        this.hQe.setText(2131762291);
      }
      this.mode = this.hPY;
      localObject = x.hJf;
      x.aGD().hJq = true;
      this.hQb.setVisibility(4);
      this.hQd.setText(2131762339);
      this.hQe.setText(2131762338);
      this.hPX.setText(2131762432);
      localObject = this.hPX;
      Context localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131101425));
      this.hPX.setBackgroundResource(2131231436);
      this.hPX.setOnClickListener((View.OnClickListener)new d(this));
      rg(0);
      continue;
      this.mode = this.hPZ;
      localObject = x.hJf;
      x.aGD().hJq = true;
      this.hQb.setVisibility(4);
      this.hQd.setText(2131762288);
      this.hQe.setText(2131762289);
      this.hPX.setText(2131762432);
      localObject = this.hPX;
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((Button)localObject).setTextColor(localContext.getResources().getColor(2131100194));
      this.hPX.setBackgroundResource(2131231429);
      this.hPX.setOnClickListener((View.OnClickListener)new e(this));
      rg(0);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207998);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      t.a(this.hQh).setVisibility(4);
      this.hQh.rg(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207998);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207999);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = new Intent();
      paramView.putExtra("open_custom_style_url", true);
      paramView.putExtra("forceHideShare", true);
      paramView.putExtra("show_native_web_view", true);
      paramView.putExtra("rawUrl", this.hQh.hJl);
      paramView.putExtra("screen_orientation", 1);
      c.b(this.hQh.hwr.getContext(), "webview", ".ui.tools.WebViewUI", paramView, 9);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207999);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208000);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = x.hJf;
      x.aGD().hJq = false;
      b.b.a(t.b(this.hQh), b.c.hLD);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208000);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208001);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = x.hJf;
      x.aGD().hJq = false;
      paramView = t.c(this.hQh);
      localObject = this.hQh.hwr.getContext();
      p.g(localObject, "root.context");
      paramView.setTextColor(((Context)localObject).getResources().getColor(2131101425));
      t.c(this.hQh).setBackgroundResource(2131231436);
      this.hQh.rg(8);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.t
 * JD-Core Version:    0.7.0.1
 */