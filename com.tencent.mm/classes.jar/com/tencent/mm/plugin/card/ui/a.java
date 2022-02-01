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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.uz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context mContext;
  List<CardInfo> pXz;
  HashMap<String, Integer> pYu;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(113145);
    this.pXz = new ArrayList();
    this.pYu = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(113145);
  }
  
  public final CardInfo Ep(int paramInt)
  {
    AppMethodBeat.i(113147);
    CardInfo localCardInfo = (CardInfo)this.pXz.get(paramInt);
    AppMethodBeat.o(113147);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113146);
    int i = this.pXz.size();
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
    CardInfo localCardInfo = Ep(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131493334, null);
      paramViewGroup = new a();
      paramViewGroup.pYk = ((RelativeLayout)paramView.findViewById(2131298086));
      paramViewGroup.pYv = ((LinearLayout)paramView.findViewById(2131298233));
      paramViewGroup.pYl = ((ImageView)paramView.findViewById(2131298144));
      paramViewGroup.pYm = ((TextView)paramView.findViewById(2131298056));
      paramViewGroup.pYn = ((TextView)paramView.findViewById(2131298179));
      paramViewGroup.pYo = ((TextView)paramView.findViewById(2131308746));
      paramViewGroup.pYq = ((TextView)paramView.findViewById(2131298180));
      paramViewGroup.pYw = ((ImageView)paramView.findViewById(2131298172));
      paramViewGroup.pYx = ((TextView)paramView.findViewById(2131298088));
      paramViewGroup.pYy = ((TextView)paramView.findViewById(2131298217));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.csC()) {
        break label959;
      }
      paramViewGroup.pYl.setVisibility(0);
      paramViewGroup.pYn.setVisibility(0);
      paramViewGroup.pYo.setVisibility(0);
      paramViewGroup.pYq.setVisibility(8);
      paramViewGroup.pYm.setVisibility(0);
      paramViewGroup.pYm.setText(localCardInfo.csQ().gTG);
      if (!localCardInfo.csz()) {
        break label726;
      }
      if ((localCardInfo.csQ().LeC == null) || (localCardInfo.csQ().LeC.size() != 1)) {
        break label611;
      }
      paramViewGroup.pYn.setText(((abz)localCardInfo.csQ().LeC.get(0)).title);
      label306:
      if (localCardInfo.csQ().LeZ != 1) {
        break label746;
      }
      paramViewGroup.pYw.setVisibility(0);
      label328:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label758;
      }
      paramViewGroup.pYo.setText(this.mContext.getString(2131757195, new Object[] { l.AF(l) + "  -  " + l.AF(localCardInfo.getEndTime()) }));
      paramViewGroup.pYo.setVisibility(0);
      label424:
      paramInt = this.mContext.getResources().getDimensionPixelSize(2131166011);
      n.a(paramViewGroup.pYl, localCardInfo.csQ().iwv, paramInt, 2131234198, true);
      if (localCardInfo.csQ().LeX != 1) {
        break label837;
      }
      paramViewGroup.pYl.setAlpha(255);
      paramViewGroup.pYy.setVisibility(8);
      paramViewGroup.pYn.setTextColor(this.mContext.getResources().getColor(2131100116));
      paramViewGroup.pYm.setTextColor(this.mContext.getResources().getColor(2131100116));
      paramViewGroup.pYo.setTextColor(this.mContext.getResources().getColor(2131100571));
      label548:
      paramInt = ((Integer)this.pYu.get(localCardInfo.csV())).intValue();
      if (paramInt != 1) {
        break label931;
      }
      paramViewGroup.pYx.setText("");
      paramViewGroup.pYx.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(113148);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label611:
      if ((localCardInfo.csQ().LeC == null) || (localCardInfo.csQ().LeC.size() != 2)) {
        break label306;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((abz)localCardInfo.csQ().LeC.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((abz)localCardInfo.csQ().LeC.get(1)).title);
      paramViewGroup.pYn.setText(localStringBuilder.toString());
      break label306;
      label726:
      paramViewGroup.pYn.setText(localCardInfo.csQ().title);
      break label306;
      label746:
      paramViewGroup.pYw.setVisibility(8);
      break label328;
      label758:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.pYo.setText(this.mContext.getString(2131757194, new Object[] { l.AF(localCardInfo.getEndTime()) }));
        paramViewGroup.pYo.setVisibility(0);
        break label424;
      }
      paramViewGroup.pYo.setText("");
      paramViewGroup.pYo.setVisibility(8);
      break label424;
      label837:
      paramViewGroup.pYy.setText(localCardInfo.csQ().LeY);
      paramViewGroup.pYl.setAlpha(90);
      paramViewGroup.pYy.setVisibility(0);
      paramViewGroup.pYn.setTextColor(this.mContext.getResources().getColor(2131100571));
      paramViewGroup.pYm.setTextColor(this.mContext.getResources().getColor(2131100571));
      paramViewGroup.pYo.setTextColor(this.mContext.getResources().getColor(2131100571));
      break label548;
      label931:
      paramViewGroup.pYx.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.pYx.setVisibility(0);
      continue;
      label959:
      paramViewGroup.pYl.setVisibility(8);
      paramViewGroup.pYn.setVisibility(8);
      paramViewGroup.pYm.setVisibility(8);
      paramViewGroup.pYo.setVisibility(8);
      paramViewGroup.pYy.setVisibility(8);
      paramViewGroup.pYx.setVisibility(8);
      paramViewGroup.pYq.setVisibility(0);
      paramViewGroup.pYk.setBackgroundColor(this.mContext.getResources().getColor(2131100137));
      paramViewGroup.pYq.setText(this.mContext.getResources().getString(2131757117));
    }
  }
  
  public final class a
  {
    public RelativeLayout pYk;
    public ImageView pYl;
    public TextView pYm;
    public TextView pYn;
    public TextView pYo;
    public TextView pYq;
    public LinearLayout pYv;
    public ImageView pYw;
    public TextView pYx;
    public TextView pYy;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */