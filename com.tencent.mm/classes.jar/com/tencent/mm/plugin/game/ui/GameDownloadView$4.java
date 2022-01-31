package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.bo;

final class GameDownloadView$4
  implements j.a
{
  GameDownloadView$4(GameDownloadView paramGameDownloadView) {}
  
  public final void f(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111895);
    if ((!paramBoolean) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(111895);
      return;
    }
    if ((GameDownloadView.b(this.nyF) == null) || (GameDownloadView.b(this.nyF).nmJ == null) || (!GameDownloadView.b(this.nyF).nmJ.field_appId.equals(paramString)))
    {
      AppMethodBeat.o(111895);
      return;
    }
    this.nyF.refresh();
    AppMethodBeat.o(111895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView.4
 * JD-Core Version:    0.7.0.1
 */