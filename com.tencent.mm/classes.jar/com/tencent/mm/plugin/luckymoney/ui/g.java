package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

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
    z localz;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(a.g.lucky_money_my_send_record_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.pPT = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_title));
      paramViewGroup.mMA = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_desc));
      paramViewGroup.Eui = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_time));
      paramViewGroup.Euj = ((TextView)paramView.findViewById(a.f.lucky_money_my_send_record_amount));
      paramViewGroup.zP = paramInt;
      paramView.setTag(paramViewGroup);
      localz = Wf(paramInt);
      if (Util.isNullOrNil(localz.EAx)) {
        break label394;
      }
      localObject1 = l.b(this.mContext, localz.EAt + localz.EAx, paramViewGroup.pPT.getTextSize());
      localObject2 = l.b(this.mContext, localz.EAt, paramViewGroup.pPT.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
      localSpannableStringBuilder.setSpan(new r("#FA9D3B", new r.a()
      {
        public final void ed(View paramAnonymousView) {}
      }), ((SpannableString)localObject2).length(), ((SpannableString)localObject1).length(), 18);
      paramViewGroup.pPT.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      paramViewGroup.Eui.setText(localz.EAu);
      paramViewGroup.Euj.setText(this.mContext.getString(a.i.lucky_money_amount_with_unit, new Object[] { com.tencent.mm.wallet_core.ui.g.formatMoney2f(localz.Ezg / 100.0D) }));
      localObject2 = this.mContext.getString(a.i.lucky_money_send_record_desc, new Object[] { Long.valueOf(localz.Eze), Long.valueOf(localz.EAv) });
      localObject1 = localObject2;
      if (localz.status == 5) {
        localObject1 = this.mContext.getString(a.i.lucky_money_send_record_status_expired) + " " + (String)localObject2;
      }
      paramViewGroup.mMA.setText((CharSequence)localObject1);
      AppMethodBeat.o(65660);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label394:
      ag.a(this.mContext, paramViewGroup.pPT, localz.EAt);
    }
  }
  
  final class a
  {
    TextView Eui;
    TextView Euj;
    TextView mMA;
    TextView pPT;
    int zP;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g
 * JD-Core Version:    0.7.0.1
 */