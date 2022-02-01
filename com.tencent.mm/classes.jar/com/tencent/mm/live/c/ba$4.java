package com.tencent.mm.live.c;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ba$4
  implements View.OnClickListener
{
  ba$4(RelativeLayout paramRelativeLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(208187);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/live/plugin/LiveVerifyPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.LiveVerifyPlugin", "jumpToVerifyAgreementLink.");
    paramView = new Intent();
    paramView.putExtra("title", this.hOq.getContext().getString(2131762430));
    paramView.putExtra("rawUrl", this.hOq.getContext().getString(2131762428, new Object[] { LocaleUtil.getApplicationLanguage() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    c.b(this.hOq.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/live/plugin/LiveVerifyPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(208187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.ba.4
 * JD-Core Version:    0.7.0.1
 */