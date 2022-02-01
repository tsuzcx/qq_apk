package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.plugin.collect.model.h;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  List<h> qzs;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(64041);
    this.qzs = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(64041);
  }
  
  public final h Fd(int paramInt)
  {
    AppMethodBeat.i(64043);
    h localh = (h)this.qzs.get(paramInt);
    AppMethodBeat.o(64043);
    return localh;
  }
  
  public final void dd(List<h> paramList)
  {
    AppMethodBeat.i(64046);
    this.qzs.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64046);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64042);
    int i = this.qzs.size();
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
      localView = aa.jQ(this.mContext).inflate(2131493667, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    paramView = (a)localView.getTag();
    paramViewGroup = Fd(paramInt);
    paramView.qpf.setText(e.a(this.mContext, paramViewGroup.qwd, paramViewGroup.type));
    paramView.qzt.setText(e.Fb(paramViewGroup.dKt));
    paramView.jVn.setText(this.mContext.getString(2131757667, new Object[] { Integer.valueOf(paramViewGroup.qwe) }));
    AppMethodBeat.o(64044);
    return localView;
  }
  
  public final void setData(List<h> paramList)
  {
    AppMethodBeat.i(64045);
    this.qzs.clear();
    this.qzs.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64045);
  }
  
  static final class a
  {
    TextView jVn;
    TextView qpf;
    WalletTextView qzt;
    TextView qzu;
    
    public a(View paramView)
    {
      AppMethodBeat.i(64040);
      this.qpf = ((TextView)paramView.findViewById(2131298847));
      this.qzu = ((TextView)paramView.findViewById(2131298846));
      this.qzt = ((WalletTextView)paramView.findViewById(2131298852));
      this.jVn = ((TextView)paramView.findViewById(2131298848));
      AppMethodBeat.o(64040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b
 * JD-Core Version:    0.7.0.1
 */