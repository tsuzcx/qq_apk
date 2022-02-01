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
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

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
    z localz;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(a.g.lucky_money_my_receive_record_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.vsF = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_nickname));
      paramViewGroup.Eui = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_time));
      paramViewGroup.Euj = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_amount));
      paramViewGroup.EJJ = ((TextView)paramView.findViewById(a.f.lucky_money_my_record_desc));
      paramViewGroup.Euu = ((ImageView)paramView.findViewById(a.f.lucky_money_my_record_group_icon));
      paramView.setTag(paramViewGroup);
      localz = Wf(paramInt);
      if (Util.isNullOrNil(localz.EAx)) {
        break label366;
      }
      SpannableString localSpannableString1 = l.b(this.mContext, localz.EAq + localz.EAx, paramViewGroup.vsF.getTextSize());
      SpannableString localSpannableString2 = l.b(this.mContext, localz.EAq, paramViewGroup.vsF.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString1);
      localSpannableStringBuilder.setSpan(new r("#FA9D3B", new r.a()
      {
        public final void ed(View paramAnonymousView) {}
      }), localSpannableString2.length(), localSpannableString1.length(), 18);
      paramViewGroup.vsF.setText(localSpannableStringBuilder);
      label241:
      if (Util.isNullOrNil(localz.EAy)) {
        break label385;
      }
      paramViewGroup.EJJ.setVisibility(0);
      paramViewGroup.EJJ.setText(localz.EAy);
      label272:
      paramViewGroup.Eui.setText(localz.EAs);
      paramViewGroup.Euj.setText(this.mContext.getString(a.i.lucky_money_receive_amount, new Object[] { g.formatMoney2f(localz.EAr / 100.0D) }));
      if (localz.gbo != 1) {
        break label397;
      }
      paramViewGroup.Euu.setImageResource(a.e.lucky_money_group_icon);
      paramViewGroup.Euu.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(65632);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label366:
      ag.a(this.mContext, paramViewGroup.vsF, localz.EAq);
      break label241;
      label385:
      paramViewGroup.EJJ.setVisibility(8);
      break label272;
      label397:
      if (localz.gbo == 2)
      {
        paramViewGroup.Euu.setImageResource(a.e.lucky_money_f2f_record_icon);
        paramViewGroup.Euu.setVisibility(0);
      }
      else if (localz.gbo == 3)
      {
        paramViewGroup.Euu.setImageResource(a.h.lucky_money_exclusive_hb);
        paramViewGroup.Euu.setVisibility(0);
      }
      else
      {
        paramViewGroup.Euu.setVisibility(8);
      }
    }
  }
  
  final class a
  {
    TextView EJJ;
    TextView Eui;
    TextView Euj;
    ImageView Euu;
    TextView vsF;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.e
 * JD-Core Version:    0.7.0.1
 */