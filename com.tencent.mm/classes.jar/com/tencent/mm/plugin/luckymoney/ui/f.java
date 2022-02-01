package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.t;

public final class f
  extends e
{
  private Context mContext = null;
  
  public f(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(65660);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131494650, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.lCL = ((TextView)paramView.findViewById(2131301859));
      paramViewGroup.lDu = ((TextView)paramView.findViewById(2131301857));
      paramViewGroup.vjQ = ((TextView)paramView.findViewById(2131301858));
      paramViewGroup.vjR = ((TextView)paramView.findViewById(2131301856));
      paramViewGroup.fq = paramInt;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      t localt = Js(paramInt);
      paramViewGroup.lCL.setText(localt.vpp);
      paramViewGroup.vjQ.setText(localt.vpq);
      paramViewGroup.vjR.setText(this.mContext.getString(2131760831, new Object[] { com.tencent.mm.wallet_core.ui.e.C(localt.vok / 100.0D) }));
      String str2 = this.mContext.getString(2131760961, new Object[] { Long.valueOf(localt.voi), Long.valueOf(localt.vpr) });
      String str1 = str2;
      if (localt.status == 5) {
        str1 = this.mContext.getString(2131760962) + " " + str2;
      }
      paramViewGroup.lDu.setText(str1);
      AppMethodBeat.o(65660);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  final class a
  {
    int fq;
    TextView lCL;
    TextView lDu;
    TextView vjQ;
    TextView vjR;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.f
 * JD-Core Version:    0.7.0.1
 */