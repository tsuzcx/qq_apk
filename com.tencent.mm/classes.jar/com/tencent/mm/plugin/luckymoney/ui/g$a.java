package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$a
  implements g.d
{
  g.c lWQ;
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, ai paramai)
  {
    if (bk.bl(paramai.name))
    {
      y.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
      paramViewGroup.setVisibility(8);
    }
    do
    {
      return;
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      o.g(localImageView, paramai.name);
      if (!bk.bl(paramai.content)) {
        localImageView.setOnClickListener(new g.a.1(this, paramai, paramContext));
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup.addView(localImageView);
      paramViewGroup.setVisibility(0);
      h.nFQ.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramai.lRN) });
    } while (this.lWQ == null);
    f.eZ(this.lWQ.lWW, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g.a
 * JD-Core Version:    0.7.0.1
 */