package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.d.a.a.t;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

final class h$2
  implements View.OnClickListener
{
  h$2(h paramh, com.tencent.mm.plugin.card.base.b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (this.ixY.azr())
    {
      paramView = new j.b();
      com.tencent.mm.plugin.card.d.b.a(this.ixZ.ixX.hxN, paramView.ild, paramView.ile, false, this.ixY);
    }
    for (;;)
    {
      t.finish();
      return;
      paramView = this.ixY.azx().sIU;
      if ((paramView != null) && (!bk.bl(paramView.sIg)) && (!bk.bl(paramView.sIf)))
      {
        int i;
        if (this.ixZ.hxN.getIntent() != null)
        {
          i = this.ixZ.hxN.getIntent().getIntExtra("key_from_scene", 3);
          label117:
          if (this.ixZ.hxN.getIntent() == null) {
            break label228;
          }
        }
        label228:
        for (int j = this.ixZ.hxN.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
        {
          com.tencent.mm.plugin.card.d.b.a(this.ixY.azB(), paramView, i, j);
          com.tencent.mm.plugin.report.service.h.nFQ.f(11941, new Object[] { Integer.valueOf(20), this.ixY.azB(), this.ixY.azC(), "", paramView.title });
          break;
          i = 3;
          break label117;
        }
      }
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.url)))
      {
        String str = l.y(paramView.url, paramView.sJq);
        com.tencent.mm.plugin.card.d.b.a(this.ixZ.ixX.hxN, str, 1);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11941, new Object[] { Integer.valueOf(9), this.ixY.azB(), this.ixY.azC(), "", paramView.title });
        if (l.a(paramView, this.ixY.azB()))
        {
          str = this.ixY.azB();
          paramView = paramView.title;
          l.yX(str);
          com.tencent.mm.plugin.card.d.b.a(this.ixZ.ixX.hxN, this.ixY.azx().imA);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h.2
 * JD-Core Version:    0.7.0.1
 */