package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.f.s;

final class j$9
  implements View.OnClickListener
{
  j$9(j paramj, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56154);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.setClass(this.Kks.activity, f.s.class);
    Log.d("MicroMsg.TrackMapUI", "click url %s", new Object[] { this.Kku });
    paramView.putExtra("rawUrl", this.Kku);
    paramView.putExtra("showShare", false);
    c.g(this.Kks.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(56154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.9
 * JD-Core Version:    0.7.0.1
 */