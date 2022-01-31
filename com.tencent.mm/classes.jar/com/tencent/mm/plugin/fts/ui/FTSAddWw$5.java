package com.tencent.mm.plugin.fts.ui;

import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;

final class FTSAddWw$5
  implements f
{
  FTSAddWw$5(FTSAddWw paramFTSAddWw) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.Dk().b(372, this);
    FTSAddWw.d(this.kAM);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddWw.e(this.kAM).setText(n.g.no_contact_result);
        label65:
        FTSAddWw.a(this.kAM, -1);
        FTSAddWw.f(this.kAM);
        paramString = new com.tencent.mm.h.b.a.n();
        paramString.ciW = FTSAddWw.a(this.kAM);
        paramString.ciX = 0L;
        paramString.ciY = 2L;
        paramString.QX();
      }
    }
    for (;;)
    {
      FTSAddWw.g(this.kAM);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddWw.e(this.kAM).setText(this.kAM.getString(n.g.search_contact_err_no_code));
      break label65;
      paramString = a.eI(paramString);
      if (paramString != null)
      {
        FTSAddWw.e(this.kAM).setText(paramString.desc);
        break label65;
      }
      FTSAddWw.e(this.kAM).setText(n.g.no_contact_result);
      break label65;
      FTSAddWw.a(this.kAM, ((com.tencent.mm.openim.b.n)paramm).ePX);
      FTSAddWw.a(this.kAM, 1);
      paramString = new com.tencent.mm.h.b.a.n();
      paramString.ciW = FTSAddWw.a(this.kAM);
      paramString.ciX = 0L;
      paramString.ciY = 1L;
      paramString.QX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.5
 * JD-Core Version:    0.7.0.1
 */