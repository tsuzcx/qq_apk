package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;

final class ExdeviceRankInfoUI$11
  implements ac.a
{
  ExdeviceRankInfoUI$11(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void Lw(String paramString)
  {
    AppMethodBeat.i(20145);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.lPt.getString(2131299490));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = v.oQ("wx_sport");
    v.aae().z(str, true).i("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(this.lPt, "sns", ".ui.SnsUploadUI", localIntent, 2);
    AppMethodBeat.o(20145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.11
 * JD-Core Version:    0.7.0.1
 */