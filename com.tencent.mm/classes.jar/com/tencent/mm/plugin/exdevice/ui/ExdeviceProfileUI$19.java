package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.exdevice.model.ac.a;

final class ExdeviceProfileUI$19
  implements ac.a
{
  ExdeviceProfileUI$19(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void Lw(String paramString)
  {
    AppMethodBeat.i(20043);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
    localIntent.putExtra("Ksnsupload_appname", this.lOl.getString(2131299490));
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("need_result", true);
    String str = v.oQ("wx_sport");
    v.aae().z(str, true).i("prePublishId", "wx_sport");
    localIntent.putExtra("reportSessionId", str);
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", paramString);
    d.b(this.lOl, "sns", ".ui.SnsUploadUI", localIntent, 2);
    AppMethodBeat.o(20043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.19
 * JD-Core Version:    0.7.0.1
 */