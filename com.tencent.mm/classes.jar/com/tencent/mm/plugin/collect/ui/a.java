package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a
  extends BaseAdapter
{
  List<com.tencent.mm.plugin.collect.b.a> iJQ = new ArrayList();
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    return this.iJQ.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.iJQ.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = y.gt(this.mContext).inflate(a.g.collect_bill_item, paramViewGroup, false);
      localView.setTag(new a.a(localView));
    }
    paramView = (com.tencent.mm.plugin.collect.b.a)this.iJQ.get(paramInt);
    paramViewGroup = (a.a)localView.getTag();
    TextView localTextView = paramViewGroup.iJR;
    Context localContext = this.mContext;
    long l = paramView.timestamp;
    localTextView.setText(new SimpleDateFormat(localContext.getString(a.i.collect_bill_item_date_day_format)).format(new Date(l * 1000L)));
    paramViewGroup.iJS.setText(e.pw(paramView.fee));
    if (!bk.bl(paramView.desc))
    {
      paramViewGroup.iIV.setText(paramView.desc);
      paramViewGroup.iIV.setVisibility(0);
      return localView;
    }
    paramViewGroup.iIV.setVisibility(8);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.a
 * JD-Core Version:    0.7.0.1
 */