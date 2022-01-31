package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.x;

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
    AppMethodBeat.i(42754);
    r localr;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130970034, paramViewGroup, false);
      paramViewGroup = new d.a(this);
      paramViewGroup.nzx = ((TextView)paramView.findViewById(2131825714));
      paramViewGroup.ojf = ((TextView)paramView.findViewById(2131825716));
      paramViewGroup.ojg = ((TextView)paramView.findViewById(2131825717));
      paramViewGroup.ojr = ((ImageView)paramView.findViewById(2131825715));
      paramView.setTag(paramViewGroup);
      localr = yz(paramInt);
      x.a(this.mContext, paramViewGroup.nzx, localr.oon);
      paramViewGroup.ojf.setText(localr.oop);
      paramViewGroup.ojg.setText(this.mContext.getString(2131301295, new Object[] { com.tencent.mm.wallet_core.ui.e.E(localr.ooo / 100.0D) }));
      if (localr.cMP != 1) {
        break label202;
      }
      paramViewGroup.ojr.setImageResource(2130839415);
      paramViewGroup.ojr.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(42754);
      return paramView;
      paramViewGroup = (d.a)paramView.getTag();
      break;
      label202:
      if (localr.cMP == 2)
      {
        paramViewGroup.ojr.setImageResource(2130839404);
        paramViewGroup.ojr.setVisibility(0);
      }
      else
      {
        paramViewGroup.ojr.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.d
 * JD-Core Version:    0.7.0.1
 */