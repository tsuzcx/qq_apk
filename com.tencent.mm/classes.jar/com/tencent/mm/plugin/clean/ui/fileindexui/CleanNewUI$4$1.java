package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URL;
import org.json.JSONObject;

final class CleanNewUI$4$1
  implements DialogInterface.OnClickListener
{
  CleanNewUI$4$1(CleanNewUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new URL(CleanNewUI.e(this.iDS.iDR).getString("url"));
      String str = CleanNewUI.e(this.iDS.iDR).getString("md5");
      y.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[] { paramDialogInterface, str });
      e.a locala = new e.a();
      locala.zP("wesecure.apk");
      locala.zN(paramDialogInterface.toString());
      locala.eO(true);
      locala.zQ(str);
      locala.pE(1);
      d.aFP().a(locala.iPG);
      h.nFQ.a(714L, 4L, 1L, false);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.CleanNewUI", paramDialogInterface, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.4.1
 * JD-Core Version:    0.7.0.1
 */