package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;

final class ExdeviceProfileUI$20
  implements ac.a
{
  ExdeviceProfileUI$20(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void UF(String paramString)
  {
    AppMethodBeat.i(24116);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.peX.getString(2131758621));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = y.tD("wx_sport");
    y.arz().E(str, true).m("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(this.peX, "sns", ".ui.SnsUploadUI", localIntent, 2);
    AppMethodBeat.o(24116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.20
 * JD-Core Version:    0.7.0.1
 */