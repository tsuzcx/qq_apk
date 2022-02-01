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
      paramViewGroup.siX = ((TextView)paramView.findViewById(2131301854));
      paramViewGroup.sYS = ((TextView)paramView.findViewById(2131301855));
      paramViewGroup.sYT = ((TextView)paramView.findViewById(2131301850));
      paramViewGroup.sZe = ((ImageView)paramView.findViewById(2131301852));
      paramView.setTag(paramViewGroup);
      localt = Gb(paramInt);
      z.a(this.mContext, paramViewGroup.siX, localt.ter);
      paramViewGroup.sYS.setText(localt.tet);
      paramViewGroup.sYT.setText(this.mContext.getString(2131760940, new Object[] { com.tencent.mm.wallet_core.ui.e.D(localt.tes / 100.0D) }));
      if (localt.dDN != 1) {
        break label202;
      }
      paramViewGroup.sZe.setImageResource(2131233028);
      paramViewGroup.sZe.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(65632);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label202:
      if (localt.dDN == 2)
      {
        paramViewGroup.sZe.setImageResource(2131233017);
        paramViewGroup.sZe.setVisibility(0);
      }
      else
      {
        paramViewGroup.sZe.setVisibility(8);
      }
    }
  }
  
  final class a
  {
    TextView sYS;
    TextView sYT;
    ImageView sZe;
    TextView siX;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.d
 * JD-Core Version:    0.7.0.1
 */