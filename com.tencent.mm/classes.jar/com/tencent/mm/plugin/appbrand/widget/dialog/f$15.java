package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.n;

public final class f$15
  implements View.OnClickListener
{
  public f$15(f paramf, Context paramContext, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49879);
    this.lYV.es(4, 1);
    if (this.lYV.KCY != null) {}
    for (int i = (int)this.lYV.KCY.getRating();; i = 0)
    {
      paramView = this.lYV;
      Context localContext = this.val$context;
      String str1 = this.val$appId;
      String str2 = this.lZa;
      if (g.ab(n.class) != null)
      {
        n localn = (n)g.ab(n.class);
        com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
        localf.appId = "wxbfac0b7aca45dd68";
        localf.username = "gh_af145dc05189@app";
        localf.gXn = 0;
        localf.scene = 1147;
        localf.iJb = String.format("/pages/edit/edit.html?appid=%s&appName=%s&score=%s", new Object[] { str1, str2, Integer.valueOf(i) });
        localf.iJg = new f.4(paramView);
        localn.a(localContext, localf);
      }
      AppMethodBeat.o(49879);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.15
 * JD-Core Version:    0.7.0.1
 */