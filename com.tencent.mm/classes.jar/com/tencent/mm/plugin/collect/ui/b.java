package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.plugin.collect.model.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.af;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  List<g> bMf;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(64041);
    this.bMf = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(64041);
  }
  
  public final g Jo(int paramInt)
  {
    AppMethodBeat.i(64043);
    g localg = (g)this.bMf.get(paramInt);
    AppMethodBeat.o(64043);
    return localg;
  }
  
  public final void eX(List<g> paramList)
  {
    AppMethodBeat.i(64046);
    this.bMf.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64046);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64042);
    int i = this.bMf.size();
    AppMethodBeat.o(64042);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64044);
    View localView = paramView;
    if (paramView == null)
    {
      localView = af.mU(this.mContext).inflate(a.g.collect_bill_list_item, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    paramView = (a)localView.getTag();
    paramViewGroup = Jo(paramInt);
    paramView.wRf.setText(e.a(this.mContext, paramViewGroup.wYy, paramViewGroup.type));
    paramView.xbL.setText(e.Jm(paramViewGroup.hHX));
    paramView.pJi.setText(this.mContext.getString(a.i.collect_bill_total_num_text, new Object[] { Integer.valueOf(paramViewGroup.wYz) }));
    AppMethodBeat.o(64044);
    return localView;
  }
  
  public final void setData(List<g> paramList)
  {
    AppMethodBeat.i(64045);
    this.bMf.clear();
    this.bMf.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64045);
  }
  
  static final class a
  {
    TextView pJi;
    TextView wRf;
    WalletTextView xbL;
    TextView xbM;
    
    public a(View paramView)
    {
      AppMethodBeat.i(64040);
      this.wRf = ((TextView)paramView.findViewById(a.f.collect_bill_list_date_tv));
      this.xbM = ((TextView)paramView.findViewById(a.f.collect_bill_list_currency_tv));
      this.xbL = ((WalletTextView)paramView.findViewById(a.f.collect_bill_list_money_tv));
      this.pJi = ((TextView)paramView.findViewById(a.f.collect_bill_list_desc_tv));
      AppMethodBeat.o(64040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b
 * JD-Core Version:    0.7.0.1
 */