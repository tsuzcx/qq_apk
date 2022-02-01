package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.exdevice.model.ag.a;

final class ExdeviceRankInfoUI$11
  implements ag.a
{
  ExdeviceRankInfoUI$11(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void apw(String paramString)
  {
    AppMethodBeat.i(24217);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.yCI.getString(R.l.exdevice_wechat_sport));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = ad.Jo("wx_sport");
    ad.bCb().M(str, true).q("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    c.b(this.yCI, "sns", ".ui.SnsUploadUI", localIntent, 2);
    AppMethodBeat.o(24217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.11
 * JD-Core Version:    0.7.0.1
 */