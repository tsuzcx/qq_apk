package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$a
  implements h.d
{
  h.c ovE;
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, as paramas)
  {
    AppMethodBeat.i(42894);
    if (bo.isNullOrNil(paramas.name))
    {
      ab.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(42894);
      return;
    }
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    x.i(localImageView, paramas.name);
    if (!bo.isNullOrNil(paramas.content)) {
      localImageView.setOnClickListener(new h.a.1(this, paramas, paramContext));
    }
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramViewGroup.addView(localImageView);
    paramViewGroup.setVisibility(0);
    h.qsU.e(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramas.opO) });
    if (this.ovE != null) {
      g.gK(this.ovE.ovK, 0);
    }
    AppMethodBeat.o(42894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h.a
 * JD-Core Version:    0.7.0.1
 */