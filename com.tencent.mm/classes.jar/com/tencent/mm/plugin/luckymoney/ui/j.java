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
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends BaseAdapter
{
  View.OnClickListener ENS;
  b ENT;
  private List<ae> Eud;
  String Eue;
  boolean Euf;
  int Eug;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(65925);
    this.Eud = new LinkedList();
    this.Eug = 1;
    this.ENT = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(65925);
  }
  
  private ae Wo(int paramInt)
  {
    AppMethodBeat.i(65928);
    ae localae = (ae)this.Eud.get(paramInt);
    AppMethodBeat.o(65928);
    return localae;
  }
  
  public final void fS(List<ae> paramList)
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
      this.Eud = paramList;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(65927);
    int i = this.Eud.size();
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
      paramViewGroup.nBk = paramView.findViewById(a.f.root);
      paramViewGroup.tXu = ((ImageView)paramView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.vsF = ((TextView)paramView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.Eui = ((TextView)paramView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.Euj = ((TextView)paramView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.Euk = ((TextView)paramView.findViewById(a.f.lucky_money_record_answer));
      paramViewGroup.Eul = ((TextView)paramView.findViewById(a.f.lucky_money_record_wish_btn));
      paramViewGroup.Eum = ((ImageView)paramView.findViewById(a.f.lucky_money_record_best_luck_icon));
      paramViewGroup.Eun = ((TextView)paramView.findViewById(a.f.lucky_money_record_game_tips));
      if (this.ENT != null) {
        this.ENT.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    ae localae;
    for (;;)
    {
      localae = Wo(paramInt);
      ag.a(paramViewGroup.tXu, localae.EAH, localae.userName);
      if ((!Util.nullAsNil(localae.Ezh).equals(this.Eue)) || (!this.Euf)) {
        break;
      }
      paramViewGroup.Eul.setOnClickListener(this.ENS);
      paramViewGroup.Eul.setVisibility(0);
      paramViewGroup.Euk.setVisibility(8);
      paramViewGroup.Eui.setVisibility(8);
      ag.a(this.mContext, paramViewGroup.vsF, localae.EAG);
      String str = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { g.formatMoney2f(localae.EAr / 100.0D) });
      paramViewGroup.Euj.setText(str);
      if (!Util.isNullOrNil(localae.EAJ)) {
        break label464;
      }
      paramViewGroup.Eum.setVisibility(8);
      paramViewGroup.Eun.setVisibility(8);
      AppMethodBeat.o(65929);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    if (Util.isNullOrNil(localae.EAI)) {
      paramViewGroup.Euk.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.Eui.setText(ag.q(this.mContext, Util.getLong(localae.EAs, 0L) * 1000L));
      paramViewGroup.Eui.setVisibility(0);
      paramViewGroup.Eul.setVisibility(8);
      break;
      ag.a(this.mContext, paramViewGroup.Euk, localae.EAI);
      paramViewGroup.Euk.setVisibility(0);
    }
    label464:
    paramViewGroup.Eun.setText(localae.EAJ);
    if (this.Eug == 2) {
      paramViewGroup.Eum.setImageResource(a.e.lucky_money_first_share_icon);
    }
    for (;;)
    {
      paramViewGroup.Eum.setVisibility(0);
      paramViewGroup.Eun.setVisibility(0);
      break;
      paramViewGroup.Eum.setImageResource(a.e.lucky_money_best_luck_icon);
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
      paramc.nBk.setBackgroundResource(a.c.transparent);
      paramc.nBk.setPadding(0, paramContext.getResources().getDimensionPixelOffset(a.d.MiddlePadding), 0, paramContext.getResources().getDimensionPixelOffset(a.d.MiddlePadding));
      paramc.vsF.setTextColor(i);
      paramc.Eui.setTextColor(j);
      paramc.Euj.setTextColor(i);
      paramc.Euk.setTextColor(i);
      paramc.Eul.setTextColor(k);
      AppMethodBeat.o(65924);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(j.c paramc, Context paramContext);
  }
  
  final class c
  {
    TextView Eui;
    TextView Euj;
    TextView Euk;
    TextView Eul;
    ImageView Eum;
    TextView Eun;
    View nBk;
    ImageView tXu;
    TextView vsF;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */