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
      paramViewGroup.upn = ((TextView)paramView.findViewById(2131301854));
      paramViewGroup.vjQ = ((TextView)paramView.findViewById(2131301855));
      paramViewGroup.vjR = ((TextView)paramView.findViewById(2131301850));
      paramViewGroup.vkc = ((ImageView)paramView.findViewById(2131301852));
      paramView.setTag(paramViewGroup);
      localt = Js(paramInt);
      z.a(this.mContext, paramViewGroup.upn, localt.vpm);
      paramViewGroup.vjQ.setText(localt.vpo);
      paramViewGroup.vjR.setText(this.mContext.getString(2131760940, new Object[] { com.tencent.mm.wallet_core.ui.e.C(localt.vpn / 100.0D) }));
      if (localt.dNM != 1) {
        break label202;
      }
      paramViewGroup.vkc.setImageResource(2131233028);
      paramViewGroup.vkc.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(65632);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label202:
      if (localt.dNM == 2)
      {
        paramViewGroup.vkc.setImageResource(2131233017);
        paramViewGroup.vkc.setVisibility(0);
      }
      else
      {
        paramViewGroup.vkc.setVisibility(8);
      }
    }
  }
  
  final class a
  {
    TextView upn;
    TextView vjQ;
    TextView vjR;
    ImageView vkc;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.d
 * JD-Core Version:    0.7.0.1
 */