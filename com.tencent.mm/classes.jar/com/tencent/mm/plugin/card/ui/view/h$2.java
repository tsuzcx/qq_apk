package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.b.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class h$2
  implements View.OnClickListener
{
  h$2(h paramh, com.tencent.mm.plugin.card.base.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88746);
    if (this.kBf.baX())
    {
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this.kBg.kBe.jpX, paramView.kmb, paramView.kmc, false, this.kBf);
    }
    for (;;)
    {
      t.finish();
      AppMethodBeat.o(88746);
      return;
      paramView = this.kBf.bbd().wGD;
      if ((paramView != null) && (!bo.isNullOrNil(paramView.wFM)) && (!bo.isNullOrNil(paramView.wFL)))
      {
        int i;
        if (this.kBg.jpX.getIntent() != null)
        {
          i = this.kBg.jpX.getIntent().getIntExtra("key_from_scene", 3);
          label127:
          if (this.kBg.jpX.getIntent() == null) {
            break label238;
          }
        }
        label238:
        for (int j = this.kBg.jpX.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
        {
          com.tencent.mm.plugin.card.d.b.a(this.kBf.bbh(), paramView, i, j);
          com.tencent.mm.plugin.report.service.h.qsU.e(11941, new Object[] { Integer.valueOf(20), this.kBf.bbh(), this.kBf.bbi(), "", paramView.title });
          break;
          i = 3;
          break label127;
        }
      }
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        String str = l.H(paramView.url, paramView.wGZ);
        com.tencent.mm.plugin.card.d.b.a(this.kBg.kBe.jpX, str, 1);
        com.tencent.mm.plugin.report.service.h.qsU.e(11941, new Object[] { Integer.valueOf(9), this.kBf.bbh(), this.kBf.bbi(), "", paramView.title });
        if (l.a(paramView, this.kBf.bbh()))
        {
          l.IG(this.kBf.bbh());
          com.tencent.mm.plugin.card.d.b.b(this.kBg.kBe.jpX, this.kBf.bbd().knw);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h.2
 * JD-Core Version:    0.7.0.1
 */