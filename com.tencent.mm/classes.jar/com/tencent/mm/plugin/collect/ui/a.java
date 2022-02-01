package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  List<com.tencent.mm.plugin.collect.model.a> tYs;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(64030);
    this.tYs = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(64030);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64031);
    int i = this.tYs.size();
    AppMethodBeat.o(64031);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(64032);
    Object localObject = this.tYs.get(paramInt);
    AppMethodBeat.o(64032);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64033);
    View localView = paramView;
    if (paramView == null)
    {
      localView = ad.kS(this.mContext).inflate(a.g.collect_bill_item, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    paramView = (com.tencent.mm.plugin.collect.model.a)this.tYs.get(paramInt);
    paramViewGroup = (a)localView.getTag();
    TextView localTextView = paramViewGroup.tNP;
    Context localContext = this.mContext;
    long l = paramView.timestamp;
    localTextView.setText(new SimpleDateFormat(localContext.getString(a.i.collect_bill_item_date_day_format)).format(new Date(l * 1000L)));
    paramViewGroup.tYt.setText(e.IJ(paramView.fee));
    if (!Util.isNullOrNil(paramView.desc))
    {
      paramViewGroup.mMA.setText(paramView.desc);
      paramViewGroup.mMA.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(64033);
      return localView;
      paramViewGroup.mMA.setVisibility(8);
    }
  }
  
  static final class a
  {
    TextView mMA;
    TextView tNP;
    WalletTextView tYt;
    
    public a(View paramView)
    {
      AppMethodBeat.i(64029);
      this.tNP = ((TextView)paramView.findViewById(a.f.collect_bill_date_tv));
      this.tYt = ((WalletTextView)paramView.findViewById(a.f.collect_bill_money_tv));
      this.mMA = ((TextView)paramView.findViewById(a.f.collect_bill_desc_tv));
      AppMethodBeat.o(64029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.a
 * JD-Core Version:    0.7.0.1
 */