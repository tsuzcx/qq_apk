package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.wallet_core.ui.e;

final class g$b$1
  implements View.OnClickListener
{
  g$b$1(g.b paramb, ai paramai, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.lWR.lRN) });
    if (this.lWR.lRO != 1)
    {
      ((f)g.r(f.class)).a(this.val$context, this.lWR.content, new g.b.1.1(this)).show();
      return;
    }
    e.aa(this.val$context, this.lWR.content);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g.b.1
 * JD-Core Version:    0.7.0.1
 */