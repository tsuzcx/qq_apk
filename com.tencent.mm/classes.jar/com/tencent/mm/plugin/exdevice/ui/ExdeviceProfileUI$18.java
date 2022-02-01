package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.by.c;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.exdevice.model.ad.a;

final class ExdeviceProfileUI$18
  implements ad.a
{
  ExdeviceProfileUI$18(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void avw(String paramString)
  {
    AppMethodBeat.i(24115);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.vpc.getString(R.l.exdevice_wechat_sport));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = ad.Rp("wx_sport");
    ad.beh().I(str, true).k("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    c.b(this.vpc, "sns", ".ui.SnsUploadUI", localIntent, 2);
    AppMethodBeat.o(24115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.18
 * JD-Core Version:    0.7.0.1
 */