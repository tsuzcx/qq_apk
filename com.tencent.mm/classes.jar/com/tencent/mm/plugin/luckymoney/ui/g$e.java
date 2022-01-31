package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bk;

final class g$e
  implements g.d
{
  g.c lWQ;
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, ai paramai)
  {
    if (bk.bl(paramai.name)) {
      return;
    }
    Object localObject = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_text_oper_view, paramViewGroup, true);
    TextView localTextView = (TextView)((View)localObject).findViewById(a.f.lucky_money_text_oper_wording);
    localObject = (ImageView)((View)localObject).findViewById(a.f.lucky_money_text_oper_icon);
    if (!bk.bl(paramai.iconUrl))
    {
      o.g((ImageView)localObject, paramai.iconUrl);
      ((ImageView)localObject).setVisibility(0);
      label76:
      if ((this.lWQ != null) && (this.lWQ.textColor != -2147483648)) {
        localTextView.setTextColor(this.lWQ.textColor);
      }
      if ((this.lWQ == null) || (this.lWQ.textSize == -2147483648)) {
        break label275;
      }
      localTextView.setTextSize(0, this.lWQ.textSize);
    }
    for (;;)
    {
      localTextView.setGravity(17);
      localTextView.setText(paramai.name);
      if (!bk.bl(paramai.content)) {
        localTextView.setOnClickListener(new g.e.1(this, paramai, paramContext));
      }
      paramViewGroup.setVisibility(0);
      h.nFQ.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramai.lRN) });
      if (this.lWQ == null) {
        break;
      }
      f.eZ(this.lWQ.lWW, 0);
      return;
      ((ImageView)localObject).setVisibility(8);
      break label76;
      label275:
      localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.d.HintTextSize));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g.e
 * JD-Core Version:    0.7.0.1
 */