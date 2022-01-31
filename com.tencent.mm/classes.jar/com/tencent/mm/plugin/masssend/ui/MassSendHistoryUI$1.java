package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.a.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class MassSendHistoryUI$1
  implements c.e
{
  MassSendHistoryUI$1(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final String SH(String paramString)
  {
    AppMethodBeat.i(22794);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.ii(this.oCd);
      AppMethodBeat.o(22794);
      return "";
    }
    paramString = bo.nullAsNil(paramString);
    if ((MassSendHistoryUI.a(this.oCd).isPlaying()) && (paramString.equals(MassSendHistoryUI.b(this.oCd).oBL)))
    {
      MassSendHistoryUI.bPm();
      this.oCd.releaseWakeLock();
      MassSendHistoryUI.a(this.oCd).stop(false);
      AppMethodBeat.o(22794);
      return "";
    }
    if (MassSendHistoryUI.a(this.oCd, paramString))
    {
      AppMethodBeat.o(22794);
      return paramString;
    }
    AppMethodBeat.o(22794);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.1
 * JD-Core Version:    0.7.0.1
 */