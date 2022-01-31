package com.tencent.mm.plugin.card.base;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

final class CardBaseUI$6
  implements q.a
{
  CardBaseUI$6(CardBaseUI paramCardBaseUI, String paramString, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(87622);
    if (paramBoolean)
    {
      CardBaseUI.c(this.kkO, this.efI);
      h.bO(this.kkO, this.kkO.getResources().getString(2131297941));
      if (this.kkR) {
        this.kkO.finish();
      }
    }
    AppMethodBeat.o(87622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.6
 * JD-Core Version:    0.7.0.1
 */