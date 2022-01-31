package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.bk;

final class g$b
  implements g.d
{
  g.c lWQ;
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, ai paramai)
  {
    if (bk.bl(paramai.name)) {
      return;
    }
    TextView localTextView = new TextView(paramContext);
    if ((this.lWQ != null) && (this.lWQ.textColor != -2147483648))
    {
      localTextView.setTextColor(this.lWQ.textColor);
      if ((this.lWQ == null) || (this.lWQ.textSize == -2147483648)) {
        break label227;
      }
      localTextView.setTextSize(0, this.lWQ.textSize);
    }
    for (;;)
    {
      localTextView.setGravity(17);
      localTextView.setText(paramai.name);
      if (!bk.bl(paramai.content)) {
        localTextView.setOnClickListener(new g.b.1(this, paramai, paramContext));
      }
      paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
      paramViewGroup.setVisibility(0);
      h.nFQ.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramai.lRN) });
      return;
      localTextView.setTextColor(paramContext.getResources().getColor(a.c.wallet_link_color));
      break;
      label227:
      localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.HintTextSize));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g.b
 * JD-Core Version:    0.7.0.1
 */