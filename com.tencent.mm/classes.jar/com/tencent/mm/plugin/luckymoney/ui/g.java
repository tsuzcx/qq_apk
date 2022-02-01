package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
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
    y localy;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131495373, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.mPa = ((TextView)paramView.findViewById(2131304178));
      paramViewGroup.jVn = ((TextView)paramView.findViewById(2131304176));
      paramViewGroup.yQj = ((TextView)paramView.findViewById(2131304177));
      paramViewGroup.yQk = ((TextView)paramView.findViewById(2131304175));
      paramViewGroup.fs = paramInt;
      paramView.setTag(paramViewGroup);
      localy = PT(paramInt);
      if (Util.isNullOrNil(localy.yWu)) {
        break label386;
      }
      localObject1 = l.b(this.mContext, localy.yWq + localy.yWu, paramViewGroup.mPa.getTextSize());
      localObject2 = l.b(this.mContext, localy.yWq, paramViewGroup.mPa.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
      localSpannableStringBuilder.setSpan(new q("#FA9D3B", new q.a()
      {
        public final void dF(View paramAnonymousView) {}
      }), ((SpannableString)localObject2).length(), ((SpannableString)localObject1).length(), 18);
      paramViewGroup.mPa.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      paramViewGroup.yQj.setText(localy.yWr);
      paramViewGroup.yQk.setText(this.mContext.getString(2131762585, new Object[] { com.tencent.mm.wallet_core.ui.f.formatMoney2f(localy.yVj / 100.0D) }));
      localObject2 = this.mContext.getString(2131762735, new Object[] { Long.valueOf(localy.yVh), Long.valueOf(localy.yWs) });
      localObject1 = localObject2;
      if (localy.status == 5) {
        localObject1 = this.mContext.getString(2131762736) + " " + (String)localObject2;
      }
      paramViewGroup.jVn.setText((CharSequence)localObject1);
      AppMethodBeat.o(65660);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label386:
      af.a(this.mContext, paramViewGroup.mPa, localy.yWq);
    }
  }
  
  final class a
  {
    int fs;
    TextView jVn;
    TextView mPa;
    TextView yQj;
    TextView yQk;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g
 * JD-Core Version:    0.7.0.1
 */