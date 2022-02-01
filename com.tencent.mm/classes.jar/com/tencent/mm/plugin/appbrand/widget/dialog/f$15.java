package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.service.r;

public final class f$15
  implements View.OnClickListener
{
  public f$15(f paramf, Context paramContext, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49879);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    this.oqB.eI(4, 1);
    if (this.oqB.HZZ != null) {}
    for (int i = (int)this.oqB.HZZ.getRating();; i = 0)
    {
      paramView = this.oqB;
      localObject = this.val$context;
      String str1 = this.val$appId;
      String str2 = this.kqs;
      if (com.tencent.mm.kernel.g.af(r.class) != null)
      {
        r localr = (r)com.tencent.mm.kernel.g.af(r.class);
        com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
        localg.appId = "wxbfac0b7aca45dd68";
        localg.username = "gh_af145dc05189@app";
        localg.iOo = 0;
        localg.scene = 1147;
        localg.kHw = String.format("/pages/edit/edit.html?appid=%s&appName=%s&score=%s", new Object[] { str1, str2, Integer.valueOf(i) });
        localg.kHB = new f.4(paramView);
        localr.a((Context)localObject, localg);
      }
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49879);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.15
 * JD-Core Version:    0.7.0.1
 */