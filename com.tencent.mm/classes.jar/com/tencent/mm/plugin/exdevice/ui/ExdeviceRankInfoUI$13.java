package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;

final class ExdeviceRankInfoUI$13
  implements ac.a
{
  ExdeviceRankInfoUI$13(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void anx(String paramString)
  {
    AppMethodBeat.i(24223);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.rKI.getString(2131758927));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = ad.JX("wx_sport");
    ad.aVe().G(str, true).l("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    c.b(this.rKI, "sns", ".ui.SnsUploadUI", localIntent, 2);
    AppMethodBeat.o(24223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.13
 * JD-Core Version:    0.7.0.1
 */