package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;

final class ExdeviceRankInfoUI$11
  implements ac.a
{
  ExdeviceRankInfoUI$11(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void Bu(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.jFV.getString(R.l.exdevice_wechat_sport));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = u.ij("wx_sport");
    u.Hc().v(str, true).h("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(this.jFV, "sns", ".ui.SnsUploadUI", localIntent, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.11
 * JD-Core Version:    0.7.0.1
 */