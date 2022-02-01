package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.af;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView
  extends LinearLayout
{
  private TextView pJi;
  private TextView wRf;
  private WalletTextView xbL;
  private TextView xbM;
  
  public CollectBillHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64034);
    init(paramContext);
    AppMethodBeat.o(64034);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64035);
    init(paramContext);
    AppMethodBeat.o(64035);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64036);
    init(paramContext);
    AppMethodBeat.o(64036);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64037);
    paramContext = af.mU(paramContext).inflate(a.g.collect_bill_header, this);
    this.wRf = ((TextView)paramContext.findViewById(a.f.collect_bill_header_date_tv));
    this.xbM = ((TextView)paramContext.findViewById(a.f.collect_bill_header_currency_tv));
    this.xbL = ((WalletTextView)paramContext.findViewById(a.f.collect_bill_header_money_tv));
    this.pJi = ((TextView)paramContext.findViewById(a.f.collect_bill_header_desc_tv));
    AppMethodBeat.o(64037);
  }
  
  public final void b(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(64038);
    this.wRf.setText(e.a(getContext(), paramLong, paramInt3));
    this.xbL.setText(e.Jm(paramInt2));
    this.pJi.setText(getContext().getString(a.i.collect_bill_total_num_text, new Object[] { Integer.valueOf(paramInt1) }));
    AppMethodBeat.o(64038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillHeaderView
 * JD-Core Version:    0.7.0.1
 */