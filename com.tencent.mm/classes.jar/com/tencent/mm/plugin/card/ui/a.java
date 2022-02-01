package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.ts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context mContext;
  List<CardInfo> oDj;
  HashMap<String, Integer> oEe;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(113145);
    this.oDj = new ArrayList();
    this.oEe = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(113145);
  }
  
  public final CardInfo Ay(int paramInt)
  {
    AppMethodBeat.i(113147);
    CardInfo localCardInfo = (CardInfo)this.oDj.get(paramInt);
    AppMethodBeat.o(113147);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113146);
    int i = this.oDj.size();
    AppMethodBeat.o(113146);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113148);
    CardInfo localCardInfo = Ay(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131493247, null);
      paramViewGroup = new a();
      paramViewGroup.oDU = ((RelativeLayout)paramView.findViewById(2131297771));
      paramViewGroup.oEf = ((LinearLayout)paramView.findViewById(2131297915));
      paramViewGroup.oDV = ((ImageView)paramView.findViewById(2131297828));
      paramViewGroup.oDW = ((TextView)paramView.findViewById(2131297743));
      paramViewGroup.oDX = ((TextView)paramView.findViewById(2131297863));
      paramViewGroup.oDY = ((TextView)paramView.findViewById(2131305529));
      paramViewGroup.oEa = ((TextView)paramView.findViewById(2131297864));
      paramViewGroup.oEg = ((ImageView)paramView.findViewById(2131297856));
      paramViewGroup.oEh = ((TextView)paramView.findViewById(2131297773));
      paramViewGroup.oEi = ((TextView)paramView.findViewById(2131297899));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.bTz()) {
        break label959;
      }
      paramViewGroup.oDV.setVisibility(0);
      paramViewGroup.oDX.setVisibility(0);
      paramViewGroup.oDY.setVisibility(0);
      paramViewGroup.oEa.setVisibility(8);
      paramViewGroup.oDW.setVisibility(0);
      paramViewGroup.oDW.setText(localCardInfo.bTN().oze);
      if (!localCardInfo.bTw()) {
        break label726;
      }
      if ((localCardInfo.bTN().FRz == null) || (localCardInfo.bTN().FRz.size() != 1)) {
        break label611;
      }
      paramViewGroup.oDX.setText(((aaf)localCardInfo.bTN().FRz.get(0)).title);
      label306:
      if (localCardInfo.bTN().FRX != 1) {
        break label746;
      }
      paramViewGroup.oEg.setVisibility(0);
      label328:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label758;
      }
      paramViewGroup.oDY.setText(this.mContext.getString(2131757025, new Object[] { l.sm(l) + "  -  " + l.sm(localCardInfo.getEndTime()) }));
      paramViewGroup.oDY.setVisibility(0);
      label424:
      paramInt = this.mContext.getResources().getDimensionPixelSize(2131165979);
      n.a(paramViewGroup.oDV, localCardInfo.bTN().hzB, paramInt, 2131233400, true);
      if (localCardInfo.bTN().FRV != 1) {
        break label837;
      }
      paramViewGroup.oDV.setAlpha(255);
      paramViewGroup.oEi.setVisibility(8);
      paramViewGroup.oDX.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.oDW.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.oDY.setTextColor(this.mContext.getResources().getColor(2131100469));
      label548:
      paramInt = ((Integer)this.oEe.get(localCardInfo.bTS())).intValue();
      if (paramInt != 1) {
        break label931;
      }
      paramViewGroup.oEh.setText("");
      paramViewGroup.oEh.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(113148);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label611:
      if ((localCardInfo.bTN().FRz == null) || (localCardInfo.bTN().FRz.size() != 2)) {
        break label306;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((aaf)localCardInfo.bTN().FRz.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((aaf)localCardInfo.bTN().FRz.get(1)).title);
      paramViewGroup.oDX.setText(localStringBuilder.toString());
      break label306;
      label726:
      paramViewGroup.oDX.setText(localCardInfo.bTN().title);
      break label306;
      label746:
      paramViewGroup.oEg.setVisibility(8);
      break label328;
      label758:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.oDY.setText(this.mContext.getString(2131757024, new Object[] { l.sm(localCardInfo.getEndTime()) }));
        paramViewGroup.oDY.setVisibility(0);
        break label424;
      }
      paramViewGroup.oDY.setText("");
      paramViewGroup.oDY.setVisibility(8);
      break label424;
      label837:
      paramViewGroup.oEi.setText(localCardInfo.bTN().FRW);
      paramViewGroup.oDV.setAlpha(90);
      paramViewGroup.oEi.setVisibility(0);
      paramViewGroup.oDX.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.oDW.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.oDY.setTextColor(this.mContext.getResources().getColor(2131100469));
      break label548;
      label931:
      paramViewGroup.oEh.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.oEh.setVisibility(0);
      continue;
      label959:
      paramViewGroup.oDV.setVisibility(8);
      paramViewGroup.oDX.setVisibility(8);
      paramViewGroup.oDW.setVisibility(8);
      paramViewGroup.oDY.setVisibility(8);
      paramViewGroup.oEi.setVisibility(8);
      paramViewGroup.oEh.setVisibility(8);
      paramViewGroup.oEa.setVisibility(0);
      paramViewGroup.oDU.setBackgroundColor(this.mContext.getResources().getColor(2131100106));
      paramViewGroup.oEa.setText(this.mContext.getResources().getString(2131756947));
    }
  }
  
  public final class a
  {
    public RelativeLayout oDU;
    public ImageView oDV;
    public TextView oDW;
    public TextView oDX;
    public TextView oDY;
    public TextView oEa;
    public LinearLayout oEf;
    public ImageView oEg;
    public TextView oEh;
    public TextView oEi;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */