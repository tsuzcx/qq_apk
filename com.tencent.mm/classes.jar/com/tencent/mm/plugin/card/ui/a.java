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
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context mContext;
  List<CardInfo> nZP;
  HashMap<String, Integer> oaK;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(113145);
    this.nZP = new ArrayList();
    this.oaK = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(113145);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113146);
    int i = this.nZP.size();
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
    CardInfo localCardInfo = zP(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131493247, null);
      paramViewGroup = new a();
      paramViewGroup.oaA = ((RelativeLayout)paramView.findViewById(2131297771));
      paramViewGroup.oaL = ((LinearLayout)paramView.findViewById(2131297915));
      paramViewGroup.oaB = ((ImageView)paramView.findViewById(2131297828));
      paramViewGroup.oaC = ((TextView)paramView.findViewById(2131297743));
      paramViewGroup.oaD = ((TextView)paramView.findViewById(2131297863));
      paramViewGroup.oaE = ((TextView)paramView.findViewById(2131305529));
      paramViewGroup.oaG = ((TextView)paramView.findViewById(2131297864));
      paramViewGroup.oaM = ((ImageView)paramView.findViewById(2131297856));
      paramViewGroup.oaN = ((TextView)paramView.findViewById(2131297773));
      paramViewGroup.oaO = ((TextView)paramView.findViewById(2131297899));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.bOU()) {
        break label959;
      }
      paramViewGroup.oaB.setVisibility(0);
      paramViewGroup.oaD.setVisibility(0);
      paramViewGroup.oaE.setVisibility(0);
      paramViewGroup.oaG.setVisibility(8);
      paramViewGroup.oaC.setVisibility(0);
      paramViewGroup.oaC.setText(localCardInfo.bPi().nVK);
      if (!localCardInfo.bOR()) {
        break label726;
      }
      if ((localCardInfo.bPi().Ekq == null) || (localCardInfo.bPi().Ekq.size() != 1)) {
        break label611;
      }
      paramViewGroup.oaD.setText(((yg)localCardInfo.bPi().Ekq.get(0)).title);
      label306:
      if (localCardInfo.bPi().EkO != 1) {
        break label746;
      }
      paramViewGroup.oaM.setVisibility(0);
      label328:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label758;
      }
      paramViewGroup.oaE.setText(this.mContext.getString(2131757025, new Object[] { l.qn(l) + "  -  " + l.qn(localCardInfo.getEndTime()) }));
      paramViewGroup.oaE.setVisibility(0);
      label424:
      paramInt = this.mContext.getResources().getDimensionPixelSize(2131165979);
      n.a(paramViewGroup.oaB, localCardInfo.bPi().hhs, paramInt, 2131233400, true);
      if (localCardInfo.bPi().EkM != 1) {
        break label837;
      }
      paramViewGroup.oaB.setAlpha(255);
      paramViewGroup.oaO.setVisibility(8);
      paramViewGroup.oaD.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.oaC.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.oaE.setTextColor(this.mContext.getResources().getColor(2131100469));
      label548:
      paramInt = ((Integer)this.oaK.get(localCardInfo.bPn())).intValue();
      if (paramInt != 1) {
        break label931;
      }
      paramViewGroup.oaN.setText("");
      paramViewGroup.oaN.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(113148);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label611:
      if ((localCardInfo.bPi().Ekq == null) || (localCardInfo.bPi().Ekq.size() != 2)) {
        break label306;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((yg)localCardInfo.bPi().Ekq.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((yg)localCardInfo.bPi().Ekq.get(1)).title);
      paramViewGroup.oaD.setText(localStringBuilder.toString());
      break label306;
      label726:
      paramViewGroup.oaD.setText(localCardInfo.bPi().title);
      break label306;
      label746:
      paramViewGroup.oaM.setVisibility(8);
      break label328;
      label758:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.oaE.setText(this.mContext.getString(2131757024, new Object[] { l.qn(localCardInfo.getEndTime()) }));
        paramViewGroup.oaE.setVisibility(0);
        break label424;
      }
      paramViewGroup.oaE.setText("");
      paramViewGroup.oaE.setVisibility(8);
      break label424;
      label837:
      paramViewGroup.oaO.setText(localCardInfo.bPi().EkN);
      paramViewGroup.oaB.setAlpha(90);
      paramViewGroup.oaO.setVisibility(0);
      paramViewGroup.oaD.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.oaC.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.oaE.setTextColor(this.mContext.getResources().getColor(2131100469));
      break label548;
      label931:
      paramViewGroup.oaN.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.oaN.setVisibility(0);
      continue;
      label959:
      paramViewGroup.oaB.setVisibility(8);
      paramViewGroup.oaD.setVisibility(8);
      paramViewGroup.oaC.setVisibility(8);
      paramViewGroup.oaE.setVisibility(8);
      paramViewGroup.oaO.setVisibility(8);
      paramViewGroup.oaN.setVisibility(8);
      paramViewGroup.oaG.setVisibility(0);
      paramViewGroup.oaA.setBackgroundColor(this.mContext.getResources().getColor(2131100106));
      paramViewGroup.oaG.setText(this.mContext.getResources().getString(2131756947));
    }
  }
  
  public final CardInfo zP(int paramInt)
  {
    AppMethodBeat.i(113147);
    CardInfo localCardInfo = (CardInfo)this.nZP.get(paramInt);
    AppMethodBeat.o(113147);
    return localCardInfo;
  }
  
  public final class a
  {
    public RelativeLayout oaA;
    public ImageView oaB;
    public TextView oaC;
    public TextView oaD;
    public TextView oaE;
    public TextView oaG;
    public LinearLayout oaL;
    public ImageView oaM;
    public TextView oaN;
    public TextView oaO;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */