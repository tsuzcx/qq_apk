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
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

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
      paramView = this.mInflater.inflate(2131495371, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.rMV = ((TextView)paramView.findViewById(2131304173));
      paramViewGroup.yQj = ((TextView)paramView.findViewById(2131304174));
      paramViewGroup.yQk = ((TextView)paramView.findViewById(2131304168));
      paramViewGroup.zeG = ((TextView)paramView.findViewById(2131304169));
      paramViewGroup.yQv = ((ImageView)paramView.findViewById(2131304171));
      paramView.setTag(paramViewGroup);
      localy = PT(paramInt);
      if (Util.isNullOrNil(localy.yWu)) {
        break label358;
      }
      SpannableString localSpannableString1 = l.b(this.mContext, localy.yWn + localy.yWu, paramViewGroup.rMV.getTextSize());
      SpannableString localSpannableString2 = l.b(this.mContext, localy.yWn, paramViewGroup.rMV.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString1);
      localSpannableStringBuilder.setSpan(new q("#FA9D3B", new q.a()
      {
        public final void dF(View paramAnonymousView) {}
      }), localSpannableString2.length(), localSpannableString1.length(), 18);
      paramViewGroup.rMV.setText(localSpannableStringBuilder);
      label235:
      if (Util.isNullOrNil(localy.yWv)) {
        break label377;
      }
      paramViewGroup.zeG.setVisibility(0);
      paramViewGroup.zeG.setText(localy.yWv);
      label266:
      paramViewGroup.yQj.setText(localy.yWp);
      paramViewGroup.yQk.setText(this.mContext.getString(2131762714, new Object[] { com.tencent.mm.wallet_core.ui.f.formatMoney2f(localy.yWo / 100.0D) }));
      if (localy.egY != 1) {
        break label389;
      }
      paramViewGroup.yQv.setImageResource(2131233681);
      paramViewGroup.yQv.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(65632);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label358:
      af.a(this.mContext, paramViewGroup.rMV, localy.yWn);
      break label235;
      label377:
      paramViewGroup.zeG.setVisibility(8);
      break label266;
      label389:
      if (localy.egY == 2)
      {
        paramViewGroup.yQv.setImageResource(2131233670);
        paramViewGroup.yQv.setVisibility(0);
      }
      else if (localy.egY == 3)
      {
        paramViewGroup.yQv.setImageResource(2131691043);
        paramViewGroup.yQv.setVisibility(0);
      }
      else
      {
        paramViewGroup.yQv.setVisibility(8);
      }
    }
  }
  
  final class a
  {
    TextView rMV;
    TextView yQj;
    TextView yQk;
    ImageView yQv;
    TextView zeG;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.e
 * JD-Core Version:    0.7.0.1
 */