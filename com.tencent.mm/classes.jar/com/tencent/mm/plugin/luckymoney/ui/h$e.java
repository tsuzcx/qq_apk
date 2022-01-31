package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.g;
import com.tencent.mm.sdk.platformtools.bo;

final class h$e
  implements h.d
{
  h.c ovE;
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, as paramas)
  {
    AppMethodBeat.i(42899);
    if (bo.isNullOrNil(paramas.name))
    {
      AppMethodBeat.o(42899);
      return;
    }
    Object localObject = LayoutInflater.from(paramContext).inflate(2130970047, paramViewGroup, true);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131825837);
    localObject = (ImageView)((View)localObject).findViewById(2131825836);
    if (!bo.isNullOrNil(paramas.iconUrl))
    {
      x.i((ImageView)localObject, paramas.iconUrl);
      ((ImageView)localObject).setVisibility(0);
      if ((this.ovE != null) && (this.ovE.textColor != -2147483648)) {
        localTextView.setTextColor(this.ovE.textColor);
      }
      if ((this.ovE == null) || (this.ovE.textSize == -2147483648)) {
        break label287;
      }
      localTextView.setTextSize(0, this.ovE.textSize);
    }
    for (;;)
    {
      localTextView.setGravity(17);
      localTextView.setText(paramas.name);
      if (!bo.isNullOrNil(paramas.content)) {
        localTextView.setOnClickListener(new h.e.1(this, paramas, paramContext));
      }
      paramViewGroup.setVisibility(0);
      h.qsU.e(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramas.opO) });
      if (this.ovE != null) {
        g.gK(this.ovE.ovK, 0);
      }
      AppMethodBeat.o(42899);
      return;
      ((ImageView)localObject).setVisibility(8);
      break;
      label287:
      localTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131427758));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h.e
 * JD-Core Version:    0.7.0.1
 */