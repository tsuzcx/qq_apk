package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.collect.b.e;
import com.tencent.mm.plugin.collect.b.h;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  List<h> iJQ = new ArrayList();
  private Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void aX(List<h> paramList)
  {
    this.iJQ.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    return this.iJQ.size();
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
      localView = y.gt(this.mContext).inflate(a.g.collect_bill_list_item, paramViewGroup, false);
      localView.setTag(new b.a(localView));
    }
    paramView = (b.a)localView.getTag();
    paramViewGroup = pz(paramInt);
    paramView.iJR.setText(e.a(this.mContext, paramViewGroup.iHh, paramViewGroup.type));
    paramView.iJS.setText(e.pw(paramViewGroup.iHj));
    paramView.iIV.setText(this.mContext.getString(a.i.collect_bill_total_num_text, new Object[] { Integer.valueOf(paramViewGroup.iHi) }));
    return localView;
  }
  
  public final h pz(int paramInt)
  {
    return (h)this.iJQ.get(paramInt);
  }
  
  public final void setData(List<h> paramList)
  {
    this.iJQ.clear();
    this.iJQ.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b
 * JD-Core Version:    0.7.0.1
 */