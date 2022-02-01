package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;

public final class i$15
  implements View.OnClickListener
{
  public i$15(i parami, Context paramContext, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49879);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    this.uCF.fY(4, 1);
    if (this.uCF.uCS != null) {}
    for (int i = (int)this.uCF.uCS.getRating();; i = 0)
    {
      paramView = this.uCF;
      localObject = this.val$context;
      String str1 = this.etl;
      String str2 = this.qfz;
      if (h.ax(t.class) != null)
      {
        t localt = (t)h.ax(t.class);
        g localg = new g();
        localg.appId = "wxbfac0b7aca45dd68";
        localg.username = "gh_af145dc05189@app";
        localg.euz = 0;
        localg.scene = 1147;
        localg.qAF = String.format("/pages/edit/edit.html?appid=%s&appName=%s&score=%s", new Object[] { str1, str2, Integer.valueOf(i) });
        localg.idh = new i.4(paramView);
        localt.a((Context)localObject, localg);
      }
      a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49879);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.15
 * JD-Core Version:    0.7.0.1
 */