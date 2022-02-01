package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private List<cih> Eud;
  private String Eue;
  boolean Euf;
  private int Eug;
  private a Euh;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(64906);
    this.Eud = new LinkedList();
    this.Eue = null;
    this.Euf = false;
    this.Eug = 1;
    this.Euh = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(64906);
  }
  
  private cih VL(int paramInt)
  {
    AppMethodBeat.i(64909);
    cih localcih = (cih)this.Eud.get(paramInt);
    AppMethodBeat.o(64909);
    return localcih;
  }
  
  public final void fS(List<cih> paramList)
  {
    AppMethodBeat.i(64907);
    if (paramList == null) {}
    for (this.Eud = new LinkedList();; this.Eud = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(64907);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64908);
    int i = this.Eud.size();
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
      paramViewGroup.nBk = paramView.findViewById(a.f.root);
      paramViewGroup.tXu = ((ImageView)paramView.findViewById(a.f.lucky_money_record_avatar));
      paramViewGroup.vsF = ((TextView)paramView.findViewById(a.f.lucky_money_record_nickname));
      paramViewGroup.Eui = ((TextView)paramView.findViewById(a.f.lucky_money_record_time));
      paramViewGroup.Euj = ((TextView)paramView.findViewById(a.f.lucky_money_record_amount));
      paramViewGroup.Euk = ((TextView)paramView.findViewById(a.f.lucky_money_record_answer));
      paramViewGroup.Eul = ((TextView)paramView.findViewById(a.f.lucky_money_record_wish_btn));
      paramViewGroup.Eum = ((ImageView)paramView.findViewById(a.f.lucky_money_record_best_luck_icon));
      paramViewGroup.Eun = ((TextView)paramView.findViewById(a.f.lucky_money_record_game_tips));
      paramView.setTag(paramViewGroup);
    }
    cih localcih;
    for (;;)
    {
      localcih = VL(paramInt);
      ag.a(paramViewGroup.tXu, localcih.EtG, localcih.username);
      paramViewGroup.Euk.setVisibility(8);
      ag.a(this.mContext, paramViewGroup.vsF, localcih.nickname);
      String str = this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { g.formatMoney2f(localcih.Tpi / 100.0D) });
      paramViewGroup.Euj.setText(str);
      paramViewGroup.Eui.setText(ag.q(this.mContext, localcih.Tpj * 1000L));
      paramViewGroup.Eui.setVisibility(0);
      paramViewGroup.Eul.setVisibility(8);
      if (!Util.isNullOrNil(localcih.Tpl)) {
        break;
      }
      paramViewGroup.Eum.setVisibility(8);
      paramViewGroup.Eun.setVisibility(8);
      AppMethodBeat.o(64910);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.Eun.setText(localcih.Tpl);
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
  
  static abstract interface a {}
  
  final class b
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
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */