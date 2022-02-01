package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  List<com.tencent.mm.plugin.collect.model.a> qzs;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(64030);
    this.qzs = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(64030);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64031);
    int i = this.qzs.size();
    AppMethodBeat.o(64031);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(64032);
    Object localObject = this.qzs.get(paramInt);
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
      localView = aa.jQ(this.mContext).inflate(2131493665, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    paramView = (com.tencent.mm.plugin.collect.model.a)this.qzs.get(paramInt);
    paramViewGroup = (a)localView.getTag();
    TextView localTextView = paramViewGroup.qpf;
    Context localContext = this.mContext;
    long l = paramView.timestamp;
    localTextView.setText(new SimpleDateFormat(localContext.getString(2131757655)).format(new Date(l * 1000L)));
    paramViewGroup.qzt.setText(e.Fb(paramView.dFu));
    if (!Util.isNullOrNil(paramView.desc))
    {
      paramViewGroup.jVn.setText(paramView.desc);
      paramViewGroup.jVn.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(64033);
      return localView;
      paramViewGroup.jVn.setVisibility(8);
    }
  }
  
  static final class a
  {
    TextView jVn;
    TextView qpf;
    WalletTextView qzt;
    
    public a(View paramView)
    {
      AppMethodBeat.i(64029);
      this.qpf = ((TextView)paramView.findViewById(2131298838));
      this.qzt = ((WalletTextView)paramView.findViewById(2131298855));
      this.jVn = ((TextView)paramView.findViewById(2131298839));
      AppMethodBeat.o(64029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.a
 * JD-Core Version:    0.7.0.1
 */