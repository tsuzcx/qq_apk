package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.t;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.wallet_core.ui.f;

public final class d
  extends e
{
  private Context mContext;
  
  public d(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(65632);
    t localt;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131494648, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.uAJ = ((TextView)paramView.findViewById(2131301854));
      paramViewGroup.vvV = ((TextView)paramView.findViewById(2131301855));
      paramViewGroup.vvW = ((TextView)paramView.findViewById(2131301850));
      paramViewGroup.vwh = ((ImageView)paramView.findViewById(2131301852));
      paramView.setTag(paramViewGroup);
      localt = JR(paramInt);
      z.a(this.mContext, paramViewGroup.uAJ, localt.vBr);
      paramViewGroup.vvV.setText(localt.vBt);
      paramViewGroup.vvW.setText(this.mContext.getString(2131760940, new Object[] { f.C(localt.vBs / 100.0D) }));
      if (localt.dPc != 1) {
        break label202;
      }
      paramViewGroup.vwh.setImageResource(2131233028);
      paramViewGroup.vwh.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(65632);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label202:
      if (localt.dPc == 2)
      {
        paramViewGroup.vwh.setImageResource(2131233017);
        paramViewGroup.vwh.setVisibility(0);
      }
      else
      {
        paramViewGroup.vwh.setVisibility(8);
      }
    }
  }
  
  final class a
  {
    TextView uAJ;
    TextView vvV;
    TextView vvW;
    ImageView vwh;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.d
 * JD-Core Version:    0.7.0.1
 */