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
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.vb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context mContext;
  List<CardInfo> tup;
  HashMap<String, Integer> tuq;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(113145);
    this.tup = new ArrayList();
    this.tuq = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(113145);
  }
  
  public final CardInfo HQ(int paramInt)
  {
    AppMethodBeat.i(113147);
    CardInfo localCardInfo = (CardInfo)this.tup.get(paramInt);
    AppMethodBeat.o(113147);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113146);
    int i = this.tup.size();
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
    CardInfo localCardInfo = HQ(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.e.thI, null);
      paramViewGroup = new a();
      paramViewGroup.tuf = ((RelativeLayout)paramView.findViewById(a.d.tbI));
      paramViewGroup.tur = ((LinearLayout)paramView.findViewById(a.d.tdG));
      paramViewGroup.tug = ((ImageView)paramView.findViewById(a.d.tcw));
      paramViewGroup.tuh = ((TextView)paramView.findViewById(a.d.duY));
      paramViewGroup.tui = ((TextView)paramView.findViewById(a.d.tcV));
      paramViewGroup.tuj = ((TextView)paramView.findViewById(a.d.subtitle));
      paramViewGroup.tul = ((TextView)paramView.findViewById(a.d.tcW));
      paramViewGroup.tus = ((ImageView)paramView.findViewById(a.d.tcO));
      paramViewGroup.tut = ((TextView)paramView.findViewById(a.d.tbJ));
      paramViewGroup.tuu = ((TextView)paramView.findViewById(a.d.tdx));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.cGd()) {
        break label979;
      }
      paramViewGroup.tug.setVisibility(0);
      paramViewGroup.tui.setVisibility(0);
      paramViewGroup.tuj.setVisibility(0);
      paramViewGroup.tul.setVisibility(8);
      paramViewGroup.tuh.setVisibility(0);
      paramViewGroup.tuh.setText(localCardInfo.cGs().jEi);
      if (!localCardInfo.cGa()) {
        break label743;
      }
      if ((localCardInfo.cGs().SfP == null) || (localCardInfo.cGs().SfP.size() != 1)) {
        break label628;
      }
      paramViewGroup.tui.setText(((acg)localCardInfo.cGs().SfP.get(0)).title);
      label317:
      if (localCardInfo.cGs().Sgn != 1) {
        break label763;
      }
      paramViewGroup.tus.setVisibility(0);
      label339:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label775;
      }
      paramViewGroup.tuj.setText(this.mContext.getString(a.g.tmh, new Object[] { l.GN(l) + "  -  " + l.GN(localCardInfo.getEndTime()) }));
      paramViewGroup.tuj.setVisibility(0);
      label436:
      paramInt = this.mContext.getResources().getDimensionPixelSize(a.b.sZN);
      n.a(paramViewGroup.tug, localCardInfo.cGs().llI, paramInt, a.c.my_card_package_defaultlogo, true);
      if (localCardInfo.cGs().Sgl != 1) {
        break label854;
      }
      paramViewGroup.tug.setAlpha(255);
      paramViewGroup.tuu.setVisibility(8);
      paramViewGroup.tui.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.sZt));
      paramViewGroup.tuh.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.sZt));
      paramViewGroup.tuj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      label565:
      paramInt = ((Integer)this.tuq.get(localCardInfo.cGx())).intValue();
      if (paramInt != 1) {
        break label951;
      }
      paramViewGroup.tut.setText("");
      paramViewGroup.tut.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(113148);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label628:
      if ((localCardInfo.cGs().SfP == null) || (localCardInfo.cGs().SfP.size() != 2)) {
        break label317;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((acg)localCardInfo.cGs().SfP.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((acg)localCardInfo.cGs().SfP.get(1)).title);
      paramViewGroup.tui.setText(localStringBuilder.toString());
      break label317;
      label743:
      paramViewGroup.tui.setText(localCardInfo.cGs().title);
      break label317;
      label763:
      paramViewGroup.tus.setVisibility(8);
      break label339;
      label775:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.tuj.setText(this.mContext.getString(a.g.card_validate_to, new Object[] { l.GN(localCardInfo.getEndTime()) }));
        paramViewGroup.tuj.setVisibility(0);
        break label436;
      }
      paramViewGroup.tuj.setText("");
      paramViewGroup.tuj.setVisibility(8);
      break label436;
      label854:
      paramViewGroup.tuu.setText(localCardInfo.cGs().Sgm);
      paramViewGroup.tug.setAlpha(90);
      paramViewGroup.tuu.setVisibility(0);
      paramViewGroup.tui.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      paramViewGroup.tuh.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      paramViewGroup.tuj.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      break label565;
      label951:
      paramViewGroup.tut.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.tut.setVisibility(0);
      continue;
      label979:
      paramViewGroup.tug.setVisibility(8);
      paramViewGroup.tui.setVisibility(8);
      paramViewGroup.tuh.setVisibility(8);
      paramViewGroup.tuj.setVisibility(8);
      paramViewGroup.tuu.setVisibility(8);
      paramViewGroup.tut.setVisibility(8);
      paramViewGroup.tul.setVisibility(0);
      paramViewGroup.tuf.setBackgroundColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.sZx));
      paramViewGroup.tul.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
    }
  }
  
  public final class a
  {
    public RelativeLayout tuf;
    public ImageView tug;
    public TextView tuh;
    public TextView tui;
    public TextView tuj;
    public TextView tul;
    public LinearLayout tur;
    public ImageView tus;
    public TextView tut;
    public TextView tuu;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */