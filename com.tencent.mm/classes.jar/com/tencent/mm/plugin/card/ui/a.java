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
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  List<CardInfo> krw;
  HashMap<String, Integer> ksr;
  Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(88211);
    this.krw = new ArrayList();
    this.ksr = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(88211);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(88212);
    int i = this.krw.size();
    AppMethodBeat.o(88212);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88214);
    CardInfo localCardInfo = tg(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130968905, null);
      paramViewGroup = new a.a(this);
      paramViewGroup.ksh = ((RelativeLayout)paramView.findViewById(2131821968));
      paramViewGroup.kss = ((LinearLayout)paramView.findViewById(2131821969));
      paramViewGroup.ksi = ((ImageView)paramView.findViewById(2131821970));
      paramViewGroup.ksj = ((TextView)paramView.findViewById(2131821971));
      paramViewGroup.ksk = ((TextView)paramView.findViewById(2131821973));
      paramViewGroup.ksl = ((TextView)paramView.findViewById(2131821949));
      paramViewGroup.ksn = ((TextView)paramView.findViewById(2131821976));
      paramViewGroup.kst = ((ImageView)paramView.findViewById(2131821972));
      paramViewGroup.ksu = ((TextView)paramView.findViewById(2131821974));
      paramViewGroup.ksv = ((TextView)paramView.findViewById(2131821975));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.baQ()) {
        break label959;
      }
      paramViewGroup.ksi.setVisibility(0);
      paramViewGroup.ksk.setVisibility(0);
      paramViewGroup.ksl.setVisibility(0);
      paramViewGroup.ksn.setVisibility(8);
      paramViewGroup.ksj.setVisibility(0);
      paramViewGroup.ksj.setText(localCardInfo.bbd().knw);
      if (!localCardInfo.baN()) {
        break label726;
      }
      if ((localCardInfo.bbd().wFZ == null) || (localCardInfo.bbd().wFZ.size() != 1)) {
        break label611;
      }
      paramViewGroup.ksk.setText(((uo)localCardInfo.bbd().wFZ.get(0)).title);
      label306:
      if (localCardInfo.bbd().wGy != 1) {
        break label746;
      }
      paramViewGroup.kst.setVisibility(0);
      label328:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label758;
      }
      paramViewGroup.ksl.setText(this.mContext.getString(2131298083, new Object[] { l.ha(l) + "  -  " + l.ha(localCardInfo.getEndTime()) }));
      paramViewGroup.ksl.setVisibility(0);
      label424:
      paramInt = this.mContext.getResources().getDimensionPixelSize(2131428180);
      m.a(paramViewGroup.ksi, localCardInfo.bbd().kmm, paramInt, 2130839758, true);
      if (localCardInfo.bbd().wGw != 1) {
        break label837;
      }
      paramViewGroup.ksi.setAlpha(255);
      paramViewGroup.ksv.setVisibility(8);
      paramViewGroup.ksk.setTextColor(this.mContext.getResources().getColor(2131689825));
      paramViewGroup.ksj.setTextColor(this.mContext.getResources().getColor(2131689825));
      paramViewGroup.ksl.setTextColor(this.mContext.getResources().getColor(2131690143));
      label548:
      paramInt = ((Integer)this.ksr.get(localCardInfo.bbi())).intValue();
      if (paramInt != 1) {
        break label931;
      }
      paramViewGroup.ksu.setText("");
      paramViewGroup.ksu.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(88214);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label611:
      if ((localCardInfo.bbd().wFZ == null) || (localCardInfo.bbd().wFZ.size() != 2)) {
        break label306;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((uo)localCardInfo.bbd().wFZ.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((uo)localCardInfo.bbd().wFZ.get(1)).title);
      paramViewGroup.ksk.setText(localStringBuilder.toString());
      break label306;
      label726:
      paramViewGroup.ksk.setText(localCardInfo.bbd().title);
      break label306;
      label746:
      paramViewGroup.kst.setVisibility(8);
      break label328;
      label758:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.ksl.setText(this.mContext.getString(2131298082, new Object[] { l.ha(localCardInfo.getEndTime()) }));
        paramViewGroup.ksl.setVisibility(0);
        break label424;
      }
      paramViewGroup.ksl.setText("");
      paramViewGroup.ksl.setVisibility(8);
      break label424;
      label837:
      paramViewGroup.ksv.setText(localCardInfo.bbd().wGx);
      paramViewGroup.ksi.setAlpha(90);
      paramViewGroup.ksv.setVisibility(0);
      paramViewGroup.ksk.setTextColor(this.mContext.getResources().getColor(2131690143));
      paramViewGroup.ksj.setTextColor(this.mContext.getResources().getColor(2131690143));
      paramViewGroup.ksl.setTextColor(this.mContext.getResources().getColor(2131690143));
      break label548;
      label931:
      paramViewGroup.ksu.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.ksu.setVisibility(0);
      continue;
      label959:
      paramViewGroup.ksi.setVisibility(8);
      paramViewGroup.ksk.setVisibility(8);
      paramViewGroup.ksj.setVisibility(8);
      paramViewGroup.ksl.setVisibility(8);
      paramViewGroup.ksv.setVisibility(8);
      paramViewGroup.ksu.setVisibility(8);
      paramViewGroup.ksn.setVisibility(0);
      paramViewGroup.ksh.setBackgroundColor(this.mContext.getResources().getColor(2131689845));
      paramViewGroup.ksn.setText(this.mContext.getResources().getString(2131298005));
    }
  }
  
  public final CardInfo tg(int paramInt)
  {
    AppMethodBeat.i(88213);
    CardInfo localCardInfo = (CardInfo)this.krw.get(paramInt);
    AppMethodBeat.o(88213);
    return localCardInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */