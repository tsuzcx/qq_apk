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
      paramViewGroup.tqQ = ((TextView)paramView.findViewById(2131301854));
      paramViewGroup.uhg = ((TextView)paramView.findViewById(2131301855));
      paramViewGroup.uhh = ((TextView)paramView.findViewById(2131301850));
      paramViewGroup.uhs = ((ImageView)paramView.findViewById(2131301852));
      paramView.setTag(paramViewGroup);
      localt = HW(paramInt);
      z.a(this.mContext, paramViewGroup.tqQ, localt.umG);
      paramViewGroup.uhg.setText(localt.umI);
      paramViewGroup.uhh.setText(this.mContext.getString(2131760940, new Object[] { com.tencent.mm.wallet_core.ui.e.C(localt.umH / 100.0D) }));
      if (localt.dBz != 1) {
        break label202;
      }
      paramViewGroup.uhs.setImageResource(2131233028);
      paramViewGroup.uhs.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(65632);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label202:
      if (localt.dBz == 2)
      {
        paramViewGroup.uhs.setImageResource(2131233017);
        paramViewGroup.uhs.setVisibility(0);
      }
      else
      {
        paramViewGroup.uhs.setVisibility(8);
      }
    }
  }
  
  final class a
  {
    TextView tqQ;
    TextView uhg;
    TextView uhh;
    ImageView uhs;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.d
 * JD-Core Version:    0.7.0.1
 */