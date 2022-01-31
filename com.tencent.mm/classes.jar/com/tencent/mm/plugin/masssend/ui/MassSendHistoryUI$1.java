package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.f.a.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.s;

final class MassSendHistoryUI$1
  implements c.e
{
  MassSendHistoryUI$1(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final String GW(String paramString)
  {
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      s.gM(this.mbC);
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = bk.pm(paramString);
      if ((MassSendHistoryUI.a(this.mbC).isPlaying()) && (str.equals(MassSendHistoryUI.b(this.mbC).mbj)))
      {
        MassSendHistoryUI.bhl();
        this.mbC.releaseWakeLock();
        MassSendHistoryUI.a(this.mbC).stop(false);
        return "";
      }
      paramString = str;
    } while (MassSendHistoryUI.a(this.mbC, str));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.1
 * JD-Core Version:    0.7.0.1
 */