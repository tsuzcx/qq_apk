package com.tencent.mm.live.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "LIVE_VERIFY_REQUEST_CODE", "", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class t
  extends a
{
  public static final a Kva;
  private final b IIs;
  private final WeImageView KuV;
  private final RelativeLayout KuW;
  private final WeImageView KuX;
  private final TextView KuY;
  private final int KuZ;
  private final Button hJh;
  private final TextView igV;
  String ivl;
  
  static
  {
    AppMethodBeat.i(202924);
    Kva = new a((byte)0);
    AppMethodBeat.o(202924);
  }
  
  public t(final RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(202923);
    this.IIs = paramb;
    paramb = paramRelativeLayout.findViewById(2131307550);
    k.g(paramb, "root.findViewById(R.id.live_face_verify_ui_root)");
    this.KuW = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307739);
    k.g(paramb, "root.findViewById(R.id.live_verify_ok_btn)");
    this.hJh = ((Button)paramb);
    paramb = paramRelativeLayout.findViewById(2131307742);
    k.g(paramb, "root.findViewById(R.id.live_verify_top_back)");
    this.KuV = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307737);
    k.g(paramb, "root.findViewById(R.id.live_verify_icon)");
    this.KuX = ((WeImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307740);
    k.g(paramb, "root.findViewById(R.id.live_verify_title)");
    this.igV = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307736);
    k.g(paramb, "root.findViewById(R.id.live_verify_content_tip)");
    this.KuY = ((TextView)paramb);
    this.ivl = "";
    this.KuZ = 9;
    this.KuW.setOnClickListener((View.OnClickListener)1.Kvb);
    this.KuV.setVisibility(0);
    this.KuX.setIconColor(0);
    this.KuV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202917);
        b.b.a(t.a(this.Kvc), b.c.FAX);
        AppMethodBeat.o(202917);
      }
    });
    this.hJh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202918);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("open_custom_style_url", true);
        paramAnonymousView.putExtra("forceHideShare", true);
        paramAnonymousView.putExtra("show_native_web_view", true);
        paramAnonymousView.putExtra("rawUrl", this.Kvc.ivl);
        d.b(paramRelativeLayout.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView, t.b(this.Kvc));
        AppMethodBeat.o(202918);
      }
    });
    AppMethodBeat.o(202923);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202921);
    k.h(paramc, "status");
    switch (u.ciE[paramc.ordinal()])
    {
    default: 
      agK(8);
    }
    for (;;)
    {
      super.a(paramc, paramBundle);
      AppMethodBeat.o(202921);
      return;
      String str1;
      if (paramBundle != null)
      {
        String str2 = paramBundle.getString("PARAM_VERIFY_URL");
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "";
      }
      this.ivl = str1;
      agK(0);
      continue;
      this.KuV.setVisibility(8);
      this.igV.setText(2131766611);
      this.KuY.setText(2131766610);
      this.hJh.setText(2131766700);
      this.hJh.setOnClickListener((View.OnClickListener)new b(this));
      agK(0);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(202922);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.KuZ)
    {
      Bundle localBundle = null;
      if (paramIntent != null) {
        localBundle = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localBundle != null) && (k.g(localBundle.getString("go_next", ""), "roomlive_verify"))) {
        this.IIs.a(b.c.FAP, new Bundle());
      }
    }
    AppMethodBeat.o(202922);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202920);
      t.a(this.Kvc).a(b.c.FAX, new Bundle());
      AppMethodBeat.o(202920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.t
 * JD-Core Version:    0.7.0.1
 */