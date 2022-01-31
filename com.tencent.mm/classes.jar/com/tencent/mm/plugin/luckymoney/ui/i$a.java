package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;

final class i$a
  implements i.b
{
  i$a(i parami) {}
  
  public final void a(i.c paramc, Context paramContext)
  {
    int i = paramContext.getResources().getColor(a.c.lucky_money_goldstyle_busi_detail_primary_text_color);
    int j = paramContext.getResources().getColor(a.c.lucky_money_goldstyle_busi_detail_sub_text_color);
    int k = paramContext.getResources().getColor(a.c.lucky_money_goldstyle_text_red_color);
    paramc.iUL.setBackgroundResource(a.c.transparent);
    paramc.iUL.setPadding(0, paramContext.getResources().getDimensionPixelOffset(a.d.MiddlePadding), 0, paramContext.getResources().getDimensionPixelOffset(a.d.MiddlePadding));
    paramc.lbC.setTextColor(i);
    paramc.lLL.setTextColor(j);
    paramc.lLM.setTextColor(i);
    paramc.lLN.setTextColor(i);
    paramc.lLO.setTextColor(k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i.a
 * JD-Core Version:    0.7.0.1
 */