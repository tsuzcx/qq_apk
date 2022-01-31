package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.r;

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
    AppMethodBeat.i(42782);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130970036, paramViewGroup, false);
      paramViewGroup = new f.a(this);
      paramViewGroup.iJG = ((TextView)paramView.findViewById(2131825720));
      paramViewGroup.kPB = ((TextView)paramView.findViewById(2131825723));
      paramViewGroup.ojf = ((TextView)paramView.findViewById(2131825721));
      paramViewGroup.ojg = ((TextView)paramView.findViewById(2131825722));
      paramViewGroup.Fb = paramInt;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      r localr = yz(paramInt);
      paramViewGroup.iJG.setText(localr.ooq);
      paramViewGroup.ojf.setText(localr.oor);
      paramViewGroup.ojg.setText(this.mContext.getString(2131301197, new Object[] { com.tencent.mm.wallet_core.ui.e.E(localr.ony / 100.0D) }));
      String str2 = this.mContext.getString(2131301316, new Object[] { Long.valueOf(localr.onw), Long.valueOf(localr.oos) });
      String str1 = str2;
      if (localr.status == 5) {
        str1 = this.mContext.getString(2131301317) + " " + str2;
      }
      paramViewGroup.kPB.setText(str1);
      AppMethodBeat.o(42782);
      return paramView;
      paramViewGroup = (f.a)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.f
 * JD-Core Version:    0.7.0.1
 */