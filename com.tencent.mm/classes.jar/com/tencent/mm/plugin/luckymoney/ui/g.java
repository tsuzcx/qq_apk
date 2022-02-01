package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

public final class g
  extends f
{
  private Context mContext = null;
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(65660);
    y localy;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(a.g.lucky_money_my_send_record_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.sUt = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_title));
      paramViewGroup.pJi = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_desc));
      paramViewGroup.KmP = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_time));
      paramViewGroup.KmQ = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_amount));
      paramViewGroup.Sc = paramInt;
      paramView.setTag(paramViewGroup);
      localy = aab(paramInt);
      if (Util.isNullOrNil(localy.Ktn)) {
        break label394;
      }
      localObject1 = p.b(this.mContext, localy.Ktj + localy.Ktn, paramViewGroup.sUt.getTextSize());
      localObject2 = p.b(this.mContext, localy.Ktj, paramViewGroup.sUt.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
      localSpannableStringBuilder.setSpan(new s("#FA9D3B", new s.a()
      {
        public final void eS(View paramAnonymousView) {}
      }), ((SpannableString)localObject2).length(), ((SpannableString)localObject1).length(), 18);
      paramViewGroup.sUt.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      paramViewGroup.KmP.setText(localy.Ktk);
      paramViewGroup.KmQ.setText(this.mContext.getString(a.i.lucky_money_amount_with_unit, new Object[] { i.formatMoney2f(localy.KrT / 100.0D) }));
      localObject2 = this.mContext.getString(a.i.lucky_money_send_record_desc, new Object[] { Long.valueOf(localy.KrR), Long.valueOf(localy.Ktl) });
      localObject1 = localObject2;
      if (localy.status == 5) {
        localObject1 = this.mContext.getString(a.i.lucky_money_send_record_status_expired) + " " + (String)localObject2;
      }
      paramViewGroup.pJi.setText((CharSequence)localObject1);
      AppMethodBeat.o(65660);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label394:
      ah.a(this.mContext, paramViewGroup.sUt, localy.Ktj);
    }
  }
  
  final class a
  {
    TextView KmP;
    TextView KmQ;
    int Sc;
    TextView pJi;
    TextView sUt;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g
 * JD-Core Version:    0.7.0.1
 */