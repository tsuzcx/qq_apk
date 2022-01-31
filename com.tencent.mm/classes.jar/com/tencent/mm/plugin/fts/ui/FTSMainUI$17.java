package com.tencent.mm.plugin.fts.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.c.a;
import com.tencent.mm.plugin.fts.ui.widget.d;

final class FTSMainUI$17
  implements c.a
{
  FTSMainUI$17(FTSMainUI paramFTSMainUI) {}
  
  public final void Px(String paramString)
  {
    AppMethodBeat.i(61888);
    this.mYi.mWR.setSearchContent(paramString);
    AppMethodBeat.o(61888);
  }
  
  public final void Py(String paramString)
  {
    AppMethodBeat.i(61890);
    FTSMainUI.d(this.mYi).mXp.nax = paramString;
    this.mYi.mWR.setSearchContent(paramString);
    FTSMainUI.a(this.mYi, paramString);
    AppMethodBeat.o(61890);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(61889);
    this.mYi.mWR.setSearchContent(paramString);
    FTSMainUI.a(this.mYi, paramString);
    if (!paramBoolean1)
    {
      if (paramBoolean2)
      {
        FTSMainUI.Pw(this.mYi.getString(2131300242));
        AppMethodBeat.o(61889);
        return;
      }
      FTSMainUI.Pw(this.mYi.getString(2131300243));
    }
    AppMethodBeat.o(61889);
  }
  
  public final void bCV()
  {
    AppMethodBeat.i(61887);
    this.mYi.mWR.setCursorVisible(false);
    FTSMainUI.d(this.mYi).wy(1);
    FTSMainUI.e(this.mYi);
    this.mYi.mWR.setHint(this.mYi.getContext().getString(2131300240));
    AppMethodBeat.o(61887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.17
 * JD-Core Version:    0.7.0.1
 */