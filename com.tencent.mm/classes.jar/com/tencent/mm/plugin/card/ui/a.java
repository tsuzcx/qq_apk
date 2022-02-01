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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.tu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context mContext;
  List<CardInfo> oJL;
  HashMap<String, Integer> oKG;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(113145);
    this.oJL = new ArrayList();
    this.oKG = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(113145);
  }
  
  public final CardInfo AK(int paramInt)
  {
    AppMethodBeat.i(113147);
    CardInfo localCardInfo = (CardInfo)this.oJL.get(paramInt);
    AppMethodBeat.o(113147);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113146);
    int i = this.oJL.size();
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
    CardInfo localCardInfo = AK(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131493247, null);
      paramViewGroup = new a();
      paramViewGroup.oKw = ((RelativeLayout)paramView.findViewById(2131297771));
      paramViewGroup.oKH = ((LinearLayout)paramView.findViewById(2131297915));
      paramViewGroup.oKx = ((ImageView)paramView.findViewById(2131297828));
      paramViewGroup.oKy = ((TextView)paramView.findViewById(2131297743));
      paramViewGroup.oKz = ((TextView)paramView.findViewById(2131297863));
      paramViewGroup.oKA = ((TextView)paramView.findViewById(2131305529));
      paramViewGroup.oKC = ((TextView)paramView.findViewById(2131297864));
      paramViewGroup.oKI = ((ImageView)paramView.findViewById(2131297856));
      paramViewGroup.oKJ = ((TextView)paramView.findViewById(2131297773));
      paramViewGroup.oKK = ((TextView)paramView.findViewById(2131297899));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.bUO()) {
        break label959;
      }
      paramViewGroup.oKx.setVisibility(0);
      paramViewGroup.oKz.setVisibility(0);
      paramViewGroup.oKA.setVisibility(0);
      paramViewGroup.oKC.setVisibility(8);
      paramViewGroup.oKy.setVisibility(0);
      paramViewGroup.oKy.setText(localCardInfo.bVc().oFG);
      if (!localCardInfo.bUL()) {
        break label726;
      }
      if ((localCardInfo.bVc().GjY == null) || (localCardInfo.bVc().GjY.size() != 1)) {
        break label611;
      }
      paramViewGroup.oKz.setText(((aai)localCardInfo.bVc().GjY.get(0)).title);
      label306:
      if (localCardInfo.bVc().Gkw != 1) {
        break label746;
      }
      paramViewGroup.oKI.setVisibility(0);
      label328:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label758;
      }
      paramViewGroup.oKA.setText(this.mContext.getString(2131757025, new Object[] { l.sz(l) + "  -  " + l.sz(localCardInfo.getEndTime()) }));
      paramViewGroup.oKA.setVisibility(0);
      label424:
      paramInt = this.mContext.getResources().getDimensionPixelSize(2131165979);
      n.a(paramViewGroup.oKx, localCardInfo.bVc().hCp, paramInt, 2131233400, true);
      if (localCardInfo.bVc().Gku != 1) {
        break label837;
      }
      paramViewGroup.oKx.setAlpha(255);
      paramViewGroup.oKK.setVisibility(8);
      paramViewGroup.oKz.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.oKy.setTextColor(this.mContext.getResources().getColor(2131100085));
      paramViewGroup.oKA.setTextColor(this.mContext.getResources().getColor(2131100469));
      label548:
      paramInt = ((Integer)this.oKG.get(localCardInfo.bVh())).intValue();
      if (paramInt != 1) {
        break label931;
      }
      paramViewGroup.oKJ.setText("");
      paramViewGroup.oKJ.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(113148);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label611:
      if ((localCardInfo.bVc().GjY == null) || (localCardInfo.bVc().GjY.size() != 2)) {
        break label306;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((aai)localCardInfo.bVc().GjY.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((aai)localCardInfo.bVc().GjY.get(1)).title);
      paramViewGroup.oKz.setText(localStringBuilder.toString());
      break label306;
      label726:
      paramViewGroup.oKz.setText(localCardInfo.bVc().title);
      break label306;
      label746:
      paramViewGroup.oKI.setVisibility(8);
      break label328;
      label758:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.oKA.setText(this.mContext.getString(2131757024, new Object[] { l.sz(localCardInfo.getEndTime()) }));
        paramViewGroup.oKA.setVisibility(0);
        break label424;
      }
      paramViewGroup.oKA.setText("");
      paramViewGroup.oKA.setVisibility(8);
      break label424;
      label837:
      paramViewGroup.oKK.setText(localCardInfo.bVc().Gkv);
      paramViewGroup.oKx.setAlpha(90);
      paramViewGroup.oKK.setVisibility(0);
      paramViewGroup.oKz.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.oKy.setTextColor(this.mContext.getResources().getColor(2131100469));
      paramViewGroup.oKA.setTextColor(this.mContext.getResources().getColor(2131100469));
      break label548;
      label931:
      paramViewGroup.oKJ.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.oKJ.setVisibility(0);
      continue;
      label959:
      paramViewGroup.oKx.setVisibility(8);
      paramViewGroup.oKz.setVisibility(8);
      paramViewGroup.oKy.setVisibility(8);
      paramViewGroup.oKA.setVisibility(8);
      paramViewGroup.oKK.setVisibility(8);
      paramViewGroup.oKJ.setVisibility(8);
      paramViewGroup.oKC.setVisibility(0);
      paramViewGroup.oKw.setBackgroundColor(this.mContext.getResources().getColor(2131100106));
      paramViewGroup.oKC.setText(this.mContext.getResources().getString(2131756947));
    }
  }
  
  public final class a
  {
    public TextView oKA;
    public TextView oKC;
    public LinearLayout oKH;
    public ImageView oKI;
    public TextView oKJ;
    public TextView oKK;
    public RelativeLayout oKw;
    public ImageView oKx;
    public TextView oKy;
    public TextView oKz;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */