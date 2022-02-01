package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

public final class e
  extends f
{
  private Context mContext;
  
  public e(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(65632);
    y localy;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(a.g.lucky_money_my_receive_record_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.yEQ = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_nickname));
      paramViewGroup.KmP = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_time));
      paramViewGroup.KmQ = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_amount));
      paramViewGroup.KDq = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_desc));
      paramViewGroup.Knb = ((ImageView)paramView.findViewById(a.f.lucky_money_my_record_group_icon));
      paramView.setTag(paramViewGroup);
      localy = aab(paramInt);
      if (Util.isNullOrNil(localy.Ktn)) {
        break label366;
      }
      SpannableString localSpannableString1 = p.b(this.mContext, localy.Ktg + localy.Ktn, paramViewGroup.yEQ.getTextSize());
      SpannableString localSpannableString2 = p.b(this.mContext, localy.Ktg, paramViewGroup.yEQ.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString1);
      localSpannableStringBuilder.setSpan(new s("#FA9D3B", new s.a()
      {
        public final void eS(View paramAnonymousView) {}
      }), localSpannableString2.length(), localSpannableString1.length(), 18);
      paramViewGroup.yEQ.setText(localSpannableStringBuilder);
      label241:
      if (Util.isNullOrNil(localy.Kto)) {
        break label385;
      }
      paramViewGroup.KDq.setVisibility(0);
      paramViewGroup.KDq.setText(localy.Kto);
      label272:
      paramViewGroup.KmP.setText(localy.Kti);
      paramViewGroup.KmQ.setText(this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { i.formatMoney2f(localy.Kth / 100.0D) }));
      if (localy.ihy != 1) {
        break label397;
      }
      paramViewGroup.Knb.setImageResource(a.e.lucky_money_group_icon);
      paramViewGroup.Knb.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(65632);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label366:
      ah.a(this.mContext, paramViewGroup.yEQ, localy.Ktg);
      break label241;
      label385:
      paramViewGroup.KDq.setVisibility(8);
      break label272;
      label397:
      if (localy.ihy == 2)
      {
        paramViewGroup.Knb.setImageResource(a.e.lucky_money_f2f_record_icon);
        paramViewGroup.Knb.setVisibility(0);
      }
      else if (localy.ihy == 3)
      {
        paramViewGroup.Knb.setImageResource(a.h.lucky_money_exclusive_hb);
        paramViewGroup.Knb.setVisibility(0);
      }
      else
      {
        paramViewGroup.Knb.setVisibility(8);
      }
    }
  }
  
  final class a
  {
    TextView KDq;
    TextView KmP;
    TextView KmQ;
    ImageView Knb;
    TextView yEQ;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.e
 * JD-Core Version:    0.7.0.1
 */