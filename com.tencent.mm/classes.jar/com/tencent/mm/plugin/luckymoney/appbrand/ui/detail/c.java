package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private List<cyk> KmK;
  private String KmL;
  boolean KmM;
  private int KmN;
  private a KmO;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(64906);
    this.KmK = new LinkedList();
    this.KmL = null;
    this.KmM = false;
    this.KmN = 1;
    this.KmO = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(64906);
  }
  
  private cyk ZH(int paramInt)
  {
    AppMethodBeat.i(64909);
    cyk localcyk = (cyk)this.KmK.get(paramInt);
    AppMethodBeat.o(64909);
    return localcyk;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64908);
    int i = this.KmK.size();
    AppMethodBeat.o(64908);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64910);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(a.g.lucky_money_record_item, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.qAv = paramView.findViewById(a.f.root);
      paramViewGroup.xaN = ((ImageView)paramView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.yEQ = ((TextView)paramView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.KmP = ((TextView)paramView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.KmQ = ((TextView)paramView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.KmR = ((TextView)paramView.findViewById(a.f.lucky_money_record_answer));
      paramViewGroup.KmS = ((TextView)paramView.findViewById(a.f.lucky_money_record_wish_btn));
      paramViewGroup.KmT = ((ImageView)paramView.findViewById(a.f.lucky_money_record_best_luck_icon));
      paramViewGroup.KmU = ((TextView)paramView.findViewById(a.f.lucky_money_record_game_tips));
      paramView.setTag(paramViewGroup);
    }
    cyk localcyk;
    for (;;)
    {
      localcyk = ZH(paramInt);
      ah.a(paramViewGroup.xaN, localcyk.Kmn, localcyk.username);
      paramViewGroup.KmR.setVisibility(8);
      ah.a(this.mContext, paramViewGroup.yEQ, localcyk.nickname);
      String str = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { i.formatMoney2f(localcyk.aaDk / 100.0D) });
      paramViewGroup.KmQ.setText(str);
      paramViewGroup.KmP.setText(ah.s(this.mContext, localcyk.aaDl * 1000L));
      paramViewGroup.KmP.setVisibility(0);
      paramViewGroup.KmS.setVisibility(8);
      if (!Util.isNullOrNil(localcyk.aaDn)) {
        break;
      }
      paramViewGroup.KmT.setVisibility(8);
      paramViewGroup.KmU.setVisibility(8);
      AppMethodBeat.o(64910);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.KmU.setText(localcyk.aaDn);
    if (this.KmN == 2) {
      paramViewGroup.KmT.setImageResource(a.e.lucky_money_first_share_icon);
    }
    for (;;)
    {
      paramViewGroup.KmT.setVisibility(0);
      paramViewGroup.KmU.setVisibility(0);
      break;
      paramViewGroup.KmT.setImageResource(a.e.lucky_money_best_luck_icon);
    }
  }
  
  public final void iQ(List<cyk> paramList)
  {
    AppMethodBeat.i(64907);
    if (paramList == null) {}
    for (this.KmK = new LinkedList();; this.KmK = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(64907);
      return;
    }
  }
  
  static abstract interface a {}
  
  final class b
  {
    TextView KmP;
    TextView KmQ;
    TextView KmR;
    TextView KmS;
    ImageView KmT;
    TextView KmU;
    View qAv;
    ImageView xaN;
    TextView yEQ;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */