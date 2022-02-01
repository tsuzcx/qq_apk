package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends BaseAdapter
{
  View.OnClickListener KIr;
  b KIs;
  private List<af> KmK;
  String KmL;
  boolean KmM;
  int KmN;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(65925);
    this.KmK = new LinkedList();
    this.KmN = 1;
    this.KIs = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(65925);
  }
  
  private af aak(int paramInt)
  {
    AppMethodBeat.i(65928);
    af localaf = (af)this.KmK.get(paramInt);
    AppMethodBeat.o(65928);
    return localaf;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(65927);
    int i = this.KmK.size();
    AppMethodBeat.o(65927);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(65929);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(a.g.lucky_money_record_item, paramViewGroup, false);
      paramViewGroup = new c();
      paramViewGroup.qAv = paramView.findViewById(a.f.root);
      paramViewGroup.xaN = ((ImageView)paramView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.yEQ = ((TextView)paramView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.KmP = ((TextView)paramView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.KmQ = ((TextView)paramView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.KmR = ((TextView)paramView.findViewById(a.f.lucky_money_record_answer));
      paramViewGroup.KmS = ((TextView)paramView.findViewById(a.f.lucky_money_record_wish_btn));
      paramViewGroup.KmT = ((ImageView)paramView.findViewById(a.f.lucky_money_record_best_luck_icon));
      paramViewGroup.KmU = ((TextView)paramView.findViewById(a.f.lucky_money_record_game_tips));
      if (this.KIs != null) {
        this.KIs.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    af localaf;
    for (;;)
    {
      localaf = aak(paramInt);
      ah.a(paramViewGroup.xaN, localaf.KtD, localaf.userName);
      if ((!Util.nullAsNil(localaf.KrU).equals(this.KmL)) || (!this.KmM)) {
        break;
      }
      paramViewGroup.KmS.setOnClickListener(this.KIr);
      paramViewGroup.KmS.setVisibility(0);
      paramViewGroup.KmR.setVisibility(8);
      paramViewGroup.KmP.setVisibility(8);
      ah.a(this.mContext, paramViewGroup.yEQ, localaf.KtC);
      String str = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { i.formatMoney2f(localaf.Kth / 100.0D) });
      paramViewGroup.KmQ.setText(str);
      if (!Util.isNullOrNil(localaf.KtF)) {
        break label464;
      }
      paramViewGroup.KmT.setVisibility(8);
      paramViewGroup.KmU.setVisibility(8);
      AppMethodBeat.o(65929);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    if (Util.isNullOrNil(localaf.KtE)) {
      paramViewGroup.KmR.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.KmP.setText(ah.s(this.mContext, Util.getLong(localaf.Kti, 0L) * 1000L));
      paramViewGroup.KmP.setVisibility(0);
      paramViewGroup.KmS.setVisibility(8);
      break;
      ah.a(this.mContext, paramViewGroup.KmR, localaf.KtE);
      paramViewGroup.KmR.setVisibility(0);
    }
    label464:
    paramViewGroup.KmU.setText(localaf.KtF);
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
  
  public final void iQ(List<af> paramList)
  {
    AppMethodBeat.i(65926);
    if (paramList == null) {
      new LinkedList();
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(65926);
      return;
      this.KmK = paramList;
    }
  }
  
  final class a
    implements j.b
  {
    a() {}
    
    public final void a(j.c paramc, Context paramContext)
    {
      AppMethodBeat.i(65924);
      int i = paramContext.getResources().getColor(a.c.lucky_money_goldstyle_busi_detail_primary_text_color);
      int j = paramContext.getResources().getColor(a.c.lucky_money_goldstyle_busi_detail_sub_text_color);
      int k = paramContext.getResources().getColor(a.c.lucky_money_goldstyle_text_red_color);
      paramc.qAv.setBackgroundResource(a.c.transparent);
      paramc.qAv.setPadding(0, paramContext.getResources().getDimensionPixelOffset(a.d.MiddlePadding), 0, paramContext.getResources().getDimensionPixelOffset(a.d.MiddlePadding));
      paramc.yEQ.setTextColor(i);
      paramc.KmP.setTextColor(j);
      paramc.KmQ.setTextColor(i);
      paramc.KmR.setTextColor(i);
      paramc.KmS.setTextColor(k);
      AppMethodBeat.o(65924);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(j.c paramc, Context paramContext);
  }
  
  final class c
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
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */