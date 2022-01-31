package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView
  extends LinearLayout
{
  TextView iIV;
  TextView iJR;
  WalletTextView iJS;
  private TextView iJT;
  
  public CollectBillHeaderView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    paramContext = y.gt(paramContext).inflate(a.g.collect_bill_header, this);
    this.iJR = ((TextView)paramContext.findViewById(a.f.collect_bill_header_date_tv));
    this.iJT = ((TextView)paramContext.findViewById(a.f.collect_bill_header_currency_tv));
    this.iJS = ((WalletTextView)paramContext.findViewById(a.f.collect_bill_header_money_tv));
    this.iIV = ((TextView)paramContext.findViewById(a.f.collect_bill_header_desc_tv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillHeaderView
 * JD-Core Version:    0.7.0.1
 */