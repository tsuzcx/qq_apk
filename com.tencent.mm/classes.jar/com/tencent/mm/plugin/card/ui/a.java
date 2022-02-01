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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.ws;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  Context mContext;
  List<CardInfo> wyM;
  HashMap<String, Integer> wyN;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(113145);
    this.wyM = new ArrayList();
    this.wyN = new HashMap();
    this.mContext = paramContext;
    AppMethodBeat.o(113145);
  }
  
  public final CardInfo Ir(int paramInt)
  {
    AppMethodBeat.i(113147);
    CardInfo localCardInfo = (CardInfo)this.wyM.get(paramInt);
    AppMethodBeat.o(113147);
    return localCardInfo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113146);
    int i = this.wyM.size();
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
    CardInfo localCardInfo = Ir(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.e.wmh, null);
      paramViewGroup = new a();
      paramViewGroup.wyC = ((RelativeLayout)paramView.findViewById(a.d.wfV));
      paramViewGroup.wyO = ((LinearLayout)paramView.findViewById(a.d.whU));
      paramViewGroup.wyD = ((ImageView)paramView.findViewById(a.d.wgJ));
      paramViewGroup.wyE = ((TextView)paramView.findViewById(a.d.fvq));
      paramViewGroup.wyF = ((TextView)paramView.findViewById(a.d.whj));
      paramViewGroup.wyG = ((TextView)paramView.findViewById(a.d.subtitle));
      paramViewGroup.wyI = ((TextView)paramView.findViewById(a.d.whk));
      paramViewGroup.wyP = ((ImageView)paramView.findViewById(a.d.whc));
      paramViewGroup.wyQ = ((TextView)paramView.findViewById(a.d.wfW));
      paramViewGroup.wyR = ((TextView)paramView.findViewById(a.d.whL));
      paramView.setTag(paramViewGroup);
      if (!localCardInfo.djv()) {
        break label979;
      }
      paramViewGroup.wyD.setVisibility(0);
      paramViewGroup.wyF.setVisibility(0);
      paramViewGroup.wyG.setVisibility(0);
      paramViewGroup.wyI.setVisibility(8);
      paramViewGroup.wyE.setVisibility(0);
      paramViewGroup.wyE.setText(localCardInfo.djK().mee);
      if (!localCardInfo.djs()) {
        break label743;
      }
      if ((localCardInfo.djK().ZdK == null) || (localCardInfo.djK().ZdK.size() != 1)) {
        break label628;
      }
      paramViewGroup.wyF.setText(((aek)localCardInfo.djK().ZdK.get(0)).title);
      label317:
      if (localCardInfo.djK().Zei != 1) {
        break label763;
      }
      paramViewGroup.wyP.setVisibility(0);
      label339:
      long l = ((CardInfo)localCardInfo).field_begin_time;
      if ((localCardInfo.getEndTime() <= 0L) || (l <= 0L)) {
        break label775;
      }
      paramViewGroup.wyG.setText(this.mContext.getString(a.g.wqG, new Object[] { l.iY(l) + "  -  " + l.iY(localCardInfo.getEndTime()) }));
      paramViewGroup.wyG.setVisibility(0);
      label436:
      paramInt = this.mContext.getResources().getDimensionPixelSize(a.b.wdU);
      n.a(paramViewGroup.wyD, localCardInfo.djK().nQG, paramInt, a.c.my_card_package_defaultlogo, true);
      if (localCardInfo.djK().Zeg != 1) {
        break label854;
      }
      paramViewGroup.wyD.setAlpha(255);
      paramViewGroup.wyR.setVisibility(8);
      paramViewGroup.wyF.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.wdC));
      paramViewGroup.wyE.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.wdC));
      paramViewGroup.wyG.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      label565:
      paramInt = ((Integer)this.wyN.get(localCardInfo.djP())).intValue();
      if (paramInt != 1) {
        break label951;
      }
      paramViewGroup.wyQ.setText("");
      paramViewGroup.wyQ.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(113148);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label628:
      if ((localCardInfo.djK().ZdK == null) || (localCardInfo.djK().ZdK.size() != 2)) {
        break label317;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((aek)localCardInfo.djK().ZdK.get(0)).title);
      localStringBuilder.append("-");
      localStringBuilder.append(((aek)localCardInfo.djK().ZdK.get(1)).title);
      paramViewGroup.wyF.setText(localStringBuilder.toString());
      break label317;
      label743:
      paramViewGroup.wyF.setText(localCardInfo.djK().title);
      break label317;
      label763:
      paramViewGroup.wyP.setVisibility(8);
      break label339;
      label775:
      if (localCardInfo.getEndTime() > 0L)
      {
        paramViewGroup.wyG.setText(this.mContext.getString(a.g.card_validate_to, new Object[] { l.iY(localCardInfo.getEndTime()) }));
        paramViewGroup.wyG.setVisibility(0);
        break label436;
      }
      paramViewGroup.wyG.setText("");
      paramViewGroup.wyG.setVisibility(8);
      break label436;
      label854:
      paramViewGroup.wyR.setText(localCardInfo.djK().Zeh);
      paramViewGroup.wyD.setAlpha(90);
      paramViewGroup.wyR.setVisibility(0);
      paramViewGroup.wyF.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      paramViewGroup.wyE.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      paramViewGroup.wyG.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.grey_background_text_color));
      break label565;
      label951:
      paramViewGroup.wyQ.setText("x".concat(String.valueOf(paramInt)));
      paramViewGroup.wyQ.setVisibility(0);
      continue;
      label979:
      paramViewGroup.wyD.setVisibility(8);
      paramViewGroup.wyF.setVisibility(8);
      paramViewGroup.wyE.setVisibility(8);
      paramViewGroup.wyG.setVisibility(8);
      paramViewGroup.wyR.setVisibility(8);
      paramViewGroup.wyQ.setVisibility(8);
      paramViewGroup.wyI.setVisibility(0);
      paramViewGroup.wyC.setBackgroundColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.wdG));
      paramViewGroup.wyI.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
    }
  }
  
  public final class a
  {
    public RelativeLayout wyC;
    public ImageView wyD;
    public TextView wyE;
    public TextView wyF;
    public TextView wyG;
    public TextView wyI;
    public LinearLayout wyO;
    public ImageView wyP;
    public TextView wyQ;
    public TextView wyR;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a
 * JD-Core Version:    0.7.0.1
 */