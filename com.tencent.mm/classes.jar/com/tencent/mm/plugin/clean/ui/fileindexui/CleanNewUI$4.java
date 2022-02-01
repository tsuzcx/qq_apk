package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URL;
import org.json.JSONObject;

final class CleanNewUI$4
  implements View.OnClickListener
{
  CleanNewUI$4(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22925);
    ac.i("MicroMsg.CleanNewUI", "qq mgr btn click");
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 3L, 1L, false);
    if (!CleanNewUI.d(this.osr))
    {
      if (CleanNewUI.e(this.osr))
      {
        com.tencent.mm.ui.base.h.d(this.osr, this.osr.getString(2131757389, new Object[] { bs.An(CleanNewUI.f(this.osr)) }), "", this.osr.getString(2131755714), this.osr.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(22924);
            try
            {
              paramAnonymousDialogInterface = new URL(CleanNewUI.g(CleanNewUI.4.this.osr).getString("url"));
              String str = CleanNewUI.g(CleanNewUI.4.this.osr).getString("md5");
              ac.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[] { paramAnonymousDialogInterface, str });
              g.a locala = new g.a();
              locala.WF("wesecure.apk");
              locala.WD(paramAnonymousDialogInterface.toString());
              locala.jF(true);
              locala.WG(str);
              locala.AG(1);
              f.bXJ().a(locala.oJg);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 4L, 1L, false);
              AppMethodBeat.o(22924);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.CleanNewUI", paramAnonymousDialogInterface, "", new Object[0]);
              }
            }
          }
        }, null);
        AppMethodBeat.o(22925);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
      paramView.putExtra("show_bottom", false);
      paramView.putExtra("showShare", false);
      d.b(this.osr.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 5L, 1L, false);
    }
    AppMethodBeat.o(22925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.4
 * JD-Core Version:    0.7.0.1
 */