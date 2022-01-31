package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;

final class ExdeviceProfileUI$19
  implements ac.a
{
  ExdeviceProfileUI$19(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void Bu(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.jEM.getString(R.l.exdevice_wechat_sport));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = u.ij("wx_sport");
    u.Hc().v(str, true).h("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(this.jEM, "sns", ".ui.SnsUploadUI", localIntent, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.19
 * JD-Core Version:    0.7.0.1
 */