package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URL;
import org.json.JSONObject;

final class CleanNewUI$4$1
  implements DialogInterface.OnClickListener
{
  CleanNewUI$4$1(CleanNewUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18914);
    try
    {
      paramDialogInterface = new URL(CleanNewUI.d(this.kJt.kJs).getString("url"));
      String str = CleanNewUI.d(this.kJt.kJs).getString("md5");
      ab.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[] { paramDialogInterface, str });
      g.a locala = new g.a();
      locala.JL("wesecure.apk");
      locala.JJ(paramDialogInterface.toString());
      locala.gr(true);
      locala.JM(str);
      locala.tV(1);
      f.bjl().a(locala.kYR);
      h.qsU.idkeyStat(282L, 7L, 1L, false);
      AppMethodBeat.o(18914);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CleanNewUI", paramDialogInterface, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanNewUI.4.1
 * JD-Core Version:    0.7.0.1
 */