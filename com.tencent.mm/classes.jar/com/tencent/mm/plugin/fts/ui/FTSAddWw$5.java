package com.tencent.mm.plugin.fts.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.n;

final class FTSAddWw$5
  implements f
{
  FTSAddWw$5(FTSAddWw paramFTSAddWw) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(61757);
    g.Rc().b(372, this);
    FTSAddWw.d(this.mWE);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddWw.e(this.mWE).setText(2131301859);
        label68:
        FTSAddWw.a(this.mWE, -1);
        FTSAddWw.f(this.mWE);
        paramString = new w();
        paramString.fr(FTSAddWw.a(this.mWE));
        paramString.cTG = 0L;
        paramString.cTH = 2L;
        paramString.ake();
      }
    }
    for (;;)
    {
      FTSAddWw.g(this.mWE);
      AppMethodBeat.o(61757);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddWw.e(this.mWE).setText(this.mWE.getString(2131302978));
      break label68;
      paramString = a.kO(paramString);
      if (paramString != null)
      {
        FTSAddWw.e(this.mWE).setText(paramString.desc);
        break label68;
      }
      FTSAddWw.e(this.mWE).setText(2131301859);
      break label68;
      FTSAddWw.a(this.mWE, ((n)paramm).gfS);
      FTSAddWw.a(this.mWE, 1);
      paramString = new w();
      paramString.fr(FTSAddWw.a(this.mWE));
      paramString.cTG = 0L;
      paramString.cTH = 1L;
      paramString.ake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.5
 * JD-Core Version:    0.7.0.1
 */