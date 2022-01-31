package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

final class h$b
  implements h.d
{
  h.c ovE;
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, as paramas)
  {
    AppMethodBeat.i(42897);
    if (bo.isNullOrNil(paramas.name))
    {
      AppMethodBeat.o(42897);
      return;
    }
    TextView localTextView = new TextView(paramContext);
    if ((this.ovE != null) && (this.ovE.textColor != -2147483648))
    {
      localTextView.setTextColor(this.ovE.textColor);
      if ((this.ovE == null) || (this.ovE.textSize == -2147483648)) {
        break label241;
      }
      localTextView.setTextSize(0, this.ovE.textSize);
    }
    for (;;)
    {
      localTextView.setGravity(17);
      localTextView.setText(paramas.name);
      if (!bo.isNullOrNil(paramas.content)) {
        localTextView.setOnClickListener(new h.b.1(this, paramas, paramContext));
      }
      paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
      paramViewGroup.setVisibility(0);
      h.qsU.e(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramas.opO) });
      AppMethodBeat.o(42897);
      return;
      localTextView.setTextColor(paramContext.getResources().getColor(2131690648));
      break;
      label241:
      localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131427758));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h.b
 * JD-Core Version:    0.7.0.1
 */