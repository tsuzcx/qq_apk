package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    a.a(this.hOO, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().hOi);
    if ((2 == a.b(this.hOO)) || (3 == a.b(this.hOO)) || (5 == a.b(this.hOO)) || (6 == a.b(this.hOO)))
    {
      y.d(a.BG(), "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().hOi), Integer.valueOf(a.c(this.hOO)) });
      a.d(this.hOO);
    }
    while (4 != a.b(this.hOO)) {
      return;
    }
    y.d(a.BG(), "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().hOi), Integer.valueOf(a.c(this.hOO)) });
    a.e(this.hOO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a.2
 * JD-Core Version:    0.7.0.1
 */