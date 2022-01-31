package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.ui.WalletTextView;

final class b$a
{
  TextView iIV;
  TextView iJR;
  WalletTextView iJS;
  TextView iJT;
  
  public b$a(View paramView)
  {
    this.iJR = ((TextView)paramView.findViewById(a.f.collect_bill_list_date_tv));
    this.iJT = ((TextView)paramView.findViewById(a.f.collect_bill_list_currency_tv));
    this.iJS = ((WalletTextView)paramView.findViewById(a.f.collect_bill_list_money_tv));
    this.iIV = ((TextView)paramView.findViewById(a.f.collect_bill_list_desc_tv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b.a
 * JD-Core Version:    0.7.0.1
 */