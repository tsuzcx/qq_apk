package com.tencent.mm.live.c;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ba$4
  implements View.OnClickListener
{
  ba$4(RelativeLayout paramRelativeLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212600);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.LiveVerifyPlugin", "jumpToVerifyAgreementLink.");
    paramView = new Intent();
    paramView.putExtra("title", this.gSN.getContext().getString(2131766733));
    paramView.putExtra("rawUrl", this.gSN.getContext().getString(2131766731, new Object[] { ac.fks() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    d.b(this.gSN.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.ba.4
 * JD-Core Version:    0.7.0.1
 */