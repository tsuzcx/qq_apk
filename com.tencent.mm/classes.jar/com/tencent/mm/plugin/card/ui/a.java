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
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context mContext;
  List<CardInfo> nwP;
  HashMap<String, Integer> nxK;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(113145);
    this.nwP = new ArrayList();
    this.nxK = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(113145);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113146);
    int i = this.nwP.size();
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
    CardInfo localCardInfo = yZ(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131493247, null);
      paramViewGroup = new a();
      paramViewGroup.nxA = ((RelativeLayout)paramView.findViewById(2131297771));
      paramViewGroup.nxL = ((LinearLayout)paramView.findViewById(2131297915));
      paramViewGroup.nxB = ((ImageView)paramView.findViewById(2131297828));
      paramViewGroup.nxC = ((TextView)paramView.findViewById(2131297743));
      paramViewGroup.nxD = ((TextView)paramView.findViewById(2131297863));
      paramViewGroup.nxE = ((TextView)paramView.findViewById(2131305529));
      paramViewGroup.nxG = ((TextView)paramView.findViewById(2131297864));
      paramViewGroup.nxM = ((ImageView)paramView.findViewById(2131297856));
      paramViewGroup.nxN = ((TextView)paramView.findViewById(2131297773));
      paramViewGroup.nxO = ((TextView)paramView.findViewById(2131297899));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.bHH()) {
        break label959;
      }
      paramViewGroup.nxB.setVisibility(0);
      paramViewGroup.nxD.setVisibility(0);
      paramViewGroup.nxE.setVisibility(0);
      paramViewGroup.nxG.setVisibility(8);
      paramViewGroup.nxC.setVisibility(0);
      paramViewGroup.nxC.setText(localCardInfo.bHV().nsK);
      if (!localCardInfo.bHE()) {
        break label726;
      }
      if ((localCardInfo.bHV().CRF == null) || (localCardInfo.bHV().CRF.size() != 1)) {
        break label611;
      }
      paramViewGroup.nxD.setText(((xo)localCardInfo.bHV().CRF.get(0)).title);
      label306:
      if (localCardInfo.bHV().CSd != 1) {
        break label746;
      }
      paramViewGroup.nxM.setVisibility(0);
      label328:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label758;
      }
      paramViewGroup.nxE.setText(this.mContext.getString(2131757025, new Object[] { l.mz(l) + "  -  " + l.mz(localCardInfo.getEndTime()) }));
      paramViewGroup.nxE.setVisibility(0);
      label424:
      paramInt = this.mContext.getResources().getDimensionPixelSize(2131165979);
      n.a(paramViewGroup.nxB, localCardInfo.bHV().gGR, paramInt, 2131233400, true);
      if (localCardInfo.bHV().CSb != 1) {
        break label837;
      }
      paramViewGroup.nxB.setAlpha(255);
      paramViewGroup.nxO.setVisibility(8);
      paramViewGroup.nxD.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.nxC.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.nxE.setTextColor(this.mContext.getResources().getColor(2131100469));
      label548:
      paramInt = ((Integer)this.nxK.get(localCardInfo.bIa())).intValue();
      if (paramInt != 1) {
        break label931;
      }
      paramViewGroup.nxN.setText("");
      paramViewGroup.nxN.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(113148);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label611:
      if ((localCardInfo.bHV().CRF == null) || (localCardInfo.bHV().CRF.size() != 2)) {
        break label306;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((xo)localCardInfo.bHV().CRF.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((xo)localCardInfo.bHV().CRF.get(1)).title);
      paramViewGroup.nxD.setText(localStringBuilder.toString());
      break label306;
      label726:
      paramViewGroup.nxD.setText(localCardInfo.bHV().title);
      break label306;
      label746:
      paramViewGroup.nxM.setVisibility(8);
      break label328;
      label758:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.nxE.setText(this.mContext.getString(2131757024, new Object[] { l.mz(localCardInfo.getEndTime()) }));
        paramViewGroup.nxE.setVisibility(0);
        break label424;
      }
      paramViewGroup.nxE.setText("");
      paramViewGroup.nxE.setVisibility(8);
      break label424;
      label837:
      paramViewGroup.nxO.setText(localCardInfo.bHV().CSc);
      paramViewGroup.nxB.setAlpha(90);
      paramViewGroup.nxO.setVisibility(0);
      paramViewGroup.nxD.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.nxC.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.nxE.setTextColor(this.mContext.getResources().getColor(2131100469));
      break label548;
      label931:
      paramViewGroup.nxN.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.nxN.setVisibility(0);
      continue;
      label959:
      paramViewGroup.nxB.setVisibility(8);
      paramViewGroup.nxD.setVisibility(8);
      paramViewGroup.nxC.setVisibility(8);
      paramViewGroup.nxE.setVisibility(8);
      paramViewGroup.nxO.setVisibility(8);
      paramViewGroup.nxN.setVisibility(8);
      paramViewGroup.nxG.setVisibility(0);
      paramViewGroup.nxA.setBackgroundColor(this.mContext.getResources().getColor(2131100106));
      paramViewGroup.nxG.setText(this.mContext.getResources().getString(2131756947));
    }
  }
  
  public final CardInfo yZ(int paramInt)
  {
    AppMethodBeat.i(113147);
    CardInfo localCardInfo = (CardInfo)this.nwP.get(paramInt);
    AppMethodBeat.o(113147);
    return localCardInfo;
  }
  
  public final class a
  {
    public RelativeLayout nxA;
    public ImageView nxB;
    public TextView nxC;
    public TextView nxD;
    public TextView nxE;
    public TextView nxG;
    public LinearLayout nxL;
    public ImageView nxM;
    public TextView nxN;
    public TextView nxO;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */